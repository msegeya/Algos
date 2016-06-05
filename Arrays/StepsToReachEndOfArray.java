/**
	Question: Minimum number of jumps to reach end. Given an array of integers where each element represents the max number of steps that can be made forward from that element. 

	Reference: 	https://www.youtube.com/watch?v=cETfFsSTGJI
				http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

	Logic: 
		- Very easy. Look at the video.
		- For every index check whether you can reach the destination index or not. Such that src < des. (Src should be before des.)
		- If yes, then check using which src we can reach des in fewer steps.
		- Return the last des value.
*/

class StepsToReachEndOfArray {
	public static void main(String[] args) {
		// int[] array = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1}; // 4
		// int[] array = {1, 3, 6, 1, 0, 9}; // 3
		int[] array = {1,3,5,3,2,2,6,1,6,8,9}; // 4

		int minSteps = getMinSteps(array);
		System.out.println(minSteps);
	}

	public static int getMinSteps(int[] array) {
		int[] jump = new int[array.length];
		jump[0] = 0;
		for(int i = 1; i < array.length; i++) {
			jump[i] = Integer.MAX_VALUE;
		}

		for(int des = 1; des < array.length; des++) {
			for(int src = 0; src < des; src++) {
				if(des <= src + array[src]) {
					if(jump[des] > jump[src] + 1) {
						jump[des] = jump[src] + 1;
					}
				}
			}
		}

		ArrayUtil.print(jump, "Steps for each value is: ");

		return jump[jump.length - 1];
	}
}