package Problems;

public class palindromeNumber9 {

	public static void main(String[] args) {
		System.out.println(isPalindrome(123321));
	}
	
	//Check each end against each other
	public static boolean isPalindrome(int x){
		//Assume all negatives and 0 is not a palindrome
		if(x <= 0){
			return false;
		}
		int div = 1;
		while(x/div >= 10){
			div = div * 10;
		}
		System.out.println("Div" + div);
		//Make it so that divisor the correct multiple of ten
		
		while( x != 0){
			int r = x % 10;
			int l = x / div;
			if(l != r) return false;
			
			System.out.println(x % div);
			System.out.println((x % div) / 10);
			// x % div --> slice off right
			// (x % div) / 10 --> slice off left
			x = (x % div) / 10;
			
			//just slice off two numbers, divisor is 100 less.
			div /= 100;
		}
		return true;
	}

}
