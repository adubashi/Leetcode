package stackandqueue;

import java.util.*;
/*
 * Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string],
 where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid;
 No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 For example, there won't be input like 3a or 2[4].
 
 
 s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc". -> 2,3 , c,a 
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

If we hit a number, we add it to to number stack. 

If we hit a opening bracket [, start adding the second string to the string stack.
 */

public class DecodeString {
	
	public static void main(String args[]) {
		String s = "3[a]2[bc]";
		String res = decodeString(s);
		System.out.println(res);
	}
	
	
	/*
	 * Use a stack
	 * One stack to store numbers, another to store the sequences
	 * Iterate through the string 
	 */
	public static String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		// 记录'['之前的数字
		Stack<Integer> countStack = new Stack<>();
		// 记录'['之前的运算结果
		Stack<String> resStack = new Stack<>();
		int idx = 0;
		int curNum = 0;
		while (idx < s.length()) {
			if(Character.isDigit(s.charAt(idx))) {
				curNum = 0;
				while(Character.isDigit(s.charAt(idx))) {
					curNum = 10 * curNum + (s.charAt(idx) - '0');
					idx++;
				}
				countStack.push(curNum);
			} else if(s.charAt(idx) == '[') {
				resStack.push(res.toString());
                res = new StringBuilder();
                idx++;
			} else if(s.charAt(idx) == ']') {
				//Unwind stack
				StringBuilder temp = new StringBuilder(resStack.pop());
				int repeatTimes = countStack.pop();
				for(int i = 0; i < repeatTimes; i++) {
					temp.append(res);
				}
				res = temp;
				idx++;
			} else {
				res.append(s.charAt(idx));
				idx++;
			}
		}
		return res.toString();
    }

}
