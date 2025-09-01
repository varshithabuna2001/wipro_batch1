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
    private PaymentRepository paymentRepository;

    @PostMapping
    public String makePayment(@RequestBody Payment payment) {
        // Simulate success
        payment.setStatus("SUCCESS");
        paymentRepository.save(payment);
        return "Payment successful for bookingId: " + payment.getBookingId();
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
