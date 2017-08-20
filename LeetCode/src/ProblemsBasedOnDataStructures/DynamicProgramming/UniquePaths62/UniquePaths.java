package ProblemsBasedOnDataStructures.DynamicProgramming.UniquePaths62;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePaths {
	
	
	public static int numberOfUniquePaths = 0; 
	public static Hashtable<ArrayList<Integer>,Boolean> cache;
	
	
	public static void main(String args[]) {
		System.out.println(uniquePaths(2,2));
	}
	
	/*
	 * doesn't work 2^(m+n) solution
	 */
	public static boolean uniquePathsWrong(int m, int n) {
		if(m < 0 || n < 0) {
			return false;
		}
		ArrayList<Integer> point = new ArrayList<>();
		point.add(m);
		point.add(n);
		
		
		if(cache.containsKey(point)) {
			return cache.get(point);
		}
		
		boolean success = false;
		if( (m == 1 && n == 1) || uniquePathsWrong(m - 1, n) || uniquePathsWrong(m, n - 1 )) {
			numberOfUniquePaths++;
			success = true;
		} 
	    cache.put(point, success);
	    return success;
	}

	/*
	 * Let's deal with a simpler question first: get total number of unique paths 
	 * 
	 * 
	 */
	
	public static int uniquePaths(int m, int n) {
		if(m == 0 || n == 0) {
			return 1;
		}
		return uniquePaths(m-1,n) + uniquePaths(m,n-1);
	}
	
	
	public static int uniquePathsCached(int m, int n) {
        numberOfUniquePaths = 0;
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        cache = new Hashtable<ArrayList<Integer>,Boolean>();
        uniquePathsHelper(m,n,path);
        return path.size();
		
	}
	
	/*
	 * cached solution 
	 */
	public static boolean uniquePathsHelper(int m, int n, ArrayList<ArrayList<Integer>> path) {
		if(m < 0 || n < 0) {
			return false;
		}
		ArrayList<Integer> point = new ArrayList<>();
		point.add(m);
		point.add(n);
		
		if(cache.containsKey(point)) {
			return cache.get(point);
		}
		
		boolean success = false;
		if( (m == 1 && n == 1) || uniquePathsHelper(m - 1, n,path) || uniquePathsHelper(m, n - 1,path)) {
			path.add(point);
			success = true;
		} 
	    cache.put(point, success);
	    return success;
	}    
	
	
	
	
}
