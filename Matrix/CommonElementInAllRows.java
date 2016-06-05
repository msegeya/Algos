/**
	Question: Find a common element in all rows of a given row-wise sorted matrix. Given a matrix where every row is sorted in increasing order. Write a function that finds and returns a common element in all rows. If there is no common element, then returns -1.

	Reference: http://www.geeksforgeeks.org/find-common-element-rows-row-wise-sorted-matrix/

	Example: 
		Input: mat[4][5] = { 
								{1, 2, 3, 4, 5},
			                    {2, 4, 5, 8, 10},
			                    {3, 5, 7, 9, 11},
			                    {1, 3, 5, 7, 9},
                  			};
		Output: 5

	Logic: 
		- Start from the last column.
		- Create an array say column. Initialize all the values of column with the last-column index.
		- Get the minimum value from the last column and find to which row it belongs to and say its index as min_row.
		- Push to left of all the column indices of all the rows which are less than min_row index value.
		- Do this until you get the count equal to rows then retunt the common element.
		- If at any row you have reached index 0 without getting the common element then return -1.
*/

import java.util.Arrays;

class CommonElementInAllRows {
	public static void main(String[] args) {
		int[][] matrix = { 
							{1, 2, 3, 4, 5},
		                    {2, 4, 5, 8, 10},
		                    {3, 5, 7, 9, 11},
		                    {1, 3, 5, 7, 9},
                  		 };

        System.out.println(getCommonElement(matrix));
	}

	public static int getCommonElement(int[][] matrix) {
		// To store the last column indices of each row.
		int[] column = new int[matrix.length];
		// To store the minimum element row.
		int min_row = 0;

		// Fill the entire array with the last column index.
		Arrays.fill(column, matrix[0].length - 1);

		while(column[min_row] >= 0) {

			// find minimum in the current last column.
			for(int i = 0; i < matrix.length; i++) {
				if(matrix[i][column[i]] < matrix[min_row][column[min_row]]) {
					min_row = i;
				}
			}

			int count_common = 0;

			// As of now we got which row has the min value.
			// Now we will update the column[] array by comparing it with the min value row element.
			for(int row = 0; row < matrix.length; row++) {
				// If the current cell is greater than the minimum value cell then move left
				// Else increment count.
				if(matrix[row][column[row]] > matrix[min_row][column[min_row]]) {
					// If the column value is 0 then we cannot move further so return -1.
					if(column[row] == 0) {
						return -1;
					}

					// Move left.
					column[row] = -- column[row];
				} else {
					// increment count.
					count_common++;
				}
			}

			// If the count is equal to num of rows then this is the common element.
			if(matrix.length == count_common) {
				return matrix[min_row][column[min_row]];
			}
		} // while

		return -1;
	} // end of method.

}