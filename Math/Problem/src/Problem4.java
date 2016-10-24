
public class Problem4 {
	public static int[] array = new int[300];
	public static String output = "27";
	public static void main(String args[]){
		
		
		array[0] = 2;
		array[1]  = 7; 
		
		//generate(1, 2, 7);
		gen(300);
		System.out.println(output);
	}
	
	public static void gen(int n){
		int num = 2;
		int num1 = 7;
		for(int i = 0; i < 6; i++){
			int product  = num * num1;
			String product1 = String.valueOf(product);
			char[] digits1 = product1.toCharArray();
			System.out.println(new String(digits1));
			output = output + new String(digits1);
			if(digits1.length == 2){
				num =  Character.getNumericValue(output.charAt(output.length() - 2));
				num1 =  Character.getNumericValue(output.charAt(output.length() - 3));
			} else {
				num = Character.getNumericValue(output.charAt(output.length() - 2));
				num1 = Character.getNumericValue(output.charAt(output.length() - 3));
				
			}
		}
	}
	
	
	public static void generate(int total, int number, int number1){
		if(total == 0){
			return;
		} else {
			Integer product = number * number1;
			String product1 = String.valueOf(product);
			char[] digits1 = product1.toCharArray();
			
			output = output + new String(digits1);
			System.out.println(digits1);
			
			
			generate(total - 1, number1, Character.getNumericValue(digits1[0])  );
		}
	
		
	}

}
