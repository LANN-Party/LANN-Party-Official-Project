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
	
	/*
	 * basic testing
	 *Description: testing the getFirstName
	 */
	@Test
	public void testgetFirstName() {
		assertEquals("John", ad.getFirstName());
	}
	/*
	 * basic testing
	 *Description: testing set first name
	 */
	@Test
	public void testsetFirstName() {
		ad.setFirstName("Bob");
		assertEquals("Bob", ad.getFirstName());
	}
	/*
	 * basic testing
	 *Description: testing get last name
	 */
	@Test
	public void testgetLastName() {
		assertEquals("Smith", ad.getLastName());
	}
	/*
	 * basic testing
	 *Description: testing set last name 
	 */
	@Test
	public void testsetLastName() {
		ad.setLastName("Jones");
		assertEquals("Jones", ad.getLastName());
	}
	/*
	 * basic testing
	 *Description: testing get user name  
	 */
	@Test
	public void testgetUserName() {
		assertEquals("jsmith", ad.getUserName());
	}
	/*
	 * basic testing
	 *Description: testing set username 
	 */
	@Test
	public void testsetUserName() {
		ad.setUserName("bjones");
		assertEquals("bjones", ad.getUserName());
	}
	/*
	 * basic testing
	 *Description: testing get password
	 */
	@Test
	public void testgetPassword() {
		assertEquals("password", ad.getPassword());
	}
	/*
	 * basic testing
	 *Description: testing set password 
	 */
	@Test
	public void testsetPassword() {
		ad.setPassword("pword");
		assertEquals("pword", ad.getPassword());
	}
	/*
	 * basic testing
	 *Description: testing get type
	 */
	@Test
	public void testgetType() {
		assertEquals('a', ad.getType());
	}
	/*
	 * basic testing
	 *Description: testing set type 
	 */
	@Test
	public void testsetType() {
		ad.setType('u');
		assertEquals('u', ad.getType());
	}
	/*
	 * basic testing
	 *Description: testing set type with invalid arg 
	 *and throwing and exception
	 */
	@Test (expected= IllegalArgumentException.class)
	public void testsetTypeThrows(){
		ad.setType('w');
	}
	/*
	 * basic testing
	 *Description:	testing set status with invalid arg 
	 *and throwing and exception
	 */
	@Test (expected= IllegalArgumentException.class)
	public void testsetStatusThrows(){
		ad.setStatus('w');
	}
	/*
	 * basic testing
	 *Description: testing get status
	 */
	@Test
	public void testgetStatus() {
		assertEquals('Y', ad.getStatus());
	}
	/*
	 * basic testing
	 *Description: testing set status with valid arg
	 */
	@Test
	public void testsetStatus() {
		ad.setStatus('N');
		assertEquals('N', ad.getStatus());
	}
	/*
	 * basic testing
	 *Description: testing is logon method
	 */
	@Test
	public void testisLogon() {
		assertFalse(ad.isLogon());
	}
	/*
	 * basic testing
	 *Description: testing set logon
	 */
	@Test
	public void testsetLogon() {
		ad.setLogon(true);
		assertTrue(ad.isLogon());
	}
	/*
	 * basic testing
	 *Description: testing constructing an admin
	 */
	@Test
	public void testadmin() {
		Admin am = new Admin("Bob", "Jones", "bjones", "pword", 'a', 'y');
		assertTrue(am != null);
	}
	/*
	 * basic testing
	 *Description: testing tostring output
	 */
	@Test
	public void testtoString() {
		String s = ad.toString();
		assertTrue(s != null);
	}
	
}
