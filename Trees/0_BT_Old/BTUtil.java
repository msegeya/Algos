public class BTUtil {
	public static int getHeight(BTNode root) {
		if(null == root) {
			return 0;
		}

		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	public static void printInorder(BTNode root) {
		System.out.println("Inorder traversal:");
		inorder(root);
		System.out.println();
	}

	public static void inorder(BTNode root) {
		if(null == root) {
			return;
		} else {
			inorder(root.left);
			System.out.print(root.data + " -> ");
			inorder(root.right);
		}
	}

	public static void printPreorder(BTNode root) {
		System.out.println("Preorder traversal:");
		preorder(root);
		System.out.println();
	}

	public static void preorder(BTNode root) {
		if(null == root) {
			return;
		} else {
			System.out.print(root.data + " -> ");
			preorder(root.left);
			preorder(root.right);
		}
	}
}