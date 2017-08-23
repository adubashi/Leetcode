package ProblemsBasedOnDataStructures.BinarySearch.FindMedianOfTwoSortedArrays4;

public class FindMedianOfTwoSortedArrays {
	
	
	public static void main(String args[]) {
		
		
		double[] array = {1,2,3};
		double[] array2 = {4,5,6};
		
		
		double ans = findMedianSortedArraysLinear(array,array2);
		
		
		System.out.println(ans);
		
	}
	
	
	
	
	
	
	/*
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
       Find the median of the two sorted arrays. 
	   The overall run time complexity should be O(log (m+n)).
	 */
	
	
	/*
	 * 
	 * Using two indices for each array and one index to track the total 
	 * number of elements to produce a linear solution
	 * 
	 */
	public static double findMedianSortedArraysLinear(double[] nums1, double[] nums2) {
		int index1 = 0;
		int index2 = 0;
		
		int totalIndex = (nums1.length + nums2.length)/2;
		
		
		while(true) {
			if(nums1[index1] < nums2[index2] ) {
			   index1++;
			   totalIndex--;
			   if(totalIndex == 0) {
				   return nums2[index2];
			   }
			} else {
				index2++;
				totalIndex--;
				if(totalIndex == 0) {
					return nums1[index1];
				}
			}
		}
		//Should not happen 
		//return nums1[index1];
	}

}
