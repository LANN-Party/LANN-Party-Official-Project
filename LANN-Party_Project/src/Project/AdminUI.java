package Project;

import java.util.ArrayList;

//github.com/LANN-Party/LANN-Party-Official-Project.git
/**
 * @author njfloeder
 *
 *
 *
 */
public class AdminUI {
	
	private Admin_Controler AC = new Admin_Controler();
	
	private boolean u,c;
	
	private University svhool;
	
	private Object check;

	/**
	 * constructor
	 */
	public AdminUI(){
		
	}
	
	/**
	 * views all users
	 */
	public void viewusers(){
		
		AC.displayProfile();
		
	}
	/**
	 * allows admin to edit a user from their information
	 * 
	 * @param uName username of user
	 * @param fName first name of user
	 * @param lName last name of user
	 * @param pWord password for user to log in 
	 * @param type either a user is admin or student
	 * @param status if they are signed in or not
	 */
	public void editUser(String uName, String fName, String lName, String pWord, 
char type, char status,ArrayList<University> savedSchools){
		
		AC.saveChanges( uName,  fName,  lName,  pWord,  type,  status, savedSchools);

	}
	
	/**
	 * lets on deactivate a user from their username
	 * 
	 * @param uName username for user
	 */
	public void deactivateUser(String uName){
		AC.deleteUser(uName);
	}
	
	/**
	 * lets one add in a new user
	 * 
	  * @param uName username of user
	 * @param fName first name of user
	 * @param lName last name of user
	 * @param pWord password for user to log in 
	 * @param type either a user is admin or student
	 * @param status if they are signed in or not
	 */
	public void addUser(String uName, String fName, String lName, String pWord, 
			char type, char status){
		
		AC.addUser( uName,  fName,  lName,  pWord, type,  status);
	}
	
	
	/**
	*lets you view all schools
	 */
	public void viewSchools(){
		AC.displaySchools();
	}
	
	/**
	 * lets you veiw a selected user from screen 
	 */
	public void veiwUser(){
		AC.displayProfile();
	}
	/**
	 * lets you veiw one selected school from screen
	 */
	public void viewSchool(){
		AC.displaySchool();
	}
	/**
	 * saves changes made with a user
	 * 
	  * @param uName username of user
	 * @param fName first name of user
	 * @param lName last name of user
	 * @param pWord password for user to log in 
	 * @param type either a user is admin or student
	 * @param status if they are signed in or not
	 */
	
	public void saveChanges(String uName, String fName, String lName, String pWord, 
			char type, char status,ArrayList<University> savedSchools){
		
		AC.saveChanges( uName,  fName,  lName,  pWord,  type,  status, savedSchools);
	}
	/**
	 * lets a school to be edited
	 * 
	 * @param state where the university is located
	 * @param name, Name of the school
	 * @param location where the school is 
	 * @param control type of school(private vs public)
	 * @param percentF percent of female students 
	 * @param SATVerbal, sat score for virbal section 
	 * @param SATMath, sat score for the math catagory
	 * @param expenses the expensive for the school
	 * @param numberOfApp, number of applicants to the school
	 * @param percentAdmitted, percent admitted to the schol
	 * @param academicScale, the level they would give the school for academics
	 * @param qualityOfLiffe, csale from 1-10 of how a user would rate the quality of life
	 * @param emphases, emphases at the school
	 */   
	public void editSchool(String name, String state, String location, String control, int numberOfStudents, 
			double percentFemales, int satVerbal, int satMath, double expenses, double percentFinAid, int applicants,
			double percentAdmitted, double percentEnrolled, int academScale, int socialScale, 
		    int qualOfLife, String emphasis1, String emphasis2, String emphasis3, String emphasis4, String emphasis5){
				
				AC.editSchool(name, state, location, control, numberOfStudents, percentFemales, satVerbal, satMath, expenses, percentFinAid, applicants, percentAdmitted, percentEnrolled, academScale, socialScale, qualOfLife, emphasis1, emphasis2, emphasis3, emphasis4, emphasis5);
			}
	/**
	 * confirms the changes were made 
	 * @return true or false if the changes were made
	 */
	public boolean confirmChanges(){
		
	return false;	
	
	}
	/**
	 * add a school with params
	 * 
		 * @param state where the university is located
	 * @param name, Name of the school
	 * @param location where the school is 
	 * @param control type of school(private vs public)
	 * @param percentF percent of female students 
	 * @param SATVerbal, sat score for virbal section 
	 * @param SATMath, sat score for the math catagory
	 * @param expenses the expensive for the school
	 * @param numberOfApp, number of applicants to the school
	 * @param percentAdmitted, percent admitted to the schol
	 * @param academicScale, the level they would give the school for academics
	 * @param qualityOfLiffe, csale from 1-10 of how a user would rate the quality of life
	 * @param emphases, emphases at the school
	 */
	 public void addSchool(String name, String state, String location, String control, int numberOfStudents, 
			   double percentFemales, int satVerbal, int satMath, double expenses, double percentFinAid, int applicants,
			   double percentAdmitted, double percentEnrolled, int academScale, int socialScale, 
			   int qualOfLife, String emphasis1, String emphasis2, String emphasis3, String emphasis4, String emphasis5)
			  {
		 		AC.addSchool(name, state, location, control, numberOfStudents, percentFemales, satVerbal, satMath, expenses, percentFinAid, applicants, percentAdmitted, percentEnrolled, academScale, socialScale, qualOfLife, emphasis1, emphasis2, emphasis3, emphasis4, emphasis5);
			  }
	/**
	 * cancle an action in progress
	 */
	public void cancel(){
	
		
	}
	/**
	 * lets you logout from the current screen
	 */
	public void logout(){
		
		
	}
	

}