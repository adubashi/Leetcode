package Problems;

import java.util.Arrays;
import java.util.*;

public class groupAnagrams49 {
	public static boolean isAnagram(String s, String t){
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		
		return sArray.equals(tArray);         
    }
	
	public static List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> result = new ArrayList<List<String>>();
	 
	    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	    for(String str: strs){
	    	char[] arr = str.toCharArray();
	    	Arrays.sort(arr);
	    	String st = new String(arr);
	    	
	    	if(map.containsKey(st)){
	    		map.get(st).add(str);
	    	} else {
	    		List<String> nl = new ArrayList<String>();
	    		nl.add(str);
	    		map.put(st,nl);
	    	}
	    }
	    
	    //Sort each entry
	    for(Map.Entry<String, List<String>> entry: map.entrySet()){
	        Collections.sort(entry.getValue());
	    }
	 
	    //Return the values
	    result.addAll(map.values());
	 
	    return result;
	}

}
