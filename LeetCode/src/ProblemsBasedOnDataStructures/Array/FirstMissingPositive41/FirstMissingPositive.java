package ProblemsBasedOnDataStructures.Array.FirstMissingPositive41;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedHashMap;

/*
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 */

public class FirstMissingPositive {
	/*
	 * 
	 * Sorting 
	 * O(nlogn) time
	 * O(1) space, but depends on the sort used
	 */
	public static int firstMissingPositiveSorting(int[] nums) {
		
		//Edge case: If the array is empty, the missing number is 1
		if(nums.length == 0){
			return 1;
		}
		Arrays.sort(nums);
		int result = 0;
		for(int i = 0; i < nums.length; i++){
			
			//Ignore all negative numbers 
			if(nums[i]  <= 0){
				continue;
			}
			
			if(nums[i] - result > 1){
				return result + 1;
			} else {
				result = nums[i];
			}
		}
		//Edge case: If we get to end of the array, the remaining missing positive is the
		// last number + 1
		return nums[nums.length - 1 ] + 1; 
    }
	
	//Using hash table
	//Add all numbers to a hash table 
	//O(n) time
	//O(n) space for the hashtable
	public static int firstMissingPositiveHash(int[] nums){
		Hashtable<Integer,Integer> numTable  = new Hashtable<Integer,Integer>();
		for(int i = 0; i < nums.length; i++){
			numTable.put(nums[i], 1);
		}
		for(int i = 1; i < Integer.MAX_VALUE; i++){
			if(numTable.get(i) == null){
				return i;
			}
		}
		//Should never happen
		return 0;	
	}
	
	public static void main(String args[]){
		
		int[] nums = {-1,0,2};
		int res = firstMissingPositiveHash(nums);
		
	}

}
