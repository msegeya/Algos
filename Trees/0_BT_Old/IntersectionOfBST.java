/**
	Source: http://stackoverflow.com/questions/11271206/intersection-of-2-binary-trees-throws-stack-overflow-error
			http://stackoverflow.com/questions/5728821/intersection-of-2-binary-search-trees

	Question: Intersection of two BST's
	
	Logic:
		- Goto each node at every level like we have done in IdentiacalTreesOrNot.java
		- If the node is at same level with same data then return true else return false.
		- Recursively use the same logic for all the nodes.
*/

import java.util.*;

class IntersectionOfBST {

	private BST bstObj;
	
	private BTNode root1;
	private BTNode root2;
	private BTNode root;

	public static void main(String[] args) {
		IntersectionOfBST ibstObj = new IntersectionOfBST();
		
		ibstObj.prepareCBT();
		ibstObj.printInterOf2BST();
	}

	void prepareCBT() {
		bstObj = new BST();
		int[] input1 = {100, 50, 300, 30, 70};
		int[] input2 = {100, 50, 300, 30};

		for(int data : input1) {
			root1 = bstObj.insert(root1, data);
		}
		bstObj.print(root1);

		for(int data : input2) {
			root2 = bstObj.insert(root2, data);
		}
		bstObj.print(root2);
	}
	
	void printInterOf2BST() {
		List<Integer> result = new ArrayList<Integer>();
		makeIntersectionOf2Lists(root1, root2, result);

		System.out.println("Common elements are: ");
		printList(result);

		System.out.println("\nIntersection of two trees: ");
		root = makeBSTUsingList(root, result, 0, result.size() - 1);
		bstObj.print(root);	
	}

	BTNode makeBSTUsingList(BTNode root,
								List<Integer> result, 
									int start,
										int end) {
		if(start > end) {
			return null;
		}

		if(start == end) {
			BTNode node = new BTNode(result.get(start));
			return node;
		}

		int midIndex = getMidPoint(start, end);
		BTNode newNode = new BTNode(result.get(midIndex));

		newNode.left = makeBSTUsingList(newNode.left, result, start, midIndex - 1);
		newNode.right = makeBSTUsingList(newNode.right, result, midIndex + 1, end);

		return newNode;
	}

	int getMidPoint(int start, int end) {
		int mid = (start + end) / 2;

		if(start == 0) {
			mid += 1;
		} else if((start + end) % 2 == 0) {
			mid = mid;
		} else if((start + end) % 2 == 1) {
			mid = mid + 1;
		} 

		return mid;
	}

	void makeIntersectionOf2Lists(BTNode root1, 
										BTNode root2,
											List<Integer> result) {
		if(null == root1 && null == root2) {
			return;
		} 

		if(null == root1 || null == root2) {
			return;
		}

		makeIntersectionOf2Lists(root1.left, root2.left, result);
		if(root1.data == root2.data) {
				result.add(root1.data);
		} 

		makeIntersectionOf2Lists(root1.right, root2.right, result);
	}

	void printList(List<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
}