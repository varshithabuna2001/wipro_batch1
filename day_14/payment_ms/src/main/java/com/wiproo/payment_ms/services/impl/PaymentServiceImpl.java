package com.wiproo.payment_ms.services.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiproo.payment_ms.entity.*;
import com.wiproo.payment_ms.repo.*;
import com.wiproo.payment_ms.services.*;

 
@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepo paymentRepo;
	
	@Override
	public void save(Payment payment) {
		 
		paymentRepo.save(payment);
	}

	@Override
	public List<Payment> findAll() {
		 
		return paymentRepo.findAll();
	}
	@Override
	public Payment findByOrderId(int orderId) {
	    return paymentRepo.findByOrderId(orderId);
	}

}