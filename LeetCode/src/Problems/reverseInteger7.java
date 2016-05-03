package Problems;

public class reverseInteger7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(reverseInteger(2147483700));
		System.out.println(reverseInteger(1234567899));

	}
	
	public static int reverseInteger(int integer){
		int reversed = 0;
		while(integer != 0){
			//Handles the overflow
			if (reversed != 0 && Integer.MAX_VALUE / reversed < 10 
				&& Integer.MAX_VALUE / reversed > -10){
                return 0;
			}
			//Reversed calculation
			reversed = reversed * 10 + integer % 10;
			integer = integer / 10;
		}
		return reversed;
	}
	
	public static int reverseInteger2(int integer){
		int reversed = 0;
		while(integer != 0){
			//Handles the overflow
			//Reversed calculation
			try {
			reversed = reversed * 10 + integer % 10;
			integer = integer / 10;
			} catch(Exception e){
				System.out.println("Overflow");
			}
		}
		return reversed;
	}

}
