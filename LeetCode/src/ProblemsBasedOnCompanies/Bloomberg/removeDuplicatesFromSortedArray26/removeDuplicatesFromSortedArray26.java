package Bloomberg.removeDuplicatesFromSortedArray26;

import java.util.Arrays;

public class removeDuplicatesFromSortedArray26 {
	
	
	public static void main(String args[]){
		int[] array = {1,1,2,2,2,3};
		int[] array2 = {1,1,2};
		
		System.out.println(removeDuplicates(array));
		System.out.println(removeDuplicates(array2));
	}
	
	public static int removeDuplicates(int[] A) {
		int j = 0;
		int i = 1;
		while(i < A.length){
			if(A[i] == A[j]){
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
		
		System.out.println(Arrays.toString(A));
		return j+1;
		
		
	}

}
