/**
	Questions: Sort an array according to the order defined by another array. Given two arrays A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those are in A2. For the elements not present in A2, append them at last in sorted order.
	
	Reference: http://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/

	Example: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8} and A2[] = {2, 1, 8, 3}
			 ==> {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}

	Logic: 
		- Store all the elements of the input array(the array we need to sort) to map along with its count.
		- Now for each base element check whether this element is in map or not,
			If yes, then print that element count number of times. And remove that element from map.
			If no, then goto next element.
		- Sort the remaining elements in the map and print them. 
		- Since the remaining elements need to be sorted we will take TreeMap.
*/

import java.util.*;

class SortArrayBasedOnAnotherArray {
	public static void main(String[] args) {
		int[] A = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		int[] B = {2, 1, 8, 3};

		ArrayUtil.print(A, "Input Array");
		ArrayUtil.print(B, "Base Array");

		printSortedArray(A, B);
	}

	public static void printSortedArray(int[] A, int[] B) {
		Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		for(int i = 0; i < A.length; i++) {
			if(null == treeMap.get(A[i])) {
				treeMap.put(A[i], 1);
			} else {
				int count = treeMap.get(A[i]);
				treeMap.put(A[i], ++count);
			}
		}

		for(int i = 0; i < B.length; i++) {
			if(null != treeMap.get(B[i])) {
				int count = treeMap.get(B[i]);
				while(count > 0) {
					System.out.print(B[i] + " ");
					count--;
				}
				treeMap.remove(B[i]);
			}
		}

		// print the remaining elements in sorted order.
		Set keySet = treeMap.entrySet();
		Iterator iter = keySet.iterator();
		while(iter.hasNext()) {
			Map.Entry keyValue = (Map.Entry) iter.next();
			int value = (Integer) keyValue.getValue();
			int key = (Integer) keyValue.getKey();
			while(value > 0) {
				value--;
				System.out.print(key + " ");
			}
		}
	}
}