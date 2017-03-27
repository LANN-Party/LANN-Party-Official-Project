package Project;

import java.util.*;

/**
 * controller for all searches made by the user
 * 
 * @author njfloeder
 * @version 3/27/2017
 */
public class Search_Controler {

	private DatabaseController dc;

	/**
	 * @param dc
	 */
	public Search_Controler() {
		dc = new DatabaseController("lannp", "lannp", "csci230");
	}

	/**
	 * this method gets related schools from a user search school name
	 * 
	 * @param name,
	 *            name of user
	 * @return an object array of schools
	 */
	public ArrayList<University> displaySearchResults(String schoolName, String state, String location, String control,
			int numStuH, double satVerbH, double satVerbL, double satMathH, double satMathL, double expensesH,
			double expensesL, double percFinacialH, double percFinacialL, int numberAppsH, int numberAppsL,
			double percAdmittedH, double percAdmittedL, double percEnrolledH, double percEnrolledL, int acdemScaleH,
			int acdemScaleL, int socialscaleH, int socialscaleL, int qualityLifeH, int qualityLifeL, String emph1,
			String emph2, String emph3, String emph4, String emph5) {

		ArrayList<University> inRange = new ArrayList<University>();
		int numStuh = numStuH;
		double satVerbh = satVerbH;
		double satVerbl = satVerbL;
		double satMathh = satMathH;
		double satMathl = satMathL;
		int acdemScaleh = acdemScaleH;
		double expensesh = expensesH;
		double expensesl = expensesL;
		double percFinacialh = percFinacialH;
		double percFinaciall = percFinacialL;
		int numberAppsh = numberAppsH;
		int numberAppsl = numberAppsL;
		double percAdmittedh = percAdmittedH;
		double percAdmittedl = percAdmittedL;
		double percEnrolledh = percEnrolledH;
		double percEnrolledl = percEnrolledL;
		int acdemScalel = acdemScaleL;
		int socialscaleh = socialscaleH;
		int socialscalel = socialscaleL;
		int qualityLifeh = qualityLifeH;
		int qualityLifel = qualityLifeL;
		int numEmphs=0;
		
		if (numStuh == 0)
			numStuh = Integer.MAX_VALUE;
		if (satVerbh == 0)
			satVerbh = Integer.MAX_VALUE;
		if (satVerbl == 0)
			satVerbl = Integer.MIN_VALUE;
		if (satMathh == 0)
			satMathh = Integer.MAX_VALUE;
		if (satMathl == 0)
			satMathl = Integer.MIN_VALUE;
		if (acdemScaleh == 0)
			acdemScaleh = Integer.MAX_VALUE;
		if (expensesh == 0)
			expensesh = Integer.MAX_VALUE;
		if (expensesl == 0)
			expensesl = Integer.MIN_VALUE;
		if (percFinacialh == 0)
			percFinacialh = Integer.MAX_VALUE;
		if (percFinaciall == 0)
			percFinaciall = Integer.MIN_VALUE;
		if (numberAppsh == 0)
			numberAppsh = Integer.MAX_VALUE;
		if (numberAppsl == 0)
			numberAppsl = Integer.MIN_VALUE;
		if (percAdmittedh == 0)
			percAdmittedh = Integer.MAX_VALUE;
		if (percAdmittedl == 0)
			percAdmittedl = Integer.MIN_VALUE;
		if (percEnrolledh == 0)
			percEnrolledh = Integer.MAX_VALUE;
		if (percEnrolledl == 0)
			percEnrolledl = Integer.MIN_VALUE;
		if (acdemScalel == 0)
			acdemScalel = Integer.MIN_VALUE;
		if (socialscaleh == 0)
			socialscaleh = Integer.MAX_VALUE;
		if (socialscalel == 0)
			socialscalel = Integer.MIN_VALUE;
		if (qualityLifeh == 0)
			qualityLifeh = Integer.MAX_VALUE;
		if (qualityLifel == 0)
			qualityLifel = Integer.MIN_VALUE;
		if(emph1==null)
			numEmphs++;
		if(emph2==null)
			numEmphs++;
		if(emph3==null)
			numEmphs++;
		if(emph4==null)
			numEmphs++;
		if(emph5==null)
			numEmphs++;

		for (University x : dc.getSchools()) {
			if (x.getName().contains(schoolName)) {
				if (x.getState().contains(state))
					if (x.getLocation().equals(location))
						if (x.getControl().equals(control))
							if (x.getSATVerbal() <= satVerbh && x.getSATVerbal() >= satVerbl)
								if (x.getSATMath() <= satMathH && x.getSATMath() >= satMathL)
									if (x.getExpenses() <= expensesh && x.getExpenses() >= expensesl)
										if (x.getPercentFinancialAid() <= percFinacialh
												&& x.getPercentFinancialAid() <= percFinaciall)
											if (x.getNumOfApplicants() <= numberAppsh
													&& x.getNumOfApplicants() >= numberAppsl)
												if (x.getPercentAdmitted() <= percAdmittedh
														&& x.getPercentAdmitted() >= percAdmittedl)
													if (x.getPercentEnrolled() <= percEnrolledh
															&& x.getPercentEnrolled() >= percEnrolledl)
														if (x.getAcademicScale() <= acdemScaleh
																&& x.getAcademicScale() >= acdemScalel)
															if (x.getSocialScale() <= socialscaleh
																	&& x.getSocialScale() >= socialscalel)
																if (x.getQualityOfLife() <= qualityLifeh
																		&& x.getQualityOfLife() >= qualityLifel) {
																	int c =0
																	for (String s : x.getEmphases()) {
																		if (s.equals(emph1) || s.equals(emph2)
																				|| s.equals(emph3) || s.equals(emph4)
																				|| s.equals(emph5))
																			c++;
																	}
																	if(c==numEmphs){
																		inRange.add(x);	
																	}
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
	public ArrayList<University> viewSchool(String uName) {
		// list of all vectors and thier uni
		TreeMap<Double, University> vectors = new TreeMap<>();
		// list to hold top5 uni and to be returned
		ArrayList<University> top5 = new ArrayList<University>();
		// the uni the user has selected from search results
		University selected = dc.getSchool(uName);
		// the current vector being calculated
		Double vector = 0.0;
		int ctr = 0;
		// a list of all the schools
		ArrayList<University> schools = dc.getSchools();
		// the calulation of the vector that is complete
		for (University x : schools) {
			ctr++;

			if (selected.equals(x))
				vector += 0;
			if (selected.getSATMath() > x.getSATMath()) {
				vector += Math.abs(
						(selected.getSATMath() - x.getSATMath()) / (Math.abs(selected.getSATMath() - x.getSATMath())));
			} else if (selected.getSATMath() == x.getSATMath())
				vector += 0;
			else {
				vector += Math
						.abs(((selected.getSATMath() - x.getSATMath()) / (x.getSATMath() - selected.getSATMath())));
			}
			if (selected.getSATVerbal() > x.getSATVerbal()) {
				vector += Math.abs(
						(selected.getSATVerbal() - x.getSATVerbal()) / (selected.getSATVerbal() - x.getSATVerbal()));
			} else if (selected.getSATVerbal() == x.getSATVerbal())
				vector += 0;
			else {
				vector += Math.abs(
						(selected.getSATVerbal() - x.getSATVerbal()) / (x.getSATVerbal() - selected.getSATVerbal()));
			}
			if (selected.getSocialScale() > x.getSocialScale()) {
				vector += Math.abs((selected.getSocialScale() - x.getSocialScale())
						+ (selected.getSocialScale() - x.getSocialScale()));
			} else if (selected.getSocialScale() == x.getSocialScale())
				vector += 0;
			else {
				vector += Math.abs((selected.getSocialScale() - x.getSocialScale())
						+ (x.getSocialScale() - selected.getSocialScale()));
			}
			if (selected.getAcademicScale() > x.getAcademicScale()) {
				vector += Math.abs((selected.getAcademicScale() - x.getAcademicScale())
						/ (selected.getAcademicScale() - x.getAcademicScale()));
			} else if (selected.getAcademicScale() == x.getAcademicScale())
				vector += 0;
			else {
				vector += Math.abs((selected.getAcademicScale() - x.getAcademicScale())
						/ (x.getAcademicScale() - selected.getAcademicScale()));
			}
			if (selected.getPercentAdmitted() > x.getPercentAdmitted()) {
				vector += Math.abs((selected.getPercentAdmitted() - x.getPercentAdmitted())
						/ (selected.getPercentAdmitted() - x.getPercentAdmitted()));
			} else if (selected.getPercentAdmitted() == x.getPercentAdmitted())
				vector += 0;
			else {
				vector += Math.abs((selected.getPercentAdmitted() - x.getPercentAdmitted())
						/ (x.getPercentAdmitted() - selected.getPercentAdmitted()));
			}
			if (selected.getPercentEnrolled() > x.getPercentEnrolled()) {
				vector += Math.abs((selected.getPercentEnrolled() - x.getPercentEnrolled())
						/ (selected.getPercentEnrolled() - x.getPercentEnrolled()));
			} else if (selected.getPercentEnrolled() == x.getPercentEnrolled())
				vector += 0;
			else {
				vector += Math.abs((selected.getPercentEnrolled() - x.getPercentEnrolled())
						/ (x.getPercentEnrolled() - selected.getPercentEnrolled()));
			}
			if (selected.getPercentFemale() > x.getPercentFemale()) {
				vector += Math.abs((selected.getPercentFemale() - x.getPercentFemale())
						/ (selected.getPercentFemale() - x.getPercentFemale()));
			} else if (selected.getPercentFemale() == x.getPercentFemale())
				vector += 0;
			else {
				vector += Math.abs((selected.getPercentFemale() - x.getPercentFemale())
						/ (x.getPercentFemale() - selected.getPercentFemale()));
			}
			if (selected.getPercentFinancialAid() > x.getPercentFinancialAid()) {
				vector += Math.abs((selected.getPercentFinancialAid() - x.getPercentFinancialAid())
						/ (selected.getPercentFinancialAid() - x.getPercentFinancialAid()));
			} else if (selected.getPercentFinancialAid() == x.getPercentFinancialAid())
				vector += 0;
			else {
				vector += Math.abs((selected.getPercentFinancialAid() - x.getPercentFinancialAid())
						/ (x.getPercentFinancialAid() - selected.getPercentFinancialAid()));
			}
			if (selected.getQualityOfLife() > x.getQualityOfLife()) {
				vector += Math.abs((selected.getQualityOfLife() - x.getQualityOfLife())
						/ (selected.getQualityOfLife() - x.getQualityOfLife()));
			} else if (selected.getQualityOfLife() == x.getQualityOfLife())
				vector += 0;
			else {
				vector += Math.abs((selected.getQualityOfLife() - x.getQualityOfLife())
						/ (x.getQualityOfLife() - selected.getQualityOfLife()));
			}
			if (selected.getExpenses() > x.getExpenses()) {
				vector += Math
						.abs((selected.getExpenses() - x.getExpenses()) / (selected.getExpenses() - x.getExpenses()));
			} else if (selected.getExpenses() == x.getExpenses())
				vector += 0;
			else {
				vector += Math
						.abs((selected.getExpenses() - x.getExpenses()) / (x.getExpenses() - selected.getExpenses()));
			}
			if (selected.getNumOfApplicants() > x.getNumOfApplicants()) {
				vector += Math.abs((selected.getNumOfApplicants() - x.getNumOfApplicants())
						/ (selected.getNumOfApplicants() - x.getNumOfApplicants()));
			} else if (selected.getNumOfApplicants() == x.getNumOfApplicants()) {
				vector += 0;
			} else {
				vector += Math.abs((selected.getNumOfApplicants() - x.getNumOfApplicants())
						/ (x.getNumOfApplicants() - selected.getNumOfApplicants()));
			}
			if (!selected.getState().equals(x.getState()))
				vector += 1;
			if (!selected.getLocation().equals(x.getLocation()))
				vector += 1;
			if (!selected.getControl().equals(x.getControl()))
				vector += 1;
			ArrayList<String> emphS = selected.getEmphases();
			ArrayList<String> emphX = x.getEmphases();
			if (emphS != null && emphX != null) {
				for (String s : emphS) {
					for (String r : emphX) {
						if (!s.equals(r))
							vector += 1;
					}
				}
			}
			if (!(selected.getName().equals(x.getName())))
				vectors.put(vector, x);
			double v = vector;
			// where you now select
			// can sort vectors and grab the top 5 from there or just find the
			// top 5 lowest instead of sorting right away
			vector = 0.0;
		}
		System.out.println(vectors.size());
		for (int i = 0; i < 5; i++) {
			top5.add(vectors.pollFirstEntry().getValue());
		}
		return top5;
	}
}
