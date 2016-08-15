package Problems;

public class isPowerOfFour342 {
	
	public static boolean isPowerOf4(int num){
		if(num == 0){
			return false;
		}
		int pow = (int)(Math.log(num)/Math.log(4));
		
		if(Math.pow(4, pow) == num){
			return true;
		} else {
			return false;
		}
		
	}

}
