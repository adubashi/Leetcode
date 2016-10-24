
public class Problem14 {
	
	
	public static void main(String args[]){
		int[] coins = {1,2,5,10,20,50};
		System.out.println(countDP(coins, 6,100));
	}
	
	
	public static int count(int[] S, int m, int n){
		// If n is 0 then there is 1 solution (do not include any coin)
	    if (n == 0)
	        return 1;
	    // If n is less than 0 then no solution exists
	    if (n < 0)
	        return 0;
	    // If there are no coins and n is greater than 0, then no solution exist
	    if (m <=0 && n >= 1)
	        return 0;
	    // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
	    return count( S, m - 1, n ) + count( S, m, n-S[m-1] );
	}
	
	
	public static int countDP(int[] S, int m, int n){
		int[]  table = new int[n+1];
		table[0] = 1;
	    for(int i=0; i<m; i++){
	        for(int j=S[i]; j<=n; j++){
	            table[j] += table[j-S[i]];
	        }
	    }
	    System.out.println("Value\tWays");
	    for(int i = 1; i < n + 1; i++){
	    	System.out.println(i + "   " + '\t' + table[i]);
	    }
	    return table[n];
	}
	
	
}
