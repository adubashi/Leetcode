package ProblemsBasedOnDataStructures.DynamicProgramming.LargestRectangle84;

import java.util.Stack;

public class LargestRectangle {
	

	
	
	
	public static int largestHistogram(int[] array) {	
		Stack<Integer> stk = new Stack<Integer>();
		int top_val;
		int max_area = 0;
		int area = 0;
		
		
		int i = 0;	
		while(i < array.length) {	
			//If the bar is higher than the top of the stack, push it onto the stack 
			if(stk.isEmpty() || Character.getNumericValue(array[stk.peek()]) < 
					Character.getNumericValue(array[i]) ) {
			  stk.push(i);
			  i++;	
			} else {
				//If the bar is lower than the top of the stack, then calculate the 
				//rectanglar area
				int indexOfTop = stk.pop();
				area = array[indexOfTop] *(i);
				
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
		
		return max_area;	
	}
	
	
	public static int maximalRectangle(char[][] matrix) {
		
		int R = matrix.length;
		int D = R == 0 ? 0 : matrix[0].length;
		int[][] height = new int[R][D+1];
		
		int maxArea = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < D; j++) {
				if(matrix[i][j] == '0') {
					height[i][j] = 0;
				} else {
					height[i][j] = i == 0 ? 1 : height[i-1][j] + 1;
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			int area = largestHistogram(height[i]);
			if (area > maxArea) {
				maxArea = area;
			}
		}
	 
		return maxArea;
		
	}
	
	public  int largestHistogramSecond(int[] height) {	
		Stack<Integer> stack = new Stack<Integer>();
 
        int i = 0;
        int max = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                max = Math.max(max, height[t]
                        * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        return max;	
   }
	
	
	public int maximalRectangleSecond(char[][] matrix) {
		
		int R = matrix.length;
		int D = R == 0 ? 0 : matrix[0].length;
		int[][] height = new int[R][D + 1];
		
		int maxArea = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < D; j++) {
				if(matrix[i][j] == '0') {
					height[i][j] = 0;
				} else {
					height[i][j] = i == 0 ? 1 : height[i-1][j] + 1;
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			int area = largestHistogramSecond(height[i]);
			if (area > maxArea) {
				maxArea = area;
			}
		}
	 
		return maxArea;
		
	}

}
