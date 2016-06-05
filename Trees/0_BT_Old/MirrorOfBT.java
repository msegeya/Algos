/**
	Source: http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
	Question: Given tree constrcut a mirror.

	Input:  								Output:
			 1										1		
		 /       \								  /   \
		2         3								 3     2
	  /   \     /   \							/ \   /  \
	 4     5   6    7						   7   6 5    4

	Logic: 
		- Leave the root of the source tree as it is.
		- Make the left child of root as right child in the mirror tree.
		- Make the right child of root as the left child in the mirror tree. 
*/

class MirrorOfBT {

	private CBT cbtObj;
	private BTNode root;

	public static void main(String[] args) {
		MirrorOfBT mbtObj = new MirrorOfBT();
		mbtObj.prepareCBT();
		mbtObj.makeMirror();
	}

	void prepareCBT() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void makeMirror() {
		BTNode mirrorRoot = getMirrorBT(root);
		cbtObj.print(mirrorRoot);
	}

	BTNode getMirrorBT(BTNode root) {
		if(null == root) {
			return null;
		}

		BTNode newNode = new BTNode(root.data);
		newNode.left = getMirrorBT(root.right);
		newNode.right = getMirrorBT(root.left);

		return newNode;
	}

}