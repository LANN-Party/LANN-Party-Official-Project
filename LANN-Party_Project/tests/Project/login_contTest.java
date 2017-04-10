package Project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class login_contTest {
	private login_cont lc;
	private Admin_Controler ac;
	
	@Before
	public void setUp() throws Exception {
		lc = new login_cont();
		ac = new Admin_Controler();
	}

	@After
	public void tearDown() {
		ac.deleteUser("bKid");
		ac.deleteUser("jChristo");
	}
	/*
	 * basic testing
	 * description: testing login with valid args and invalid
	 */
	@Test
	public void testlogon() {
		assertTrue(lc.logon("ajmac", "password", true));
		assertFalse(lc.logon("oops", "oops", true));
	}
	/*
	 * basic testing
	 * description: registering a student 
	 * with valid and invalid args
	 */
	@Test
	public void testregisterStudent() {
		assertTrue(lc.registerStudent("Billy", "TheKid", "bKid", "pword", 'u', 'Y'));
	assertFalse(lc.registerStudent("Billy", "TheKid", "bKid", "pword", 'x', 'Y'));	
	assertFalse(lc.registerStudent("Billy", "TheKid", "bKid", "pword", 'u', 'x'));	

	}
	/*
	 * basic testing
	 * description: testing registering an admin with valid
	 * and invalid args
	 */
	@Test
	public void testregisterAdmin() {
		assertTrue(lc.registerAdmin("Jesus", "Christ", "jChristo", "pword", 'a', 'Y'));
		assertFalse(lc.registerAdmin("Jesus", "Christ", "jChristo", "pword", 'x', 'Y'));	
		assertFalse(lc.registerAdmin("Jesus", "Christ", "jChristo", "pword", 'a', 'x'));	
	}
	
}
