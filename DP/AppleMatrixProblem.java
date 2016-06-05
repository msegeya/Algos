/**
	Question: 
		A table composed of N x M cells, each having a certain quantity of apples, is given. You start from the upper-left corner. At each step you can go down or right one cell. Find the maximum number of apples you can collect.
											OR
		The same question can also be asked as "Given matrix with each cell having cost find the path from top-left to bottom-right with minimum cost."

	Reference: 
			  https://www.topcoder.com/community/data-science/data-science-tutorials/dynamic-programming-from-novice-to-advanced/ (SEARCH FOR WORD "APPLE")
		  	  http://www.careercup.com/question?id=14090859
			  http://codereview.stackexchange.com/questions/60930/project-euler-81-minimum-path-sum-through-a-matrix
	
	Example: Each of the cell in the below matrix has apples. Below numbers shows the apple count in each cell. 
			 We can move only RIGHT and DOWN for any cell. And we can update a value only from TOP and LEFT cell of the current cell.
			 Now we need to start at (0, 0) and end at bottom-right cell i,e. (4, 4) by collecting maximum number of apples.

		Input: 	1	2	3
				4	5	6
				7	8	9

		1) Start at (0, 0) and take matrix say Sum[][]
		2) Initialize path as Sum[0][0] = 1
		3) Then initialize first row and first column,
				For row, sice we need to move right.
								Sum[0, 1] = [0, 1] + Sum[0, 0] = 3; 
								Sum[0, 2] = [0, 2] + Sum[0, 1] = 6  and so on.

				For column, we need to get value from top.
								Sum[1, 0] = [1, 0] + Sum[0, 0] = 4 + 1 = 5
								Sum[2, 0] = [2, 0] + Sum[1, 0] = 7 + 5 = 12

			Matrix becomes,		1       3       6
								5       
								12
		4) For remaining cells, Sum[i, j] = value_at[i, j] + Max(Sum[i][j - 1], Sum[i - 1][j])

	Logic: 
		- 	
*/

class AppleMatrixProblem {
	public static void main(String[] args) {
		int[][] apples = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

		/*
		  int[][] apples = { {131, 673, 234, 103, 18}, 
						     {201, 96, 342, 965, 150}, 
						     {630, 803, 746, 422, 111}, 
						     {537, 699, 497, 121, 956}, 
						     {805, 732, 524, 37, 331}
						   };
		*/
	
		AppleMatrixProblem ampObj = new AppleMatrixProblem();
		ampObj.printCollectedApples(apples);
	}

	void printCollectedApples(int[][] apples) {
		int colApples = getCollectedApples(apples);
		System.out.println("Collected Apples: " + colApples);
	}

	int getCollectedApples(int[][] apples) {
		int[][] resultMatrix = prepareMatrix(apples);
		return resultMatrix[apples.length - 1][apples[0].length - 1];
	}

	int[][] prepareMatrix(int[][] apples) {
		int rowCount = apples.length;
		int colCount = apples[0].length;

		int[][] sum = new int[rowCount][colCount];

		// initialize first cell.
		sum[0][0] = apples[0][0];

		// fill first row and first column.
		for(int i = 1; i < rowCount; i++) {
			// current cell plus previous LEFT sum
			sum[0][i] = apples[0][i] + sum[0][i - 1];
			
			// current cell plus previous TOP sum
			sum[i][0] = apples[i][0] + sum[i - 1][0];
		}


		for(int row = 1; row < rowCount; row++) {
			for(int col = 1; col < colCount; col++) {
				// current cell plus maximum of LEFT or TOP
				int LEFT_CELL = sum[row][col - 1];
				int TOP_CELL = sum[row - 1][col];
				sum[row][col] = apples[row][col] + Math.max(LEFT_CELL, TOP_CELL);
			}
		} // outer for loop

		// print apple sum matrix
		System.out.println("Print Apple sum matrix: ");
		DPUtil.print2DMatrix(sum);

		return sum;
	}
}