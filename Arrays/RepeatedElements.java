/**
	Question: Find duplicates in O(n) time and O(1) extra space

	Reference: http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/

	NOTE: This solution only works if the values are present within the index range.

	Logic: 
		- Get the absolute value of the element and then get the value of this absolute value in the index and make it negative.
		- So next time when you see the same value and if it is negative then the number is repeated.
*/

class RepeatedElements {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 1, 3, 6, 6}; // output: missing is 5 and repeated is 6

		for(int i = 0; i < array.length; i++) {
			if(array[Math.abs(array[i])] > 0) {
				array[Math.abs(array[i])] = - array[Math.abs(array[i])];
			} else {
				System.out.println(Math.abs(array[i]) + " is repeated.");
			}
		}
	}
}