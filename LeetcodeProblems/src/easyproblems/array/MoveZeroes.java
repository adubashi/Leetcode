package easyproblems.array;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int zeroCount = 0;
        int nonZeroIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
            } else {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }          
        }
        
        for(int i = nonZeroIndex; i < nums.length; i++){
            nums[i] = 0;
        }
    }

}
