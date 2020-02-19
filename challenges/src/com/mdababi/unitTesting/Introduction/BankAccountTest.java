package com.mdababi.unitTesting.Introduction;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTest {

	@Test
	public void testDeposit() {
		BankAccount account = new BankAccount("dababi", "mohamed", 1000.00);
		double balance = account.deposit(200.00, true);
		assertEquals(1200.00, balance, 0);
		assertEquals(1200.00, account.getBalance(), 0);
	}

	@Test
	public void testWithdraw() {
		fail("Not yet implemented withdraw");
	}

	@Test
	public void testGetBalance() {
		fail("Not yet implemented");
	}
	

}
