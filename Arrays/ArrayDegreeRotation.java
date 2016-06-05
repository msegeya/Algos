/**
	Question: Array Degree Rotation by 90 degress.

	Reference: 	http://www.programcreek.com/2013/01/leetcode-rotate-image-java/
				http://stackoverflow.com/questions/3488691/how-to-rotate-a-matrix-90-degrees-without-using-any-extra-space
	
	Example: 	{
				 1,2,3,
     			 4,5,6,
     			 7,8,9
     			}

     			output is,
     			{
     			 7,4,1,
     			 8,5,2,
       			 9,6,3
       			}

      Consider a 3x3 matrix and do the following, 
		- First write the matrix in terms of row and column postions.
			00	01	02
			10	11	12
			20	21	22
		  We have the make the elements of these indices move to different locations.
			20	10	00
			21	11	01
			22	12	02
		- We need to move only half the way so take ROW_MAX as n / 2 and take COL_MAX as Math.ceil(n/2).
		- The swapping logic,
			1. temp = matrix[0][0]
			2. matrix[0][0] = matrix[2][0] // last row first column first value. ==> row = n - 1 - col
			3. matrix[2][0] = matrix[2][2] // This place has to have value of last element. => [n - 1 - row][n - 1 - col]
			4. matrix[2][2] = matrix[0][2] // row = 0 (col) and col = [n - 1 - row]
			5. matrix[0][2] = temp
*/

class ArrayDegreeRotation {
	public static void main(String[] args) {
		int[][] matrix = {
							{1, 2, 3},
							{4, 5, 6},
							{7, 8, 9}
						 };

		// System.out.println("Rows = " + matrix.length + " and Columns = " + matrix[0].length);
		int n = matrix.length;
		int ROW_MAX = (int) Math.floor(n / 2);
		int COL_MAX = (int) Math.ceil(n / (double) 2);

		// System.out.println("ROW_MAX = " + ROW_MAX + " COL_MAX = " + COL_MAX);

		for(int row = 0; row < ROW_MAX; row++) {
			for(int col = 0; col < COL_MAX; col++) {
				int temp = matrix[row][col];
				matrix[row][col] = matrix[n - 1 - col][row];
				matrix[n - 1 - col][row] = matrix[n - 1 - row][n - 1 - col];
				matrix[n - 1 - row][n - 1 - col] = matrix[col][n - 1 - row];
				matrix[col][n - 1 - row] = temp;
			}
		}

		ArrayUtil.print(matrix);
	}
}