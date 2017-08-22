package ProblemsBasedOnDataStructures.DynamicProgramming.EditDistance72;

public class EditDistance {
	/*
	Given two words word1 and word2, find the minimum number
	 of steps required to convert word1 to word2.
	  (each operation is counted as 1 step.)

	You have the following 3 operations permitted on a word:

	a) Insert a character
	b) Delete a character
	c) Replace a character
	*/
	
	public static int minDistance(String word1, String word2) {
		return minDistance(word1,word2,word1.length(),word2.length());
	}
	
	//First Attempt 
	public static int minDistance(int index, String word1, String word2) {
		if(word1.equals(word2)) {
			return 0;
		} else if(word1.charAt(index) == word2.charAt(index)) {
			return 0 + minDistance(index+1,word1.substring(1,word1.length()),
					   word2.substring(1,word2.length()));
		} else {	
			return 1;
				   //Delete 

				   //Insert
			
				   //Change the character
		}
	}

	
	//Second Attempt 
	//Uses two indexes --> one for each string 
	
	public static int minDistance(String word1, String word2, int index1, int index2) {
		//If word1 is 0, then we just need to get rid of all the letters in word2
		if(index1 == 0) {
			return index2;
		}
		// If word2 is 0, then we need add all the characters from word1 to word2.
		if(index2 == 0) {
			return index1;
		}
		
		if(word1.charAt(index1) == word2.charAt(index2)) {
			return 0 + minDistance(word1,word2,index1+1,index2+1);
		} else {
			return 1 + 
				  min(
				  //Delete 
				  minDistance(word1,word2,index1-1,index2),
				  //Replace
				  minDistance(word1,word2,index1-1,index2-1),
				  //Add
				  minDistance(word1,word2,index1,index2-1)			  
				  );
		}		
	}
	
	public static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
}
