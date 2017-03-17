package Project;

//github.com/LANN-Party/LANN-Party-Official-Project.git
/**
 * @author njfloeder
 *
 */
public class AdminUI {
	
	public boolean u,c;
	public University svhool;
	public Object check;
	public Admin_Controler admin = new Admin_Controler();

	/**
	 * views all users
	 */
	public void viewusers(){}
	/**
	 * allows admin to edit a user from their information
	 * 
	 * @param uName
	 * @param fName
	 * @param lName
	 * @param pWord
	 * @param type
	 * @param status
	 */
	public void editUser(String uName, String fName, String lName, String pWord, 
char type, char status){}
	
	/**
	 * lets on deactivate a user from their username
	 * 
	 * @param uName
	 */
	public void deactivateUser(String uName){}
	
	/**
	 * lets one add in a new user
	 * 
	 * @param uName
	 * @param fName
	 * @param lName
	 * @param pWord
	 * @param type
	 * @param status
	 */
	public void addUser(String uName, String fName, String lName, String pWord, 
			char type, char status){}
	
	
	/**
	*lets you view all schools
	 */
	public void viewSchools(){}
	
	/**
	 * lets you veiw a selected user from screen 
	 */
	public void veiwUser(){}
	/**
	 * lets you veiw one selected school from screen
	 */
	public void viewSchool(){}
	/**
	 * saves changes made with a user
	 * 
	 * @param uName
	 * @param fName
	 * @param lName
	 * @param pWord
	 * @param type
	 * @param status
	 */
	
	public void saveChanges(String uName, String fName, String lName, String pWord, 
			char type, char status){}
	/**
	 * lets a school to be edited
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
	/**
	 * confirms the changes were made 
	 * @return true or false if the changes were made
	 */
	public boolean confirmChanges(){
	return false;	
	}
	/**
	 * add a school with params
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
	public void addSchool(String state, String name, String ocation, String control, int percentF, int SATVerbal, int SATMath, int expenses, int numberOfApp,
			int percentAdmitted, int academicScale, int qualityOfLiffe, String[] emphases){}
	/**
	 * cancle an action in progress
	 */
	public void cancel(){}
	/**
	 * lets you logout from the current screen
	 */
	public void logout(){}
	

}