package ProblemsBasedOnDataStructures.Array.nextPermutation;

public class nextPermutation31 {
	public static void reverse(int[] nums, int left, int right){
	    while(left<right){
	        int temp = nums[left];
	        nums[left]=nums[right];
	        nums[right]=temp;
	        left++;
	        right--;
	    }
	}
	/*
	 * 
	 * 1) scan from right to left, find the first element that is less than its previous one.
	 * 2) scan from right to left, find the first element that is greater than p.
	 * 3) swap p and q
	 * 4) reverse elements [p+1, nums.length]
	 */
	public static void nextPermutation(int[] nums) {
	    if(nums == null || nums.length<2)
	        return;
	    
	    //1)
	    int p=0;            
	    for(int i=nums.length-2; i>=0; i--){
	        if(nums[i]<nums[i+1]){
	            p=i;
	            break;
	        }    
	    }
	    //2)
	    int q = 0;
	    for(int i=nums.length-1; i>p; i--){
	        if(nums[i]> nums[p]){
	            q=i;
	            break;
	        }    
	    }
	    
	    //Not possible case
	    if(p==0 && q==0){
	        reverse(nums, 0, nums.length-1);
	        return;
	    }
	    int temp=nums[p];
	    nums[p]=nums[q];
	    nums[q]=temp;
	 
	    if(p<nums.length-1){
	        reverse(nums, p+1, nums.length-1);
	    }
	    
	}

}
