/**
	Question: Search an element in a sorted and rotated array
	An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.

	Reference: http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

	Example: Input = {3, 4, 5, 1, 2}

	Logic: (Using Binary Search. NOTE: This logic deos not work if array contains duplicates.)
		- If mid index is the ke then return.
		- If key is less than the mid index value then two choices,
			1) If key is >= array[low] and key < array[mid] then search on left of mid.
			2) Else search on right of mid.
		- If key is more than the mid index value then two choices,
			1) If key > array[mid] and key <= array[high] then search on right of mid.
			2) Else search on left of mid.
*/

class SearchSortedRotated {
	public static int search(int[] array, int key, int low, int high) {

		if(low > high) {
			return -1;
		}

		int mid = (low + high) / 2;

		if(array[mid] == key) {
			return mid;
		} else if(key < array[mid]) {
			if(key >= array[low] && key < array[mid]) {
				return search(array, key, low, mid - 1);
			} else {
				return search(array, key, mid + 1, high);
			}
		} else {
			if(key > array[mid] && key <= array[high]) {
				return search(array, key, mid + 1, high);
			} else {
				return search(array, key, low, mid - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {4, 5, 6, 7, 8, 9, 1, 2, 3};
		int key = 6;
		System.out.println("Element found at index " + search(array, key, 0, array.length -1));
	}
}