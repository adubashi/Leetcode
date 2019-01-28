package arrayandstring;

public class AddBinary {
	
	
	public static void main(String args[]) {
		System.out.println(addBinary("11", "1"));
	}
	/*
	 * Given two binary strings, return their sum (also a binary string).
     * The input strings are both non-empty and contains only characters 1 or 0.
     * 
     * 
     * 
	 */
	public static String addBinary(String a, String b) {
		
		int i = a.length() - 1;
		int j = b.length() - 1;
		
		StringBuffer result = new StringBuffer();
		int carry = 0;
		
		while(i >= 0 || j >= 0 || carry == 1) {
			int sum = 0;
			if(i >= 0) {
				char charA = a.charAt(i);
				int valueOfCharA = Integer.parseInt(String.valueOf(charA));	
				sum = sum + valueOfCharA;
			}
			if(j >= 0) {
				char charB = b.charAt(j);
				int valueOfCharB = Integer.parseInt(String.valueOf(charB));
				sum = sum + valueOfCharB;
			}
			sum = sum + carry;
			int digit = sum % 2;
			carry = sum / 2;
			result.append(Character.forDigit(digit, 10));
			i--;
			j--;
		}
		String reversed = result.reverse().toString();
		return reversed;
    }

}
