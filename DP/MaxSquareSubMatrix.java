/**
	Question: Maximum size square sub-matrix with all 1s.

	Source: https://www.youtube.com/watch?v=_Lf1looyJMU
			http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
	
	Logic: 
		- First place 0th row and 0th column with zeros.
		- If matrix[i, j] = 0 then place 0 in result matrix.
		- If the matrix[i, j] = 1, then result[i, j] = Min(matrix[i - 1, j], matrix[i - 1, j - 1], matrix[i, j - 1])
*/

import java.util.*;

class MaxSquareSubMatrix {
	public static void main(String[] args) {
		int[][] matrix = { 
						   {0, 1, 1, 0, 1}, 
		                   {1, 1, 0, 1, 0}, 
		                   {0, 1, 1, 1, 0},
		                   {1, 1, 1, 1, 0},
		                   {1, 1, 1, 1, 1},
		                   {0, 0, 0, 0, 0}
		                 };

		MaxSquareSubMatrix mssmObj = new MaxSquareSubMatrix();
		mssmObj.printMaxSizeSubMtrxOfOnes(matrix);                
	}

	void printMaxSizeSubMtrxOfOnes(int[][] matrix) {
		int max_subMatrix_size = getMaxSizeSubMtrxOfOnes(matrix);
		System.out.println("Max Sum Matrix size: " + max_subMatrix_size);
	}

	int getMaxSizeSubMtrxOfOnes(int[][] matrix) {
		Map<String, Object> map = prepareMaxSubMatrix(matrix);

		int[][] resultMatrix = (int[][]) map.get("matrix");
		int row_max = (Integer) map.get("row_max");
		int col_max = (Integer) map.get("col_max");

		System.out.println("Max Row = " + row_max + " and Max Col = " + col_max);
		return resultMatrix[row_max][col_max];
	}

	Map<String, Object> prepareMaxSubMatrix(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		int[][] resultMatrix = new int[rowCount][colCount];

		int max_row = -1;
		int max_col = -1;

		Map<String, Object> map = new HashMap<String, Object>();
		int max_count= 0;
		
		// Copy 0th row data of the matrix to resultMatrix.
		for(int col = 0; col < colCount; col++) {
			resultMatrix[0][col] = matrix[0][col];
		}

		// Copy 0th column data of the matrix to resultMatrix.
		for(int row = 0; row < rowCount; row++) {
			resultMatrix[row][0] = matrix[row][0];
		}

		for(int row = 1; row < rowCount; row++) {
			for(int col = 1; col <colCount; col++) {
				// If the cell is having one then we need to check the around the same cell in the result matrix.
				if(1 == matrix[row][col]) {
					// We check the cell by checking cells left, top, top_left_diag values and increment by 1.
					int cur_result = Math.min(Math.min(resultMatrix[row][col- 1], resultMatrix[row - 1][col - 1]), resultMatrix[ row - 1][col]);
					resultMatrix[row][col] = cur_result + 1;
					
					if(resultMatrix[row][col] > max_count) {
						max_count = resultMatrix[row][col];
						max_row = row;
						max_col = col;
					}
				} else {
					resultMatrix[row][col] = 0;
				}
			}
		}

		System.out.println("Result Matrix");
		for(int row = 0; row < rowCount; row++) {
			for(int col = 0; col < colCount; col++) {
				System.out.print(resultMatrix[row][col] + "\t");
			}
			System.out.println();
		}
		
		map.put("row_max", max_row);
		map.put("col_max", max_col);
		map.put("matrix", resultMatrix);
		return map;
	}
}