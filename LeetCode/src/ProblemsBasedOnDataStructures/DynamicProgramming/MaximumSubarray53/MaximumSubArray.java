package ProblemsBasedOnDataStructures.DynamicProgramming.MaximumSubarray53;

public class MaximumSubArray {
	
	
	public static void main(String args[] ) {
		
		int[] array = {4,-1,2,1};
		maximumSubArray(array);
	}
	
	public static int maximumSubArray(int[] array) {
		
		
		
		int maxSoFar =  array[0];
		int max = array[0]; 
		
		for(int i = 1; i < array.length; i++) {
			maxSoFar = Math.max(maxSoFar + array[i], array[i]);
			max = Math.max(max,  maxSoFar);
		}
		
		System.out.println(max);
		return max;
	}

}
