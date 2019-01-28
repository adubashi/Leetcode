package ProblemsBasedOnDataStructures.BitManipulation.numberOf1bits191;

public class NumberOfOneBits {
	
	public static void main(String args[]) {
		System.out.println(numberOfOneBits2(12));
	}
	
	
	public static int numberOfOneBits(int n) {
		if(n < 0) {
			n = -1 * n;
		}
		
		String s = Integer.toBinaryString(n);
		
		int numberOfOnes = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1') {
			   numberOfOnes++;
			}
		}
		return numberOfOnes;
	}
	
	public static int numberOfOneBits2(int n) {
		
		
		if(n < 0) {
			n = -1 * n;
		}
		
		int count = 0;
		while( n >= 1) {
			int remainder = n % 2;		
			if(remainder == 1) {
			   count++;
			}
			n = n / 2;
		}
		return count;
	}
	//Basically removes all bits up to the next set bit on the next iteration
	public static int numberOfOneBits3(int n) {
		int count = 0;
		while(n != 0) {
			
			
			n = n & (n - 1);
			count++;
		}
		return count;
	}
	
	

	
}
