package com.wiproo.order_ms.entity;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="order_data")
@Data
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="order_number")
	String orderNumber;
	
	@Column(name="order_value")
	double orderValue;
	
	@Column(name="order_status")
	String orderStatus;

	public void setOrderStatus(String string) {
		// TODO Auto-generated method stub
		
	}

	public Object getOrderValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

}