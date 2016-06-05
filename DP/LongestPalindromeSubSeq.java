/**
	Question: Longest palindrome sub-sequence. (Sub-Sequence not Sub-String. So letters in palindrome need not to be in sequence.)

	Source: https://www.youtube.com/watch?v=_nCsPn7_OgI&index=9&list=PLTS60CibV9pAotipCiJwCdtC6Sntzgbww
			http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/

	Logic:
		- See the above video before proceding further.
		- Concept explained in below example as well as in code comments.
		- Also for printing the sub-sequence see method getPalindromeStr(..)

	Example: Input string = "agbdba"
			 Longest Palindrome sub-sequence is, "a b d b a" of length 5.
			 We have other palindrome also, "bdb" of length 3.
	
	Consider the above string "agbdba".
		- Construct a matrix of given string size. Note, the indexes in the below matrix are the indexes correponds to the indexes of the string i,e. 0 = a, 1 = g, 2 = b, 3 = d, 4 = b, 5 = a.
		Row index, column index means ==> From row to column i,e. say row=1 and column=4 => From character at index 2 to character at index 4 in the given string.  
						0	1	2	3	4	5
					0
					1
					2
					3
					4
					5
		- Take length which starts from 1 to string_length i,e. 1 to 6.
		- Length = 1, we will consider only 1 character at a time i,e. 0th, 1st, .. 5th.
		  With 1 character we can have only 1 palindrome. We will update matrix diagonally by placing 1 where row = column.
		 				0	1	2	3	4	5
					0	1
					1		1
					2			1
					3				1
					4					1
					5						1
		- Length=2, We need to update matrix for 0 to 1, 1 to 2, 2 to 3, 3 to 4, 4 to 5. (row to column).
					0 to 1 => a g => Compare first and last char, charAt(0) == charAt(1)? 
					Two cases,
						If YES, matrix[row][column] => matrix[0][1] = 2 
							=> First and last are equal so palindrome size will be 2.
						If NO, 	Get the maximum of (0, 0) and (1, 1) 
							=> Max(matrix[row][col - 1], matrix[row + 1][col]) => Max(matrix[0][0], matrix[1][1]);

					Similarly, take 1 to 2, 2 to 3 and so on.		
						0	1	2	3	4	5
					0	1	1	
					1		1	1
					2			1	1
					3				1	1
					4					1	1
					5						1
		- Length=3, 0 to 2, 1 to 3, 2 to 4, 3 to 5.
					0 to 2 => charAt(0) == charAt(2) => NO.
					Max(matrix[0][1], matrix[1][2]) => Max(1, 1) = 1.
					2 to 4 => [b d b] => b == b => YES.
					matrix[2][4] = (2 + remaining_char_is "d" to which only 1 palindrome is possible) => (2 + 1) => 3 
					that is nothing but matrix[2][4] = 2 + matrix[3][3] (middle character is "d" to which only 1 palin is possible.) So finally value is 3.

						0	1	2	3	4	5
					0	1	1	1
					1		1	1	1
					2			1	1	3	
					3				1	1	1
					4					1	1
					5						1
		- Final matrix,
						0	1	2	3	4	5
					0	1	1	1	1	3	5
					1		1	1	1	3	3
					2			1	1	3	3
					3				1	1	1
					4					1	1
					5						1

		- Finally for the length of the palindrome sub sequence we can get from 0th row .. last column. matrix[0][last_column]

		See below code comments for more details.											
*/


class LongestPalindromeSubSeq {

	public static void main(String[] args) {
		LongestPalindromeSubSeq lpssObj = new LongestPalindromeSubSeq();

		String input = "agbdba";
		// String input = "GEEKSFORGEEKS";
		lpssObj.printLonPalinSubSeq(input);
	}

	void printLonPalinSubSeq(String input) {
		int length = getPalinLength(input);
		System.out.println("Palindrome length: " + length);
	}

	int getPalinLength(String input) {
		int[][] palinMatrix = getPalindromeMatrix(input);
		
		String palinStr = getPalindromeStr(palinMatrix, input);
		System.out.println("Palindrom Sub-Sequence is: " + palinStr);
		
		return palinMatrix[0][input.length() - 1];
	}

	int[][] getPalindromeMatrix(String str) {
		int strLength = str.length();
		int[][] palinMatrix = new int[strLength][strLength];

		int rowCount = strLength;
		int colCount = strLength;
		
		// make all the diagonal cells as 1. Since we can atleast have one palindrome of length equal to the character itself.
		for(int row = 0; row < rowCount; row++) {
				palinMatrix[row][row] = 1;
		}
		
		for(int col = 1; col < colCount; col++) {
			// This is the column which we will be moving for all rows.
			int update_Col = col;
			for(int row = 0; row < rowCount; row++) {
				if(update_Col < colCount) {
					if(str.charAt(row) == str.charAt(update_Col)) {
						// As two chars (first and last) are equal so we will get minimum palindrome length as 2.
						int matchPalinLength = 2;
						
						// For characters in the middle we need the value from previous palindrome calculation.
						// For middle string, we get the value from row and column which are start of middle 
						//string index and end of middle string index.
						// Example: "abca" => say index 0 to index 3. Since here index-0 and index-3 are matching so
						// we need to consider the middle elements for remaining calculation. So middle string starts from 1 to 2
						// So get the value from matrix where row is 1 and column is 2 => say REMAIN and add it with 2 and update.
						int rem_middle_chars_len = palinMatrix[row + 1][update_Col - 1];
						
						palinMatrix[row][update_Col] = matchPalinLength + rem_middle_chars_len;
					} else {
						// If the characters do not match then update the cell with max of the previous palindrome i,e. 
						// the palindrome that is formed with middle elements if there are any.
						// Example: "agbd" => index 0 to 3 => since index 0 and index 3 values do not match so we need to check 
						// whether the middle characters can give us any good palindrome values or not.
						// so we search for Max(palinMatrix(0, 2), palinMatrix(1, 3))
						int left_len = palinMatrix[row][update_Col - 1];
						int down_len = palinMatrix[row + 1][update_Col];
						palinMatrix[row][update_Col] = Math.max(left_len, down_len);
					}
				}
				update_Col += 1;
			}
		}

		System.out.println("Palindrome Matrix: ");
		for(int row = 0; row < rowCount; row++) {
			for(int col = 0; col < colCount; col++) {
				System.out.print(palinMatrix[row][col] + "\t");
			}
			System.out.println();
		}
		
		return palinMatrix;
	}
	
	
	/**
	  How to get the palindrome string?
	  If the value is coming from either left or down cell then we have used Max operation. So we will move towards the max cell.
	  If the value is different from left and down cell then we need to move diagonally.
	 */
	String getPalindromeStr(int[][] palinMatrix, 
								String input) {
		int palinLength = palinMatrix[0][input.length() - 1];
		char[] output = new char[palinLength];
		
		int startPos = 0;
		int endPos = palinLength - 1;
		
		int row = 0;
		int col = input.length() - 1;
		while(palinLength > 0) {
			// Check from where did the length came.
			// If it is due to equals in palindrome string then we need to move diagonally.
			// else we need to move towards the max cell value side.
			if(palinMatrix[row][col - 1] == palinMatrix[row + 1][col] &&
					palinMatrix[row][col - 1] != palinLength) {
				output[startPos] = input.charAt(row);
				output[endPos] = input.charAt(col);
				
				palinLength -= 2;
				
				// we move diagonally.
				row = row + 1;
				col = col - 1;
				
				// update the output char positions for new value.
				startPos += 1;
				endPos -= 1;
			} else {
				if(palinMatrix[row][col -1] == palinLength) {
					col = col -1;
				} else {
					row = row + 1;
				}
			}
			
			if(1 == palinLength) {
				output[startPos] = input.charAt(row);
				break;
			}
		}
		
		return new String(output);
	}
} 