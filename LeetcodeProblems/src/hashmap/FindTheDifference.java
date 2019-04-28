package hashmap;

import java.util.*;

public class FindTheDifference {
	
	public static void main(String args[]) {
		String s = "abce";
		String t = "abced";
		findTheDifference(s, t);
		
		
	}
	
	public static char findTheDifference(String s, String t) {
		/*
		 * 1. Calculate character map for s string, used a character array, based on String s
		 * 2. Decrement the character map, based on t. 
		 */
		int[] array = new int[26];
		Arrays.fill(array, 0);
		for(int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
			array[(char)s.charAt(i) - 'a' ]++;
		}
		
		System.out.println(Arrays.toString(array));
		
		for(int i = 0; i < t.length(); i++) {
			array[t.charAt(i) - 'a']--;
			System.out.println(array[t.charAt(i) - 'a']);
			if(array[t.charAt(i)- 'a'] < 0 ) {
				return t.charAt(i);
			}
		}
		
		
		return 'd';
    }
	
	

	

}
