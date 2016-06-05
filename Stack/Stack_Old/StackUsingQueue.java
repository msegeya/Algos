/**
	Question: Implement stack using two queues.

	Reference: http://stackoverflow.com/questions/688276/implement-stack-using-two-queues

	Logic: 
		- For Push, use Queue-1.
		- For Pop, 
				1) while size of Queue-1 is bigger than 1 then dequeue items from Queue-1 to Queue-2.
				2) From Queue-1, Dequeue and return the last element then switch the names of Queue-1 and Queue-2.
*/

import java.util.*;

class StackUsingQueue {

	Stack<Integer> stack = new Stack<Integer>();
	Queue<Integer> queue_1 = new LinkedList<Integer>();
	Queue<Integer> queue_2 = new LinkedList<Integer>();

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 5};
		StackUsingQueue sqObj = new StackUsingQueue();

		sqObj.createStack(input);
		
		sqObj.printStack("Stack Elements: ");
		sqObj.printQueue("Queue Elements: ");

		for(int item : input) {
			sqObj.pushItemToQue(item);
		}

		for(int item : input) {
			sqObj.popItemStkNQue();
		}
	}

	public void createStack(int[] input) {
		for(int item : input) {
			stack.push(item);
		}
	}

	public void pushItemToQue(int item) {
		queue_1.add(item);
	}

	public void popItemStkNQue() {
		if(stack != null && !stack.isEmpty()) {
			int poppedEle = stack.pop();
			System.out.println("Stack Popped Element is: " + poppedEle);
		}

		while(queue_1 != null && queue_1.size() > 1) {
			queue_2.add(queue_1.remove());
		}

		if(queue_1 != null && queue_1.size() == 1) {
			int poppedEle = queue_1.remove();
			System.out.println("Queue Popped Element is: " + poppedEle);

			Queue<Integer> tempQueue = queue_1;
			queue_1 = queue_2;
			queue_2 = tempQueue;
		}
	}

	public void printStack(String msg) {
		System.out.println(msg);
		Iterator<Integer> iter = stack.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}

	public void printQueue(String msg) {
		if(queue_1 != null) {
			System.out.println(msg);
			Iterator<Integer> iter = queue_1.iterator();
			while(iter.hasNext()) {
				System.out.print(iter.next() + " ");
			}
			System.out.println();
		} else {
			System.out.println("No Elements in Queue_1.");			
		}
	}	

}