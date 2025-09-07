package com.wiproo.payment.service;

import com.wiproo.payment.entity.*;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment create(Payment payment);
    Optional<Payment> findById(Long id);
    Optional<Payment> findByPaymentId(String paymentId);
    List<Payment> findAll();
    Payment update(Long id, Payment payment);
    void delete(Long id);
}
