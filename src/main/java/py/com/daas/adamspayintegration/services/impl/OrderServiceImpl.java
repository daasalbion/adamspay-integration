package py.com.daas.adamspayintegration.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.daas.adamspayintegration.clients.model.DebtsResponse;
import py.com.daas.adamspayintegration.clients.model.TObjStatus.StatusEnum;
import py.com.daas.adamspayintegration.entities.OrderMain;
import py.com.daas.adamspayintegration.entities.ProductInOrder;
import py.com.daas.adamspayintegration.entities.ProductInfo;
import py.com.daas.adamspayintegration.enums.OrderStatusEnum;
import py.com.daas.adamspayintegration.enums.ResultEnum;
import py.com.daas.adamspayintegration.exception.MyException;
import py.com.daas.adamspayintegration.repositories.OrderRepository;
import py.com.daas.adamspayintegration.repositories.ProductInOrderRepository;
import py.com.daas.adamspayintegration.repositories.ProductInfoRepository;
import py.com.daas.adamspayintegration.repositories.UserRepository;
import py.com.daas.adamspayintegration.services.OrderService;
import py.com.daas.adamspayintegration.services.PaymentService;
import py.com.daas.adamspayintegration.services.ProductService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductInfoRepository productInfoRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ProductInOrderRepository productInOrderRepository;
    @Autowired
    PaymentService paymentService;

    @Override
    public Page<OrderMain> findAll(Pageable pageable) {
        return orderRepository.findAllByOrderByOrderStatusAscCreateTimeDesc(pageable);
    }

    @Override
    public Page<OrderMain> findByStatus(Integer status, Pageable pageable) {
        return orderRepository.findAllByOrderStatusOrderByCreateTimeDesc(status, pageable);
    }

    @Override
    public Page<OrderMain> findByBuyerEmail(String email, Pageable pageable) {
        return orderRepository.findAllByBuyerEmailOrderByOrderStatusAscCreateTimeDesc(email, pageable);
    }

    @Override
    public Page<OrderMain> findByBuyerPhone(String phone, Pageable pageable) {
        return orderRepository.findAllByBuyerPhoneOrderByOrderStatusAscCreateTimeDesc(phone, pageable);
    }

    @Override
    public OrderMain findOne(Long orderId) {
        OrderMain orderMain = orderRepository.findByOrderId(orderId);
        if (orderMain == null) {
            throw new MyException(ResultEnum.ORDER_NOT_FOUND);
        }
        return orderMain;
    }

    @Override
    @Transactional
    public OrderMain finish(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        if (!orderMain.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new MyException(ResultEnum.ORDER_STATUS_ERROR);
        }
        DebtsResponse debtsResponse = paymentService.getDebt(String.valueOf(orderId));
        // if was confirmed by the provider
        StatusEnum status = debtsResponse.getDebt().getObjStatus().getStatus();

        switch (status) {
            case SUCCESS -> {
                orderMain.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
                orderRepository.save(orderMain);
                paymentService.updateTransaction(debtsResponse);
            }
            case ACTIVE -> {
                System.out.println("Still pending");
            }
            default -> {
                orderMain.setOrderStatus(OrderStatusEnum.CANCELED.getCode());
                restoreStock(orderMain);
                orderRepository.save(orderMain);
                paymentService.updateTransaction(debtsResponse);
            }
        }

        return orderRepository.findByOrderId(orderId);
    }

    @Override
    @Transactional
    public OrderMain cancel(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        if (!orderMain.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new MyException(ResultEnum.ORDER_STATUS_ERROR);
        }

        orderMain.setOrderStatus(OrderStatusEnum.CANCELED.getCode());
        orderRepository.save(orderMain);

        paymentService.deleteDebt(String.valueOf(orderId));

        // Restore Stock
        restoreStock(orderMain);

        return orderRepository.findByOrderId(orderId);
    }

    private void restoreStock(OrderMain orderMain) {
        Iterable<ProductInOrder> products = orderMain.getProducts();
        for (ProductInOrder productInOrder : products) {
            ProductInfo productInfo = productInfoRepository.findByProductId(productInOrder.getProductId());
            if (productInfo != null) {
                productService.increaseStock(productInOrder.getProductId(), productInOrder.getCount());
            }
        }
    }
}
