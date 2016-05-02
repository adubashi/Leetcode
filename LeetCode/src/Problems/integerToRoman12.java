package Problems;

import java.util.*;

public class integerToRoman12 {
	
	public static void main(String args[]){
		
		System.out.println(integerToRoman(4));
		System.out.println(integerToRoman(40));

	}
	public static String integerToRoman(int number) {
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");
        
        int[] keys = {100,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder result = new StringBuilder();
        for(int i = 0; i< keys.length; i++){
        	while(number >= keys[i]){
        		number = number - keys[i];
        		result.append(map.get(keys[i]));
        	}
        }
		
		
		return result.toString();
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
