package ProblemsBasedOnDataStructures.DynamicProgramming.LongestValidParentheses32;
import java.util.Stack;

public class LongestValidParentheses {
	
	
	public static void main(String args[]) {
		
		
		System.out.println(isBalanced("(())"));
		System.out.println(isBalanced("(()"));
		
		System.out.println(longestValidParentheses(")))))))))))"));
	}
	
	//Push open, pop closing
	public static boolean isBalanced(String s) {
		Stack<Character> stk = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
				char mCharacter = s.charAt(i);
				
				if(mCharacter == '(') {
					stk.push(mCharacter);
				} else if(mCharacter == ')') {
					 if(stk.isEmpty() || stk.pop() != '(') {
		                    return false;
		             }
				}
				
		}
		return stk.isEmpty();
	}
	
	
	public static int longestValidParenthesesNaive(String s) {
		int maxLength = 0;
		for(int i = 0; i < s.length(); i++) {
			for(int j = i; j < s.length(); j++) {
				String mString = s.substring(i, j+1);
				if(isBalanced(mString)) {
					if(mString.length() > maxLength) {
						maxLength = mString.length();
					}
				}	
			}
		}	
		return maxLength;
	}
	
	
	public static int longestValidParentheses(String s) {
		
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(-1);
		int maxAns = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == '(') {
			   stk.push(i);
			} else {
				//Closing brace
				stk.pop();
				int currentLength = i  - stk.peek();
				
				if(stk.isEmpty()) {
					stk.push(i);
				} else {
					maxAns = Math.max(maxAns, currentLength);
				}
				
			}
	
		}
		return maxAns;
	}

}
