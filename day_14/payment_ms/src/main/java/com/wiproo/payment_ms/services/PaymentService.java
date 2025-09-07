package com.wiproo.payment_ms.services;
import java.util.List;

import com.wiproo.payment_ms.entity.*;

 

public interface PaymentService {

	void save(Payment order);
	List<Payment> findAll();
	Payment findByOrderId(int orderId);
}