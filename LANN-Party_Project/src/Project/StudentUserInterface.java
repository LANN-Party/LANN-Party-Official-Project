package Project;
import java.util.*;
 /**
  * FileName: StudentUserInterface.java
  */
 
 /**
  * interface dedicated to users who are Students
  * @author Noah Hynes-Marquette
  * @version 3/19/2017
  *
  */
public class StudentUserInterface {
	
	UserController uc = new UserController();
	Search_Controler sc = new Search_Controler();
	//Data fields
	/**confirmation from user*/
	boolean confirm;
	
	//Data fields
	/**results from search*/
	String searchResults;
	
	/**
	 * displays Student user's profile
	 * 
	 * @param uName; String, user name of student to get information on
	 */
	public void viewProfile(String fName)
	{
		//telling UserController to show information on the given student
		uc.displayProfile(fName);
	}
	
	/**
	 * calls UserController to display the user's saved schools
	 * 
	 * @param uName : String, user name of student to get saved schools from
	 */
	public void viewSavedSchools(String uName)
	{
		uc.displaySavedSchools(uName);
	}
	
	/**
	 * allows the Student user to make changes to their profile 
	 * information before finalizing the changes
	 * 
	 * @param uName; String, username of the user (cannot be changed here)
     * @param fName; String, first name of the user
	 * @param lName; String, last name of the user
	 * @param pWord; String, the user's password
	 * @param type; char, type of user (Admin or Student)
	 * @param status; char, whether or not the user is logged (will never be changed here)
	 */
	public boolean editInfo(String uName, String fName, String lName, String pWord, char type, char status)
	{
		return uc.editInfo(uName, fName, lName, pWord, type, status);
	}
	
	/**
	 * displays information of selected school
	 * 
	 * @param sName : String, school name
	 */
	public void viewSchool(String sName)
	{
		System.out.println(uc.displaySchool(sName).toString());
	}
	
	/**
	 * removes selected school from the Student user's profile
	 * 
	 * @param uName : String, name of student to save school to
	 * @param schoolName : String, name of school to add
	 */
	public boolean removeSchool(String uName, String sName)
	{
		return uc.removeSchool(uName, sName);
	}
	
	/*
	/**
	 * Gets confirmation from user to delete selected school
	 * 
	 * @return
	 */
	/*IGNORE for phase 2
	public boolean confirmRemove()
	{
		//TODO: send selected school to removeSavedSchool() in DatabaseController
		return false;
	}
	*/
	/**
	 * Shows results for name of school given from the user
	 * 
	 * @param name; String, name of school
	 */
	public void searchSchool(String name)
	{
		//TODO: access search controller and give  list of schools
		System.out.println(uc.searchSchool(name).toString());
		ArrayList<University> univ = sc.viewSchool(name);
		for(University u : univ){
			System.out.println(u.getName());
		}
	}
	
	/**
	 * Adds selected school to Students saved schools
	 * 
	 * @param uName : String, user name of student
	 * @param sName : String, name of school to save
	 * 
	 */
	public boolean saveSchool(String uName, String sName)
	{
		//sending University object to be sorted in the UserController
		return uc.saveSchool(uName, sName);
	}
	
	/**
	 * gets confirmation to save selected school to the
	 * Students saved schools
	 * 
	 * @return
	 */
	/*IGNORE for phase 2
	public boolean confirmSave()
	{
		//TODO: set the old user object and then return to previous screen
		return false;
	}
	8?
	/**
	 * gets cancel option so the selected school is not saved to 
	 * 
	 * @param none
	 */
	/*IGNORE for phase 2
	public void cancelSave()
	{
		//do we need this method?
	}
	*/
	/**
	 * Cancel option is presented to user
	 * 
	 * @param none
	 */
	/*IGNORE for phase 2
	public void cancel()
	{
	   
	   //TODO: bring user back to screen presented before cancel was selected
	}
	*/
}
