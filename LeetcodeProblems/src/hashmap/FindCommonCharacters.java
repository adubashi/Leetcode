package hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;

public class FindCommonCharacters {
	
	
	public static void main(String args[]) {
		String[] A = {"bella","label","roller"};
		commonChars(A);
	}
	
	/*
	 * Create a list of character maps, one for each string. 
	 * Get the minimum of each character from the maps
	 * 
	 */
	public static List<String> commonChars(String[] A) {
		List<String> ans = new ArrayList<>();
        if (A == null || A.length == 0) {
            return ans;
        }
        int[][] map = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                map[i][A[i].charAt(j) - 'a']++;
            }
        }
		//Have a second character map to hold the minimums
        Map<Character, Integer>  minMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < 26; i++) {
        		int common = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                common = Math.min(common, map[j][i]);
            }
            minMap.put((char)(i + 'a'), common);
        }
        System.out.println(minMap);
        for(Character c : minMap.keySet()) {
        		if(minMap.get(c) > 0) {
        		   	int count = minMap.get(c);
        		   	for(int k = 0; k < count; k++) {
        		   		ans.add(c.toString());
        		   	}
        			
        		}
        }
        System.out.println(ans);
        return ans;
    }

}
