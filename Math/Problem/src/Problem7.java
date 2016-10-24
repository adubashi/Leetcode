
public class Problem7 {
	public static void main(String args[]){
		
		Double r1 = -2.06443;
		Double r2 = 1.17248;
		Double r3 = 2.89195;
		
		
		for(int i = 1; i < 1000; i++){
			
			Double sum = Math.pow(r1, i) + Math.pow(r2, i) + Math.pow(r3, i);
			
			if(sum > Double.MAX_VALUE){
				break;
			}
			
			System.out.println("Power: " + i + "--Sum of Roots: " + sum);
			System.out.println("Power: " + i + "--Sum of Roots(Rounded): " + Math.round(sum));
			
		}
	}

}
