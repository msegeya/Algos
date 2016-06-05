/**
	Question: Longets commmon sub-sequence.

	Source: https://www.youtube.com/watch?v=NnD96abizww
			http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/

	Example: 
		string-1 = ABCDGH
		string-2 = AEDFHR
		The longest common sub-sequence is ADH. How?
		The matched letters need not to be consecutive but they have to be in the same order in both the string.

	Logic: 
		- Look at the above video and understand the algorithm first and then implement.
	
	How to calculate values in the matrix?
		- If the row and column header are same then increment left-top-diagonal value by 1.
		- If row and column value are not same then get Max(left_cell_value, top_cell_value) of the given cell.

	How to retieve the matched string?
		- Start from bottom right cell whose value say LENGTH.
		- Move towards left ONLY if the value in the left cell is same as LENGTH.
		- Else see if the row and column headers (string values at that position) are same. If so then move diagonally towards left and before moving save it in an array.
		- If the header values of the row and column are NOT same then check which is maximum among the left and top cell of the current cell and move it in that direction.
		- Do this until we reach row or column value is greater than 0.
*/

class LongestCommonSubSeq {

	private String string1;
	private String string2;

	public static void main(String[] args) {
		LongestCommonSubSeq lcsObj = new LongestCommonSubSeq();
		lcsObj.prepareStrings();

		lcsObj.printLCSLength();

		lcsObj.printLCSString();
	}

	void prepareStrings() {
		// output: "ADH" and 3
		// string1 = "ABCDGH"; string2 = "AEDFHR"; 

		// output: "GTAB" and 4
		string1 = "AGGTAB"; string2 = "GXTXAYB";

		// output: "ABCF" and 4
		// string1 = "ACBCF"; string2 = "ABCDAF";
	}

	void printLCSLength() {
		int lcsLength = getLCSLength(string1, string2);
		System.out.println("\nLCS length of " + string1 + " and " + string2 + " is " + lcsLength);
	}

	void printLCSString() {
		int[][] lcsMatrix = prepareLCSMatrix(string1, string2, string1.length(), string2.length());
		String matchedStr = getMatchedString(lcsMatrix, string1, string2);
		System.out.println("LCS string for " + string1 + " and " + string2 + " is " + matchedStr);
	}

	int getLCSLength(String str1, 
						String str2) {
		int l1 = str1.length();
		int l2 = str2.length();

		System.out.println("String-1 = " + str1 + " with length = " + l1);
		System.out.println("String-2 = " + str2 + " with length = " + l2);
 
		int[][] lcsMatrix = prepareLCSMatrix(str1, str2, l1, l2);

		return lcsMatrix[l1][l2];
	}

	int[][] prepareLCSMatrix(String str1, 
								String str2,
									int l1, 
										int l2) {
		// we need an extra row and column for storing zero's.
		int[][] lcsMatrix = new int[l1 + 1][l2 + 1];

		for(int i = 0; i <= l1; i++) {
			for(int j = 0; j <= l2; j++) {
				// initialize all the elements in row 0 and all the elements in column 0 awith ZERO
				if(i == 0 || j == 0) {
					lcsMatrix[i][j] = 0;
				  // If row and col value matches then update the cell value as (diagonal_value + 1)
				} else if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
					// else update the cell value with Max(left_cell_value, top_cell_value)
				} else {
					lcsMatrix[i][j] = Math.max(lcsMatrix[i][j - 1], lcsMatrix[i - 1][j]);
				}
				System.out.print(lcsMatrix[i][j] + "\t");
			}
			System.out.println();
		}
		return lcsMatrix;
	}

	String getMatchedString(int[][] lcsMatrix,
								String str1, 
									String str2) {
		int length = lcsMatrix[str1.length()][str2.length()];
		char[] output = new char[length];
		int k = length - 1;

		int rows = lcsMatrix.length - 1;
		int cols = lcsMatrix[0].length - 1;

		while(rows > 0 && cols > 0) {
			if(length == lcsMatrix[rows][cols - 1]) {
				cols--;
				// Since we are coming from the last cell .. we need to add the character at the of the output.
			} else if(str1.charAt(rows - 1) == str2.charAt(cols - 1)) {
				output[k] = str1.charAt(rows - 1); k--;
				length--;
				cols--;
				rows--;
			} else {
				// left is greater than top then go move towards left.
				if(lcsMatrix[rows][cols - 1] > lcsMatrix[rows - 1][cols]) {
					cols--;
				} else {
					rows--;
				}
			}
		}
		return new String(output);
	}

}