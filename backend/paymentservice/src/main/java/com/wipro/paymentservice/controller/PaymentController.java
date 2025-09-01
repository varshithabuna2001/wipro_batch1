package com.wipro.paymentservice.controller;

import com.wipro.paymentservice.model.Payment;
import com.wipro.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository repo;

    @PostMapping
    public Payment makePayment(@RequestBody Payment payment) {
        payment.setStatus("SUCCESS");
        return repo.save(payment);
    }

    @GetMapping
    public List<Payment> all() {
        return repo.findAll();
    }
}
