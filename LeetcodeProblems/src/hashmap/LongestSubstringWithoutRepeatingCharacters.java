package hashmap;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String args[]) {
		String s = "aab";
		int res = lengthOfLongestSubstringEfficientMap(s);
		System.out.println(res);
	}
	
	
	//Brute Force solution, try all combinations
	public static int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j <= s.length(); j++) {
				Set<Character> set = new HashSet<>();
				int length = 0;
				for(int k = i; k < j; k++) {
					Character ch = s.charAt(k);
					if(set.contains(ch)) {	
					   break; 
					} else {
						set.add(ch);
					   length++;	
					}
					if(length > maxLength) {
						maxLength = length;
					}
				}
				
			}
		}
		return maxLength;
    }
	/*
	 * Use a sliding window with a hashset 
	 * 
	 */
	public static int lengthOfLongestSubstringEfficient(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while( i < s.length() && j < s.length()){
        		Character ch = s.charAt(j);
        		if(!set.contains(ch)) {
        			set.add(ch);
        			j++;
        			if(j - i > ans) {
        				ans = j - i;
        			}
        		} else {
        			set.remove(s.charAt(i));
        			i++;
        		}
        }
		return ans;
	}
	
	public static int lengthOfLongestSubstringEfficientMap(String s) {
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        int i = 0, j = 0;
        while( i < n && j < n) {
        		Character ch = s.charAt(j);
        		if (map.containsKey(ch)) {
                i = Math.max(map.get(ch), i);
            }
        		ans = Math.max(ans, j - i + 1);
        		map.put(ch, j + 1);
        		j++;
        }
        return ans;
		
	}

}
