package ProblemsBasedOnDataStructures.Stack.trappingRainWater42;

import java.util.Arrays;
import java.util.Stack;

public class TrappingRainWater {
	
	
	/*
	 * 
	 * Algorithm thoughts 
	 * 
	 * 1st thought:
	 * Use a stack
	 * 
	 *  Push the height to the stack 
	 *  
	 *  If the next height is less than the top of the stack, add the difference to the max rainwater.
	 *  Pop the stack and push the height to the stack
	 *  
	 *  If the next height is greater than the top of the stack, do nothing. Push the new height  
	 *  to the stack. 
	 *  ----------------
	 *  
	 *  2nd thought:
	 *  Push the height to the stack but this time in units of 1
	 *  
	 *  If the next height is less than the total size of a stack 
	 *  - add the difference to the total rainwaiter
	 *  	> pop the stack the difference between the total size of the stack and the current height
	 *  - If the next height is greater than the total size of the stack --> Not sure. This doesn't properly handle the case.
	 *  
	 *  3rd thought:
	 *  How to handle the case where the height goes up and we still have rainwater to collect
	 *  
	 *  How to handle the case where the height goes down but there is no rainwater to collect 
	 *  ------------
	 *  
	 * 4th thought: Fuck a stack
	 * 
	 *  
	 *  Scan left to right and right to left to find the max on the left of i and the max height on
	 *  the right of i 
	 *  
	 *  
	 * 
	 *  
	 * 
	 * 
	 */

	
	public static int trapRainWater(int[] height){
		
		if(height.length == 0 || height.length == 1){
			return 0;
		}
		
		//From left to right 
		int[] maxSeenLeft = new int[height.length];
		maxSeenLeft[0] = 0;
		int maxFromLeft = 0;
		for(int i = 1; i < height.length; i++){
			int previousTowerHeight = height[i-1];	
			if( previousTowerHeight > maxFromLeft){
				maxFromLeft = previousTowerHeight;
				maxSeenLeft[i] = maxFromLeft;
			} else {
				maxSeenLeft[i] = maxFromLeft;
			}
		}
		
		System.out.println(Arrays.toString(maxSeenLeft));
		
		//From right to left
		int[] maxSeenRight = new int[height.length];
		maxSeenRight[height.length - 1] = 0;
		int maxFromRight = 0;
		for(int i = height.length -2; i >= 0; i--){
			int previousTowerHeight = height[i + 1];
			
			if(previousTowerHeight > maxFromRight){
				maxFromRight = previousTowerHeight;
				maxSeenRight[i] = maxFromRight;
			} else {
				maxSeenRight[i] = maxFromRight;
			}
		}
		
		System.out.println(Arrays.toString(maxSeenRight));
		
		
		//Calculate max rainwater 
		
		int maxRainWater = 0;
		for(int i = 0; i < height.length; i++){
			maxRainWater = maxRainWater + Math.max(Math.min(maxSeenLeft[i],maxSeenRight[i]) - height[i],0);
		}
		
		System.out.println(maxRainWater);
		return maxRainWater;
		
	}
		
	
	public static void main(String args[]){
		int[] testData = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		trapRainWater(testData);
		
		
	}
		
		
		
	
	
}
