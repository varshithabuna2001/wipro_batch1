package com.wiproo.order_ms.dto;
import com.wiproo.order_ms.entity.*;

import lombok.Data;

@Data
public class OrderResponse {
	private Order order;
	private Payment payment;
	public void setOrder(Order order2) {
		// TODO Auto-generated method stub
		
	}
	 public void setPayment(Payment payment2) {
		// TODO Auto-generated method stub
		
	}

}