package Problems;

public class mergeSortedArray88 {
	/*
	 * 
	 *88. Merge Sorted Array My Submissions Question
	  Total Accepted: 92440 Total Submissions: 309193 Difficulty: Easy
	  Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	Note:
	You may assume that nums1 has enough space (size that is greater or equal to m + n) 
	to hold additional elements from nums2. 
	The number of elements initialized in nums1 and nums2 are m and n respectively.
	 */
	//Bloomberg
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int totalSpace = m + n - 1;
		int indexA = m - 1;
		int indexB = n - 1;
		
		while(indexB >= 0){
			if(indexA >= 0 && nums1[indexA] > nums2[indexB]){
			   nums1[totalSpace] = nums1[indexA];
			   indexA--;
			   totalSpace--;
			} else {
				nums1[totalSpace] = nums2[indexB];
				indexB--;
				totalSpace--;
			}
		}
		
		
		
        
    }

}
