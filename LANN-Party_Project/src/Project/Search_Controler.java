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
	public ArrayList<University> displaySearchResults(String schoolName, String state,String location,
			String control,int numStuH, double satVerbH, double satVerbL,double satMathH,double satMathL,
				double expensesH,double expensesL,double percFinacialH,double percFinacialL,int numberAppsH,
						int numberAppsL, double percAdmittedH,double percAdmittedL,double percEnrolledH, double percEnrolledL,
							int acdemScaleH, int acdemScaleL,int socialscaleH,int socialscaleL,int qualityLifeH,int qualityLifeL,
								String emph1,String emph2,String emph3,String emph4,String emph5){
		
		
		ArrayList<University> inRange = new ArrayList();
		String[][] schhools = dc.getSchools();
		for(String x; schools){
			if(.getName().contains(schoolName)){
				inRange.add(      );
			}
			else if(getState().contains(state)){
				inRange.add(      );
			}
			else if(.getLocation.equals(location)){
				inRange.add(      );
			}
			else if(.getControl().equals(control)){
				inRange.add(      );
			}
			else if(.getSatVerbal()<=satVerbH && .getSatVerbal()>=satVerbL){
				inRange.add(      );
			}
			else if(.getSatMath()<=satMathH && .getSatMath()>=satMathL){
				inRange.add(      );
			}
			else if(.getExpenses()<=expensesH && .getExpenses()>=expensesL){
				inRange.add(      );
			}
			else if(.getPercentFinancialAid()<=percFinacialH && .getPercentFinancialAid()<=percFinacialL){
				inRange.add(      );
			}
			else if(.getNumOfApplicants()<=numberAppsH && .getNumOfApplicants()>=numberAppsL){
				inRange.add(      );
			}
			else if(<=percAdmittedH && >=percAdmittedL){
				inRange.add(      );
			}
			else if(<=percEnrolledH && >=percEnrolledL){
				inRange.add(      );
			}
			else if(<=acdemScaleH && >=acdemScaleL){
				inRange.add(      );
			}
			else if(<=socialscaleH && >=socialscaleL){
				inRange.add(      );
			}
			else if(<=qualityLifeH && >=qualityLifeL){
				inRange.add(      );
			}
			else{
				for(){
					if(.equals(emph1)||.equals(emph2) || .equals(emph3) || .equals(emph4) || .equals(emph5))
						inRange.add(      );
				}
			}
			
		}
		
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

