package Project;
import java.util.*;
/**
 * @author njfloeder
 *
 */
public class Search_Controler {

	private University school;
	private ArrayList<University> schools;
	private DatabaseController dc = new DatabaseController(); 
	
	/**
	 * this method gets related schools from a user search school name
	 * @param name, name of user
	 * @return an object array of schools
	 */
	public ArrayList<University> displaySearchResults(String schoolName, String state,String location,String control,int numStuH,){
		
		return null;
	
	}
	
	/**
	 * views one school that they select on the screen 
	 * 
	 * 
	 * 
	 */
	public void viewSchool(String uName){
	System.out.println(dc.getSchool(uName));
	}
}

