class IsMirror {
	public boolean isMirror(BTNode root1, BTNode root2) {
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
		  			isMirror(root1.left, root2.right)
		  					&&
		  			isMirror(root1.right, root2.left)
		  		);					

	}
}