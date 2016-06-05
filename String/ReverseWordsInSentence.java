/**
	Source: http://stackoverflow.com/questions/22640106/reverse-word-letters-in-a-sentence-java

	Question: Reverse word letters in a sentence java

	Logic:
		- Split the sentence using string split.
		- Create output string builder
		- Take each words and using string builder reverse it and append it to output string builder.
		- Return output.
*/

class ReverseWordsInSentence {
	public static String SPACE = " ";

	public static void main(String[] args) {
		String input = "This is interview question";

		ReverseWordsInSentence rwsObj = new ReverseWordsInSentence();
		rwsObj.printWordsRevInSent(input);
	}

	void printWordsRevInSent(String input) {
		String output = getWordsRevInSent(input);
		System.out.println("Reverse Words in Sentense: " + output);
	}

	String getWordsRevInSent(String input) {
		String[] words = input.split(ReverseWordsInSentence.SPACE);
		StringBuilder builder = new StringBuilder();

		for(int i = 0; i < words.length; i++) {
			builder.append(new StringBuilder(words[i]).reverse());
			builder.append(ReverseWordsInSentence.SPACE);
		}

		return builder.toString();
	}

}