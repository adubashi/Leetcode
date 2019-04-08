package easyproblems.array;

import java.lang.reflect.Array;

public class RemoveDuplicatesFromSortedArray {
	
	public int removeDuplicates(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return 1;
		}
		//Keep an index of the unique element, while iterating through it. This is what we'll return to the client
		int uniqueElementIndex = 0; 
		for(int i = 1; i < nums.length; i++) {
			if(nums[i-1] != nums[i]) {
				nums[uniqueElementIndex] = nums[i-1];
				uniqueElementIndex++;
			} 
		}
		nums[uniqueElementIndex++] = nums[nums.length-1];
		return uniqueElementIndex + 1;
        
    }

}
