package hashmap;
/*
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArraysII {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4,9,5};
		int[] array2 = {9,4,9,8,4};
		int[] res1 =intersect(array, array2);
		System.out.println(Arrays.toString(res1));
		
		
		int[] array3 = {1,2,2,1};
		int[] array4 = {2,2};
		int[] res2 = intersect(array3, array4);
		System.out.println(Arrays.toString(res2));
	}
	
	
	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i: nums1){
	        if(map.containsKey(i)){
	            map.put(i, map.get(i)+1);
	        }else{
	            map.put(i, 1);
	        }
	    }
	 
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    for(int i: nums2){
	        if(map.containsKey(i)){
	            if(map.get(i)>1){
	                map.put(i, map.get(i)-1);
	            }else{
	                map.remove(i);
	            }
	            list.add(i);
	        }
	    }
		int[] array = list.stream().mapToInt(i->i).toArray();
		return array;
      
    }
	
	public static void addElementToList(int elem, int n, List<Integer> list) {
		for(int k = 0; k < n; k++) {
			list.add(elem);
		}
	}

}
