/**
 * 
 */
package Project;
import java.util.*;


/**
 * controller for object admin
 * @author njfloeder
 * @version 3/27/17
 */
public class Admin_Controler {

	
	DatabaseController dc;
	
	/**
	 * creates an Admin_Controller and 
	 * initializes the DatabaseController instance variable
	 * 
	 */
	public Admin_Controler() {
		dc = new DatabaseController("lannp","lannp","csci230");
	}
	
	/**
	 * When called, this method displays the information attached to the 
	 * admin user
	 * 
	 * @param myName : name of admin whose profile will be displayed
	 */
	public void displayProfile(String myName){
		if(dc.getAdmin(myName)==null&&dc.getUser(myName)==null){
			System.out.println( "User not found. Please try a diffrent name");
		}
		System.out.println( dc.getAdmin(myName).toString());
		
	}
	
	/**
	 * When called, this method produces an array of all admin and student users
	 */
	public void viewUsers(){
		ArrayList<Student> s = dc.getStudents();
		ArrayList<Admin> a = dc.getAdmins();
		for(Student e : s){
			System.out.println(e.toString());
		}
		for(Admin ea : a){
			System.out.println(ea.toString());
		}
	}
	/**
	 * When called, this method diplays the information attached to a given user
	 * 
	  * @param uName : username of user
	 */
	public void displayInfo(String uName){
		if(dc.getAdmin(uName)==null&&dc.getUser(uName)==null){
			System.out.println( "User not found. Please try a diffrent name");
		}
		System.out.println(dc.getUser(uName).toString());
	}

	
	/**
	 * When called, this method calls DatabaseController to create a new 
	 * admin or student user depending on their type
	 * 
	 * @param uName : username of user
	 * @param fName : first name of user
	 * @param lName : last name of user
	 * @param pWord : password for user to log in 
	 * @param type : either a user is admin or student
	 * @param status : if they are signed in or not
	 */
	public boolean addUser(String uName, String fName, String lName, String pWord, char type, char status){
		
		return dc.addUser(uName, fName, lName, pWord, type, status);
	}
	
	/**
	 * When called, this method calls DatabaseController to make changes
	 * to the information of a given user
	 * 
	 * 
	 * @param uName : username of user
	 * @param fName : first name of user
	 * @param lName : last name of user
	 * @param pWord : password for user to log in 
	 * @param type : either a user is admin or student
	 * @param status : if they are signed in or not
	 */
	public boolean editUser(String uName, String fName, String lName, String pWord, 
char type, char status){
		
		return dc.editUser(uName, fName, lName, pWord, type, status);

	}

	
	/**
	 * When called, this method makes a call to DatabaseController to
	 * delete a given user
	 * 
	 * @param uName : name of the user to delete
	 */
	public boolean deleteUser(String uName){
		if(dc.getAdmin(uName)!=null||dc.getUser(uName)!=null)
		return dc.deleteUser(uName);
		else return 
				false;
	}
	
	/**
	 * When called, this method calls DatabaseController to deactivate a given user
	 * 
	 * @param uName : username of user to be deactivated
	 * @return true if user is deactivated, false otherwise
	 */
	public boolean deactivateUser(String uName){
		if(dc.getUser(uName) != null){
			dc.getUser(uName).setStatus('n');
			return true;
		}
		else if(dc.getAdmin(uName) != null){
			dc.getAdmin(uName).setStatus('n');
			return true;
		}
		else
			return false;
	}
	
	/**
	 * When called, this method displays the information of a given school
	 * 
	 * @param sName : name of the school to show information for
	 */
	public void displaySchool(String sName){
		System.out.println(dc.getSchool(sName).toString());
	}
	
	/**
	 * When called, this method displays a list of all schools
	 */
	public void displaySchools(){
		for(University x: dc.getSchools()){
		System.out.println(x.getName());
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
	 public boolean addSchool(String name, String state, String location, String control, int numberOfStudents, 
			   double percentFemales, double satVerbal, double satMath, double expenses, double percentFinAid, int applicants,
			   double percentAdmitted, double percentEnrolled, int academScale, int socialScale, 
			   int qualOfLife)
			  {
		 		return dc.addSchool(name, state, location, control, numberOfStudents, percentFemales, satVerbal, satMath, expenses, percentFinAid, applicants, percentAdmitted, percentEnrolled, academScale, socialScale, qualOfLife);
			  }
	 
	 /**
	  * Calls dbcontroller to remove a school from the database
	  * @param name name of school to remove
	  * @return true if school is removed successfully, false otherwise
	  */
	 public boolean removeSchool(String name){
		 if(dc.removeSchool(name))
			 return true;
		 return false;
	 }
	 
	/**
	 * When called, this method returns a university object
	 * 
	 * @param sName : name of the school to return
	 * @return University university
	 */
	public University getSchool(String sName){
		
		return dc.getSchool(sName);
	}
	
	/**
	 * When called, this method adds an emphasis to a given school
	 * 
	 * @param school : name of the school to add the emphasis to
	 * @param emph : the new emphasis to add
	 */
	public void addEmphasis(String school, String emph){
		//return dc.addEmphasis(school, emph);
		dc.addEmphasis(school, emph);
	}
	
	/**
	 * When called, this method removes an emphasis from a given school
	 * 
	 * @param school : name of the school to remove the emphasis from
	 * @param emph : the emphasis to remove
	 */
	public void removeEmphasis(String school, String emph){
		//return dc.removeEmphasis(school, emph);
		dc.removeEmphasis(school, emph);
	}
	
	/**
	 * When called, this method allows the admin user to edit information
	 * of a given university
	 * 
	 * @param state : where the university is located
	 * @param name : Name of the school
	 * @param location : city the school is located in 
	 * @param control : type of school(private vs public)
	 * @param percentF : percent of female students 
	 * @param SATVerbal : accepted SAT verbal score of the school
	 * @param SATMath : accepted SAT math score of the school
	 * @param expenses : expenses of attending the school
	 * @param numberOfApp : average number of people who apply to the school
	 * @param percentAdmitted : average percent of applicants admitted
	 * @param percentEnrolled : average number of admitted applicants that enroll in the school
	 * @param academicScale : average number given for academic quality on a scale of 1-10
	 * @param socialScale : average number given for social quality on a scale of 1-10
	 * @param qualityOfLife : average number given for quality of life on a scale of 1-10
	 * 
	 */
	
	
	public boolean editSchool(String name, String state, String location, String control, int numberOfStudents, 
	double percentFemales, double satVerbal, double satMath, double expenses, double percentFinAid, int applicants,
	double percentAdmitted, double percentEnrolled, int academScale, int socialScale, 
    int qualOfLife){
		
		return dc.editSchool(name, state, location, control, numberOfStudents, percentFemales, satVerbal, satMath, expenses, percentFinAid, applicants, percentAdmitted, percentEnrolled, academScale, socialScale, qualOfLife);
	}
	
	
	/**
	 * When called, this method prints out a list of emphases for a given school
	 * 
	 * @param school : name of school to get emphases
	 */
	public void getEmphases(String school)
	{
		System.out.println("Emphases for " + school + ":" + " " +dc.getEmphases(school).toString());
	}
}
