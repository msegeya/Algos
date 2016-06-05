/**
	Question: Find the longest palindrome sub-string.

	Source: https://www.youtube.com/watch?v=obBdxeCx_Qs
			http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

	Manacher's Algorithm: (TC: O(n). VERY HARD TO IMPLEMENT. So use DP approach in mentioned in above link.)
		https://www.youtube.com/watch?v=V-sEwsca1ak&list=PLTS60CibV9pAotipCiJwCdtC6Sntzgbww&index=8

	Logic: (Using DP not Mancher's algorithm)
		- We can't use same logic as LongestPalindromeSubSeq.java. Since we are can't use incremental numbers like incrementing by 2 here.
		- When ever a row and column value fo a cell matches then we should also make sure to check the diagonally previous one is true or not. Only if it is true then we should mark it as true. 
		Why to do this?
			Simple, we are doing it because we need to make sure the substring which is in the middle also satisfies palindrome condition.
		- Look at below code comments for more details.

	How to print the sub-string?
		While traversing make sure to note down the start index of the palindromic sub-string. Now we know the start point and length so we calcualte the sub-string.
		See below code comments --> getPalinSubStr(..)
*/

class LongestPalinSubStr {

	private int palinBeginsAt;

	public static void main(String[] args) {
		LongestPalinSubStr lpsstrObj = new LongestPalinSubStr();

		  String input = "BANANA"; // O/P: ANANA
//		  String input = "BABCBABCBACCBA"; // O/P: ABCBABCBA
//		String input = "ABAABA"; // O/P: ABAABA

		lpsstrObj.printLongSubStr(input);
	}

	void printLongSubStr(String input) {
		int longSubStrLength = getLongestSubStrLength(input);
		System.out.println("Longest Sub-String Length: " + longSubStrLength);
	}

	int getLongestSubStrLength(String input) {
		int palinSubStrLen = prepareMatrixAndGetLength(input);
		
		String subStr = getSubStrUsingLength(input, palinSubStrLen, palinBeginsAt);
		System.out.println("Palindromic String is: " + subStr);

		return palinSubStrLen;
	}

	String getSubStrUsingLength(String input, 
									int palinSubStrLen,
										int palinBeginsAt) {
		StringBuilder builder = new StringBuilder();
		int start = 0;
		
		while(start < palinSubStrLen) {
			builder.append(input.charAt(palinBeginsAt));
			
			palinBeginsAt++;
			start++;
		}

		return builder.toString();
	}

	/**
		Look at the above mentioned video.
		Even when the row and column character matches we need to make sure the characters in the middle should also satisfy the palindrome constraint.	
	*/
	int prepareMatrixAndGetLength(String str) {
		// min one length always exists.
		int max_length = 1;
		int length = str.length();

		// boolean matrix that stores the truth values.
		boolean[][] palinMatrix = new boolean[length][length];

		// Initialize the matrix diagonally. Since 1 character is a palindrome we will initialize it with TRUE.
		for(int row = 0; row < length; row++) {
			palinMatrix[row][row] = true;
		}

		// two length sub-string's
		for(int i = 0; i < length - 1; i++) {
			if(str.charAt(i) == str.charAt(i + 1)) {
				palinMatrix[i][i + 1] = true;
				max_length = 2;
			}
		}
		// printMatrix(palinMatrix);

		// Even when the row and column character matches we need to make sure the characters 
		// in the middle should also satisfy the palindrome constraint.
		for(int col = 2; col < length; col++) {
			int updated_col = col;
			for(int row = 0; row < length; row++) {
				if(updated_col < length) {
					if((str.charAt(row) == str.charAt(updated_col)) && 
								(palinMatrix[row + 1][updated_col - 1])) {
						palinMatrix[row][updated_col] = true;
						int cur_length = updated_col - row + 1;

						if(max_length < cur_length)
							max_length = cur_length;
						
						palinBeginsAt = row;
					}	
				}
				updated_col++;
			}
		}
		printMatrix(palinMatrix);

		return max_length;
	}

	void printMatrix(boolean[][] matrix) {
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + "\t");
			}
			System.out.println();
		}
	}
}