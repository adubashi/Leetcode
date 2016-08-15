package Problems;

public class searchForARange34 {
	public static int[] searchRange(int[] A, int target) {
		
		int[] result = {-1,-1};
		
		// Find the first index of the target value
        result[0] = binarySearchFirstIndex(A, target);
         
        if (result[0] == -1) {
            result[1] = -1;
            return result;
        }
         
        // Find the last index of the target value
        result[1] = binarySearchLastIndex(A, target);
         
        return result;
				
	}
	
	private static int binarySearchFirstIndex(int[] A, int target) {
		int lo = 0;
        int hi = A.length - 1;
         
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) {
                hi = mid;
            } else if (A[mid] > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        
        if(A[lo] == target){
        	return lo;
        }
        
        if(A[hi] == target){
        	return hi;
        }
        
        return -1;
	}
	
	private static int binarySearchLastIndex(int[] A, int target) {
		int lo = 0;
        int hi = A.length - 1;
         
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) {
                hi = mid;
            } else if (A[mid] > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        
        if(A[hi] == target){
        	return hi;
        }
        if(A[lo] == target){
        	return lo;
        }
        return -1;

	}
	
	public int[] searchRange2(int[] A, int target) {
        int[] ret = {-1, -1};
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }
        int low;
        if (A[start] != target)
            return ret;
        else
            low = start;
        start = 0;
        end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < target + 1)
                start = mid + 1;
            else
                end = mid;
        }
        int high = A[start] == target ? start : start - 1;
        ret[0] = low;
        ret[1] = high;
        return ret;
    }

}
