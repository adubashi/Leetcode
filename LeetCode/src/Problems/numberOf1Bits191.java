package Problems;

public class numberOf1Bits191 {
	
	public static void main(String args[]){
		
		System.out.println(hammingWeight(3));
		System.out.println(hammingWeight(7));
		
	}
	
	public static int hammingWeight(int n) {
		if(n < 0){
			n = n * -1;
		}
		int result = 0;
	    while(n > 0)
	    {
	        result++;
	        n &= (n -1);
	    }
	    return result;
        
    }

}
