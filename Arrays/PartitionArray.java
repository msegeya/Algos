/**
	Question: Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.

	Reference:  http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/

	Example: {1, 5, 11, 5} // true. {1, 5, 5} and {11}
			 {1, 5, 3} // false. No equal sets possible.

	Logic: (Using Dynamic Programming)
		- Create a 2D array of size ((sum/2) * (n + 1)) where sum = array[0] + .. + array[n - 1]
		- Every cell should have the following property,
			part[i][j] = true, if a subset of {array[0], array[1] .. array[j - 1]} has sum equal to i
					   = false, otherwise
*/

class PartitionArray {
	public static void main(String[] args) {
		// int[] array = {3, 1, 1, 2, 2, 1}; // true
		// int[] array = {1, 5, 3}; // false
		int[] array = {1, 5, 11, 5};

		// Step-1: Calculate sum
		int sum = 0;
		for(int s : array) {
			sum += s;
		}

		// Step-2: Check whether sum is even or odd. If odd return false.
		if(sum % 2 != 0) {
			System.out.println("Partitioning the array is not possible.");
			return;
		} 

		// Step-3: Take a boolean matrix. 
		int ROWS = sum / 2 + 1;
		int COLS = array.length + 1;
		boolean[][] part = new boolean[ROWS][COLS];

		// Step-4: Initialize first row with true.
		for(int col = 0; col < COLS; col++) {
			part[0][col] = true;
		}

		// Step-5: Initialize the left most column with false except part[0][0]
		for(int row = 1; row < ROWS; row++) {
			part[row][0] = false;
		}

		// Step-6: Fill the table
		for(int row = 1; row < ROWS; row++) {
			for(int col = 1; col < COLS; col++) {
				
				part[row][col] = part[row][col - 1];

				if(row >= array[col - 1]) {
					part[row][col] = part[row][col] || part[row - array[col - 1]][col - 1];
				} 
			}
		}

		System.out.println(part[ROWS - 1][COLS - 1]);
	}
}