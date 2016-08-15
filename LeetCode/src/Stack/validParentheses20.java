package Stack;


import java.util.Stack;
public class validParentheses20 {
	
	public static boolean isValid(String s){
		Stack<Character> stk = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '[' || ch == '{'){
              stk.push(ch);  
            } else if(ch == ')' || ch == ']' || ch == '}'){
                if(ch == ')') {
                    if(stk.isEmpty() || stk.pop() != '('){
                       return false;
                    } 
                } else if( ch == ']'){
                    if(stk.isEmpty() || stk.pop() != '['){
                       return false;
                    } 
                } else if( ch == '}'){
                    if(stk.isEmpty() || stk.pop() != '{'){
                       return false;
                    } 
                }
            }
        }
        return stk.isEmpty();
	}

}
