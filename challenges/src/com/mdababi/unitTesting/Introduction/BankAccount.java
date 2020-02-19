package com.mdababi.unitTesting.Introduction;

public class BankAccount {
	private String firstName;
	private String lastName;
	private double balance;

	public BankAccount(String firstName, String lastName, double balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}

	// the branche argumenet is true if the client is performing the transaction at
	// a branch with a teller
	// the branch argument is false if the client is performung the transaction with
	// ATM
	public double deposit(double amount, boolean branch) {
		balance += amount;
		return balance;
	}

	public double withdraw(double amount, boolean branch) {
		balance -= amount;
		return balance;
	}

	public double getBalance() {
		return balance;
	}

}
