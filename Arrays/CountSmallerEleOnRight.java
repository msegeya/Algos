/**
	Question: Count smaller elements on right side

	Reference: http://www.geeksforgeeks.org/count-smaller-elements-on-right-side/

	NOTE: You can refer InversionCounter.java for doing this. We used Merge Sort logic here.

	Logic: (A Self Balancing Binary Search Tree (AVL, Red Black,.. etc) can be used to get the solution in O(nLogn) time complexity.)
		- We traverse the array from right to left and insert all elements one by one in an AVL tree.
		- While inserting a new key in an AVL tree, we first compare the key with root.
		- If key is greater than root, then it is greater than all the nodes in left subtree of root. So we add the size of left subtree to the count of smaller element for the key being inserted.
*/

class CountSmallerEleOnRight {
	public static void main(String[] args) {
		// int[] array = {12, 1, 2, 3, 0, 11, 4};
		int[] array = {10, 6, 15, 20, 30, 5, 7};
		
		CountSmallerEleOnRight cser = new CountSmallerEleOnRight();
		int[] count = cser.getEachEleCount(array);

		for(int c : count) {
			System.out.print(c + "\t");
		}
	}

	public int[] getEachEleCount(int[] array) {
		int[] count = new int[array.length];
		BSTArrayNode root = null;

		for(int i = array.length - 1; i >= 0; i--) {
			root = insert(root, array[i], count, i, 0);
		}

		return count;
	}

	public BSTArrayNode insert(BSTArrayNode root, int data, int[] count, int pos, int val) {
		if(null == root) {
			count[pos] = val;
			root = new BSTArrayNode(data);
			return root;
		}

		if(root.data <= data) {
			val++;
			if(null != root.left) {
				val += root.left.size;
			}

			root.right = insert(root.right, data, count, pos, val);
		} else {
			root.left = insert(root.left, data, count, pos, val);
		}

		// balancing after insertion.

		if(height(root.left) - height(root.right) > 1) {
			if(height(root.left) >= height(root.right)) {
				root = rightRotate(root);
			} else {
				root.left = leftRotate(root.left);
				root = rightRotate(root);
			}
		} else if(height(root.right) - height(root.left) > 1) {
			if(height(root.right.right) >= height(root.right.left)) {
				root = leftRotate(root);
			} else {
				root.right = rightRotate(root.right);
				root = leftRotate(root);
			}
		} else {
			root.height = getHeight(root);
			root.size = getSize(root);
		}

		return root;
	}

	public int getHeight(BSTArrayNode root) {
		if(null == root) {
			return 0;
		} else {
			int leftHeight = root.left != null ? root.left.height : 0;
			int rightHeight = root.right != null ? root.right.height : 0;

			return 1 + Math.max(leftHeight, rightHeight);
		}
	}

	public int height(BSTArrayNode root) {
		if(null == root) {
			return 0;
		} else {
			return root.height;
		}
	}

	public int getSize(BSTArrayNode root) {
		if(null == root) {
			return 0;
		} else {
			int leftSize = root.left != null ? root.left.size : 0;
			int rightSize = root.right != null ? root.right.size : 0;

			return 1 + Math.max(leftSize, rightSize);
		}
	}

	public BSTArrayNode leftRotate(BSTArrayNode root) {
		BSTArrayNode newRoot = root.right;
		root.right = root.right.left;
		newRoot.left = root;
		root.height = getHeight(root);
		root.size = getSize(root);
		newRoot.height = getHeight(newRoot);
		newRoot.size = getSize(newRoot);

		return newRoot;
	}

	public BSTArrayNode rightRotate(BSTArrayNode root) {
		BSTArrayNode newRoot = root.left;
		root.left = root.left.right;
		newRoot.right = root;
		root.height = getHeight(root);
		root.size = getSize(root);
		newRoot.height = getHeight(newRoot);
		newRoot.size = getSize(newRoot);

		return newRoot;
	}
}

class BSTArrayNode {
	public int data;
	public BSTArrayNode left;
	public BSTArrayNode right;

	// to get the number of elements greater than this element.
	public int size;
	// To get the level at which this element is present.
	public int height;


	public BSTArrayNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}