package arrayandstring;

public class MonotonicArray {
	
	
	public boolean isMonotonic(int[] A) {
		return isMonotonicIncreasing(A) || isMonotonicDecreasing(A);
	}
	
	public boolean isMonotonicIncreasing(int[] A) {
		for(int i = 1; i < A.length; i++) {
			if(A[i] < A[i-1]) {
				return false;
			}
		}
		return true;
    }
	
	public boolean isMonotonicDecreasing(int[] A) {
		for(int i = 1; i < A.length; i++) {
			if(A[i] > A[i-1]) {
				return false;
			}
		}
		return true;
    }
	
	public boolean isMonotonicFast(int[] A) {
		if (A.length==1) return true;
        int n=A.length;
        boolean up= (A[n-1]-A[0])>0;
        for (int i=0; i<n-1; i++) {
            if (A[i+1]!=A[i] && (A[i+1]-A[i]>0)!=up) {
                return false;
            }
        }
        return true;
	}

}
