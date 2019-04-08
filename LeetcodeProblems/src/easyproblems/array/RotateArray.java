package easyproblems.array;

public class RotateArray {
	
	public void rotate(int[] nums, int k) {
        //Get correct step length
		int stepNumber = k % nums.length;
		
		int[] a = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			a[(i + stepNumber) % nums.length] = nums[i];
		}
		
		for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

}
