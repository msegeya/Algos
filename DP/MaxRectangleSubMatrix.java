/**
	Question: Maximum Sub Rectangle matrix in a given matrix. In the below matrix the maximum rectangle that can be formed is starting from top [2, 2] to [2, 5] and bottom [3, 2] to [3, 5]

	Example: Consider the below matrix,
				0	1	2	3	4	5
			0	1	0	0	1	1	1
			1	1	0	1	1	0	1
			2	0	1	1	1	1	1
			3	0	0	1	1	1	1
	
	NOTE: BEFORE GOING FURTHUR CHECK MAXINUM RECTANGLE AREA IN A HISTOGRAM @ MAXRECTHISTOGRAM.JAVA
	
	Reference: https://www.youtube.com/watch?v=g8bSdXCG-lA

	Logic:
		- For the given matrix first we will try to calcualte an input array using these matrix values.
		- Take the above matrix, do sum of each row and save it in the array basing on the following conditions,
			for(each row) {
				if(row(column(value)) == 0) then array[row] = 0; 
				// Note: If there is any value other than zero is found at the end then the result array[row] will not be zero.
			} else {
				array[row] += column(value)
			}
		- Now we have a array, use this array as a histogram and calculate the max. rectangular area that can be possible.

		How to calculate using Histogram?
		- For each element in the input array do,
			For Insert:
			  #) If stack is empty then push the the element's index and increment the index value.
			  #) If the stack is not empty and current element is greater than the stack's top index element then push the element's index in to the stack.
			  #) If the stack is not empty and the current element is less than the stack's top element,
			  		Two conditions:
				  	Condition-1: If stack is empty after popping top, 
				  		then pop the index and get the element and calculate area as, area = stack[top] * index;
					Condition-2: if the stack is NOT empty after popping top,
						then pop the index and get the element and calculate area as, area = stack[top] * (index - stack.peek() - 1)
			For Delete,
			  #) For all the elements in the stack do,
			  	  - Pop the index from the stack and if the stack is empty then area = stack[top] * index;
			  	  - Pop the index from the stack and if the stack is NOT empty then area = stack[top] * (index - stack.peek() - 1);
*/

import java.util.*;

class MaxRectangleSubMatrix {

	int[][] matrix = {
						{1, 0, 0, 1, 1, 1},
						{1, 0, 1, 1, 0, 1},
						{0, 1, 1, 1, 1, 1},
						{0, 0, 1, 1, 1, 1}
					 };

	public static void main(String[] args) {
		MaxRectangleSubMatrix mrsmObj = new MaxRectangleSubMatrix();
		mrsmObj.printMaxRect();
	}

	public void printMaxRect() {
		int[] hist = new int[matrix[0].length];

		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[row].length; col++) {
				if(matrix[row][col] == 0) {
					hist[row] = 0;
				} else {
					hist[row] += matrix[row][col];
				}
			}
		}

		int max_rect = calUsingHist(hist);
		System.out.println("Maximum Rectangle = " + max_rect);
	}

	public int calUsingHist(int[] hist) {
		Stack<Integer> stack = new Stack<Integer>();
		int max_area = -1;
		int area = 0;

		int index = 0;
		while(index < hist.length) {
			if(stack.isEmpty() || hist[stack.peek()] <= hist[index]) {
				stack.push(index);
				index++;
			} else {
				int top = stack.pop();
				if(stack.isEmpty()) {
					area = hist[top] * index;
				} else {
					area = hist[top] * (index - stack.peek() - 1);
				}

				if(max_area < area) {
					max_area = area;
				}
			}
		}

		while(!stack.isEmpty()) {
			int top = stack.pop();

			if(stack.isEmpty()) {
				area = hist[top] * index;
			} else {
				area = hist[top] * (index - stack.peek() - 1);
			}

			if(max_area < area) {
				max_area = area;
			}
		}

		return max_area;
	}
}