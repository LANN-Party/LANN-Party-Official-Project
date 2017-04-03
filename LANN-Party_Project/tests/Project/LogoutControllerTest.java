/**
 * 
 */
package Project;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

/**
 * @author nmhynesmarquette
 *
 */
public class LogoutControllerTest {

	private LogoutController loc;
	private login_cont lic;
	
	@Before
	public void setUp() throws Exception {
		loc = new LogoutController();
		lic = new login_cont();
	}
	
	@Test
	public void teststudentLogout() {
		lic.logon("ajmac", "password", true);
		assertTrue(loc.studentLogout("ajmac"));
	}
	
	@Test
	public void testadminLogout(){
		lic.logon("nadmin", "admin", true);
		assertTrue(loc.adminLogout("nadmin"));
	}

}
