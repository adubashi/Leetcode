package ProblemsBasedOnDataStructures.Stack.LargestRectangleInHistogram84;

import java.util.Stack;

public class LargestRectangle {
	
	public static int largestRectangleArea(int[] heights) {	
				//Stack that holds the heights 
				Stack<Integer> stk = new Stack<Integer>();
				
				int maxArea = 0;
				int tp;
				int areaWithTop;
				
				int i = 0;
				while( i < heights.length){
					
					if(stk.isEmpty() || heights[stk.peek()] <= heights[i] ){
					   stk.push(i);
					   i++; 	
					} else {
					   int smallestIndex = stk.pop();
					   if(stk.isEmpty()){
		                   areaWithTop = heights[smallestIndex] * i;
					   } else {
						   areaWithTop = heights[smallestIndex] * (i - stk.peek() - 1);
					   }
					   if(maxArea < areaWithTop){
						   maxArea = areaWithTop;
					   }	   
					}		
				}
				while(!stk.isEmpty()){
					tp = stk.pop();
					if(stk.isEmpty()){
						areaWithTop = heights[tp] * (i);
					} else {
						areaWithTop = heights[tp] *( i - stk.peek() - 1);
					}
					if(maxArea < areaWithTop ){
						maxArea = areaWithTop;
					}
				}	
				return maxArea;   
    }

}
