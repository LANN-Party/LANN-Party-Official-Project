package Project;

import java.util.*;

import dblibrary.project.csci230.*;

 /**
  * FileName: DatabaseController.java
  */
 
 /**
  * Class dedicated to all information in the system
  * @author Noah Hynes-Marquette
  * @version 3/20/2017
  *
  */
public class DatabaseController {
	
	private UniversityDBLibrary uDBL;
	private Search_Controler search; 
	
	  //Data fields
	   /**All schools in the database (ArrayList)*/
	  //ArrayList<schools>;
	  
	  //Data fields
	  /**All users, admin or student, in the database (ArrayList)*/
	  //ArrayList<users>;
	
	
	
	public DatabaseController(String dataBase, String uName, String pWord){
		uDBL = new UniversityDBLibrary(dataBase, uName, pWord);
		search = new Search_Controler();
	}
	  
	/**
	 * gets an arraylist of all the students in the database
	 * 
	 * @return ArrayList<Student> of all students in the database
	 */
	  public ArrayList<Student> getStudents()
	  {
		//TODO: return information of all users in the database in list form ordered by user name alphabetically
		String[][] users =  uDBL.user_getUsers();
		String[][] userSchools = uDBL.user_getUsernamesWithSavedSchools();
		ArrayList<String> schools = new ArrayList<String>();
		ArrayList<Student> students = new ArrayList<Student>();
		
		for(int i = 0; i<users.length; i++){
			schools.clear();
			if(users[i][4].charAt(0) == 'u'){
				for(int j = 0; j<userSchools[i].length; j++){
					String name = userSchools[i][j];

					schools.add(name);
				}
				Student s = new Student(users[i][0], users[i][1], users[i][2], users[i][3], users[i][4].charAt(0), users[i][5].charAt(0), schools);
				students.add(s);
			}
		}
	    return students;
	  }
	  
	  /**
	   * 
	   * @return ArrayList<Admin> of all the admins in the database
	   */
	  public ArrayList<Admin> getAdmins(){
		  
		  ArrayList<Admin> admins = new ArrayList<Admin>();
		  String[][] users =  uDBL.user_getUsers();
		  
		  for(int i = 0; i<users.length; i++){
			  if(users[i][4].charAt(0) == 'a'){
				  Admin s = new Admin(users[i][0], users[i][1], users[i][2], users[i][3], users[i][4].charAt(0), users[i][5].charAt(0));
				  admins.add(s);
			  }
		  }
		  return admins;
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
		uDBL.user_addUser(fName, lName, uName, pWord, type);
	  }
	  
	  /**
	   * Deletes selected user from the database   
	   * 
	   * @param uName : String, user name of the user to delete
	   */
	  public void deleteUser(String uName)
	  {
	    //TODO: using the user name of the User object given, delete the object from the database
		uDBL.user_deleteUser(uName);
	  }
	  
	  /**
	   * Removes selected school from database 
	   * 
	   * @param university : University, the university to remove from database
	   */
	  public void removeSchool(String name)
	  {
		uDBL.university_deleteUniversity(name);
	  }
	  
	  /**
	   * Removes the object from the user's saved school list
	   * 
	   * @param uName : String, name of the User whose saved list the school will be removed from
	   * @param schoolName : String, name of the university 
	   */
	  public void removeSavedSchool(String uName, String schoolName)
	  {
		uDBL.user_removeSchool(uName, schoolName);
	  }
	  
	  /**
	   * Saves school and it's information to database   
	   * 
	   * @param uName : String, name of student to save school to
	   * @param schoolName : String, name of school to add
	   */
	  public void saveSchool(String uName, String schoolName)
	  {
	    //TODO: using the University object given to it, add it to the DBL
		uDBL.user_saveSchool(uName, schoolName);
	  }
	  
	  /**
	   * Gets selected user's information   
	   * 
	   * @param uName : String, the user name of the user to get information on
	   * @return Student object of student if found, null if not.
	   */
	  public Student getUser(String uName)
	  {
		//TODO: search DatabaseLibrary(DBL) to find if User object exists
		  String[][] users =  uDBL.user_getUsers();
		  String[][] userSchools = uDBL.user_getUsernamesWithSavedSchools();
		  ArrayList<String> schools = new ArrayList<String>();
			
		  for(int i = 0; i<users.length; i++){
			  schools.clear();
			  if(users[i][0] == uName){
				  for(int j = 0; j<userSchools[i].length; j++){
					  String name = userSchools[i][j];

					  schools.add(name);
				  }
				  Student s = new Student(users[i][0], users[i][1], users[i][2], users[i][3], users[i][4].charAt(0), users[i][5].charAt(0), schools);
				  return s;
			  }
		  }
		  return null;
	  }
	  
	  /**
	   * 
	   * @param uName username to search for
	   * @return Admin, the admin object of the name parameter, or null if not found
	   */
	  public Admin getAdmin(String uName){
		  String[][] users = uDBL.user_getUsers();
		  for(int i =0; i<users.length; i++){
			  if(users[i][0] == uName){
				  Admin a = new Admin(users[i][0], users[i][1], users[i][2], users[i][3], users[i][4].charAt(0), users[i][5].charAt(0));
				  return a;
			  }
		  }
		  return null;
	  }
	  
	  /**
	   * Gets selected schools' information  
	   * 
	   * @param name: String, name of university to get information on
	   */
	  public University getSchool(String name)
	  {
		  String[][] s = uDBL.university_getUniversities();
			 
		  for(int i=0; i<s.length; i++){
			  if(s[i][0]==name){
				  University u = new University(s[i][0], s[i][1], s[i][2], s[i][3], Integer.parseInt(s[i][4]), Double.parseDouble(s[i][5]), Double.parseDouble(s[i][6]),
						 Double.parseDouble(s[i][7]), Double.parseDouble(s[i][8]), Double.parseDouble(s[i][9]), Integer.parseInt(s[i][10]), Double.parseDouble(s[i][11]),
						 Double.parseDouble(s[i][12]), Integer.parseInt(s[i][13]), Integer.parseInt(s[i][14]), Integer.parseInt(s[i][15]));
				  return u;
			  }
		  }
		  return null;
	  }
	  
	  /**
	   * Uses information to search the database for related schools
	   * 
	   * @param university: University, university to get related school for
	   */
	  public ArrayList<University> getRelatedSchools(University university)
	  {
		  return search.viewSchool(university.getName());
	  }
	  
	  /**
	   * Gets an array list of all the schools from DBL 
	   * 
	   * @param university: University, university to get schools for???
	   */
	  public ArrayList<University> getSchools()
	  {
		 String[][] s = uDBL.university_getUniversities();
		 ArrayList<University> universities = new ArrayList<University>();
		 
		 for(int i=0; i<s.length; i++){
			 University u = new University(s[i][0], s[i][1], s[i][2], s[i][3], Integer.parseInt(s[i][4]), Double.parseDouble(s[i][5]), Double.parseDouble(s[i][6]),
					 Double.parseDouble(s[i][7]), Double.parseDouble(s[i][8]), Double.parseDouble(s[i][9]), Integer.parseInt(s[i][10]), Double.parseDouble(s[i][11]),
					 Double.parseDouble(s[i][12]), Integer.parseInt(s[i][13]), Integer.parseInt(s[i][14]), Integer.parseInt(s[i][15]));
			 universities.add(u);
		 }
		 return universities;
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

	   */
	  public void editSchool(String name, String state, String location, String control, int numberOfStudents, 
		double percentFemales, int satVerbal, int satMath, double expenses, double percentFinAid, int applicants,
		double percentAdmitted, double percentEnrolled, int academScale, int socialScale, 
	    int qualOfLife)
	  {                         
		uDBL.university_addUniversity(name, state, location, control, numberOfStudents, percentFemales, satVerbal, satMath,
		     expenses, percentFinAid, applicants, percentAdmitted, percentEnrolled, academScale, socialScale, qualOfLife);
	  }
	  
	  /**
	   * Adds new school to the UniversityDBLibrary and using all inputs, create a new University object
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

	   */
	  public void addSchool(String name, String state, String location, String control, int numberOfStudents, 
	   double percentFemales, int satVerbal, int satMath, double expenses, double percentFinAid, int applicants,
	   double percentAdmitted, double percentEnrolled, int academScale, int socialScale, 
	   int qualOfLife)
	  {
		//TODO: create University object and add it to the list of Universities in DBL
		uDBL.university_addUniversity(name, state, location, control, numberOfStudents, percentFemales, satVerbal, satMath,
				expenses, percentFinAid, applicants, percentAdmitted, percentEnrolled, academScale, socialScale, qualOfLife);
		
	  }
	  
	  /**
	   * 
	   * 
	   * @param sName : String, name of the school to add emphasis to
	   * @param emphasis1 : String, the number 1 major supported at this school
	   */
	  public void addEmphasis(String sName, String emphasis1)
	  {
	    uDBL.university_addUniversityEmphasis(sName, emphasis1);
	  }
	  
	  /**
	   * 
	   * 
	   * @param sName : String, name of the school to remove emphasis from
	   * @param emphasis1 : String, one emphasis to remove

	   */
	  public void removeEmphasis(String sName, String emphasis1)
	  {
	    uDBL.university_removeUniversityEmphasis(sName, emphasis1);
	  }
	  
	  /**
	   * Changes the given information in for the student in the DBL
	   * 
	   * @param uName : String, user name of user to edit
	   * @param fName : String, first name of user
	   * @param lName : String, last name of user
	   * @param pWord : String, password of user
	   * @param type : String, user type (Admin or Student)
	   * @param status : String, whether or not the user is logged (will never be changed here)
	   */
	  public void editUser(String uName, String fName, String lName, String pWord, char type, char status)
	  {
	    uDBL.user_editUser(uName, fName, lName, pWord, type, status);
	  }
	

}
////////////////////////////Questions/////////////////////////////////////
/**
 * Q1: it seems like we have a lot happening with the confirms and set method things, can we combine some?
 * A1: ignore GUIs right now
 * Q2: what, again, is all contained in database that is not contained in classes like Student, University, or Admin?
 * A1: all crap is stored in DB 
 */
