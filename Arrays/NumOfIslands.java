/**
	Question: Find the number of islands. Given a boolean 2D matrix, find the number of islands. The 2D matrix has 1's and 0's where "1 is island" and "0 is water".

	A little background: A connected component of an undirected graph is a subgraph in which every two vertices are connected to each other by a path(s), and which is connected to no other vertices outside the subgraph.
	==> It means, a cell can move in 8 directions (up, down, right, left, up-left, up-right, down-left, down-right).
		In this case a cell can move in a direction which has "1" and such that that cell should not be visited before.

	So in simple a connected component is, a DFS path where the last node cannot be in any direction because either all the 1's around ir visited or it is surrounded by all 0's. Each DFS call that will give us a path with vertices and edges this is called as 1 componenet.

	Reference: http://www.geeksforgeeks.org/find-number-of-islands/

	Logic: 
		- For each 1 in the grid which is not visited,
			Mark it visited and explore all its adjacent nodes using DFS.
		- In DFS mark explore every adjacent node that is not visited.
		- For every DFS call increase the count.
*/	


class NumOfIslands {

	// From a cell we can move at max in 8 directions.
	// {up, down, right, left, up-left, up-right, down-left, down-right}
	private static int[] Row_Dir = {-1, -1, -1,  0, 0,  1, 1, 1};
	private static int[] Col_Dir = {-1,  0,  1, -1, 1, -1, 0, 1};

	private static int ROWS;
	private static int COLS;

	public static void main(String[] args) {
		int[][] a = {
						{1, 1, 1, 1, 0},
						{1, 1, 0, 1, 0},
						{1, 1, 0, 0, 0},
						{0, 0, 0, 0, 0}
					}; // 1

		int result = getNumOfIslands(a);
		System.out.println("Number of Islands = " + result);

		int[][] b = {
						{1, 1, 0, 0, 0},
						{0, 1, 0, 0, 1},
						{1, 0, 0, 1, 1},
						{0, 0, 0, 0, 0},
						{1, 0, 1, 0, 1}
					}; // 5

		result = getNumOfIslands(b);
		System.out.println("Number of Islands = " + result);
		
	}

	public static int getNumOfIslands(int[][] grid) {
		if(null == grid || 0 == grid.length) {
			return -1;
		}

		ROWS = grid.length;
		COLS = grid[0].length;

		// To keep track of all the cells whether visited or not.
		boolean[][] visited = new boolean[ROWS][COLS];

		int count = 0;
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {

				// If cell is 0 or the cell is already visited then just continue.
				// else do DFS for this cell. 
				// Increment count for each DFS call.
				if(grid[row][col] == 0 || visited[row][col]) {
					continue;
				} else {
					DFS(grid, row, col, visited);
					++count;
				}
			}
		}

		return count;
	}

	// Explore all the adjacent nodes. This whole stack leads to 1 connected componenet.
	public static void DFS(int[][] grid, int row, int col, boolean[][] visited) {
		visited[row][col] = true;

		// Any cell can traverse in 8 directions. So first validate the direction and then do DFS on it.
		for(int dir = 0; dir < Row_Dir.length; dir++) {
			if(isSafe(grid, row + Row_Dir[dir], col + Col_Dir[dir], visited)) {
				DFS(grid, row + Row_Dir[dir], col + Col_Dir[dir], visited);
			}
		}
	}

	// To cehck whether the move is valid or not.
	public static boolean isSafe(int[][] grid, int check_row, int check_col, boolean[][] visited) {
		if ( 
				(check_row >= 0 && check_row < ROWS)
							&&
				(check_col >= 0 && check_col < COLS)
							&&
				(grid[check_row][check_col] == 1)
							&&
				(visited[check_row][check_col] == false)
			)	{
			return true;
		} else {
			return false;
		}
	}
}