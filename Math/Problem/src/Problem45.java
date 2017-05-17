
public class Problem45 {
	
	
	public static double nthterm(int n, double x){
		
		
		double tophalf = Math.pow(x, Math.pow(2, n));
		
		double bottomhalf =  1 - Math.pow(x, Math.pow(2, n+1));
		
		return tophalf/bottomhalf;
	}
	
	public static void main(String args[]){
		
		for(double i = 0.1;  i <= 1; i = i + .10){
			System.out.println("x = " + i + "    sum " + calculateSum(i) + " explicit sum " + explicitSum(i));
		}
	}
	
	public static double explicitSum(double x){
		return x/(1 - x);
	}
	
	public static double calculateSum(double x){
		double sum = 0;
		for(int n = 0; n <= 100; n++){
			double result = nthterm(n,x);
			sum = sum + result;
			
			//System.out.println(n + " : " + result);
			
		}
		
		return sum;
		
	}

}
