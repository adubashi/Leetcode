package Problems;

import java.util.*;

public class moveZeros283 {
	
	
	public static void main(String args[]){
		int[] arg = {5,0,0,1,1};
		System.out.println(Arrays.toString(arg));
		moveZeroes(arg);
		System.out.println(Arrays.toString(arg));
	}
	public static void moveZeroes(int[] nums) {
        int count = 0;
        int i = 0;
        for(i = 0; i< nums.length; i++){
        	if(nums[i] != 0){
        		nums[count] = nums[i];
        		count++;
        	}
        }
        
        while(count < nums.length){
        	nums[count] = 0;
        	count++;
        }
    }

}
