class TrieNode {
	char letter;
	TrieNode[] link;
	boolean wordComplete;

	// We assume each TrieNode has 26 characters. (We took only 26 characters for simplicity.)
	public TrieNode(char letter) {
		this.letter = letter;
		this.link = new TrieNode[26];
		this.wordComplete = false;
	}
}