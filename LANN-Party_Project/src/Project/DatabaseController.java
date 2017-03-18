package Project;
import java.util.*;
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
	   /**All schools in the database (ArrayList)*/
	  //ArrayList<schools>;
	  
	  //Data fields
	  /**All users, admin or student, in the database (ArrayList)*/
	  //ArrayList<users>;
	
	
	public DatabaseController() {
		super();
	}
	  
	  /**
	   * Displays all users in the database  
	   * 
	   * @param none
	   */
	  public Student getUsers()
	  {
		//TODO: return information of all users in the database in list form ordered by user name alphabetically
	    return null;
	  }
	  
	  /**
	   * Once given the information needed for a new user,
	   * it creates a new Student or Admin user
	   * 
	   * @param uName  : String, user's user name
	   * @param fName : String, user's first name
	   * @param lName : String, user's last name
	   * @param pWord : String, user's password
	   * @param type  : char, shows whether a user is an Admin or Student
	   * @param status : char, shows whether or not the user is currently logged in
	   */
	  public void addUser(String uName, String fName, String lName, String pWord, char type, char status)
	  {
		//TODO: using the information given to it, 
	  }
	  
	  /**
	   * Deletes selected user from the database   
	   * 
	   * @param uName : String, user name of the user to delete
	   */
	  public void deleteUser(String uName)
	  {
	    //TODO: using the user name of the User object given, delete the object from the database
	  }
	  
	  /**
	   * Removes selected school from database 
	   * 
	   * @param university : University, the university to remove from database
	   */
	  public void removeSchool(University university)
	  {
	    //TODO: using the name of the University given, delete the object from the database
	  }
	  
	  /**
	   * Removes the object from the user's saved school list
	   * 
	   * @param university, University, school to remove 
	   */
	  public void removeSavedSchool(University university)
	  {
		  
	  }
	  
	  /**
	   * Saves school and it's information to database   
	   * 
	   * @param university : University, the university to save to database
	   */
	  public void saveSchool(University university)
	  {
	    //TODO: using the University object given to it, add it to the DBL
	  }
	  
	  /**
	   * Gets selected user's information   
	   * 
	   * @param uName : String, the user name of the user to get information on
	   */
	  public Student getUser(String uName)
	  {
		//TODO: search DatabaseLibrary(DBL) to find if User object exists
		//TODO: if the User is found, return the User object
		//TODO: if the User is not found, return null
	    return null;
	  }
	  
	  /**
	   * Gets selected schools' information  
	   * 
	   * @param name: String, name of university to get information on
	   */
	  public University getSchool(String name)
	  {
		//TODO: search DatabaseLibrary(DBL) to find if University object exists
		//TODO: if the University is found, return the University object
	    //TODO: if the University is not found, return null
	    return null;
	  }
	  
	  /**
	   * Uses information to search the database for related schools
	   * 
	   * @param university: University, university to get related school for
	   */
	  public University getRelatedSchool(University university)
	  {
		//TODO: search database University objects to find ones with similar attributes based on an algorithm
		//TODO: return related schools
	    return null;
	  }
	  
	  /**
	   * Gets school's information  
	   * 
	   * @param university: University, university to get schools for???
	   */
	  public University getSchools()
	  {
		 //TODO: return whole string of University objects
	     return null;
	  }
	  
	  /**
	   * receives entries for possible changes in the specific
	   * school's information
	   * 
	   * @param name : String, name of the University object to change (can't be changed here)
	   * @param state : String, the school's state
	   * @param location : String, the city the school resides in
	   * @param control : String, state or private school
	   * @param numberOfStudents : int, numbers of students the user enters
	   * @param percentFemales : double, percent of female students attending the university
	   * @param satVerbal : int, the required score to get in to the university
	   * @param satMath : int, the required score to get in to the university
	   * @param expenses : cost of attending the university
	   * @param percentFinAid : double, average percent of financial aid given to students
	   * @param applicants : double, number of students applying to the university
	   * @param percentAdmitted : double, average percent of applicants admitted
	   * @param percentEnrolled : double, average percent of admitted students that enrolled
	   * @param academScale : int, average rating of this school academically from 1(poor)-5(excellent)
	   * @param socialScale : int, average rating of this school socially from 1(poor)-5(excellent)
	   * @param qualOfLife : int, average rating of this school's quality of life from 1(poor)-5(excellent)
	   * @param emphasis1 : String, the number 1 major supported at this school
	   * @param emphasis2 : String, the number 2 major supported at this school
	   * @param emphasis3 : String, the number 3 major supported at this school
	   * @param emphasis4 : String, the number 4 major supported at this school
	   * @param emphasis5 : String, the number 5 major supported at this school
	   */
	  public void editSchool(String name, String state, String location, String control, int numberOfStudents, 
		double percentFemales, int satVerbal, int satMath, double expenses, double percentFinAid, int applicants,
		double percentAdmitted, double percentEnrolled, int academScale, int socialScale, 
	    int qualOfLife, String emphasis1, String emphasis2, String emphasis3, String emphasis4, String emphasis5)
	  {                       
	    //TODO: use name to getSchool() from DBL?
		//TODO: set its information??
	  }
	  
	  /**
	   * Adds new school to the database and using all inputs, create a new University object
	   * 
	   * @param name : String, name of the University object
	   * @param state : String, the school's state
	   * @param location : String, the city the school resides in
	   * @param control : String, state or private school
	   * @param numberOfStudents : int, numbers of students the user enters
	   * @param percentFemales : double, percent of female students attending the university
	   * @param satVerbal : int, the required score to get in to the university
	   * @param satMath : int, the required score to get in to the university
	   * @param expenses : cost of attending the university
	   * @param percentFinAid : double, average percent of financial aid given to students
	   * @param applicants : double, number of students applying to the university
	   * @param percentAdmitted : double, average percent of applicants admitted
	   * @param percentEnrolled : double, average percent of admitted students that enrolled
	   * @param academScale : int, average rating of this school academically from 1(poor)-5(excellent)
	   * @param socialScale : int, average rating of this school socially from 1(poor)-5(excellent)
	   * @param qualOfLife : int, average rating of this school's quality of life from 1(poor)-5(excellent)
	   * @param emphasis1 : String, the number 1 major supported at this school
	   * @param emphasis2 : String, the number 2 major supported at this school
	   * @param emphasis3 : String, the number 3 major supported at this school
	   * @param emphasis4 : String, the number 4 major supported at this school
	   * @param emphasis5 : String, the number 5 major supported at this school
	   */
	  public void addSchool(String name, String state, String location, String control, int numberOfStudents, 
	   double percentFemales, int satVerbal, int satMath, double expenses, double percentFinAid, int applicants,
	   double percentAdmitted, double percentEnrolled, int academScale, int socialScale, 
	   int qualOfLife, String emphasis1, String emphasis2, String emphasis3, String emphasis4, String emphasis5)
	  {
		//TODO: create University object and add it to the list of Universities in DBL
	  }
	  
	  /**
	   * Makes final changes to the specific user's profile   
	   * 
	   * @param none
	   */
	  public void saveChangesToUser()
	  {
	    //what do I save? why again aren't we making the changes as they happen?
	  }
}
////////////////////////////Questions/////////////////////////////////////
/**
 * Q1: it seems like we have a lot happening with the confirms and set method things, can we combine some?
 * A1: ignore GUIs right now
 * Q2: what, again, is all contained in database that is not contained in classes like Student, University, or Admin?
 * A1: all crap is stored in DB 
 */
