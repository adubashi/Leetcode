package ProblemsBasedOnDataStructures.DynamicProgramming.LargestRectangle84;

import java.util.Stack;

public class LargestRectangle {
	
	public static int largestRectangle(char[][] array) {
		return 0;
	}
	
	
	
	
	public static int largestHistogram(int[] array) {
		
		Stack<Integer> stk = new Stack<Integer>();
		int top_val;
		int max_area = 0;
		int area = 0;
		
		
		int i = 0;
		
		while(i < array.length) {	
			//If the bar is higher than the top of the stack, push it onto the stack 
			if(stk.isEmpty() || array[stk.peek()] < array[i] ) {
			  stk.push(i);
			  i++;	
			} else {
				//If the bar is lower than the top of the stack, then calculate the 
				//rectanglar area
				int indexOfTop = stk.pop();
				area = array[indexOfTop] *( i);
				
				if(!stk.isEmpty()) {
					area = array[indexOfTop] * (i - stk.peek() - 1);
				}			
				max_area = Math.max(area, max_area);
			}
		}
		
		while(!stk.isEmpty()) {
			 top_val = array[stk.peek()];
	         stk.pop();
	         area = top_val * i;
	         if (!stk.isEmpty()) {
	                area = top_val * (i - stk.peek() - 1 );
	         }
	         max_area = Math.max(area, max_area);
		}
		
		
	}

}
