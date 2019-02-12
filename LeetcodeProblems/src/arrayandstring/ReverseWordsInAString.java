package arrayandstring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given an input string, reverse the string word by word.
Example:  
Input: "the sky is blue",
Output: "blue is sky the".
 */

public class ReverseWordsInAString {
	
	public static void main(String args[]) {
		String s = "the sky is blue";
		
		String res = reverseWords(s);
		
		System.out.println(res);
		
	}
	
	//
	public static String reverseWords(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
        
        //If all spaces return s;
		if (!(s.trim().length() > 0)) {
			return "";
		}

		String[] array = s.trim().split(" ");
		List<String> list = Arrays.asList(array).stream().map(a -> a.trim())
            .filter(a -> a.trim().length() > 0 ).collect(Collectors.toList());
		Collections.reverse(list);
		System.out.println(list);
		
		if(list.size() == 1) {
			return list.get(0);
		}
		
		StringBuffer res = new StringBuffer();
		res.append(list.get(0));
		for(int i = 1; i < list.size(); i++) {
			res.append(" " + list.get(i));
		}
		return res.toString();
    }

}
