package Problems;
import java.util.*;
/*
 * Contains Duplicate 217 
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */

public class containsDuplicate217 {
	
	public static void main(String args[]){
		int[] array = {1,2,3,3,5};
		int[] array2 = {1,2,3};
		
		System.out.println(containsDuplicate(array));
		System.out.println(containsDuplicate(array2));
		
	}
	
	public static boolean containsDuplicate(int[] array){
		if(array == null || array.length == 0){
			return false;
		}
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i: array){
	        if(hs.contains(i)){
	            return true;
	        }
	        hs.add(i);
	    }
		return false;
	}

}
