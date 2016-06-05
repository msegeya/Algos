/**
	Question: Find the minimum distance between two numbers.
	Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. The array might also contain duplicates. You may assume that both x and y are different and present in arr[].

	Reference: http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/

	Logic: 
		- Start from 0 and see whether you can find either x or y. Call the index as prev.

*/

class MinDistOfTwoEle {
	public static void main(String[] args) {
		int[] array = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3}; // 1 (3 at index )
		int x = 3;
    	int y = 6;

    	System.out.println("The min distance between " + x + " and " + y + " is " + getMinDist(array, x, y));
	}

	public static int getMinDist(int[] array, int x, int y) {
		int i = 0;
		int prevIndex = -1;
		int diff = Integer.MAX_VALUE;

		for(; i < array.length; i++) {
			if(array[i] == x || array[i] == y) {
				prevIndex = i;
				break;
			}
		}

		// System.out.println(i);
		i++;
		for(; i < array.length; i++) {
			if(array[i] == x && array[prevIndex] == y || array[i] == y && array[prevIndex] == x) {
				if(i - prevIndex < diff) {
					diff = i - prevIndex;

					// NOTE: Now update this previous index to i. Since this is the new element that is encountered.
					prevIndex = i;
				}
			} else if(array[i] == x && array[prevIndex] == x || array[i] == y && array[prevIndex] == y) {
				prevIndex = i;
			}
		}

		return diff;
	}
}