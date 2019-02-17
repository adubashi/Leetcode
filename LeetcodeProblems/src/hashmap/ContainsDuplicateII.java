package hashmap;

import java.util.HashMap;

import java.util.Map;
/*
 * Contains Duplicate II
  Go to Discuss
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
 */
public class ContainsDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		//Initialize a map
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < nums.length; i++) {
			int elem = nums[i];
			
			if(map.containsKey(elem)) {
				int prevIndex= map.get(elem);
				int currentIndex = i;
				
				int diff = Math.abs(currentIndex - prevIndex);
				min = Math.min(diff, min);
			} 
			map.put(elem, i);
		}
		
		if(min <= k) {
			return true;
		} else {
			return false;
		}
        
    }

}
