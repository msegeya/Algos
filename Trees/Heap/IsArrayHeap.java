class IsArrayHeap {
	
	/* 
		Assuming MAX_ARRAY.
		Pass array and index as 0. 
	*/
	public boolean isHeap(int[] array, int index) {
		if(index >= array.length) { return true; }

		// Note: Leafs will always be true.
		// How to check for leaves?
		// Since Heap is a CBT, leaves will occupy array from (array.length - 2) / 2. You can check it yourself.
		if(index > (array.length - 2) / 2) { return true;}

		return  isHeap(array, 2 * index + 1) 
						&& 
			 	isHeap(array, 2 * index + 2) 
			 			&& 
			 	((array[index] >= array[2 * index + 1]) && ((array[index] >= array[2 * index + 2]);
	}

	/* Iterative Solution */
	public boolean isHeap(int[] array) {
		for(int i = 0; i <= (array.length - 2) / 2; i++) {
			if(array[2 * i + 1] > array[i]) { 
				return false;
			}

			if(array[2 * i + 2] > array[i]) {
				return false;
			}
		}

		return true;
	}
}