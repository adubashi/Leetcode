package arrayandstring;

public class StrStr {
	
	public static void main(String args[]) {
		//haystack = "hello", needle = "ll"
		
		int result = strStrKMP("hello","ll");
		System.out.println(result);
	}
	/*
	 * 
	 * Implement Strstr 
	 * 
	 * Implement strStr().
     * Return the index of the first occurrence of needle in haystack,
     *  or -1 if needle is not part of haystack.
     *  
     *  Naive solution:
     *  Iterate from the start of the string to the end of the string, search starting at
     *  each index. 
     *  
     *  substringAtIndex -> check if the substring exists starting at index for the string S.
	 */
	
	/*
	 * Complex Solution: KMP algorithm
	 * https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
	 * 
	 * 1. Construct an LPS array = longest proper prefix which is also suffix
	 * - For example, prefixes of “ABC” are “”, “A”, “AB” and “ABC”.
	 *  Proper prefixes are “”, “A” and “AB”
	 * - We search for lps in sub-patterns.
	 * - For each sub-pattern pat[0..i] where i = 0 to m-1,
	 *  lps[i] stores length of the maximum matching proper prefix
	 *   which is also a suffix of the sub-pattern pat[0..i].
	 * For each sub-pattern pat[0..i] where i = 0 to m-1, lps[i] stores
	 * length of the maximum matching proper prefix 
	 * which is also a suffix of the sub-pattern pat[0..i].
	 * -lps[i] = the longest proper prefix of pat[0..i] 
              which is also a suffix of pat[0..i].  
	 * 
	 * https://web.stanford.edu/class/cs97si/10-string-algorithms.pdf
	 * 
	 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
	 * 
	 * 
	 * 
	 */
	public static int strStr(String string, String str) {
		int i = 0;
		for(i = 0; i < string.length(); i++) {
			int index = substringAtIndex(string, str, i);
			if(index != -1) {
			   return index;	
			}
		}
		return -1;
    }
	
	public static int substringAtIndex(String string, String str, int index) {
		int m = index;
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(string.charAt(m) == str.charAt(i)) {
				count++;
				if(count == str.length()) {
					return m;
				}
				m++;	
			} 
		}
		return -1;
	}
	
	
	public static int[] computeLPSArray(String pattern, int m) {	
		int len = 0;
		int i = 1;
		int[] lps = new int[m];
		lps[0] = 0;
		
		// the loop calculates lps[i] for i = 1 to M-1
		while(i < m) {
			if(pattern.charAt(i) == pattern.charAt(len)) {
				len++; 
                lps[i] = len; 
                i++;
			} else {
				// (pat[i] != pat[len]) 
				if (len != 0) { 
                    len = lps[len - 1];    
                } else { 
                    lps[i] = len; 
                    i++; 
                } 
			}	
		}
		return lps;
	}
	
	public static int strStrKMP(String haystack, String needle) {
		if(needle.equals("")){
            return 0;
        }
		//Get the longest proper prefix array
		int[] longestProperPrefixArray = computeLPSArray(needle, needle.length());
		
		int i = 0;
		int j = 0;
		while( i < haystack.length()) {
			if (needle.charAt(j) == haystack.charAt(i)) { 
                j++; 
                i++; 
            }
			if(j == needle.length()) {
				return (i - j);
			} else if(i < haystack.length() &&
					needle.charAt(j) != haystack.charAt(i)) {
				if(j != 0) {
					j = longestProperPrefixArray[j - 1]; 
				} else {
					i++;
				}
			}
		}
		return -1;
    }

}
