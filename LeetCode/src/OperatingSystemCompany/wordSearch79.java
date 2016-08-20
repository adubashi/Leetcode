package OperatingSystemCompany;

public class wordSearch79 {
	
	
	public boolean wordSearch(char[][] board, String word){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(dfs(board,word,i,j,0)){
					return true;
				}
			}
		}
		return false;
	}
	
	//DFS to find the word
	public boolean dfs(char[][] board, String word, int i, int j, int k){
		
		int n = board.length;
		int m = board[0].length;
		
		if(i  < 0 || j < 0 || i>=m || j >= n){
			return false;
		}
		
		if(word.charAt(k) == board[i][j]){
			char temp = board[i][j];
			board[i][j] = '#';
			if(k == word.length()-1){
			   return true;
			} else {
				dfs(board,word,i + 1,j,k+1);
				dfs(board,word,i,j + 1,k+1);
				dfs(board,word,i- 1,j,k+1);
				dfs(board,word,i,j-1,k+1);
			}
			board[i][j] = temp;
		} 		
		return false;
	}

}
