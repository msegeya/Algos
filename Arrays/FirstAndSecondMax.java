/**
	Question: Find the smallest and second smallest element in an array

	Reference:  Own Implementation
				http://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/

	Logic: 
		- Similar to finding max of a array.
		- If you find element greater than max then make the current max as second max and the current element as max.
*/

class FirstAndSecondMax {
	public static void main(String[] args) {
		int[] array = {12, 13, 1, 10, 34, 1};

		int max_1 = array[0];
		int max_2 = array[0];

		for(int i = 1; i < array.length; i++) {
			if(max_1 < array[i]) {
				max_2 = max_1;
				max_1 = array[i];
			}
		}

		System.out.println(max_1 + " " + max_2);
	}
}