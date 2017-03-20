/**
 * 
 */
package Project;

/**
 * interface for logging in Admin's and Students
 * @author lrdahlquist
 * @version 3/19/17
 */

public class LoginUI {
	private login_cont login;
	private LogoutController logout;
	
	/**
	 * constructor for the LoginUI
	 */
	public LoginUI() {
		this.login = new login_cont();
		this.logout = new LogoutController();
	}
	
	/**
	 * Calls logon in the login_cont
	 * @param userName,    userName
	 * @param pass, password
	 * @param steal, boolean for whether or no to steal the session
	 */
	public void logon(String userName, String pass, boolean steal){
		this.login.logon(userName, pass, steal);
	}
	
	
	/**
	 * logs out student
	 * @param s, student
	 */
	public void studentLogout(Student s){
		this.logout.studentLogout(s);
	}
	
	/**
	 * logs out Admin
	 * @param s, Admin
	 */
	public void adminLogout(Admin a){
		this.logout.adminLogout(a);
	}
	
	
	
}
