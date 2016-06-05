/**
	Question: Given sum print the paths from root to leaf.
	
	Logic: 
		- Before going furthur please refer PrintRootToLeafPaths.java. We will follow the same logic just by including one more variable "sum".
		- We will follow same but when ever we encounter a node we will reduce the sum by node value.
		- If the sum is zero then return the path.
*/


import java.util.Scanner;

class SumPathFromRootToLeaf {
	private CBT cbtObj;
	private BTNode root;

	public static void main(String[] args) {
		SumPathFromRootToLeaf sprtObj = new SumPathFromRootToLeaf();
		sprtObj.prepareCBT();

		System.out.println("Enter Sum: ");
		Scanner scan = new Scanner(System.in);
		int sum = scan.nextInt();

		sprtObj.printSumPath(sum);
	}

	void prepareCBT() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		// int[] input = {1, 2, 3, 1}; ==> When you say sum as 4 then two paths will be printed.
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void printSumPath(int sum) {
		int[] path = new int[1000];
		int level = 0;
		getPathForGivenSum(root, path, level, sum);
	}

	void getPathForGivenSum(BTNode root, 
								int[] path,
									int level,
										int sum) {
		if(null == root) {
			return;
		}

		if(sum > 0) {
			sum = sum - root.data;
			path[level] = root.data;
			level++;
		}

		if(0 == sum) {
			printPaths(path, level);
			return;
		}

		if(null == root.left && null == root.right && sum > 0) {
			return;
		}

		getPathForGivenSum(root.left, path, level, sum);
		getPathForGivenSum(root.right, path, level, sum);
	}

	void printPaths(int[] path, int maxLevel) {
		for(int i = 0; i < maxLevel; i++) {
			System.out.print(path[i] + " -> ");
		}
		System.out.println();
	}
}