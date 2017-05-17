package OperatingSystemCompany;
import java.util.*;
public class spiralMatrix54 {
	
	
	public static void main(String args[]){
		
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		
		
		List<Integer> result = spiralOrder(matrix);
		
		//System.out.println(result);
	}
	
	
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
		 
        if(matrix == null || matrix.length == 0) return result;
 
        int m = matrix.length;
        int n = matrix[0].length;
 
        int x=0; 
        int y=0;
        
        while(m > 0 && n > 0){
        	System.out.println("----------");
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
            for(int i = 0; i < n - 1; i++){
            	 System.out.print(matrix[x][y]);
               	 result.add(matrix[x][y++]);
            }
            System.out.println("----------");
            for(int i = 0; i < m - 1; i++){
            	System.out.print(matrix[x][y]);
            	result.add(matrix[x++][y]);
            }
            System.out.println("----------");
            for(int i = 0; i < n - 1; i++){
            	System.out.print(matrix[x][y]);
            	result.add(matrix[x][y--]);
            }
            System.out.println("----------");
            for(int i = 0; i < m - 1; i++){
            	System.out.print(matrix[x][y]);
            	result.add(matrix[x--][y]);
            }
            x++;
            y++;
            n = n - 2;
            m = m - 2;
            
            
        	
        }
        return result;
	}

}
