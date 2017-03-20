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
		for(University x; dc.getSchools()){
			if(x.getName().contains(schoolName)){
				inRange.add(x);
			}
			else if(x.getState().contains(state)){
				inRange.add(x);
			}
			else if(x.getLocation().equals(location)){
				inRange.add(x);
			}
			else if(x.getControl().equals(control)){
				inRange.add(x);
			}
			else if(x.getSATVerbal()<=satVerbH && x.getSATVerbal()>=satVerbL){
				inRange.add(x);
			}
			else if(x.getSATMath()<=satMathH && x.getSATMath()>=satMathL){
				inRange.add(x);
			}
			else if(x.getExpenses()<=expensesH && x.getExpenses()>=expensesL){
				inRange.add(x);
			}
			else if(x.getPercentFinancialAid()<=percFinacialH && x.getPercentFinancialAid()<=percFinacialL){
				inRange.add(x);
			}
			else if(x.getNumOfApplicants()<=numberAppsH && x.getNumOfApplicants()>=numberAppsL){
				inRange.add(x);
			}
			else if(x.getPercentAdmitted()<=percAdmittedH && x.getPercentAdmitted()>=percAdmittedL){
				inRange.add(x);
			}
			else if(x.getPercentEnrolled()<=percEnrolledH && x.getPercentEnrolled()>=percEnrolledL){
				inRange.add(x);
			}
			else if(x.getAcademicScale()<=acdemScaleH && x.getAcademicScale()>=acdemScaleL){
				inRange.add(x);
			}
			else if(x.getSocialScale()<=socialscaleH && x.getSocialScale()>=socialscaleL){
				inRange.add(x);
			}
			else if(x.getQualityOfLife()<=qualityLifeH && x.getQualityOfLife()>=qualityLifeL){
				inRange.add(x);
			}
			else{
				for(String s; x.getEmphases()){
					if(s.equals(emph1)||s.equals(emph2) || s.equals(emph3) || s.equals(emph4) || s.equals(emph5))
						inRange.add(x);
				}
			}
			
		}
		
		return inRange;
	
	}
	
	/**
	 * views one school that they select on the screen 
	 * 
	 * 
	 * 
	 */
	public void viewSchool(String uName){
		ArrayList<Double> vectors = new ArrayList();
		University selected = dc.getSchool(uName);
		for(University x; dc.getSchools()){
			double vector = Math.abs(
		}
	}
}

