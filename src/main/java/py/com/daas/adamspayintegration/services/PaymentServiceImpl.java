package py.com.daas.adamspayintegration.services;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import py.com.daas.adamspayintegration.clients.AdamsPayClient;
import py.com.daas.adamspayintegration.model.DebtsBody;
import py.com.daas.adamspayintegration.model.DebtsDebt;
import py.com.daas.adamspayintegration.model.DebtsResponse;
import py.com.daas.adamspayintegration.model.TAmount;
import py.com.daas.adamspayintegration.model.TDatePeriod;

@Service
public class PaymentServiceImpl {

    private final String apiKey;
    private final AdamsPayClient adamsPayClient;

    public PaymentServiceImpl(@Value("${adamspay.apikey}") String apiKey, AdamsPayClient adamsPayClient) {
        this.apiKey = apiKey;
        this.adamsPayClient = adamsPayClient;
    }

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

    public DebtsResponse getDebt(String id) {
        return adamsPayClient.getDebt(apiKey, id);
    }

    public DebtsResponse updateDebt(String id, DebtsBody debtsBody) {
        return adamsPayClient.updateDebt(apiKey, id, debtsBody);
    }

    public DebtsResponse deleteDebt(String id) {
        return adamsPayClient.deleteDebt(apiKey, id);
    }

}
