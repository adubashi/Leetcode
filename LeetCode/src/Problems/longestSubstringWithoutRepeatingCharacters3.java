package Problems;
import java.util.*;

public class longestSubstringWithoutRepeatingCharacters3 {
	
	public static void main(String args[]){
		
		//System.out.println(lengthOfLongestSubstring("aaabcfaa"));
		
		System.out.println(allUnique("abcdfl",0,6));
		System.out.println(allUnique("aacdfl",0,6));
		System.out.println(lengthOfLongestSubstringON3("aabbcl"));
		
	}
	//Geeks for Geeks solution
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
				cur_len = i - prev_index;
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
	//O(N^3) solution
	//Check if every substring has unique characters
	//N^2 subproblems, N time for each
	
	
	//Checks for all unique characters 
	public static boolean allUnique(String s, int start, int end){
		Set<Character> set = new HashSet<Character>();
		for(int i = start; i < end; i++){
			Character ch = s.charAt(i);
			if(set.contains(ch)){
				return false;
			}
			set.add(ch);
		}
		return true;
	}
	
	//Length of longest substring in O(N^3)
	public static int lengthOfLongestSubstringON3(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
        	for(int j = i + 1; j <= n; j++){
        		if(allUnique(s,i,j)){
        			ans = Math.max(ans, j - i);
        		}
        	}
        }
        return ans;
    }
	
	//O(2n) solution
	//Sliding window with a hashset
	/*
	 * A sliding window is an abstract concept commonly used in array/string problems. A window is a range of elements in the array/string which usually defined by the start and end indices, i.e. [i, j)[i,j) (left-closed, right-open). A sliding window is a window "slides" its two boundaries to the certain direction. 
	 * For example, if we slide [i, j)[i,j) to the right by 11 element, then it becomes [i+1, j+1)[i+1,j+1) (left-closed, right-open).
	Back to our problem. We use HashSet to store the characters in current window [i, j)[i,j) 
	(j = ij=i initially). Then we slide the index jj to the right. 
	If it is not in the HashSet, we slide jj further. 
	Doing so until s[j] is already in the HashSet. 
	At this point, we found the maximum size of substrings 
	without duplicate characters start with index ii. 
	If we do this for all ii, we get our answer.
	 */
	/*
	 * Time Complexity: O(2n)
	 * Space complexity : O(min(m, n))O(min(m,n)). Same as the previous approach.
	 *  We need O(k)O(k) space for the sliding window, where kk is the size of the Set. 
	 *  The size of the Set is upper bounded by the size of the string nn 
	 *  and the size of the charset/alphabet mm.
	 */
	public static int lengthOfLongestSubstringHashSet(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
        	if(!set.contains(s.charAt(j))){
        		set.add(s.charAt(j));
        		j++;
        		ans = Math.max(ans, j - i);
        	} else {
        		set.remove(s.charAt(i));
        		i++;
        	}
           
        }
        return ans;
    }
	/*
	 *  In fact, it could be optimized to require only n steps. 
	 *  Instead of using a set to tell if a character exists or not, 
	 *  we could define a mapping of the characters to its index. 
	 *  Then we can skip the characters immediately when we found a repeated character.
	 *  
	 *   The reason is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j'
	 *   we don't need to increase ii little by little.
	 *   We can skip all the elements in the range [i, j'][i,j] and let i to be j' + 1
	 * 
	 *   Time: O(N) time
	 *   Space: O(256) space
	 */
	public static int lengthOfLongestSubstringN(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; ++j) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
	
	
	
	
	
	

}
