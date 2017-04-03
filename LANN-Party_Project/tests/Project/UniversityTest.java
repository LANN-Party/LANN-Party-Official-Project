/**
 * 
 */
package Project;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author nmhynesmarquette
 *
 */
public class UniversityTest {
	private University uv;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		uv = new University("UNIVERSITY SCHOOL", "STATE", "TOWNVILLE", "CONTROL", 200, 20, 200, 200, 4000, 30, 300, 20, 20, 3, 3, 3);
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
	    uv.setName("UNIVERSITY SCHOOL");
	    uv.setState("STATE");
	    uv.setLocation("TOWNVILLE");
	    uv.setControl("CONTROL");
	    uv.setNumOfStudents(20);
	    uv.setPercentFemale(20);
	    uv.setSATVerbal(200);
	    uv.setSATMath(200);
	    uv.setExpenses(4000);
	    uv.setPercentFinancialAid(30);
	    uv.setNumOfApplicants(300);
	    uv.setPercentAdmitted(20);
	    uv.setPercentEnrolled(20);
	    uv.setAcademicScale(3);
	    uv.setSocialScale(3);
	    uv.setQualityOfLife(3);
	}
	
	
	@Test
	public void testgetName() {
		assertEquals("name found", "UNIVERSITY SCHOOL", uv.getName());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetName() {
		uv.setName("random name");
		assertEquals("name set","random name", uv.getName());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetState() {
		assertEquals("state found", "STATE", uv.getState());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetState() {
		uv.setState("IOWA");
		assertEquals("state set", "IOWA", uv.getState());
		//fail("Not yet implemented");
	}
	
	
	@Test
	public void testgetLocation() {
		assertEquals("location found", "TOWNVILLE", uv.getLocation());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetLocation() {
		//suburban, urban, rural
		uv.setLocation("SUBURBAN");
		assertEquals("location set", "SUBURBAN", uv.getLocation());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetControl() {
		assertEquals("control found", "CONTROL", uv.getControl());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetControl() {
		uv.setControl("PRIVATE");
		assertEquals("control set", "PRIVATE", uv.getControl());
		//fail("Not yet implemented");
	}

	@Test
	public void testgetNumOfStudents() {
		assertTrue("#students found", 200 == uv.getNumOfStudents());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetNumOfStudents() {
		uv.setNumOfStudents(1000);
		assertTrue("#students set", 1000 == uv.getNumOfStudents());
		uv.setNumOfStudents(0);
		assertTrue("#students set to 0 valid", 0 == uv.getNumOfStudents());
		uv.setNumOfStudents(1);
		assertTrue("#students set to 1 valid", 1 == uv.getNumOfStudents());
		//fail("Not yet implemented");
	}
	
	@Test (expected=UnsupportedOperationException.class)
	public void testsetNumOfStudentsInvalid() {
		uv.setNumOfStudents(-1);
		assertTrue("#students set is invalid at -1", -1 == uv.getNumOfStudents());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetPercentFemale() {
		assertTrue("percentF found", 20 == uv.getPercentFemale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentFemale() {
		uv.setPercentFemale(72);
		assertTrue("percentF set", 72 == uv.getPercentFemale());
		uv.setPercentFemale(100);
		assertTrue("percentF set is valid at 100", 100 == uv.getPercentFemale());
		uv.setPercentFemale(0);
		assertTrue("percentF set is valid at 0", 0 == uv.getPercentFemale());
		//fail("Not yet implemented");
	}
	
	@Test (expected=UnsupportedOperationException.class)
	public void testsetPercentFemaleInvalid1() {
		uv.setPercentFemale(-1);
		assertTrue("percentF set is invalid at", -1 == uv.getPercentFemale());
		//fail("Not yet implemented");
	}
	
	@Test (expected=UnsupportedOperationException.class)
	public void testsetPercentFemaleInvalid2() {
		uv.setPercentFemale(101);
		assertTrue("percentF set is invalid at", 101 == uv.getPercentFemale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetSATVerbal() {
		assertTrue("SATv found", 200 == uv.getSATVerbal());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSATVerbal() {
		uv.setSATVerbal(100);
		assertTrue("SATv set", 100 == uv.getSATVerbal());
		uv.setSATVerbal(0);
		assertTrue("SATv set is valid at 0", 0 == uv.getSATVerbal());
		uv.setSATVerbal(800);
		assertTrue("SATv set is valid at 800", 800 == uv.getSATVerbal());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSATVerbalInvalid1() {
		uv.setSATVerbal(-1);
		assertTrue("SATv set is invalid at -1", -1 == uv.getSATVerbal());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSATVerbalInvalid2() {
		uv.setSATVerbal(801);
		assertTrue("SATv set is invalid at 801", 801 == uv.getSATVerbal());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetSATMath() {
		assertTrue("SATm found", 200 == uv.getSATMath());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSATmath() {
		uv.setSATMath(100);
		assertTrue("SATm set", 100 == uv.getSATMath());
		uv.setSATMath(0);
		assertTrue("SATm set is valid at 0", 0 == uv.getSATMath());
		uv.setSATMath(800);
		assertTrue("SATm set is valid at 800", 800 == uv.getSATMath());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSATMathInvalid1() {
		uv.setSATMath(-1);
		assertTrue("SATm set is invalid at -1", -1 == uv.getSATMath());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSATMathInvalid2() {
		uv.setSATVerbal(801);
		assertTrue("SATm set is invalid at 801", 801 == uv.getSATVerbal());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetExpenses() {
		assertTrue("expenses found", 4000 == uv.getExpenses());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetExpenses() {
		uv.setExpenses(5000);
		assertTrue("expenses set", 5000 == uv.getExpenses());
		uv.setExpenses(0);
		assertTrue("expenses set is valid at 0", 0 == uv.getExpenses());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetExpensesInvalid() {
		uv.setExpenses(-1);
		assertTrue("expenses set is invalid at -1", -1 == uv.getExpenses());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetPercentFinancialAid() {
		assertTrue("%fin aid found", 30 == uv.getPercentFinancialAid());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentFinancialAid() {
		uv.setPercentFinancialAid(35);
		assertTrue("%fin aid set", 35 == uv.getPercentFinancialAid());
		uv.setPercentFinancialAid(0);
		assertTrue("%fin aid set is valid at 0", 0 == uv.getPercentFinancialAid());
		uv.setPercentFinancialAid(100);
		assertTrue("%fin aid set is valid at 100", 100 == uv.getPercentFinancialAid());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentFinancialAidInvalid1() {
		uv.setPercentFinancialAid(101);
		assertTrue("%fin aid set is invalid at 101", 101 == uv.getPercentFinancialAid());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentFinancialAidInvalid2() {
		uv.setPercentFinancialAid(-1);
		assertTrue("%fin aid set is invalid at -1", -1 == uv.getPercentFinancialAid());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetNumOfApplicants() {
		assertTrue("#aplics found", 300 == uv.getNumOfApplicants());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetNumOfApplicants() {
		uv.setNumOfApplicants(400);
		assertTrue("#aplics set", 400 == uv.getNumOfApplicants());
		uv.setNumOfApplicants(0);
		assertTrue("#aplics set is valid at 0", 0 == uv.getNumOfApplicants());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetNumOfApplicantsInvalid() {
		uv.setNumOfApplicants(-1);
		assertTrue("#aplics set is invalid at -1", -1 == uv.getNumOfApplicants());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetPercentAdmitted() {
		assertTrue("%admtd found", 20 == uv.getPercentAdmitted());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentAdmitted() {
		uv.setPercentAdmitted(30);
		assertTrue("%admtd set", 30 == uv.getPercentAdmitted());
		uv.setPercentAdmitted(0);
		assertTrue("%admtd set is valid at 0", 0 == uv.getPercentAdmitted());
		uv.setPercentAdmitted(100);
		assertTrue("%admtd set is valid at 100", 100 == uv.getPercentAdmitted());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentAdmittedInvalid1() {
		uv.setPercentAdmitted(-1);
		assertTrue("%admtd set is invalid at -1", -1 == uv.getPercentAdmitted());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentAdmittedInvalid2() {
		uv.setPercentAdmitted(101);
		assertTrue("%admtd set is invalid at 101", 101 == uv.getPercentAdmitted());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetPercentEnrolled() {
		assertTrue("%enrolled found", 20 == uv.getPercentEnrolled());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentEnrolled() {
		uv.setPercentEnrolled(30);
		assertTrue("%enrolled set", 30 == uv.getPercentEnrolled());
		uv.setPercentEnrolled(0);
		assertTrue("%enrolled set is valid at 0", 0 == uv.getPercentEnrolled());
		uv.setPercentEnrolled(100);
		assertTrue("%enrolled set is valid at 100", 100 == uv.getPercentEnrolled());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentEnrolledInvalid1() {
		uv.setPercentEnrolled(101);
		assertTrue("%enrolled set is invalid at 101", 101 == uv.getPercentEnrolled());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentEnrolledInvalid2() {
		uv.setPercentEnrolled(-1);
		assertTrue("%enrolled set is invalid at -1", -1 == uv.getPercentEnrolled());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetAcademicScale() {
		assertTrue("academ scale found", 3 == uv.getAcademicScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetAcademicScale() {
		uv.setAcademicScale(7);
		assertTrue("academ scale set", 7 == uv.getAcademicScale());
		uv.setAcademicScale(0);
		assertTrue("academ scale set is valid at 0", 0 == uv.getAcademicScale());
		uv.setAcademicScale(10);
		assertTrue("academ scale set is valid at 10", 10 == uv.getAcademicScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetAcademicScaleInvalid1() {
		uv.setAcademicScale(-1);
		assertTrue("academ scale set is invalid at -1", -1 == uv.getAcademicScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetAcademicScaleInvalid2() {
		uv.setAcademicScale(11);
		assertTrue("academ scale set is invalid at 11", 11 == uv.getAcademicScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetSocialScale() {
		assertTrue("socScale found", 3 == uv.getSocialScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSocialScale() {
		uv.setSocialScale(6);
		assertTrue("soScale", 6 == uv.getSocialScale());
		uv.setSocialScale(0);
		assertTrue("soScale is valid at 0", 0 == uv.getSocialScale());
		uv.setSocialScale(10);
		assertTrue("soScale is valid at 10", 10 == uv.getSocialScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSocialScaleInvalid1() {
		uv.setSocialScale(-1);
		assertTrue("soScale is invalid at -1", -1 == uv.getSocialScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSocialScaleInvalid2() {
		uv.setSocialScale(11);
		assertTrue("soScale is invalid at 11", 11 == uv.getSocialScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetQualityOfLife() {
		assertTrue("qualLife found", 3 == uv.getQualityOfLife());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetQualityOfLife() {
		uv.setQualityOfLife(5);
		assertTrue("qualLife set", 5 == uv.getQualityOfLife());
		uv.setQualityOfLife(0);
		assertTrue("qualLife set is valid at 0", 0 == uv.getQualityOfLife());
		uv.setQualityOfLife(10);
		assertTrue("qualLife set is valid at 10", 10 == uv.getQualityOfLife());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetQualityOfLifeInvalid1() {
		uv.setQualityOfLife(-1);
		assertTrue("qualLife set is invalid at -1", -1 == uv.getQualityOfLife());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetQualityOfLifeInvalid2() {
		uv.setQualityOfLife(11);
		assertTrue("qualLife set is invalid at 11", 11 == uv.getQualityOfLife());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetEmphases() {
		ArrayList<String> name = new ArrayList<>();
		name.add("hoops");
		uv.setEmphases(name);
		assertEquals("emphases found", name, uv.getEmphases());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetEmphases1() {
		ArrayList<String> name = new ArrayList<>();
		name.add("biology");
		uv.setEmphases(name);
		assertEquals("emphases set1", name, uv.getEmphases());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetEmphases2() {
		ArrayList<String> name = new ArrayList<>();
		name.add("biology");
		name.add("math");
		uv.setEmphases(name);
		assertEquals("emphases set2", name, uv.getEmphases());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testtoString() {
		University u = new University("School", "State", "town", "control", 200, 20, 200, 200, 4000, 30, 300, 20, 20, 3, 3, 3);
		String s = "University [state=State, name=School, location=town, control=control, numOfStudents=200, percentFemale=20, SATVerbal=200, SATMath=200, expenses=4000, percentFinancialAid=30,numOfApplicants=300, percentAdmitted=20, percentEnrolled=20, academicScale=3,socialScale=3, qualityOfLife=3]";
		assertEquals("toString worked", s, u.toString());
		//fail("Not yet implemented");
	}

}
