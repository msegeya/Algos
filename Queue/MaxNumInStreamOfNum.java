/**
	Question: Given a stream of numbers say n. Given a window say w. Find the maximum number for each window where the total time complexity for n numbers
				is O(n).

	Reference: http://articles.leetcode.com/sliding-window-maximum/


	Logic - 1: 
		- Immediately Heap comes into thought. We construct a heap for each window and find the maximum/minum element.
		- This logic works but takes time O(klogn) where k is the number of windows.

	Logic - 2: 
		- If you analyse it you will come to know at a time only 4 elements are present and after that for each number one element will be pushed. Such that we have to remove the oldest element that is the element that is inserted first of this window. 
		So we need to do operations from both ends i,e., insert at the last and delete at the first. 
		==> This gives us an idea about "Double Ended Queue".

		NOTE: As said above we no need to have 4 elements all the time in the deque we just need the maximum of the four elements.

		- Logic goes as follows,
			#) Insert first 'w' element's index of the stream in to the queue such that if any element is larger than the queue's back elements then remove them until queue is empty or the last element is greater than the current element.
*/

import java.util.*;

class MaxNumInStreamOfNum {
	public static void main(String[] args) {
		int[] stream = {60, 40, 20, 3, 2, 55, 29, 43, 79, 81, 64};
		int w  = 4;

		// NOTE: We are pushing indices not the actual values.
		Deque<Integer> deque = new LinkedList<Integer>();

		for(int i = 0; i < w; i++) {
			int current = stream[i];
			// if the current element is >= deque back elements then remove them and finally push the current's index to deque.
			while(!deque.isEmpty() && current >= stream[deque.getLast()]) {
				deque.removeLast();
			}

			deque.addLast(i);

		}	
		int[] pickedIndices = new int[stream.length - w + 1];
		int k = 0;
			
		for(int i = w; i < stream.length; i++) {
			pickedIndices[k++] = deque.getFirst();

			int current = stream[i];
			// similar to above logic. Just remove the elments that are lesser than the current element.
			while(!deque.isEmpty() && current >= stream[deque.getLast()]) {
				deque.removeLast();
			}

			// If the new element is not greater than the current and the queue already has a count of window elements
			while(!deque.isEmpty() && deque.peek() <= i - w) {
				deque.removeFirst();
			}

			deque.addLast(i);
		}	

		// finally add the last window maximum element.
		pickedIndices[k] = deque.removeFirst();

		for(int i = 0; i < pickedIndices.length; i++) {
			System.out.print(stream[pickedIndices[i]] + "\t");
		}
	}
}