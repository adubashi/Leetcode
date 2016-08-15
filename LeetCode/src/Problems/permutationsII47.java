package Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class permutationsII47 {
	public static List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		returnList.add(new ArrayList<Integer>());
		for (int i = 0; i < num.length; i++) {
			HashSet<List<Integer>> currentSet = new HashSet<List<Integer>>();
			for(List<Integer> l : returnList){
				for(int j = 0; j < l.size() + 1; j++){
					l.add(j, num[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);	
				}
			}
			returnList = new ArrayList<List<Integer>>(currentSet);
		}
		return returnList;
	}

}
