
public class Problem16 {

	
	public static boolean isSubsetSum (int arr[], int n, int sum)
	{
	   // Base Cases
	   if (sum == 0)
	     return true;
	   if (n == 0 && sum != 0)
	     return false;
	   // If last element is greater than sum, then ignore it
	   if (arr[n-1] > sum)
	     return isSubsetSum (arr, n-1, sum);
	   /* else, check if sum can be obtained by any of the following
	      (a) including the last element
	      (b) excluding the last element
	   */
	   try {
		   System.out.println(arr[n]);
	   } catch(Exception e){  
	   }
	   return isSubsetSum (arr, n-1, sum) || isSubsetSum (arr, n-1, sum-arr[n-1]); 
	}
}
