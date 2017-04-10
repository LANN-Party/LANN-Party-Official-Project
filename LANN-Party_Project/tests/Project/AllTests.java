package Project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Admin_ControlerTest.class, AdminTest.class, DatabaseControllerTest.class, login_contTest.class,
		LogoutControllerTest.class, Search_ControlerTest.class, StudentTest.class, StudentUserInterfaceTest.class,
		UCTest.class, UniversityTest.class, UserControllerTest.class })
public class AllTests {

}
