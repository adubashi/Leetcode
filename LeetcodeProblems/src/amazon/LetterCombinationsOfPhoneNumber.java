package amazon;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
	/*
	 * 1. Have a recursive helper function that gets passed a string of digits, a large list to hold the combination,
	 * and a string per combination. This String gets appended to recursively. 
	 * 2. The base case is if the string is null/empty. If this is true we append the comboString to the comboList.
	 * 3. For one digit, do a recursive call for each of the combinations. I.E 2 -> ABC 
	 */
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		String comboString = "";
		if(digits.equals("")) {
			return list;
		}
		letterCombinationHelper(digits, comboString, list);
		return list;
    }
	
	public void letterCombinationHelper(String digits, String comboString, List<String> comboList) {
		if(digits.equals("")) {
		   comboList.add(comboString);
           return;
		}
        System.out.println(digits);
		Character ch = digits.charAt(0);
		String nextString = digits.substring(1);
		
		if(ch == '2') {
			letterCombinationHelper(nextString, comboString + "a", comboList);
			letterCombinationHelper(nextString, comboString + "b", comboList);
			letterCombinationHelper(nextString, comboString + "c", comboList);
		} else if(ch == '3') {
			letterCombinationHelper(nextString, comboString + "d", comboList);
			letterCombinationHelper(nextString, comboString + "e", comboList);
			letterCombinationHelper(nextString, comboString + "f", comboList);
		} else if(ch == '4') {
			letterCombinationHelper(nextString, comboString + "g", comboList);
			letterCombinationHelper(nextString, comboString + "h", comboList);
			letterCombinationHelper(nextString, comboString + "i", comboList);
		} else if(ch == '5') {
			letterCombinationHelper(nextString, comboString + "j", comboList);
			letterCombinationHelper(nextString, comboString + "k", comboList);
			letterCombinationHelper(nextString, comboString + "l", comboList);	
		} else if(ch == '6') {
			letterCombinationHelper(nextString, comboString + "m", comboList);
			letterCombinationHelper(nextString, comboString + "n", comboList);
			letterCombinationHelper(nextString, comboString + "o", comboList);
		} else if(ch == '7') {
			letterCombinationHelper(nextString, comboString + "p", comboList);
			letterCombinationHelper(nextString, comboString + "q", comboList);
			letterCombinationHelper(nextString, comboString + "r", comboList);
			letterCombinationHelper(nextString, comboString + "s", comboList);
		} else if(ch == '8') {
			letterCombinationHelper(nextString, comboString + "t", comboList);
			letterCombinationHelper(nextString, comboString + "u", comboList);
			letterCombinationHelper(nextString, comboString + "v", comboList);
		} else if(ch == '9') {
            letterCombinationHelper(nextString, comboString + "w", comboList);
			letterCombinationHelper(nextString, comboString + "x", comboList);
			letterCombinationHelper(nextString, comboString + "y", comboList);
			letterCombinationHelper(nextString, comboString + "z", comboList);
		}
	}

}
