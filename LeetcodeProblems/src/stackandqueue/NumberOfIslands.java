package stackandqueue;

public class NumberOfIslands {
	
	public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    traverseIsland(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public static void traverseIsland(char[][] grid, int x, int y){
        if(x >= grid.length ||
           x < 0 ||
           y < 0 ||
           y >= grid[0].length){
            return;
        } 
        if(grid[x][y] != '1'){
            return;
        } 
        if(grid[x][y] == '1'){
            grid[x][y] = 'X';
            traverseIsland(grid, x - 1, y);  
            traverseIsland(grid, x, y - 1);
            traverseIsland(grid, x + 1, y);
            traverseIsland(grid, x, y + 1);
        }
        
    }

}
