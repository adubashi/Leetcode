package hashmap;

import java.util.HashMap;

public class ContainsDuplicates {
	public static void main(String args[]) {
		
	}
	
	public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int val = map.get(nums[i]);
				if(val == 1) {
					return true;
				} 
			} else{
               map.put(nums[i], 1); 
            }
		}
		return false;  
    }

}
