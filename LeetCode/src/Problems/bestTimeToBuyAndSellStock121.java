package Problems;

public class bestTimeToBuyAndSellStock121 {
	
	public static void main(String args[]){
		
		int[] array = {1,2,4,2,9,1};
		
		System.out.println(maxProfit(array));
		
	}
	
	public static int maxProfit(int[] prices){
		int profit = 0;
		int minElement = Integer.MAX_VALUE;
		
		for(int i = 0; i < prices.length; i++){
			if((prices[i] - minElement) > profit){
				profit = prices[i] - minElement;
			}
			if(prices[i] < minElement){
			   minElement = prices[i];
			}
		}
		return profit;
	}

}
