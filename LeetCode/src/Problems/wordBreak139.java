package Problems;

import java.util.*;

public class wordBreak139 {
	
	public static boolean wordBreak(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
	}
	
	public static boolean wordBreakHelper(String s, Set<String> dict, int start){
		if(start == s.length()){
			return true;
		}
		
		for(String a: dict){
			int len = s.length();
			int end = start + len;
			if(end > s.length()){
				continue;
			}
			if(s.substring(start, start+len).equals(a)){
				if(wordBreakHelper(s,dict,start+len)){
					return true;
				}
			}	
		}
		return false;
	}
	
	/*
	 * Define an array t[] such that t[i]==true => 0-(i-1) can be segmented using dictionary
	 * Initial state t[0] == true
	 */
	public static boolean wordBreak2(String s, Set<String> dict){
		boolean[] t = new boolean[s.length()+1];
		t[0] = true;
		
		for(int i = 0; i < s.length(); i++){
			if(!t[i]){
				continue;
			}
			for(String a: dict){
				int len = a.length();
				int end = i + len;
				if(end > s.length()){
					continue;
				}
				if(t[end]){
					continue;
				}
				if(s.substring(i, end).equals(a)){
					t[end] = true;
				}
			}
		}
		return t[s.length()];
	}
	
	public static void main(String args[]){
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		
		String tst = "leetcode";
		
		System.out.println(wordBreak3(tst,dict));
	}
	
	public static boolean wordBreak3(String s, Set<String> wordDict) {
		int[] pos = new int[s.length()+1];
		 
	    Arrays.fill(pos, -1);
	 
	    pos[0]=0;
	 
	    for(int i=0; i<s.length(); i++){
	        if(pos[i]!=-1){
	            for(int j=i+1; j<=s.length(); j++){
	                String sub = s.substring(i, j);
	                if(wordDict.contains(sub)){
	                    pos[j]=i;
	                }
	            } 
	        }
	    }
	 
	    return pos[s.length()]!=-1;
	}

}
