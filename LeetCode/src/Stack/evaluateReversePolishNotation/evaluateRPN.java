package Stack.evaluateReversePolishNotation;

import java.util.*;

public class evaluateRPN {
	
	public static int evalRPN(String[] tokens) {
		int returnValue = 0;
		String operators = "+-*/";
 
		Stack<String> stack = new Stack<String>();
		
		for(String t : tokens){
			if (!operators.contains(t)) { //push to stack if it is a number
				stack.push(t);
			} else {
				Integer a = Integer.valueOf(stack.pop());
				Integer b = Integer.valueOf(stack.pop());
				switch (t) {
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;
				}
			}		
		}
		returnValue = Integer.valueOf(stack.pop());
		return returnValue;
        
    }

}
