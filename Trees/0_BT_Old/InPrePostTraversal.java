import java.util.Stack;

class InPrePostTraversal {

	private CBT cbtObj;
	private BTNode root;

	public static void main(String[] args) {
		InPrePostTraversal ippObj = new InPrePostTraversal();
		ippObj.prepareCBT();

		ippObj.printInorderRecur();
		ippObj.printPreorderRecur();
		ippObj.printPostorderRecur();

		ippObj.printInorderIter();
		ippObj.printPreorderIter();
		// ippObj.printPostorderIter();		
	}

	void prepareCBT() {
		cbtObj = new CBT();
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int data : input) {
			root = cbtObj.insert(root, data);
		}
	}

	void printInorderRecur() {
		System.out.println("RECURSION: Inorder");
		doPrintInorderRecur(root);
		System.out.println();
	}

	void doPrintInorderRecur(BTNode root) {
		if(null == root) {
			return;
		} else {
			doPrintInorderRecur(root.left);
			System.out.print(root.data + " -> ");
			doPrintInorderRecur(root.right);
		}
	}


	void printPreorderRecur() {
		System.out.println("RECURSION: Preorder");
		doPrintPreorderRecur(root);
		System.out.println();
	}

	void doPrintPreorderRecur(BTNode root) {
		if(null == root) {
			return;
		} else {
			System.out.print(root.data + " -> ");
			doPrintPreorderRecur(root.left);
			doPrintPreorderRecur(root.right);
		}
	}

	void printPostorderRecur() {
		System.out.println("RECURSION: Postorder");
		doPrintPostorderRecur(root);
		System.out.println();
	}

	void doPrintPostorderRecur(BTNode root) {
		if(null == root) {
			return;
		} else {
			doPrintPostorderRecur(root.left);
			doPrintPostorderRecur(root.right);
			System.out.print(root.data + " -> ");
		}
	}

	void printInorderIter() {
		System.out.println("ITERATIVE: Inorder");
		doPrintInorderIter(root);
		System.out.println();
	}

	void doPrintInorderIter(BTNode root) {
		Stack<BTNode> stack = new Stack<BTNode>();

		while(null != root) {
			stack.push(root);
			root = root.left;
		}

		while(!stack.isEmpty()) {
			BTNode node = stack.pop();
			System.out.print(node.data + " -> ");

			if(null != node.right) {
				node = node.right;

				while(null != node) {
					stack.push(node);
					node = node.left;
				}
			}
		}
	}

	void printPreorderIter() {
		System.out.println("ITERATIVE: Preorder");
		doPrintPreorderIter(root);
	}

	void doPrintPreorderIter(BTNode root) {
		Stack<BTNode> stack = new Stack<BTNode>();
		stack.push(root);

		while(!stack.isEmpty()) {
			
			BTNode node = stack.pop();
			System.out.print(node.data + " -> ");

			if(null != node.right) {
				stack.push(node.right);
			} 

			if(null != node.left) {
				stack.push(node.left);
			}
		}
	}

	void printPostorderIter() {
		System.out.println("ITERATIVE: Postorder");
		doPrintPostorderIter(root);
	}

	void doPrintPostorderIter(BTNode root) {
		Stack<BTNode> stack = new Stack<BTNode>();
		stack.push(root);
		root = root.left;

		while(null != root) {
			stack.push(root);
			root = root.left;
		}

		while(!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.data + " -> ");

			if(null != root.right) {
				root = root.right;
				stack.push(root);

				root = root.left;
				while(null != root) {
					stack.push(root);
					root = root.left;
				}
			}
		}
	}
}