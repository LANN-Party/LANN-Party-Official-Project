package Project;
 /**
  * FileName: userController.java
  */
 
 /**
  * Class dedicated to users who are Students
  * @author Noah Hynes-Marquette
  * @version 2/25/2017
  *
  */
	public class UserController {
		
		public Object[] schools;
		
		DatabaseController dc = new DatabaseController();
		LogoutController lc = new LogoutController();
		
		  
		public UserController() {
			super();
		}
		  
		  /**
		   * Displays profile information to Student user   
		   * 
		   * @param uName; String, user name of the user
		   */
		  public void displayProfile(String uName)
		  {
		    //TODO: use name given to get the user's information from DB
			//TODO: use information received and display it to the user
			System.out.println(dc.getUser(uName));
		  }

		  /**
		   * receives entries for possible changes in the specific
		   * Student's profile
		   * 
		   * @param uName; String, username of the user (cannot be changed here)
		   * @param fName; String, first name of the user
		   * @param lName; String, last name of the user
		   * @param pWord; String, the user's password
		   * @param type; char, type of user (Admin or Student)
		   * @param status; char, whether or not the user is logged (will never be changed here)
		   */
		  public void editInfo(String uName, String fName, String lName, String pWord, char type, char status)
		  {
		    //TODO: displays the user's information with text boxes to enter or change previous information
			//TODO: if user selects the option to "Save Changes" call confirmSaveChanges
			dc.editUser(uName, fName, lName, pWord, type, status);
		  }
		  /*
		  /**
		   * Saves new user info given to the specific Student's profile
		   * 
		   * @param uName; String, username of the user (will never be changed here)
		   * @param fName; String, first name of the user
		   * @param lName; String, last name of the user
		   * @param pWord; String, the user's password
		   * @param type; char, type of user (Admin or Student)
		   * @param status; char, whether or not the user is logged (will never be changed here)
		   */
		  /*IGNORE for phase 2
		  public void confirmSaveChanges(String uName, String fName, String lName, String pWord, char type, char status)
		  {
		    //TODO: show message box to user asking if they wish to continue with the action
			//TODO: if user clicks yes, call confirmSave() in StudentUserInterface
			//TODO: if user clicks cancel, call cancel() in StudentUserInterface
		  }
		  */

		  /**
		   * Displays schools saved to the specific Student user's
		   * profile
		   * 
		   * @param none
		   */
		  public void displaySavedSchools()
		  {
		    //TODO: get list of saved schools from DB
			//dc.getSchools();
			//TODO: display list of saved schools
			System.out.println(dc.getSchools());
		  }
		  
		  /**
		   * sends selected school to database to be removes from their profile
		   * 
		   * @param uName : String, name of user
		   * @param school : name of school to remove
		   */
		  public void removeSchool(String uName, String school)
		  {
		    //TODO: when this button is clicked, call removeConfirmed
			  dc.removeSavedSchool(uName, school);
		  }
		  /*
		  /**
		   * Send confirmation message to Student user asking
		   * whether they confirm their removal request
		   * 
		   * @param none
		   */
		  /*IGNORE for phase 2
		  public void removeConfirmed()
		  {
		    //TODO: send message to user asking if they wish to continue
			//TODO: if the user clicks to continue, send to confirm remove in SUI
			//TODO: if the user clicks to not continue, go back to the previous screen and change nothing
			//TODO: for both cases, once an option is picked, go back to previous screen
		  }
		  */
		  
		  /**
		   * Adds the given object to the user's list of saved schools through DatabaseController
		   * 
		   * @param university; University, the university selected by the user that will be saved in the
		   * 								user's profile
		   */
		  public void saveSchool (University university)
		  {
			dc.saveSchool(university);
		  }
		  
		  /**
		   * Unsets user (and saves changes??)
		   * 
		   * @param none
		   */
		  public void logout()
		  {
			//send call to logout controller
			lc.studentLogout();
		  }
	
	}
