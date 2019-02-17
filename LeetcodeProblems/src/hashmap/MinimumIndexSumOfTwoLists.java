package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
	
	public static void main(String args[]) {
/*
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 */
		String[] array = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] array1 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		
		/*
		 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
		 */
		String[] array3 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] array4 = {"KFC", "Shogun", "Burger King"};
		
		findRestaurant(array, array1);
		findRestaurant(array3, array4);
	}
	
	
	public static String[] findRestaurant(String[] list1, String[] list2) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		Map<String,Integer> map2 = new HashMap<String,Integer>();
		for(int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		for(int j = 0; j < list2.length; j++) {
			map2.put(list2[j], j);
		}
		
		
		//Get the min sum;
		int minSum = Integer.MAX_VALUE;
		for(String key : map.keySet()) {
			int val1 = map.get(key);
			if(map2.containsKey(key)) {
				int val2 = map2.get(key);
				int sum = val1 + val2;
				minSum = Math.min(sum, minSum);
			}
		}
		System.out.println(minSum);
		
		List<String> resultList = new ArrayList<String>();
		//Iterate through again to get the solution
		for(String key : map.keySet()) {
			int val1 = map.get(key);
			if(map2.containsKey(key)) {
				int val2 = map2.get(key);
				int sum = val1 + val2;
				if(sum == minSum) {
					resultList.add(key);
				}
			}
		} 
		return resultList.stream().toArray(String[]::new);
    }

}
