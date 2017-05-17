package Company1Social;

public class regularExpressionMatching10 {
	
	public static boolean matches(String pattern, String str) {
		
		// base case 1: we came to end in both string and pattern -> matched
        if (str.length() == 0 && pattern.length() == 0) {
            return true;
        }
        
        // base case 2: we came to end in string, but pattern contains more symbols (and it is not '*')
        if (pattern.charAt(0)=='*' && pattern.length() != 1 && str.length() == 0) {
            return false;
        }
        // checking the next symbol matching
        if (charsMatch(pattern, '?') || charsMatch(pattern, str)) {
            return matches(pattern.substring(1), str.substring(1));
        }
        // checking wildcard - there are two scenarios: either we skip the wildcard, or we skip the next symbol
        if (charsMatch(pattern, '*')) {
            return matches(pattern.substring(1), str) || matches(pattern, str.substring(1));
        }
        return false;
	}
	
	private static boolean charsMatch(String s, char ch) {
        return s.length() > 0 && s.charAt(0) == ch;
    }
    private static boolean charsMatch(String s, String p) {
        return s.length() > 0 && p.length() > 0 && s.charAt(0) == p.charAt(0);
    }
    
    
    public static boolean isMatch(String s, String p) {
    	 
        if(p.length() == 0)
            return s.length() == 0;
 
        //p's length 1 is special case    
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));    
 
        }else{
            int len = s.length();
 
            int i = -1; 
            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatch(s.substring(i+1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        } 
    }

}
