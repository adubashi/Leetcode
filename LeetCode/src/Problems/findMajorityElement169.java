package Problems;

public class findMajorityElement169 {
	
	public static void main(String args[]){
		int[] nums = {1,1,1,1,1,1,1,2,2,2};
		
		System.out.println(majorityElement(nums));
	}
	
	public static int majorityElement(int[] nums) {
       int majorityIndex = 0;
       int count = 0;
       int i = 0;
       
       for(i = 0; i < nums.length; i++){
    	   if(nums[i] == nums[majorityIndex]){
    		   count++;
    	   } else {
    		   count--;
    	   }
    	   
    	   if(count == 0){
    		   count = 1;
    		   majorityIndex = i;
    	   }
       }
       
       return nums[majorityIndex];
    }

}
