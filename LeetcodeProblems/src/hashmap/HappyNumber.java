package hashmap;

import java.util.HashSet;
import java.util.Set;

/*
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits,
  and repeat the process until the number equals 1 (where it will stay),
   or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.


 */
public class HappyNumber {
	
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
	    while(!set.contains(n)){
	        set.add(n);
	        n = getSum(n);
	        if(n==1) {
	            return true;
	        }
	    }
	    return false;
    }
	
	
	public static int getSum(int n){
	    int sum =0;
	    while(n>0){
	        sum = (int) (sum + Math.pow((n%10), 2));
	        n = n/10;
	    } 
	    return sum;    
	}

}
