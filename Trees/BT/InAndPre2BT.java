/**
	Question: Given Inorder and PreOrder traversal, create a tree out of them.

	Logic: 
		- Using preorder traversal figure out the root and nodes to left and right of it in the inorder.
*/

class InAndPre2BT {
	
	/*
		int[] preOrder = {1 2 4 5 3 6};
		int[] inOrder = {4 2 5 1 6 3};
		int start = 0;
		int end = preOrder.length;
	*/

	int preOrderIndex = 0;
	public BTNode convert(int[] preOrder, int[] inOrder, int strat, int end) {
		if(start > end) {
			return null;
		}

		BTNode newNode = new BTNode(pre[preOrderIndex]);
		preOrderIndex++;

		if(start == end) {
			return newNode;
		}

		int search = searchInorder(inOrder, newNode.data, start, end);

		newNode.left = convert(preOrder, inOrder, start, search - 1);
		newNode.right = convert(preOrder, inOrder, search + 1, end);

		return newNode;
	}

	public int searchInorder(int[] inOrder, int data, int start, int end) {
		for(int i = start; i <= end; i++) {
			if(data == inOrder[i]) {
				return i;
			}
		}
		return -1;
	}
}