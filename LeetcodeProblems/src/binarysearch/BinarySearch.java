package binarysearch;

public class BinarySearch {
	
	
	public static void main(String args[]) {
		int[] array = {-1,0,3,5,9,12};
		int target = 9;
		System.out.println(search(array, target));
		
		int[] array2 = {-1,0,3,5,9,12};
		int target1 = 2;
		System.out.println(search(array2, target1));	
	}
	
	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length;
		
		while(start < end) {
			int mid = (start + end)/2;
			if(target == nums[mid]) {
				return mid;
			}
			if(target > nums[mid]) {
				start = mid + 1;
			} else {
				end = mid;
			}		
		}
		return -1; 
    }

}
