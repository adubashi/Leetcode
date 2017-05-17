package Company1Search;

public class WildcardMatching44 {
	/*
	 * 4 variables:
	 * str --> string to be matched 
	 * pattern --> string matched 
	 * s: the cursor in str
	   p: the cursor in p 
	 * StarIdx: the place of the last encountered * (Initialize as -1)
	   match: the place in str, when p encountered a *
	 * ----------------------------------------------------
	  If p and s match, p++, s++
	  
	  If p and s do not match, and p encounter a *: 
	  remember the current place of p and s in ‘StarIdx’ and ‘match’. Then, p++l .
	  
	  If p and s do not match, and p does not encounter a *,
	  but StarIdx is not  -1: update p as StarIdx+1, update match as match+1, update s as match
	  
	  If p and s do not match, and p does not currently at a *, and p does not ever encountered an * before,
	   we can decide, the two string do not match. Return false;
	  


	 * -----------------------------------------------------
	 */
	//Greedy Algorithm
	public static boolean isMatch(String str, String pattern) {
		
		int s = 0;
		int p = 0;
		int starIndex = -1;
		int match = 0;
		
		while(s < str.length()){
			if(p < pattern.length() && (pattern.charAt(p) == str.charAt(s) || pattern.charAt(p) == '?')){
				s++;
				p++;
			} else if((pattern.charAt(p) != str.charAt(s)) &&  pattern.charAt(p) == '*'){
				starIndex = p;
				match = s;
				p++;		
			} else if(starIndex != -1 ){
				match++;
                s = match;
                p = starIndex + 1; 
			} else {
				return false;
			}		
		}
		
		while (p < pattern.length() && pattern.charAt(p) == '*'){
	        p++;
		}
	    return p == pattern.length();
    }
	
	/*
	 * 
	 * Recursive/ DP method
	 * 1. Regular case: if two chars are the same, or p is ‘?’, then go to check dp[i-1][j-1]
	   2. Special case: when p is ‘*’, we need to check dp[i-1][j-1] for every i>0. If there is one true, then the answer is true.
	 */
	
	//DP solution that doesn't handle edge cases
	public static boolean isMatchDP(String str, String pattern) {
		int width = str.length();
        int height = pattern.length();
         
        boolean[][] dp = new boolean[width + 1][height + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= width; i++){
            for (int j = 1; j <= height; j++){
            	if (str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                } else if(pattern.charAt(j-1) == '*') {
                	int cur = i;
                    while (cur > 0){
                        if (dp[cur-1][j-1]){
                            dp[i][j]= true;
                            break;
                        }
                        cur--;
                    }      	
                }
            }
        }
        return dp[width][height];
		
	}
	
	//Handles Edge cases
    public static boolean isMatch1(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        int lens = s.length();
        int lenp = p.length();
        
        boolean[][] D = new boolean[lens + 1][lenp + 1];
        
        boolean flag = false;
        
        for (int i = 0; i <= lens; i++) {
            flag = false;
            for (int j = 0; j <= lenp; j++) {
                // both is empty.
                if (i == 0 && j == 0) {
                    D[i][j] = true;
                    flag = true;
                    continue;
                }
                
                // if P is empty, s is not empty, it is false.
                if (j == 0) {
                    D[i][j] = false;
                    continue;
                }
                
                // if S is empty, P is not empty
                if (i == 0) {
                    D[i][j] = D[i][j - 1] && p.charAt(j - 1) == '*';
                } else {
                    D[i][j] = (matchChar(s.charAt(i - 1), p.charAt(j - 1)) && D[i - 1][j - 1])
                      || (p.charAt(j - 1) == '*' && (D[i][j - 1] || D[i - 1][j]));    
                }
                
                if (D[i][j]) {
                    flag = true;
                }
                
                if (D[i][j] && p.charAt(j - 1) == '*' && j == lenp) {
                    return true;
                }
            }
            
            if (!flag) {
                return false;
            }
        }
        
        return D[lens][lenp];
    }
    
    public static boolean matchChar(char c, char p) {
        return (p == '?' || p == c);
    }
	
	

}
