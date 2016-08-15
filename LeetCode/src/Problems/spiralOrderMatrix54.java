package Problems;

import java.util.ArrayList;
import java.util.List;

public class spiralOrderMatrix54 {
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		 
        if(matrix == null || matrix.length == 0) return result;
 
        int m = matrix.length;
        int n = matrix[0].length;
 
        int x=0; 
        int y=0;
        
        while(m > 0 && n > 0){
        	//if one row/column left, no circle can be formed
        	//Row column edge case
            if(m==1){
                for(int i=0; i<n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }
            //below, process a circle
            //top - move right
            for(int i = 0; i < n - 1; i++ ){
            	 result.add(matrix[x][y++]);
            }
            //Go down 
            for(int i = 0; i < m - 1; i++){
            	 result.add(matrix[x++][y]);
            }
            //Go left
            for(int i = 0; i < n - 1; i++){
            	result.add(matrix[x][y--]);
            }
            
            //Go back up
            for(int i = 0; i < m - 1; i++){
            	result.add(matrix[x--][y]);
            }
            
            x++;
            y++;
            m=m-2;
            n=n-2;    
        }
        return result;
    }
	
	public static void main(String args[]){
		int[][] multi = new int[][]{
				  { 1, 2, 3},
				  { 8, 9, 4},
				  { 7, 6, 5},
				};
		System.out.println(spiralOrder(multi).toString());
		
	}

}
