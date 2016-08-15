package Problems;
import java.util.*;

public class isValidSudoku36 {
	
	//Uber
	public static boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;
		// check each column
		for (int i = 0; i < 9; i++) {
			Set<Character> set = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (set.contains(board[i][j])) {
						return false;
					}
					set.add(board[i][j]);
				}
			}
		}
	 
		//check each row
		for (int j = 0; j < 9; j++) {
			Set<Character> set = new HashSet<Character>();
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (set.contains(board[i][j])) {
						return false;
					}
					set.add(board[i][j]);
				}
			}
		}
	 
		//check each 3*3 matrix
		for (int block = 0; block < 9; block++) {
			Set<Character> set = new HashSet<Character>();
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '.') {
						if (set.contains(board[i][j])) {
							return false;
						}
						set.add(board[i][j]);
					}
				}
			}
		}
	 
		return true;
    }

}
