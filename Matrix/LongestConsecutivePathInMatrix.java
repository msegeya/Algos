/**
	Question: Find length of the longest consecutive path from a given starting character. Given a matrix of characters. Find length of the longest path from a given character, such that all characters in the path are consecutive to each other, i.e., every character in path is next to previous in alphabetical order. It is allowed to move in all 8 directions from a cell.

	Reference: http://www.geeksforgeeks.org/find-length-of-the-longest-consecutive-path-in-a-character-matrix/

	Example: 
				a 	c 	d 
				h 	b 	e 
				i 	g 	f

			and start = e.

		Output: e f g h i

	Explanation: Start from the given character. For each cell we have max of eight directions where it can move. Get the cell that is has character which is appears next in alphabetical order. If you have more than one option then choose the one that is close. Ex: In case of cell 'e', we have 'g' and 'f'. But 'f' is close to the character 'e', hence move in taht direction.

	Logic:(Using DFS and DP)
		- We will solve it just like the way we have solved Arrays/NumOfIslands.java. But instead of just using DFS we will also use DP for storing the previously solved sub problems.
		- Each cell can move in 8 direction at max. GO into each diection and do the following.
			1) For each of the adjacent cell check whether the difference between adjcaen cell and current cell is 1. If so then the adjacent is next to current cell so go in that directiona and add 1.
			2) Add the count to the DP after finishing all the adjacent cells.
		- Do this for all the adjacent cells and return the max path.
		- See code comments for more details.
*/

class LongestConsecutivePathInMatrix {

	private static int[] XDir = {-1, -1, -1,  0, 0,  1, 1, 1};
	private static int[] YDir = {-1,  0,  1, -1, 1, -1, 0, 1};

	private static int[][] DP;

	public static void main(String[] args) {
		char[][] grid = {
							{'a','c','d'},
							{'h','b','e'}, 
							{'i','g','f'}	
						};

		char start = 'e';

		// Dynamic Programming is used to store the previous solved sub problems.
		DP = new int[grid.length][grid[0].length];
		DP = MatrixUtil.fillWithValue(DP, -1);
		
		System.out.println(getLonPath(grid, start));						
	}

	public static int getLonPath(char[][] grid, char key) {
		// pathLen should be 1. But we are adding it during the call so keep it as 0.
		int pathLen = 0;

		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == key) {
					for(int k = 0; k < 8; k++) {
						// Add the current cell length so it is +1.
						pathLen = Math.max(pathLen, 1 + getLongPathUtil(grid, i + XDir[k], j + YDir[k], key));
					}
				}
			}
		}

		return pathLen;
	}

	public static int getLongPathUtil(char[][] grid, int i, int j, char prev) {

		// Check whether the index range is within the gird or not.
		// Check whether the adjacent cell is really adjacent in the alphabetical order.
		if(!isSafe(i, j, grid) || !isAdjacent(prev, grid[i][j])) {
			return 0;
		}

		// If the DP is -1 then still this cell is not explored.
		if(DP[i][j] != -1) {
			return DP[i][j];
		}

		// We will save the length of the path after the end of the DFS for this path.
		int subPathLen = 0;
		for(int k = 0; k < 8; k++) {
			subPathLen = Math.max(subPathLen, 1 + getLongPathUtil(grid, i + XDir[k], j + YDir[k], grid[i][j]));
		}

		DP[i][j] = subPathLen;

		return subPathLen;
	}

	public static boolean isSafe(int i, int j, char[][] grid) {
		if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
			return true;
		} 

		return false;
	}

	public static boolean isAdjacent(char prev, char curr) {
		return (curr - prev) == 1;
	}
}