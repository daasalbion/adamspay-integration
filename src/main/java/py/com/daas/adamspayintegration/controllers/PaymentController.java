package py.com.daas.adamspayintegration.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.daas.adamspayintegration.clients.model.DebtsBody;
import py.com.daas.adamspayintegration.clients.model.DebtsResponse;
import py.com.daas.adamspayintegration.services.impl.PaymentServiceImpl;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public DebtsResponse createDeb(@RequestBody DebtsBody debtsBody) {
        return paymentService.createDebt(debtsBody);
    }

    @GetMapping("/{id}")
    public DebtsResponse getDebt(@PathVariable("id") String id) {
        return paymentService.getDebt(id);
    }

    @PutMapping("/{id}")
    public DebtsResponse updateDebt(@PathVariable("id") String id, @RequestBody DebtsBody debtsBodyRequest) {
        return paymentService.updateDebt(id, debtsBodyRequest);
    }

    @DeleteMapping("/{id}")
    public DebtsResponse deleteDebt(@PathVariable("id") String id) {
        return paymentService.deleteDebt(id);
    }

    @PostMapping("/webhook")
    public void receiveWebhook(@RequestBody DebtsResponse debtsBodyRequest) {
        //process the webhook payload
        paymentService.handleWebhook(debtsBodyRequest);
    }

}
