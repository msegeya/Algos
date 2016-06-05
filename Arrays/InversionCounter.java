/**
	Question: Count inversions in an array.
	Description: Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

	Reference: http://www.geeksforgeeks.org/counting-inversions/

	Logic -1: (Using Insertion Sort .. O(n^2))
		- For each insertion in to the sorted array check where it fits.
		- For each check increment the count.
		- Return the sum of count of all the elements.

	Logic - 2: (Using Merge Sort .. O(nlogn))
		- We will do usual merge sort.
		- When ever a element is less than the elements of its right we just copy that element and proceed to next element.
		- But when the element is less than its right elements then our inversion count will be (mid - i). Since the left half and right half are sorted so all the elements in the left sub array which are on the right of the current element will be definetly less than our element on right sub array. So add this to inversion count.
*/

class InversionCounter {
	public static void main(String[] args) {
		// int[] array = {1, 20, 6, 4, 5}; // o/p: 5. (20 is > 6, 4, 5) (6 is > 4, 5)

		int[] array = {2, 4, 1, 3, 5}; // o/p: 3. (2 is > 1) (4 is > 1, 3)

		System.out.println(getInversionCount(array));
	}

	public static int getInversionCount(int[] array) {
		int[] helper = new int[array.length];
		return mergeSort(array, helper, 0, array.length - 1);
	} 

	public static int mergeSort(int[] array, int[] helper, int low, int high) {
		int inver_count = 0;

		if(low < high) {
			int mid = low + (high - low) / 2;

			inver_count += mergeSort(array, helper, low, mid);
			inver_count += mergeSort(array, helper, mid + 1, high);
			inver_count += merge(array, helper, low, mid + 1, high);
		}

		return inver_count;
	}

	public static int merge(int[] array, int[] helper, int low, int mid, int high) {
		int inver_count = 0;
		int i = low;
		int j = mid;
		int k = low;

		while(i < mid && j <= high) {
			if(array[i] <= array[j]) {
				helper[k] = array[i];
				i++;
				k++;
			} else {
				helper[k] = array[j];
				k++;
				j++;

				inver_count += (mid - i);
			}
		}

		while(i < mid) {
			helper[k] = array[i];
			k++;
			i++;
		}

		while(j <= high) {
			helper[k] = array[j];
			k++;
			j++;
		}

		for(i = low; i <= high; i++) {
			array[i] = helper[i];
		}

		return inver_count;
	}
}