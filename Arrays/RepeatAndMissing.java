/**
	Question: Find the repeating and the missing. Given an unsorted array of size n. Array elements are in range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in array. Find these two numbers.

	Reference: http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
	
	Example: int[] = {3, 1, 3}
  			 Output: 2, 3

  			 arr[] = {4, 3, 6, 2, 1, 1}
  			 Output: 1, 5 	 
	
	NOTE: In simple, you can sort the array and find the missing and repeating elements. Will take O(nlogn)

	Logic: O(n)
		- We will use RepeatedElements.java for finding repeating elements.
		- For missing element we will traverse the array and return the first positive index element.
*/

class RepeatAndMissing {
	public static void main(String[] args) {

		int[] array = {4, 3, 6, 2, 1, 1};

		for(int i = 0; i < array.length; i++) {
			int element = array[Math.abs(array[i]) - 1];
			if(element > 0) {
				array[Math.abs(array[i]) - 1] = -element;
			} else {
				System.out.println("Repeated element is " + Math.abs(array[i]));
			}
		}

		// now traverse the array and find the index of the positive number.
		// After getting the index increment the index and print it.
		for(int i = 0; i < array.length; i++) {
			if(array[i] > 0) {
				System.out.println("Missing number is = " + (i + 1));
			}
		}
	}
}