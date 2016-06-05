/**
	Question: There is a 2d matrix and in each point there are some gold coins. Then starting from the bottom-left point you have to collect the maximum number of points. The constraint is that you can only move in right and up direction.

	NOTE: We will change the requirements here. Start from top-left and move to bottom-right and at every step we will move either down or right.

	Reference: https://www.careercup.com/question?id=10071580

	Logic: (Using Dynamic Programming.)
		- Let us say the matrix is A[][], where A[i, j] = # of coins at [i, j] position.
		- Refer DP/AppleMatrixProblem.java for more details.
*/

class CollectMaxPointsInGrid {
	public static void main(String[] args) {
		int[][] A = {
						 {3, 6, 8, 2},
	                     {5, 2, 4, 3},
	                     {1, 1, 20, 10},
	                     {1, 1, 20, 10},
	                     {1, 1, 20, 10}
					}; // 91
		System.out.println(getCoins(A));
	
		int[][] B = {
						{1, 2, 3}, 
						{4, 5, 6}, 
						{7, 8, 9}
					}; // 29

		System.out.println(getCoins(B));					
	}

	public static int getCoins(int[][] A) {
		int ROWS = A.length;
		int COLS = A[0].length;

		int[][] coins = new int[ROWS][COLS];

		// Initialize coins[0][0] with the first cell value of the matrix.
		coins[0][0] = A[0][0];

		// Initialize first row and first column.
		// Assuming both ROWS and COLS are equal.
		for(int i = 1; i < COLS; i++) {
			// first row.
			coins[0][i] = A[0][i] + coins[0][i - 1];
		}

		for(int i = 1; i < ROWS; i++) {
			// first column
			coins[i][0] = A[i][0] + coins[i - 1][0];
		}

		// Now for each row we do the following.
		int row = 0;
		int col = 0;
		for(row = 1; row < ROWS; row++) {
			for(col = 1; col < COLS; col++) {
				coins[row][col] = A[row][col] + Math.max(coins[row][col - 1], coins[row - 1][col]);
			}
		}

		return coins[row - 1][col - 1];
	}
}