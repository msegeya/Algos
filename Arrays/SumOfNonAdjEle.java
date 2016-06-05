/**
	Question: Sum of number in the array such that no two elements should be adjacent to each other in the result set.
	NOTE: All are positive numbers.

	Reference: http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/

	Logic: 
		- NOTE: Before going further, incl is nothing but incluing the current element. So we need to add the current element to incl. Since we have added current element to incl we should not add the previous element to it. So we will add the excl to the incl + current element. Also until now we need to keep track of the max sum. So get the max sum and since excl should not have current element we will assign temp to the excl.
		- First take the first element as incl_cur
		- Start with the second element and as we cannot take the adjacent one so we will calculate the max of incl_cur and excl_cur and save it.
		- Now incl_cur has the first element and temp has the max of incl_cur and excl_cur.
		- incl_cur will be excl_cur + current_element.
		- excl_cur will be temp.
		- Do this until you reach end of the array.
		- Finally return max of incl and excl.
*/

class SumOfNonAdjEle {
	public static int nonAdjSum(int[] array) {
		int incl_cur = array[0];
		int excl_cur = 0;

		for(int i = 1; i < array.length; i++) {
			
			// current sum excluding current element which is nothing but excl_cur
			int temp_sum = (incl_cur > excl_cur) ? incl_cur : excl_cur;

			// current sum including current element
			incl_cur = excl_cur + array[i];
			excl_cur = temp_sum;
		}

		return Math.max(incl_cur, excl_cur);
	}

	public static void main(String[] args) {
		int[] array = {5,  5, 10, 40, 50, 35};
		System.out.println(nonAdjSum(array));
	}
}