package Project;

/**
 * controller for the login and logout of a user
 * @author ajmcintyre
 * @version 3/27/17
 * @filename: LogoutController.java
 */
public class LogoutController {
	private DatabaseController dc;
	
	public LogoutController() {
		dc = new DatabaseController("lannp","lannp","csci230");
	}
	/**
	 * @param s the student object to be logged out
	 */
	public void studentLogout(String uName){
		Student s = dc.getUser(uName);
		s.setLogon(false);
		if(!s.isLoggedOn())
			System.out.println("Logged Off");
	}
	
	/**
	 * 
	 * @param a the admin object to be logged out
	 */
	public void adminLogout(String uName){
		Admin a = dc.getAdmin(uName);
		a.setLogon(false);;
		if(!a.isLogon())
			System.out.println("Logged Off");
	}

}
