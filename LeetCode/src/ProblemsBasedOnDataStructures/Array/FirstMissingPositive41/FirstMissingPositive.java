package ProblemsBasedOnDataStructures.Array.FirstMissingPositive41;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedHashMap;

/*
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 */

public class FirstMissingPositive {
	/*
	 * 
	 * Sorting 
	 * O(nlogn) time
	 * O(1) space, but depends on the sort used
	 */
	public static int firstMissingPositiveSorting(int[] nums) {
		
		//Edge case: If the array is empty, the missing number is 1
		if(nums.length == 0){
			return 1;
		}
		Arrays.sort(nums);
		int result = 0;
		for(int i = 0; i < nums.length; i++){
			
			//Ignore all negative numbers 
			if(nums[i]  <= 0){
				continue;
			}
			
			if(nums[i] - result > 1){
				return result + 1;
			} else {
				result = nums[i];
			}
		}
		//Edge case: If we get to end of the array, the remaining missing positive is the
		// last number + 1
		return nums[nums.length - 1] + 1; 
    }
	
	//Using hash table
	//Add all numbers to a hash table 
	//O(n) time
	//O(n) space for the hashtable
	public static int firstMissingPositiveHash(int[] nums){
		Hashtable<Integer,Integer> numTable  = new Hashtable<Integer,Integer>();
		for(int i = 0; i < nums.length; i++){
			numTable.put(nums[i], 1);
		}
		for(int i = 1; i < Integer.MAX_VALUE; i++){
			if(numTable.get(i) == null){
				return i;
			}
		}
		//Should never happen
		return 0;	
	}
	/*
	 * 
	 * O(n) time
	 * O(n) space - for copying the array,but can be modified to use O(1) space,
	 * array copying is not necessary it's just cleaner
	 * 
	 * Steps:
	 * 1. Segregate the positive and negative integers
	 * 2. Traverse the array that has positive numbers, if an integer is positive then change
	 * it to negative
	 */
	
	public static int separatePositiveAndNegativeIntegers(int[] nums, int size){
		int numberOfNonPositives = 0;
		int i = 0;
		for(i = 0; i < size; i++){
			if(nums[i] <= 0){
			   swap(i,numberOfNonPositives,nums);
			   numberOfNonPositives++;
			}
		}	
		return numberOfNonPositives;
	}
	
	public static void swap(int i, int j, int[] arr){
		int elem = arr[i];
		arr[i] = arr[j];
		arr[j] = elem;
	}
	
	//Find the missing positive integer in an array with all positives
	public static int findMissingPositive(int[] arr, int size){
		  int i;
	      for(i = 0; i < size; i++)
	      {
	        if(Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0){
	          arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
	        }
	      }     
	      // Return the first index value at which 
	      // is positive
	      for(i = 0; i < size; i++){
	        if (arr[i] > 0){
	          return i+1;  // 1 is added becuase indexes 
	                       // start from 0
	        }
		  }
	      return size+1;
	}
	
	public static int findMissing(int[] arr, int size){
			// First separate positive and 
	       // negative numbers
	       int shift = separatePositiveAndNegativeIntegers(arr, size);
	       int[] arr2 = Arrays.copyOfRange(arr, shift, size);
	       // Shift the array and call 
	       // findMissingPositive for
	       // positive part
	       return findMissingPositive(arr2, size-shift);
	}
	
	
	public static int findMissingPositiveOptimal(int[] A){
		if(A.length == 0){
			return 1;
		}
		
		int n = A.length;
		int i = 0;
		while(i < n){
			boolean inRange = A[i] >= 1 && A[i] <= n;
			boolean inWrongPlace = A[i] != i + 1;
			boolean isNotARepeat = A[i] != A[A[i] - 1];
			if(inRange && inWrongPlace && isNotARepeat){
			  swap(i, A[i] - 1,A);
			} else {
				i++;
			}
		}
		
		//If an element is not in the correct place then return i+1, as that 
		// is the missing element
		for (i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
		
		
		return A[A.length - 1 ] + 1;
	}

	public static void main(String args[]){
		int[] nums = {-3,-2,-1,0,2};
		int[] nums2 = {0,2,-3,-2,-1,};
		System.out.println(findMissing(nums2, nums2.length));	
	}

}
