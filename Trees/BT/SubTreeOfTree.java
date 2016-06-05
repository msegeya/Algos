/**
	Question: Check whether a tree (S) is a sub tree of the main tree (T) or not?

	Logic - 1: Refer subTreeUsingIdentical method below --> O(m * n)

	Logic - 2: Best method O(n)	
		- Get inorder of the tree T say inT. (something like 1 -> 2 -> 3)
		- Get inorder of the tree S say inS. (something like 1 -> 2 -> 3)
			##### Check whether inS is substring of inT. ##### 
		- Wait its not over yet. Only with one traversal we won't get the solution.
		- Get preorder of the tree T say preT. (something like 1 -> 2 -> 3)
		- Get preorder of the tree S say preS. (something like 1 -> 2 -> 3)
			##### Check whether preS is substring of preT. #####
		- Only if both the conditions are true we will get say the given S is sub tree of T.	
*/

class SubTreeOfTree {
	boolean subTreeUsingIdentical(BTNode T, BTNode S) {
		// null is part of the tree
		if(null == S) {
			return true;
		}

		// if the base tree is itself null and the subtree S is not null then return T. 
		// Sub tree is not null since if it is null we would not reached here because of the above condition.
		if(null == T) {
			return false;
		}

		if(isIdentical(T, S)) {
			return true;
		}

		return (subTreeUsingIdentical(root.left) || subTreeUsingIdentical(root.right));
	}

	boolean isIdentical(BTNode T, BTNode S) {
		if(null == T && null == S) { return true; }
		if(null == T || null == S) { return false; }

		return ( (T.data == S.data)
						&&
				 isIdentical(T.left, S.left)
				 		&&
				 isIdentical(T.right, S.right)
			   );
	}

}