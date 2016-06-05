import java.util.Arrays;

class MatrixUtil {
	public static void print(int[][] array, String msg) {

		if(null == msg) {
			msg = "Input 2D Matrix is";
		}

		System.out.println("\n" + msg);

		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void print(int[] array, String msg) {
		if(null == msg) {
			msg = "Array is: ";
		}

		System.out.println(msg);
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println();
	}

	public static int[][] fillWithValue(int[][] grid, int defaultValue) {
		for(int row = 0; row < grid.length; row++) {
			Arrays.fill(grid[row], defaultValue);
		}

		return grid;
	}
}