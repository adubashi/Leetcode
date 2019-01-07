
package arrayandstring;

public class FindPivotIndex {
	
	public static void main(String[] args) {
		
		int[] nums = {1, 7, 3, 6, 5, 6};
		int[] nums2 = {1, 2, 3};
		
		//Simple Solution:
		System.out.println("Simple Solution:");
		//Test Cases 1 
		System.out.println("Expected Result: " + 3);
		System.out.println("Actual Result:" + pivotIndex(nums));
		
		//Test Cases 1 
		System.out.println("Expected Result: " + -1);
		System.out.println("Actual Result:" + pivotIndex(nums2));
		
		System.out.println("O(N) runtime Solution:");
		//Test Cases 1 
		System.out.println("Expected Result: " + 3);
		System.out.println("Actual Result:" + pivotIndexONRuntime(nums));
		
		//Test Cases 1 
		System.out.println("Expected Result: " + -1);
		System.out.println("Actual Result:" + pivotIndexONRuntime(nums2));
		
		
		
	}
	/*
	 * 724. Find Pivot Index
	 * Find the Pivot Index of array
	 * Prompt: 
	 * Given an array of integers nums, 
	 * write a method that returns the "pivot" index of this array.
	   We define the pivot index as the index
	    where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
	    If no such index exists, we should return -1.
	    If there are multiple pivot indexes,
	    you should return the left-most pivot index.
	    
	    Input: 
		nums = [1, 7, 3, 6, 5, 6]
		Output: 3
		Explanation: 
		The sum of the numbers to the left of index 3
		 (nums[3] = 6) 
		 is equal to the sum of numbers to the right of index 3.
		Also, 3 is the first index where this occurs.
		
		Initial Thought:
		Iterate through the array and add up from the left to the current index,
		and from the right index and check if they are equal.
		If they are equal then return the index.
		If the iteration finishes with no solution, then return -1.

		Time complexity - O(N^2) --> In the worst case, two loops
		Space Complexity - O(1) 
	 */
	
	/*
	 * Simple Solution 
	 */
	public static int pivotIndex(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			int middleIndex = i;
			//Left Sum 
			int leftSum = addFromLeft(nums, middleIndex);
			int rightSum = addFromRight(nums, middleIndex);
			if(leftSum == rightSum) {
				return middleIndex;
			}
		}
		return -1; 
	}
	
	public static int addFromLeft(int nums[], int middleIndex) {
		int sum = 0;
		for(int j = 0; j < middleIndex; j++) {
			sum = sum + nums[j];
		}
		return sum;
	}
	
	public static int addFromRight(int nums[], int middleIndex) {
		int sum = 0;
		for(int j = middleIndex+1; j <= nums.length-1; j++) {
			sum = sum + nums[j];
		}
		return sum;
	}
	/*
	 * Next Step - Find a solution that can be done in O(N) runtime
	 * 
	 * Potential Options:
	 * Calculate the sum of the array, all elements.
	 * -> Check while iterating that the left and right side are equal to each other
	 * -> How? --> We can just check the left side using a counter. If the left = (1/2 * sum) - current elem, then 
	 * -> then the right side has to be equal. 
	 * 
	 * Issue with this is, even if the left side has the amount, we need to check if the right side
	 * has the same amount. So we can check the left side, then break out of the loop and check the right side up to the index;
	 * 
	 */
	
	public static int pivotIndexONRuntime(int[] nums) {
		//Calculate the total sum
		int totalSum = 0;
		for(int i = 0; i < nums.length; i++) {
			int elem = nums[i];
			totalSum = totalSum + elem;
		}
		int runningSumLeft = 0;
		int middleIndex = -1;
		for(int i = 0; i < nums.length; i++) {
			if(2*runningSumLeft == (totalSum - nums[i])) {
				middleIndex = i;
				break;
			}
			int elem = nums[i];
			runningSumLeft = runningSumLeft + elem;
		}
		if(middleIndex == -1) {
			return middleIndex;
		}
		
		int rightSum = addFromRight(nums, middleIndex);
		
		if(rightSum == runningSumLeft) {
			return middleIndex;
		}
		
		return -1; 
	}
	
	
	
	

}
