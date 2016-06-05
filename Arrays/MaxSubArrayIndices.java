/**
	Question: Given an array arr[], find the maximum j – i such that arr[j] > arr[i]

	Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  	Output: 6  (j = 7, i = 1)

    Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
	Output: 8 ( j = 8, i = 0)

    Input:  {1, 2, 3, 4, 5, 6}
    Output: 5  (j = 5, i = 0)

    Input:  {6, 5, 4, 3, 2, 1}
    Output: -1

    Logic: 
    	- Get min of every two adjacents elements of all the elements from the start.
    	- Get max of every two adjacents elements of all the elements from the end.
    	- Now for every element start from 0 in both the arrays do the following,
    		- If RMax[j] > LMin[i] then diff = j - i and increment j
    		- Else increment i.
*/

class MaxSubArrayIndices {
	public static void main(String[] args) {
		// int[] array = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		int[] array = {34, 8, 10, 3, 2, 80, 30, 33, 1};

		int[] LMin = new int[array.length];
		int[] RMax = new int[array.length];

		LMin[0] = array[0];
		for(int i = 1; i < array.length; i++) {
			LMin[i] = Math.min(array[i], LMin[i - 1]);
		}

		ArrayUtil.print(LMin, "LMin");

		RMax[array.length - 1] = array[array.length - 1];
		for(int j = array.length - 2; j >= 0; j--) {
			RMax[j] = Math.max(array[j], RMax[j + 1]);
		}

		ArrayUtil.print(RMax, "RMax");

		int max_diff = -1;
		int i = 0, j = 0;
		while(i < array.length && j < array.length) {
			if(RMax[j] > LMin[i]) {
				max_diff = j - i;
				j++;
			} else {
				i++;
			}
		}

		System.out.println(max_diff);
	}
}