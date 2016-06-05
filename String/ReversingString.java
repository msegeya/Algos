/**
	Source: http://stackoverflow.com/questions/2439141/what-is-the-most-efficient-algorithm-for-reversing-a-string-in-java

	Question: Reverse a string in most efficient way. (Don't think too much .. :P) 
			  Do using both Iteratively and Recursively.	

	Logic: 
		- Just like the way we reverse an int array we do the same for the String.
		- Convert the String to Char array.
		- Start pointer i from 0 and pointer j last of String.
		- If i < j them swap chars at i and j and then do i++ and j--.

*/

class ReversingString {
	public static void main(String[] args) {
		// even length
		// String input = "amarnath";

		// odd length
		String input = "Oracle1";

		ReversingString rsObj = new ReversingString();
		rsObj.printRevStrIter(input);

		rsObj.printRevStrRecur(input);
	}

	void printRevStrRecur(String input) {
		String revStr = reverseRecur(input);
		System.out.println("RECURSIVELY = " + revStr);
	}

	String reverseRecur(String input) {
		if(input.length() == 1) {
			return input;
		}

		return reverseRecur(input.substring(1)) + input.charAt(0);
	}

	void printRevStrIter(String input) {
		String revStr = getReverseOfString(input);
		System.out.println("ITERATIVELY = " + revStr);
	}

	String getReverseOfString(String input) {
		int length = input.length();
		char[] inputChar = input.toCharArray();
		int i = 0;
		int j = length - 1;
		while(i < j) {
			swapChars(inputChar, i, j);
			i++;
			j--;
		}

		return new String(inputChar);
	}

	void swapChars(char[] chars, 
							int left, 
								int right) {
		char temp = chars[left];
		chars[left] = chars[right];
		chars[right] = temp;
	}
}