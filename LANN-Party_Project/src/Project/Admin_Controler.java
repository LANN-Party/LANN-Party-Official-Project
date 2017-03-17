/**
 * 
 */
package Project;

/**
 * @author njfloeder
 *
 */
public class Admin_Controler {

	public Object[] schools;
	

	/**
	 * @param schools
	 */
	public Admin_Controler() {
		super();
	}
	/**
	 * displays the users profile
	 * 
	 * 
	 * 
	 */
	public void displayProfile(){
		
	}
	/**
	 * displays users info
	 * 
	  * @param uName username of user
	 * @param fName first name of user
	 * @param lName last name of user
	 * @param pWord password for user to log in 
	 * @param type either a user is admin or student
	 * @param status if they are signed in or not
	 */
	public void displayInfo(String uName, String fName, String lName, int pWord, char type, char status){
		
		System.out.println(uName+ " " + fName + " " + lName + " "+ pWord +" " + type+ " " + status);
	}
	/**
	 * save changes to a user
	 * 
	  * @param uName username of user
	 * @param fName first name of user
	 * @param lName last name of user
	 * @param pWord password for user to log in 
	 * @param type either a user is admin or student
	 * @param status if they are signed in or not
	 */
	public void saveChanges(String uName, String fName, String lName, int pWord, char type, char status){

		Student temp = new Student(uName, fName, lName, pWord, type, status);
		 = temp;
	}
	/**
	 * save a school object
	 */
	public void saveSchool(University university){
		
		= university;
	}
	/**
	 * add a user into database
	 * 
	 * @param uName username of user
	 * @param fName first name of user
	 * @param lName last name of user
	 * @param pWord password for user to log in 
	 * @param type either a user is admin or student
	 * @param status if they are signed in or not
	 */
	public void addUser(String uName, String fName, String lName, int pWord, char type, char status){
		
		Student newStu = new Student(uName,fName,lName,pWord, type,status);
		.add(newStu);
	}
	/**
	 * checks the users username
	 * 
	 * @param uName
	 * @return boolean true or false 
	 */
	public boolean checkUserName(String uName){
		
		for(Student s: ){
			if(s.getUserName().equals(uName))
				return true;
		}
		
		return false;
	}
	/**
	 * delete a user
	 * 
	 * @param uName
	 */
	public void deleteUser(String uName){
		
		.remove();
	}
	/**
	 * displays a school
	 */
	public void displaySchool(){
		System.out.println();
	}
	/**
	 * displays the schools
	 */
	public void displaySchools(){
		for(University x: ){
		System.out.println(x);
		}
	}

	/**
	 * gets a university
	 * 
	 * @return University university
	 */
	public University getSchool(){
		
		return null;
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
	public void editSchool(String state, String name, String ocation, String control, int percentF, int SATVerbal, int SATMath, int expenses, int numberOfApp,
			int percentAdmitted, int academicScale, int qualityOfLiffe, String[] emphases){
		
		University newU = new University( state,  name,  ocation,  control,  percentF,  SATVerbal,  SATMath,  expenses,  numberOfApp,
				 percentAdmitted,  academicScale,  qualityOfLiffe,  emphases);
		
		saveSchool(newU);
	}
}
