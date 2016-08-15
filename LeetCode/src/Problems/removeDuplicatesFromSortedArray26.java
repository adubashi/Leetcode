package Problems;
import java.util.Arrays;
public class removeDuplicatesFromSortedArray26 {
	
	public static void main(String args[]){
		int[] arr = {1,1,2,2,3,3};
		
		removeDuplicates(arr);
	}
	
	public static int removeDuplicates(int[] array){
		if(array.length < 2){
			return array.length;
		}
		int j = 0;
		int i = 1;
		
		
		while(i < array.length){
			if(array[i] == array[j]){
				//Nothing
			} else {
				j++;
				array[j] = array[i];
			}
			i++;
		}
		
		System.out.println(Arrays.toString(array));
		return j + 1;
	}

}
