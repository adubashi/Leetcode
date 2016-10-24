import java.util.Arrays;

public class Problem6 {
	
	public static void main(String args[]){
		
		int[] array = digits(2679);
		
		System.out.println(Arrays.toString(array));
		
		for(int i = 0; i < array.length; i++){
			System.out.println(i + " = " +array[i]);
		}
		
	}
	
	public static int[] digits(int n){
		int[] array = new int[10];
		int total = 0;
		
		
		for(int i = 1; i <= n; i++){

			String numString = String.valueOf(i);
			System.out.println(numString);
			char[] digits1 = numString.toCharArray();
			System.out.println(Arrays.toString(digits1));
			
			for(int j = 0; j < digits1.length; j++){
				System.out.println(digits1[j]);
				int index = Character.getNumericValue(digits1[j]);
				System.out.println(index);
				array[index]++;
			}

		}
		
		System.out.println("Total number of digits: " + total);
		return array;
	}

}
