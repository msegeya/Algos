/**
	Question: Maximum of all subarrays of size k.

	Example: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
			 k = 3
			 Output: 3 3 4 5 5 5 6

	Logic:
		In simple, Place the max element of each sub array at the start of the deque and for each window deque it from the queue.
		- Push the first element INDEX into the queue.
		- From now for every element within the window check whether the current is greater than the deque element. If so then remove it.
		- Remove the indices that are not in the range of the window indices.
*/
import java.util.Deque;
import java.util.LinkedList;

class MaxOfEachSubArray {
	public static void main(String[] args) {
		int[] array = {12, 1, 78, 90, 57, 89, 56};
		int w = 3;

		// We will store indices not actual values.
		Deque<Integer> deque = new LinkedList<Integer>();
		int i = 0;
		int each_max = Integer.MIN_VALUE;

		// for the 1st window find the max an keep it in the queue.
		// If the current element is greater than the previous elements then delete those elements.
		// This happens only for that particualr window.
		while(i < w) {
			while(!deque.isEmpty() && array[i] >= array[deque.getLast()]) {
				deque.removeLast();
			}

			deque.addLast(i);
			i++;
		}

		// To store max element indices of each window.
		int[] maxIndices = new int[array.length - w + 1];
		int k = 0;

		for(i = w; i < array.length; i++) {
			maxIndices[k++] = deque.getFirst();

			// To remove all the existing minimum elements in the queue.
			while(!deque.isEmpty() && array[i] >= array[deque.getLast()]) {
				deque.removeLast();
			}

			// If there is no min element than current and if the queue is having indices
			// other than the window then delete them.
			while(!deque.isEmpty() && deque.peek() <= i - w) {
				deque.removeFirst();
			}

			deque.addLast(i);
		}

		maxIndices[k] = deque.removeFirst();
		
		for(int j = 0; j < maxIndices.length; j++) {
			System.out.print(array[maxIndices[j]] + "\t");
		}
	}
}