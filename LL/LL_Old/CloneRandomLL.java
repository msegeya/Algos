/**
	Question: Clone a LL where each node had a next pointer and a random pointer. Next pointer points to next node and random pointer points to some random node.

	Reference: http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/

	Logic: 
		- Consider input as 1 -> 2 -> 3 -> 4 and Random Ptr(RP) of 1 points to 3, RP of 2 points to 1, 3 points to 4, 4 points to 3.
		- Create new node for each node and place it next to each original node.
			==> 1 -> 1 -> 2 -> 2 -> 3 -> 3 -> 4 -> 4
		- We have not yet worked on random pointers. Now we will work on them. original.next is nothing but duplicate new node	
		   ################## original.next.arbitary = original.arbitary.next; ##################
		   
		   This works because original's next is duplicate node. We need to point duplicate node's random pointer. Which is nothing but next of original's random pointer.
		- Now restore original and cloned lists separatly.
		- Make sure to make next pointer for last node's of both original and cloned list as null.   
*/

class CloneRandomLL {
	
	private SLLNode head;
	private SLLNode originalList;
	private SLLNode finalClonedList;

	public static void main(String[] args) {
		CloneRandomLL crllObj = new CloneRandomLL();
		crllObj.initialize();
		crllObj.myClone();
	}

	public void initialize() {
		SLLNode node_1 = new SLLNode(1);
		SLLNode node_2 = new SLLNode(2);
		SLLNode node_3 = new SLLNode(3);
		SLLNode node_4 = new SLLNode(4);

		node_1.next = node_2;
		node_2.next = node_3;
		node_3.next = node_4;
		node_4.next = null;

		// create random pointers.
		node_1.random = node_3;
		node_2.random = node_1;
		node_3.random = node_4;
		node_4.random = node_3;

		head = node_1;

		SLL.printDataAndRandom(head, "Orignal List");
	}

	public void myClone() {
		SLLNode nodeCloneList = doNodeClone(head);
		SLLNode randomPtrList = doRandomPtrClone(nodeCloneList);
		segregateOriginalAndRandom(randomPtrList);
	}

	public SLLNode doNodeClone(SLLNode head) {
		SLLNode current = head;

		while(null != current) {
			SLLNode newNode = new SLLNode(current.data);

			newNode.next = current.next;
			current.next = newNode;

			current = current.next.next;
		}

		SLL.printDataAndRandom(head, "Orignal List");

		return head;
	}

	public SLLNode doRandomPtrClone(SLLNode nodeClone) {
		SLLNode current = nodeClone;

		while(null != current) {
			current.next.random = current.random.next;
			current = current.next.next;
		}

		return nodeClone;
	}

	public void segregateOriginalAndRandom(SLLNode clonedList) {

		SLLNode originalListPtr = null, finalClonedListPtr = null;
		SLLNode prevNode = null;
		SLLNode current = clonedList;

		while(null != current) {
			if(null == originalList) {
				originalList = current;
				originalListPtr = originalList;
			} else {
				originalListPtr.next = current;
				originalListPtr = originalListPtr.next;
			}

			if(null == finalClonedList) {
				finalClonedList = current.next;
				finalClonedListPtr = finalClonedList;
			} else {
				finalClonedListPtr.next = current.next;
				finalClonedListPtr = finalClonedListPtr.next;
			}

			current = current.next.next;
		}

		SLL.printDataAndRandom(originalList, "Original List After Cloning");
		SLL.printDataAndRandom(finalClonedList, "Cloned List");

	}

}