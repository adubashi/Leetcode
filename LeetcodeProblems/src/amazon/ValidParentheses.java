package amazon;

import java.util.*;

public class ValidParentheses {
	
	public boolean isValid(String s) {
		Stack<Character> stk = new Stack<Character>();
		
		for(int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			
			if(ch == '(' || ch == '{' || ch == '[') {
			  stk.push(ch);
			}
			if(ch == ')' || ch == '}' || ch == ']') {
			  if(!stk.isEmpty()) {
				  Character top = stk.pop();
				  if(!isMatchingPair(ch, top)) {
					  return false;
				  }
			  } else {
				  return false;
			  }
			}
		}
		
		return stk.isEmpty();
		
        
    }
	
	public boolean isMatchingPair(Character ch, Character ch1) {
		if(ch == '(' && ch1 == ')') {
		   return true;
		} else if(ch == '{' && ch1 == '}') {
			return true;
		} else if(ch == '[' && ch1 == ']') {
			return true;
		} else {
			return false;
		}
	}

}
