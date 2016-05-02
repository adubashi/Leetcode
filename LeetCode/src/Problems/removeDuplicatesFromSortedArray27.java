package Problems;
/*
	26. Remove Duplicates from Sorted Array My Submissions Question
	Total Accepted: 116945 Total Submissions: 354417 Difficulty: Easy
	Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	Do not allocate extra space for another array, you must do this in place with constant memory.
 */
public class removeDuplicatesFromSortedArray27 {
	
	public static void main(String args[]){
		
	}
	
    public static int removeDuplicates(int[] A){
    	if (A.length < 2){
    	    return A.length;
    	}
     
    	int j = 0;
    	int i = 1;
     
    	while (i < A.length) {
    		if (A[i] == A[j]) {
    		   
    		} else {
    			j++;
    			A[j] = A[i];
    		}
    		i++;
    	}
     
    	return j + 1;
	}

}
