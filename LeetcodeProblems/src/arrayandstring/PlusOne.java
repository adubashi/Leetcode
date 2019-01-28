package arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {
	
	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		int[] nums2 = {4,3,2,1};
		int[] nums3 = {9};
		
		//Simple Solution:
		System.out.println("Simple Solution:");
		//Test Cases 1 
		int[] expectedArray = {1,2,4};
		System.out.println("Expected Result: " + Arrays.toString(expectedArray));
		System.out.println("Actual Result:" + Arrays.toString(plusOne(nums)));
		
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
		//Convert to list 
		List<Integer> intList = Arrays.stream(digits)
			      .boxed()
			      .collect(Collectors.toList());
	    intList.add(0, 0);
	    System.out.println(intList);
	    
	    digits = Arrays.copyOf(digits, digits.length + 1);
	    
	    for(int i = 0; i < digits.length; i++) {
	    		digits[i] = intList.get(i);
	    }
	    
	    System.out.println(Arrays.toString(digits));
	    
		int startIndex = digits.length - 1;
		int carry = 0;
		while(startIndex >= 0 || carry != 0) {
			int number = digits[startIndex];
			System.out.println("number:" + number);
			//Result 
			int result = number + 1;
			System.out.println("result:" + result);
			if(result > 9) {
				carry = 1;
				digits[startIndex] = result % 10;
			} else {
				digits[startIndex] = result;
				carry = 0;
				break;
			}
			startIndex--;
		}
        if(digits[0] == 0) {
        		digits = Arrays.copyOfRange(digits, 1, digits.length);
        		return digits;
        } else {
        		return digits;
        }
	}
	
	public static int[] plusOneEfficient(int[] digits) {
		if(digits==null||digits.length==0) {
	        return new int[0];
		}
	 
	    int carry = 1;    
	    for(int i=digits.length-1; i>=0; i--){
	        int sum = digits[i]+carry;
	        if(sum>=10){
	            carry=1;
	        }else{
	            carry=0;
	        }
	        digits[i]=sum%10;
	    }
	 
	    if(carry==1){
	        int[] result = new int[digits.length+1];
	        System.arraycopy(digits, 0, result, 1, digits.length);
	        result[0]=1;
	        return result;
	    }else{
	        //int[] result = new int[digits.length];
	        return digits;
	    }
		
	}

}
