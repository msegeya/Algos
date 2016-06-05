/**
	Question: Given BT, check whether given BT is CBT or not.

	CBT conditions: 
		1) All the levels except the last level should be completely filled.
		2) At each level right child nodes should be filled only after filling the left child nodes.

	Logic:
		- Get the size of the tree and say it as count.
		- Your'e index value should not be greater than the count. That is if you have 10 values in an array then your index positions will be from 0 .. 9.
		- If the tree is not a CBT and as array's are continous there should be no empty slots between any elements.
		- If for any node, if the index value is not incremented but while calculating the index position if the index is greater than the count then return false.
		- NOTE: Index position is calculated by the root level not by number of elements.
*/
class CheckIsCBT {
	
	public void checkCBT() {
		BTNode head;
		int count = BTUtil.count(head);
		if(isCBT(head, 0, count)) {
			System.out.println("Given tree is CBT.");
		} else {
			System.out.println("Given tree is NOT a CBT.");
		}
	}

	public boolean isCBT(BTNode root, int index, int count) {
		if(null == root) {
			return true;
		}

		if(index >= count) {
			return false;
		}

		return (isCBT(root.left, 2 * index + 1, count) && isCBT(root.right, 2 * index + 2, count));
	}

}