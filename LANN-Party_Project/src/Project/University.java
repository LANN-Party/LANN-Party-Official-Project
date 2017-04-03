package Project;

import java.util.*;

/**
 * Class defining the object university
 * @author ajmcintyre
 * @version 3/27/17
 * @filename: University.java
 */
public class University {

	/**
	 * 
	 */
	private String state, name, location, control;
	private int numOfStudents, numOfApplicants, academicScale, socialScale, qualityOfLife;
	private double percentFemale, SATVerbal, SATMath, expenses, percentFinancialAid, percentAdmitted, percentEnrolled;
	private ArrayList<String> emphases;
	
	/**
	 * @param state the state the university is in
	 * @param name the name of the university
	 * @param location the town of the university
	 * @param control state or private university
	 * @param number of students attending university
	 * @param percentFemale	the female percentage of the population
	 * @param sATVerbal the average SAT Verbal score
	 * @param sATMath the average SAT Math score
	 * @param expenses the cost of attendance 
	 * @param percentFinancialAid the percent of students receiving financial aid
	 * @param numOfApplicants the number of applicants
	 * @param percentAdmitted the percent of applicants admitted
	 * @param percentEnrolled the percent of admitted students that enroll
	 * @param academicScale the academic grading scale
	 * @param socialScale the social scale
	 * @param qualityOfLife the quality of life rating
	 * @param emphases the focuses of the school's academics
	 */
	public University(String name, String state, String location, String control, int numberOfStudents, double percentFemale, double sATVerbal,
			double sATMath, double expenses, double percentFinancialAid, int numOfApplicants, double percentAdmitted,
			double percentEnrolled, int academicScale, int socialScale, int qualityOfLife) {
		super();
		this.state = state;
		this.name = name;
		this.location = location;
		this.control = control;
		this.numOfStudents = numberOfStudents;
		this.percentFemale = percentFemale;
		SATVerbal = sATVerbal;
		SATMath = sATMath;
		this.expenses = expenses;
		this.percentFinancialAid = percentFinancialAid;
		this.numOfApplicants = numOfApplicants;
		this.percentAdmitted = percentAdmitted;
		this.percentEnrolled = percentEnrolled;
		this.academicScale = academicScale;
		this.socialScale = socialScale;
		this.qualityOfLife = qualityOfLife;
		this.emphases = emphases;
	}
	

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the control
	 */
	public String getControl() {
		return this.control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}

	/**
	 * @return the percentFemale
	 */
	public double getPercentFemale() {
		return percentFemale;
	}

	/**
	 * @param percentFemale the percentFemale to set
	 */
	public void setPercentFemale(double percentFemale) {
		this.percentFemale = percentFemale;
	}

	/**
	 * @return the sATVerbal
	 */
	public double getSATVerbal() {
		return SATVerbal;
	}

	/**
	 * @param sATVerbal the sATVerbal to set
	 */
	public void setSATVerbal(double sATVerbal) {
		SATVerbal = sATVerbal;
	}

	/**
	 * @return the sATMath
	 */
	public double getSATMath() {
		return SATMath;
	}

	/**
	 * @param sATMath the sATMath to set
	 */
	public void setSATMath(double sATMath) {
		SATMath = sATMath;
	}

	/**
	 * @return the expenses
	 */
	public double getExpenses() {
		return expenses;
	}

	/**
	 * @param expenses the expenses to set
	 */
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}

	/**
	 * @return the percentFinancialAid
	 */
	public double getPercentFinancialAid() {
		return percentFinancialAid;
	}

	/**
	 * @param percentFinancialAid the percentFinancialAid to set
	 */
	public void setPercentFinancialAid(double percentFinancialAid) {
		this.percentFinancialAid = percentFinancialAid;
	}

	/**
	 * @return the numOfApplicants
	 */
	public int getNumOfApplicants() {
		return numOfApplicants;
	}

	/**
	 * @param numOfApplicants the numOfApplicants to set
	 */
	public void setNumOfApplicants(int numOfApplicants) {
		this.numOfApplicants = numOfApplicants;
	}
	
	/**
	 * @return the numOfStudents
	 */
	public int getNumOfStudents() {
		return numOfStudents;
	}

	/**
	 * @param numOfStudents the numOfStudents to set
	 */
	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}

	/**
	 * @return the percentAdmitted
	 */
	public double getPercentAdmitted() {
		return percentAdmitted;
	}

	/**
	 * @param percentAdmitted the percentAdmitted to set
	 */
	public void setPercentAdmitted(int percentAdmitted) {
		this.percentAdmitted = percentAdmitted;
	}

	/**
	 * @return the percentEnrolled
	 */
	public double getPercentEnrolled() {
		return percentEnrolled;
	}

	/**
	 * @param percentEnrolled the percentEnrolled to set
	 */
	public void setPercentEnrolled(int percentEnrolled) {
		this.percentEnrolled = percentEnrolled;
	}

	/**
	 * @return the academicScale
	 */
	public int getAcademicScale() {
		return academicScale;
	}

	/**
	 * @param academicScale the academicScale to set
	 */
	public void setAcademicScale(int academicScale) {
		this.academicScale = academicScale;
	}

	/**
	 * @return the socialScale
	 */
	public int getSocialScale() {
		return socialScale;
	}

	/**
	 * @param socialScale the socialScale to set
	 */
	public void setSocialScale(int socialScale) {
		this.socialScale = socialScale;
	}

	/**
	 * @return the qualityOfLife
	 */
	public int getQualityOfLife() {
		return qualityOfLife;
	}

	/**
	 * @param qualityOfLife the qualityOfLife to set
	 */
	public void setQualityOfLife(int qualityOfLife) {
		this.qualityOfLife = qualityOfLife;
	}

	/**
	 * @return the emphases
	 */
	public ArrayList<String> getEmphases() {
		return emphases;
	}

	/**
	 * @param emphases the emphases to set
	 */
	public void setEmphases(ArrayList<String> emphases) {
		this.emphases = emphases;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "University [name=" + name + ", state=" + state + ", location=" + location + ", control=" + control
				+ ", numOfStudents=" + numOfStudents + ", percentFemale=" + percentFemale + ", SATVerbal=" + SATVerbal 
				+ ", SATMath=" + SATMath + ", expenses=" + expenses +", percentFinancialAid=" + percentFinancialAid
				+ ", numOfApplicants=" + numOfApplicants + ", percentAdmitted=" + percentAdmitted + ", percentEnrolled=" + percentEnrolled 
				+ ", academicScale=" + academicScale + ", socialScale=" + socialScale + ", qualityOfLife=" + qualityOfLife
				+ "]";
	}

}
