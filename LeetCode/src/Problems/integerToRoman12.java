package Problems;

import java.util.*;

public class integerToRoman12 {
	
	public static void main(String args[]){
		
		//System.out.println(integerToRoman(4));
		System.out.println(integerToRoman(400));

	}
	public static String integerToRoman(int num) {
		
		String[] dict = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
        StringBuilder ret = new StringBuilder();
        for(int i=0; i<13; i++) {
            if(num>=val[i]) {
                int count = num/val[i];
                num %= val[i];
                for(int j=0; j<count; j++) {
                    ret.append(dict[i]);
                }
            }
        }
        return ret.toString();
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
