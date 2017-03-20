package Project;
 /**
  * FileName: StudentUserInterface.java
  */
 
 /**
  * Class dedicated to users who are Students
  * @author Noah Hynes-Marquette
  * @version 2/26/2017
  *
  */
public class StudentUserInterface {
	
	UserController uc = new UserController():
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
	public void viewProfile(String uName)
	{
		//telling UserController to show information on the given student
		uc.displayProfile(uName);
	}
	
	/**
	 * calls UserController to display the user's saved schools
	 * 
	 * @param none
	 */
	public void viewSavedSchools()
	{
		uc.displaySavedSchools();
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
	public void editInfo(String uName, String fName, String lName, 
			String pWord, char type, char status)
	{
		uc.editInfo(uName, fName, lName, pWord, type, status);
	}
	
	/**
	 * displays information of selected school
	 * 
	 * @param sName : String, school name
	 */
	public void viewSchool(String sName)
	{

	}
	
	/**
	 * removes selected school from the Student user's profile
	 * 
	 * @param university: University, school to remove from saved list
	 */
	public void removeSchool(University university)
	{
		uc.removeSchool(university);
	}
	
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
		
	}
	
	/**
	 * Adds selected school to Students saved schools
	 * 
	 * @param university; University, the school chosen to be saved to the student's profile
	 */
	public void saveSchool(University university)
	{
		//sending University object to be sorted in the UserController
		uc.saveSchool(university);
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
