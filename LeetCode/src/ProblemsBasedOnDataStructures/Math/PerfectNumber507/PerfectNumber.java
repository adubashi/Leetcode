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
	

	public static boolean isPerfect2(int n){
		
		if(n == 1 || n == 0){
            return false;
        }
		int sum = 0;
		
		int squareRootInt = (int)Math.sqrt(n);
		for(int i = 1; i <= squareRootInt; i++){
			if(n % i == 0){
				sum = sum + i + (n/i);
			}
		}
		
		return sum == (2 * n);
	}
	
	public static void main(String args[]){
		System.out.println(isPerfect2(5));
		System.out.println(isPerfect2(6));
		System.out.println(isPerfect2(28));
	}
}
