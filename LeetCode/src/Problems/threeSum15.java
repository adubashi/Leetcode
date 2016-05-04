package Problems;
import java.util.*;
public class threeSum15 {
	/*
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
	 * Find all unique triplets in the array which gives the sum of zero.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,3,5,1,3,5};
		
		//System.out.println(threeSum(array,5,6));
		
		List<List<Integer>> list = threeSum2(array,6,9);
		
		
		for (List<Integer> l1 : list) {
			   for (Integer n : l1) {
			       System.out.print(n + " "); 
			   }

			   System.out.println();
		} 
		

	}
	
	//int n = length of array - 1;
	//Runs in O(N^3) time 
	public static boolean find3Numbers(int A[], int n, int target){
		
		for(int i = 0; i < n - 2; i++){
			for(int j = i + 1; j < n - 1; j++){
				for(int k = j + 1; k < n; k++){
					if((A[i] + A[j] + A[k]) == target){
						System.out.println(A[i] + " " + A[j] + " " + A[k]);
						return true;
						
					}
				}
			}
		}
		return false;
	}
	
	//Method 2 --> Using Sorting 
	//Run in O(n^2) time;
	//O(nlogn) time to do sorting 
	public static boolean threeSum(int A[], int n, int target){
		Arrays.sort(A);
		int l = 0;
		int r = 0;
		for(int i = 0; i < n - 2; i++){
			l = i + 1;
			r = n - 1;
			// To find the other two elements, start two index variables
	        // from two corners of the array and move them toward each
	        // other
			while(l < r){
				if(A[l] + A[r] + A[i] == target){
					System.out.println(A[l] + " " + A[i] +  " " + A[r]);
					return true;
				} else if( (A[l] + A[r] + A[i]) < target){
					l++;
				} else {
					r--;
				}
			}
		}
		return false;
	}
	
	//Returns a list
	
	public static List<List<Integer>> threeSum2(int A[], int n, int target){
		
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(A);
		int l = 0;
		int r = 0;
		for(int i = 0; i < n - 2; i++){
			l = i + 1;
			r = n - 1;
			// To find the other two elements, start two index variables
	        // from two corners of the array and move them toward each
	        // other
			while(l < r){
				if(A[l] + A[r] + A[i] == target){
					System.out.println(A[l] + " " + A[i] +  " " + A[r]);
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(A[l]);
					temp.add(A[i]);
					temp.add(A[r]);
					list.add(temp);
					l++;
					r--;
					while (l<r  && A[l]== A[l-1]) l++;// for duplicates
					while (l<r && A[r] == A[r+1] )r--; // duplicates
					
				} else if( (A[l] + A[r] + A[i]) < target){
					l++;
				} else {
					r--;
				}
			}
			while (i <n-1  && A[i] == A[i+1] )i++; //duplicates;	
		}
		return list;
	}
	
	

}
