/**
	Question: Insertion Sort --> O(n^2)

	Reference: https://www.youtube.com/watch?v=DFG-XuyPYUQ

	When to use?
		Although it is one of the elementary sorting algorithms with O(n^2) worst-case time, insertion sort is the algorithm of choice either when the data is nearly sorted (because it is adaptive) or when the problem size is small (because it has low overhead).

	Logic: 
		- Divide the element in to two groups Sorted and Unsorted.
		- Sorted group has one element that is the first element and remaining are in Unsorted group.
		- Take each element from Unsorted group and place it in sorted group starting from the right most of the sorted group index. You need to do the following while inseting it into sorted group,
			1) Compare the last element of sorted group and see if it is less or greater than it. If greater then come out of the loop. Since the sorted group is already sorted so one element is enough to check.
			2) If the right most element is small then move the right most element one step up and compare our element with the next element in the sorted group.
			3) Finally place the element in the position where the element to left of it are smaller than it and the elements to the right of it are greater than it.
*/

class InsertionSort {
	public static void main(String[] args) {
		System.out.println("******* Insertion Sort ********");
		int[] array = {23, 42, 4, 16, 8, 15};
		SortUtil.print(array, SortUtil.BEFORE_SORTING);
		sort(array);
	}

	static void sort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j;
			for(j = i - 1; j >= 0 && temp < array[j]; j--) {
				// don't swap them. Just move the largest one to a step right.
				array[j + 1] = array[j];
				SortUtil.print(array);
			}
			array[j + 1] = temp;
		}

		SortUtil.print(array, SortUtil.AFTER_SORTING);
	}
}