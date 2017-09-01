package ProblemsBasedOnDataStructures.BinarySearch.FindMedianOfTwoSortedArrays4;

public class FindMedianOfTwoSortedArrays {
	
	
	public static void main(String args[]) {
		
		
		double[] array = {1,2,3};
		double[] array2 = {5,6};
		
		
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
	 * 
	 * 
	 * 
	 * The naive implementation resolves to linear time. 
	 * As we are given arrays we know the length of each in constant time and therefore know where the median should resolve.
	 *  We loop through the index of our median (med_idx), at each stage 
	 *  we maintain our previous value m1. m2 is updated in our logic block.
	 *  If we've traversed array a completely, we know we must continue traversing b,
	 *  and vice versa. If we have not traversed either 
	 *  completely we simply check for the lower value and 
	 *  increment pointer i (corresponding to array a) or j (corresponding to array b).
	 */
	public static double findMedianSortedArraysLinear(double[] nums1, double[] nums2) {
		int index1 = 0;
		int index2 = 0;
		
		double element1 = 0;
		double element2 = 0;
		
		
		
		int totalLength = (nums1.length + nums2.length) / 2;
		
		int tracker = 0;
		
		while(tracker < totalLength + 1) {
			element1 = element2;
			//If we hit the end of array
			if(index1 == nums1.length) {
			   element2 = nums2[index2];
			   index2++;
			} else if(index2 == nums2.length) {
				element2 = nums1[index1];
				index1++;
			} else {
				if(nums1[index1] < nums2[index2]) {
					element2 = nums1[index1];
					index1++;
				} else {
					element2 = nums2[index2];
					index2++;
				}	
			}
			tracker++;
		}
		
		if((nums1.length + nums2.length) % 2 == 0) {
			return (element1 + element2)/2; 
		} else {
			return element2;
		}
	}

}
