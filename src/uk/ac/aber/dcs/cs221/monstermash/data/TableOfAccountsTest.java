package uk.ac.aber.dcs.cs221.monstermash.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TableOfAccountsTest {
	
	static TableOfAccounts accounts;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		accounts = new TableOfAccounts();
		accounts.addUser("barry@hotmail.com").setPassword("spider");
		accounts.addUser("colin@gmail.com").setPassword("roflcopter");
		accounts.addUser("locked@yahoo.co.uk");
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckPassword() {
		assertTrue(accounts.lookup("barry@hotmail.com").checkPassword("spider"));
		
	}
	@Test
	public void testLockedAccount() {
		assertFalse(accounts.lookup("locked@yahoo.co.uk").checkPassword(""));
	}
	@Test
	public void testChangeEmail() {
		accounts.addUser("testChangeEmail@test.com").setEmail("testChangedEmail2@test.com");
		assertTrue(accounts.lookup("testChangedEmail2@test.com") != null);
	}

}
