package Problems;

import java.util.*;

public class SimplifyPath71 {

	public static void main(String[] args) {
		String a = "/a/./b/../../c/";// /c
		String b = "/home/"; // /home
		
		System.out.println(simplifyPath(a));
		
	}
	
	public static String simplifyPath(String path) {
		String[] paths = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for(String s : paths){
        	if(s.equals(".")){
        		//do nothing
        	} else if(s.equals("..")) {
        		//If the stack is not empty
        		if(!stack.isEmpty()){
        			stack.pop();
        		}
        	} else if(s.length() > 0){
        		stack.push(s);
        	}
        }
        
        //Now we have the shortened path, just add in /s to make properly formatted unix path
        StringBuilder sb = new StringBuilder();
        for(String s : stack){
        	sb.append("/" + s);
        }
        if (sb.length() == 0) 
            sb.append("/");
        return sb.toString();
    }

}
