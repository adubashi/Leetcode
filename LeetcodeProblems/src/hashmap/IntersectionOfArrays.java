package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Given two arrays, write a function to compute their intersection.
		Example 1:
		Input: nums1 = [1,2,2,1], nums2 = [2,2]
		Output: [2]
		Example 2:
		Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
		Output: [9,4]
	 */
	public static int[] intersection(int[] nums1, int[] nums2) {
		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums1.length; i++) {
			int elem = nums1[i];
			if(hashmap.containsKey(elem)) {
				int val = hashmap.get(elem);
				hashmap.put(elem, val + 1);
			} else {
				hashmap.put(elem, 1);
			}
		}
		
		Map<Integer, Integer> hashmap2 = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums2.length; i++) {
			int elem = nums2[i];
			if(hashmap.containsKey(elem)) {
				int val = hashmap.get(elem);
				hashmap2.put(elem, val + 1);
			} 
		}
		
		
		System.out.println(hashmap2);
		List<Integer> list = new ArrayList<Integer>(hashmap2.keySet());
		int[] array = list.stream().mapToInt(i->i).toArray();
		return array;
    }

}
