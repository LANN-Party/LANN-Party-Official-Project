package Project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import Project.DatabaseController;

public class DatabaseControllerTest {
	public DatabaseController dbc;
	public Student stu;
	public Admin admin;
	public University school;
	
	@Before
	public void setUp() throws Exception {
	  dbc = new DatabaseController("database", "LANN-Party", "somethingwewontforget");
	  stu = new Student("logan", "dahlquist", "logo", "yanktrain",'a','y',null);
	  admin = new Admin("bob", "saget", "bsag", "yanktrain", 'a', 'y');
	  school = new University("test2", "Minnesota", "St. Cloud", "control", 15, 58, 400, 300, 50000, 30, 400, 54, 44, 5, 5, 5);
	  dbc.addEmphasis("test2", "test");
	  dbc.addEmphasis("test2", "Science");

	}
	
	@After
	public void tearDown(){
		dbc.deleteUser("logo");
		dbc.deleteUser("logo100");
		dbc.deleteUser("bsag");
		dbc.removeEmphasis("test2", "test");
		dbc.removeEmphasis("test2", "test2");
		dbc.removeEmphasis("test2", "Science");
		dbc.removeSchool("test");
		dbc.removeSchool("test2");
		dbc.removeSchool("test3");
		


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
		assertTrue(dbc.addUser("logo100", "Logan", "Dahlquist", "yanktrain", 'u', 'y'));
		
	}
	
	@Test 
	public void testdeleteUser() {
		dbc.addUser("ddog", "dalton", "dahlquist", "yeet", 'u', 'y');
		assertTrue(dbc.deleteUser("ddog"));
	}
	
	@Test 
	public void testremoveSchool() {
		dbc.addSchool("test", "Minnesota", "St. Cloud", "control", 15, 58, 400, 300, 50000, 30, 400, 54, 44, 5, 5, 5);
		assertTrue(dbc.removeSchool("test"));
	}
	
	@Test 
	public void testremoveSavedSchool() {
		stu.addSchool("St. John's");
		assertTrue(dbc.removeSavedSchool(stu.getUserName(), "St. John's"));
	}
	
	@Test 
	public void testsaveSchool() {
		assertTrue(dbc.saveSchool(stu.getUserName(),"MSU"));
	}
	
	@Test 
	public void testgetUser() {
		Student output;
		output = dbc.getUser(stu.getUserName());
		assertTrue(output.equals(stu));
	}
	
	@Test 
	public void testgetAdmin() {
		Admin output;
		output = dbc.getAdmin(admin.getUserName());
		assertTrue(output.equals(admin));
	}
	
	@Test 
	public void testgetSchool() {
		University output;
		output = dbc.getSchool(school.getName());
		assertTrue(output.equals(school));
	}
	
	@Test 
	public void testgetRelatedSchoolsReturnsArrayList() {
		assertTrue(dbc.getRelatedSchools(school)!= null);
	}
	
	@Test 
	public void testgetSchools() {
		assertTrue(dbc.getSchools()!=null);
	}
	
	@Test 
	public void testeditSchool() {
		String state = school.getState();
		dbc.editSchool("test2", "Mn", "St. Cloud", "control", 15, 58, 400, 300, 50000, 30, 400, 54, 44, 5, 5, 5);
		assertEquals("The state should have been changed it mn. Right now its: "+school.getState(), state, school.getState());
	}
	
	@Test 
	public void testaddSchool() {
		assertTrue(dbc.addSchool("test3", "Minnesota", "St. Cloud", "control", 15, 58, 400, 300, 50000, 30, 400, 54, 44, 5, 5, 5));
	}
	
	@Test 
	public void testaddEmphasis() {
		String newEmph = "test2";
		dbc.addEmphasis("test2", newEmph);
		ArrayList<String> emph = new ArrayList<String>();
		emph = dbc.getEmphases("test2");
		assertTrue(emph.contains(newEmph));
		
	}
	
	@Test 
	public void testremoveEmphasis() {
		String newEmph = "test";
		dbc.removeEmphasis("test2", newEmph);
		ArrayList<String> emph = new ArrayList<String>();
		emph = dbc.getEmphases("test2");
		assertFalse(emph.contains("test"));
	}
	
	@Test 
	public void testeditUser() {
		String name = stu.getFirstName();
		dbc.editUser(stu.getUserName(), "jim", stu.getLastName(), stu.getPassword(), stu.getType(), stu.getStatus());
		String newName = stu.getFirstName();
		assertFalse(name.equals(newName));
	}
	
	@Test 
	public void testgetEmphases() {
		assertTrue(dbc.getEmphases(school.getName())!=null);
	}
	

}
