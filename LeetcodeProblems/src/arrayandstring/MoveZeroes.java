package arrayandstring;

import java.util.Arrays;

import com.apple.eawt.AppEvent.SystemSleepEvent;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);

	}
	
	public static void moveZeroes(int[] nums) {
		int nonZeroCount = 0;
		
		//Get a count of non-zero elements, setting the non zero count index to the element.  
		for(int i = 0; i < nums.length; i++) {
			int elem = nums[i];
			if(elem == 0) {
			  
			} else {
				nums[nonZeroCount] = elem;
				nonZeroCount++;
			}
		}
		
		//Make the rest of the elements zero
		int k = nonZeroCount;
		while(k < nums.length) {
			nums[k] = 0;
			k++;
		}
		
		System.out.println(Arrays.toString(nums));
		
        
    }
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
