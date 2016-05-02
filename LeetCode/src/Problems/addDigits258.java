package Problems;

public class addDigits258 {
	
	public static void main(String args[]){
		
		System.out.println(addDigits(38));
		
	}
	
	//O(N) time
	public static int addDigits(int num){
		while (num >= 10) {
            int newNum = 0;
            while (num > 0) {
                newNum += num % 10;
                num /= 10;
            }
            num = newNum;
        }
        return num;
	}
	
	public static int addDigitsFast(int num){
		int d = (int)Math.floor((num-1)/9);
        
        return num - 9*d;
	}

}
