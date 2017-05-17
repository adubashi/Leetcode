package Company1Search;

public class perfectSquares279 {
	
	public static int minSquares(int n) {
		if( n <= 3){
			return n;
		}	
		int cur = n;
		for(int i = 1; i <= n; i++){
			int temp = i*i;
			if(temp > n){
				break;
			} else {
				cur = Math.min(cur, 1 + minSquares(cur - temp));
			}
		}
		return cur;	
	}
	
	public static int getMinSquares(int n){
		int[] dp = new int[n+1];
		 
		if(n == 0){
			return 0;
		} else if(n == 1){
			return 1;
		} else if(n == 2){
			return 2;
		}
		
		
		dp[0] = 0;
	    dp[1] = 1;
	    dp[2] = 2;
	    
	    for(int i = 3; i <= n; i++){
	    	dp[i] = i;
	    	for(int x = 1; x <= i; x++){
	    		int temp = x*x;
	    		if(temp > i){
	    			break;
	    		} else {
	    			dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
	    		}
	    	}
	    }
	    
	    return dp[n];
	}

}
