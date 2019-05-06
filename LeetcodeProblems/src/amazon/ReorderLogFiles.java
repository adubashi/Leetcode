package amazon;

import java.util.*;
import java.util.stream.Collectors;

public class ReorderLogFiles {
	
	public static String[] reorderLogFiles(String[] logs) {
		//0. log array to list 
	    //1. Filter the strings into the different types, letter logs and digit logs
	    //2. sort the letter logs with a comparator
	    // - get rid of the identifier. If they are the same, then use the identifier.
	    //3. Add the new letter logs  + the original digit logs
        List<String> list =  Arrays.asList(logs);
        
        List<String> letterLogs = list.stream().filter(string -> !isAllDigits(string.split("\\s+")[1])).collect(Collectors.toList());
        List<String> digitLogs = list.stream().filter(string -> isAllDigits(string.split("\\s+")[1])).collect(Collectors.toList());
        
        //Sort letter logs
        Comparator<String> letterLogComparator = new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				String logFile1 = o1.substring(o1.indexOf(" "), o1.length());
				String logFile2 = o2.substring(o2.indexOf(" "), o2.length()); 
				if(logFile1.equals(logFile2)) {
					String identifier1 = o1.substring(0, o1.indexOf(" "));
					String identifier2 = o2.substring(0, o2.indexOf(" "));
					return identifier1.compareTo(identifier2);
				} else {
					return logFile1.compareTo(logFile2);
				}
			}
        };
        
        Collections.sort(letterLogs, letterLogComparator);
        List<String> returnedList = new ArrayList<String>();
       
        for(int i = 0; i < letterLogs.size(); i++) {
        		returnedList.add(letterLogs.get(i));
        }
        for(int i = 0; i < digitLogs.size(); i++) {
    			returnedList.add(digitLogs.get(i));
        }
           
        	return Arrays.copyOf(returnedList.toArray(), returnedList.size(), 
					String[].class);
    }
	
	private static boolean isAllDigits(String s) {
		for(Character ch : s.toCharArray()) {
			if(!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}
	

}
