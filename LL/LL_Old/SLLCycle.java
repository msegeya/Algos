/**
	Question: Check if the LL has a cycle or not.

	Reference: karumanchi

	Logic: 
		- Take two pointers. slowPtr, fastPtr. ==> slowPtr move one step and fastPtr moves two steps at a time.
		- Initialize slowPtr and fastPtr to head.
		- If slow meets fast then SLL has a cycle else if they meet null then there is no cycle.

	Example:
		head--> 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> 70 -> 80 -> 100
				|												 |	
				|________________________________________________|

*/

class SLLCycle {

	public SLLNode headCycle;
	public SLLNode headNoCycle;
	public SLLNode slowPtr, fastPtr;

	public static void main(String[] args) {
		SLLCycle sllcObj = new SLLCycle();
		sllcObj.initialize();
		sllcObj.makeCycle();

		sllcObj.checkCycle();
	}

	public void initialize() {
		headCycle = SLL.createSLL();
		headNoCycle = SLL.createSLL();
	}

	public void makeCycle() {
		SLLNode newNode = new SLLNode(100);
		SLLNode current = headCycle;
		while(null != current.next) {
			current = current.next;
		}
		current.next = newNode;
		newNode.next = headCycle;

		SLL.printCycle(headCycle);
	}

	public void checkCycle() {
		isCycle(headCycle);
		isCycle(headNoCycle);	
	}

	public void isCycle(SLLNode head) {
		slowPtr = head;
		fastPtr = head;
		boolean cycleStatus = false;

		while(null != slowPtr.next && null != fastPtr.next &&  null != fastPtr.next.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if(slowPtr == fastPtr) {
				cycleStatus = true;
				break;
			}
		}

		System.out.println();
		if(cycleStatus) {
			System.out.println("SLL has a cycle.");
		} else {
			System.out.println("SLL has NO cycle.");
		}
	}	

}