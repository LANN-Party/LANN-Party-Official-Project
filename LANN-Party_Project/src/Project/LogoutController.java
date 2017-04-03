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
	public boolean studentLogout(String uName){
		Student s = dc.getUser(uName);
		if(s==null)
			return false;
		s.setLogon(false);
		if(!s.isLoggedOn()){
			System.out.println("Logged Off");
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param a the admin object to be logged out
	 */
	public boolean adminLogout(String uName){
		Admin a = dc.getAdmin(uName);
		if(a==null)
			return false;
		a.setLogon(false);;
		if(!a.isLogon()){
			System.out.println("Logged Off");
			return true;
		}
		return false;
	}

}
