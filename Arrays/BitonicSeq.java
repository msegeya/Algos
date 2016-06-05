/**
	Question: A Bitonic Sequence is nothing but a longest sequence which first increases and then decreases.

	Reference:  http://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
				https://www.youtube.com/watch?v=TWHytKnOPaQ

	Logic: 
		- Take two arrays inc[] and dec[].
		- For inc[] for every element to the left of it, if the current element is greater than the previous element then inc[i] = inc[i -1] + 1
		- For dec[] for every element to the right of it, if the current element is greater than to its right then dec[i] = dec[i + 1] + 1
		- Finally take the sum of the numbers at their respective indeices in both inc[] and dec[] and also do -1 for this.
		- Get the max of the sum.
*/

import java.util.Arrays;

class BitonicSeq {
	public static void main(String[] args) {
		int[] array = {12, 4, 78, 90, 45, 23};

		// initialize two arrays.
		int[] inc = new int[array.length];
		int[] dec = new int[array.length];

		inc[0] = 1;
		dec[array.length - 1] = 1;

		for(int i = 1; i < inc.length; i++) {
			inc[i] = (array[i] > array[i - 1]) ? inc[i - 1] + 1 : 1;
		}
		ArrayUtil.print(inc, "Inc Array");

		for(int i = dec.length - 2; i >= 0; i--) {
			dec[i] = (array[i] > array[i + 1]) ? dec[i + 1] + 1 : 1;
		}
		ArrayUtil.print(dec, "Dec Array");


		// for getting the max bitonic values add both inc and dec for their respective indices and return the max value.
		int max = -1;
		for(int i = 0; i < array.length; i++) {
			int sum = inc[i] + dec[i] - 1;
			if(sum > max) {
				max = sum;
			}
		}

		System.out.println("max Bitonic Sequence is = " + max);
	}
}