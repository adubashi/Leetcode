package Problems;
import java.util.*;

public class letterCombinationsOfaPhoneNumber17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Combination("","23");

	}
	
	public static String[] keypad = {null, null, "abc","def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
	
	//Assume no 0s or 1s
	//Simple recursion(just prints combinations)
	public static void Combination(String prefix, String num){
		if(num.length()==0) {
            System.out.println(prefix);
		}else {      
            int x = Integer.parseInt(num.charAt(0)+"");
            String temp = new String();
            temp = keypad[x];
            for(int j=0;j<temp.length();j++){
               Combination(prefix+temp.charAt(j),num.substring(1,num.length()));
            } 
		}
	}
	
	//Stores the combos in an arraylist
	public static List<String> letterCombinations(String digits) {
	    HashMap<Integer, String> map = new HashMap<Integer, String>();
	    map.put(2, "abc");
	    map.put(3, "def");
	    map.put(4, "ghi");
	    map.put(5, "jkl");
	    map.put(6, "mno");
	    map.put(7, "pqrs");
	    map.put(8, "tuv");
	    map.put(9, "wxyz");
	    map.put(0, "");
	 
	    ArrayList<String> result = new ArrayList<String>();
	 
	    if(digits == null || digits.length() == 0)
	        return result;
	 
	    ArrayList<Character> temp = new ArrayList<Character>();
	    getString(digits, temp, result, map);
	 
	    return result;
	}
	
	//Stores the combinations in a list
	public static void getString(String digits, ArrayList<Character> temp, ArrayList<String> result,  HashMap<Integer, String> map){
	    if(digits.length() == 0){
	        char[] arr = new char[temp.size()];
	        for(int i=0; i<temp.size(); i++){
	            arr[i] = temp.get(i);
	        }
	        result.add(String.valueOf(arr));
	        return;
	    }
	 
	    Integer curr = Integer.valueOf(digits.substring(0,1));
	    String letters = map.get(curr);
	    for(int i=0; i<letters.length(); i++){
	        temp.add(letters.charAt(i));
	        getString(digits.substring(1), temp, result, map);
	        temp.remove(temp.size()-1);
	    }
	}

}
