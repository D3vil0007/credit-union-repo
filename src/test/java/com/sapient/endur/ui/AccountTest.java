package com.sapient.endur.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sapient.endur.model.Account;
import com.sapient.endur.model.AccountType;
import com.sapient.endur.model.ConsumerAccount;

class AccountTest {
   private static Account account=null;
	@BeforeAll
	static void initilaize() {
		account= new ConsumerAccount(675876876L,AccountType.MONEY_MARKET,"Smith",LocalDate.of(2010, 9, 1),350000.0);
	}
	
	@AfterAll
	static void cleanup() {
		account=null;
	}
	
	@Test
	void testValidGetOwnerName() {
		assertEquals("Steve Smith",account.getOwnerName());
	}
	
	@Test
	void testInvalidGetOwnerName() {
		assertNotEquals("Clarke",account.getOwnerName());
	}

	@Test
	void testSetOwnerName() {
		account.setOwnerName("Steve Smith");
		assertEquals("Steve Smith", account.getOwnerName());
	}

	@Test
	void testGetBalance() {
		assertEquals(350000.0,account.getBalance());
	}

	@Test
	void testSetBalance() {
		account.setBalance(account.getBalance()+100000.0);
		assertEquals(450000.0, account.getBalance());
	}

}

