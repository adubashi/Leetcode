package ProblemsBasedOnDataStructures.Math.PerfectNumber507;

public class PerfectNumber {
	
	//exceeded time limit
	public static boolean isPerfect(int n){
		int sum = 0;
		for(int i = 1; i < n; i++){
			if(n % i == 0){
				sum = sum + i;
			}
		}
		
		return sum == n;
	}
	
	/*
	 * Time complexity: O(root(n))
	 * Space: O(1)
	 * 
	 */
	public static boolean isPerfect2(int n){
		
		if(n == 1 || n == 0){
            return false;
		}
		int sum = 1;
		
		
		for(int i = 2; i*i <= n; i++){
			if(n % i == 0){
				sum += i + (n/i);
				

			}
		}
		
		return sum == n;
	}
	
	public static void main(String args[]){
		System.out.println(isPerfect2(0));
		System.out.println(isPerfect2(1));
		System.out.println(isPerfect2(5));
		System.out.println(isPerfect2(6));
		System.out.println(isPerfect2(28));
	}
}
