package com.vladproduction.springtransactions.controllers;

import com.vladproduction.springtransactions.models.Payment;
import com.vladproduction.springtransactions.models.Sale;
import com.vladproduction.springtransactions.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 08-Apr-24
 */

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/save")
    public Payment savePayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @GetMapping("/{id}")
    public Optional<Payment> findPaymentById(@PathVariable Long id) {
        return paymentService.findPaymentById(id);
    }

    @GetMapping("/all")
    public List<Payment> findAllPayments() {
        return paymentService.findAllPayments();
    }

    @PatchMapping("/{id}/update")
    public int updatePaymentById(@PathVariable Long id, @RequestBody Payment payment) {
        return paymentService.updatePaymentById(id, payment);
    }

    @DeleteMapping("/{id}/delete")
    public int deletePaymentById(@PathVariable Long id) {
        return paymentService.deletePaymentById(id);
    }

}
