package py.com.daas.adamspayintegration.services.impl;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.daas.adamspayintegration.clients.AdamsPayClient;
import py.com.daas.adamspayintegration.clients.model.DebtsBody;
import py.com.daas.adamspayintegration.clients.model.DebtsDebt;
import py.com.daas.adamspayintegration.clients.model.DebtsResponse;
import py.com.daas.adamspayintegration.clients.model.TAmount;
import py.com.daas.adamspayintegration.clients.model.TDatePeriod;
import py.com.daas.adamspayintegration.clients.model.TDebtDoc;
import py.com.daas.adamspayintegration.entities.OrderMain;
import py.com.daas.adamspayintegration.entities.Transaction;
import py.com.daas.adamspayintegration.repositories.OrderRepository;
import py.com.daas.adamspayintegration.repositories.TransactionRepository;
import py.com.daas.adamspayintegration.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final String apiKey;
    private final AdamsPayClient adamsPayClient;
    private final TransactionRepository transactionRepository;
    private final OrderRepository orderRepository;

    public PaymentServiceImpl(@Value("${adamspay.apikey}") String apiKey, AdamsPayClient adamsPayClient,
            TransactionRepository transactionRepository, OrderRepository orderRepository) {
        this.apiKey = apiKey;
        this.adamsPayClient = adamsPayClient;
        this.transactionRepository = transactionRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Transaction create(OrderMain order) {
        DebtsDebt debt = new DebtsDebt();
        DebtsBody debtsBody = new DebtsBody();
        // docId
        debt.setDocId(order.getOrderId().toString());
        // amount
        TAmount amount = new TAmount();
        amount.setCurrency("PYG");
        amount.setValue(order.getOrderAmount().toString());
        debt.setAmount(amount);
        // label
        debt.setLabel("implementation");
        // validPeriod
        TDatePeriod datePeriod = new TDatePeriod();
        datePeriod.setStart(OffsetDateTime.now());
        datePeriod.setEnd(OffsetDateTime.now().plusDays(1));
        debt.setValidPeriod(datePeriod);
        // debt
        debtsBody.setDebt(debt);

        DebtsResponse debtsResponse = createDebt(debtsBody);

        Transaction transaction = new Transaction();
        transaction.setOrder(order);
        transaction.setPayStatus(debtsResponse.getDebt().getPayStatus().getStatus().toString());
        transaction.setPayUrl(debtsResponse.getDebt().getPayUrl());
        transaction.setObjStatus(debtsResponse.getDebt().getObjStatus().getStatus().toString());
        transaction.setOrderAmount(order.getOrderAmount());

        return transactionRepository.save(transaction);
    }

    @Override
    public DebtsResponse createDebt(DebtsBody debtsBodyRequest) {
        DebtsDebt debt = new DebtsDebt();
        DebtsBody debtsBody = new DebtsBody();
        // docId
        debt.setDocId(debtsBodyRequest.getDebt().getDocId());
        // amount
        TAmount amount = new TAmount();
        amount.setCurrency(debtsBodyRequest.getDebt().getAmount().getCurrency());
        amount.setValue(debtsBodyRequest.getDebt().getAmount().getValue());
        debt.setAmount(amount);
        // label
        debt.setLabel("implementation");
        // validPeriod
        TDatePeriod datePeriod = new TDatePeriod();
        datePeriod.setStart(OffsetDateTime.now());
        datePeriod.setEnd(OffsetDateTime.now().plusDays(1));
        debt.setValidPeriod(datePeriod);
        // debt
        debtsBody.setDebt(debt);

        return adamsPayClient.createDebt(apiKey, debtsBody);
    }

    @Override
    public DebtsResponse getDebt(String id) {
        return adamsPayClient.getDebt(apiKey, id);
    }

    @Override
    public DebtsResponse updateDebt(String id, DebtsBody debtsBody) {
        return adamsPayClient.updateDebt(apiKey, id, debtsBody);
    }

    @Override
    public DebtsResponse deleteDebt(String id) {
        DebtsResponse debtsResponse = adamsPayClient.deleteDebt(apiKey, id);
        updateTransaction(debtsResponse);
        return debtsResponse;
    }

    @Override
    public void handleWebhook(DebtsResponse debtsResponse) {
        updateTransaction(debtsResponse);
    }

    public void updateTransaction(DebtsResponse debtsResponse) {
        TDebtDoc debtsBody = debtsResponse.getDebt();
        OrderMain order = orderRepository.findByOrderId(Long.valueOf(debtsBody.getDocId()));
        Transaction transaction = transactionRepository.findByOrder(order);
        transaction.setPayStatus(debtsBody.getPayStatus().getStatus().toString());
        transaction.setObjStatus(debtsBody.getObjStatus().getStatus().toString());

        transactionRepository.save(transaction);
    }

}
