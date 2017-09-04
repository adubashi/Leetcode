package ProblemsBasedOnDataStructures.DivideAndConquer.medianOfTwoSortedArrays4;

import java.util.Arrays;

public class MedianOfTwoSortedArrays4 {
	
	public static void main(String args[]){
		int[] nums1 = {1, 2, 4,9};
		int[] nums2 = {3,5};
		
		System.out.println(findMedianSortedArrays(nums1,nums2));
	}
	
	//Merge the two arrays and the median
	//O(n + m) time 
	//O(n + m) space 
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int[] mergedArray = mergeTwoSortedArrays(nums1,nums2);
		System.out.println(Arrays.toString(mergedArray));
		
		if(mergedArray.length % 2 == 1){
			return mergedArray[(nums1.length + nums2.length)/2];
		} else {
			double a = mergedArray[(mergedArray.length)/2];
			double b = mergedArray[(mergedArray.length)/2 -1];
			return (a + b)/2  ;
		}
    }
	
	
	public static int[] mergeTwoSortedArrays(int[] nums1, int[] nums2){
		int[] newArray = new int[nums1.length + nums2.length];
		
		int indexA = 0;
		int indexB = 0;
		int i = 0;
		for(i = 0; indexA < nums1.length && indexB < nums2.length; i++){
			if(nums1[indexA] < nums2[indexB]){
				newArray[i] = nums1[indexA];
				indexA++;
			} else {
				newArray[i] = nums2[indexB];
				indexB++;
			}
		}
		
		//Still elements left in nums1
		while(indexA < nums1.length){
			newArray[i] = nums1[indexA];
			indexA++;
			i++;
		}
		
		//Still elements left in nums2
		while(indexB < nums2.length){
			newArray[i] = nums2[indexB];
			indexB++;
			i++;
		}
		return newArray;
	}
	
	//Assumption
	//Both arrays are the same size 
	
	
	

}
