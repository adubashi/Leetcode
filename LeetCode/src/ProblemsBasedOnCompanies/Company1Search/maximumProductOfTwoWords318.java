package Company1Search;

import java.util.Arrays;

public class maximumProductOfTwoWords318 {
	
	public static void main(String args[]){
		
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		String[] test = {"abcd", "aefg"};
		String[] noCommon = { "a", "aa", "aaa", "aaaa" };
		int cd = maxProduct(test);
		
		System.out.println(cd);
		//maxProduct(noCommon);
	}
	
	
	
	public static int maxProduct(String[] words) {
		if (words == null || words.length <= 1) {
            return 0;
        }
         
        int n = words.length;
        int[] encodedWords = new int[n];
         
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                encodedWords[i] |= (1 << (c - 'a'));
                System.out.println(Integer.toBinaryString(encodedWords[i]));
                //System.out.println(encodedWords[i]);
            }
        }
         
        System.out.println(Arrays.toString(encodedWords));
        for(Integer i : encodedWords){
        	System.out.println(Integer.toBinaryString(i));
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((encodedWords[i] & encodedWords[j]) == 0) {
                    maxLen = Math.max(maxLen, 
                        words[i].length() * words[j].length());
                }
            }
        }
         
        return maxLen;
        
    }
	
	


}
