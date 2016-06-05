/**
	Question: Get the Nth node from end of LL.

	Reference: Karumanchi

	Logic: 
		- Take two pointers startPtr, endPtr and point them to head of the SLL.
		- Move endPtr N-steps startign from head.
		- Now startPtr is at head and endPtr is at Nth position of the SLL. 
		- Move each of them one step at a time. When the endPtr reaches the end then startPtr is at Nth node.
*/


class NthNodeLast {

	private SLLNode head;
	private SLLNode firstPtr;
	private SLLNode lastPtr;

	private int N = 3;

	public static void main(String[] args) {
		NthNodeLast nnlObj = new NthNodeLast();
		nnlObj.initialize();
		nnlObj.printNthElement();
	}

	public void initialize() {
		head = SLL.createSLL();
	}

	public void printNthElement() {
		firstPtr = head;
		lastPtr = head;

		int count = 1;
		while(count != N) {
			lastPtr = lastPtr.next;
			count++;
		}

		while(null != lastPtr.next) {
			firstPtr = firstPtr.next;
			lastPtr = lastPtr.next;
		}

		System.out.println();
		System.out.println(N + " value from last is " + firstPtr.data);
	}
}