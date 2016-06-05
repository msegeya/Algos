class IdenticalTrees {
	public boolean identical(BTNode root1, BTNode root2) {

		if(null == root1 && null == root2) {
			return true;
		}

		if(null == root1 && null != root2) {
			return false;
		}		

		if(null != root1 && null == root2) {
			return false;
		}

		return (
					(root1.data == root2.data) 
							&& 
					identical(root1.left,root2.left)
							&&
					identical(root1.right,root2.right)
				);			
	}
}