package model;

import java.util.ArrayList;

/**
 * 
 * @author Otsuki
 * A class to evaluate/justify the suger levels.
 */
public class SugerLevelEval {

	/**
	 * get users input as String
	 * return the evaluation as suger level in String
	 * @param input
	 * @return
	 */
	public String getSugerLevel(String input) {
		
		// 50 means default. Debugging purpose
		int inputInt = 50;
		
		inputInt = Integer.parseInt(input);
		
		//get the suger level standards list.
		DBUtil dbUtil = new DBUtil();
		
		ArrayList<Integer> sugerLevelStandards = new ArrayList<>();
		sugerLevelStandards = dbUtil.getSugerLevelFasting();
		
		int norm_min = sugerLevelStandards.get(0);
		int norm_max = sugerLevelStandards.get(1);
		int preDiab_max = sugerLevelStandards.get(2);
		
		System.out.println(1);
		System.out.println(norm_min);
		System.out.println(norm_max);
		System.out.println(preDiab_max);
		
		String returnStr = "tmp Str for debugging";
		
		if (inputInt < norm_max) {
			returnStr = "Green";
		} else if (inputInt < preDiab_max) {
			returnStr = "Yellow";
		} else {
			returnStr = "Red";
		}
		
		return returnStr;
	}
	
	

}
