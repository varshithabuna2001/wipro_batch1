package com.wiproo.payment.controller;

import com.wiproo.payment.entity.*;
import com.wiproo.payment.service.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

   
    @PostMapping
    public ResponseEntity<Payment> create(@Valid @RequestBody Payment payment) {
        Payment saved = service.create(payment);
        return ResponseEntity.created(URI.create("/api/payments/" + saved.getId())).body(saved);
    }

   
    @GetMapping
    public List<Payment> all() {
        return service.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @GetMapping("/by-payment-id/{paymentId}")
    public ResponseEntity<Payment> getByPaymentId(@PathVariable String paymentId) {
        return service.findByPaymentId(paymentId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@PathVariable Long id, @Valid @RequestBody Payment payment) {
        try {
            Payment updated = service.update(id, payment);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
