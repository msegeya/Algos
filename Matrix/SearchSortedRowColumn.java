/**
	Question: Search in a row wise and column wise sorted matrix. Given an n x n matrix, where every row and column is sorted in increasing order. Given a number x, how to decide whether this x is in the matrix. The designed algorithm should have linear time complexity.

	Reference: http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/

	Logic: 
		- Since the matrix is sorted we need to traverse the matrix by comparing cell values.
		- Start from top-right cell. 
		- Three cases, (let the cell value be C and the search element be X)
			1) If C > X then move to left of the same row.
			2) If C < X then move down of the same column.
			3) If C == X then return true
			4) Else return false
*/

class SearchSortedRowColumn {
	public static void main(String[] args) {
		int[][] grid = { 
							{10, 20, 30, 40},
		                	{15, 25, 35, 45},
		                    {27, 29, 37, 48},
		                    {32, 33, 39, 50},
	                    };

	    MatrixUtil.print(grid, null);

	    int key1 = 20;
	    System.out.println("Search for key = " + key1 + " is " + search(grid, key1));

	    int key2 = 31;
	    System.out.println("Search for key = " + key2 + " is " + search(grid, key2));
	}

	public static boolean search(int[][] grid, int key) {
		int ROWS = grid.length;
	    int COLS = grid[0].length;

	    // start from the top-right most cell.
	    int row = 0;
	    int col = COLS - 1;
	    while(row < ROWS && col >= 0) {
	    	int cell_element = grid[row][col];
	    	if(cell_element > key) {
	    		col--;
	    	} else if(cell_element < key) {
	    		row++;
	    	} else {
	    		return true;
	    	}
	    }

	    return false;
	}
}