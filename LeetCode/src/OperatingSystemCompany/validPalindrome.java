package OperatingSystemCompany;

public class validPalindrome {
	
	 public static void main(String args[]){
		 
	 }
	
	 public boolean isPalindrome(String s) {
         if (s.isEmpty()) {
            return true;
         }
         
         int head = 0;
         int tail = s.length() - 1;
         
         while(head < tail){
        	 if (!Character.isLetterOrDigit(s.charAt(head))) {
                 head++;
             } else if(!Character.isLetterOrDigit(s.charAt(tail))){
            	 tail--;
             } else {
	        	 if(s.charAt(head) != s.charAt(tail)){
	        		 return false;
	        	 }
	        	 head++;
	        	 tail--;
             }
         }
         return true;
	 }

}
