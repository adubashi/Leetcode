package binarysearch;

public class SearchInRotatedArray {
	
	public static void main(String args[]) {
		int[] array = {4,5,6,7,0,1,2};
		int target = 0;
		
		System.out.println(findPivot(array, 0, array.length));
		System.out.println(pivotedBSearch(array, target));
		
		
	}
	
	//Have a function to find the pivot 
  	/*
  	 * 1) Find out pivot point and divide the array in two
      sub-arrays. (pivot = 2) 
	*	  2) Now call binary search for one of the two sub-arrays.
	*	      (a) If element is greater than 0th element then
	*	             search in left array
	*	      (b) Else Search in right array
	*	          (1 will go in else as 1 < 0th element(3))
	*	  3) If element is found in selected sub-array then return index
	*		Else return -1.
  	*/
	public static int binarySearch(int arr[], int low, int high, int key) 
    { 
       if (high < low) 
           return -1; 
         
       /* low + (high - low)/2; */       
       int mid = (low + high)/2;   
       if (key == arr[mid]) 
           return mid; 
       if (key > arr[mid]) 
           return binarySearch(arr, (mid + 1), high, key); 
       return binarySearch(arr, low, (mid -1), key); 
    }
	
	/* Function to get pivot. For array  
    3, 4, 5, 6, 1, 2 it returns 
    3 (index of 6) */
  public static int findPivot(int arr[], int low, int high) { 
    // base cases 
    if (high < low)   
         return -1; 
    if (high == low)  
         return low; 
      
    /* low + (high - low)/2; */
    int mid = (low + high)/2;    
    if (mid < high && arr[mid] > arr[mid + 1]) 
        return mid; 
    if (mid > low && arr[mid] < arr[mid - 1]) 
        return (mid-1); 
    if (arr[low] >= arr[mid]) 
        return findPivot(arr, low, mid-1); 
    return findPivot(arr, mid + 1, high); 
 }
  
  public static int pivotedBSearch(int arr[], int key) {
	  int pivot = findPivot(arr, 0, arr.length-1); 
      // If we didn't find a pivot, then  
      // array is not rotated at all 
      if (pivot == -1) {
          return binarySearch(arr, 0, arr.length-1, key); 
      }     
      // If we found a pivot, then first  
      // compare with pivot and then 
      // search in two subarrays around pivot 
      if (arr[pivot] == key) 
          return pivot; 
      if (arr[0] <= key) {
          return binarySearch(arr, 0, pivot-1, key); 
      }
      return binarySearch(arr, pivot+1, arr.length-1, key);  
  }
  
  public static int search(int arr[], int left, int right, int key) {
	  if(left > right) {
		  return -1;
	  }
	  int mid = (left + right)/2; 
      if (arr[mid] == key) {
          return mid;
      }
      
      //If left -> mid is sorted
      if(arr[left] <= arr[mid]) {
    	  	if(key >= arr[left] && key <= arr[mid]) {
    	  		return search(arr, left, mid, key);
    	  	} else {
    	  		return search(arr, mid, right ,key);
    	  	}
      }
      //If left -> mid is not sorted, then mid - right must be
      if(key >= arr[mid] && key <= arr[right]) {
    	  	return search(arr, mid+1, right, key);
      } else {
    	  	return search(arr, left, mid-1, key);
      }  
  }

}
