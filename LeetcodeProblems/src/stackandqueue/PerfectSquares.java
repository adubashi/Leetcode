package stackandqueue;

import java.util.*;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSquares(6)); 
	}
	
	public static int numSquares(int n) {
		// Create a dynamic programming table 
        // to store sq 
		if(n == 0 || n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 3;
        }
        // Create a dynamic programming table 
        // to store sq 
        int dp[] = new int[n+1];
       
        // getMinSquares table for base case entries 
        dp[0] = 0; 
        dp[1] = 1; 
        dp[2] = 2; 
        dp[3] = 3;
        
        for (int i = 4; i <= n; i++) {
        		dp[i] = i; 
        		for (int x = 1; x <= i; x++) { 
                    int temp = x*x; 
                    if (temp > i) {
                        break; 
                    } else { 
                    		dp[i] = Math.min(dp[i], 1+dp[i-temp]); 
                    }
            }
        }
        return dp[n];
    }

}
