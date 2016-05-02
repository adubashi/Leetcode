package Problems;

import java.util.*;

public class removeElement27 {
	/*
	 * 27. Remove Element
	 * Given an array and a value, remove all instances of that value in place and return the new length.
	   The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	 */
	
	public static void main(String args[]){
		int[] array = {1,2,3,3,3,3,3,5,6};
		
		System.out.println(removeElement(array,3));
		
		System.out.println(Arrays.toString(array));
	}
	
    public static int removeElement(int[] nums, int val) {
    	int i = 0;
    	int j = 0;
    	
    	while(i < nums.length){
    		if(nums[i] != val){
    			nums[j] = nums[i];
    			j++;
    		}
    		i++;
    	}
    	
    	return j;
        
    }

}
