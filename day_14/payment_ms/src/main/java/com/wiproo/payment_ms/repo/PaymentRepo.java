package com.wiproo.payment_ms.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiproo.payment_ms.entity.*;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {
	Payment findByOrderId(int orderId);

}