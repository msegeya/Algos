/**
	Question: Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array.

	Source: http://stackoverflow.com/questions/4487438/maximum-sum-of-non-consecutive-elements 

	Example:
			A: [3, 2, 7, 10] should return 13 (sum of 3 and 10) 
			A: [3, 2, 5, 10, 7] should return 15 (sum of 3, 5 and 7).

	Logic: (We need to use dynamic programming.)
		- M[0] = A[0]

		- M[1] = Max(A[0], A[1])

		- M[2] = Max(A[2] + A[0], A[1]) => Since A[2] and A[1] cannot come together we need to take A[2] and A[0] as a set and A[0] is nothing but M[0]
		       = Max(A[2] + M[0], M[1])	

		- M[3] = Max(A[3] + M[1], M[2])
			|
			|
		- M[i] = max(A[i] + M[i - 2], M[i - 1])	

	Both Space and Time complexity are O(N). 

	Can we reduce the space?
	YES. In every call we only need the sum of the two previous results. Except for M[0] and M[1] where we do the computation directly.
	So save the previous two results in to two variables and we will be using them for next computations.

	If i == 0,
		int M0 = A[0];
	If i == 1,		
		int M1 = Max(A[0], A[1])
	Else
		int M2 = Max(M1, M0)
		M0 = M1;
		M1 = M2;
*/

/*
	We will solve two problems here.
	Problem-1: Without 2 consecutive numbers.
	Problem-2: Without 3 consecutive numbers.
*/

class MaxNonConsecSubArray {
	int[] input = {5,  5, 10, 40, 50, 35};
	// int[] input = {3, 4, 5, 1, 2};

	public static void main(String[] args) {
		MaxNonConsecSubArray mncsaObj = new MaxNonConsecSubArray();
		mncsaObj.printMaxSubArray();
	}

	void printMaxSubArray() {
		int max2NonConsec = getMax2NonConsecutive(input);
		System.out.println("Max sum for 2 non-consecutive elements is: " + max2NonConsec);

		int max3NonConsec = getMax3NonConsecutive(input);
		System.out.println("Max sum for 3 non-consecutive elements is: " + max3NonConsec);		
	}

	int getMax2NonConsecutive(int[] input) {
		int sum[] = new int[input.length];

		for(int i = 0; i < input.length; i++) {
			if(0 == i) {
				sum[i] = input[0];
			} else if(1 == i) {
				sum[i] = Math.max(input[0], input[1]);
			} else {
				sum[i] = Math.max(sum[i - 1], sum[i - 2] + input[i]);
			}
		}

		return sum[input.length - 1];
	}

	int getMax3NonConsecutive(int[] input) {
		int sum[] = new int[input.length];

		for(int i = 0; i < input.length; i++) {
			if(0 == i) {
				sum[i] = input[0];
			} else if(1 == i) {
				sum[i] = input[0] + input[1];
			} else if(2 == i){
				sum[i] = getMaxOf3(sum[i - 1], sum[i-2] + input[i], input[i] + input[i - 1]);
			} else {
				sum[i] = getMaxOf3(sum[i - 1], sum[i - 2] + input[i], sum[i - 3] + input[i] + input[i - 1]);
			}
		}

		return sum[input.length - 1];
	}

	int getMaxOf3(int x, 
					int y, 
						int z) {
		return Math.max(Math.max(x, y), z);
	}
		
}	