/**
 * File: FirstDriver.java
 * 
 * LANN-Party
 * 
 * description: The first driver for the project
 * version: 3/20/2017
 */

package Project;

public class FirstDriver {

	private LoginUI login = new LoginUI();
	private AdminUI adminUI = new AdminUI();
	private StudentUserInterface studentUI = new StudentUserInterface();
	
	public FirstDriver(){
		super();
	}
	
	public void run(){
		login.registerStudent("Andrew", "McIntyre", "ajmac", "password", 'u', 'n');
		login.logon("ajmac", "password", true);
		/**
		if(login.registerStudent("Andrew", "McIntyre", "ajmac", "password", 'u', 'n')){
			login.logon("ajmac", "password", true);
		}
		else{
			System.out.println("Registration Failed");
			System.exit(0); //TODO change this later
		}
		**/
		
		studentUI.viewProfile("ajmac");
		studentUI.editInfo("ajmac", "Bob", "McIntyre", "password", 'u', 'n');
		studentUI.viewProfile("ajmac");
		studentUI.editInfo("ajmac", "Andrew", "McIntyre", "password", 'u', 'n');
		
		studentUI.searchSchool("AUGSBURG");	
		studentUI.saveSchool("ajmac", "AUGSBURG");
		studentUI.viewSavedSchools("ajmac");
		
		login.studentLogout("ajmac");
		
		login.logon("nadmin", "admin", true);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstDriver fD = new FirstDriver();
		fD.run();
	}

}
