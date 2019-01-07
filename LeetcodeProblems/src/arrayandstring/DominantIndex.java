package arrayandstring;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DominantIndex {
	/*
	 * In a given integer array nums, there is always exactly one largest element.
	  Find whether the largest element in the array 
	  is at least twice as much as every other number in the array.
	  If it is, return the index of the 
	  largest element, otherwise return -1.
	 */
	public static void main(String[] args) {
		
		int[] nums = {3, 6, 1, 0};
		int[] nums2 = {1, 2, 3, 4};
		
		//Simple Solution:
		System.out.println("Simple Solution:");
		//Test Cases 1 
		System.out.println("Expected Result: " + 1);
		System.out.println("Actual Result:" + dominantIndex(nums));
		
		//Test Cases 1 
		System.out.println("Expected Result: " + -1);
		System.out.println("Actual Result:" + dominantIndex(nums2));	
		
		//Simple Solution:
		System.out.println("Fast Solution:");
		//Test Cases 1 
		System.out.println("Expected Result: " + 1);
		System.out.println("Actual Result:" + dominantIndexFast(nums));
				
		//Test Cases 1 
		System.out.println("Expected Result: " + -1);
		System.out.println("Actual Result:" + dominantIndexFast(nums2));	
	}
	/*
	 * Initial Thought 
	 * 1. Find the Max of the array
	 * 2. Check if every other element is twice that much, using streams and predicate, allMatch
	 * - Very slow: 96 ms, compared to other solutions.
	 */
	public static int dominantIndex(int[] nums) {
		int max = nums[0];
		int maxIndex = 0;
		for( int i = 0; i < nums.length; i++) {
			if(nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}
		//System.out.println("max: " + max);
		//System.out.println("maxIndex: " + maxIndex);
		
		final int max1 = max;
		//System.out.println("Max:" + max1);
		Predicate<Integer> p = element -> max1 >= 2*element;
		List<Integer> list = Arrays.stream(nums).boxed().filter(element -> element != max1).collect(Collectors.toList());
		//System.out.println(list);
		boolean twiceAsMuch = list.stream().allMatch(p);
		if(twiceAsMuch) {
			return maxIndex;
		} else {
			return -1;
		}
    }
	
	public boolean isTwiceAsMuch(int x, int y) {
		return x >= 2*y;
	}
	/*
	 * Dominant Index Fast
	 * Find the max. 
	 * Iterate through the array, checking the 2*elem condition. If not 
	 * 
	 */
	public static int dominantIndexFast(int[] nums) {
		int max = nums[0];
		int maxIndex = 0;
		for( int i = 0; i < nums.length; i++) {
			if(nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}
		for(int j = 0; j < nums.length; j++) {
		    if(j == maxIndex) {
		    		continue;
		    }
		    if(!(max >= 2*nums[j])) {
		    		return -1;
		    }
		}
		return maxIndex;		
    }

}
