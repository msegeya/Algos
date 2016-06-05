/**
	Question: Longest Skiing Problem. You can start at any cell in the matrix. You can only move in 4 directions .. TOP/BOTTOM/LEFT/RIGHT depending on the grid boundaries. You can make a move to any particular cell only if the cell value is strictly less than the current cell value. Your taks is to find the longest path and the longest path should give the best Drop(start_cell_value - end_cell_value should be maximum.)

	Reference:  https://www.careercup.com/question?id=19369681
				http://geeks.redmart.com/2015/01/07/skiing-in-singapore-a-coding-diversion/

	Logic:
		- We have already done this .. refer Arrays/NumOfIslands.java
		- For every path we can move in 4 directions and the path which we are moving should have the cell value less than the current cell value.
		- Do DFS of that cell using the above point.
		- At each cell increment the setp count by 1.
		- If the cell is already visited then return the count.
		- Finally return the maximum count.
*/

class LongestSkiing {

	public static int[] ROW_DIR = {-1, 0, 0, 1};
	public static int[] COL_DIR = {0, -1, 1, 0};

	public static int[][] dist;

	public static int ROWS;
	public static int COLS;

	public static void main(String[] args) {
		int[][] mountains = {
								{4, 8, 7, 3}, 
								{2, 5, 9, 3}, 
								{6, 3, 2, 5},
								{4, 4, 1, 6}
							};

		System.out.println("\nMax Length = " + getLonSkiingLen(mountains));
	}

	public static int getLonSkiingLen(int[][] mountains) {
		ROWS = mountains.length;
		COLS = mountains[0].length;

		dist = new int[ROWS][COLS];

		int max = Integer.MIN_VALUE;
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				max = Math.max(DFS(row, col, mountains), max);
			}
		}

		return max;
	}

	public static int DFS(int row, int col, int[][] mountains) {

		System.out.print(mountains[row][col] + " -> ");

		// If the length is already calculated then just return the cell value.
		// It won't go out of range since the caller is sending valid row, col values.
		if(dist[row][col] != 0) {
			return dist[row][col];
		}

		// Else we need to calculate the matrix values.
		int cur_sum = 0;
	
		// UP direction.
		if(row - 1 >= 0 && mountains[row][col] > mountains[row - 1][col]) {
			cur_sum = Math.max(cur_sum, DFS(row - 1, col, mountains));
		}

		// DOWN direction
		if(row + 1 < ROWS && mountains[row][col] > mountains[row + 1][col]) {
			cur_sum = Math.max(cur_sum, DFS(row + 1, col, mountains));
		}

		// LEFT direction.
		if(col - 1 >= 0 && mountains[row][col] > mountains[row][col - 1]) {
			cur_sum = Math.max(cur_sum, DFS(row, col - 1, mountains));
		}

		// RIGHT direction.
		if(col + 1 < COLS && mountains[row][col] > mountains[row][col + 1]) {
			cur_sum = Math.max(cur_sum, DFS(row, col + 1, mountains));
		}

		System.out.println();
		
		dist[row][col] = cur_sum + 1;
		
		return dist[row][col];
	}
}