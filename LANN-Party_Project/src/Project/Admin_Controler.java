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
	 * displays the users profile
	 */
	public void displayProfile(){}
	/**
	 * displays users info
	 * 
	 * @param uName
	 * @param fName
	 * @param lName
	 * @param pWord
	 * @param type
	 * @param status
	 */
	public void displayInfo(String uName, String fName, String lName, int pWord, char type, char status){}
	/**
	 * save changes to a user
	 * 
	 * @param uName
	 * @param fName
	 * @param lName
	 * @param pWord
	 * @param type
	 * @param status
	 */
	public void saveChanges(String uName, String fName, String lName, int pWord, char type, char status){}
	/**
	 * save a school object
	 */
	public void saveSchool(University university){}
	/**
	 * add a user into database
	 * 
	 * @param uName
	 * @param fName
	 * @param lName
	 * @param pWord
	 * @param type
	 * @param status
	 */
	public void addUser(String uName, String fName, String lName, int pWord, char type, char status){}
	/**
	 * checks the users username
	 * 
	 * @param uName
	 * @return boolean true or false 
	 */
	public boolean checkUserName(String uName){
		return false;
	}
	/**
	 * delete a user
	 * 
	 * @param uName
	 */
	public void deleteUser(String uName){}
	/**
	 * displays a school
	 */
	public void displaySchool(){}
	/**
	 * displays the schools
	 */
	public void displaySchools(){}

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
	 * @param state
	 * @param name
	 * @param ocation
	 * @param control
	 * @param percentF
	 * @param SATVerbal
	 * @param SATMath
	 * @param expenses
	 * @param numberOfApp
	 * @param percentAdmitted
	 * @param academicScale
	 * @param qualityOfLiffe
	 * @param emphases
	 */
	public void editSchool(String state, String name, String ocation, String control, int percentF, int SATVerbal, int SATMath, int expenses, int numberOfApp,
			int percentAdmitted, int academicScale, int qualityOfLiffe, String[] emphases){}
}
