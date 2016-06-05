/**
	Question: Find the mid point of a single linked list.

	Reference: http://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/

	Logic: 
		- Take two pointer fastPtr, slowPtr. fastPtr moves two steps and slowPtr moves 1 step.
		- When fastPtr reaches end of the LL then slowPtr is at the middle of the LL.
*/

class MidPointSLL {

	private SLLNode headEven;
	private SLLNode headOdd;

	public static void main(String[] args) {
		MidPointSLL mpObj = new MidPointSLL();
		mpObj.initialize();
		mpObj.printMidPoint();		
	}

	public void initialize() {
		headEven = SLL.createSLL();

		headOdd = SLL.createSLL();
		headOdd = SLL.insert(headOdd, 100);
		SLL.print(headOdd);
	}

	public void printMidPoint() {
		printMid(headEven, "Even-LL");
		printMid(headOdd, "Odd-LL");
	}

	public void printMid(SLLNode head, String msg) {
		SLLNode slowPtr = head, fastPtr = head;
		while(null != slowPtr.next && null != fastPtr.next && null != fastPtr.next.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		System.out.println();
		System.out.println(msg + ": " + "Mid-Point of the LL is " + slowPtr.data);
	}

}