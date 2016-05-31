package Problems;


import java.util.*;
/*
 * 
 * 46. Permutations 
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * Difficulty: Medium
 * Company:
 * Microsoft
 */
public class permutations46 {
	
	public static void main(String args[]){
		int[] num = {1,2,3};
		List<List<Integer>> result  = permute(num);
		print(result);
	}
	
	public static List<List<Integer>> permute(int[] num) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(num, 0, result);
        return result;
    }
    public static void permute(int[] num, int start, List<List<Integer>> result) {
     
    	if(start >= num.length){
	        List<Integer> item = convertArrayToList(num);
	        result.add(item);
        }
        for(int j = start; j <= num.length - 1; j++){
	        swap(num,start,j);
	        permute(num,start+1,result);
	        swap(num,start,j);
        }
    }
    private static List<Integer> convertArrayToList(int[] num) {
    	List<Integer> item = new ArrayList<Integer>();
    	for (int h = 0; h < num.length; h++) {
    		item.add(num[h]);
    	}
    	return item;
    }
    private static void swap(int[] a, int i, int j) {
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
	public static void print(List<List<Integer>> list){
		for(List<Integer> l: list){
			System.out.println(l.toString());
		}
	}

}
