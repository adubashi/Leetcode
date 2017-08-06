package ProblemsBasedOnDataStructures.Hashtable.TwoSum;

import java.util.*;

public class TwoSum1 {
	public static int[] twoSum(int[] array, int sum){
		Hashtable<Integer,Integer> hashtable = new Hashtable<Integer,Integer>();	
		int[] result = new int[2];
		
		for(int i = 0; i < array.length; i++){
			int value = array[i];
			
			if(hashtable.containsKey(value)){
				int index = hashtable.get(value);
				result[0] = index;
				result[1] = i;
				return result;
			} else {
				hashtable.put(sum - array[i], i);
			}
		}
		return array;
	}
	
	
	public static boolean twoSum2(int[] array, int sum){
		Hashtable<Integer,Integer> hash = new Hashtable<Integer,Integer>();
		for(Integer elem : array){
			if(hash.containsKey(elem)){
				return true;
			} else {
				hash.put(sum-elem, elem);
			}
		}
		return false;
	}

}
