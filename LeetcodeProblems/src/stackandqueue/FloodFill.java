package stackandqueue;

public class FloodFill {
	/*
	 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
 and a pixel value newColor, "flood fill" the image.
To perform a "flood fill", consider the starting pixel,
 plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
At the end, return the modified image.
	 */
	//Image 
	//Row -> sr
	//Column -> sc
	//New Color
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }
	
	public void dfs(int[][] image, int r, int c, int color, int newColor) {
		
		//Base case
		if(c < 0 || r < 0 || c >= image[0].length || r >= image.length) {
			return;
		}
		if (image[r][c] == color) {
            image[r][c] = newColor;
            dfs(image, r-1, c, color, newColor);
            dfs(image, r, c-1, color, newColor);
            dfs(image, r+1, c, color, newColor);
            dfs(image, r, c+1, color, newColor);
        }
    }

}
