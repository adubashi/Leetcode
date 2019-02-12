package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Optional;

public class SingleNumber {
	
	public static int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int val = map.get(nums[i]);
				map.put(nums[i], val + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		
		Optional<Entry<Integer,Integer>> elem  = map.entrySet()
        .stream().filter(entry -> entry.getValue() == 1).findFirst();
		if(elem.isPresent()) {
			return elem.get().getKey();
		}   
        return 0;
    }
	
	/*
	 * 
	 * XOR Solution 
	 * 
	 * The best solution is to use XOR.
	 *  XOR of all array elements gives us the number with single occurrence.
	 *   The idea is based on following two facts.
		a) XOR of a number with itself is 0.
		b) XOR of a number with 0 is number itself.
		
		res = 7 ^ (3 ^ 3) ^ (4 ^ 4) ^ (5 ^ 5)  
    		    = 7 ^ 0 ^ 0 ^ 0
            = 7 ^ 0
            = 7 
	  */
	
	public static int findSingle(int arr[]) { 
        // Do XOR of all elements and return 
        int res = arr[0]; 
        for (int i = 1; i < arr.length; i++) {
            res = res ^ arr[i]; 
        }
      
        return res; 
    }
	
	//Math equations
	// Mathematical Equation = 2*(a+b+c+d) – (a + a + b + b + c + c + d)
    //In more simple words: 2*(sum_of_array_without_duplicates) – (sum_of_array)
	
	public static int findSingleMath(int arr[]) { 
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		List<Integer> noDupes = new ArrayList<>(new HashSet<>(list));
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		int sumNoDupes = noDupes.stream().mapToInt(Integer::intValue).sum();
		return 2*sumNoDupes - sum;
    }
	
	

}
