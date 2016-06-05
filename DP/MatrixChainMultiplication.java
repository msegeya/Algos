/**
	Question: Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

	Example: Given matrices A[2, 3], B[3, 6], C[6, 4], D[4, 5]. Now we will multiple all these matrices.
							(A * B)(C * D)
						 => A[2, 3] * B[3, 6] + C[6, 4] * D[4, 5] + Result of {A[2, 3] * B[3, 6]} * Result of {C[6, 4] * D[4, 5]}
						 => (2 * 3 * 6) + (6 * 4 * 5) + (2 * 6 * 5)
						 => 36 + 120 + 60
						 => 216
		In this way we need to find out all the multiplicative combinations of all the matrices. Also note, no matter about the order the result of the multiplication will be same but the number of operation may vary.

	NOTE: This question can also be asked as "Matrix Product Parenthesization."

	Source: https://www.youtube.com/watch?v=vgLJZMUfnsU
			https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MatrixMultiplicationCost.java
			http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/

	Logic:
		- Suppose say input is {1, 2, 3, 4} 
						=> (1, 2), (2, 3), (3, 4)  
						=> {(1, 2) * (2, 3)} * {3, 4} 
						=> {(1 * 2 * 3) with result (1 * 3)} * {(3, 4)}
						=> 6 + { (1, 3) * (3, 4) }
						=> 6 + (1 * 3 * 4)
						=> 6 + 12
						=> 18
		- Create a matrix of size equal to given array {1, 2, 3, 4} where matrix will be (1, 2), (2, 3), (3, 4)
		- One trick is to write down the matrix multiplication and then write the code for the same
			Length = 1 => Consider only one matrix at a time. So we can't multiply them => numbr of ways will be 0.
					1	2	3	4
				1	0
				2		0
				3			0
				4				0

			Length = 2 => Now take two matrices. (0, 1) * (1, 2) or (1, 2) * (2, 3) or (2, 3) * (3, 4)
			Take example, (0 * 1) => (1, 2) * (2, 3) where row = 0 and column = row + length;
			Why column is row + length? 
				Look at the matrix multiplication set => (1, 2) * (2, 3) => we need from start to end of the length that is from 0 to length => row = 0 to col = row + length
				and 
				k will be the between 0 and 2 that is k = row + 1 and k < col.

				So matrix[row][col] => matrix[row][row + length] => matrix[0][0 + 2] => matrix[0][2]
				=> (1, 2) * (2, 3) => 1 * 2 * 3 => 6.
			
			Example-2: (1 * 2) => (1, 2) * (2, 3) => Result of (1, 2) + Result of (2, 3) + Result of (1, 2) * Result of(2, 3)

					0	1	2	3
				0	0   	6
				1		0		
				2			0
				3				0
				
		NOTE: DON'T WORRY ABOUT THE CELLS THAT ARE NOT BEEN FILLED WE ARE ANYWAYS NOT DEPENEDING ON OTHER CELLS.
		- Initialize the cell matrix[row][col] with MAX_VALUE. Once after computation check if the result of the computation is less than the MAX_VALUE. If so then assign matrix[row][col] = result.
*/

class MatrixChainMultiplication {
	public static void main(String[] args) {
		int[] product = {4 ,2, 3, 5, 3};
		MatrixChainMultiplication mcmObj = new MatrixChainMultiplication();
		mcmObj.printMinProductMul(product);
	}

	void printMinProductMul(int[] product) {
		int minProductMul = getMinProductMul(product);
		System.out.println("Min Product Multiplicatiion: " + minProductMul);
	}

	int getMinProductMul(int[] product) {
		int[][] mulMatrix = prepareMatrix(product);
		return mulMatrix[0][mulMatrix[0].length - 1];
	}

	int[][] prepareMatrix(int[] product) {

		int rowCount = product.length;
		int colCount = product.length;

		int[][] resultMtrx = new int[rowCount][colCount];

		// since there are 4 products in the given input we need to calcualte product of length 4.
		// Length 1 => We will take only one product. That is we will consider only diagonal indexes.
		for(int i = 0; i < rowCount; i++) {
			resultMtrx[i][i] = 0;
		}

		// Length 2, 3, 4 .. 
		// As we have already done with length 1 that is (0, 0), (1, 1), (2, 2) .. 
		// Length = 2: We have {(0, 1), (1, 2)} and {(2, 3) * (3, 4)} 
		// Let's take {(0, 1), (1, 2)} => Result of (0, 1) + Result of (1, 2) + Result of (0, 1) * (1, 2) 
		for(int length = 2; length < product.length; length++) {
			for(int row = 0; row < rowCount - length; row++) {
				int col = row + length;
				resultMtrx[row][col] = Integer.MAX_VALUE;

				for(int k = row + 1; k < col; k++) {
					int result = resultMtrx[row][k] + resultMtrx[k][col] + product[row] * product[k] * product[col];

					if(result < resultMtrx[row][col]) {
						resultMtrx[row][col] = result;
					}
				}
			}						
		} // length for loop.

		return resultMtrx;
	}
}