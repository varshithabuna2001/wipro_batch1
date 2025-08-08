package com.wipro.classes;

public class order {
	String orderid;
	double price;
	int noitems;
	
	public order(String orderid, double price, int noitems) {
		super();
		this.orderid = orderid;
		this.price = price;
		this.noitems = noitems;
	}
	
	public String toString()
	{
		return "orderid :" +orderid+ ", price :" +price+ ",noitems :"+noitems;
	}
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNoitems() {
		return noitems;
	}
	public void setNoitems(int noitems) {
		this.noitems = noitems;
	}
	 

}
