package com.wiproo.order_ms.service;
import java.util.List;

import com.wiproo.order_ms.dto.*;
import com.wiproo.order_ms.entity.*;



public interface OrderService {

	void save(Order order);
	//List<Order> findAll();
	List<OrderResponse> findAll();
}