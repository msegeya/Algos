/**
	Question: Move all zeroes to end of array

	Reference: http://www.geeksforgeeks.org/move-zeroes-end-array/

	Logic: 
		- Take two pointers, start(0) and end(n - 1).
		- If end = 0 then end--.
		- If strat = 0 then swap start and end elements and then do start++ and end--.
		- Do this until start < end.
*/

class Move0sToEnd {
	public static void main(String[] args) {
		int[] array = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};

		int start = 0;
		int end = array.length - 1;

		while(start < end) {
			while(0 == array[end]) {
				end--;
			}

			while(array[start] != 0) {
				start++;
			}

			if(start < end) {
				array = ArrayUtil.swap(array, start, end);
				start++;
				end--;
			}
		}

		ArrayUtil.print(array, "After moving all the 0s to end.");
	}
}