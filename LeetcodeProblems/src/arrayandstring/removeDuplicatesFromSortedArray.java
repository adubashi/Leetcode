package arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.apple.eawt.AppEvent.SystemSleepEvent;

public class removeDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {0,0,1,1,1,2,2,3,3,4};
		int res = removeDuplicates(array);
		System.out.println(res);

	}
	/*
	 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
	   Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
	 */
	
	/*
	 * 1. Create an auxiliary array temp[] to store unique elements.
	   2. Traverse input array and one by one copy unique elements of arr[] to temp[]. 
       3. Also keep track of count of unique elements. Let this count be j.
       - Copy j elements from temp[] to arr[] and return j
	 * 
	 */
	public static int removeDuplicatesExtraSpace(int[] nums) {
		
		//List to store temp elements
		List<Integer> tempList = new ArrayList<Integer>();
		
		
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return 1;
		}
		
		int uniqueElementCount = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[i - 1]) {
				tempList.add(nums[i]);
				uniqueElementCount++;
			}
		}
		
		//Fill in array
		for(int k = 0; k < uniqueElementCount; k++) {
			nums[k] = tempList.get(k);
		}
		System.out.println(Arrays.toString(nums));
		return uniqueElementCount;
	
    }
	
	public static int removeDuplicates(int[] nums) {
	
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return 1;
		}
		
		int uniqueElementIndex = 0;
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] != nums[i + 1]) {
				nums[uniqueElementIndex] = nums[i];
				uniqueElementIndex++;
			}
		}
		nums[uniqueElementIndex] = nums[nums.length - 1]; 
		return uniqueElementIndex + 1;
    }

}
