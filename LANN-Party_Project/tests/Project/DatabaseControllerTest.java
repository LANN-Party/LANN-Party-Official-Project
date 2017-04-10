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
		dbc.removeSavedSchool("logo", "test");
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
		dbc.removeSchool("St. Thomas");


	}
	 
	public void testgetStudents() {
		ArrayList<Student> result = dbc.getStudents();
		assertTrue(result!=null);
	}
	
	@Test 
	public void testgetAdmins() {
		ArrayList<Admin> result = dbc.getAdmins();
		assertTrue(result!=null);
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
	public void testeditSchoolFailNotAState() {
		assertFalse(dbc.editSchool("St. Thomas", "RUSSIA", "St. Paul", "PRIVATE", 10000, 50, 300, 300, 50000, 60, 4500, 60, 500, 3, 3, 3));
	}
	
	@Test
	public void testeditSchoolFailNegativeStudents() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", -1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolZeroStudents() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 0, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailNegativePercentFemale() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, -10, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailOver100PercentFemale() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 110, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFem1() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 1, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFem99() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1,99, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATVerbalNegative() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, -1, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATVerbalOver800() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 801, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATVerbalZero() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 0, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATVerbal1() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 1, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATVerbal800() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 800, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATVerbal799() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 799, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATMathNegative() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, -1, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATMathOver800() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 801, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATMathZero() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 0, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATMath1() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 1, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolSATMath800() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 800, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSATMath799() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 799, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailExpensesNegative() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, -1, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolExpensesZero() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 0, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailPercFinAidNegative() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, -1, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFinAidZero() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 0, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFinAid1() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 1, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFinAid99() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 99, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercFinAid100() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 100, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailApplicantsNegative() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, -1, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolApplicantsZero() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 0, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailPercAdmittedNegative() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, -1, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercAdmittedZero() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 0, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercAdmittedAid1() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 1, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercAdmitted99() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 99, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercAdmitted100() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 100, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailPercEnrolledNegative() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, -1, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercEnrolledZero() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 0, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercEnrolled1() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 1, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercEnrolled99() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 99, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolPercEnrolled100() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 100, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailAcademScaleNegative() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, -1, 3, 4));
	}
	
	@Test
	public void testeditSchoolAcademScaleZero() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 0, 3, 4));
	}
	
	@Test
	public void testeditSchoolAcademScale1() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testeditSchoolAcademScale9() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 9, 3, 4));
	}
	
	@Test
	public void testeditSchoolAcademScale10() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 10, 3, 4));
	}
	
	@Test
	public void testeditSchoolFailSocialScaleNegative() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, -1, 4));
	}
	
	@Test
	public void testeditSchoolSocialScaleZero() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 0, 4));
	}
	
	@Test
	public void testeditSchoolSocialScale1() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 1, 4));
	}
	
	@Test
	public void testeditSchoolSocialScale9() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 9, 4));
	}
	
	@Test
	public void testeditSchoolSocialScale10() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 10, 4));
	}
	
	@Test
	public void testeditSchoolFailQualOfLifeNegative() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, -1, 3, -1));
	}
	
	@Test
	public void testeditSchoolQualOfLifeZero() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 0, 3, 0));
	}
	
	@Test
	public void testeditSchoolQualOfLife1() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 1));
	}
	
	@Test
	public void testeditSchoolQualOfLife9() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 9, 3, 9));
	}
	
	@Test
	public void testeditSchoolQualOfLife10() {
		assertFalse(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 10, 3, 10));
	}
	
	@Test 
	public void testaddSchool() {
		assertTrue(dbc.addSchool("test3", "Minnesota", "St. Cloud", "control", 15, 58, 400, 300, 50000, 30, 400, 54, 44, 5, 5, 5));
	}
	
	@Test
	public void testaddSchoolFailNotAState() {
		assertFalse(dbc.addSchool("St. Thomas", "RUSSIA", "St. Paul", "PRIVATE", 10000, 50, 300, 300, 50000, 60, 4500, 60, 500, 3, 3, 3));
	}
	
	@Test
	public void testaddSchoolFailNegativeStudents() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", -1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolZeroStudents() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 0, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailNegativePercentFemale() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, -10, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailOver100PercentFemale() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 110, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFem1() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 1, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFem99() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1,99, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATVerbalNegative() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, -1, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATVerbalOver800() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 801, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATVerbalZero() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 0, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATVerbal1() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 1, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATVerbal800() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 800, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATVerbal799() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 799, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATMathNegative() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, -1, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATMathOver800() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 801, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATMathZero() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 0, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATMath1() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 1, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolSATMath800() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 800, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSATMath799() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 799, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailExpensesNegative() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, -1, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolExpensesZero() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 0, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailPercFinAidNegative() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, -1, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFinAidZero() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 0, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFinAid1() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 1, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFinAid99() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 99, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercFinAid100() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 100, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailApplicantsNegative() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, -1, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolApplicantsZero() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 0, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailPercAdmittedNegative() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, -1, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercAdmittedZero() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 0, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercAdmittedAid1() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 1, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercAdmitted99() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 99, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercAdmitted100() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 100, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailPercEnrolledNegative() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, -1, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercEnrolledZero() {
		assertTrue(dbc.editSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 10, 0, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercEnrolled1() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 1, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercEnrolled99() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 99, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolPercEnrolled100() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 100, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailAcademScaleNegative() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, -1, 3, 4));
	}
	
	@Test
	public void testaddSchoolAcademScaleZero() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 0, 3, 4));
	}
	
	@Test
	public void testaddSchoolAcademScale1() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4));
	}
	
	@Test
	public void testaddSchoolAcademScale5() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 5, 3, 4));
	}
	
	@Test
	public void testaddSchoolAcademScale6() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 6, 3, 4));
	}
	
	@Test
	public void testaddSchoolFailSocialScaleNegative() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, -1, 4));
	}
	
	@Test
	public void testaddSchoolSocialScaleZero() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 0, 4));
	}
	
	@Test
	public void testaddSchoolSocialScale1() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 1, 4));
	}
	
	@Test
	public void testaddSchoolSocialScale9() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 9, 4));
	}
	
	@Test
	public void testaddSchoolSocialScale10() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 10, 4));
	}
	
	@Test
	public void testaddSchoolFailQualOfLifeNegative() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, -1, 3, -1));
	}
	
	@Test
	public void testaddSchoolQualOfLifeZero() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 0, 3, 0));
	}
	
	@Test
	public void testaddSchoolQualOfLife1() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 1));
	}
	
	@Test
	public void testaddSchoolQualOfLife4() {
		assertTrue(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 4, 3, 4));
	}
	
	@Test
	public void testaddSchoolQualOfLife6() {
		assertFalse(dbc.addSchool("St. Thomas", "MINNESOTA", "URBAN", "PRIVATE", 1, 43, 420, 490, 29991, 80, 4000, 85, 50, 5, 3, 6));
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
