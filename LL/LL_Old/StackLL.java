/**
	Question: Stack using LL

	Reference: Kraumanchi

	Logic: 
		- Create a SLL.
		- Insert or Delete only from the front of the SLL.
*/

class StackLL {

	private SLLNode head;

	public static void main(String[] args) {
		StackLL stkLLObj = new StackLL();
		stkLLObj.stkLLOperations();
	}

	public void stkLLOperations() {
		insert(10);
		insert(20);
		insert(30);
		remove();
		remove();
		remove();
		remove();
	}

	public void insert(int data) {
		SLLNode newNode = new SLLNode(data);
		SLLNode front = null;
		if(null == head) {
			head = newNode;
		} else {
			front = head;
			head = newNode;
			head.next = front;
		}
		SLL.print(head);
	}

	public void remove() {
		if(null == head) {
			System.out.println("SLL is Empty.");
			return;
		}
		
		SLLNode first = head.next;
		SLLNode deleteNode = head;
		head = first;
		SLL.print(head);
	}
}