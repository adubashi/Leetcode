package arrayandstring;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = {'c', 'a', 't'};
		char[] array2 = {'b', 'a', 't', 's'};
		reverseString(array2);

	}
	
	public static void reverseString(char[] s) {
		if(s == null || s.length == 0) {
			return;
		}
		int i = 0;
		int j = s.length - 1;	
		while( i < j) {
			swap(s, i, j);
			i++;
			j--;
		}
	}
	
	public static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
