package com.mdababi.unitTesting.junit;

public class BankAccount {
	private String firstName;
	private String lastName;
	private double balance;
	private int accountType;

	public static final int CHECKING = 2;
	public static final int SAVING = 2;

	public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.accountType = typeOfAccount;
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
		if(amount > 500 && !branch)
			throw new IllegalArgumentException();
		balance -= amount;
		return balance;
	}

	public double getBalance() {
		return balance;
	}

	public boolean isCheching() {
		return accountType == CHECKING;
	}

}
