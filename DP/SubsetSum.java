/**
	Question: Given sum and given a set of numbers "S". Check whether there is a subset in given set S whose sum of numbers will result in given sum.

	Source: https://www.youtube.com/watch?v=s6FhG--P7z0
			http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/		
	
	Example: 
			Given set S = {3, 34, 4, 12, 5, 2} and SUM = 9 
			==> Sum of (4, 5) will give us 9. No other solution exists.
			
			S = {2, 3, 7, 8, 10}; sum = 11 ==> Sum of (3, 8) = 11. 

	Logic: 
		- Look at the video for Logic.
		- Look at the code comments below.
*/

import java.util.*;

class SubsetSum {
	public static void main(String[] args) {
		SubsetSum ssObj = new SubsetSum();

		int[] set = {2, 3, 7, 8, 10}; int sum = 11;
		// int[] set = {3, 34, 4, 12, 5, 2}; int sum = 9;

		ssObj.printSubSet(set, sum);
	}

	void printSubSet(int[] set, 
							int sum) {
		List<Integer> setList = getSubsetsForSum(set, sum);
		
		System.out.print("Set = {");
		for(int i = 0; i < setList.size(); i++) {
			System.out.print(setList.get(i) + ", ");
		}
		System.out.print("}");
	}

	List<Integer> getSubsetsForSum(int[] set, 
										int sum) {
		boolean[][] matrix = prepareSetMatrixForSum(set, sum);
		
		List<Integer> itemsList = getSubSetElements(matrix, set);
		return itemsList;
	}
	
	List<Integer> getSubSetElements(boolean[][] matrix, 
										int[] set) {
		int row = matrix.length - 1;
		int col = matrix[0].length - 1;
		List<Integer> list = new ArrayList<Integer>();
		
		while(row != 0) {
			boolean value = matrix[row][col];
			// If we got the value from above cell.
			if(value == matrix[row - 1][col]) {
				row = row - 1;
			} else {
				// If we got the value from above's rows cell other then above cell 
				// then we need to add the row index value from set.
				list.add(set[row]);
				row = row - 1;
				// goto the column from where we came from.
				col = (col > set[row] ? col - set[row] : set[row] - col) - 1;
			}
		}
		
		return list;
	}

	/**
		I think we need to sort the set before starting the processing.
	*/
	boolean[][] prepareSetMatrixForSum(int[] set, 
											int sum) {
		// rows are the subset elements.
		int rowCount = set.length;

		// columns are for sum i,. [0 .. sum]. Plus 1 needed because we need to start from 0 to sum(including)
		int colCount = sum + 1;

		boolean[][] matrix = new boolean[rowCount][colCount];

		// we will explicitly fill the first row usign the first element in the set.
		// such that we can use the first row values for remaining elements in the set.
		// If the subset value matches the given sum i,e. the column value then return true else false.
		for(int col = 0; col < colCount; col++) {
			if(col == set[0]) {
				matrix[0][col] = true;
			}
		}		

		for(int row = 0; row < rowCount; row++) {
			matrix[row][0] = true;
		}

		for(int row = 1; row < rowCount; row++) {
			for(int col = 1; col < colCount; col++) {
				if(col >= set[row]) {

					// check if previous set elements can form the needed sum or not. If so then there is no need to do the below steps.
					// See it like this, if the element(s) that are already present in the set can form given sum then there is no point in calcualting again.
					if(false == matrix[row - 1][col]) {
						// Using current element can be used to form the needed sum.
						// We don't need this since this is greater than the needed sum. So this will be true anyways. 
						// So the result totally depends on the remaining sum status.
						//boolean curr_element_status = true;

						// for remaining element we need to check whether it can be formed or not.
						int remain_sum = (set[row] >= col ? (set[row] - col) : (col - set[row]));
						boolean remain_sum_status = matrix[row - 1][remain_sum];

						// Finally if both the above statements are true then return true.
						matrix[row][col] = remain_sum_status;	
					} else {
						matrix[row][col] = true;
					}
				} else {
					matrix[row][col] = matrix[row - 1][col];
				}
			}
		}

		DPUtil.print2DMatrix(matrix);
		return matrix;
	}
}