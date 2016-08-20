package Company1Search;

import java.util.*;

public class MinimumHeightTrees310 {
	
	public static void main(String args[]){
		int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		int n = 6;
		
		List<Integer> mht = findMinHeightTrees(n,edges);
		
	}
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) return Collections.singletonList(0);
		
		//
	    List<Set<Integer>> adj = new ArrayList<>(n);
	    for (int i = 0; i < n; ++i) {
	    	adj.add(new HashSet<Integer>());
	    }
	    //Build the adjacency list 
	    // each index represents a node label
	    for (int[] edge : edges) {
	        adj.get(edge[0]).add(edge[1]);
	        adj.get(edge[1]).add(edge[0]);
	    }
	    
	    System.out.println(adj);
	    
	    List<Integer> leaves = new ArrayList<>();
	    for (int i = 0; i < n; ++i) {
	        if (adj.get(i).size() == 1) leaves.add(i);
	    }
	    
	    while (n > 2) {
	    	n -= leaves.size();
	        List<Integer> newLeaves = new ArrayList<>();
	        for (int i : leaves) {
	            int j = adj.get(i).iterator().next();
	            adj.get(j).remove(i);
	            if (adj.get(j).size() == 1) newLeaves.add(j);
	        }
	        leaves = newLeaves;
	    }
	    return leaves;     
    }

}
