package stackandqueue;

public class Matrix01 {
	
	public int[][] updateMatrix(int[][] matrix) {
		int m=matrix.length;
		if(m==0)return null;
		int n=matrix[0].length;
		boolean[][] visited=new boolean[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=matrix[i][j]==0?0:Integer.MAX_VALUE-1;
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(visited[i][j]==false && matrix[i][j]!=0){
                    dfs(matrix,visited,i,j);
                }
			}
		}
		return matrix;
	}
	public int dfs(int[][] matrix,boolean[][] visited,int row,int col){
		if(row < 0 || col < 0 || col >= matrix[0].length || row >= matrix.length) {
			return Integer.MAX_VALUE-1;
		}
		if(visited[row][col] == true) {
			return matrix[row][col];
		}
		visited[row][col] = true;
		if(row-1>=0) {
			matrix[row][col]=Math.min(matrix[row-1][col]+1,matrix[row][col]);
		}
		if(row+1<matrix.length) {
			matrix[row][col]=Math.min(matrix[row+1][col]+1,matrix[row][col]);
		}
		if(col-1>=0) {
			matrix[row][col]=Math.min(matrix[row][col-1]+1,matrix[row][col]);
		}
		if(col+1<matrix[0].length) {
			matrix[row][col]=Math.min(matrix[row][col+1]+1, matrix[row][col]);
		}
		int d1 = dfs(matrix, visited, row + 1, col);
		int d2 = dfs(matrix, visited, row - 1, col);
		int d3 = dfs(matrix, visited, row, col - 1);
		int d4 = dfs(matrix, visited, row, col + 1 ); 
		int min= Math.min(Math.min(Math.min(d1,d2),d3),d4)+1;
        matrix[row][col]=Math.min(matrix[row][col],min);
		return matrix[row][col];
	}

}
