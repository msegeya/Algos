/**
	Question: Quick Sort --> O(nlogn)

	Refernce:  http://stackoverflow.com/a/1934004/967638
			   http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html

	When to use?
		- When you don't need a stable sort and average case performance matters more than worst case performance. A quick sort is O(N log N) on average, O(N^2) in the worst case. A good implementation uses O(log N) auxiliary storage in the form of stack space for recursion.
		- Quick sort is better than Merge sort it terms of space other than that both of them takes the same time complexity O(nlogn).

	Logic: 
		- Pick a pivot for safe case we will select the middle element as the pivot.
		- Elements less than pivot should be to the left of pivot position and similarly elements greater than pivot should be on right of pivot.
		- If there are any elements that are less or greater than pivot on the opposite side then swap them.
		- Do this until all are elements swapped.
*/

class QuickSort {

	private static int[] array;

	public static void main(String[] args) {
		System.out.println("******* Quick Sort ********");
		array = new int[6];
		array[0] = 23;
		array[1] = 42;
		array[2] = 4;
		array[3] = 16;
		array[4] = 8;
		array[5] = 15;
		SortUtil.print(array, SortUtil.BEFORE_SORTING);
		sort();
	}

	public static void sort() {
		int low = 0, high = array.length - 1;
		quickSort(low, high);
		SortUtil.print(array, SortUtil.AFTER_SORTING);
	}

	public static void quickSort(int low, int high) {
		int i = low; 
		int j = high;

		// pivot can be anything. To be simple let us consider it as middle element.
		int mid = low + (high - low) / 2;
		int pivot_element = array[mid]; 

		// elements less than the pivot should come to the left of pivot and others to right of the pivot.
		while(i <= j) {
			while(array[i] < pivot_element) {
				i++;
			}

			while(array[j] > pivot_element) {
				j--;
			}

			// if we find an element which is on the left but larger than the pivot then we need to move it to right of pivot.
			// Similarly any element right od pivot which is less than the pivot then we will move it to the left of pivot.
			// if i is less than j then there are some elements which are less than the pivot.
			if(i <= j) {
				array = SortUtil.swap(array, i, j);
				i++;
				j--;
			}			
		}

		// We need to do this until we are done with all the elements. Which means we need to sort remaining elements.
		// if low < j it means we haven't checked the pivot of this windows that is from (low to j)
		if(low < j) {
			quickSort(low, j);
		}

		// Similarly if i < high then we haven't checked the pivot of this window.
		if(i < high) {
			quickSort(i, high);
		}
	}
}