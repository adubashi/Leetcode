package ProblemsBasedOnDataStructures.DynamicProgramming.HouseRobber198;

public class HouseRobber {
	
	public static void main(String args[]) {
		
		
	}
	
	/*
	 * You are a professional robber planning to rob houses along a street. 
	 * Each house has a certain amount of money stashed, 
	 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

		Given a list of non-negative integers representing the amount of 
		money of each house, determine the maximum amount of 
		money you can rob tonight without alerting the police.
	 * 
	 * 
	 */
	
	/*
	 * Seems like a dynamic programming problem
	 * 
	 * find the most amount of money that can be robbed up to the ith index 
	 * 
	 * Then cache it in a dp[] index
	 * 
	 * Question is what the sub problem is for this.
	 * 
	 * Think that dp[i] = dp[i-1];
	 * 
	 * Attempt:cache the first two entries in the array in dp, then do dp[i] = dp[i-1] 
	 * and iterate through the array
	 * 
	 */
	
	/*
	 * 
	 * Doesn't work for some reason
	 * Yu's coding garden
	 */
	public static int rob(int[] nums) {	
		 if(nums.length == 0) {
				return 0;
			} else if(nums.length == 1) {
				return nums[0];
			} else if(nums.length == 2) {
				return Math.max(nums[0], nums[1]);
			}
			
			int n = nums.length; 
			int[] dp = new int[n+1];
			dp[1] = nums[0];
			dp[2] = nums[1];
			
			for(int i = 3; i < n + 1; i++) {
				dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i-1];
			}
			
			return Math.max(dp[n], dp[n-1]);
    }
	
	//Recurrence relation
	// dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i-1])
	public static int rob2(int[] nums) {
		if(nums.length == 0) {
			return 0;
		} else if(nums.length == 1) {
			return nums[0];
		} else if(nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		
		int n = nums.length; 
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = nums[0];
		
		for(int i = 2; i < n + 1; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
		}
		
		return Math.max(dp[n], dp[n-1]);
		
	}

}
