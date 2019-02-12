package arrayandstring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayPartition {
	/*
	 * 
	 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
	 *  say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

		Example 1:
		Input: [1,4,3,2]
		
		Example 2:
		Input: [1,6,5,3] -> [1,3,5,6] 

		Output: 4
		Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
	 */

	public static void main(String[] args) {
		
		int[] array = {1,3,5,6};
		
		int result = arrayPairSum(array);

		System.out.println(result);
	}
	/*
	 * [1, 4, 3, 2] -> [1, 2, 3, 4]
	 * Example of solution
	 * - sort the array
	 * - iterate through the array and add up the minimum 
	 * 
	 * 
	 */
	public static int arrayPairSum(int[] nums) {
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Collections.sort(list);
		
		int i = 0; 
		int sum = 0;
		while( i < list.size()) {
			sum = sum + Math.min(list.get(i), list.get(i+1));
			i = i + 2;
		}
		return sum;     
    }

}
