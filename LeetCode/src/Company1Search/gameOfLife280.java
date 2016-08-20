package Company1Search;

import java.util.Arrays;

public class gameOfLife280 {
	
	
	
	
	private static final int[][] NEIGHBOURS = {
	    {-1, -1}, {-1, 0}, {-1, +1},
	    { 0, -1},          { 0, +1},
	    {+1, -1}, {+1, 0}, {+1, +1}};
	
	public static void main(String args[]){
		int[][]  array = { {1,1} , {1,0} } ;
		
		gameOfLifeInPlace(array);
	}
	    
	public void gameOfLife(int[][] board){
	    gameOfLifeInPlace(board);
	}
	    
	    
	public static void gameOfLifeInPlace(int[][] board){
	    for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				int sum = 0;
                int mn = board[i][j];
                sum = value(board,i-1,j-1) + value(board,i-1,j) + value(board,i-1,j+1) + value(board,i,j-1) + 
                    value(board,i,j+1) + value(board,i+1,j-1) + value(board,i+1,j) + value (board,i+1,j+1);
                if (mn == 0 && sum == 3){
                    board[i][j] = -1;
                }else if(mn == 1 && sum < 2){
                    board[i][j] = -2;
                }else if (mn == 1 && sum > 3){
                    board[i][j] = -2;
                }
			}
		}
		
		for (int i = 0; i<board.length; i++){
	        for (int j = 0; j<board[0].length; j++){
	              int mn = board[i][j];
	              if (mn == -1 || mn == -2){
	                  board[i][j] = mn + 2;
	              }
	        }
	    }
		//Printing
		for (int[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
	}
	public void gameOfLifeNotInPlace(int[][] board) {
		
		int[][] newBoard = new int[board.length][board[0].length];
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				int mn = board[i][j];
				int sum = countNeighbors(i,j,board);
				System.out.println(sum);
				if(sum < 2){
					newBoard[i][j] = 0;
				}
				if(sum == 2 || sum == 3){
					newBoard[i][j] = board[i][j];
				}
				if(mn == 0 && sum == 3){
					newBoard[i][j] = 1;
				}
				if(sum > 3){
					newBoard[i][j] = 0;
				}
			}
		}
		
		//Copy over
		for(int i=0; i<board.length; i++)
			  for(int j=0; j<board[i].length; j++)
			    board[i][j]= newBoard[i][j];
		
		//Printing
		for (int[] arr : newBoard) {
            System.out.println(Arrays.toString(arr));
        } 
    }
	
	public static int countNeighbors(int x, int y, int[][] board){
		int count = 0;
	    for (int[] offset : NEIGHBOURS) {
	    	int newx = x + offset[1]; 
	    	int newy = y + offset[0];
	        if (validIndex(newx,newy,board) && board[newx][newy]  == 1) {
	           count++;
	        }
	    }
	    return count;
	}
	
	public static boolean validIndex(int x, int y, int[][] board){
		return (x >= 0 && x < board.length) && (y >= 0 && y < board[0].length);
	}
	
	public static int value (int[][] board, int i, int j ){
        int m = board.length;
        int n = board[0].length;
        if (i<0 || j<0 || i>m-1 ||j>n-1){
            return 0;
        }else{
            int cur = board[i][j];
            if (cur == -2){
                return 1;
            }else if(cur == -1){
                return 0;
            }else{
                return cur;
            }
        }
    }
}
