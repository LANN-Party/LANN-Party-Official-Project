package Project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import Project.DatabaseController;

public class DatabaseControllerTest {
	public DatabaseController dbc;
	
	@Before
	public void setUp() throws Exception {
	  dbc = new DatabaseController("database", "LANN-Party", "somethingwewontforget");
	}
	
	@Test 
	public void testgetStudents() {
		ArrayList<Student> expResult = new ArrayList<Student>();
		ArrayList<Student> result = dbc.getStudents();
		assertEquals("The list of users is" + expResult, expResult, result);
		//fail("Not yet implemented");
	}
	
	@Test 
	public void testgetAdmins() {
		ArrayList<Admin> expResult = new ArrayList<Admin>();
		ArrayList<Admin> result = dbc.getAdmins();
		assertEquals("The list of admins is" + expResult, expResult, result);
		//fail("Not yet implemented");
	}
	
	@Test 
	public void testaddUser() {
		String expResult = "dfloeder, Dave, Floeder, weeble22, student";
		//TODO: what do I do here for status??
		//String result = dbc.addUser(dfloeder, Dave, Floeder, weeble22, student, );
		assertEquals("The added student's info is" + result, expResult, result)
		fail("Not yet implemented");
	}
	
	@Test 
	public void testdeleteUser() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testremoveSchool() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testremoveSavedSchool() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testsaveSchool() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testgetUser() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testgetAdmin() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testgetSchool() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testgetRelatedSchools() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testgetSchools() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testeditSchool() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testaddSchool() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testaddEmphasis() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testremoveEmphasis() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testeditUser() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void testgetEmphases() {
		fail("Not yet implemented");
	}
	

}
