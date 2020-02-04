package com.mdababi.concurrence.challenge1;

public class BankAccount {
	private double balance;
	private String accountNumber;

	public BankAccount(double balance, String accountNumber) {
		super();
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	public void deposit(double amount) {
		balance += amount;
		
	}
	
	public void withdraw(double amount) {
		balance -= amount;
		
	}
	
	

}
