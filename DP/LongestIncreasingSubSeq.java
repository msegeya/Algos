/**
	Question: Longest Increasing SubSequence. Given an array find the increasing sequence.

	Source: 
		O(nlogn) --> http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
		O(nlogn) --> http://stackoverflow.com/questions/6129682/longest-increasing-subsequenceonlogn
		O(n^2)	 --> http://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
		O(n^2) 	 --> https://www.youtube.com/watch?v=CE2b_-XfVDk
		O(nlogn) --> https://www.youtube.com/watch?v=S9oUiVYEq7E

	Logic-1: (TC: O(n^2) using Dynamic Programming)
		- At each level we will check how many of the previous numbers are LESS than the current one. So for current node we can check using previous nodes.
		- We will use an array "DP" where we will store the count of numbers that are less than current one + 1 (for current element).
		- DP size will be size of the original array. Initialize DP[0] with 1 .. that is for every element it will be longest sub-sequence for itself.
		- If current element at index i, (DP[i] < DP[j] + 1) then update DP[i] with DP[j] + 1; ==> j starts from (i-1) and goes until 0.
			 AND 
		  array[i] > array[j] ==> current element should be greater than the previous element.

		Example:
			array: {3, 4, -1, 0, 6, 2, 3}; 		DP's : {0, 0, 0, 0, 0, 0, 0};
			i = 0:
				DP[0] = 1; ==> Since for every element longest will be atleast 1.	
			i = 1:
				DP[i] = 1; Take a variable j which will traverse all the previous elements before current element ==> j < i.
				Now check whether previous element is less than current element. => array[i] > array[j] => YES
					AND	
				Also check whether DP[j] + 1 > DP[i] ==> longest length for the current element is greater than the previous calcualted ones.
		- Look below code comments for more details.
*/

class LongestIncreasingSubSeq {

	private int[] input;

	public static void main(String[] args) {
		LongestIncreasingSubSeq lisObj = new LongestIncreasingSubSeq();
		lisObj.prepareInput();

		lisObj.printLonIncrSeq();
	}

	void prepareInput() {
		int[] array = {3, 4, -1, 0, 6, 2, 3}; // o/p: -1, 0, 2, 3; max_length = 4
		// int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80 }; // o/p: {10, 22, 33, 41, 60, 80}; max_length = 6
		input = array;
	}

	void printLonIncrSeq() {
		int max_length = getLonIncrSeq(input);
		System.out.println("\nLongest Increasing Sub-Sequence is: " + max_length);
	}

	int getLonIncrSeq(int[] array) {
		int[] DP = new int[array.length];
		DP[0] = 1;

		// max_length is 1 since each element itself will be the longest.
		int max_length = 1;

		// To know what are the elements that are picked up save the picked elements in this array.
		int[] pickedIndexes = new int[array.length];
		// termination condition while backtracking to print all the picked up array elements.
		pickedIndexes[0] = -1;

		int bestEnd = 0;

		for(int i = 1; i < array.length; i++) {
			// default values for DP array for all the array elements.
			DP[i] = 1;

			pickedIndexes[i] = -1;

			for(int j = i - 1; j >= 0; j--) {
				// check if the current element is greater than previous element
				// Also check if the current DP is less then the previous DP plus 1 else no point in updating.
				if( (array[i] > array[j]) && ((DP[j] + 1) > DP[i])) {
					DP[i] = DP[j] + 1;

					pickedIndexes[i] = j;
				}
			}

			if(max_length < DP[i]) {
				max_length = DP[i];

				// this is the last element index that is choosen in the longest sub-sequence.
				bestEnd = i;
			}
		}

		// So what are the elements that are present in the longest path?
		// -1 is used to stop backtracking further.
		System.out.print("Elements present in the longest path are: ");	
		while(bestEnd != -1) {
			System.out.print(array[bestEnd] + " ");
			bestEnd = pickedIndexes[bestEnd];
		}

		return max_length;
	}
}