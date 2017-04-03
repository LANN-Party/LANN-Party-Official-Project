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
	public void testUniversity() {
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetState() {
		assertEquals("state found", uv.getState());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetState() {
		uv.setState("IOWA");
		assertEquals("state set", "IOWA", uv.getState());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetName() {
		assertEquals("name found", uv.getName());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetName() {
		uv.setName("random name");
		assertEquals("name set","random name", uv.getName());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetLocation() {
		assertEquals("location found", uv.getLocation());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetLocation() {
		uv.setLocation("Orangeville");
		assertEquals("location set", "Orangeville", uv.getLocation());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetControl() {
		assertEquals("control found", uv.getControl());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetControl() {
		uv.setControl("anatomy");
		assertEquals("control set", "anatomy", uv.getControl());
		//fail("Not yet implemented");
	}

	@Test
	public void testgetNumOfStudents() {
		assertEquals("#students found", uv.getNumOfStudents());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetNumOfStudents() {
		uv.setNumOfStudents(1000);
		assertTrue("#students set", 1000 == uv.getNumOfStudents());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetPercentFemale() {
		assertEquals("percentF found", uv.getPercentFemale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentFemale() {
		uv.setPercentFemale(72);
		assertTrue("percentF set", 72 == uv.getPercentFemale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetSATVerbal() {
		assertEquals("SATv found", uv.getSATVerbal());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSATVerbal() {
		uv.setSATVerbal(100);
		assertTrue("SATv set", 100 == uv.getSATVerbal());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetSATMath() {
		assertEquals("SATm found", uv.getSATMath());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSATmath() {
		uv.setSATMath(100);
		assertTrue("SATm set", 100 == uv.getSATMath());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetExpenses() {
		assertEquals("expenses found", uv.getExpenses());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetExpenses() {
		uv.setExpenses(5000);
		assertTrue("expenses set", 5000 == uv.getExpenses());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetPercentFinancialAid() {
		assertEquals("%fin aid found", uv.getPercentFinancialAid());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentFinancialAid() {
		uv.setPercentFinancialAid(35);
		assertTrue("%fin aid set", 35 == uv.getPercentFinancialAid());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetNumOfApplicants() {
		assertEquals("#aplics found", uv.getNumOfApplicants());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetNumOfApplicants() {
		uv.setNumOfApplicants(400);
		assertTrue("#aplics set", 400 == uv.getNumOfApplicants());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetPercentAdmitted() {
		assertEquals("%admtd found", uv.getPercentAdmitted());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentAdmitted() {
		uv.setPercentAdmitted(30);
		assertTrue("%admtd set", 30 == uv.getPercentAdmitted());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetPercentEnrolled() {
		assertEquals("%enrolled found", uv.getPercentEnrolled());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetPercentEnrolled() {
		uv.setPercentEnrolled(30);
		assertTrue("%enrolled set", 30 == uv.getPercentEnrolled());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetAcademicScale() {
		assertEquals("academ scale found", uv.getAcademicScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetAcademicScale() {
		uv.setAcademicScale(7);
		assertTrue("academ scale set", 7 == uv.getAcademicScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetSocialScale() {
		assertEquals("socScale found", uv.getSocialScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetSocialScale() {
		uv.setSocialScale(6);
		assertTrue("soScale", 6 == uv.getSocialScale());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetQualityOfLife() {
		assertEquals("qualLife found", uv.getQualityOfLife());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetQualityOfLife() {
		uv.setQualityOfLife(5);
		assertTrue("qualLife set", 5 == uv.getQualityOfLife());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testgetEmphases() {
		ArrayList<String> name = new ArrayList<>();
		name.add("hoops");
		uv.setEmphases(name);
		assertEquals("emphases found", uv.getEmphases());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetEmphases1() {
		ArrayList<String> name = new ArrayList<>();
		name.add("biology");
		uv.setEmphases(name);
		assertEquals("emphases set", "biology", uv.getEmphases());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testsetEmphases2() {
		ArrayList<String> name = new ArrayList<>();
		name.add("biology");
		name.add("math");
		uv.setEmphases(name);
		assertEquals("emphases set", name, uv.getEmphases());
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
