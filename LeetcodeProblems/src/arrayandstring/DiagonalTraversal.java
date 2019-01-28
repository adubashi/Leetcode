package arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DiagonalTraversal {
	
	public static void main(String[] args) {
		int[][] array = { {1,2,3},
						 {4,5,6},
						 {7,8,9}};
		int[] result = findDiagonalOrder(array);
		System.out.println(Arrays.toString(result));
	}
	
	/*
	 * 1. Have a flag = isUp that determines whether it does up or down 
	 * 2. Have one loop that determines whether all the elements get printed 
	 * - Going up: i>=0 && j<n ; j++, i--
	 * - Going down: j >= 0 && i<n ; i++ , j--
	 * 
	 */
	public static int[] findDiagonalOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return new int[0];
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		boolean isUp = true;
		int i = 0;
		int j = 0; 
		
		//Matrix Length
		int horizontalLength = matrix.length;
		int verticalLength = matrix[0].length;
		
		for(int k = 0; k < horizontalLength * verticalLength;) {
			if(isUp) {
				while( i >= 0 && j < verticalLength) {
					System.out.println(matrix[i][j]);
					list.add(matrix[i][j]);
					k++;
					i--;
					j++;
				}
				if(i < 0 && j <= verticalLength - 1) {
					i = 0;
				}
				if( j == verticalLength) {
					i = i + 2;
					j--;	
				}
				
			} else {
				while(j >= 0 && i < horizontalLength) {
					System.out.println(matrix[i][j]);
					list.add(matrix[i][j]);
					k++;
					j--;
					i++;
				}
				if(j < 0 && i <= horizontalLength - 1) {
					j = 0;
				}
				if( i == horizontalLength) {
					j = j + 2;
					i--;
				}		
			}
			isUp = !isUp; 
		}
        return list.stream().mapToInt(p -> p).toArray();
    }
}
