/**
 * 
 */
package Project;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * @author nmhynesmarquette
 *
 */
public class StudentTest {
	private Student st;
	
	@Before
	public void setUp() throws Exception {
		ArrayList<String> schools = new ArrayList<String>();
		st = new Student("Teddy", "Roosevelt", "tRoos", "pWord", 'u', 'Y', schools);
	}
	
	@After
	public void tearDown(){
		st.setFirstName("Teddy");
		st.setLastName("Roosevelt");
		st.setPassword("pWord");
		st.setStatus('Y');
		st.setType('u');
		ArrayList<String> schools = new ArrayList<String>();
		st.setSavedSchools(schools);
		st.setLogon(false);
	}
	/*
	 * basic testing
	 * description: geting to first name
	 */
	@Test
	public void testgetFirstName() {
		assertEquals("Teddy", st.getFirstName());
	}
	/*
	 * basic testing
	 * description:geting the last name
	 */
	@Test
	public void testgetLastName() {
		assertEquals("Roosevelt", st.getLastName());
	}
	/*
	 * basic testing
	 * description:getting the user name
	 */
	@Test
	public void testgetUserName() {
		assertEquals("tRoos", st.getUserName());
	}
	/*
	 * basic testing
	 * description:getting the password
	 */
	@Test
	public void testgetTypegetPassword() {
		assertEquals("pWord", st.getPassword());
	}
	/*
	 * basic testing
	 * description: setting the first name
	 */
	@Test
	public void testsetFirstName() {
		st.setFirstName("Billy");
		assertEquals("Billy", st.getFirstName());
	}
	/*
	 * basic testing
	 * description:setting the last name
	 */
	@Test
	public void testsetLastName() {
		st.setLastName("Bob");
		assertEquals("Bob", st.getLastName());
	}
	/*
	 * basic testing
	 * description:throwing exception for invalid type set
	 */
	@Test (expected= IllegalArgumentException.class)
	public void testsetTypeThrows(){
		st.setType('w');
	}
	/*
	 * basic testing
	 * description:throwing exception for invalid
	 * status set
	 */
	@Test (expected= IllegalArgumentException.class)
	public void testsetStatusThrows(){
		st.setStatus('w');
	}
	/*
	 * basic testing
	 * description:testing set password
	 */
	@Test
	public void testsetPassword() {
		st.setPassword("newPass");
		assertEquals("newPass", st.getPassword());
	}
	/*
	 * basic testing
	 * description: testing set type
	 */
	@Test
	public void testsetType() {
		st.setType('a');
		assertEquals('a', st.getType());
	}
	
	@Test
	public void testsetStatus() {
		st.setStatus('N');
		assertEquals('N', st.getStatus());
	}
	/*
	 * basic testing
	 * description: testing get status
	 */	
	@Test
	public void testgetStatus() {
		assertEquals('Y', st.getStatus());
	}
	/*
	 * basic testing
	 * description:getting users saved schools
	 */
	@Test
	public void testgetSavedSchools() {
		ArrayList<String> s = new ArrayList<String>();
		assertEquals(s, st.getSavedSchools());
	}
	/*
	 * basic testing
	 * description: testing setting/adding a 
	 * users saved schools
	 */
	@Test
	public void testsetSavedSchools() {
		ArrayList<String> sc = new ArrayList<String>();
		sc.add("St.John's");
		st.setSavedSchools(sc);
		assertEquals(sc.toString(), st.getSavedSchools().toString());
	}
	/*
	 * basic testing
	 * description: testing add school
	 */
	@Test
	public void testaddSchool() {
		st.addSchool("Augsburg");
		assertTrue(st.getSavedSchools().contains("Augsburg"));
	}
	/*
	 * basic testing
	 * description: updating a users info
	 */
	@Test
	public void testupdateInfo() {
		st.updateInfo("tRoos", "Jack", "Daniels", "pWord", 'u', 'Y');
		assertEquals("Jack", st.getFirstName());
		assertEquals("Daniels", st.getLastName());
		assertEquals("pWord", st.getPassword());
	}
	/*
	 * basic testing
	 * description:logged on or not
	 */
	@Test
	public void testisLoggedOn() {
		st.setLogon(true);
		assertTrue(st.isLoggedOn());
	}
	/*
	 * basic testing
	 * description: setting loged on
	 */
	@Test
	public void testsetLogon() {
		st.setLogon(true);
		assertTrue(st.isLoggedOn());
	}
	/*
	 * basic testing
	 * description: removing a school
	 */
	@Test
	public void testremoveSchool() {
		st.addSchool("Augsburg");
		assertTrue(st.getSavedSchools().contains("Augsburg"));
		st.removeSchool("Augsburg");
		assertTrue(!(st.getSavedSchools().contains("Augsburg")));
	}
	/*
	 * basic testing
	 * description: toString correct output
	 */
	@Test
	public void testtoString() {
		String s = "Teddy,Roosevelt,tRoos,pWord,u";
		assertEquals(s, st.toString());
	}
	
}
