/**
	Question: For each parent check whether the child's sum is equal to parent sum.

	Logic: For each node get the data and see whether its immediate children data sum is equal to parent's data.
*/

class CheckChildSum {
	public boolean checkChildSum(BTNode root) {
		if(null == root) {
			return true;
		}

		if(null == root.left && null == root.right) {
			return true;
		}

		int leftSum = (root.left != null) ? root.left.data : 0;
		int rightSum = (root.right != null) ? root.right.data : 0;
		
		return (root.data == leftSum + rightSum 
						&&
				checkChildSum(root.left) 
						&& 
				checkChildSum(root.right)
			   );
	}
}