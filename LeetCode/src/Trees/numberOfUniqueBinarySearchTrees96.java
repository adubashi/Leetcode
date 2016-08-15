package Trees;

public class numberOfUniqueBinarySearchTrees96 {
	/*
	 * 
	 * Create a binary search tree for each node then loop through the 
	 */
	// i=n, count[n] = sum(count[0..k]*count[k+1...n]) 0 <= k < n-1
	 public static int numTrees(int n) {
		 int[] count = new int[n  + 1];
		 //null tree
		 count[0] = 1;
		 //One root node
		 count[1] = 1;
		 for(int i = 2; i <= n ; i++){
			 for(int j = 0; j <= i - 1; j++){
				 count[i] = count[i] + count[j] * count[i - j - 1];
			 }
		 }
		 
		 return count[n];
	        
	 }

}
