/**
	Source: http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
	Question: Given inorder traversal and preorder traversal, construct the tree.

	Example: 
		Inorder: 4 2 5 1 6 3
		Preorder: 1 2 4 5 3 6

	Logic: 
		- As we know preorder is (Root-Left-Right) => first element of inorder is the root. In the above example root is 1.
		- Now in Inorder sequence, group elements to the left of 1 and elements to the right of 1 => (4 2 5) (1) (6 3)
		- Similarly take next element from Preorder that is 2, do same as Step-2. => (4 (2) 5) (1) (6 3)
		- Now take node element 4. As node 4 does not have any elements to the left and right that are not visited so we can ignore it.
		- Take 5, same as above step. Ignore it.
		- Take 6, 6 has one element in right in its preorder sequence that has yet to be visited. => (4 (2) 5) (1) (6) (3)
		- Finally the tree looks as below,
						1
					  /   \
					 2     3
					/ \    /
				   4   5  6
		- Please look at the comments in the code for more details.		    	  	
*/
class InorderPreorderToTree {

	private BTNode root;
	private CBT cbtObj;

	public static void main(String[] args) {
		InorderPreorderToTree ipObj = new InorderPreorderToTree();

		int[] inorder = {4, 2, 5, 1, 6, 3};
		int[] preorder = {1, 2, 4, 5, 3, 6};

		ipObj.buildTree(inorder, preorder);
	}

	void buildTree(int[] inorder,
						int[] preorder) {
		root = buildTreeViaInoPreo(inorder, preorder, 0, inorder.length - 1);
		cbtObj = new CBT();
		cbtObj.print(root);
	}


	/**
		Why do we need start and end index?
		When we split the inorder list basing on the key in post order we don't need to 
	*/
	static int preIndex = 0;
	BTNode buildTreeViaInoPreo(int[] inorder, 
								int[] preorder,
									int inStartIndex, 
										int inEndIndex) {
		
		if(inStartIndex > inEndIndex) {
			return null;
		}

		BTNode newNode = new BTNode(preorder[preIndex]);
		preIndex++;

		// We will go deep until there the start and end index of Inorder traversal are equal .. i.e, 
		// until there is no left and right elements for a given index.
		if(inStartIndex == inEndIndex) {
			return newNode;
		}

		// Find the preorder element index in Inorder. Such that we can divide the Inorder array into parts.
		int searchIndex = searchInorder(inorder, newNode.data, inStartIndex, inEndIndex);

		// We go deep until the start and end index are equal and fianlly return the first node that is created.
		newNode.left = buildTreeViaInoPreo(inorder, preorder, inStartIndex, searchIndex - 1);
		newNode.right = buildTreeViaInoPreo(inorder, preorder, searchIndex + 1, inEndIndex);

		return newNode;
	}

	int searchInorder(int[] inorder, 
							int element,
								int start,
									int end) {
		int searchIndex = -1;

		for(int i = start; i <= end; i++) {
			if(inorder[i] == element) {
				searchIndex = i;
			}
		}

		return searchIndex;
	}
}