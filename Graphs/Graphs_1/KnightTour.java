/**
	Question: Knight Tour problem

	What is BackTracking?
	Backtracking is an algorithmic paradigm that tries different solutions until finds a solution that "works". Problems which are typically solved using backtracking technique have following property in common. These problems can only be solved by trying every possible configuration and each configuration is tried only once. A Naive solution for these problems is to try all configurations and output a configuration that follows given problem constraints. Backtracking works in incremental way and is an optimization over the Naive solution where all possible configurations are generated and tried.

	Reference: 	https://www.youtube.com/watch?v=ab_dY3dZFHM
				http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
	
	NOTE: We need to visit all the cells using the knight.

	Logic:
		- If all the cells are visited then print them.
		- Else,
			a) Add a move to the solution and start recursively if this move leads to a solution or not.
			b) If the move does not lead to a solution then return false. If so then remove the move from solution and try with the next move.
			c) If none of the move returns the answer then return false.
	
	Implementation:
		- Please got through NQueenPro.java before proceeding furthur. Same backtracking logic is used here.
		- Start a cell say (0, 0) and check all possible solutions.
		- Keep this (0, 0) move fixed and find all other solutions. If there is a solution then print else remove (0, 0) solution and move to next cell that is   (0, 1) or (1, 0) and start the process again.
		- If you add any cell and if the solution generated does not work then come you need to make it back to default value that is -1.
*/

class KnightTour {
	private int[][] grid;
	private int N;

	public static void main(String[] args) {
		KnightTour ktObj = new KnightTour();
		ktObj.initialize();

		ktObj.solKnightPro();
	}

	public void initialize() {
		N = 8;
		grid = new int[N][N];

		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				grid[r][c] = -1;
			}
		}
	}

	public void solKnightPro() {
		/* xMove[] and yMove[] define next move of Knight. 
		   xMove[] is for next value of x coordinate
           yMove[] is for next value of y coordinate 
			
		   All these moves are L shape moves. Take the combination of xMove and yMove at same index positions. 
		   You will understand the moves are all L shaped.
        */
        int xMove[] = {2, 1, -1, -2, -2, -1,  1, 2};
        int yMove[] = {1, 2,  2,  1, -1, -2, -2, -1};

        int START_ROW = 0, START_COL = 0;
        int moveCount = 0;

        grid[START_ROW][START_COL] = moveCount;
        boolean output = backtrackUtil(START_ROW, START_COL, moveCount + 1, grid, xMove, yMove);
        
        if(output) {
        	System.out.println("Knight Travel output is: ");
        	for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					System.out.print(grid[r][c] + "\t");
				}
				System.out.println();
			}
        } else {
        	System.out.println("Solution is not possible.");
        }
	}

	public boolean backtrackUtil(int row, 
									int col, 
										int moveCount, 
											int[][] grid, 
												int[] xMove, 
													int[] yMove) {

		if(moveCount == N * N) {
			return true;
		}

		// current move is at (row, col). 
		for(int k = 0; k < N; k++) {
			int next_row = row + xMove[k];
			int next_col = col + yMove[k];

			if(isSafe(next_row, next_col)) {
				grid[next_row][next_col] = moveCount;

				boolean result = backtrackUtil(next_row, next_col, moveCount + 1, grid, xMove, yMove);
				if(result) {
					return true;
				}

				grid[next_row][next_col] = -1; 
			}
		}
		return false;
	}

	public boolean isSafe(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < N && grid[r][c] == -1);
	}
}