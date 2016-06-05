/**
	Question: Sort a nearly sorted (or K sorted) array. Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. 

	Reference: http://www.geeksforgeeks.org/nearly-sorted-algorithm/

	Logic-1: (Use Insertion Sort)
		- Insertion sort works well for almost sorted array.
		- Since the inner loop need to rotate almost k times our TC will be O(nk).

	Logic-2: (Use Heap)
		- Create a MIN heap with size k + 1.
		- Pop one element at a time and start adding new element for every poped element.
*/

import java.util.*;

class SortKSortedArray {
	public static void main(String[] args) {
		int[] array = {2, 6, 3, 12, 56, 8};
		int k = 3;

		Queue<Integer> queue = new PriorityQueue<Integer>(k);
		int[] result = new int[array.length];

		int i = 0;
		for(i = 0; i < k; i++) {
			queue.add(array[i]);
		}

		i = k;
		int j = 0;
		while(i < array.length) {
			if(!queue.isEmpty()) {
				result[j++] = queue.poll();
				queue.add(array[i]);
				i++;
			}
		}

		while(!queue.isEmpty()) {
			result[j++] = queue.poll();
		}

		ArrayUtil.print(result, "K sorted array result.");
	}
}