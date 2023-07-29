package py.com.daas.adamspayintegration.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import py.com.daas.adamspayintegration.clients.AdamsPayClient;
import py.com.daas.adamspayintegration.model.DebtsBody;
import py.com.daas.adamspayintegration.model.DebtsResponse;

@Service
public class PaymentServiceImpl {

    private final String apiKey;
    private final AdamsPayClient adamsPayClient;

    public PaymentServiceImpl(@Value("${adamspay.apikey}") String apiKey, AdamsPayClient adamsPayClient) {
        this.apiKey = apiKey;
        this.adamsPayClient = adamsPayClient;
    }

    public DebtsResponse createDebt(DebtsBody debtsBody) {
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
