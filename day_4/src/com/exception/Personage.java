package com.exception;

import java.time.LocalDateTime;
public class Personage {
	static int years=1950;
	static int age;
	public static void main(String[] args) {
		LocalDateTime dtm1=LocalDateTime.now();
		difference(dtm1,years);
		System.out.println(age);

	}
	private static void difference(LocalDateTime dtm1, int years2) {
		// TODO Auto-generated method stub
		age = dtm1.getYear() - years; 
	}

}
