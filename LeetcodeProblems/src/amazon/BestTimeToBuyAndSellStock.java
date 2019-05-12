package amazon;

public class BestTimeToBuyAndSellStock {
	
	
	public static void main(String args[]) {
		int[] array = {7,1,5,3,6,4};
		maxProfit(array);
		
	}
	
	
	/*
	 * 1. Have an index that goes through the array(front window)
	 * 2. As we go through the array, keep track of the current minimum stock price
	 * 3. If current element is greater than the minimum, then set the max profit to the max of maxProfit and prices[i] - soFarMin
	 * 4. If it is not then we have a new minimum and we should get the soFarMin to the prices[i]
	 */
	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			 return 0 ;
		 }		
		 int maxProfit = 0 ;
		 int sofarMin = prices[0] ;
		for(int frontWindow = 1; frontWindow < prices.length; frontWindow++) {
			if (prices[frontWindow] > sofarMin) {
	    		 	maxProfit = Math.max(maxProfit, prices[frontWindow] - sofarMin) ;
		    	 } else{
		    		sofarMin = prices[frontWindow];  
		    	 }
		}
		System.out.println(maxProfit);
        return maxProfit;
    }

}
