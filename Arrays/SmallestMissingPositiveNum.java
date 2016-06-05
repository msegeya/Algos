/**
	Question: Find the smallest positive number missing from an unsorted array in O(n).

	Reference:  http://www.programcreek.com/2014/05/leetcode-first-missing-positive-java/
				http://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/

	Logic-1: (Using HashMap. Can be done in O(n) but it takes space complexity of O(n))
		- Take a HashMap and store all the positive number of the array in it.
		- Now start with the first postive index number .. that is 1. Check whether it is there are not,
			- If there then check for the next numebr that is 2
			- Else return the number.

	Logic-2: (We will use the concept of Bucket Sort.)
		- First remove all the negative numbers and place all the positive numbers into the new array.
		- Bucket sort technique is nothing but to both the array index and the array value must me same.
		- For each element in the new Array,
			- See if the element can be within the range or not, that is whether element <= 0 or element >= array.length then break.
			- See if the element is same as its index then we no need to do anything. So break.
			- Else swap the element to its index position.
		- Finally return the index whose value is not same as its value.	
*/

class SmallestMissingPositiveNum {
	public static void main(String[] args) {
		// int[] array = {0, 10, 2, -10, -20}; // 1
		// int[] array = {3, 4, -1, 1}; // 2
		int[] array = {1, 2, 0}; // 3

		// Step-1: Segregate all <= 0 numbers to the start of the array.
		// Return the index where the positive number starts.
		int start = segregate(array);
		ArrayUtil.print(array, "Segregate Negative numbers to the left of the array: ");
		// System.out.println(start);

		// Step-2: Find the smallest positive missing number.
		int[] newArray = prepareMissingPositiveArray(array, start);
		ArrayUtil.print(newArray, "Print after using absolute of index: ");

		// Step-3: Finally get the index of the first positive number.
		for(int i = 0; i < newArray.length; i++) {
			if(newArray[i] != i + 1) {
				System.out.println("Missing number is = " + (i + 1));
				return;
			}
		}

		System.out.println("Missing number is = " + (newArray.length + 1));
	}

	public static int segregate(int[] array) {
		int j = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] <= 0) {
				ArrayUtil.swap(array, i, j);
				j++;
			}
		}

		return j;
	}

	public static int[] prepareMissingPositiveArray(int[] array, int start) {
		int[] newArray = new int[array.length - start];

		int j = 0;
		for(int i = start; i < array.length; i++) {
			newArray[j++] = array[i];
		}

		for(int i = 0; i < newArray.length; i++) {
			while(newArray[i] != i + 1) {
				
				// If the element gives index that is <= 0 or >= array length then break.
				if(newArray[i] <= 0 || newArray[i] >= newArray.length) {
					break;
				}

				// If the element is in the correct position that is index value is same as element value the break.
				if(newArray[i] == newArray[newArray[i] - 1]) {
					break;
				}

				// else swap the element at its index position.
				int temp = newArray[i];
				newArray[i] = newArray[temp - 1];
				newArray[temp - 1] = temp;
			}
		}

		return newArray;
	}

}