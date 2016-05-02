package Problems;

public class romanToInteger11 {
	
	public static void main(String args[]){
		
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("V"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("XIII"));
		System.out.println(romanToInt("XIV"));
	}
	
	
	
	
	public static int romanToInt(String s) {
		int result = 0;
		for(int i =0; i < s.length(); i++){
			if(i > 0 && charToInt(s.charAt(i)) > charToInt(s.charAt(i-1))){
				result += (charToInt(s.charAt(i)) - 2*charToInt(s.charAt(i-1)));
			} else {
				result += charToInt(s.charAt(i));
			}
		}
		return result;
    }
	
	public static int charToInt(char c){
		switch(c){
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		default : return 0;
		}
	}
}
