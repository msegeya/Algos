/**
	Question: Consider given BST is kinda MAX_HEAP. Now we need to check whether the BST is a Heap or not.

	Reference: http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/

	Logic: 
		- First property to check whether a tree is Heap or not is by checking for CBT. If CBT then check for Heap property else return false.
		- How to check whether a given tree is CBT or not. See isCBT(..) method for more details.
		- How to check MAX_HEAP property,
			For each node from bottom to top check whether the parent > child. If leaf then return true.
*/

class IsBSTHeap {

	/* See CheckIsCBT.java for more details. */
	// count is nothing but the number of nodes in the tree.
	// index starts from 0.
	public boolean isCBT(BTNode root, int index, int count) {
		if(null == root) { return true; }

		if(index >= count) { return false; }

		return isCBT(root.left, 2 * index + 1, count) && isCBT(root.right, 2 * index + 2, count);
	}

	public int count(BTNode root) {
		if(null == root) { return 0; }

		return 1 + count(root.left) + count(root.right);
	}

	public boolean isHeap(BSTNode root) {
		if(null == root) { return true; }

		if(null == root.left && null == root.right) { return true; }

		if(null == root.left && null != root.right) {
			return root.data >= root.right.data;
		}

		if(null != root.left && null == root.right) {
			return root.data >= root.left.data;
		}

		boolean isLeftHeap = isHeap(root.left);
		boolean isRightHeap = isHeap(root.right);

		return isLeftHeap && isRightHeap && ((root.data >= root.left.data && root.data >= root.right.data));
	}
}