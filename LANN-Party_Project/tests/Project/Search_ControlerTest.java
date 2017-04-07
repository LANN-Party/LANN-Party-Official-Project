/**
 * 
 */
package Project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * @author nmhynesmarquette
 *
 */
public class Search_ControlerTest {
	private Search_Controler sc;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		sc = new Search_Controler();
	}
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	

	@Test
	public void testdisplaySearchResultsEmptyForBadName() {
		sc.displaySearchResults("jfdkslf", null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultsOnlyName() {
		sc.displaySearchResults("CORNELL", null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultsFailsForWrongState() {
		sc.displaySearchResults("CORNELL", "MINNESOTA", null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultNameState() {
		sc.displaySearchResults("CORNELL", "NEW YORK", null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultFailsForWrongLoc() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "URBAN", null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultNameStateLoc() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongControl() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PUBLIC", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultNSLC() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxPopulation() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 5000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxP() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinPop() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 27000, 26000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmnP() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxPercFemale() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxPF() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinPercFemale() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmPF() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxSATV() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxSATV() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinSATV() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 620, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmnSATV() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxSATM() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxSATM() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinSATM() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 660, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmnSATM() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxExpenses() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 40000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxExp() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinExpenses() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 44000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmnExp() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxPFin() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxPFin() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinPFin() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmnPFin() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxNumApp() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 15000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxNA() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinNumApp() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 19000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmnNA() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxPercAdmit() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxPA() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinPercAdmit() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 35, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmnPA() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxPercEnr() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 30, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxPE() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinPercEnr() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 10000, 40, 25, 60, 55, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmnPE() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxAcSc() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 3, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxAS() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 0, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinAcSc() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 6, 0, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmnAS() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 0, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxSocSc() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 1, 0, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxSS() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 0, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinSocSc() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 4, 0, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmnSS() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 0, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMaxQual() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 1, 0, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmxQ() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 0, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongMinQual() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 3, null, null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultmnQ() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 1, null, null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongEmph1() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 1, "BUSINESS", null, null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultEmph1() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 1, "AGRICULTURE", null, null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongEmph2() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 1, "AGRICULTURE", "adfsa", null, null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultEmph2() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 1, "AGRICULTURE", "ARCHITECTURE", null, null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongEmph3() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 1, "AGRICULTURE", "ARCHITECTURE", "dfsadfs", null, null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultEmph3() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 1, "AGRICULTURE", "ARCHITECTURE", "ARTS-AND-SCIENCES", null, null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongEmph4() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 1, "AGRICULTURE", "ARCHITECTURE", "ARTS-AND-SCIENCES", "fdsafds", null);
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultEmph4() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 1, "AGRICULTURE", "ARCHITECTURE", "ARTS-AND-SCIENCES", "ENGINEERING", null);
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultWrongEmph5() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 1, "AGRICULTURE", "ARCHITECTURE", "ARTS-AND-SCIENCES", "ENGINEERING", "fdsaf");
		String s = "";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testdisplaySearchResultEmph5() {
		sc.displaySearchResults("CORNELL", "NEW YORK", "SMALL-CITY", "PRIVATE", 26000, 24000, 55, 40, 630, 590, 670, 640, 45000, 40000, 70, 40, 20000, 15000, 40, 25, 60, 40, 5, 2, 5, 2, 3, 1, "AGRICULTURE", "ARCHITECTURE", "ARTS-AND-SCIENCES", "ENGINEERING", "HOTEL-ADMINISTRATION");
		String s = "CORNELL";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test
	public void testviewSchool() {
		sc.viewSchool("AUGSBURG");
		String s = "NEWYORK IT"
				+ "\nHOFSTRA"
				+ "\nUNIVERSITY OF MAINE"
				+ "\nUNIVERSITY OF SOUTHERN CALIFORNIA"
				+ "\nUNIVERSITY OF EVANSVILLE";
		assertEquals(s, outContent.toString().trim());
	}
	
	@Test (expected= NullPointerException.class)
	public void testviewSchoolFailsForWrongSchool(){
		ArrayList<University> u = sc.viewSchool("FDAFSD");
	}

}
