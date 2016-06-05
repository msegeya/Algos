class SortUtil {

	public static final String BEFORE_SORTING = "Before Sorting";
	public static final String AFTER_SORTING = "After Sorting";

	public static void print(int[] array, String msg) {
		if(null == msg) {
			msg = "Array Elements are: ";
		}

		System.out.println(msg);
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

	public static void print(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

	public static int[] swap(int[] array, int leftPos, int rightPos) {
		int temp = array[leftPos];
		array[leftPos] = array[rightPos];
		array[rightPos] = temp;

		return array;
	}
}