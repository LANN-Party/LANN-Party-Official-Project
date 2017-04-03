/**
 * 
 */
package Project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author nmhynesmarquette
 *
 */
public class AdminTest {
	private Admin ad;
	
	@Before
	public void setUp() throws Exception {
		ad = new Admin("John", "Smith", "jsmith", "password", 'a', 'Y');
	}
	

	@Test
	public void testgetFirstName() {
		assertEquals("John", ad.getFirstName());
	}

	@Test
	public void testsetFirstName() {
		ad.setFirstName("Bob");
		assertEquals("Bob", ad.getFirstName());
	}
	
	@Test
	public void testgetLastName() {
		assertEquals("Smith", ad.getLastName());
	}
	
	@Test
	public void testsetLastName() {
		ad.setLastName("Jones");
		assertEquals("Jones", ad.getLastName());
	}
	
	@Test
	public void testgetUserName() {
		assertEquals("jsmith", ad.getUserName());
	}
	
	@Test
	public void testsetUserName() {
		ad.setUserName("bjones");
		assertEquals("bjones", ad.getUserName());
	}
	
	@Test
	public void testgetPassword() {
		assertEquals("password", ad.getPassword());
	}
	
	@Test
	public void testsetPassword() {
		ad.setPassword("pword");
		assertEquals("pword", ad.getPassword());
	}
	
	@Test
	public void testgetType() {
		assertEquals('a', ad.getType());
	}
	
	@Test
	public void testsetType() {
		ad.setType('u');
		assertEquals('u', ad.getType());
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testsetTypeThrows(){
		ad.setType('w');
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testsetStatusThrows(){
		ad.setStatus('w');
	}
	@Test
	public void testgetStatus() {
		assertEquals('Y', ad.getStatus());
	}
	
	@Test
	public void testsetStatus() {
		ad.setStatus('N');
		assertEquals('N', ad.getStatus());
	}
	
	@Test
	public void testisLogon() {
		assertFalse(ad.isLogon());
	}
	
	@Test
	public void testsetLogon() {
		ad.setLogon(true);
		assertTrue(ad.isLogon());
	}
	
	@Test
	public void testadmin() {
		Admin am = new Admin("Bob", "Jones", "bjones", "pword", 'a', 'y');
		assertTrue(am != null);
	}
	
	@Test
	public void testtoString() {
		String s = ad.toString();
		assertTrue(s != null);
	}
	
}
