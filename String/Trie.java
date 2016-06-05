/**
	Source: http://exceptional-code.blogspot.in/2011/07/coding-up-trie-prefix-tree.html
			http://codereview.stackexchange.com/questions/41630/trie-tree-form-in-java

	Question: Trie DS
	
	NOTE: Please see "TrieOptimised.java" for better implementation. 
		  The disadvantage of this approach is even if we are not using every character we allocate space for them.
		  So we will optimize it by creating a character only if the letter is available.

	Usage: Dictionary words, Auto completion, Word Search
	
	Logic: 
		- Every node has 26 characters.
		- We link the next character with the next alphabet of the next node.
		- So when ever we need to search for a word. We start at root then we go to the next link basing on the character of the search word.
*/


// NOTE: Look "TrieOptimised.java" for optimised approach.

class Trie {

	public static int ALPHABET_SMALL_START = 97;
	private TrieNode root;
	
	public static void main(String[] args) {
		String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
		
		Trie trieObj = new Trie();
		trieObj.prepareTree(words);
		
		trieObj.printTrie();
		
		trieObj.search();
	}

	void prepareTree(String[] words) {
		// create an empty root.
		root = new TrieNode(' ');

		for(String word : words) {
			root = insert(root, word);
		}
	}

	TrieNode insert(TrieNode root, 
						String word) {

		TrieNode currentNode = root;

		for(int i = 0; i < word.length(); i++) {
			char curr_letter = word.charAt(i);
			int charIndex = curr_letter - ALPHABET_SMALL_START;
			if(null == currentNode.link[charIndex]) {
				// create a new node for the current character.
				TrieNode newNode = new TrieNode(curr_letter);
				currentNode.link[charIndex] = newNode;
				currentNode = newNode;						
			} else {
				currentNode = currentNode.link[charIndex];
			}
		}
		// after completing the word insertion. Update wordComplete as true.
		currentNode.wordComplete = true;

		return root;
	}
	
	void search() {
		String[] searchWords = {"all", "alloy", "be", "amarnath"};
		System.out.println("SEARCH OPERATIONS: ");
		for(String search : searchWords) {
			boolean searchResult = search(root, search);
			if(searchResult) {
				System.out.println("Element found: " + search);
			} else {
				System.out.println("Element NOT found: " + search);
			}
		}
	}
	
	boolean search(TrieNode root, String search) {
		if(null == search) {
			return false;
		}
		
		TrieNode current = root;
		int i = 0;
		for(i = 0; i < search.length(); i++) {
			TrieNode nextNode = current.link[search.charAt(i) - ALPHABET_SMALL_START];
			
			if(null == nextNode) {
				break;
			}
			current = nextNode;
		}
		
		if(current.wordComplete && i == search.length()) {
			return true;
		}
		
		return false;
	}
	
	
	void printTrie() {
		System.out.println("Trie words are: ");
		printTrie(root, 0, new char[50]);
		System.out.println();
	}
	
	void printTrie(TrieNode root, int level, char[] branch) {
		if(null == root) {
			return;
		} 
		
		for(int i = 0; i < root.link.length; i++) {
			branch[level] = root.letter;
			printTrie(root.link[i], level + 1, branch);
		}
		
		if(root.wordComplete) {
			for(int j = 1; j <= level; j++) {
				System.out.print(branch[j]);
			}
			System.out.println();
		}
	}
}