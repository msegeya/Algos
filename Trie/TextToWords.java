/**
	Question: Given a string of words. Your task is to split the words in the given string.
			  Example: "thisisatext" to ["this", "is", "a", "text"]
			  			"programmerit" to ["programmer", "it"], ["program", "merit"]

	Reference: http://stackoverflow.com/questions/8793387/how-to-break-down-a-given-text-into-words-from-the-dictionary
	
	Logic: 
		- Assume that you have a Trie in hand.
		- Start of with the first character and then see if there is a path for all the characters. At any point if you find out that there is a word ending with this character then save it. We won't print it unless we decide whether there is no other word which is larger than the current word.
			Example: "programmerit" we have "program" first and then we also have the word "programmer". In this case we have to choose "programmer" instead of program. But if the letters after programmer does not form a word then we should use the first word "program" and proceed furthur.

	Implementation:			
		- Create a Trie.
		- Have a index called "start", this is used to keep track of start of the word in a given input string.
		- For a sequence of chars in a given input, if at any char if you find out current.isWord is true then a word is ended here. So use string substring logic to get the word using from start pointer to current index.
		- But if you want the longest word in a given string to be splited as a word then don't just split the word when you see isWord as true wait until nextlink is null for the next character.
		- Save all the obtained words in a array list string.
		- Finally return the array list and print it.
*/

import java.util.*;

class TextToWords {

	private TrieNode root;
	private String[] dic = {"this", "is", "a", "text", "program", "programmer", "merit", "it"};
	private String[] input = {"thisisatext", "programmerit"};

	public static void main(String[] args) {
		TextToWords twObj = new TextToWords();
		twObj.initialize();
		twObj.findWords();
	}

	public void initialize() {
		root = Trie.insert(dic, root);
		Trie.print(root);
	}

	public void findWords() {
		for(String eachStr : input) {
			System.out.println("Words present in string " + eachStr + " are");
			List<String> wordsList = getWords(eachStr);
			for(int i = 0; i < wordsList.size(); i++) {
				System.out.println(wordsList.get(i));
			}
		}
	}

	public List<String> getWords(String str) {
		TrieNode current = root;
		List<String> wordsList = new ArrayList<String>();
		
		boolean startWord = false;
		int start = -1;
		for(int i = 0; i < str.length(); i++) {
			if(start == -1) {
				start = i;
			}

			char ch = str.charAt(i);
			TrieNode nextLink = current.childMap.get(ch);

			if(null != nextLink) {
				// look at below commneted code if you want to print the longest word instead of just word.
				if(nextLink.data == ch && nextLink.isWord) {
					wordsList.add(str.substring(start, i + 1));
					// reset the start point again.
					start = -1;
					current = root;
				} else {
					current = nextLink;
				}
			} else {
				System.out.println("Word(s) pattern does not exist. We are at index " + i);
				return null;
			}

			/*  If we want the longest string to be splitted as a word. 
				Ex: "programmerit" output should be ["programmer", "it"] instead of ["program" "merit"]

				if(nextLink.data == ch && nextLink.isWord) {
					if(((i + 1) < str.length()) && nextLink.childMap.get(str.charAt(i + 1)) != null) {
						current = nextLink;	
					} else {
						wordsList.add(str.substring(start, i + 1));
						// reset the start point again.
						start = -1;
						current = root;	
					}
				} else {
					current = nextLink;
				}
			*/
 		}


 		return wordsList;
	}
}