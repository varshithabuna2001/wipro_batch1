package com.wipro.anonymous;

public class greet_lambda {
	public static void main(String[] args) {
		greet g =()->System.out.println("Hello lambda");
	g.sayHello();
}
}