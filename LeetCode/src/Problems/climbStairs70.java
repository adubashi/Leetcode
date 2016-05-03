package Problems;

public class climbStairs70 {
	
	//Geeks for geeks article
	//http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
	public static void main(String args[]){
		int[] map = new int[6];
		System.out.println(countWaysDP(4,map));	
	}
	
	//Exponential time-->O(2^N)
    public static int climbStairs(int n) {
        if(n < 0){
            return 0;
        } else if(n == 0){
            return 1;
        } else {
            return climbStairs(n-1) + climbStairs(n-2);
        }  
    }
    
    //DP way
    //O(n) time
    public static int countWaysDP(int n, int[] map) {
    	if (n < 0) {
            return 0;
      } else if (n == 0) {
            return 1;
      } else if (map[n] > 0) {
            return map[n];
      } else {
            map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map);
            return map[n];
      }
    }
    
    //Time: O(nm)
 // A recursive function used by countWays
 // A C program to count number of ways to reach n't stair when
 // a person can climb 1, 2, ..m stairs at a time
    public static int countWaysUtil(int n, int m)
    {
        int[] res = new int[n];
        res[0] = 1; res[1] = 1;
        for (int i=2; i<n; i++)
        {
           res[i] = 0;
           for (int j=1; j<=m && j<=i; j++){
             res[i] += res[i-j];
           }
        }
        return res[n-1];
    }
     
    // Returns number of ways to reach s'th stair
    public static int countWays(int s, int m)
    {
        return countWaysUtil(s+1, m);
    }

}
