/**
	Question: Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.

	Example:    0 1 1 1
				0 0 1 1
				1 1 1 1  // this row has maximum 1s
				0 0 0 0

	Reference:  http://stackoverflow.com/a/5388634/967638
				http://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/

	Logic: 
		- Start from the top-right most cell.
		- If cell is "1" then move left in the same row. Max will be the current row.
		- If cell is "0" then move down in the same column. Make max as the current row.
*/

class MaxRowWith1s {
	public static void main(String[] args) {
		int[][] grid = {
							{0, 1, 1, 1},
							{0, 0, 1, 1},
							{1, 1, 1, 1},
							{0, 0, 0, 0}
					   };

		System.out.println("Row with max 1's is = " + getMaxRow(grid));			   
	}

	public static int getMaxRow(int[][] grid) {
		int ROWS = grid.length;
		int COLS = grid[0].length;

		int row = 0;
		int col = COLS - 1;

		int max_row = row;

		while(row >= 0 && row < ROWS && col >= 0 && col < COLS) {
			if(1 == grid[row][col]) {
				col--;
				max_row = row;
			} else {
				row++;
			}
		}

		return  max_row;
	}
}