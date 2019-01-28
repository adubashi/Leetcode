package ProblemsBasedOnDataStructures.Greedy.JumpGame55;

enum Index {
    GOOD, BAD, UNKNOWN
}

public class JumpGame {
	
	
	public static void main(String[] args) {
		
		
		int[] A = {2,3,1};
		System.out.println(canJump(A));
		

	}
	
	//Backtracking
	public static boolean canJump(int[] nums) {		
		return canJumpFromPosition(0,nums);
	}
	
	//Naive solution
	public static boolean canJumpFromPosition(int position, int[] nums) {
		//End case:  if the position is equal to end position, then try out 
		// all position combinations
		if(position == nums.length - 1) {
			return true;
		}
		//Try out all combinations
		int maxJump = nums[position];
		//Edge case for this, if the maxJump is past the end of the array.
		int furthestJump = Math.min(position + maxJump, nums.length - 1);
		//Because we can jump the full distance
		for(int i = position + 1; i <= furthestJump; i++) {
			if(canJumpFromPosition(i,nums)) {
			   return true;
			}	
		}
		return false;
		
	}
	
	//Non-naive bottom-up DP solution
	//No recursion
	
	
	public static boolean canJumpDP(int[] nums) {
		Index[] memo = new Index[nums.length];
		for(int i = 0; i < memo.length; i++) {
			memo[i] = Index.UNKNOWN;
		}
		memo[memo.length - 1] = Index.GOOD;
		
		for(int i = nums.length - 2; i >= 0; i--) {
			//Calculate the furthest jump
			 int furthestJump = Math.min(i + nums[i], nums.length - 1);
			 for (int j = i + 1; j <= furthestJump; j++) {
				    //If any of the possibilities are good, then set the original index to GOOD
	                if (memo[j] == Index.GOOD) {
	                    memo[i] = Index.GOOD;
	                    break;
	                }
			 }
			 
			 
		}

		//If the original index is good, then we can jump
		return memo[0] == Index.GOOD;
	
	}
	
	//Non-naive top-down DP solution
	//Recursive 
	
	//Uses a class variable memo as a memoization table
	
	
	public static Index[] memo;
	
	public static boolean canJumpTopDown(int[] nums) {
	        memo = new Index[nums.length];
	        for (int i = 0; i < memo.length; i++) {
	            memo[i] = Index.UNKNOWN;
	        }
	        memo[memo.length - 1] = Index.GOOD;
	        return canJumpFromPositionTopDown(0, nums);
	}
	
	public static boolean canJumpFromPositionTopDown(int position, int[] nums) {
		if (memo[position] != Index.UNKNOWN) {
            if(memo[position] == Index.GOOD) {
            	return true; 
            } else {
            	return false;
            }
        }
		
		int furthestJump = Math.min(position + nums[position], nums.length - 1);
		for(int i = position+1; i <= furthestJump; i++) {
			if (canJumpFromPosition(i, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
		}
		
		memo[position] = Index.BAD;
		
		return false;
	}
	
	//Greedy algorithm
	
	public static boolean canJumpGreedy(int[] nums) {
		int lastPos = nums.length - 1;
		for(int i = nums.length - 1; i >= 0; i--) {
			//Check if there is a potential jump that can reach another good index.
			//Then set this new good index, as the lastPosition is equal to the current inde
			if(i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}
		
		//If the last index is good, then return true;
		return lastPos == 0;
	}
	

}
