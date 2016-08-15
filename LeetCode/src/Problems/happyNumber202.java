package Problems;
import java.util.*;
public class happyNumber202 {
	
	public static boolean isHappy(int n){
		Set<Integer> set = new HashSet<Integer>();
		
		while(!set.contains(n)){
			set.add(n);
			n = sum(getDigits(n));
			if(n == 1){
				return true;
			}
		}
		return false;
		
	}
		
	public static int[] getDigits(int n){
		String s = String.valueOf(n);
		int[] result = new int[s.length()];
		int i = 0;
		while(n > 0){
			int m = n % 10;
			result[i] = m;
			i++;
			n = n / 10;
		}
		return result;
	}
	
	public static int sum(int[] arr){
		int result = 0;
		for(int i: arr){
			result = result + i*i;
		}
		return result;
	}

}
