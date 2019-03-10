package binarysearch;

public class MySqrt {
	
	public static void main(String args[]) {
		
	}
	
	public int mySqrt(int x) {
		if(x == 0 || x == 1) {
			return x;
		}	
		int i = 1;
		for( i = 1; i < x; i++) {
			 int sq = i * i;
			 if(sq == x) {
				 return i;
			 }
			 if(sq > x) {
				 break;
			 }
		}
		return i-1;       
    }
	/*
	 * binary search
	 */
	
	public int mySqrtFast(int x) {
		long start = 0;
        long end = x / 2 + 1;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid * mid == x)
                return (int)mid;
            if (mid * mid < x)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return (int)end;	
    }

}
