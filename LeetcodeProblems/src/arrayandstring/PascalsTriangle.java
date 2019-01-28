package arrayandstring;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {
	
	public static void main(String[] args) {
		
		
		List<List<Integer>> test = generate(2);
		for (List<Integer> l1 : test) {
			   for (Integer n : l1) {
			       System.out.print(n + " "); 
			   }
			   System.out.println();
		} 
	}
	/*
	 * Pascal's triangle
	 * 
	 * Pascal's triangle is just n choose k 
	 * https://www.mathsisfun.com/pascals-triangle.html
	 * 			(0)
	 * 			(0)
	 * 		(1)		(1)
	 * 		(0)		(1)
	 */
	//n Choose R
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ans = new ArrayList<>();
        int pow = numRows-1;
        for(int i =0; i <= pow; i ++){
            List<Integer> row = new ArrayList<>();
            for(int j =0; j <= i ; j ++)
                row.add(combinations(i, j));
                
            ans.add(row);
        }
        
        return ans;
    }
	
	
	public static int combinations(int n, int k) {
		int res = 1; 
        
        if (k > n - k) 
        k = n - k; 
              
        for (int i = 0; i < k; ++i) 
        { 
            res *= (n - i); 
            res /= (i + 1); 
        } 
        return res; 
	}

}
