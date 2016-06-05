/**
	Question: Majority Element. An element which appears more than n/2 times.

	Reference: http://www.geeksforgeeks.org/majority-element/

	Logic-1:
		- Sort the array .. O(nlogn)
		- Now take the first element and traverse the array and see what is the next element. If the next element is same as current element then increment count. If not same then reset the count value to 1.
		- Return the element which has count >= than n/2;

	Logic-2: (Using Moore's Voting Algorithm) .. O(n)
		- The algorithm for first phase that works in O(n) is known as Moore’s Voting Algorithm. Basic idea of the algorithm is if we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority element.
*/

import java.util.*;

class MajorityElement {
	public static void majEle(int[] array) {
		int count = 1;
		int max = array.length/2;

		Arrays.sort(array);

		for(int i = 1; i < array.length; i++) {
			if(array[i] == array[i - 1]) {
				count++;

				if(count >= max) {
					System.out.println(array[i]);
					break;
				}
			} else {
				count = 1;
			}
		}
	}

	public static int mooresAlgo(int[] array) {
		// used to track the majority element.
		int count = 0;
		// result holds the majority element.
		int result = 0;

		for(int i = 0; i < array.length; i++) {
			if(0 == count) {
				result = array[i];
				count = 1;
			} else if(result == array[i]) {
				count++;
			} else {
				count--;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] array = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		majEle(array);
		System.out.println("Moore's Majority Element: " + mooresAlgo(array));
	}
}