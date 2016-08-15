package Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class subsets {
	public static void main(String args[]){
		int[] num = {1,2,3};
		
		print(subsets(num));
		
	}

    public static List<List<Integer>> subsets(int[] num) {
    	if (num == null)
    		return null;
     
    	Arrays.sort(num);
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
     
    	for (int i = 0; i < num.length; i++) {
    		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
     
    		//get sets that are already in result
    		for (List<Integer> a : result) {
    			temp.add(new ArrayList<Integer>(a));
    		}
    		//add S[i] to existing sets
    		for (ArrayList<Integer> a : temp) {
    			a.add(num[i]);
    		}
    		//add S[i] only as a set
    		ArrayList<Integer> single = new ArrayList<Integer>();
    		single.add(num[i]);
    		temp.add(single);
     
    		result.addAll(temp);
    		System.out.println("Iteration: "+ i);
    		print(result);
    	}
    	//add empty set
    	result.add(new ArrayList<Integer>());
    	return result;

    }
	public static void print(List<List<Integer>> list){
		for(List<Integer> l: list){
			System.out.println(l.toString());
		}
	}

}
