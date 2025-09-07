package com.wiproo.order_ms.dto;
import lombok.Data;

@Data
public class Payment {
    private int id;
    private int orderId;
    private boolean paymentStatus;
    private double paymentAmount;
	public void setPaymentStatus(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void setPaymentAmount(Object orderValue) {
		// TODO Auto-generated method stub
		
	}
	public void setOrderId(Object id2) {
		// TODO Auto-generated method stub
		
	}
}