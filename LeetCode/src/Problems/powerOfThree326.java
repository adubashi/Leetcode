package Problems;

public class powerOfThree326 {
	
	public static void main(String args[]){
		
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(47));
		
	}
	
	public static boolean isPowerOfThree(int n){	
		while (n % 3 == 0) {
		    n = n / 3;
		}
		return n == 1;
	}
	
	public static boolean isPowerOfThree2(int n) {
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
