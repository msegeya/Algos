/**
	Question: Inorder successor of a tree.

	class Node
	{
	    int data;
	    Node *left;
	    Node *right;
	    Node *next;
	};

	Logic: 
		- Do reverse traversal of Inorder.
		- Follow code comments.
*/

class InorderSuccessor {

	// To keep track of the successors.
	static BTNode next = null;

	public void inorderSuccessor(BTNode root) {
		if(null != root) {
			inorderSuccessor(root.right);

			// Initially it will be null then we will update it with the last node.
			root.next = next;
			next = root;

			inorderSuccessor(root.left);
		}
	}
}