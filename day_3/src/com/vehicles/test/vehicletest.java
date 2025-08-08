package com.vehicles.test;

import com.vehicles.car;
import com.vehicles.vehicle;

public class vehicletest {
	public static void main(String[] args) {
		car cars = new car(5,"petrol","white");		
		System.out.println(cars);
		
	}

	@Override
	public String toString() {
		return "vehicletest [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}

