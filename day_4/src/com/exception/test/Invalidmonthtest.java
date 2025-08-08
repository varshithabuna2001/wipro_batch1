package com.exception.test;

import com.exception.Invalidmonth;

public class Invalidmonthtest {
	public static void main(String[] args) {
		try {
			checkMonth(7);
		}
		catch (Invalidmonth e){
			e.printStackTrace();
		}
	}

static void checkMonth(int month) throws Invalidmonth
{
	if (month>12)
	{
		throw new Invalidmonth("Invalid month");
	 }
	else
	{
		System.out.println("valid month");
	}
}
	  
}
