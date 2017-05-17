package Company1Search;
import java.util.*;
public class generateParentheses22 {
	
	public static void main(String args[]){
		
		System.out.println(generateParenthesis(3));
		
	}
	
	public static List<String> generateParenthesis(int n) {
	    List<String> result = new ArrayList<String>();
	    generate("", result, n, n);
	    return result;
	}
	public static void generate(String s, List<String> result, int left, int right){
		//Base Case
		if(left > right)
	        return;
	 
		//N = 0
	    if(left==0&&right==0){
	        result.add(s);
	        return;
	    }
	    
	    if(left > 0){
	    	generate(s + "(", result,left-1,right);
	    }
	    if(right > 0){
	    	generate( s + ")", result,left,right-1);
	    }
	    
		
	}

}
