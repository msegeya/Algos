/**
	Question: Find the maximum element in an array which is first increasing and then decreasing.

	Reference: http://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/

	Logic: (Use Binary Search)
		NOTE: This method works only for distinct numbers.
		- If the mid element is > mid + 1 element and mid > mid -1 element then return mid element. Simple it is maximum of both of its adjacent elements.
		- If the mid element is greater than the next element but smaller than the previous element then maximum lies on the left. {3, 50, 10, 9, 7, 6}
		- If the mid element is smaller than the next element but greater than the previous element then maximum lies on the right. {2, 4, 6, 8, 10, 3, 1}
*/

class MaxEleIncrAndDecr {
	public static void main(String[] args) {
		// int[] array = {1, 3, 50, 10, 9, 7, 6}; // 50
		// int[] array = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}; // 500
		// int[] array = {10, 20, 30, 40, 50}; // 50
		int[] array = {120, 100, 80, 20, 0}; // 120

		System.out.println(binarySearch(array, 0, array.length - 1));
	}

	public static int binarySearch(int[] array, int low, int high) {
		// If only one element is present then return that element.
		if(low == high) {
			return array[low];
		}

		// If we have only two elements and if the first element is >= second element.
		if(high == low + 1 && array[low] >= array[high]) {
			return array[low];
		}

		// If we have only two elements and if the second element is greater than the first element.
		if(high == low + 1 && array[low] < array[high]) {
			return array[high];
		}

		int mid = low + (high - low) / 2;
		if(array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
			return array[mid];
		}

		if(array[mid] > array[mid + 1] && array[mid] < array[mid - 1]) {
			return binarySearch(array, low, mid -1);
		} 

		return binarySearch(array, mid + 1, high);

	}
}