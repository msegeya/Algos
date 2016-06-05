/**
	Question: Convert a string to another string using only 3 operations (Insert, Delete, Replace)
			  What are the minimum operations required to do that.

	Source: https://www.youtube.com/watch?v=We3YDTzNXEk

	Example: Convert "ABCDEF" to "AZCED" using only INSERT, DELETE, REPLACE.

	Logic: 
		- Please see the above video for logic.
		- Create a matrix with string lengths plus one.
		- See below methods for preparing and printing the number of operations.
*/

import java.util.*;

class EditDistance {

	private static String INSERT = "INSERT";
	private static String REPLACE = "REPLACE";
	private static String DELETE = "DELETE";

	public static void main(String[] args) {
		EditDistance edObj = new EditDistance();
		
		String srcStr = "ABCDEF"; String desStr = "AZCED"; // 3 operations
		// String srcStr = "SATURDAY"; String desStr = "SUNDAY"; // 3 operations

		edObj.printNumOfOperations(srcStr, desStr);
	}

	void printNumOfOperations(String srcStr, 
									String desStr) {
		int numOfOps = getEditDistOpers(srcStr, desStr);
		System.out.println("# of oper's req to convert from source " + srcStr 
									+ " to destination " + desStr + " is " + numOfOps);
	}

	int getEditDistOpers(String srcStr, 
								String desStr) {
		int[][] editDistMtrx = prepareEditDistMatrx(srcStr, desStr);
		int opersCount = editDistMtrx[desStr.length()][srcStr.length()];

		Map<String, Integer> opersCountMap = getOperationsByType(editDistMtrx, opersCount, srcStr, desStr);
		System.out.println("# of Insert Operations: " + opersCountMap.get(EditDistance.INSERT));
		System.out.println("# of Delete Operations: " + opersCountMap.get(EditDistance.DELETE));
		System.out.println("# of Replace Operations: " + opersCountMap.get(EditDistance.REPLACE));

		return opersCount;
	}

	/**
		If moving,
				diagonally and they are same 		==> no_operation_needed.
				diagonally and they are NOT same  	==> Replace
				top 	   							==> Insert
				left 	   							==> Delete

		If the char at row and col are same then we need to move diagonally to top left.
		If the char at row and col are not same and we got the value from diagonal of "TOP LEFT" then operation is "REPLACE"
		If the char at row and col are not same and we got it from "LEFT" then the operation is "DELETE" 
		If the char at row and col are not same and we got it from "TOP" then the operation is "TOP"
	*/
	Map<String, Integer> getOperationsByType(int[][] editDistMtrx,
													int opersCount, 
														String srcStr,
															String desStr) {
		int row = desStr.length();
		int col = srcStr.length();

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(EditDistance.INSERT, 0);
		map.put(EditDistance.DELETE, 0);
		map.put(EditDistance.REPLACE, 0);

		while(opersCount > 0) {
			// If same then we need to move diagonally up.
			if(desStr.charAt(row - 1) == srcStr.charAt(col - 1)) {
				row = row - 1;
				col = col - 1;
			} else if(desStr.charAt(row - 1) != srcStr.charAt(col - 1)) {
				// if chars are not equal and if the value is from diagonal	then operations is REPLACE
				if(opersCount == editDistMtrx[row - 1][col - 1] + 1) { 
					
					int replaceCount = map.get(EditDistance.REPLACE);
					replaceCount++;
					map.put(EditDistance.REPLACE, replaceCount);

					row = row - 1;
					col = col - 1;

				} else if(opersCount == editDistMtrx[row - 1][col] + 1) { // top then operation is INSERT

					int insertCount = map.get(EditDistance.INSERT);
					insertCount++;
					map.put(EditDistance.INSERT, insertCount);

					row = row - 1;
				} else { // operation is DELETE
					int deleteCount = map.get(EditDistance.DELETE);
					deleteCount++;
					map.put(EditDistance.DELETE, deleteCount);

					col = col - 1;
				}
				opersCount--;
			}
		}

		return map;
	}


	/**
		Initialize the 0th row and 0th column with 0, 1, 2 ... 

		If row and column index character are same then there is no need of any edit operations. So we will get the minimum from adjacent cells. That is the element present at the top_left_diagonal.
		
		If row and column index character are NOT same then we will get the minimum of top_left_diagonal or left or top and plus 1 since we need to do one more edit operation. ==> Minimum(top_left_diag, top, left) + 1;

	*/
	int[][] prepareEditDistMatrx(String srcStr, 
									String desStr) {
		// We need one additonal row and column for dummy values.
		// We will put bigger string as column and smaller string as row.
		int rowCount = desStr.length() + 1;
		int colCount = srcStr.length() + 1;

		int[][] editDistMtrx = new int[rowCount][colCount];

		for(int row = 0; row < rowCount; row++) {
			for(int col = 0; col < colCount; col++) {
				if(0 == row || 0 == col) {
					if(0 == row) {
						editDistMtrx[row][col] = col;
					} else {
						editDistMtrx[row][col] = row;
					}
				} else {
					if(desStr.charAt(row - 1) == srcStr.charAt(col - 1)) {
						editDistMtrx[row][col] = editDistMtrx[row - 1][col - 1];
					} else {
						int diag_top_left = editDistMtrx[row - 1][col - 1];
						int top = editDistMtrx[row - 1][col];
						int left = editDistMtrx[row][col - 1];
						int min_dist_from_adjs = Math.min(diag_top_left, Math.min(top, left));

						editDistMtrx[row][col] = 1 + min_dist_from_adjs;
					}
				}
			}
		} // outer for loop
		printMatrix(editDistMtrx);
		return editDistMtrx;
	}

	void printMatrix(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;

		for(int row = 0; row < rowCount; row++) {
			for(int col = 0; col < colCount; col++) {
				System.out.print(matrix[row][col] + "\t");
			}
			System.out.println();
		}
	}
}