/**
 * FileName: login_cont.java
 */
package Project;
import java.util.*;
/**
 * A controller to login the users, admin or student
 * @author lrdahlquist
 * @version 3/19/17
 *
 */
public class login_cont {
	DatabaseController dc;
	
	public login_cont(){
		dc = new DatabaseController("lannp", "lannp", "csci230");
	}
	/**
	 * Logs the user in
	 * 
	 * @param String username, password
	 * @param boolean steal
	 */
	
	public void logon(String username, String password, boolean steal)
	{
			Student s = dc.getUser(username);
			Admin a = dc.getAdmin(username);
			if(s != null){
				if(password == s.getPassword()){
					if(!s.isLoggedOn()){
						s.setLogon(true);
					}
					else{
						Scanner scan = new Scanner(System.in);
						System.out.println("You are already logged in, would you like to steal the session");
						System.out.println("Enter Yes / No");
						String input=scan.nextLine();
						scan.close();
						if (input.equals("Yes") || input.equals("yes")){
/*Change? Redundant*/			s.setLogon(true);
						}
						else{
							loginFail();
						}
					}
				}
				else{
					loginFail();
				}
			}
			else if(a != null){
				if(password == s.getPassword()){
					if(!s.isLoggedOn()){
						s.setLogon(true);
					}
					else{
						Scanner scan = new Scanner(System.in);
						System.out.println("You are already logged in, would you like to steal the session");
						System.out.println("Enter Yes / No");
						String input=scan.nextLine();
						scan.close();
						if (input.equals("Yes") || input.equals("yes")){
	/*Change? Redundant*/			s.setLogon(true);
						}
						else{
							loginFail();
						}
					}
				}
				else{
					loginFail();
				}
			}
		else
			loginFail();
	}
	
	/**
	 * Notifies the user that the login failed
	 * 
	 */
	
	public void loginFail()
	{
		System.out.println("Login failed, please try again");
	}

}
