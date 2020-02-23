package com.mdababi.unitTesting.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
	private BankAccount account;
	
	@Before
	public void setup() {
		account = new BankAccount("dababi", "mohamed", 1000.00, BankAccount.CHECKING);
		//System.out.println("running a test ...");
	}

	@Test
	public void testDeposit() {
		double balance = account.deposit(200.00, true);
		assertEquals(1200.00, balance, 0);
	}

	@Test
	public void testWithdraw_branch() {
		double balance = account.withdraw(600.00, true);
		assertEquals(400.00, balance, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWithdraw_notBranch() {
		account.withdraw(600.00, false);
	}

	@Test
	public void testGetBalance_deposit() {
		double balance = account.deposit(200.00, true);
		assertEquals(1200.00, account.getBalance(), 0);
	}

	@Test
	public void testGetBalance_withdraw() {
		double balance = account.withdraw(200.00, true);
		assertEquals(800.00, account.getBalance(), 0);
	}

	@Test
	public void isChecking_true() {
		assertTrue(account.isCheching());
	}

}
