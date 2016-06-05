/**
	Source: http://www.javaproficiency.com/2015/01/generate-permutation-of-string.html
			http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
			http://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string
			http://stackoverflow.com/questions/14008521/please-explain-this-algorithm-to-get-all-permutations-of-a-string	

	Question: Permutations of a String (Recursively and Iteratively)

	Logic-1: (Using Recursive)
		- We will keep one element constant and swap the other two elements.
		- Check permutations.gif image in repos.
		- We just keep first element as constant and swap rest of the remaining elements.
		- Similarly we take every char and put it first and swap the remaining elements.

	Logic-2: (Using Iterative)	
		- It is very easy to do using Recursion since we need to do the same for all steps.

*/


class PermutationsOfString {
	public static void main(String[] args) {
		String input = "abc";
		// String input = "abcd";
		// String input = "abcde";

		PermutationsOfString psObj = new PermutationsOfString();
		psObj.printAllPermutations(input);
	}

	void printAllPermutations(String input) {
		char[] chars = input.toCharArray();
		doPermutations(chars, 0, input.length() - 1);
	}

	/**
		Keep first element as constant and swap the remaining chars.
		Similarly make every char as first element and swap the remaining chars.
	*/
	void doPermutations(char[] chars, 
								int start, 
									int end) {
		if(start == end) {
			for(int k = 0; k < chars.length; k++) {
				System.out.print(chars[k]);
			}
			System.out.println();
			return;
		}

		// You will understand by looking at image permutations.gif
		for(int i = start; i <= end; i++) {
			swap(chars, start, i);
			doPermutations(chars, start + 1, end);
			swap(chars, start, i);
		}
	}

	void swap(char[] chars, 
					int left, 
						int right) {
		char temp = chars[left];
		chars[left] = chars[right];
		chars[right] = temp;
	}
}