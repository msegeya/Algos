/**
	Question: Rotate Matrix Elements.

	Reference: http://www.geeksforgeeks.org/rotate-matrix-elements/

	Input:
				1    2    3
				4    5    6
				7    8    9

	Output:
				4    1    2
				7    5    3
				8    9    6

	Logic: 
		- Instead of creating an arraylist to rotate here we will rotate the matrix using swapping.
		- Following is the order of the rotation,
			1) Shift elements of top row.
			2) Shift elements of last column.
			3) Shift elements of bottom row.
			4) Shift element of first column.
		- Same logic as we have followed in spiral form. But here istead of printing we will swap the element with the next element as per shifting rules.	
*/


class MatrixRotation {

	public static int[][] rotate(int[][] grid, int rot) {
		while(rot > 0) {
			grid = rotate(grid);
			rot--;
		}

		return grid;
	}

	public static int[][] rotate(int[][] grid) {
		int start_row = 0;
		int start_col = 0;
		int last_row = grid.length;
		int last_col = grid[0].length;

		while(start_row < last_row && start_col < last_col) {
			// If the next row is the last row then break.
			if(start_row + 1 == last_row || start_col + 1 == last_col) {
				break;
			}

			int prev = -1;
			int curr = -1;
			int i = 0; // iterator.

			prev = grid[start_row + 1][start_col];

			// first row
			for(i = start_col; i < last_col; i++) {
				curr = grid[start_row][i];
				grid[start_row][i] = prev;
				prev = curr;
			}
			start_row++;

			// last column
			for(i = start_row; i < last_row; i++) {
				curr = grid[i][last_col - 1];
				grid[i][last_col - 1] = prev;
				prev = curr;
			}
			last_col--;

			// last row
			if(start_row < last_row) {
				for(i = last_col - 1; i >= start_col; i--) {
					curr = grid[last_row - 1][i];
					grid[last_row - 1][i] = prev;
					prev = curr;
				}	
			}
			last_row--;

			// first column
			if(start_col < last_col) {
				for(i = last_row - 1; i >= start_row; i--) {
					curr = grid[i][start_col];
					grid[i][start_col] = prev;
					prev = curr;
				}
			}
			start_col++;
		}

		return grid;
	}

	public static void main(String[] args) {
		int[][] A = { 
						{1,  2,  3,  4},
				        {5,  6,  7,  8},
				        {9,  10, 11, 12},
				        {13, 14, 15, 16}  
				    };
		int rot = 1;
		MatrixUtil.print(A, "Input Matrix is:");

		A = rotate(A, rot);
		MatrixUtil.print(A, "Matrix Rotation for Rotations = " + rot);
	}
}