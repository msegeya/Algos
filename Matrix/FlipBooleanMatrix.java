/**
	Question: Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.

	Reference: http://www.geeksforgeeks.org/a-boolean-matrix-question/

	Logic: TC = O(ROWS * COLS) and SC = O(ROWS + COLS)
		- Take two arrays .. row[], col[] of size array.length and array[0].length repectively.
		- Traverse the matrix and do the following,
			If matrix[i][j] == 1 then make row[i] = 1 and column[j] = 1
		- Traverse the matrix again and do the following,
			matrix[i][j] = 1 if row[i] == 1 || col[j] == 1
		- Finally print matrix.	
*/

class FlipBooleanMatrix {
	public static void main(String[] args) {
		int[][] grid = {
							{1, 0, 0, 1},
							{0, 0, 1, 0},
							{0, 0, 0, 0}
					   };

		MatrixUtil.print(grid, "Input Matrix: ");			   

		printFlipOfMatrix(grid);
	}

	public static void printFlipOfMatrix(int[][] grid) {
		int ROWS = grid.length;
		int COLS = grid[0].length;

		int[] row = new int[ROWS];
		int[] col = new int[COLS];

		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				if(1 == grid[i][j]) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				if(1 == row[i] || 1 == col[j]) {
					grid[i][j] = 1;
				}
			}
		}

		MatrixUtil.print(grid, "Output Matrix:");
	}
}