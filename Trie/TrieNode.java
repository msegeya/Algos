import java.util.*;

class TrieNode {
	Character data;
	Map<Character, TrieNode> childMap;
	Boolean isWord;
	// This we will use for delete method.
	int numOfChilds;

	public TrieNode(char data) {
		this.data = data;
		this.childMap = new HashMap<Character, TrieNode>();
		this.isWord = false;
		this.numOfChilds = 0;
	}

	public TrieNode() {
		this.data = null;
		this.childMap = new HashMap<Character, TrieNode>();
		this.isWord = null;
		this.numOfChilds = 0;
	}
}