package Problems;

import java.util.*;


public class wordPattern290 {
	
	public static void main(String args[]){
		System.out.println(wordPattern("abba","dog dog cat dog"));
	}
	
	
	
	public static boolean wordPattern(String pattern, String str) {
		String[] st = str.trim().split("\\s+");
		System.out.println(Arrays.toString(st));
		
		if(st.length != pattern.length()){
			return false;
		}
		
		Map<Character,String> map = new HashMap<Character,String>();
		for(int i = 0; i < pattern.length(); i++){
			char ch = pattern.charAt(i);
			String s = st[i];
			
			if(map.containsKey(ch)){
				if(!map.get(ch).equals(s)){
					return false;
				}
			} else {
				if(map.containsValue(s)){
					return false;
				}
				map.put(ch, s);
			}
		}
		
		
		return true;
	}
	
	

}
