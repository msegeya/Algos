/**
	Source: http://stackoverflow.com/questions/8965926/algorithm-to-generate-all-combinations-of-a-string

	Question: Combinations of a given String.

	Logic: 
		- Consider the given string as "ABC"
		- Calculate its length  => 3
		- Find all the binary values from 1 to (2^3 - 1) => (1 to 7) ==> 001, 010, 011, 100, 101, 110, 111.
		- Now take each binary value, 001 => Consider the position of the binary value same as the original string and when the char is 1 in binary string then replace it with corresponding character. ==> 001 is C
		- 001 - C, 010 - B, 011 - BC, 100 - A, 101 - AC, 110 - AB, 111 - ABC
		- We need to using String format for padding the binary value with leading zeroes.
*/

class CombinationsOfString {
	public static void main(String[] args) {
		// String input = "abc";
		String input = "abcd";
		CombinationsOfString csObj = new CombinationsOfString();
		csObj.printCombinations(input);		
	}

	void printCombinations(String input) {
		doCombinations(input);
	}

	void doCombinations(String input) {
		int length = input.length();
		int count = (int) Math.pow(2, length);

		String pattern = "%" + length + "s";
		for(int i = 1; i < count; i++) {
			String formatedStr = String.format(pattern, Integer.toBinaryString(i)).replace(' ', '0');
			// System.out.println(formatedStr);

			int start = 0;
			String output = "";
			while(start < length) {
				if(formatedStr.charAt(start) == '1') {
					output += input.charAt(start);
				}
				start++;	
			}
			System.out.println(output);
		}
	}
}