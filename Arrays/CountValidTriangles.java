/**
	Question: Count the number of possible triangles. Given an unsorted array of positive integers. Find the number of triangles that can be formed with three different array elements as three sides of triangles. For a triangle to be possible from 3 values, the sum of any two values (or sides) must be greater than the third value (or third side).

	Example: {4, 6, 3, 7} ==> Output is 3. {3, 4, 6}, {4, 6, 7} and {3, 6, 7}.
	
	Logic: 
		- Sort the array.
		- Take 3 pointers. i, j, k. 
			where, i will be pointing to 0.
				   j will be pointing to i + 1
				   k will be pointing to i + 2
		- For every i, j, k check, array[i] + array[j] > array[k]
		- Increment the value of k if the above condition satisfies.
*/

import java.util.Arrays;

class CountValidTriangles {
	public static void main(String[] args) {
		// int[] array = {10, 21, 22, 100, 101, 200, 300}; // 6
		int[] array = {4, 6, 3, 7}; // 3


		// Step-1: Sort the array
		Arrays.sort(array);

		int count = 0;
		for(int i = 0; i < array.length - 2; i++) {
			int k = i + 2;
			for(int j = i + 1; j < array.length; j++) {

				// Fix i and j. k will be every element after j.
				while(k < array.length && array[i] + array[j] > array[k]) {
					++k;
				}

				// Since k starts after j. We need to subtract j from k to get the count for this pair combination.
				count += k - j - 1;
			}
		}

		System.out.println(count);
	}
}