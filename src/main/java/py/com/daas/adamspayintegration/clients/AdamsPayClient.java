package py.com.daas.adamspayintegration.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import py.com.daas.adamspayintegration.clients.model.DebtsBody;
import py.com.daas.adamspayintegration.clients.model.DebtsResponse;

@FeignClient(name = "adamspay", url = "https://staging.adamspay.com/api/v1")
public interface AdamsPayClient {

    @PostMapping("/debts")
    DebtsResponse createDebt(@RequestHeader("apiKey") String apiKey, DebtsBody debt);

    @GetMapping("/debts/{docId}")
    DebtsResponse getDebt(@RequestHeader("apiKey") String apiKey, @PathVariable("docId") String docId);

    @PutMapping("/debts/{docId}")
    DebtsResponse updateDebt( @RequestHeader("apiKey") String apiKey, @PathVariable("docId") String docId,
            DebtsBody debtRequest);

    @DeleteMapping("/debts/{docId}")
    DebtsResponse deleteDebt(@RequestHeader("apiKey") String apiKey, @PathVariable("docId") String docId);

}
