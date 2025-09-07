package com.wiproo.payment_ms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wiproo.payment_ms.entity.*;
 
import com.wiproo.payment_ms.services.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping
	void save(@RequestBody Payment payment)
	{
		paymentService.save(payment);
	}

	@GetMapping
	List<Payment> findAll()
	{
		return paymentService.findAll();
	}
	@GetMapping("/order/{id}")
	public Payment findByOrderId(@PathVariable int id) {
	    return paymentService.findByOrderId(id);
	}
}