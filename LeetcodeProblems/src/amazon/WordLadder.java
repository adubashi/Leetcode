package amazon;

import java.util.*;

public class WordLadder {
	/*
	 * 1. beginWord = "hit"
	 * 2. endWord = "cog" 
	 * 3. ["hot", "dot", "dog", "lot", "log", "cog"]
	 *  
	 *  Example Recursive solution: 
	 *  
	 *  For the beginning word check if it can be turned into any of the words in the list. --> function for if it can be transformed
	 *  and returns the new word.
	 *  
	 *  if(beginWord == endWord){
	 *  	   return 0;
	 *  }
	 *  
	 *  
	 *  String word = canBeTransformed(beginWord, wordList);
	 *  
	 *  Return 1 + ladderLength(beginWord, endWord, wordList);
	 *  
	 *  ----- Think of dynamic programming solution 
	 *  
	 *  
	 *  
	 *  
	 * 
	 * 
	 * 
	 * 
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) {
        		return 0;
        }
        String potentialTransform = canBeTransformed(beginWord, wordList);
           
        if(potentialTransform.equals("")) {
        	   return Integer.MAX_VALUE;
        }
        
        return  1 + ladderLength(potentialTransform, endWord, wordList);
    }
	
	public String canBeTransformed(String beginWord, List<String> wordList) {
		List<String> resultList = new ArrayList<String>();
		for(int i = 0; i < beginWord.length(); i++) {
			for(char alphabet = 'a'; alphabet <='z'; alphabet++ ) {
				String test = beginWord.substring(0, i) + alphabet + beginWord.substring(i+1, beginWord.length());
				if(wordList.contains(test)) {
					return test;
				}
			}
		}
		return "";
	}

}
