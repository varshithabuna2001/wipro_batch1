package com.wiproo.Mobile.dto;
public class Mobile {
    private String make;
    private String modelNumber;
    private double price;

    
    public Mobile() {}

    public Mobile(String make, String modelNumber, double price) {
        this.make = make;
        this.modelNumber = modelNumber;
        this.price = price;
    }

   
    public Mobile(Integer id, String make2, String modelNumber2, double price2) {
		// TODO Auto-generated constructor stub
	}

	public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    public String getModelNumber() {
        return modelNumber;
    }
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    
    public String toString() {
        return "Mobile [make=" + make + ", modelNumber=" + modelNumber + ", price=" + price + "]";
    }

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
}