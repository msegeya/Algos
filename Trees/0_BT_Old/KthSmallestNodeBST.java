/**
	Source: http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
	Question: Get kth smallest element in a BST. 
			Ex: If k=3, then we need to return 10.
				If k=5,	then we need to return 14

									20
								  /   \
								 8     22
							   /   \
							  4    12
							      /  \
								 10   14

	Logic: (Using Inorder Iteratively.)
		- As Inorder tree traversal prints all the nodes of a BST in sorted order. Using that we can get the kth element.
		- Traverse the tree Iteratively in Inorder traversal and push the elements into the stack.
		- While popping out elements we will decrement the k value. If k is 1 then return then popped element.

	Can we do it without using Stack? YES.
	Logic-2: (Using Morris Traversal. Without using recursion and without using Stack.)	
		- Please refer MorrisTraversal.java for the same.
*/
import java.util.Stack;
class KthSmallestNodeBST {
	
	private BST bstObj;
	private BTNode root;

	public static void main(String[] args) {
		KthSmallestNodeBST ksnObj = new KthSmallestNodeBST();
		ksnObj.prepareBST();

		ksnObj.printKthElement(3);
		ksnObj.printKthElement(5);
	}

	void prepareBST() {
		bstObj = new BST();
		int[] input = {20, 8, 22, 4, 12, 10, 14};
		for(int data : input) {
			root = bstObj.insert(root, data);
		}
		bstObj.print(root);
	}

	void printKthElement(int k) {
		BTNode node = getKthNode(root, k);
		System.out.println("K = " + k + " has value " + node.data);
	}

	BTNode getKthNode(BTNode root, 
							int k) {
		Stack<BTNode> stack = new Stack<BTNode>();
		BTNode result = null;

		if(root == null) {
			return null;
		} else {
			while(null != root.left) {
				stack.push(root);
				root = root.left;
			}

			while(!stack.isEmpty()) {
				BTNode node = stack.pop();
				k--;
				if(1 == k) {
					result = node;
				}

				if(null != node.right) {
					node = node.right;
					while(null != node) {
						stack.push(node);
						node = node.left;
					}
				}
			}
		}
		return result;
	}

}