package arrayandstring;
/*
 * 
 * Given an array of n positive integers and a positive integer s,
 *  find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */

public class minimumSizeSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,3,1,2,4,3};
		int sum = 7;
		int result = minSubArrayLen(sum, array);
		System.out.println(result);
	}
	
	//O(n^2) solution 
	public static int minSubArrayLenON2(int s, int[] nums) {
		
		int minLengthSoFar = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			int sum = 0;
			for(int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				int length = j - i + 1;
				if(sum >= s && length < minLengthSoFar ) {
					minLengthSoFar = length;
				}
			}
		}
		
		if(minLengthSoFar == Integer.MAX_VALUE) {
			return 0;
		}
		return minLengthSoFar;
        
    }
	/*
	 * We can use 2 points to mark the left and right boundaries of the sliding window. 
	 * When the sum is greater than the target, shift the left pointer;
	 *  when the sum is less than the target, shift the right pointer.
	 */
	public static int minSubArrayLen(int s, int[] nums) {
		if(nums==null||nums.length==0) {
	        return 0;
		}
		
		int leftPointer=0; 
	    int rightPointer=0;
	    int sum=0;
	 
	    int minLen = Integer.MAX_VALUE;
	    
	    while(leftPointer < nums.length) {
	    		if(sum < s) {
	    			sum = sum + nums[leftPointer];
	    			leftPointer++;
	    		} else {
	    			minLen = Math.min(minLen, leftPointer - rightPointer); 			
	    			if(rightPointer==leftPointer-1) {
	                    return 1;
	    			}        
	    			sum = sum - nums[rightPointer];
	    			rightPointer++;
	    		}
	    }
	    
	    while(sum >= s) {
	    		minLen = Math.min(minLen, leftPointer - rightPointer);
	        sum -= nums[rightPointer++];
	    }
	    
	    return minLen==Integer.MAX_VALUE? 0: minLen;    
    }

}
