import java.util.Arrays;

class ArrayUtil {
	public static int[] swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;

		return array;
	}

	public static void print(int[] array, String msg) {
		if(null == msg) {
			msg = "Array is: ";
		}

		System.out.println(msg);
		System.out.println(Arrays.toString(array));

		System.out.println();
	}

	public static void print(String[] array, String msg) {
		if(null == msg) {
			msg = "Array is: ";
		}

		System.out.println(msg);
		for(String s : array) {
			System.out.print(s + " ");
		}

		System.out.println();
	}

	public static void print(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}
}