/**
	Question: Selection Sort --> O(n^2)

	Reference:  https://www.youtube.com/watch?v=Aq2E47uU2ao
				http://javahungry.blogspot.com/2013/06/java-sorting-program-code-selection-sort.html

	When to use? 
		One advantage of selection sort is that it requires only  n  write operations.  If we have a system where write operations are extremely expensive and read operations are not, then selection sort could be ideal.

	Logic: 
		- If we have n elements then we need to have (n - 1) iterations.
		- For each iteration get the minimum element and swap the element with the current iteration position.
*/

class SelectionSort {
	public static void main(String[] args) {
		System.out.println("******* Selection Sort ********");
		int[] array = {23, 42, 4, 16, 8, 15};
		SortUtil.print(array, SortUtil.BEFORE_SORTING);
		sort(array);
	}

	public static void sort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int min_pos = i;

			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[min_pos]) {
					min_pos = j;
				}
			}
			array = SortUtil.swap(array, min_pos, i);
		}

		SortUtil.print(array, SortUtil.AFTER_SORTING);
	}
}