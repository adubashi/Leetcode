package Problems;

public class findMedianOfTwoSortedArrays4 {
	
	
	/*
	 * Method 1:
	 * Use merge procedure of merge sort. 
	 * Keep track of count while comparing elements of two arrays. 
	 * If count becomes n(For 2n elements), we have reached the median. 
	 * Take the average of the elements at 
	 * indexes n-1 and n in the merged array. 
	 * See the below implementation.
	 */
	 //O(n) time
	//Two arrays of size n each
	//
	public static int getMedian(int[] array1, int[] array2, int n){
		int i = 0; //current index of array1
		int j = 0; //0current index of array2
		int count = 0;
		int m1 = -1;
		int m2 = -1;
		
		for(count = 0; count <= n; count++){
			
			//All elements of array1 are smaller than array2
			if(i == n){
				m1 = m2;
				m2 = array2[0];
				break;
			}
			//All elements of array2 are smaller than array1
			else if(j == n){
				m1 = m2;
				m2 = array1[0];
				break;
			}
			//Merge
			if(array1[i] < array2[j]){
				m1 = m2;
				m2 = array1[i];
				i++;
			} else {
				m1 = m2;
				m2 = array2[j];
				j++;
			}
			
		}
		return (m1 + m2)/2;
	}
	//---------------------------------------------------------------//
	/*
	 * 1. Calculate the median of array1 and array2
	 * 2. If m1 == m2, then return m1
	 * 3. If m1 > m2:
	 * a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
       b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
       4. If m2 > m1:
	 * a)   From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
	 * b) 	From first element of ar2 to m2 (ar2[0...|_n/2_|])
	 * 5. Continue process until the size of the subarray is 2
	 * 6. When the size of the subarray is 2, 
	 * Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
	 */
	 //Time: O(log(m+n))
	/* Function to get median of a sorted array */
	
	//Find median of a sorted array
	public static double median(int arr[], int n)
	{
	    if (n%2 == 0)
	        return (arr[n/2] + arr[n/2-1])/2;
	    else
	        return arr[n/2];
	}
	
	//find median of two sorted arrays
	/*
	public static double getMedian2(int ar1[], int ar2[], int n){
		if(n <= 0){
			return -1;
		}
		if(n == 1){
			return (ar1[0] + ar2[0])/2;
		}
		if(n == 2){
			return (Math.max(ar1[0],ar2[0]) + Math.min(ar1[1], ar2[1]))/2;
		}
		double m1 = median(ar1, n); 
	    double m2 = median(ar2, n); 
	    
	    System.out.println("Median1: "+  m1);
	    System.out.println("Median2: "+  m2);
	    
	    //If they are equal then return m1 or m2
	    if(m1 == m2){
	    	return m2;
	    }

	    if(m1  < m2){
	    	if(n % 2 == 0){
	    		return getMedian2(ar2 , ar1, n - n/2 + 1);
	    	} else {
	    		return getMedian2(ar1, ar2, n - n/2);
	    	}
	    }
	    
	    if (n % 2 == 0){
	    	return getMedian2(ar2, ar1, n - n/2 + 1);
	    } else {
	    	return getMedian2(ar2, ar1, n - n/2);
	    }
		
	}
	*/
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
	 
		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
				+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}
	 
	public static int findKth(int A[], int B[], int k, 
		int aStart, int aEnd, int bStart, int bEnd) {
	 
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
	 
		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
	 
		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count
	 
		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;
	 
		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
	 
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
	
	
	
	
	public static void main(String args[]){
	    int ar1[] = {2,2,2,2};
	    int ar2[] = {10, 10, 10, 10};
	    int n1 = 4;
	    int n2 = 4;
	    System.out.println("TESTING");
	    if (n1 == n2){
	        System.out.println(findMedianSortedArrays(ar1,ar2));
	    }

	}
	
	 
	
	

}
