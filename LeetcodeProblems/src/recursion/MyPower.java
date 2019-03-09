package recursion;

public class MyPower {
	
	public static void main(final String args[]) {
		System.out.println(myPow(2,2));
	}

	
	public static double myPow(double x, int n) {
	    	if(n >= 0) {
	    		return pow(x, n);
	    	} else {
	    		return 1/pow(x, n);
	    	}
    }

    public static double pow(double x, int n) {
	    	if (n == 0) {
	    		return 1;
	    	}
	    	double num = pow(x, n/2);
	    	if (n % 2 == 0) {
	    		return num * num;
	    	}
	    	return num * num * x;
    }
}
