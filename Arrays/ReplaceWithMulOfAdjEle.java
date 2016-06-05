/**
	Question: Replace every array element by multiplication of previous and next.

	Reference: 

	Logic: 
		- Whole point is to save previous and Next element.
		- So save them and do the multiplication.
		- Before updating any index element just save the original value such that it will be useful for next element multiplication.
*/

class ReplaceWithMulOfAdjEle {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};

		array = getMulWithAdjEle(array);
		ArrayUtil.print(array, "Replace Each element with Multiplication of next and previous.");
	}

	public static int[] getMulWithAdjEle(int[] array) {
		int prev_ele = 1;
		int next_ele = 1;

		for(int i = 0; i < array.length; i++) {
			// next_ele will be the element after current element.
			if(i + 1 < array.length) {
				next_ele = array[i + 1];
			} else {
				next_ele = 1;
			}

			// save the current element before replacing it.
			int temp = array[i];

			// replace the current with prev and next.
			array[i] = prev_ele * next_ele;

			// update prev with temp.			
			prev_ele = temp;
		}

		return array;
	}
}