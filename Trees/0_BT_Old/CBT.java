
import java.util.*;
class CBT {

	public static void main(String[] args) {
		CBT cbt = new CBT();
		BTNode root  = null;
		root = cbt.prepareCBT(root);
		cbt.print(root);
	}

	BTNode prepareCBT(BTNode root) {
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int data : input) {
			root = insert(root, data);
		}
		return root;
	}

	public BTNode insert(BTNode root, int data) {
		BTNode newNode = new BTNode(data);
		if(null == root) {
			root = newNode;
			return root;
		} 

		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(root);
		boolean inserted = false;
		while(!queue.isEmpty() && !inserted) {
			BTNode poppedNode = queue.remove();
			if(null == poppedNode.left) {
				poppedNode.left = newNode;
				inserted = true;
			} else if(null == poppedNode.right) {
				poppedNode.right = newNode;
				inserted = true;
			} else {
				if(null != poppedNode.left) {
					queue.add(poppedNode.left);
				}
				if(null != poppedNode.right) {
					queue.add(poppedNode.right);
				}
			}
		}
		return root;
	}

	public BTNode insert(BTNode root, 
								int data, 
									int parent,
										boolean leftRightFlag) {
		BTNode newNode = new BTNode(data);

		if(root == null) {
			root = newNode;
			return root;
		}

		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BTNode poppedNode = queue.remove();
			
			if(poppedNode.data == parent) {
				// false means left side.
				if(leftRightFlag == false) {
					poppedNode.left = newNode;
				} else {
					poppedNode.right = newNode;
				}
			}

			if(null != poppedNode.left) {
					queue.add(poppedNode.left);
			}
			
			if(null != poppedNode.right) {
					queue.add(poppedNode.right);
			}
		}
		return root;
	}

	void print(BTNode root) {
		System.out.println("Elements present in the tree are: ");
		printUsintBFS(root);
		System.out.println();
	}

	void printUsintBFS(BTNode root) {
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(root);
		queue.add(null);
		int level = 0;
		while(!queue.isEmpty()) {
			BTNode poppedNode = queue.remove();
			if(null == poppedNode) {
				level++;
				if(!queue.isEmpty()) {
					queue.add(null);
				}
			} else {
				System.out.println("Element " + poppedNode.data + " is at level " + level);
				if(null != poppedNode.left) {
					queue.add(poppedNode.left);
				}

				if(null != poppedNode.right) {
					queue.add(poppedNode.right);
				}
			}
		}
	}
}