package amazon;

public class LongestPalindromicSubstring {
	
	
	public static void main(String args[]) {
		System.out.println(isPalindrome("baab"));
	}
	
	public static String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        
        
        int maxLen = 0;
		String maxSub = "";
		for(int i = 0; i < s.length(); i++) {
			for(int j = i; j < s.length(); j++) {
				if(isPalindrome(s.substring(i, j+1))) {
					
					if(s.substring(i, j+1).length() > maxLen) {
						maxLen =  s.substring(i, j+1).length();
						maxSub = s.substring(i, j+1);
					}
				}
			}
		}
		return maxSub;
    }
	
	public  static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		
		while(i < j) {
			if(!(s.charAt(i) == s.charAt(j))) {
				return false;
			}
			
			
			i++;
			j--;
		}
		return true;
	}

}
