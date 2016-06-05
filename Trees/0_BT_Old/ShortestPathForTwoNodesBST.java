/**
	Source: http://www.geeksforgeeks.org/find-distance-two-given-nodes/
	Question: Shortest Path For Two Nodes.

	Logic: 
		- Refer LeastCommonAncestorBST.java
		- Use the same LCA logic and get the LCA.
		- As LCA is the meeting point. Do sum of 
			(Distance from LCA to target-1 + Distance from LCA to target-2) which gives us Shortest path.
*/

import java.util.*;
class ShortestPathForTwoNodesBST {

	private BST bstObj;
	private BTNode root;

	public static void main(String[] args) {
		ShortestPathForTwoNodesBST spObj = new ShortestPathForTwoNodesBST();
		spObj.prepareBST();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first element in the tree: ");
		int target1 = scan.nextInt();
		System.out.println("Enter second element in the tree: ");
		int target2 = scan.nextInt();
		
		// Iteratively
		spObj.printShortestLengthIter(target1, target2);		
	}

	void prepareBST() {
		bstObj = new BST();
		int[] input = {20, 8, 22, 4, 12, 10, 14};
		for(int data : input) {
			root = bstObj.insert(root, data);
		}
		bstObj.print(root);
	}

	void printShortestLengthIter(int target1,
									int target2) {
		BTNode lcaNode = getLCA(root, target1, target2);
		System.out.println("LCA for " + target1 + " and " + target2 + " is " + lcaNode.data);

		int length = getLengthFromLCA(lcaNode, target1) + getLengthFromLCA(lcaNode, target2);

		System.out.println("Shortest path between " + target1 + " and " + target2 + " is " + length);
	}

	BTNode getLCA(BTNode root,
					int target1, 
						int target2) {
		if(null == root) {
			return null;
		} else {
			while(null != root) {
				if(target1 < root.data && target2 < root.data) {
					root = root.left;
				} else if(target1 > root.data && target2 > root.data) {
					root = root.right;
				} else {
					break;
				}
			}
		}

		return root;
	}

	int getLengthFromLCA(BTNode root, 
								int target) {
		int length = 0;
		if(target == root.data) {
			return length;
		} 

		while(null != root && root.data != target) {
			length++;
			if(target < root.data) {
				root = root.left;
			} else if(target > root.data) {
				root = root.right;
			}
		}

		System.out.println("Distance from LCA to " + target + " is " + length);

		return length;
	}
}