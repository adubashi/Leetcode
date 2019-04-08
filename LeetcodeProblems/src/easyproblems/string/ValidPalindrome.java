package easyproblems.string;

public class ValidPalindrome {
	
	public boolean isPalindrome(String s) {		 
		s = s.toLowerCase();
		int i = 0;
		int j = s.length() - 1;
		while(i<j){
	        while(i<j && isAlphanumeric(s.charAt(i))){
	            i++;
	        }
	        while(i<j && isAlphanumeric(s.charAt(j))){
	            j--;
	        }
	        if(s.charAt(i) != s.charAt(j)){
	            return false;
	        }
	        i++;
	        j--;
	    }	 
	    return true;
    }
	
	public boolean isAlphanumeric(char ch) {
		return !((ch>='a' && ch<='z') || (ch>='0'&&ch<='9'));
	}

}
