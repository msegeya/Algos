/**
	Question: Sub string example.

	Syntax: 	public String substring(int beginIndex)
								OR
				public String substring(int beginIndex, int endIndex)

				where beginIndex is inclusive and endIndex is exclusive.
*/

class SubStrEx {
	public static void main(String[] args) {
		String input = "Welcome to Tutorialspoint.com";

		System.out.println(input.substring(11));
		System.out.println(input.substring(11, 15));
	}
}