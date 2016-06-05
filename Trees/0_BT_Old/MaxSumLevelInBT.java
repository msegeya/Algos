/**
	Logic - 1: RECURSION 
		We know how to get the print data at each level.
		Now insteaf of printing them we will sum all the data and return the total sum at each level.

	Logic - 2: Iterative
		We know to print level by level in a tree using BFS.
		Now add these and save them in an array with level as index.
		Finally return the index with maximum sum.	
*/

class MaxSumLevelInBT {
	
	private CBT cbtObj;
	private BTNode root;

	public static void main(String[] args) {
		MaxSumLevelInBT mslObj = new MaxSumLevelInBT();
		mslObj.prepareCBT();

		mslObj.getMaxLevelRecur();

		// mslObj.getMaxLevelIter();
	}

	void prepareCBT() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void getMaxLevelRecur() {
		int height = BTUtil.getHeight(root);
		System.out.println("Height of a tree is: " + height);	

		int[] levelSum = new int[height];

		for(int level = 0; level < height; level++) {
			int sum = getMaxSumLevelRecur(root, level);
			levelSum[level] = sum;
		}

		int maxSum = -1;
		int maxLevel = -1;

		for(int i = 0; i < height; i++) {
			if(maxSum < levelSum[i]) {
				maxSum = levelSum[i];
				maxLevel = i;
			}
		}

		System.out.println("RECURSION: Maximum sum " + maxSum + " is at level " + maxLevel);
	}

	int getMaxSumLevelRecur(BTNode root, 
								int level) {
		if(null == root) {
			return 0;
		}

		if(0 == level) {
			return root.data;
		}

		return (getMaxSumLevelRecur(root.left, level - 1) + getMaxSumLevelRecur(root.right, level - 1));
	}

}