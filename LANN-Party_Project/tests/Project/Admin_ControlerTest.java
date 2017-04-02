/**
 * 
 */
package Project;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
/**
 * @author nmhynesmarquette
 *
 */
public class Admin_ControlerTest {
	private Admin_Controler ac;
	private Admin ad;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void setup() throws Exception{
		ac = new Admin_Controler();
		ad = new Admin("Noreen", "Admin", "nadmin", "admin", 'a', 'Y');
	}
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	    ac.deleteUser("jcena");
	    ac.addUser("juser", "John", "User", "user", 'u', 'Y');
	    ac.removeSchool("St. Thomas");
	}
	
	
	@Test
	public void testdisplayProfile() {
		String sa = ad.toString();
		ac.displayProfile("nadmin");
		String s = outContent.toString().trim();
		assertEquals(sa, s);
	}
	
	@Test
	public void testviewUsers() {
		ac.viewUsers();
		assertTrue(outContent.toString() != null);
	}
	
	@Test
	public void testdisplayInfo() {
		ArrayList<String> schools = new ArrayList<String>();
		Student s = new Student("John", "User", "juser", "user", 'u', 'Y', schools);
		ac.displayInfo("juser");
		assertEquals(s.toString(), outContent.toString().trim());
	}
	
	@Test
	public void testaddUser() {
		assertTrue(ac.addUser("jcena", "John", "Cena", "ucantseeme", 'u', 'Y'));
	}
	
	@Test
	public void testeditUser() {
		assertTrue(ac.editUser("ajmac", "Jimmy", "McIntyre", "password", 'u', 'Y'));
		ac.editUser("ajmac", "Andrew", "McIntyre", "password", 'u', 'Y');
	}
	
	@Test
	public void testdeleteUser() {
		assertTrue(ac.deleteUser("juser"));
	}
	
	@Test
	public void testdeactivateUser() {
		assertTrue(ac.deactivateUser("juser"));
	}
	
	@Test
	public void testdisplaySchool() {
		String s = ac.getSchool("AUGSBURG").toString();
		ac.displaySchool("AUGSBURG");
		String oC = outContent.toString().trim();
		assertEquals(s, oC);
	}
	
	@Test
	public void testdisplaySchools() {
		ac.displaySchools();
		assertTrue(outContent.toString() != null);
	}
	
	@Test
	public void testaddSchool() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "St. Paul", "PRIVATE", 10000, 50, 300, 300, 50000, 60, 4500, 60, 500, 3, 3, 3));
	}
	
	@Test
	public void testremoveSchool() {
		ac.addSchool("Bethel", "Minnesota", "St. Paul", "PRIVATE", 2000, 60, 300, 300, 40000, 70, 2000, 80, 60, 2, 2, 2);
		assertTrue(ac.removeSchool("Bethel"));
	}
	
	@Test
	public void testgetSchool() {
		assertTrue(ac.getSchool("AUGSBURG") != null);
	}
	
	@Test
	public void testaddEmphasis() {
		ac.addSchool("Bethel", "Minnesota", "St. Paul", "PRIVATE", 2000, 60, 300, 300, 40000, 70, 2000, 80, 60, 2, 2, 2);
		ac.addEmphasis("Bethel", "Computer Science");
		ac.getEmphases("Bethel");
		String s = "Emphases for Bethel: [Computer Science]";
		assertEquals(s, outContent.toString().trim());
		ac.removeEmphasis("Bethel", "Computer Science");
	}
	
	@Test
	public void testremoveEmphasis() {
		ac.removeEmphasis("AUGSBURG", "PERFORMING-ARTS");
		ac.getEmphases("AUGSBURG");
		String s = "Emphases for AUGSBURG: [BUSINESS-ADMINISTRATION, EDUCATION]";
		assertEquals(s, outContent.toString().trim());
		ac.addEmphasis("AUGSBURG", "PERFORMING-ARTS");
	}
	
	@Test
	public void testeditSchool() {
		String og = ac.getSchool("AUGSBURG").toString();
		ac.editSchool("AUGSBURG", "MINNESOTA", "URBAN", "PRIVATE", 10000, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4);
		String newS = ac.getSchool("AUGSBURG").toString();
		assertTrue(!(og.equals(newS)));		
		ac.editSchool("AUGSBURG", "MINNESOTA", "SMALL-CITY", "PRIVATE", 10000, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4);
	}
	
	@Test
	public void testgetEmphases() {
		String s = "Emphases for AUGSBURG: [BUSINESS-ADMINISTRATION, EDUCATION, PERFORMING-ARTS]";
		ac.getEmphases("AUGSBURG");
		assertEquals(s, outContent.toString().trim());
	}
	
}
