package arrayandstring;

public class MaxConsecutiveOnes {
	/*
	 * Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,1,0,1,1,1};
		
		int left = findMaxConsecutiveOnes(nums);
		
		System.out.println(left);

	}
	
	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int result = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
			   count = 0;	
			} else{
               count++;
            }
			result = Math.max(count, result);
		}
		return result;
    }

}
