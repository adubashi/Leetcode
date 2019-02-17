package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(hashmap.containsKey(nums[i])) {
				int val = hashmap.get(nums[i]);
				return new int[]{val, i};
			} else {
				hashmap.put(target-nums[i],i);
			}
		}
		return new int[]{0,0};
    }

}
