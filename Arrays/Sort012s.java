/**
	Question: Sort arrays of 0's, 1's, 2's.

	Reference: http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

	Logic: 
		- Use Dutch National Flag Algorithm
		- If you encounter any 0 then push it to front.
		- If you see any 1 then leave it.
		- If you see any 2 then push it to the last.

*/

class Sort012s {
	public static void main(String[] args) {
		int[] array = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

		ArrayUtil.print(array, "Before Sorting: ");

		array = dutchNationalAlgo(array);

		ArrayUtil.print(array, "After sorting: ");
	}

	public static int[] dutchNationalAlgo(int[] array) {
		int low = 0;
		int high = array.length - 1;
		int start = 0;
		int temp = 0;

		while(start <= high) {
			switch(array[start]) 
			{
				case 0: temp = array[low];
						array[low] = array[start];
						array[start] = temp;
						low++;
						start++;	
						break;

				case 1: start++;
						break;

				case 2: temp = array[start];
						array[start] = array[high];
						array[high] = temp;
						high--;

						break;		
							
			}
		}

		return array;
	}
}