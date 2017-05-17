
public class Problem46 {
	
	public static void main(String args[]){
		
		System.out.println(summation(1000000));
	}
	
	public static double nthTerm(int n){
		return 1/(Math.pow(n,2) + 2*n);
	}
	
	public static  double summation(int k){
		double sum = 0;
		for(int i = 1; i < k; i++){
			System.out.println(nthTerm(i));
			sum = sum + nthTerm(i);
		}
		return sum;
	}

}
