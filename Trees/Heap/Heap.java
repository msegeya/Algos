/**
	Question: Heap tree implementation. In this case we will implement MAX-HEAP.

	Reference: Karumanchi

	Logic:
	   #) Insertion: (MAX_HEAP)
	   	  - First insert the data at the end of the array and increment index.
	   	  - Now we need to check whether the parent of this index is > current index value or not.
	   	  - If yes then insertion is in the correct position else heapifyUp. Check percolateUp method.

	   #) percolateUp: (MAX_HEAP)
	   	  - Check if the parent position (index - 1)/2 is having value greater than or less than. If greater than its okay since as it is MAX-HEAP. But if minimum then we need to exchange the postions.
		
	   #) Delete: 
	   		- First swap the root with the last element in the array.
	   		- Delete the last index value.
	   		- percolate down starting from root that is from index 0.

	   #) percolateDown:
	   		- For every root node check whether its left and right node elements are less than the root node value.
	   		- Out of the root, left right check the max element and swap it to the root.
	   		- Do the same for all the nodes.
*/

class Heap {

	public static int index;
	public static int[] heap = new int[10];
	
	public static void main(String[] args) {
		int[] input = {24, 6, 28, 5, 63, 19, 94};

		for(int data : input) {
			insert(data);
			print();
		}
	}

	/* MAX_HEAP Implementation */
	public static void insert(int data) {
		if(index == 0) {
			heap[index] = data;
			index++;
			return;
		} else {
			heap[index] = data;
			index++;
			percolateUp(index - 1);
		}
	}

	/* We can't delete any particular element. We can delete only the root element. */
	public int delete() {
		int temp = heap[0];
		heap[0] = heap[index - 1]; // last element
		heap[index - 1] = temp;

		// reduce the actual array size of elements.
		index--; 

		// Re adjust all the root node elements if necessary such that all of them satisfy heap property.
		percolateDown(0);

		// return the deleted node.
		return temp;
	}

	/* MAX_HEAP. Maximum value will be at the top. */
	public static void percolateUp(int childIndex) {
		int insertedValue = heap[childIndex];

		while(childIndex > 0 && insertedValue > heap[getParentIndex(childIndex)]) {
			heap[childIndex] = heap[getParentIndex(childIndex)];
			childIndex = getParentIndex(childIndex);
		}

		// finally we will make the insertedValue to its correct postion.
		heap[childIndex] = insertedValue;
	}

	public static int getParentIndex(int i) {
		return (i - 1) / 2;
	}

	public static void print() {
		for(int i = 0; i < index; i++) {
			System.out.print(heap[i] + "\t");
		}
		System.out.println();
	}

	public void percolateDown(int i) {
		int max_index = Integer.MIN_VALUE;		

		int lc = leftChild(i);
		int rc = rightChild(i);

		// If left child is greater than root then root should be left child.
		// Else index will still be the root index.
		if(lc != -1 && heap[lc] > heap[i]) {
			max_index = lc; 
		} else {
			max_index = i;
		}

		// If right child is greater than both left and root then mark right child index as max_index.
		if(rc != -1 && heap[rc] > heap[max_index]) {
			max_index = rc;
		}

		// If i and max_index are not same then we must swap.
		if(max_index != i) {
			int temp = heap[i];
			heap[i] = heap[max_index];
			heap[max_index] = temp;

			// If the index changes then we need to go down and doo the same for all the root nodes.
			percolateDown(max_index);
		} 
	}

	public int leftChild(int i) {
		if(i < 0 && i >= heap.length) {
			return -1;
		}

		return 2 * i + 1;
	}

	public int rightChild(int i) {
		if(i < 0 && i >= heap.length) {
			return -1;
		}

		return 2 * i + 2;
	}
}