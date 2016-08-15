package Problems;

public class sortColors75 {
	public static void sortColors(int[] nums){
		if(nums==null||nums.length<2){
	        return;
	    }
	 
	    int[] countArray = new int[3];
	    for(int i=0; i<nums.length; i++){
	        countArray[nums[i]]++;
	    }
	    
	    for(int i=1; i<=2; i++){
	        countArray[i]=countArray[i-1]+countArray[i];
	    }
	    
	    int[] sorted = new int[nums.length];
	    for(int i=0;i<nums.length; i++){
	        int index = countArray[nums[i]]-1;
	        countArray[nums[i]] = countArray[nums[i]]-1;
	        sorted[index]=nums[i];
	    }
	    System.arraycopy(sorted, 0, nums, 0, nums.length);
	}
	
	public static void sortColors2(int[] nums){
		if(nums==null||nums.length<2){
	        return;
	    }
	 
	    int[] countArray = new int[3];
	    for(int i=0; i<nums.length; i++){
	        countArray[nums[i]]++;
	    }
	    int i = 0;
	    int j = 0;
	    while( i <= 2){
	    	if(countArray[i] != 0){
	    		nums[j] = i;
	    		j++;
	    		countArray[i] = countArray[i] - 1;
	    	} else {
	    		i++;
	    	}
	    }
	    
	}

}
