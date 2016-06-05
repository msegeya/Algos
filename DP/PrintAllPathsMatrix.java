/**
	Question: Imagine a robot sitting on the upper left hand corner of an NxN grid. The robot can only move in two directions: RIGHT and DOWN. How many possible paths are there for the robot?

	Source: http://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
			http://stackoverflow.com/questions/9105699/algorithm-for-finding-all-paths-in-a-nxn-grid

	Logic: 
		- This question is similar to Apple_Matrix_Problem @ AppleMatrixProblem.java
		- There we are doing sum at apples at each cell here we will simpliy put the path until that cell.
		  But this will take O(n^3). Because each cell will be a String and each string will have (1 to n-1) paths in worst case.
		- For each cell check whether the RIGHT or DOWN cell is 
*/

class PrintAllPathsMatrix {
	public static void main(String[] args) {
		char[][] matrix = {
							{'a', 'b', 'c'}, 
							{'d', 'e', 'f'}, 
							{'g', 'h', 'i'}
					      };

		PrintAllPathsMatrix pamObj = new PrintAllPathsMatrix();
		pamObj.printAllPathsInMatrix(matrix);
	}

	void printAllPathsInMatrix(char[][] matrix) {
		int ROWS = matrix.length;
		int COLS = matrix[0].length;

		int ROW_START = 0;
		int COL_START = 0;

		String output = "";

		prepareMatrixAndPrintpaths(matrix, ROW_START, COL_START, ROWS, COLS, output);
	}

	void prepareMatrixAndPrintpaths(char[][] matrix,
											int row, 
												int col, 
													int ROWS, 
														int COLS, 
															String output) {
		
		output = output + " -> " + matrix[row][col];
		
		if(row == ROWS - 1 && col == COLS - 1) {
			System.out.println(output);
			return;
		}
		
		// moving towards downwards
		if(row + 1 < ROWS)
			prepareMatrixAndPrintpaths(matrix, row + 1, col, ROWS, COLS, output);
		
		// moving towards right side
		if(col + 1 < COLS)
			prepareMatrixAndPrintpaths(matrix, row, col + 1, ROWS, COLS, output);
	}
}