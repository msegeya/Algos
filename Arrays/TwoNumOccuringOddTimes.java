/**
	Question: Find the two numbers with odd occurrences in an unsorted array. Given an unsorted array that contains even number of occurrences for all numbers except two numbers. Find the two numbers which have odd occurrences in O(n) time complexity and O(1) extra space.

	Reference: http://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/

	Logic: 
		- First do xor of all the elements in the array. => We will get xor of the two odd elements. For the below example the result(in binary) will be xor2 = 100 (4) => (The two odd elements are 5 and 1 => xor of 5 and 1 => 101 ^ 001 => 100 (4))
		- Every set bit that is every "1" in the xor result "100" indicates that the corresponding bits in x and y are different.
		- Now we need to pick up one set-bit (pick any "1") from the result. It is easy to pickup the right-most set-bit of a number. To get the right most set bit we use the logic as, int set_bit_num = xor2 & ~(xor2 - 1);
		- If we do XOR of all those elements which have corresponding bit-set as 1 then we get one "odd element"
		- If we do XOR of all those elements which have corresponding bit-set as 1 then we get another "odd element"	
*/

class TwoNumOccuringOddTimes {
	public static void main(String[] args) {
		int[] array = {4, 2, 4, 5, 2, 3, 3, 1}; // 5 and 1

		int xor2 = array[0];
		for(int i = 1; i < array.length; i++) {
			xor2 = xor2 ^ array[i];
		}

		System.out.println("We have two numbers with odd count and their xor will be " + xor2);
		System.out.println("XOR2 Binary Value is = " + Integer.toBinaryString(xor2));

		// to get the right most set bit.
		int set_bit_num = xor2 & ~(xor2 - 1);

		int first_num = 0;
		int second_num = 0;
		for(int i = 0; i < array.length; i++) {

			// bit-wise AND with set-bit which result in 1 - first odd number
			// bit-wise AND with set-bit which result in 0 - second odd number
			if((array[i] & set_bit_num) != 0) {
				first_num = first_num ^ array[i];
			} else {
				second_num = second_num ^ array[i];
			}
		}

		System.out.println("Two odd count numbers = " + first_num + " and " + second_num);
	}
}