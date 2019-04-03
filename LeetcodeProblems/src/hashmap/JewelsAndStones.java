package hashmap;

import java.util.*;

public class JewelsAndStones {
	
	public static void main(String args[]) {
		String J = "aA";
		String S = "aAAbbbb";
		
		String J1 = "z";
		String S1 = "ZZ";
		
		int k = numJewelsInStones(J, S);
		int k1 = numJewelsInStones(J1, S1);
		
		System.out.println(k);
		System.out.println(k1);
	}
	
	
	public static int numJewelsInStones(String J, String S) {
		//Create a hashset
		Set<Character> set = new HashSet<Character>();
		
		for(int i = 0; i < J.length(); i++) {
			set.add(J.charAt(i));
		}
		int ans = 0;
		for(int j = 0; j < S.length(); j++) {
			if(set.contains(S.charAt(j))) {
			   ans++;
			}
		}
		return ans;
        
    }

}
