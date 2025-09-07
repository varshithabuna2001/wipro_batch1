package com.wiproo.order_ms.controller;
import com.wiproo.order_ms.dto.*;
import com.wiproo.order_ms.entity.*;
import com.wiproo.order_ms.service.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	void save(@RequestBody Order order)
	{
		
		orderService.save(order);
		
		
	}

//	@GetMapping
//	List<Order> findAll()
//	{
//		return orderService.findAll();
//	}
	
	@GetMapping
	List<OrderResponse> findAll(){
		System.out.println("findall controller");
		return orderService.findAll();
	}
	
}