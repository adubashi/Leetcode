package Bloomberg.powerOfaNumber50;

public class powerOfaNumber50 {
	
	public static void main(String args[]){
		long startTime = System.nanoTime();
		System.out.println(myPow(5.0,10));
		System.out.println();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Slow way took: " + duration);
		
		
		
		
		
		
		
		
		startTime = System.nanoTime();
		System.out.println(myPowFast(5.0,10));
		System.out.println();
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Fast way took: " + duration);
		
	}
	
	
	
	public static double myPow(double x, int n){
		if(n==0)
	        return 1;
	 
	    if(n<0){
	        return 1/myPow(x, -n);
	    }
	 
	    double v = myPow(x, n/2);
	 
	    if(n%2==0){
	       return v*v;
	    }else{
	       return v*v*x;
	    }  
	}
	
	
	
	public static double myPowFast(double x, int n){
		if(n == 0){
			return 1;
		} else if(n % 2 == 0){
			return myPow(x,n/2) * myPow(x, n/2);
		} else {
			return x *  x * myPow(x,n/2);
		}
	}
	
	public static double myPowNeg(double x, int n){
		return 1/myPowFast(x,n);
	}

	
}
