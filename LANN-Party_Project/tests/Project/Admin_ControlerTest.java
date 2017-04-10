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
	    ac.removeEmphasis("Bethel", "Computer Science");
	    ac.removeSchool("St. Thomas");
	}
	
	/*
	 * basic testing
	 *Description: to test a profile being displayed
	 */
	@Test
	public void testdisplayProfile() {
		String sa = ad.toString();
		ac.displayProfile("nadmin");
		String s = outContent.toString().trim();
		assertEquals(sa, s);
	}
	
	/*
	 * basic testing
	 *Description: testing the view all users method
	 */
	@Test
	public void testviewUsers() {
		ac.viewUsers();
		assertTrue(outContent.toString() != null);
		
	}
	
	/*
	 * basic testing
	 *Description: to display a users info including saved schools
	 */
	@Test
	public void testdisplayInfo() {
		ArrayList<String> schools = new ArrayList<String>();
		Student s = new Student("John", "User", "juser", "user", 'u', 'Y', schools);
		ac.displayInfo("juser");
		assertEquals(s.toString(), outContent.toString().trim());
	}
	/*
	 * basic testing
	 *Description: testing addUser method for correct and incorrect arguments
	 */
	@Test
	public void testaddUser() {
		assertTrue(ac.addUser("jcena", "John", "Cena", "ucantseeme", 'u', 'Y'));
		assertFalse(ac.addUser("ajmac", "Jimmy", "McIntyre", "password", 'r', 'Y'));
		assertFalse(ac.addUser("ajmac", "Jimmy", "McIntyre", "password", 'u', 'r'));
	}
	/*
	 * basic testing
	 *Description: testing to edit a user with valid and invalid arguments 
	 */
	@Test
	public void testeditUser() {
		assertTrue(ac.editUser("ajmac", "Jimmy", "McIntyre", "password", 'u', 'Y'));
		assertFalse(ac.editUser("ajmac", "Jimmy", "McIntyre", "password", 'r', 'Y'));
		assertFalse(ac.editUser("ajmac", "Jimmy", "McIntyre", "password", 'u', 'r'));
		ac.editUser("ajmac", "Andrew", "McIntyre", "password", 'u', 'Y');
	}
	/*
	 * basic testing
	 *Description: testing delete working for a user existing and not
	 */
	@Test
	public void testdeleteUser() {
		assertTrue(ac.deleteUser("juser"));
		assertFalse(ac.deleteUser("oops"));
	}
	/*
	 * basic testing
	 *Description: testing deactivate user method for valid and invalid names 
	 */
	@Test
	public void testdeactivateUser() {
		assertTrue(ac.deactivateUser("juser"));
		assertFalse(ac.deactivateUser("oops"));
	}
	/*
	 * basic testing
	 *Description: displaying a schools profile
	 */
	@Test
	public void testdisplaySchool() {
		String s = ac.getSchool("AUGSBURG").toString();
		ac.displaySchool("AUGSBURG");
		String oC = outContent.toString().trim();
		assertEquals(s, oC);
	}
	/*
	 * basic testing
	 *Description: testing displaying all schools 
	 */
	@Test
	public void testdisplaySchools() {
		ac.displaySchools();
		assertTrue(outContent.toString() != null);
	}
	/*
	 * black box testing
	 *Description: testing the add method for a school with invalid and valid perams and boundaries 
	 */
	 @Test
	 public void testaddSchool() {
	  assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "St. Paul", "PRIVATE", 10000, 50, 300, 300, 50000, 60, 4500, 60, 50, 3, 3, 3));
	 }
	

	@Test
	public void testaddSchoolFailNotAState() {
		assertFalse(ac.addSchool("St. Thomas", "RUSSIA", "St. Paul", "PRIVATE", 10000, 50, 300, 300, 50000, 60, 4500, 60, 500, 3, 3, 3));
	}
	
	@Test
	public void testaddSchoolFailNegativeStudents() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", -1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolZeroStudents() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 0, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailNegativePercentFemale() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, -1, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailOver100PercentFemale() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, -1, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFem1() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 1, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFem99() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1,99, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATVerbalNegative() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, -1, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATVerbalOver800() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 801, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATVerbalZero() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 0, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATVerbal1() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 1, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATVerbal800() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 800, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATVerbal799() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 799, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATMathNegative() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, -1, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATMathOver800() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 801, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATMathZero() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 0, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATMath1() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 1, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATMath800() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 800, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATMath799() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 799, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailExpensesNegative() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, -1, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolExpensesZero() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 0, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailPercFinAidNegative() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, -1, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFinAidZero() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 0, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFinAid1() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 1, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFinAid99() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 99, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFinAid100() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 100, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailApplicantsNegative() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, -1, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolApplicantsZero() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 0, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailPercAdmittedNegative() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, -1, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercAdmittedZero() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 0, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercAdmittedAid1() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 1, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercAdmitted99() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 99, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercAdmitted100() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 100, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailPercEnrolledNegative() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, -1, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercEnrolledZero() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 0, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercEnrolled1() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 1, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercEnrolled99() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 99, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercEnrolled100() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 100, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailAcademScaleNegative() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, -1, 3, 4));
	}
	
	@Test
	public void testaddSchoolAcademScaleZero() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 0, 3, 4));
	}
	
	@Test
	public void testaddSchoolAcademScale1() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolAcademScale4() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 4, 3, 4));
	}
	
	@Test
	public void testaddSchoolAcademScale6() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 6, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSocialScaleNegative() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, -1, 4));
	}
	
	@Test
	public void testaddSchoolSocialScaleZero() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 0, 4));
	}
	
	@Test
	public void testaddSchoolSocialScale1() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 1, 4));
	}
	
	@Test
	public void testaddSchoolSocialScale4() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 4, 4));
	}
	
	@Test
	public void testaddSchoolSocialScale6() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 6, 4));
	}
	
	@Test
	public void testaddSchoolFailQualOfLifeNegative() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, -1, 3, -1));
	}
	
	@Test
	public void testaddSchoolQualOfLifeZero() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 0, 3, 0));
	}
	
	@Test
	public void testaddSchoolQualOfLife1() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 1));
	}
	
	@Test
	public void testaddSchoolQualOfLife4() {
		assertTrue(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 4, 3, 4));
	}
	
	@Test
	public void testaddSchoolQualOfLife6() {
		assertFalse(ac.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 4, 3, 6));
	}
	
	/*
	 * basic testing
	 *Description: testing remove school
	 */
	@Test
	public void testremoveSchool() {
		ac.addSchool("Bethel", "Minnesota", "St. Paul", "PRIVATE", 2000, 60, 300, 300, 40000, 70, 2000, 80, 60, 2, 2, 2);
		assertTrue(ac.removeSchool("Bethel"));
	}
	/*
	 * basic testing
	 *Description: testing getting one school
	 */
	@Test
	public void testgetSchool() {
		assertTrue(ac.getSchool("AUGSBURG") != null);
		assertTrue(ac.getSchool("oops") == null);
		
	}
	/*
	 * basic testing
	 *Description: testing adding a Emphasis to a school
	 */
	@Test
	public void testaddEmphasis() {
		ac.addSchool("Bethel", "Minnesota", "St. Paul", "PRIVATE", 2000, 60, 300, 300, 40000, 70, 2000, 80, 60, 2, 2, 2);
		ac.addEmphasis("Bethel", "Computer Science");
		ac.getEmphases("Bethel");
		String s = "Emphases for Bethel: [Computer Science]";
		assertEquals(s, outContent.toString().trim());
		ac.removeEmphasis("Bethel", "Computer Science");
	}
	/*
	 * basic testing
	 *Description: testing removing a emphasis
	 */
	@Test
	public void testremoveEmphasis() {
		ac.removeEmphasis("AUGSBURG", "PERFORMING-ARTS");
		ac.getEmphases("AUGSBURG");
		String s = "Emphases for AUGSBURG: [BUSINESS-ADMINISTRATION, EDUCATION]";
		assertEquals(s, outContent.toString().trim());
		ac.addEmphasis("AUGSBURG", "PERFORMING-ARTS");
		ac.removeEmphasis("AUGSBURG", "bleh");
		ac.getEmphases("AUGSBURG");
		String x = "Emphases for AUGSBURG: [BUSINESS-ADMINISTRATION, EDUCATION]";
		assertFalse(x.equals(outContent.toString().trim()));
	}
	/*
	 * black box testing
	 *Description: testing bounties, invalid and valid parameters for edit schools
	 */
	@Test
	 public void testeditSchool() {
	  String og = ac.getSchool("AUGSBURG").toString();
	  ac.editSchool("AUGSBURG", "MINNESOTA", "URBAN", "PRIVATE", 10000, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4);
	  String newS = ac.getSchool("AUGSBURG").toString();
	  assertTrue(!(og.equals(newS)));  
	  ac.editSchool("AUGSBURG", "MINNESOTA", "SMALL-CITY", "PRIVATE", 10000, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4);
	 }
	
	@Test
	public void testeditSchoolFailNotAState() {
		assertFalse(ac.editSchool("St. Thomas", "RUSSIA", "St. Paul", "PRIVATE", 10000, 50, 300, 300, 50000, 60, 4500, 60, 500, 3, 3, 3));
	}
	
	@Test
	public void testeditSchoolFailNegativeStudents() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", -1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolZeroStudents() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 0, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailNegativePercentFemale() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, -1, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailOver100PercentFemale() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, -1, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFem1() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 1, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFem99() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1,99, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATVerbalNegative() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, -1, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATVerbalOver800() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 801, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATVerbalZero() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 0, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATVerbal1() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 1, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATVerbal800() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 800, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATVerbal799() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 799, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATMathNegative() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, -1, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATMathOver800() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 801, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATMathZero() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 0, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATMath1() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 1, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATMath800() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 800, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATMath799() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 799, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailExpensesNegative() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, -1, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolExpensesZero() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 0, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailPercFinAidNegative() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, -1, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFinAidZero() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 0, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFinAid1() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 1, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFinAid99() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 99, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFinAid100() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 100, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailApplicantsNegative() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, -1, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolApplicantsZero() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 0, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailPercAdmittedNegative() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, -1, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercAdmittedZero() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 0, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercAdmittedAid1() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 1, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercAdmitted99() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 99, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercAdmitted100() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 100, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailPercEnrolledNegative() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, -1, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercEnrolledZero() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 0, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercEnrolled1() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 1, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercEnrolled99() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 99, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercEnrolled100() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 100, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailAcademScaleNegative() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, -1, 3, 4));
	}
	
	@Test
	public void testeditSchoolAcademScaleZero() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 0, 3, 4));
	}
	
	@Test
	public void testeditSchoolAcademScale1() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolAcademScale4() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 4, 3, 4));
	}
	
	@Test
	public void testeditSchoolAcademScale6() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 6, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSocialScaleNegative() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, -1, 4));
	}
	
	@Test
	public void testeditSchoolSocialScaleZero() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 0, 4));
	}
	
	@Test
	public void testeditSchoolSocialScale1() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 1, 4));
	}
	
	@Test
	public void testeditSchoolSocialScale4() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 4, 4));
	}
	
	@Test
	public void testeditSchoolSocialScale6() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 6, 4));
	}
	
	@Test
	public void testeditSchoolFailQualOfLifeNegative() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, -1, 3, -1));
	}
	
	@Test
	public void testeditSchoolQualOfLifeZero() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 0, 3, 0));
	}
	
	@Test
	public void testeditSchoolQualOfLife1() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 1));
	}
	
	@Test
	public void testeditSchoolQualOfLife4() {
		assertTrue(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 4, 3, 4));
	}
	
	@Test
	public void testeditSchoolQualOfLife6() {
		assertFalse(ac.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 4, 3, 6));
	}
	
	
	/*
	 * basic testing
	 *Description:testing get emphases for a school
	 */
	@Test
	public void testgetEmphases() {
		String s = "Emphases for AUGSBURG: [BUSINESS-ADMINISTRATION, EDUCATION, PERFORMING-ARTS]";
		ac.getEmphases("AUGSBURG");
		assertEquals(s, outContent.toString().trim());
	}
	
}
