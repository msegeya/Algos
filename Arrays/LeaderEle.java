/**
	Question: Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.

	Logic:
		- Scan from right.
		- Make the last element as the max and it will be the default leader.
		- Now move one step left and start seeing whether the current element is greater than max or not. 
			If yes, then current element is also a leader.
			If no, then move to next element.
*/

class LeaderEle {
	static void leaderElements(int[] array) {
		int max = array[array.length - 1];
		System.out.println("For element " + array[array.length - 1] + " max is " + max);
		for(int i = array.length - 2; i >= 0; i--) {
			if(array[i] > max) {
				max = array[i];
				System.out.println("For element " + array[i] + " max is " + max);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {16, 17, 4, 3, 5, 2};
		leaderElements(array);
	}
}