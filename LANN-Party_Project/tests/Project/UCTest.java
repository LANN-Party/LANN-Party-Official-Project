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
 * @author lrdahlquist
 *
 */
public class UCTest {
	LoginUI loginUI;
	AdminUI adminUI;
	StudentUserInterface studentUI;
	DatabaseController dbc;
	Search_Controler sc;
	String uName = "case123";
	String pWord = "case123";
	String fName = "case";
	String lName = "tester";
	char type = 'u';
	char status= 'y';
	Student caseTester = new Student(fName, lName, uName, pWord, type, status, null);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setup(){
		loginUI = new LoginUI();
		adminUI = new AdminUI();
		studentUI = new StudentUserInterface();
		dbc = new DatabaseController("lannp", "lannp","csci230");
		sc = new Search_Controler();
		Student caseTester = new Student(fName, lName, uName, pWord, type, status, null);
	}
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    dbc.removeSavedSchool(uName, "AUGSBURG");
	    dbc.deleteUser(uName);
	}
	
	/*
	 * tests login
	 */
	@Test
	public void testUC1(){
		assertTrue(loginUI.logon("case123", "case123", true));
	}
	
	/*
	 * viewProfile Test
	 */
	@Test
	public void testUC2(){
		String info = dbc.getUser(fName).toString();
		studentUI.viewProfile(fName);
		String output = outContent.toString();
		assertTrue(output.equals(info));
	}
	
	/*
	 * Edit Profile Tests
	 * 	tests changing the first name
	 * 	tests changing the last name
	 * 	tests changing the password
	 */
	@Test
	public void testUC3_1editFirstName(){
		assertTrue(studentUI.editInfo(uName, "bob", lName, pWord, type, status));
		assertTrue(caseTester.getFirstName().equals("bob"));
	}
	@Test
	public void testUC3_2editLastName(){
		assertTrue(studentUI.editInfo(uName, fName, "theBuilder", pWord, type, status));
		assertTrue(caseTester.getLastName().equals("theBuilder"));
	}
	@Test
	public void testUC3_3editPassword(){
		assertTrue(studentUI.editInfo(uName, fName, lName, "case321", type, status));
		assertTrue(caseTester.getPassword().equals("bob"));
	}
	/*
	 * View Saved Schools Test
	 * 	checks the output stream to see if the
	 * 	output is actually matching what it should be
	 */
	@Test
	public void testUC4(){
		studentUI.viewSavedSchools(uName);
		String output = outContent.toString();
		assertTrue(output.equals(caseTester.getSavedSchools().toString()));
	}
	
	/*
	 * Remove a school Test
	 * 	tests to see if a school is removed
	 */
	@Test
	public void testUC5(){
		studentUI.saveSchool(uName, "AUGSBURG");
		assertTrue(studentUI.removeSchool(uName, "AUGSBURG"));
		
	}
	
	/*
	 * Search for school test
	 * 	tests to see if the output generated by the tests
	 * 	actually matches what it should be
	 */
	@Test
	public void testUC6(){
		studentUI.searchSchool("AUGSBURG", null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String output1 = outContent.toString();
		System.setOut(null);
		sc.displaySearchResults("AUGSBURG", null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String output2 = outContent.toString();
		assertTrue(output1.equals(output2));
	}
	/*
	 * View School Test
	 * 	tests to see if the outout generated by the viewSchool
	 * 	method called in student UI matches what it should be
	 */
	@Test
	public void testUC7(){
		studentUI.viewSchool("AUGSBURG");
		String output1 = outContent.toString();
		System.setOut(null);
		assertTrue(output1.equals(dbc.getSchool("AUGSBURG").toString()));
	}
	
	/*
	 * Test Save School
	 * 	tests to see if a user can save a school
	 */
	@Test
	public void testUC8(){
		assertTrue(studentUI.saveSchool(uName, "AUGSBURG"));
	}
	
	/*
	 * Test Admin Login
	 * 	tests to see if logging in with admin credentials works
	 */
	@Test
	public void testUC9(){
		assertTrue(loginUI.logon("admin", "admin", true));
	}
	
	/*
	 * Test View Users
	 * 	makes sure the admin ui works correctly
	 */
	@Test
	public void testUC10(){
		adminUI.viewusers();
		String output1 = outContent.toString();
		System.setOut(null);
		ArrayList<Student> s = dbc.getStudents();
		ArrayList<Admin> a = dbc.getAdmins();
		for(Student e : s){
			System.out.println(e.toString());
		}
		for(Admin ea : a){
			System.out.println(ea.toString());
		}
		String output2 = outContent.toString();
		assertTrue(output1.equals(output2));
	}
	
	/*
	 * Test View User
	 * 	makes sure that the the adminUI performs 
	 * 	as expected
	 */
	@Test
	public void testUC11(){
		adminUI.veiwUser(uName);
		String output1 = outContent.toString();
		System.setOut(null);
		System.out.println(dbc.getUser(uName).toString());
		String output2 = outContent.toString();
		assertTrue(output1.equals(output2));
	}
	
	/*
	 * Edit User Tests
	 * 	tests changing the first name
	 * 	tests changing the last name
	 * 	tests changing the password
	 */
	@Test
	public void testUC12_1editFirstName(){
		assertTrue(adminUI.editUser(uName, "bob", lName, pWord, type, status));
		assertTrue(caseTester.getFirstName().equals("bob"));
	}
	@Test
	public void testUC12_2editLastName(){
		assertTrue(adminUI.editUser(uName, fName, "theBuilder", pWord, type, status));
		assertTrue(caseTester.getLastName().equals("theBuilder"));
	}
	@Test
	public void testUC12_3editPassword(){
		assertTrue(adminUI.editUser(uName, fName, lName, "case321", type, status));
		assertTrue(caseTester.getPassword().equals("bob"));
	}
	/*
	 * Add User Test
	 * 	checks to make sure you can add a user
	 * 	from the adminUI
	 */
	@Test
	public void testUC13(){
	    dbc.deleteUser(uName);
		assertTrue(adminUI.addUser(uName, fName, lName, pWord, type, status));
	}
	
	/*
	 * Deactivate User Test
	 * 	tests that you can successfully deactivate a user
	 */
	@Test
	public void testUC14(){
		assertTrue(adminUI.deactivateUser(uName));
	}
	
	/*
	 * View All Schools Test
	 * 	tests to see if the output generated by the admin UI
	 * 	matches what it should be
	 */
	@Test
	public void testUC15(){
		adminUI.viewSchools();
		String output1 = outContent.toString();
		System.setOut(null);
		for(University x: dbc.getSchools())
		{
			System.out.println(x.getName());
		}
		String output2 = outContent.toString();
		assertTrue(output1.equals(output2));
	}
	
	/*
	 * View School Test
	 * 	test to make sure admin UI output is what it should be
	 */
	@Test
	public void testUC16(){
		adminUI.viewSchool("AUGSBURG");
		String output1 = outContent.toString();
		System.setOut(null);
		assertTrue(output1.equals(dbc.getSchool("AUGSBURG").toString()));
	}
	
	/*
	 * Edit School Test
	 * 	checks to see if the school is changed
	 */
	@Test
	public void testUC17(){
		
	}
	@Test
	public void testUC18(){
		
	}
	@Test
	public void testUC19(){
		
	}
	@Test
	public void testUC20(){
		
	}
	@Test
	public void testUC21(){
		
	}
	@Test
	public void testUC22(){
		
	}
	@Test
	public void testUC23(){
		
	}
	@Test
	public void testUC24(){
		
	}
	@Test
	public void testUC25(){
		
	}
	

}
