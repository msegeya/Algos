/**
	Question: Given two sub-strings, find the Longest common sub-string.

	Source: https://www.youtube.com/watch?v=BysNXJHzCEs&list=PLTS60CibV9pAotipCiJwCdtC6Sntzgbww&index=15

	Logic: 
		- Look at the above video for logic.
		- Prepare a matrix such that,
			- If the values at row and column index of input strings matches then do,
					 matrix[row][col] = matrix[row -1][col - 1] + 1. 
				That is nothing but left-top-diagonal plus one.
			- If the values do not match then matrix[row][col] = 0 ==> Since it is a substring we don't need to do Max of cells because if one char in two stings mismatch then we need to start again. So we are putting 0 if there is a mismatch.

	How to print the sub-string?
		- We need to save the max_length and the cell that is having the max_length in the matrix. From there on we move diagonally upwards and get the character from input string (not string(s). Since we only need one input string to print the sub-string value.)
*/

class LongestCommonSubString {

	private int max_row;
	private int max_col;
	private int max_length;

	public static void main(String[] args) {
		LongestCommonSubString lcss = new LongestCommonSubString();	

		String str1 = "ABCDAF";
		String str2 = "ZBCDF";

		lcss.printLongCommonSubStr(str1, str2);
	}

	void printLongCommonSubStr(String str1, 
									String str2) {
		int[][] commonMatrix = prepareMatrix(str1, str2);
		DPUtil.print2DMatrix(commonMatrix);

		String subStr = getCommonSubStr(str1, max_length, commonMatrix, max_row, max_col);
		System.out.println("Longest Common Sub-String: " + subStr);
	}

	/*
		Start from max_row and max_col cell and keep moving diagonally upwards.
	*/
	String getCommonSubStr(String str1,
								int max_length, 
									int[][] commonMatrix, 
										int max_row,
											int max_col) {
		char[] output = new char[max_length];
		int endPtr = max_length - 1;

		while(max_length > 0) {
			if(commonMatrix[max_row][max_col] > 0) {
				// We need to do (max_row-1) since in the matrix we had a row-0 and column-0 with dummy values. 
				// So we are starting from 1 in the matrix calcualtion hence we need to decrement row value to get the corresponding character.
				output[endPtr] = str1.charAt(max_row - 1);

				// decrease the length and decrement output pointer.
				max_length--;
				endPtr--;

				// move diagonally upwards.
				max_row--;
				max_col--;
			}
		}

		return new String(output);
	}

	
	int[][] prepareMatrix(String str1, 
								String str2) {

		int rowCount = str1.length() + 1;
		int colCount = str2.length() + 1;
		int[][] commonMatrix = new int[rowCount][colCount];

		for(int row = 0; row < rowCount; row++) {
			for(int col = 0; col < colCount; col++) {
				if(0 == row || 0 == col) {
					commonMatrix[row][col] = 0;
				} else {
					// since we are starting from 1. So while comparing we need to start from 0 in the string.
					if(str1.charAt(row - 1) == str2.charAt(col - 1)) {
						int prev_substr_length = commonMatrix[row - 1][col - 1];
						commonMatrix[row][col] = prev_substr_length + 1;
						
						// Store the max length column and row. We need it to print the output.
						if(commonMatrix[row][col] > max_length) {
							max_length = commonMatrix[row][col];
							max_row = row;
							max_col = col;
						}

					} else {
						commonMatrix[row][col] = 0;
					}

				}
			}
		}

		return commonMatrix;
	}
}