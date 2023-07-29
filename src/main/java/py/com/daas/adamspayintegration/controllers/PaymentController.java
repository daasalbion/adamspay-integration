package py.com.daas.adamspayintegration.controllers;

import java.time.OffsetDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.daas.adamspayintegration.model.DebtsBody;
import py.com.daas.adamspayintegration.model.DebtsDebt;
import py.com.daas.adamspayintegration.model.DebtsResponse;
import py.com.daas.adamspayintegration.model.TAmount;
import py.com.daas.adamspayintegration.model.TDatePeriod;
import py.com.daas.adamspayintegration.services.PaymentServiceImpl;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public DebtsResponse createDeb(@RequestBody DebtsBody debtsBodyRequest) {
        DebtsDebt debt = new DebtsDebt();
        DebtsBody debtsBody = new DebtsBody();
        // docId
        debt.setDocId("test002");
        // amount
        TAmount amount = new TAmount();
        amount.setCurrency("PYG");
        amount.setValue("5000");
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

        return paymentService.createDebt(debtsBody);
    }

    @GetMapping("/{id}")
    public DebtsResponse getDebtStatus(@PathVariable("id") Long id) {
        return paymentService.getDebt("test001");
    }
}
