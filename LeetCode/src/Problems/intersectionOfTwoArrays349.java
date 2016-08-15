package Problems;

import java.util.Arrays;

public class intersectionOfTwoArrays349 {

	public static void main(String args[]) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };

		intersection(nums1, nums2);
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		if ( nums1.length > nums2.length ) {
	            int[] temp = nums1;
	            nums1 = nums2; 
	            nums2 = temp;
	    }
		//For two sorted arrays;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int[] result = new int[nums1.length];
		//Use two pointers
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < nums1.length && j < nums2.length){
			if(nums1[i] < nums2[j]){
				i++;
			} else if(nums1[i] > nums2[j]){
				j++;
			} else {
				if(k == 0 || nums1[i] != result[k-1]){
					result[k] = nums1[i];
					System.out.println(result[k]);
					k++;
				}
				i++;
				j++;
			}	
		}
		return Arrays.copyOf(result, k);
    }
}
