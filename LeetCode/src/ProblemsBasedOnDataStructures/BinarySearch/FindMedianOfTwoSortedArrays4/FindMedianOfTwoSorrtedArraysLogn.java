package ProblemsBasedOnDataStructures.BinarySearch.FindMedianOfTwoSortedArrays4;

public class FindMedianOfTwoSorrtedArraysLogn {
	
	public static double average(double a, double b) {
		return (a + b)/(2.0);
	}
	
	public static double medianOfThree(double a, double b, double c) {
	    return a + b + c - Math.max(a, Math.max(b, c))  - Math.min(a, Math.min(b, c));
	}
	
	public static double medianOfFour(double a, double b, double c, double d) {
		 double Max = Math.max( a, Math.max( b, Math.max( c, d ) ) );
		 double Min = Math.min( a, Math.min( b, Math.min( c, d ) ) );
		 return ( a + b + c + d - Max - Min ) / 2.0;
	}
	
	public static double medianOfOneArray(double[] array, int N) {
		if(array.length %  2 == 0) {
			return (array[array.length/2] + array[array.length/2 -1])/2;
		} else {
			return array[array.length/2];
		}
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return ((double) findKth(nums1, 0, nums2, 0, len / 2) +
                    (double) findKth(nums1, 0, nums2, 0, len / 2 + 1)
                   ) / 2; // note that it's better than
                          // (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2
                          // because of the overflow error
        }
    }
    
    // find the k-th smallest element of two sorted arrays
    private static int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // note the first 2 if statements here
        if (start1 == nums1.length) { // ignore the first array
            return nums2[start2 + k - 1];
        }
        if (start2 == nums2.length) { // ignore the second array
            return nums1[start1 + k - 1];
        }
        // now take both arrays into consideration
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        // skip k / 2 elements every time
        if (start1 + k / 2 - 1 >= nums1.length) { // less than k / 2 elements in the first array
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
        if (start2 + k / 2 - 1 >= nums2.length) { // less than k / 2 elements in the second array
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        }
        // now the number of elements of both arrays is greater than or equal to k / 2
        int key1 = nums1[start1 + k / 2 - 1];
        int key2 = nums2[start2 + k / 2 - 1];
        if (key1 < key2) {
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}
