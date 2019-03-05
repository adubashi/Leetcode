package stackandqueue;

import java.util.*;

public class DailyTemperatures {
	
	public void main(String[] args) {
		int[] array = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] res = dailyTemperatures(array);
		
		
		
	}
	/*
	 * Use stack to keep index 
	 */
	public static int[] dailyTemperatures(int[] T) {
		int out[] = new int[T.length];
		Stack<Integer> stk = new Stack<Integer>();
		
		//Push init index
		stk.push(0);
		
		for(int i = 1; i < T.length; i++) {
			while(!stk.isEmpty()  && T[i] > T[stk.peek()]) {
				int top = stk.pop();
				out[top] = i-top;
			}
			stk.push(i);
		}
		
		while(!stk.isEmpty()){
			int top = stk.pop();
			out[top] = 0; //nothing
		}
		return out;
    }

}
