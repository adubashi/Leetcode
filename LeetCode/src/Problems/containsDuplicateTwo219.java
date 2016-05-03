package Problems;

import java.util.*;

public class containsDuplicateTwo219 {
	
	
	public static void main(String args[]){
		int[] array = {1,2,4,5,2};
		
		System.out.println(containsNearbyDuplicate(array,2));
	}
	
	
	
	
	/*
	 * Given an array of integers and an integer k, 
	 * find out whether there are two distinct indices i and j in the array 
	 * such that nums[i] = nums[j] and the difference between i and j is at most k.
	 */
	//Use a hashmap key = number, value = index
	public static boolean containsNearbyDuplicate(int[] arr, int k){
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i< arr.length; i++){
			if(map.containsKey(arr[i])){
				   if(Math.abs(i - map.get(arr[i])) <= k){
					  return true;
				   }	
			}
			map.put(arr[i], i);
			
		}
		
		return false;
	}
}
