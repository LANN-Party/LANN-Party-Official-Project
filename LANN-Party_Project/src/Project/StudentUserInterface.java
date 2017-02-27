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
	
	//Data fields
	/**confirmation from user*/
	boolean confirm;
	
	//Data fields
	/**results from search*/
	String searchResults;
	
	/**
	 * displays Student user's profile
	 * 
	 * @param none
	 */
	public void viewProfile(){
		
	}
	
	/**
	 * displays schools saved to student user's profile
	 * 
	 * @param none
	 */
	public void viewSavedSchools(){
		
	}
	
	/**
	 * allows the Student user to make changes to their profile 
	 * information before finalizing the changes
	 * 
	 * @param uName
	 * @param fName
	 * @param lName
	 * @param pWord
	 * @param type
	 * @param status
	 */
	public void editInfo(String uName, String fName, String lName, 
			String pWord, Char type, Char status){
		
	}
	
	/**
	 * displays information of selected school
	 * 
	 * @param none
	 */
	public void viewSchool(){
		
	}
	
	/**
	 * removes selected school from the Student user's profile
	 * 
	 * @param none
	 */
	public void removeSchool(){
		
	}
	
	/**
	 * Gets confirmation from user to delete selected school
	 * 
	 * @return
	 */
	public boolean confirmRemove(){
		return false;
	}
	
	/**
	 * Shows results for name of school given from the user
	 * 
	 * @param name
	 */
	public void searchSchool(String name){
		
	}
	
	/**
	 * Adds selected school to Students saved schools
	 * 
	 * @param university
	 */
	public void saveSchool(University university){
		
	}
	
	/**
	 * gets confirmation to save selected school to the
	 * Students saved schools
	 * 
	 * @return
	 */
	public boolean confirmSave(){
		return false;
	}
	
	/**
	 * gets cancel option so the selected school is not saved to 
	 * 
	 * @param none
	 */
	public void cancelSave(){
		
	}
	
	/**
	 * Cancel option is presented to user
	 * 
	 * @param none
	 */
	public void cancel(){
		
	}
}
