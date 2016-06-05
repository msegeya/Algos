/**
	Question: N Queen's problem.

	Explanation: Chessboard queens can attack horizontally, vertically, and diagonally. The N-queens problem asks, How can N queens be placed on an NxN chessboard so that no two of them attack each other?
	==> Solution is, No two queens are on the same row, column, or diagonal.

	What is BackTracking?
	Backtracking is an algorithmic paradigm that tries different solutions until finds a solution that "works". Problems which are typically solved using backtracking technique have following property in common. These problems can only be solved by trying every possible configuration and each configuration is tried only once. A Naive solution for these problems is to try all configurations and output a configuration that follows given problem constraints. Backtracking works in incremental way and is an optimization over the Naive solution where all possible configurations are generated and tried.

	Reference: https://www.youtube.com/watch?v=kX5frmc6B7c
			   http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/	

	NOTE: Backtracking works as, take a cell try to find solution for other cells. If solution is there then print the solution else move to next cell and find solution again. Do this until you find the solution.
	
	Logic: 
		- Watch the wonderful video to know about N-Queen's. Prefer the logic in GeeksForGeeks for easy implementation.
		- We will start putting Queens column wise.
		- Start from column 0 with row as 0. Check whether there are any Queens in that to the left of the column, Upper-Left-Diagonal, Lower-Left-Diagonal. 
		  => Why not right?
		  	 Since we are coming from left that is from column-0. We need to check only columns, diagonals before this column. There is nothing on the right of this column.
		- Even though if a cell is safe such that we will enter true in that place. But beacause of making this cell to true if we are not able to fill next column then we will revert back this safe cell to false.  	 
		- Also see code comments.  	 
*/

class NQueenPro {

	private boolean[][] board;
	private int N;

	public static void main(String[] args) {
		NQueenPro nqpObj = new NQueenPro();
		nqpObj.initialize();

		nqpObj.performNQueens();		
	}

	public void initialize() {
		N = 4;
		board = new boolean[N][N];
	}

	public void performNQueens() {
		int startCol = 0;
		backtrack(board, 0);

		print(board);
	}

	
	public boolean backtrack(boolean[][] board, int col) {

		if(col == N) {
			return true;
		}

		// check all rows for each column.
		for(int r = 0; r < N; r++) {
			if(isSafe(r, col, board)) {
				board[r][col] = true;

				boolean doRecur = backtrack(board, col + 1);
				if(doRecur) {
					return true;
				} 

				// Why to do this?
				// For each cell we need to check whether it is true or not.
				// Consider the case (2, 1), this cell is actually safe but because of filling this cell entire column 2 that is (0, 2), (1, 2), (2, 2) and (3, 2) cannot be filled. So even though it is safe we will not fill this cells value as true.
				board[r][col] = false;	
			}
		}

		return false;
	}

	/*
		NOTE: We are coming from left .. that is from column-0 to column-(n-1). There will be no queens on the right of the cell.
		So we need to check only 
			1) Left of the column in a row
			2) Left diagonal of the cell.
			3) Right diagonal of the cell.
	*/
	public boolean isSafe(int row, int col, boolean[][] board) {
		int i = 0, j = 0;
		
		// check left in same row.
		for(j = 0; j < col; j++) {
			if(board[row][j]) {
				return false;
			}
		}

		// check upper diagonal on left side.
		i = row; j = col;
		for( ; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j]) {
				return false;
			}
		}

		// check lower diagonal on the right side.
		i = row; j = col;
		for( ; i < N && j >= 0; i++, j--) {
			if(board[i][j]) {
				return false;
			}
		}

		return true;
	}

	public void print(boolean[][] board) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print((board[i][j] == true ? "True" : "F") + "\t");
			}
			System.out.println();
		}
	}
}