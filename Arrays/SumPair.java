/**
	Question: Given sum find pair of elements.

	Logic: 
		1. Sort the array.
		2. Two pointer, i will start from 0 and j will start from last.
		3. If (array[i] and array[j] == sum) then print the elements.
		4. If (array[i] + array[j] < sum) then i++;
		5. If (array[i] + array[j] > sum) then j--;
*/

import java.util.*;

class SumPair {
	public void sumPair(int[] array, int sum) {
		Arrays.sort(array);

		int i = 0, j = array.length - 1;

		while(i < array.length && j >= 0) {
			if(array[i] + array[j] == sum) {
				System.out.println("Pair " + array[i] + " and " + array[j] + " will form sum " + sum);
				break;
			} else if(array[i] + array[j] > sum) {
				j--;
			} else if(array[i] + array[j] < sum) {
				i++;
			}
		}
	}
}