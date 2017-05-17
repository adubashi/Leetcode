package OperatingSystemCompany;
import java.util.*;
public class setMatrixZeroes73 {
	
	public static void main(String args[]){
		int[][] matrix = {{1,2,3},{4,0,6},{7,8,9}};
		
		//System.out.println(Arrays.deepToString(matrix));
		setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));	
	}
	
	public static void setZeroes(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		//set rows to zero
		for(int i = 0; i<matrix.length; i++){
			if(row[i]){
				setRowToZero(matrix,i);
			}
		}
		
		//Set column to zero
		for(int i = 0; i<matrix[0].length; i++){
			if(column[i]){
				setColumnToZero(matrix,i);
			}
		}
		
		
	}
	
	
	public static void setRowToZero(int[][] matrix, int row){
		for(int i = 0; i < matrix.length; i++){
			matrix[row][i] = 0;		
		}
	}
	
	public static void setColumnToZero(int[][] matrix, int col){
		for(int i = 0; i < matrix[0].length; i++){
			matrix[i][col] = 0;		
		}
	}

}
