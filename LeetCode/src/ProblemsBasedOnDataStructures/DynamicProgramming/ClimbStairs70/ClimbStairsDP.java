package ProblemsBasedOnDataStructures.DynamicProgramming.ClimbStairs70;

public class ClimbStairsDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(climbStairsIter(5));

	}
	
	public static int[] map;
	
	
	public static int climbStairsRecur(int n) {
		if(n < 0) {
			return 0;
		} else if(n == 0) {
			return 1;
		} else {
			return climbStairsRecur(n-1) + climbStairsRecur(n-2);
		}
	}
    
    
    public static int climbStairs(int n) {
		map = new int[n+1];
		return climbStairsDP(n);
	}
	
	public static int climbStairsDP(int n) {
		if(n < 0) {
			return 0;
		} else if(n == 0) {
			return 1;
        } else if(n == 1){
            return 1;  
        } else if(map[n] > 0) {
			return map[n];
		} else {
			map[n] = climbStairsDP(n-1) + climbStairsDP(n-2);
			
			return map[n];
		}
	}
	
	public static int climbStairsIter(int n) {
		if(n < 0) {
			return 0;
		} else if(n == 0) {
			return 1;
		} 
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}


}
