package Problems;

public class searchInsertPosition35 {
	/*
	 * iterate through i and i + 1, check if  nums[i - 1] <= target <= nums[i]
	 * return i;
	 * 
	 * or if nums[i - 1] == target
	 * or if nums[i] == target 
	 * 
	 * return i  or i - 1
 	 * 
	 */
	public int searchInsert(int[] nums, int target) {
		
		//Smaller than all
		if(target <= nums[0]) return 0;
		
		
		for(int i = 1; i < nums.length; i++){
			int curIndex = i;
			int prevIndex = i - 1;
			
			if((nums[prevIndex] <= target) && ( target <= nums[curIndex])){
				return curIndex;
			}
		}
		
		//bigger than all
		return nums.length;
    }
	
	public int searchInsertBinarySearch(int[] nums, int target) {
		int i=0; 
	    int j=nums.length-1;
	    while(i <= j){
	    	int mid = (i+j)/2;
	    	
	    	if(target > nums[mid]){
	    	   i = mid + 1;
	    	} else if(target < nums[mid]){
	    		j = mid - 1;
	    	} else {
	    		return mid;
	    	}
	    }
	    
	    return i;
		
	}

}
