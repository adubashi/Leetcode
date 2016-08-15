package Problems;

public class jumpGame55 {
	
	
	//Exponential time --> O(2^n) time
	//O(1) - Space
	public static boolean canJumpFromPos(int position, int[] nums){
		if(position == nums.length - 1){
			return true;
		}
		
		int farthestJump = Math.max(position + nums[position], nums.length - 1);
		for(int nextPosition = position + 1; nextPosition <= farthestJump; nextPosition++){
			if(canJumpFromPos(nextPosition,nums)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean canJump(int[] nums){
		return canJumpFromPos(0,nums);
	}
	
	//Top down --> Dynamic Programming
	public enum State {
		GOOD,
		BAD,
		UNKNOWN
	}
	public static State[] table;
	
	//Time: O(N^2)
	//Space: O(N)
	public static boolean canJumpFromPosDP(int position, int[] nums){
		if(table[position] != State.UNKNOWN){
		   if(table[position] == State.GOOD){
			   return true;
		   } else {
			   return false;
		   }
		}
		
		int farthestJump = Math.max(position + nums[position], nums.length - 1);
		for(int nextPosition = position + 1; nextPosition <= farthestJump; nextPosition++){
			if(canJumpFromPosDP(nextPosition,nums)){
				table[position] = State.GOOD;
				return true;
			}
		}
		table[position] = State.BAD;
		return false;
	}
	
	
	public static boolean canJumpDP(int[] nums) {
	       table = new State[nums.length];
	       for (int i = 0; i < table.length; i++) {
	            table[i] = State.UNKNOWN;
	       }
	       table[table.length - 1] = State.GOOD;
	       return canJumpFromPosDP(0, nums);
	}
	
	//Linear time, Constant space solution
	public static boolean canJumpLinear(int[] nums){
		int lastPos = nums.length - 1;
		for(int i = nums.length - 1; i >= 0; i--){
			if(i + nums[i] >= lastPos){
				lastPos = i;
			}
		}
		return lastPos == 0;
	}

}
