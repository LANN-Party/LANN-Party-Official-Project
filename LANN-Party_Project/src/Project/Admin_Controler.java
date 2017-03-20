/**
 * 
 */
package Project;

import java.util.ArrayList;

/**
 * @author njfloeder
 *
 */
public class Admin_Controler {

	public Object[] schools;
	
	DatabaseController dc;
	/**
	 * @param schools
	 */
	public Admin_Controler() {
		dc = new DatabaseController("lannp","lannp","csci230");
	}
	/**
	 * displays the Admin's profile
	 * 
	 * 
	 * 
	 */
	public void displayProfile(String myName){
		System.out.println(dc.getUser(myName).toString());
	}
	/**
	 * displays users info
	 * 
	  * @param uName username of user
	 */
	public void displayInfo(String uName){
		
		System.out.println(dc.getUser(uName).toString());
	}

	
	/**
	 * add a user into database
	 * 
	 * @param schools
	 * @param uName username of user
	 * @param fName first name of user
	 * @param lName last name of user
	 * @param pWord password for user to log in 
	 * @param type either a user is admin or student
	 * @param status if they are signed in or not
	 */
	public void addUser(String uName, String fName, String lName, String pWord, char type, char status){
		
		dc.addUser(uName, fName, lName, pWord, type, status);
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
char type, char status){
		
		dc.editUser(uName, fName, lName, pWord, type, status);

	}
	//TODO: ? do we needs this?
	/**
	 * checks the users username
	 * 
	 * @param uName
	 * @return boolean true or false 
	 */
	public boolean checkUserName(String uName){
		
			if(dc.getUser(uName)!=null)
				return true;
		return false;
	}
	/**
	 * delete a user
	 * 
	 * @param uName
	 */
	public void deleteUser(String uName){
		dc.deleteUser(uName);
	}
	/**
	 * displays a school
	 */
	public void displaySchool(String uName){
		System.out.println(dc.getSchool(uName));
	}
	/**
	 * displays the schools
	 */
	public void displaySchools(){
		for(University x: dc.getSchools()){
		System.out.println(x);
		}
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
			   int qualOfLife)
			  {
		 		dc.addSchool(name, state, location, control, numberOfStudents, percentFemales, satVerbal, satMath, expenses, percentFinAid, applicants, percentAdmitted, percentEnrolled, academScale, socialScale, qualOfLife);
			  }
	/**
	 * gets a university
	 * 
	 * @return University university
	 */
	public University getSchool(String uName){
		
		return dc.getSchool(uName);
	}
	
	/**
	 * Adds a emphasis to the university
	 * 
	 * @param school, university to select
	 * @param emph, a new emphasis
	 */
	public void addEmphasis(String school, String emph){
		dc.addEmphasis(school, emph);
	}
	
	/**
	 * Adds a emphasis to the university
	 * 
	 * @param school, university to select
	 * @param emph, a new emphasis
	 */
	public void removeEmphasis(String school, String emph){
		dc.removeEmphasis(school, emph);
	}
	
	/**
	 * allows admin to edit a university
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
    int qualOfLife){
		
		dc.editSchool(name, state, location, control, numberOfStudents, percentFemales, satVerbal, satMath, expenses, percentFinAid, applicants, percentAdmitted, percentEnrolled, academScale, socialScale, qualOfLife);
	}
}
