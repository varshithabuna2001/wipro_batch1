package com.exception.test;

import com.exception.Invalidvoter;

public class exceptiontest {

	public static void main(String[] args) {
		try {
			checkVotingAge(15);
		}
		catch (Invalidvoter e) {
			e.printStackTrace();
		}
	}
	static void checkVotingAge (int age) throws Invalidvoter
	{
		if (age<18)
		{
			throw new Invalidvoter("invald vote");
		}
		else
		{
		System.out.println("Eligible to vote");
		}
	}
}