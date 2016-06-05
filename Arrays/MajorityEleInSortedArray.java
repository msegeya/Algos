/**
	Question: Write a C function to find if a given integer x appears more than n/2 times in a sorted array of n integers.
	
	Reference: http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/

	Input: arr[] = {1, 2, 3, 3, 3, 3, 10}, x = 3 output should be true/false
*/

class MajorityEleInSortedArray {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 3, 3, 3, 10};
		int x = 2; // false
		// int x = 3; // true

		int index = bSearch(array, x, 0, array.length - 1);

		if(index < 0) {
			System.out.println("No such element.");
		} else {
			// since the element exist so we will have the count as 1. 
			// Search to the left and right of the index to check whether the element has count n/2 or not.
			int count = 1;

			int left = index - 1;
			while(left >= 0) {
				if(x == array[left] && count < array.length / 2) {
					count++;
				} else {
					break;
				}
			}

			if(count == array.length / 2) {
				System.out.println(x + " is the Majority element.");
				return;
			}

			int right = index + 1;
			while(right < array.length) {
				if(x == array[right] && count < array.length / 2) {
					count++;
				} else {
					break;
				}
			}

			if(count == array.length / 2) {
				System.out.println(x + " is the Majority element.");
				return;
			}

			System.out.println(x + " is not a Majority number.");
		}
	}

	public static int bSearch(int[] array, int x, int low, int high) {
		if(low < high) {
			int mid = low + (high - low) / 2;

			if(x > array[mid]) {
				return bSearch(array, x, mid + 1, high);
			} else if(x < array[mid]) {
				return bSearch(array, x, low, mid - 1);
			}

			return mid;
		}

		return -(low + 1);
	}

}