/**
	Question: Find if the LL is even or odd.

	Reference: Own

	Logic: 
		- Take fastPtr and move it 2 steps at a time.
		- When the fastPtr has next as null then it is odd if the fastPtr.next.next as null then even length.

*/
class EvenOddSLL {

	private SLLNode headEven;
	private SLLNode headOdd;

	public static void main(String[] args) {
		EvenOddSLL eoObj = new EvenOddSLL();
		eoObj.initialize();
		eoObj.isEvenOdd();
	}

	public void initialize() {
		headEven = SLL.createSLL();
		headOdd = SLL.createSLL();
		headOdd = SLL.insert(headOdd, 100);
		SLL.print(headOdd);
	}

	public void isEvenOdd() {
		checkEvenOdd(headEven);
		checkEvenOdd(headOdd);
	}

	public void checkEvenOdd(SLLNode head) {
		SLLNode fastPtr = head;

		while(null != fastPtr.next && null != fastPtr.next.next) {
			fastPtr = fastPtr.next.next;
		}

		System.out.println();
		if(null == fastPtr.next) {
			System.out.println("ODD LL");
		} else {
			System.out.println("EVEN LL");
		}
	}
}