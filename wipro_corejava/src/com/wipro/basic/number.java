package com.wipro.basic;

public class number {
 public static void main(String[] args) {
	float num=-0.025f;
	if (num==0)
	{
		System.out.println("zero");
	}
	else if(num > 0)
	{
		System.out.println("positive");
	}
		else {
			System.out.println("negitive");
		}
	
	 if(Math.abs(num)<0) {
		System.out.println("small");
	}
	else if(Math.abs(num)>10000)
	{
		System.out.println("large");
	}
}
}
