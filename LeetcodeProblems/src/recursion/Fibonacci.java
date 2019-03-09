package recursion;

public class Fibonacci {
	
	
	public static void main(String args[]) {
		System.out.println(fib(4));
	}
	
	
	public static int fib(int N) {
		if(N <= 0) {
			return 0;
		}
		if(N == 1) {
			return 1;
		}
		if(N == 2) {
			return 1;
		}
		return fib(N-1) + fib(N-2);
    }

}
