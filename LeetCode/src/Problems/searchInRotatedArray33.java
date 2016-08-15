package Problems;

public class searchInRotatedArray33 {
	
	
	public static int search(int[] nums, int left,int right, int target) {
		int mid = (left + right)/2;
		if(target == nums[mid]){
			return mid;
		}
		if(right < left){
			return -1;
		}
		if(nums[left] < nums[mid]){
				if(target >= nums[left] && target <= nums[mid]){
					return search(nums,left,mid-1,target);
				} else {
					return search(nums,mid+1,right,target);
				}
		} else if(nums[mid] < nums[left]){
			if(target >= nums[mid] && target <= nums[right]){
				return search(nums, mid+1,right,target);
			} else {
				return search(nums,left,mid-1,target);
			}
			//Repeats
		} else if(nums[left] == nums[mid]){
			if(nums[mid] != nums[right]){
				return search(nums, mid+1,right,target);
			}else {
				int result = search(nums, left, mid-1, target);
				if(result  == -1){
					return search(nums, mid+1,right,target);
				} else {
					return result;
				}
				
			}
		}
		return -1;
        
    }

}
