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
	
	@Test
	public void testgetFirstName() {
		assertEquals("Teddy", st.getFirstName());
	}
	
	@Test
	public void testgetLastName() {
		assertEquals("Roosevelt", st.getLastName());
	}
	
	@Test
	public void testgetUserName() {
		assertEquals("tRoos", st.getUserName());
	}
	
	@Test
	public void testgetTypegetPassword() {
		assertEquals("pWord", st.getPassword());
	}
	
	@Test
	public void testsetFirstName() {
		st.setFirstName("Billy");
		assertEquals("Billy", st.getFirstName());
	}
	
	@Test
	public void testsetLastName() {
		st.setLastName("Bob");
		assertEquals("Bob", st.getLastName());
	}
	
	@Test
	public void testsetPassword() {
		st.setPassword("newPass");
		assertEquals("newPass", st.getPassword());
	}
	
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
	
	@Test
	public void testgetStatus() {
		assertEquals('Y', st.getStatus());
	}
	
	@Test
	public void testgetSavedSchools() {
		ArrayList<String> s = new ArrayList<String>();
		assertEquals(s, st.getSavedSchools());
	}
	
	@Test
	public void testsetSavedSchools() {
		ArrayList<String> sc = new ArrayList<String>();
		sc.add("St.John's");
		st.setSavedSchools(sc);
		assertEquals(sc.toString(), st.getSavedSchools().toString());
	}
	
	@Test
	public void testaddSchool() {
		st.addSchool("Augsburg");
		assertTrue(st.getSavedSchools().contains("Augsburg"));
	}
	
	@Test
	public void testupdateInfo() {
		st.updateInfo("tRoos", "Jack", "Daniels", "pWord", 'u', 'Y');
		assertEquals("Jack", st.getFirstName());
		assertEquals("Daniels", st.getLastName());
		assertEquals("pWord", st.getPassword());
	}
	
	@Test
	public void testisLoggedOn() {
		st.setLogon(true);
		assertTrue(st.isLoggedOn());
	}
	
	@Test
	public void testsetLogon() {
		st.setLogon(true);
		assertTrue(st.isLoggedOn());
	}
	
	@Test
	public void testremoveSchool() {
		st.addSchool("Augsburg");
		assertTrue(st.getSavedSchools().contains("Augsburg"));
		st.removeSchool("Augsburg");
		assertTrue(!(st.getSavedSchools().contains("Augsburg")));
	}
	
	@Test
	public void testtoString() {
		String s = "Teddy,Roosevelt,tRoos,pWord,u";
		assertEquals(s, st.toString());
	}
	
}
