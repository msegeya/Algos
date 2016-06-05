/**
	Question: Find the first repeating element in an array of integers. Given an array of integers, find the first repeating element in it. We need to find the element that occurs more than once and whose index of first occurrence is smallest.

	Reference: http://www.geeksforgeeks.org/find-first-repeating-element-array-integers/

	Example: 
			arr[] = {10, 5, 3, 4, 3, 5, 6} // output = 5
			arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10} // 6

	Logic-1: (Using sorting.)
		- Copy all the element into an auxillary array.
		- Sort the auxillary array.
		- Now for every element in the original array count its element count in the auxillary array.
		- If count is > 1 then return that element.

	Logic-2: (Using Maps)
		- Start from the end and put each element in the Map.
		- For every element if the element is in the map then save(replace) that element as X.
		- Do this until you reach start of the array.
		- The last repeated element will be X. Return X.
*/

import java.util.*;

class FindFirstRepeatingElementInArray {
	public static void main(String[] args) {
		// int[] array = {10, 5, 3, 4, 3, 5, 6}; // 5
		int[] array = {6, 10, 5, 4, 9, 120, 4, 6, 10}; // 6

		System.out.println(findRepeatingEle(array));
	}

	public static int findRepeatingEle(int[] array) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int X = -1;
		for(int i = array.length - 1; i >= 0; i--) {
			if(null == map.get(array[i])) {
				map.put(array[i], 0);
			} else {
				X = array[i];
			}
		}
		return X;
	}
}