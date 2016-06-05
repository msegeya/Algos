/** 
	Question: Maximum Sum Rectangular Submatrix in Matrix dynamic programming/2D kadane

	Example: Given matrix as below, find the rectangular sub-matrix where we the sum of all cells in that rectangle are having the maximum sum.
				0	1	2	3	4
			0	2	1  -3  -4	5
			1	0	6	3	4	1
			2	2  -2  -1	4  -5
			3  -3	3	1	0	3

	Source: https://www.youtube.com/watch?v=yCQN096CwWM
			http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/

	Logic: 
		- Take two variable's L, R where L, R will be pointing to 0th column. Always L <= R.
		- For each R column, copy all the column elements into an array and apply Kadane's algorithm and get max sum.
		- For each sum get the max_left(L position), max_right (R position)
		- max_up (Within the column which we gave for Kadane's algorithm get the start index and say it as "MAX_DOWN" and get the end index and say it as "MAX_UP")
		- The sum which we got from Kadane's algorithm will be stored as max_sum.
		- Now move R = R + 1 where R < COL_COUNT.
		- Do the same Kadane's procedure and calculate the result. If result is greater than max_sum then update max_sum and all the indices.
		- After R reaching end of the COL_COUNT, now reset L and R at L + 1 and do the same procedure again.
		- Finally we will have the index positions of max_left, max_right, max_up, max_down, max_sum.
		- Print the rectangular matrix using max_left, max_right, max_up, max_down and return max_sum.
*/


import java.util.*;
class MaxSumRectangleSubMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
					{2, 1, -3, -4, 5},
					{0, 6, 3, 4, 1},
					{2, -2, -1, 4, -5},
					{-3, 3, 1, 0, 3}
		  		  };

		 MaxSumRectangleSubMatrix msrmObj = new MaxSumRectangleSubMatrix();
		 msrmObj.printMaxRectSum(matrix);
	}

	void printMaxRectSum(int[][] matrix) {
		int max_sum = getMaxRectSum(matrix);
		System.out.println("Max SUM " + max_sum);
	}

	/*
		Say we have columns from [0 .. 4].

		- From LEFT to right do the following. LEFT, RIGHT start from 0 and RIGHT moves all the way to right end and then LEFT starts at 1 and RIGHT start at 1 and again RIGHT moves all the way from LEFT TO RIGHT.  
			Take each column. Say LEFT, RIGHT pointing to Column 0.
			If LEFT == RIGHT,
			  => Then take elements of RIGHT column and put them in an array (TEMP_ARRAY) and pass it to kadane's algorithm
			If LEFT != RIGHT,
			  => Then add the current RIGHT column elements to already present elements in the TEMP_ARRAY.

		- Using Kadane's algorithm, if the passed array sum is greater than the previous sum then make this sum as max_sum and initialize the following items.
				max_left = LEFT;
				max_right = RIGHT;
				max_up = ; // start index of the max_sum that we got from kadane's algorithm.
				max_down = ; // end index of the max_sum that we got from kadane's algorithm.

		- How to print them?
			We know where the, 
							main_row (max_left) and the sub_row (max_up) starts.
							main_col (max_right) and the sub_col (max_down) starts.
			Using these traverse and print the matrix elements.	
	*/
	int getMaxRectSum(int[][] matrix) {
		int ROWS = matrix.length;
		int COLS = matrix[0].length;

 		// To pass to Kadane's method
		int[] inputArray = null;

		int max_sum = 0;
		int max_up = -1;
		int max_down = -1;
		int max_left = -1;
		int max_right = -1;

		// start from the first column.
		for(int LEFT = 0; LEFT < COLS; LEFT++) {
			// Initialize 
			inputArray = new int[ROWS];
			for(int RIGHT = LEFT; RIGHT < COLS; RIGHT++) {
				for(int row = 0; row < ROWS; row++) {
					if(RIGHT != LEFT) {
						inputArray[row] = inputArray[row] + matrix[row][RIGHT];
					} else {
						inputArray[row] = matrix[row][RIGHT];
					}
				}

				Map<String, Integer> map = kadanesMethod(inputArray);
				int cur_sum = map.get("cur_sum");

				if(cur_sum > max_sum) {
					max_sum = cur_sum;
					max_left = LEFT;
					max_right = RIGHT;
					max_up = map.get("START_INDEX");
					max_down = map.get("END_INDEX");
				}
			} // RIGHT loop
		} // LEFT loop

		printOutputMatrix(matrix, max_left, max_right, max_up, max_down);

		return max_sum;
	}

	
	Map<String, Integer> kadanesMethod(int[] array) {
		int max_end_here = 0;
		int max_so_far = 0;

		int start_index = 0;
		int end_index = 0;

		for(int i = 0; i < array.length; i++) {
			max_end_here += array[i];

			if(max_end_here < 0) {
				max_end_here = 0;

				start_index = i + 1;
			}

			if(max_end_here > max_so_far) {
				max_so_far = max_end_here;

				end_index = i;
			}
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("cur_sum", max_so_far);
		map.put("START_INDEX", start_index);
		map.put("END_INDEX", end_index);

		return map;
	}

	void printOutputMatrix(int[][] matrix,
								int max_left, 
									int max_right,
										int max_up,
											int max_down) {
		for(int row = max_up; row <= max_down; row++) {
			for(int col = max_left; col <= max_right; col++) {
				System.out.print(matrix[row][col] + "\t");
			}
			System.out.println();
		}
	}

}