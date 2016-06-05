/**
	Question: Find maximum rectangle that can be formed in a Histogram. See @ MaxRectHistogram.png for details.

	Example: Given a histogram find the largest rectangle that can be formed either horizontally or vertically with the given bars such that the sum of all the cells in the rectangle are maximum.

	Reference: https://www.youtube.com/watch?v=ZmnqCZp9bBs&src_vid=g8bSdXCG-lA&feature=cards&annotation_id=be9f2737-9f08-4434-a155-d723a87f3d05
			   https://github.com/mission-peace/interview/blob/master/src/com/interview/stackqueue/MaximumHistogram.java

	Logic: (Watch the video carefully.)
		- Watch the video before going furthur. 
		- Input is an array where each value in the array is equal to bar's in the histogram.
		- For each value in the array do,
			#) If there is no element in the stack then push the index of element and increment the index.
			#) If there is already an element and if the current index element is greater than the top of the stack index element then push the index and increment the index.
			#) If the current index value is less than the stack index element value then pop the top index and do,
				if(stack.isEmpty()) {
					area = input[top] * index;
				} else {
					area = input[top] * (index - stack.peek() - 1)
				}
				max_area = (area > max_area) ? area : max_area;

		- Now for each of the element that is pushed in to the stack do the following,
				while(!stack.isEmpty()) {
					int top = stack.pop();

					if(stack.isEmpty()) {
						area = input[top] * index;
					}
				} else {
					area = input[top] * (index - stack.peek() - 1)
				}
				max_area = (area > max_area) ? area : max_area;
		- Look below for more code comments.			 

*/

import java.util.*;

class MaxRectHistogram {

	public Stack<Integer> stack;
	// int[] histogram = {1, 2, 4};
	// int[] histogram = {2, 1, 2, 3, 1};
	int[] histogram = {2,2,2,6,1,5,4,2,2,2,2};

	public static void main(String[] args) {
		MaxRectHistogram mrhObj = new MaxRectHistogram();
		mrhObj.initialize();
		mrhObj.printMaxHistogram();
	}

	public void	initialize() {
		stack = new Stack<Integer>();
	}

	public void printMaxHistogram() {
		int max_histogram = getMaxHist(histogram, stack);
		System.out.println("Maximum Histogram = " + max_histogram);
	}

	public int getMaxHist(int[] hist, Stack<Integer> stack) {

		int area = 0; int max_area = -1;

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

		// after all insertions now if we need to pop all indices and calculate area.
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