package py.com.daas.adamspayintegration.services.impl;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.daas.adamspayintegration.entities.Cart;
import py.com.daas.adamspayintegration.entities.OrderMain;
import py.com.daas.adamspayintegration.entities.ProductInOrder;
import py.com.daas.adamspayintegration.entities.User;
import py.com.daas.adamspayintegration.enums.ResultEnum;
import py.com.daas.adamspayintegration.exception.MyException;
import py.com.daas.adamspayintegration.repositories.CartRepository;
import py.com.daas.adamspayintegration.repositories.OrderRepository;
import py.com.daas.adamspayintegration.repositories.ProductInOrderRepository;
import py.com.daas.adamspayintegration.repositories.UserRepository;
import py.com.daas.adamspayintegration.services.CartService;
import py.com.daas.adamspayintegration.services.ProductService;
import py.com.daas.adamspayintegration.services.UserService;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    ProductService productService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductInOrderRepository productInOrderRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserService userService;

    @Override
    public Cart getCart(User user) {
        return user.getCart();
    }

    @Override
    @Transactional
    public void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user) {
        Cart finalCart = user.getCart();
        productInOrders.forEach(productInOrder -> {
            Set<ProductInOrder> set = finalCart.getProducts();
            Optional<ProductInOrder> old = set.stream().filter(e -> e.getProductId().equals(productInOrder.getProductId())).findFirst();
            ProductInOrder prod;
            if (old.isPresent()) {
                prod = old.get();
                prod.setCount(productInOrder.getCount() + prod.getCount());
            } else {
                prod = productInOrder;
                prod.setCart(finalCart);
                finalCart.getProducts().add(prod);
            }
            productInOrderRepository.save(prod);
        });
        cartRepository.save(finalCart);

    }

    @Override
    @Transactional
    public void delete(String itemId, User user) {
        if(itemId.equals("") || user == null) {
            throw new MyException(ResultEnum.ORDER_STATUS_ERROR);
        }

        var op = user.getCart().getProducts().stream().filter(e -> itemId.equals(e.getProductId())).findFirst();
        op.ifPresent(productInOrder -> {
            productInOrder.setCart(null);
            productInOrderRepository.deleteById(productInOrder.getId());
        });
    }

    @Override
    @Transactional
    public void checkout(User user) {
        // Creat an order
        OrderMain order = new OrderMain(user);
        orderRepository.save(order);

        // clear cart's foreign key & set order's foreign key& decrease stock
        user.getCart().getProducts().forEach(productInOrder -> {
            productInOrder.setCart(null);
            productInOrder.setOrderMain(order);
            productService.decreaseStock(productInOrder.getProductId(), productInOrder.getCount());
            productInOrderRepository.save(productInOrder);
        });

    }
}
