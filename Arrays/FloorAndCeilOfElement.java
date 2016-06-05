/**
	Question: Floor and Ceil of a given element say x for a sorted array.
	Ceil of x is, the ceiling of x is the smallest element in array greater than or equal to x.
	Floor of x is, the floor is the greatest element smaller than or equal to x.

	Logic: (Using Binary Search)
		- Since they are sorted we can use Binary Search.
		- In Binary Search we get the place where the element actually fits.
		- So with this, if the element is present then return the element else return the previous and next indexes of the index(that is returned from Binary Search) such that it does not go out of bound.
*/

class FloorAndCeilOfElement {
	public static void main(String[] args) {
		int[] array = {1, 2, 8, 10, 10, 12, 19};
		int x = 11;
		// int x = 20;
		int index = binarySearch(array, x, 0, array.length - 1);
		System.out.println(" Index is " + index);
		if(index >= 0) {
			System.out.println("Ceil and Floor of number " + x + " is " + array[index]);
		} else {
			if(Math.abs(index) < 0 || Math.abs(index) >= array.length) {
				System.out.println("Ceil and Floor of number " + x + " does not exist.");
			} else {
				index = Math.abs(index);
				System.out.println("Ceil and Floor of number " + x + " is " + array[index - 1] + " and " + array[index - 2]);
			}
		}
	}

	public static int binarySearch(int[] array, int x, int low, int high) {
		if(low <= high) {
			int mid = low + (high - low) / 2;

			if(x > array[mid]) {
				return binarySearch(array, x, mid + 1, high);
			} else if(x < array[mid]) {
				return binarySearch(array, x, low, mid - 1);
			} else {
				return mid;
			}
		}

		return -(low + 1);
	}

}