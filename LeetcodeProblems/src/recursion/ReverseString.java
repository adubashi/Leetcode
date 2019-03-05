package recursion;

import java.util.Arrays;

public class ReverseString {
	
	
	public static void main(String[] args) {
		char[] s = {'c', 'a', 't'};	
		System.out.println(Arrays.toString(s));
		reverseString(s);
		System.out.println(Arrays.toString(s));
	}
	
	public static void reverseString(char[] s) {
		helper(0, s.length-1, s);
	}
	
	public static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	private static void helper(int start, int end, char [] s) {
		 if(start >= end) {
			 return;
		 }
		 swap(s, start, end);
		 helper(start + 1, end - 1, s);
	}

}
