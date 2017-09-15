package ProblemsBasedOnDataStructures.BinarySearch.FindMinimumInRotatedSortedArray;

public class FindMinimumOfaRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Find the minimum of a rotated sorted array
	//Assume that there are no duplicates in the array 
	
	public static int findMin(int[] nums) {
        
    }
	
	public static int binarySearch(int[] arr, int l , int r, int x) {
		
		
		if(l < r) {
			int mid = l + (r -1)/2;
			
			if(x == arr[mid]) {
				return mid;
			}
			
			if(arr[mid] > x) {
				return binarySearch(arr,l,mid,x);
			}  else {
			    return binarySearch(arr,mid,r,x);	
			}
			
		}
		return -1;
	}
	
	public static int findMin(int[] array, int left, int right) {
		//No rotation 
		if(right < left) {
			return array[0];
		}
		// If there is only one element left
		if(right == left) {
		   return array[left];
		}
		//Find mid
		int mid = left + (right - left)/2; 
		
		
		//is the minimum element mid
		if(mid < right && array[mid+1] < array[mid]) {
			return array[mid];
			
		}
		//is the minimum element mid+1;
		if(mid > left && array[mid] < array[mid-1]) {
			return array[mid+1];
		}
		
		//Need to go to either the left or the right side;
		if(array[right] > array[mid]) {
			//go left because the right side is sorted
			return findMin(array,left,mid-1); 
			
		} else {
			//go right because the left side is sorted
			return findMin(array,mid+1,right);
		}
	}

}
