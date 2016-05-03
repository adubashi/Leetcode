package Problems;

public class longestSubstringWithoutRepeatingCharacters3 {
	
	public static void main(String args[]){
		
		System.out.println(lengthOfLongestSubstring("aaabcfaa"));
		
	}
	
	
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int cur_len = 1;
		int max_len = 1;
		int prev_index;
		int i;
		
		int[] visited = new int[256];
		
		//Set all visited to -1
		for(i = 0; i < 256; i++){
			visited[i] = -1;
		}
		
	    /* Mark first character as visited by storing the index
	       of first character in visited array. */
		visited[s.charAt(0)] = 0;
		
		for(i = 1; i < n; i++){
			prev_index = visited[s.charAt(i)];
			
			/* If the current character is not present in the
	           already processed substring or it is not part of
	           the current NRCS, then do cur_len++ */
			if(prev_index == -1 || i - cur_len > prev_index){
				cur_len++;
			} else {
				/* If the current character is present in currently
		           considered NRCS, then update NRCS to start from
		           the next character of previous instance. */
				
				/* Also, when we are changing the NRCS, we
	               should also check whether length of the
	               previous NRCS was greater than max_len or
	               not.*/
				if(cur_len > max_len){
					max_len = cur_len;
				}
				cur_len = i - max_len;
			}
			
			// update the index of current character
			visited[s.charAt(i)] = i;
		}
		
		// Compare the length of last NRCS with max_len and
	    // update max_len if needed
	    if (cur_len > max_len){
	        max_len = cur_len;
	    }
		return max_len;
    }

}
