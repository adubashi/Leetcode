package arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotateArray {
	
	public static void main(final String args[]) {
		//[1,2,3,4,5,6,7] and k = 3
		int[] array = {1,2,3,4,5,6,7};
		int k = 3;
		rotate(array, k);
		
		System.out.println(Arrays.toString(array));
		
	}
	
	//Given an array, rotate the array to the right by k steps, where k is non-negative.
	public static void rotate(int[] nums, int k) {
		//Get correct step length
		int stepNumber = k % nums.length;
		//Split the array into two parts and append the end to the start
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		List<Integer> sublist1 = list.subList(0, list.size() - stepNumber);
		List<Integer> sublist2 = list.subList(list.size() - stepNumber, list.size());
		//List to modify
		List<Integer> sublist4 = new ArrayList<>(sublist2);
		int constantSize = sublist1.size();
		for(int i = 0; i < constantSize; i++) {
			int element = sublist1.get(i);
			sublist4.add(element);
		}
		for(int i = 0; i < nums.length; i++) {
			nums[i] = sublist4.get(i);
		}
    }
	
	public static int[] toIntArray(List<Integer> list)  {
	    int[] ret = new int[list.size()];
	    int i = 0;
	    for (Integer e : list)  
	        ret[i++] = e;
	    return ret;
	}
	

}
