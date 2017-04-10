/**
 * 
 */
package Project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * @author nmhynesmarquette
 *
 */
public class StudentUserInterfaceTest {
	public StudentUserInterface sui;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
	  sui = new StudentUserInterface();
	}
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void tearDown(){
		System.setOut(null);
		sui.editInfo("ajmac", "Andrew", "McIntyre", "password", 'u', 'Y');
		sui.saveSchool("ajmac", "ADELPHI");
		sui.removeSchool("ajmac", "AUGSBURG");
	}
	
	/*
	 * basic testing
	 * description:
	 */
	@Test
	public void testviewProfile() {
		sui.viewProfile("ajmac");
		String s = "Andrew,McIntyre,ajmac,password,u";
		assertEquals(s, outContent.toString().trim());
	}
	/*
	 * basic testing
	 * description:
	 */
	@Test
	public void testviewSavedSchools() {
		sui.viewSavedSchools("ajmac");
		String s = "[ADELPHI]";
		assertEquals(s, outContent.toString().trim());
	}
	/*
	 * basic testing
	 * description:
	 */
	@Test
	public void testeditInfo() {
		assertTrue(sui.editInfo("ajmac", "Aurelius", "McIntyre", "newPWorduruh", 'u', 'Y'));
	}
	/*
	 * basic testing
	 * description:
	 */
	@Test
	public void testviewSchool() {
		String s = "University [name=AUGSBURG, state=MINNESOTA, location=SMALL-CITY, control=PRIVATE, numOfStudents=10000, percentFemale=43.0, SATVerbal=420.0, SATMath=490.0, expenses=29991.0, percentFinancialAid=80.0, numOfApplicants=4000, percentAdmitted=85.0, percentEnrolled=50.0, academicScale=1, socialScale=3, qualityOfLife=4]";
		sui.viewSchool("AUGSBURG");
		assertEquals(s, outContent.toString().trim());
	}
	/*
	 * basic testing
	 * description:
	 */
	@Test
	public void testremoveSchool() {
		assertTrue(sui.removeSchool("ajmac", "ADELPHI"));
	}
	/*
	 * basic testing
	 * description:
	 */
	@Test
	public void testsearchSchool() {
		sui.searchSchool(null, null, null, null, 18000, 4000, 100, 0, 600, 300, 600, 300, 40000, 28000, 100, 60, 10000, 1000, 90, 30, 90, 30, 5, 1, 5, 1, 5, 1, null, null, null, null, null);
		String s = "ADELPHI"
				+ "\nAUGSBURG"
				+ "\nBARD"
				+ "\nBUTLER"
				+ "\nHOFSTRA"
				+ "\nMANHATTANVILLE COLLEGE"
				+ "\nMARIST COLLEGE"
				+ "\nPOLYTECHNIC INSTITUTE OF NEWYORK"
				+ "\nTRINITY COLLEGE";
		assertEquals(s, outContent.toString().trim());
	}
	/*
	 * basic testing
	 * description:
	 */
	@Test
	public void testviewRecSchools() {
		sui.viewRecSchools("AUGSBURG");
		String s = "NEWYORK IT"
				+ "\nHOFSTRA"
				+ "\nUNIVERSITY OF MAINE"
				+ "\nUNIVERSITY OF SOUTHERN CALIFORNIA"
				+ "\nUNIVERSITY OF EVANSVILLE";
		assertEquals(s, outContent.toString().trim());
	}
	/*
	 * basic testing
	 * description:
	 */
	@Test
	public void testsaveSchool() {
		sui.saveSchool("ajmac", "AUGSBURG");
		sui.viewSavedSchools("ajmac");
		String s = "[ADELPHI, AUGSBURG]";
		assertEquals(s, outContent.toString().trim());
	}

}
