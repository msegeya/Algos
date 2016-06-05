/**
	Question: Median of stream of numbers.

	Reference:  http://stackoverflow.com/questions/10657503/find-running-median-from-a-stream-of-integers
				https://gist.github.com/Vedrana/3675434

	Logic: 
		- Take two heaps max heap and min heap.
		- For each element we need to adjust the elements in both the heaps in such a way that all the minimum elements push into the MAX heap and all the maximum elements pushed into MIN heap.
		- Finally if the count of elements is odd then return the root of MAX heap else return the average of Max and Min heap root values.
*/

import java.util.*;

public class MedianOfIntegerStream {

	public Queue<Integer> maxHeap;
	public Queue<Integer> minHeap;
	public int numOfElements;

	public MedianOfIntegerStream() {
		maxHeap = new PriorityQueue<Integer>(10, new ReverseIntergerSort());
		minHeap = new PriorityQueue<Integer>();
	}

	public static void main(String[] args) {
		MedianOfIntegerStream mis = new MedianOfIntegerStream();
		int[] array = {1, 5, 10, 12, 2};

		for(int item : array) {
			mis.addToStream(item);
		}

		System.out.println(mis.getMedian());
	}

	public void addToStream(int num) {
		maxHeap.add(num);

		// if the count is even
		if(numOfElements % 2 == 0) {
			// If this is the first element. Then min heap will be empty so just increment the count and return.
			// If this is not the first element then if the root of max heap is greater than root of min heap then swap them.
			// In simple we are getting all the minimum elements on MAX heap and all maximum elements on MIN heap.
			if(minHeap.isEmpty()) {
				numOfElements++;
				return;
			} else if(maxHeap.peek() > minHeap.peek()) {
				int maxHeapRoot = maxHeap.poll();
				int minHeapRoot = minHeap.poll();

				maxHeap.add(minHeapRoot);
				minHeap.add(maxHeapRoot);
			}
		} else {
			minHeap.add(maxHeap.poll());
		}

		numOfElements++;
	}

	public double getMedian() {
		if(numOfElements % 2 == 0) {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			return (double) maxHeap.peek();
		}
	}

}

class ReverseIntergerSort implements Comparator<Integer> {
	public int compare(Integer i1, Integer i2) {
		return i2 - i1;
	}
}