package py.com.daas.adamspayintegration.services;

import py.com.daas.adamspayintegration.clients.model.DebtsBody;
import py.com.daas.adamspayintegration.clients.model.DebtsResponse;
import py.com.daas.adamspayintegration.entities.OrderMain;
import py.com.daas.adamspayintegration.entities.Transaction;

public interface PaymentService {

    Transaction create(OrderMain debtsBodyRequest);
    DebtsResponse createDebt(DebtsBody debtsBodyRequest);
    DebtsResponse getDebt(String id);
    DebtsResponse updateDebt(String id, DebtsBody debtsBody);
    DebtsResponse deleteDebt(String id);
    void handleWebhook(DebtsResponse debtsBody);
    void updateTransaction(DebtsResponse debtsResponse);

}
