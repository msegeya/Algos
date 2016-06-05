/**
	Question: Print a given matrix in spiral form. 

	Reference: http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/

	Example: 
		I/P:	1    2   3   4
		        5    6   7   8
		        9   10  11  12
		        13  14  15  16
		O/P:    1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 

		I/P: 	1   2   3   4  5   6
        		7   8   9  10  11  12
        		13  14  15 16  17  18
        O/P:    1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11		

*/

class PrintMatrixSpiralForm {
	public static void main(String[] args) {
		int[][] grid1 = {
							{1,  2,  3,  4,  5,  6},
        					{7,  8,  9,  10, 11, 12},
        					{13, 14, 15, 16, 17, 18}
        				};
        MatrixUtil.print(grid1, null);
        printSpiral(grid1);


        int[][] grid2 = {
        					{1, 2, 3, 4},
        					{5, 6, 7, 8},
        					{9, 10, 11, 12},
        					{13, 14, 15, 16}
        				};
		MatrixUtil.print(grid2, null);
        printSpiral(grid2);
	}

	public static void printSpiral(int[][] grid) {
		int last_row = grid.length;
		int last_col = grid[0].length;

		int starting_row = 0;
		int starting_col = 0;

		// Iterator
		int i = 0;

		while(starting_row < last_row && starting_col < last_col) {

			// Step-1: Print first row.
			for(i = starting_col; i < last_col; i++) {
				System.out.print(grid[starting_row][i] + " ");
			}
			starting_row++;

			// Step-2: Print last column
			for(i = starting_row; i < last_row; i++) {
				// System.out.println(starting_row + " " + (last_col - 1));
				System.out.print(grid[i][last_col - 1] + " ");
			}
			last_col--;

			// Step-3: Print the last row from the remaining rows.
			if(starting_row < last_row) {
				 for(i = last_col - 1; i >= starting_col; i--) {
				 	System.out.print(grid[last_row - 1][i] + " ");
				 }
				 last_row--;
			}

			// Step-4: Print the first column of the remaining columns
			if(starting_col < last_col) {
				for(i = last_row - 1; i >= starting_row; i--) {
					System.out.print(grid[i][starting_col] + " ");
				}
				starting_col++;
			}
		}

		System.out.println();
	}

}