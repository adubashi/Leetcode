package ProblemsBasedOnDataStructures.Hashtable.LongestSubstringWithoutRepeatedCharacters3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class LongestSubstringWithoutRepeatedCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "";
		String s1 = "arjun";
		String s2 = "arjuna";
		
		
		String s3 = "abcabcbb";
		String s4 = "bbbbb";
		String s5 = "pwwkew";
		String s6 ="aaa";
		
		/*
		System.out.println(allUnique(s));
		System.out.println(allUnique(s1));
		System.out.println(allUnique(s2));
		System.out.println(longestSubstringWithoutRepeatedCharacters(s3));
		System.out.println(longestSubstringWithoutRepeatedCharacters(s4));
		System.out.println(longestSubstringWithoutRepeatedCharacters(s5));
		*/
		System.out.println(longestSubstringWithoutRepeatedCharactersHashtable(s3));
		//System.out.println(longestSubstringWithoutRepeatedCharactersHashtable(s4));
		//System.out.println(longestSubstringWithoutRepeatedCharactersHashtable(s5));
		System.out.println(longestSubstringWithoutRepeatedCharacters(s6));

	}
	
	/*
	 * 
	 * Checks if a string is all unique characters 
	 * 
	 * 
	 */
	public static boolean allUnique(String s){
		
		boolean[] array = new boolean[256];
		for(int i = 0; i < s.length(); i++){
			if(array[s.charAt(i)]){
				return false;
			} else {
				array[s.charAt(i)] = true;
			}
		}
		return true;
	}
	
	public static int longestSubstringWithoutRepeatedCharacters(String s){
		int maxLen = 0;
		//O(n^2) time for the outer loop
		//O(n^2 * n) = O(n^3) time total
		for(int i = 0; i < s.length(); i++){
			for(int j = i; j < s.length(); j++){
				//O(n) time
				String substring = s.substring(i, j+1);
				//System.out.println(substring);
				
				//O(n) time
				if(substring.length() > maxLen && allUnique(substring)){
					maxLen = substring.length();
				}
			}
		}
		
		return maxLen;
	}
	
	public static int longestSubstringWithoutRepeatedCharactersHashtable(String s){
		int maxLen = 0;
		int curLen = 0;
		Integer prev_index;
		Hashtable<Character,Integer> hashtable = new Hashtable<Character,Integer>();

		//Initialize the first character that is visited at 0
		hashtable.put(s.charAt(0), 0);
		for(int i = 1; i < s.length(); i++){
			char curCharacter = s.charAt(i);
			
			prev_index = hashtable.get(curCharacter);
			//System.out.println(prev_index);
			
			if(prev_index == null || i - curLen > prev_index){
				curLen++;
			} else {
				if(curLen > maxLen){
					maxLen = curLen;
				}
				curLen = i - prev_index;
			}
			hashtable.put(curCharacter, i);
		}
		if(curLen > maxLen){
			maxLen = curLen;
		}
		return maxLen;
	}
	
	
	public static int longestSubstringNoRepeatsHashset(String s){
		
		int backIndex, frontIndex;
		backIndex = 0;
		frontIndex = 0;
		HashSet<Character> hashset = new HashSet<Character>();
		int lengthOfString = s.length();
		
		int maxLength = 0;
		int currentLength = 0;
		
		
		while(backIndex < lengthOfString && frontIndex < lengthOfString){
			Character backCharacter = s.charAt(backIndex);
			Character frontCharacter = s.charAt(frontIndex);	
			if(hashset.contains(frontCharacter)){
				hashset.remove(backCharacter);
				backIndex++;
			} else {
				hashset.add(frontCharacter);
				frontIndex++;
				
				currentLength = frontIndex - backIndex;
				if(currentLength > maxLength){
					maxLength = currentLength;
				}
				
			}			
		}
		return maxLength;
	}
	/*
	 * int n = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        int currentDistance = 0;
        int maxLength = 0;
        HashSet<Character> hashset = new HashSet<Character>();
        
        while( i < n && j < n){
            
            if(hashset.contains(s.charAt(j))){
                hashset.remove(s.charAt(i));
                i++;
            } else {
                hashset.add(s.charAt(j));
                currentDistance = j - i  + 1;
                if( currentDistance > maxLength){
                    maxLength = currentDistance;
                }
                j++;
            }
        }
        
        return maxLength;
	 */
	
	/*
	 * 
	 * Same principle as a hash table, but uses a sliding window with a hash of Characters to indices 
	 * Use a for loop with i as the backindex and j as the frontindex
	 * 
	 * If a character is in the map, then move the current index to that point. 
	 * 
	 * 
	 * 
	 * Why do we put the character plus one past it's original position-> to make sure the 
	 * pointer j does not move back from it's original position. Keep it moving forward.
	 */
	
	
	
	public static int longestSubstringHashTable(String s){
		
		int i = 0;
		int j = 0;
		int ans = 0;
		HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
		for(j = 0; j < s.length(); j++){
			if(hash.containsKey(s.charAt(j))){
				i = Math.max(i, hash.get(s.charAt(j)));	
			} 
			ans = Math.max(ans, j - i + 1);	
			hash.put(s.charAt(j), j+1);
		}
		
		return ans;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
