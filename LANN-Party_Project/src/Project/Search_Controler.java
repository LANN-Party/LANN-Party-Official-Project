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
	public ArrayList<University> viewSchool(String uName){
		//list of all vectors and thier uni
		HashMap<Double,University> vectors = new HashMap<>();
		//list to hold top5 uni and to be returned
		ArrayList<University> top5 = new ArrayList();
		//the uni the user has selected from search results
		University selected = dc.getSchool(uName);
		//the current vector being calculated
		Double vector;
		//a list of all the schools
		ArrayList<University> schools = dc.getSchools();
		//the calulation of the vector that is complete
		for(University x:schools){
			if(selected.getSATMath()>x.getSATMath()){
				vector+=Math.abs((selected.getSATMath()-x.getSATMath())/(Math.abs(selected.getSATMath()-x.getSATMath())));
			}
			else{
				vector+=Math.abs(((selected.getSATMath()-x.getSATMath())/(x.getSATMath()-selected.getSATMath())));
			}
			if(selected.getSATVerbal()>x.getSATVerbal()){
				vector += Math.abs((selected.getSATVerbal()-x.getSATVerbal())/(selected.getSATVerbal()-x.getSATVerbal()));
			}
			else{
				vector += Math.abs((selected.getSATVerbal()-x.getSATVerbal())/(x.getSATVerbal()-selected.getSATVerbal()));
			}
			if(selected.getSocialScale()>x.getSocialScale()){
				vector +=Math.abs((selected.getSocialScale()-x.getSocialScale())+(selected.getSocialScale()-x.getSocialScale()));
			}
			else{
				vector += Math.abs((selected.getSocialScale()-x.getSocialScale())+(x.getSocialScale()-selected.getSocialScale()));
			}
			if(selected.getAcademicScale()>x.getAcademicScale()){
				vector += Math.abs((selected.getAcademicScale()-x.getAcademicScale())/(selected.getAcademicScale()-x.getAcademicScale()));
			}
			else{
				vector += Math.abs((selected.getAcademicScale()-x.getAcademicScale())/(x.getAcademicScale()-selected.getAcademicScale()));
			}
			if(selected.getPercentAdmitted()>x.getPercentAdmitted()){
				vector += Math.abs((selected.getPercentAdmitted()-x.getPercentAdmitted())/(selected.getPercentAdmitted()-x.getPercentAdmitted()));
			}
			else{
				vector += Math.abs((selected.getPercentAdmitted()-x.getPercentAdmitted())/(x.getPercentAdmitted()-selected.getPercentAdmitted()));
			}
			if(selected.getPercentEnrolled()>x.getPercentEnrolled()){
				vector += Math.abs((selected.getPercentEnrolled()-x.getPercentEnrolled())/(selected.getPercentEnrolled()-x.getPercentEnrolled()));
			}
			else{
				vector += Math.abs((selected.getPercentEnrolled()-x.getPercentEnrolled())/(x.getPercentEnrolled()-selected.getPercentEnrolled()));
			}
			if(selected.getPercentFemale()>x.getPercentFemale()){
				vector += Math.abs((selected.getPercentFemale()-x.getPercentFemale())/(selected.getPercentFemale()-x.getPercentFemale()));
			}
			else{
				vector += Math.abs((selected.getPercentFemale()-x.getPercentFemale())/(x.getPercentFemale()-selected.getPercentFemale()));
			}
			if(selected.getPercentFinancialAid()>x.getPercentFinancialAid()){
				vector += Math.abs((selected.getPercentFinancialAid()-x.getPercentFinancialAid())/(selected.getPercentFinancialAid()-x.getPercentFinancialAid()));
			}
			else{
				vector += Math.abs((selected.getPercentFinancialAid()-x.getPercentFinancialAid())/(x.getPercentFinancialAid()-selected.getPercentFinancialAid()));
			}
			if(selected.getQualityOfLife()>x.getQualityOfLife()){
				vector += Math.abs((selected.getQualityOfLife()-x.getQualityOfLife())/(selected.getQualityOfLife()-x.getQualityOfLife()));
			}
			else{
				vector += Math.abs((selected.getQualityOfLife()-x.getQualityOfLife())/(x.getQualityOfLife()-selected.getQualityOfLife()));
			}
			if(selected.getExpenses()>x.getExpenses()){
				vector += Math.abs((selected.getExpenses()-x.getExpenses())/(selected.getExpenses()-x.getExpenses()));
			}
			else{
				vector += Math.abs((selected.getExpenses()-x.getExpenses())/(x.getExpenses()-selected.getExpenses()));
			}
			if(selected.getNumOfApplicants()>x.getNumOfApplicants()){
				vector += Math.abs((selected.getNumOfApplicants()-x.getNumOfApplicants())/(selected.getNumOfApplicants()-x.getNumOfApplicants()));
			}
			else{
				vector += Math.abs((selected.getNumOfApplicants()-x.getNumOfApplicants())/(x.getNumOfApplicants()-selected.getNumOfApplicants()));
			}
			if(!selected.getState().equals(x.getState()))
				vector += 1;
			if(!selected.getLocation().equals(x.getLocation()))
				vector +=1;
			if(!selected.getControl().equals(x.getControl()))
				vector +=1;
			String[] emphS = selected.getEmphases();
			String[] emphX = x.getEmphases();
			for(int a =0;a<selected.getEmphases().length;a++){
				for(int s = 0;s<selected.getEmphases().length;s++){
					if(!emphS[a].equals(emphX[s]))
						vector +=1;
				}
			}
			
			vectors.add(vector,x);
			//where you now select
			//can sort vectors and grab the top 5 from there or just find the top 5 lowest instead of sorting right away
			
			
		
			}
		
	}
}

