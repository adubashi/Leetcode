package Problems;

public class findPeakElement162 {
	
	
	public static void main(String args[]){
		
		
        int arr[] = {1, 2,3,1};
        int n = arr.length;
        System.out.println("Index of a peak point is " +
                            findPeak(arr));
		
		
	}
	
	//Brute force --> O(n)
	public static int findPeakElement(int[] nums){
		int max = nums[0];
		int index = 0;
		for(int i = 1; i < nums.length - 1; i++){
			int prev = nums[i-1];
			int curr = nums[i];
			int next = nums[i+1];
			
			if(curr > prev && curr > next && curr > max){
                index = i;
                max = curr;
            }
		}
		
		if(nums[nums.length-1] > max){
			index = nums.length-1;
		}
		return index;
	}
	
	public static int findPeakElementRecur(int[] arr,int low, int high, int n){
		int mid = low + (high-low)/2;
		if((mid == 0 || arr[mid-1] <= arr[mid]) &&
		   (mid == n -1 || arr[mid+1] <= arr[mid])){
			return mid;
		} else if(mid > 0 && arr[mid-1] > arr[mid]){
			findPeakElementRecur(arr,low,mid-1,n);
		} else {
			findPeakElementRecur(arr,mid+1,high,n);
		}
		return 1000;
		
	}
	//O(logn) Time
	public static int findPeak(int[] num){
		int n = num.length;
        if(n == 1) {
            return 0;
        }

        int start = 0;
        int end = n - 1;
        int mid = 0;
        //Binary Search, could be done recursively
        while(start <= end) {
            mid = start + (end - start) / 2;
            if((mid == 0 || num[mid] >= num[mid - 1]) &&
               (mid == n - 1 || num[mid] >= num[mid + 1])) {
                    return mid;
            }else if(mid > 0 && num[mid-1] > num[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
	}
	
	

}
