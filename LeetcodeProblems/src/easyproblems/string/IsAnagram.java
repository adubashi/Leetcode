package easyproblems.string;

public class IsAnagram {
	
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		
		int[] array = new int[256];
		for(int i = 0; i < s.length(); i++) {
			array[s.charAt(i)]++;
		}
		
		for(int j = 0; j < t.length(); j++) {
			array[t.charAt(j)]--;
			
			if(array[t.charAt(j)] < 0) {
				return false;
			}
		}
		return true;   
    }

}
