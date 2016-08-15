package Problems;

import java.util.List;
import java.util.ArrayList;

public class summaryRanges228 {
	
	public static List<String> summaryRanges(int[] nums){
		
		List<String> result = new ArrayList<String>();
		if(nums == null || nums.length==0)
            return result;
 
        if(nums.length==1){
            result.add(nums[0]+"");
        }
		int prevElem = nums[0];
		int first = prevElem;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] == prevElem+1){
				//Edge case
				if(i == nums.length - 1){
					result.add(first + "->" +nums[i]);
				}
			} else {
				if(first == prevElem){
					result.add(first+"");
				} else {
					result.add(first + "->" + prevElem);
				}
				if(i==nums.length-1){
                    result.add(nums[i]+"");
                }
                first = nums[i];
			}
			prevElem = nums[i];
		}
		return result;
	}

}
