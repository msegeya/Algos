/**
	Question: Postorder traversal of a tree without using recursion.

	Logic:
		1) Push root to first stack.
		2) Loop while first stack is not empty
		   2.1 Pop a node from first stack and push it to second stack
		   2.2 Push left and right children of the popped node to first stack
		3) Print contents of second stack
*/

class PostOrderIterative {
	public static void postorder_iterative(BTNode root) {
		Stack<BTNode> stack_1 = new Stack<BTNode>();
		Stack<BTNode> stack_2 = new Stack<BTNode>();

		stack_1.push(root);

		while(!stack_1.isEmpty()) {
			BTNode pop = stack_1.pop();
			stack_2.push(pop);

			if(null != pop.left) {
				stack_1.push(pop.left);
			}

			if(null != pop.right) {
				stack_1.push(pop.right);
			}
		}

		// finally print all the elements in stack_2
		while(!stack_2.isEmpty()) {
			System.out.println(stack_2.pop());
		}
	}
}