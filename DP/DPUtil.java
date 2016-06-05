class DPUtil {
	static void print2DMatrix(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;

		for(int row = 0; row < rowCount; row++) {
			for(int col = 0; col < colCount; col++) {
				System.out.print(matrix[row][col] + "\t");
			}
			System.out.println();
		}	
	}

	static void print2DMatrix(boolean[][] matrix) {
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