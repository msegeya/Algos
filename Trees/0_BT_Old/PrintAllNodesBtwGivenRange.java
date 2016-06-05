/**
	Source: http://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/
	Question: Given k1 and k2, print all the nodes that are present in this range.

	Logic: 
		- If root value is greater than k1 then call left sub-tree of root
		- If the root value is within the range then print the value
		- If the root value is less than k2 then call right sub-tree.
*/
import java.util.*;
class PrintAllNodesBtwGivenRange {

	private BST bstObj;
	private BTNode root;

	public static void main(String[] args) {
		PrintAllNodesBtwGivenRange panObj = new PrintAllNodesBtwGivenRange();
		panObj.prepareBST();

		int k1 = 10;
		int k2 = 14;
		panObj.printNodesInRange(k1, k2);
	}

	void prepareBST() {
		bstObj = new BST();
		int[] input = {20, 8, 22, 4, 12, 10, 14};
		for(int data : input) {
			root = bstObj.insert(root, data);
		}
		bstObj.print(root);
	}

	void printNodesInRange(int k1, int k2) {
		System.out.println("Given range is between " + k1 + " and " + k2);
		List<Integer> list = new ArrayList<Integer>();
		printAllNodesInRange(root, k1, k2, list);

		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	void printAllNodesInRange(BTNode root, 
									int k1, 
										int k2, 
											List<Integer> list) {
		if(null == root) {
			return;
		} 
		if(root.data > k1) {
			printAllNodesInRange(root.left, k1, k2, list);
		}
		if(root.data >= k1 && root.data <= k2) {
			list.add(root.data);
		}
		if(root.data < k2) {
			printAllNodesInRange(root.right, k1, k2, list);
		}
	}
}