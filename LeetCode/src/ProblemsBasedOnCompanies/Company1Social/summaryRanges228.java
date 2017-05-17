package Company1Social;
import java.util.*;

public class summaryRanges228 {
	
	public static void main(String args[]){
		//[0,1,2,4,5,7]
		int[] array = {0,1,2,4,5,7};
		
		System.out.println(summaryRanges(array).toString());
	}
	
	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int pre = nums[0];
        int range = 0;
        
        for(int i = 1; i <= nums.length ; i++){
        	if(i != nums.length && nums[i - 1] == nums[i] - 1 ){
        		range++;
        	} else {
        		if(range == 0){
        			result.add(Integer.toString(pre));
        		} else {
        			result.add(Integer.toString(pre) + "->" + Integer.toString(pre + range));
        		}
        		if (i != nums.length) {
                    pre = nums[i];
                    range = 0;
                }
        	}
        }
        
        return result;
		
		
	}

}
