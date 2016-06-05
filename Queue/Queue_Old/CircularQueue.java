/**
	Question: Circular Queue

	Reference: http://www.javamadesoeasy.com/2015/01/circular-queue.html

	Logic: 
		- Take following pointer, front, rear, count.
			where, 
					front will point to the first element in the circular queue.
					rear will point to the last element in the circular queue.
					count will count the number of elements in the circular queue.
		- Initially CQ is empty, so front and rear will be pointing to 0th index and count is 0.
		- Insertion:
				If count == CAPACITY then QUEUE_FULL
				Else
				Insert element at Rear and make sure to point front to starting element of the queue.
				Increment rear as (rear + 1) % CAPACITY

		- Deletion:
				If count == 0, then QUEUE_EMPTY.
				Else
				Delete element at Front postion and increment front as (front + 1) % CAPACITY.

		- Print:
				Print all elements from FRONT and start decrementing count each time and make i increment as (i + 1) % CAPACITY;
*/

class CircularQueue {

	private int[] CQ;
	private int CAPACITY = 5;
	private int count = 0;
	private int FRONT = 0;
	private int REAR = 0;

	public static void main(String[] args) {
		CircularQueue cqObj = new CircularQueue();
		cqObj.initialize();

		cqObj.pushNpop();
	}

	private void initialize() {
		CQ = new int[CAPACITY];
	}

	private void pushNpop() {
		insert(1);
		insert(2);
		print();
		remove();
		remove();

		// to check isEmpty()
		remove();
		
		// to check print if CQ is empty.
		print();

		insert(3);
		insert(4);
		insert(5);
		insert(6);
		insert(7);
		
		// to check isFull()
		insert(8);

		// to print if capacity is full.
		print();
	}

	private boolean isFull() {
		if(count == CAPACITY) {
			return true;
		} 
		
		return false;
	}

	private boolean isEmpty() {
		if(count == 0) {
			return true;
		}

		return false;
	}

	private void insert(int data) {
		if(isFull()) {
			System.out.println("CQ is Full. So cannot insert " + data);
			return;
		} 

		CQ[REAR] = data;
		REAR = (REAR + 1) % CAPACITY;
		count++;
	}

	private void remove() {
		if(isEmpty()) {
			System.out.println("CQ is empty.");
			return;
		}

		System.out.println("Removed element : " + CQ[FRONT]);
		CQ[FRONT] = -1;
		FRONT = (FRONT + 1) % CAPACITY;
		System.out.println("FRONT after deleting " + FRONT);
		count--;
	}

	private void print() {
		if(isEmpty()) {
			System.out.println("CQ is empty. So cannot print any elements.");
			return;
		} 

		System.out.println("FRONT " + FRONT + " and REAR " + REAR + " and COUNT " + count);
		System.out.print("Elements in CQ are: ");

		int totalItems = 0;
		for(int i = FRONT; i < count && totalItems < count; ) {
			System.out.print(CQ[i] + " ");
			i = (i + 1) % CAPACITY;
			totalItems ++;
		}
		System.out.println();
	}

}