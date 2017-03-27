package Project;

import java.util.ArrayList;

//github.com/LANN-Party/LANN-Party-Official-Project.git
/**
 * Interface for users who are Admins
 * @author njfloeder
 * @version 3/27/2017
 */
public class AdminUI {
	
	private Admin_Controler AC;
	private LogoutController lc;
	
	/**
	 * Constructor, creates an instance of AdminUI
	 */
	public AdminUI(){
		AC = new Admin_Controler();
		lc = new LogoutController();
	}
	
	/**
	 * views all users
	 */
	public void viewusers()
	{	
		AC.viewUsers();
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
	public boolean editUser(String uName, String fName, String lName, String pWord, 
char type, char status){
		
		return AC.editUser(uName, fName, lName, pWord, type, status);

	}
	
	/**
	 * lets on delete a user from their username
	 * 
	 * @param uName username for user
	 */
	public boolean deleteUser(String uName){
		return AC.deleteUser(uName);
	}
	
	/**
	 * 
	 * @param uName suername of user to be deactivated
	 * @return true if user is deactivated, false otherwise
	 */
	public boolean deactivateUser(String uName){
		return AC.deactivateUser(uName);
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
	public boolean addUser(String uName, String fName, String lName, String pWord, 
			char type, char status){
		
		return AC.addUser( uName,  fName,  lName,  pWord, type,  status);
	}
	
	
	/**
	*lets you view all schools
	 */
	public void viewSchools(){
		AC.displaySchools();
	}
	
	/**
	 * lets you veiw a selected user from screen 
	 * 
	 * @param uName : String, user name of user profile to view
	 */
	public void veiwUser(String uName){
		AC.displayProfile(uName);
	}
	/**
	 * lets you veiw one selected school from screen
	 */
	public void viewSchool(String uName){
		AC.displaySchool(uName);
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
	public boolean editSchool(String name, String state, String location, String control, int numberOfStudents, 
			double percentFemales, double satVerbal, double satMath, double expenses, double percentFinAid, int applicants,
			double percentAdmitted, double percentEnrolled, int academScale, int socialScale, 
		    int qualOfLife){
				
				return AC.editSchool(name, state, location, control, numberOfStudents, percentFemales, satVerbal, satMath, expenses, percentFinAid, applicants, percentAdmitted, percentEnrolled, academScale, socialScale, qualOfLife);
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
	 public boolean addSchool(String name, String state, String location, String control, int numberOfStudents, 
			   double percentFemales, double satVerbal, double satMath, double expenses, double percentFinAid, int applicants,
			   double percentAdmitted, double percentEnrolled, int academScale, int socialScale, 
			   int qualOfLife)
			  {
		 		return AC.addSchool(name, state, location, control, numberOfStudents, percentFemales, satVerbal, satMath, expenses, percentFinAid, applicants, percentAdmitted, percentEnrolled, academScale, socialScale, qualOfLife);
			  }
	 
	 /**
       * Adds a emphasis to the university
	   * 
	   * @param school, university to select
	   * @param emph, a new emphasis
	   */
	public void addEmphasis(String school, String emph){
		AC.addEmphasis(school, emph);
		}
	 
	/**
	 * Adds a emphasis to the university
	 * 
	 * @param school, university to select
	 * @param emph, a new emphasis
	 */
	public void removeEmphasis(String school, String emph){
		AC.removeEmphasis(school, emph);
		}
	 /*IGNORE for phase 2
	/**
	 * cancle an action in progress
	 */
	 /*
	public void cancel(){
	
		
	}
	*/
	/**
	 * lets you logout from the current screen
	 */
	public void logout(String uName){
		lc.adminLogout(uName);
		
	}
	
	public void getEmphases(String school){
		AC.getEmphases(school);
	}
	

}