/**
	Question: Given K sorted arrays each of size N. Merge them to a single sorted array.
	
	Reference: http://www.geeksforgeeks.org/merge-k-sorted-arrays/
	
	Logic: 
		- Create output array of size n * k.
		- Create a heap of size K. Take each element from all the arrays and put them into the heap. Delete the root of the heap and keep track from which array you have picked up. Increment the pointer of that array.
		- Do this until all the arrays are completly scanned.
		- If at any point any array is completed then push MAX_VALUE in to the heap on behalf of that array.
		- Now, inorder to keep track of the array from which each element in the heap belongs to we will use a class to save the information.

		class element {
			int data;
			int index; // at what index
			int array; // in which array 
		}

	Time Complexity: O(nklognk)
	Space Complexity: O(nK) for output array and O(k) for heap.
*/

import java.util.*;

class Element {
	public int data;
	public int index;
	public int array;

	public Element(int data, int index, int array) {
		this.data = data;
		this.index = index;
		this.array = array;
	}
}

class ElementSort implements Comparator<Element> {
	@Override
	public int compare(Element e1, Element e2) {
		return e1.data - e2.data;
	}
}

class MergekSortedArrays {

	public int[][] input =  {
							{1, 3, 5, 7},
							{2, 4, 6, 8},
							{0, 9, 10, 11}
						};

	public int[] output;

	// k is the number of arrays
	public int k;

	// n is the number of elements in an array
	public int n;

	public ElementSort elementSort;

	public PriorityQueue<Element> pq;

	// to check whether all the elements of each array are completed or not.
	private boolean[] arrayEnd; 

	public static void main(String[] args) {
		MergekSortedArrays mksaObj = new MergekSortedArrays();
		mksaObj.initialize();

		mksaObj.sort();

		mksaObj.print();
	}

	public void initialize() {
		k = input.length;
		n = input[0].length;

		output = new int[n * k];

		elementSort = new ElementSort();

		pq = new PriorityQueue<Element>(k, elementSort);

		pq.add(new Element(input[0][0], 0, 0));
		pq.add(new Element(input[1][0], 0, 1));
		pq.add(new Element(input[2][0], 0, 2));

		arrayEnd = new boolean[k];
	}

	public void sort() {
		int index = 0;
		while(!arrayEnd[0] || !arrayEnd[1] || !arrayEnd[2]) {
			Element e = pq.poll();
			output[index++] = e.data;
			pq.add(getNextEle(e));
		}
	}

	public Element getNextEle(Element e) {
		int nextIndex = e.index + 1;
		int nextArray = e.array;

		if(nextIndex >= input[nextArray].length) {
			arrayEnd[nextArray] = true;
			return new Element(Integer.MAX_VALUE, -1, -1);
		} else {
			return new Element(input[nextArray][nextIndex], nextIndex, nextArray);
		}
	}

	/* You can also iterate. But if you iterate without using poll then you may or may not get the sorted order. */
	public void print() {
		// Iterator<Element> iter = pq.iterator();
		// while(iter.hasNext()) { System.out.println(iter.next().data); }

		// while(!pq.isEmpty()) { System.out.println(pq.poll().data); }

		for(int data : output) {
			System.out.print(data + "\t");
		}
	}

}