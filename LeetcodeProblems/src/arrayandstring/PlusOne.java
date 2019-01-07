package arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {
	
	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		int[] nums2 = {4,3,2,1};
		
		//Simple Solution:
		System.out.println("Simple Solution:");
		//Test Cases 1 
		int[] expectedArray = {1,2,4};
		System.out.println("Expected Result: " + Arrays.toString(expectedArray));
		System.out.println("Actual Result:" + plusOne(nums));
		
		//Test Cases 1
		//int[] expectedArray2 = {4,3,2,1};
		//System.out.println("Expected Result: " + Arrays.toString(expectedArray2));
		//System.out.println("Actual Result:" + plusOne(nums2));	
	}
	/*
	 * Possible solution: 
	 * Convert the array to a number then plus one to that.
	 *  Then convert it back to an array.
	 *  
	 * Efficient solution. 
	 * start at end of the array then add one to that, and use a carry to 
	 * add to that. Keep iterating until the carry is at zero.
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static int[] plusOne(int[] digits) {
		List<Integer> list = new ArrayList<>();
		
		
		int startIndex = digits.length - 1;
		int carry = 0;
		while(startIndex >= 0 || carry != 0) {
			int number = digits[startIndex];
			System.out.println(number);
			//Result 
			int result = number + 1;
			if(result % 10 == 1) {
				carry = 1;
				digits[startIndex] = result % 10;
			} else {
				digits[startIndex] = result;
				carry = 0;
			}
			startIndex--;
		}
		
		List<Integer> list2 = Arrays.stream(digits).boxed().collect(Collectors.toList());
        System.out.println(Arrays.toString(digits));
        return null;
	}

}
