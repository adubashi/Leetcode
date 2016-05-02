package Problems;
/*
 * Rotate Array - 189
 * Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * 
 */

public class rotateArray189 {
	
	public void rotate(int[] arr, int k) {
		k = k % arr.length;
		
		reverse(arr,0,k-1);
		reverse(arr,k,arr.length-1);
		reverse(arr,0,arr.length-1);
		
		
	}

	
	public static void reverse(int[] arr, int left, int right){	
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}
