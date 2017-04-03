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
	
	@Test
	public void testlogon() {
		assertTrue(lc.logon("ajmac", "password", true));
	}
	
	@Test
	public void testregisterStudent() {
		assertTrue(lc.registerStudent("Billy", "TheKid", "bKid", "pword", 'u', 'Y'));
	}
	
	@Test
	public void testregisterAdmin() {
		assertTrue(lc.registerAdmin("Jesus", "Christ", "jChristo", "pword", 'a', 'Y'));
	}
	
}
