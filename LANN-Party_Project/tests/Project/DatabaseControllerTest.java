package Project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class DatabaseControllerTest {
	public DatabaseController dbc;
	public Student stu;
	public Admin admin;
	public University school;
	
	@Before
	public void setUp() throws Exception {
	  dbc = new DatabaseController("lannp", "lannp", "csci230");
	  stu = new Student("logan", "dahlquist", "logo", "yanktrain",'u','y',null);
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
		dbc.removeSavedSchool(stu.getFirstName(), "AUGSBURG");
		dbc.removeEmphasis("test", "test2");
		dbc.removeSavedSchool("logo", "test");
		
		


	}
	
	
	
	@Test 
	public void testgetStudents() {
		ArrayList<Student> result = dbc.getStudents();
		assertTrue(result!=null);
		//fail("Not yet implemented");
	}
	
	@Test 
	public void testgetAdmins() {
		ArrayList<Admin> result = dbc.getAdmins();
		assertTrue(result!=null);
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
		dbc.removeEmphasis("test", "test2");
		ArrayList<String> s = dbc.getEmphases("test");
		assertTrue(dbc.removeSchool("test"));
	}
	
	@Test 
	public void testremoveSavedSchool() {
		dbc.addSchool("test", "Minnesota", "St. Cloud", "control", 15, 58, 400, 300, 50000, 30, 400, 54, 44, 5, 5, 5);
		dbc.addUser(stu.getUserName(), stu.getFirstName(), stu.getLastName(), stu.getPassword(), stu.getType(), stu.getStatus());
		dbc.saveSchool(stu.getUserName(), "test");
		assertTrue(dbc.removeSavedSchool(stu.getUserName(), "test"));
	}
	
	@Test 
	public void testsaveSchool() {
		dbc.addSchool("test", "Minnesota", "St. Cloud", "control", 15, 58, 400, 300, 50000, 30, 400, 54, 44, 5, 5, 5);
		dbc.addUser(stu.getUserName(), stu.getFirstName(), stu.getLastName(), stu.getPassword(), stu.getType(), stu.getStatus());
		assertTrue(dbc.saveSchool("logo","test"));
	}
	
	@Test 
	public void testgetUser() {
		dbc.addUser(stu.getUserName(), stu.getFirstName(), stu.getLastName(), stu.getPassword(), stu.getType(), stu.getStatus());
		Student output;
		output = dbc.getUser(stu.getUserName());
		assertEquals("", output.getFirstName(),"logan");
	}
	
	@Test 
	public void testgetAdmin() {
		dbc.addUser(admin.getUserName(), admin.getFirstName(), admin.getLastName(), admin.getPassword(), admin.getType(), admin.getStatus());
		Admin output;
		output = dbc.getAdmin(admin.getUserName());
		assertEquals("", output.getFirstName(),"bob");
	}
	
	@Test 
	public void testgetSchool() {
		dbc.addSchool(school.getName(), school.getState(), school.getLocation(), school.getControl(), school.getNumOfStudents(), school.getPercentFemale(), school.getSATVerbal(), school.getSATMath(), school.getExpenses(), school.getPercentFinancialAid(), school.getNumOfApplicants(), school.getPercentAdmitted(), school.getPercentEnrolled(), school.getAcademicScale(), school.getSocialScale(), school.getQualityOfLife());
		University output;
		output = dbc.getSchool(school.getName());
		assertEquals("",output.getName(), school.getName());
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
		dbc.addSchool("test", "Minnesota", "St. Cloud", "control", 15, 58, 400, 300, 50000, 30, 400, 54, 44, 5, 5, 5);
		dbc.addEmphasis("test", newEmph);
		ArrayList<String> emph = new ArrayList<String>();
		emph = dbc.getEmphases("test");
		assertTrue(emph.contains(newEmph));
		dbc.removeEmphasis("test", "test2");
		
	}
	
	@Test 
	public void testremoveEmphasis() {
		dbc.addSchool("test", "Minnesota", "St. Cloud", "control", 15, 58, 400, 300, 50000, 30, 400, 54, 44, 5, 5, 5);
		String newEmph = "test";
		dbc.addEmphasis("test", newEmph);
		dbc.removeEmphasis("test", newEmph);
		ArrayList<String> emph = new ArrayList<String>();
		emph = dbc.getEmphases("test2");
		assertFalse(emph.contains("test"));
	}
	
	@Test 
	public void testeditUser() {
		dbc.addUser(stu.getUserName(), stu.getFirstName(), stu.getLastName(), stu.getPassword(), stu.getType(), stu.getStatus());
		Student test = dbc.getUser(stu.getUserName());
		dbc.editUser(stu.getUserName(), "jim", stu.getLastName(), stu.getPassword(), stu.getType(), stu.getStatus());
		Student test2 = dbc.getUser(stu.getUserName());
		assertFalse(test.getFirstName()==test2.getFirstName());
	}
	
	@Test 
	public void testgetEmphases() {
		assertTrue(dbc.getEmphases(school.getName())!=null);
	}
	

}
