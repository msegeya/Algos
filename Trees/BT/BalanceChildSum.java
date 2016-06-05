/**
	Question: Balance a tree by making data of each parent is equal to sum of its immedaite children. One condition is we should not reduce the data value of any node.

	Logic: A bit tricky.
		0. Traverse all the way down and then start from there.

		1. If the parent's data is greater than the sum of the child's data then increment one of its children .. as we start with left so we increment left child's value.

		2. If the parent's data is less than the sum of the child's data then increment the parent value. But then we also need ot change the parent's parent value also.

	Three Conditions: diff = (leftSum + rightSum) - root.data;
		1. If(dif == 0) then just return;
		2. If (diff > 0) then just increment any the parent's data by diff.
		3. If (dif < 0) then we need to increment the child's value and which inturn we need to change its parent root values.


		     50
           /     \     
         /         \
       7             2
     / \             /\
   /     \          /   \
  3        5      1      30	
*/

class BalanceChildSum {
	
	public void balance(BTNode root) {
		int leftSum = 0;
		int rightSum = 0;
		int diff = 0;

		if(null == root || (null == root.left && null == root.right)) {
			return;
		}

		balance(root.left);
		balance(root.right);

		leftSum = (root.left != null) ? root.left.data : 0;
		rightSum = (root.right != null) ? root.right.data : 0;

		diff = (leftSum + rightSum) - root.data;

		if(dif > 0) {
			root.data += dif;
		} else if(dif < 0) {
			// we don't need the negative part. What we need is just the difference.
			increment(root, Math.abs(dif));
		}
	}

	// If we increment the childs value then we need to increment the subsequent children of this node.
	// So traverse down with the difference until we reach null.
	public void increment(BTNode node, int dif) {
		if(null != node.left) {
			node.left.data += dif;
			increment(node.left, dif)
		} else if(null != node.right) {
			node.right.data += dif;
			increment(node.right, dif);
		}
	}
}