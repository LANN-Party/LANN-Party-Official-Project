package Project;
 /**
  * FileName: DatabaseController.java
  */
 
 /**
  * Class dedicated to all information in the system
  * @author Noah Hynes-Marquette
  * @version 2/25/2017
  *
  */
public class DatabaseController {
	  
	  //Data fields
	   /**All created schools*/
	  University school;
	  
	  //Data fields
	  /**All created users*/
	  User users;
	  
	  /**
	   * Displays all users in the database  
	   * 
	   * @param none
	   */
	  public User getUsers()
	  {
	    return null;
	  }
	  
	  /**
	   * Once given the information needed for a new user,
	   * it creates a new Student or Admin user
	   * 
	   * @param uName
	   * @param fName
	   * @param lName
	   * @param pWord
	   * @param type
	   * @param status
	   */
	  public void addUser(String uName, String fName, String lName, String pWord, Char type, Char status)
	  {
	  
	  }
	  
	  /**
	   * Deletes selected user from the database   
	   * 
	   * @param none
	   */
	  public void deleteUser(String uName)
	  {
	    
	  }
	  
	  /**
	   * Removes selected school from database 
	   * 
	   * @param university
	   */
	  public void removeSchool(University university)
	  {
	    
	  }
	  
	  /**
	   * Saves school and it's information to database   
	   * 
	   * @param university
	   */
	  public void saveSchool(University university)
	  {
	    return null;
	  }
	  
	  /**
	   * Gets selected user's information   
	   * 
	   * @param uName
	   */
	  public User getUser(String uName)
	  {
	    return null;
	  }
	  
	  /**
	   * Gets selected schools' information  
	   * 
	   * @param name
	   */
	  public University getSchool(String name)
	  {
	    return null;
	  }
	  
	  /**
	   * Displays schools with related information   
	   * 
	   * @param university
	   */
	  public University getRelatedSchool(University university)
	  {
	    return null;
	  }
	  
	  /**
	   * Gets school's information  
	   * 
	   * @param university
	   */
	  public University getSchools(University university)
	  {
	     return null;
	  }
	  
	  /**
	   * receives entries for possible changes in the specific
	   * school's information
	   * 
	   * @param state
	   * @param name
	   * @param location
	   * @param control
	   * @param numberOfStudentsLow
	   * @param numberOfStudentsHigh
	   * @param percentFemalesLow
	   * @param percentFemalesHigh
	   * @param satVerbalLow
	   * @param satVerbalHigh
	   * @param satMathLow
	   * @param satMathHigh
	   * @param expensesHigh
	   * @param expensesLow
	   * @param percentFinAidLow
	   * @param percentFinAidHigh
	   * @param applicantsLow
	   * @param applicantsHigh
	   * @param percentAdmittedLow
	   * @param percentAdmittedHigh
	   * @param percentEnrolledLow
	   * @param percentEnrolledHigh
	   * @param academScaleLow
	   * @param academScaleHigh
	   * @param socialScaleLow
	   * @param socialScaleHigh
	   * @param qualOfLifeLow
	   * @param qualOfLifeHigh
	   * @param emphasis1
	   * @param emphasis2
	   * @param emphasis3
	   * @param emphasis4
	   * @param emphasis5
	   */
	  public void editSchool(String state, String name, String location, String control, int numberOfStudentsLow, 
	   int numberOfStudentsHigh, double percentFemalesLow, double percentFemalesHigh, int satVerbalLow, 
	   int satVerbalHigh int satMathLow, int satMathHigh, double expensesLow, double expensesHigh, 
	   double percentFinAidLow, double percentFinAidHigh, int applicantsLow, int applicantsHigh,
	   double percentAdmittedLow, double percentAdmittedHigh, double percentEnrolledLow, double percentEnrolledHigh,
	   int academScaleLow, int academScaleHigh, int socialScaleLow, int socialScaleHigh, 
	   int qualOfLifeLow, int qualOfLifeHigh, String emphasis1, String emphasis2, String emphasis3, String emphasis4, String emphasis5)
	  {                       
	    
	  }
	  
	  /**
	   * Adds new school to the database
	   * 
	   * @param state
	   * @param name
	   * @param location
	   * @param control
	   * @param numberOfStudentsLow
	   * @param numberOfStudentsHigh
	   * @param percentFemalesLow
	   * @param percentFemalesHigh
	   * @param satVerbalLow
	   * @param satVerbalHigh
	   * @param satMathLow
	   * @param satMathHigh
	   * @param expensesHigh
	   * @param expensesLow
	   * @param percentFinAidLow
	   * @param percentFinAidHigh
	   * @param applicantsLow
	   * @param applicantsHigh
	   * @param percentAdmittedLow
	   * @param percentAdmittedHigh
	   * @param percentEnrolledLow
	   * @param percentEnrolledHigh
	   * @param academScaleLow
	   * @param academScaleHigh
	   * @param socialScaleLow
	   * @param socialScaleHigh
	   * @param qualOfLifeLow
	   * @param qualOfLifeHigh
	   * @param emphasis1
	   * @param emphasis2
	   * @param emphasis3
	   * @param emphasis4
	   * @param emphasis5
	   */
	  public void addSchool(String state, String name, String location, String control, int numberOfStudentsLow, 
	   int numberOfStudentsHigh, double percentFemalesLow, double percentFemalesHigh, int satVerbalLow, 
	   int satVerbalHigh int satMathLow, int satMathHigh, double expensesLow, double expensesHigh, 
	   double percentFinAidLow, double percentFinAidHigh, int applicantsLow, int applicantsHigh,
	   double percentAdmittedLow, double percentAdmittedHigh, double percentEnrolledLow, double percentEnrolledHigh,
	   int academScaleLow, int academScaleHigh, int socialScaleLow, int socialScaleHigh, 
	   int qualOfLifeLow, int qualOfLifeHigh, String emphasis1, String emphasis2, String emphasis3, String emphasis4, String emphasis5)
	  {
	    
	  }
	  
	  /**
	   * Makes final changes to the specific user's profile   
	   * 
	   * @param none
	   */
	  public void saveChangesToUser()
	  {
	    
	  }
}
