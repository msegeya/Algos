/**
	Source: http://stackoverflow.com/questions/2713655/reverse-a-given-sentence-in-java

	Question: Reverse a given sentence in java

	Logic: 
		- Split the words using string split.
		- Traverse from end and store them in a string builder.
		- Finally return the String builder.
*/

class ReverseSentence {

	public static String SPACE = " ";

	public static void main(String[] args) {
		String input = "This is interview question";

		ReverseSentence rsObj = new ReverseSentence();
		rsObj.printReverseSent(input);
	}

	void printReverseSent(String input) {
		String revSent = getReverseSent(input);
		System.out.println("Reverse Sentence = " + revSent);
	}

	String getReverseSent(String input) {
		String[] words = input.split(ReverseSentence.SPACE);
		StringBuilder builder = new StringBuilder();
		for(int i = words.length - 1; i >= 0; i--) {
			builder.append(words[i]);
			builder.append(ReverseSentence.SPACE);
		}

		return builder.toString();
	}
}