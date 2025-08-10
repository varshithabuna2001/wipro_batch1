package com.wipro.anonymous;

public class Bankaccount {
	public static void main(String[] args) {
		
		BankOps savingaccount = new BankOps() {
		 public void deposit(double amount)
		 {
			System.out.println("savings amount :" +amount); 
		 }
		};
		 
		 BankOps currentaccount = new BankOps() {
			 public void deposit(double amount)
			 {
				System.out.println("current amount :" +amount); 
			 }
		 };
			 savingaccount.deposit(100000);
			 currentaccount.deposit(120000);
			  }	 
		}

	
