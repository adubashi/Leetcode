package Problems;

import java.util.HashMap;

public class minimumWindowSubstring76 {
	/*
	 * 
	 * 1) Build a count array count[] for string 2. The count array stores counts of characters.
		count[‘i’] = 1
		count[‘t’] = 2
		count[‘s’] = 1

	2) Scan the string1 from left to right until we find all the characters of string2. 
	To check if all the characters are there, use count[] built in step 1.
	 So we have substring “this is a t” containing all characters of string2.
	  Note that the first and last characters of the substring must be present in string2.
	   Store the length of this substring as min_len.

	3) Now move forward in string1 and keep adding characters to the substring “this is a t”.
	 Whenever a character is added, check if the added character matches the left most character of substring.
	  If matches, then add the new character to the right side of substring and remove the leftmost character and all other extra characters after left most character.
	   After removing the extra characters, get the length of this substring and compare with min_len and update min_len accordingly.
	 */
	
	public static String minWindow(String s, String t){
		if(t.length()>s.length()) 
	        return "";
	    String result = "";
	 
	    //character counter for t
	    HashMap<Character, Integer> target = new HashMap<Character, Integer>();
	    for(int i=0; i<t.length(); i++){
	        char c = t.charAt(i);    
	        if(target.containsKey(c)){
	            target.put(c,target.get(c)+1);
	        }else{
	            target.put(c,1);  
	        }
	    }
	    

	    // character counter for s
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    int left = 0;
	    int minLen = s.length()+1;
	    int count = 0; // the total of mapped characters
	    
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	 
	        if(target.containsKey(c)){
	            if(map.containsKey(c)){
	                if(map.get(c)<target.get(c)){
	                    count++;
	                }
	                map.put(c,map.get(c)+1);
	            }else{
	                map.put(c,1);
	                count++;
	            }
	        }
	        
	        if(count == t.length()){
	            char sc = s.charAt(left);
	            while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
	                if (map.containsKey(sc) && map.get(sc) > target.get(sc))
	                    map.put(sc, map.get(sc) - 1);
	                left++;
	                sc = s.charAt(left);
	            }
	            if (i - left + 1 < minLen) {
	                result = s.substring(left, i + 1);
	                minLen = i - left + 1;
	            }
	        }
	        
	        
	    }
	 
	    return result;
	}

}
