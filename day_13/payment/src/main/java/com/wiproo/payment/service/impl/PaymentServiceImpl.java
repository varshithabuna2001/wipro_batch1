package com.wiproo.payment.service.impl;

import com.wiproo.payment.entity.*;
import com.wiproo.payment.repository.*;
import com.wiproo.payment.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repo;

    public PaymentServiceImpl(PaymentRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Payment create(Payment payment) {
        if (payment.getPaymentId() == null || payment.getPaymentId().isBlank()) {
            throw new IllegalArgumentException("paymentId is required");
        }
        if (repo.existsByPaymentId(payment.getPaymentId())) {
            throw new IllegalArgumentException("paymentId already exists: " + payment.getPaymentId());
        }
        return repo.save(payment);
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Payment> findByPaymentId(String paymentId) {
        return repo.findByPaymentId(paymentId);
    }

    @Override
    public List<Payment> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public Payment update(Long id, Payment payment) {
        Payment existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));

        
        if (payment.getPaymentId() != null && !payment.getPaymentId().equals(existing.getPaymentId())) {
            if (repo.existsByPaymentId(payment.getPaymentId())) {
                throw new IllegalArgumentException("paymentId already exists: " + payment.getPaymentId());
            }
            existing.setPaymentId(payment.getPaymentId());
        }

        if (payment.getPaymentMode() != null) existing.setPaymentMode(payment.getPaymentMode());
        if (payment.getAmount() != null) existing.setAmount(payment.getAmount());
        existing.setDescription(payment.getDescription());

        return repo.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Payment not found with id " + id);
        }
        repo.deleteById(id);
    }
}
