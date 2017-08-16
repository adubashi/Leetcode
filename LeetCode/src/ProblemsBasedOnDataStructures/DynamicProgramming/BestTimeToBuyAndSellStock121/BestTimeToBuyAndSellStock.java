package ProblemsBasedOnDataStructures.DynamicProgramming.BestTimeToBuyAndSellStock121;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {7,1,5,3,6,4};
		int k = bestTimeDP(array); // 5
		
		System.out.println(k);

	}
	
	public static int bestTimeTwoLoops(int[] array) {
		
		int maxProfit = 0;
		for(int i = 0; i < array.length; i++) {
			int firstStock = array[i];
			for(int j = i+1; j < array.length; j++) {
				int secondStock = array[j];
				maxProfit = Math.max(maxProfit, secondStock-firstStock);
				
			}
		}
		return maxProfit;
	}
	
	public static int bestTimeDP(int[] array) {
		int profit = 0;
		int min = array[0];
		
		for(int i = 1; i < array.length; i++) {
			if(min > array[i]) {
				min = array[i];
			}
			profit = Math.max(profit, array[i] - min);
		}
		return profit;
		
		
	}

}
