/**
	Question: Given a dictionary of words and an input string, find the longest prefix of the string which is also a word in dictionary.

	Reference: http://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/

	Logic: 
		- We already know how to construct a trie.
		- For each char store it in a stringbuilder. If the node has isWord as True then print the string builder until that point.
*/

class LongestPrefix {

	TrieNode root = null;

	public static void main(String[] args) {
		LongestPrefix lpObj = new LongestPrefix();
		lpObj.createTrie();
	}

	void createTrie() {
		String[] input = {"caterer", "basemexy", "child", "cater", "base"};
		// output should be, "cater", "base", <empty> 
		root = Trie.insert(input, root);
		Trie.print(root);

		checkPrefix(input);
	}

	void checkPrefix(String[] input) {
		for(String eachWord : input) {
			System.out.println("*********** Finding Prefix for ********* " + eachWord);
			if(null == root) {
				System.out.println("Root is null. Word not found: " + eachWord);
				return;
			} 

			TrieNode current = root;
			StringBuilder output = new StringBuilder();
			for(int i = 0; i < eachWord.length(); i++) {
				TrieNode nextChild = current.childMap.get(eachWord.charAt(i));
				if(null == nextChild) {
					System.out.println("Word not found: " + eachWord);
					break;
				} else {
					output.append(nextChild.data);
					// and condition is used such that we won't print the actual string.
					// If you want to print the longest string then wait until the end of the loop and 
					// f you find any before completing the actual string then print the output.
					if(nextChild.isWord && i != eachWord.length() - 1) {
						System.out.println("Prerix String is " + output);
					} 
					current = nextChild;
				}
			}
		}
	}

}