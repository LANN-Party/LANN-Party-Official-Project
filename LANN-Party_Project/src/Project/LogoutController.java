package Project;

/**
 * @author ajmcintyre
 * @version 2/27/17
 * @filename: LogoutController.java
 */
public class LogoutController {
	
	
	public LogoutController() {
		super();
	}
	/**
	 * @param s the student object to be logged out
	 */
	public void studentLogout(Student s){
		s.setLogon(false);
	}
	
	/**
	 * 
	 * @param a the admin object to be logged out
	 */
	public void adminLogout(Admin a){
		a.setLogon(false);
	}

}
