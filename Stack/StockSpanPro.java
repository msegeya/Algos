/**
	Question: Stock span problem

	Logic: (NOTE: We are pushing only indexes into stack not the actual price.)
		- Push the first price index in to the stack.
		- Now for each of the next element do the following,
			- If the next element is less than the current top then pop it.
		- Finally if the stack is empty then all the elements before it are less than the current element so output will be current index + 1 else (current_index - stack.peek())
*/

import java.util.*;

class StockSpanPro {
	public static void main(String[] args) {
		int[] stocks = {100, 80, 60, 70, 60, 75, 85};
		calSpan(stocks);
	}

	public static void calSpan(int[] array) {
		int[] S = new int[array.length];
		Stack<Integer> stk_index = new Stack<Integer>();
		stk_index.push(0);

		// Initialize the first stock price with 1.
		S[0] = 1;

		for(int i = 1; i < array.length; i++) {
			// while stack is not empty and if stack top is less than the current element then pop it.
			while(!stk_index.isEmpty() && array[i] >= array[stk_index.peek()]) {
				stk_index.pop(); // pop the index from the stk_index.
			}

			// if stk_index is empty then current element is larger than all the previous elements.
			// i - stk_index.peek() will be 1 if there is no stock price less than the current one.
			S[i] = (stk_index.isEmpty()) ? i + 1 : (i - stk_index.peek());

			// fianlly push the current element into the stk_index.
			stk_index.push(i);
		}

		for(int i = 0; i < S.length; i++) {
			System.out.print(array[i] + "\t" + S[i]);
			System.out.println();
		}
	}
}