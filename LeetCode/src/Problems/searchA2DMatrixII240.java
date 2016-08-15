package Problems;

public class searchA2DMatrixII240 {
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
         
        int m = matrix.length;
        int n = matrix[0].length;
         
        int row = m - 1;
        int col = 0;
         
        while( row >= 0 && col < n){
        	if(target == matrix[row][col]){
        		return true;
        	} else if(target < matrix[row][col]){
        		row--;
        	} else {
        		col++;
        	}
        }
        return false;
    }

}
