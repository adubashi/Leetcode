package stackandqueue;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char exp[] = {'{','(',')','}','[',']'}; 
		String s = "{()}[]";
		System.out.println(isValid(s));

	}
	
	
	public static boolean isValid(String s) {
		Stack<Character> myStack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if(ch == '{' || ch == '[' || ch == '(') {
				myStack.push(ch);
			}
			if(ch == '}' || ch == ']' || ch == ')') {
				if (myStack.isEmpty())  { 
	               return false; 
	            }else if ( !isMatchingPair(myStack.pop(), ch) ) { 
	               return false; 
	            } 
			}
		}
		return true;
        
    }
	
	public static boolean isMatchingPair(char character1, char character2) 
    { 
       if (character1 == '(' && character2 == ')') 
         return true; 
       else if (character1 == '{' && character2 == '}') 
         return true; 
       else if (character1 == '[' && character2 == ']') 
         return true; 
       else
         return false; 
    }

}
