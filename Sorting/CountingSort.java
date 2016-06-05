/**
	Question: Counting Sort. Often times we don't always have to sort the elements. Example consider a file directory and suppose we want to sort all the file names according to their size. If we only sort the file sizes then we don't know to which file names this size belongs to.
	In these kinda situations Counting Sort helps where we actually don't sort the data with the actual content but do it on their references.

	Reference:  https://www.youtube.com/watch?v=TTnvXY82dtM
				http://www.javacodex.com/Sorting/Counting-Sort

	Logic:
		- First find min and max in the array. This takes O(n)
		- Create a count array where we keep the frequency of each element. It's size will be equal to (max - min + 1)
		- For each frequency sum it will the frequencies to its left.
		- Finally start from the end fill the sorted array according to the frequency count.
*/

class CountingSort {
	public static void main(String[] args) {
		int[] array = {10, 7, 12, 4, 9, 13}; 
		// int[] array = {54, 67, 13, 24, 76, 37, 97, 10, 67, 24, 6, 28, 5, 19, 63, 1, 71, 83, 97, 24};
		print(array, null);

		doCountingSort(array);
	}

	public static void doCountingSort(int[] array) {

		// Step-1: Find min and max in the array.
		int min = array[0];
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}

			if(array[i] > max) {
				max = array[i];
			}
		}

		// Step-2: Create an array with this range.
		int range = max - min + 1;
		System.out.println("Max = " + max + " Min = " + min + " Range = " + range);
		int[] count = new int[range];

		// Step-3: Count the frequencey of each element.
		for(int i = 0; i < array.length; i++) {
			count[array[i] - min]++;
		}
		print(count, "Counting Sort: After frequency calculation");

		// Step-4: For each frequency get the sum of its previous frequencies.
		for(int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		print(count, "Counting Sort: After frequency sum");

		// Step-5: Finally put the elements in the sorted order.
		// Start from the end. 
		// Their (frequency - 1) will be the index of the element in the sorted order.
		int[] output = new int[array.length];
		for(int i = array.length - 1; i >= 0; i--) {
			output[ --count[array[i] - min] ] = array[i];
		}
		print(output, "Counting Sort: Finally Sorting");		
	}

	public static void print(int[] array, String msg) {
		if(null == msg) {
			msg = "Array is: ";
		}

		System.out.println(msg);
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println();
	}
}