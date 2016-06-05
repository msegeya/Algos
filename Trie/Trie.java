/**
	Question: Trie Data structure implementation.

	Reference: Own implementation using maps.
				http://www.geeksforgeeks.org/trie-insert-and-search/
				Delete Operation: http://www.geeksforgeeks.org/trie-delete/

	Logic: 
		Logic-1: 
				TrieNode {
					char data; TrieNode[0 .. 25] link; isWord;
				}
			INSERT: (Search is similar.) 
			- Create a trie node where each node will have data as character, 26 pointers (a .. z) and a boolean where we use it to check whether the word ended here or not using isWord.
			- Keep root as empty. Take a pointer current = root;
			- For every character check whether there is a node present with this character like, current.link[char] is null or not. If null then there is no character then create a new trie node and do current.link[char] = newNode and make current = newNode and proceed to next character input.
			Else if current.link[char] != null then make current = current.link[char]. 
			If the word ended then make sure you end that word as current.isWord = true.

		But this logic has some memeory problem. Why to create 26 pointers if all the words created are starting from say "b". We will solve this problem using Maps.

		Logic-2:
				TrieNode {
					char data; Map<Character, TrieNode> mapLink; isWord;
				}
			- Create a trie node where each node have data, map and isWord. When we create a node we will create a map but not pointers inside the map. 
			- Keep root as empty. Take a pointer current = root;
			- For every character, check whether there is a node present with this character like, current.mapLink.get(char) is null or not.
				If,
					current.mapLink.get(char) is null then create a new node and place it inise map as current.mapLink.put(char, newNode) and make current as newNode.
					current.mapLink.get(char) is NOT null then make current as current = current.mapLink.get(char)
			- If word is ended then make current.isWord as true.

		PRINT logic: 
			- Printing is little bit tricky. We will use the same stratergy for Delete also.
			- Using recursion go deep down until the current node is null and while going down make sure you store all the nodes that you are traversing.
			- After the end of each path print them.

		DELETE Logic:
			- Search whether the word is present or not. If present continue.
			- If no part of the word path have any other keys then delete all the nodes. Example like "trie" is the only word present in the entire path starting with "t" from root then we should delete all the nodes.
			- If the word is prefix of another long word (ex. exam in example) then make isWord false for exam.
			- If the word has prefix within it (ex. take "example" to delete and it contains the word "exam" as prefix in it) then delete nodes from the end until we reach "exam" word.
			
		DELETE-EXAPLANATION: 
			- Go to the leaf node of the given input and start from there.
			- If leaf node does not contain any other nodes i,e. (current.numOfChilds = 0) then delete the leaf node by making current.childMap(char, null). Since we have deleted we will make the numOfChilds of this node as 0.
			- Now recursively go back to preious nodes and check whether it has only one child or more than that. If only one child and if the child does not have any other child nodes then we can delete this node also.
			- Similarly go up until the root.

*/


import java.util.Map;

class Trie {

	public static void main(String[] args) {
		Trie trieObj = new Trie();
		trieObj.initialize();	
	}

	public void initialize() {
		String[] create_input = {"trie", "tree", "branch", "beach"};
		String[] search_input = {"bean", "beach"};
		String[] delete_input = {"tree", "trie", "amar"}; // after delete confirm using search.

		TrieNode root = createRoot();

		insert(create_input, root);
		search(search_input, root);
		print(root);
		delete(delete_input, root);
	}

	public static TrieNode createRoot() {
		return new TrieNode();
	}

	public static TrieNode createNode(char data) {
		TrieNode newNode = new TrieNode(data);
		return newNode;
	}

	public static TrieNode insert(String[] input, TrieNode root) {
		for(String eachWord : input) {
			char[] wordChar = eachWord.toLowerCase().toCharArray();
			System.out.println("INSERT: Input word is " + eachWord);

			TrieNode current = root;
			for(char eachChar : wordChar) {
				if(null == root) {
					root = createRoot();
					current = root;
				} 
				Map<Character, TrieNode> mapLink = current.childMap;
				TrieNode childNode = mapLink.get(eachChar);
				if(null == childNode) {
					TrieNode newNode = createNode(eachChar);
					mapLink.put(eachChar, newNode);
					current.numOfChilds = current.numOfChilds + 1;
					current = newNode;
				} else {
					current = childNode;
				}
			}
			current.isWord = true;
		}
		
		return root;
	}

	public static void search(String[] input, TrieNode root) {
		for(String eachWord : input) {
			System.out.println("Searching for word: " + eachWord);
			doSearch(eachWord, root);
		}
	}

	public static boolean doSearch(String eachWord, TrieNode root) {
		int length = eachWord.length();
		TrieNode current = root;
		for(int i = 0; i < eachWord.length(); i++) {
			char eachChar = eachWord.charAt(i);
			System.out.println("Current char is " + eachChar);
			if(null == root) {
				// do nothing
			} else {
				Map<Character, TrieNode> mapLink = current.childMap;
				TrieNode childNode = mapLink.get(eachChar);				
				if(childNode != null) {
					current = childNode;
					length--;
				} else {
					break;
				}
			}
		}

		if(null == root) {
			System.out.println("Root is null. Word search Failed for " + eachWord);
			return false;
		} else if(length == 0 && current.isWord == true) {
			System.out.println("**** SUCCESS **** for " + eachWord);
			return true;
		} else {
			System.out.println("**** FAILURE **** for " + eachWord);
			return false;
		}
	}

	public static void print(TrieNode root) {
		System.out.println("**************** Printing All words in a Trie **************** ");
		doPrint(root, 0, new char[100]);
	}

	public static void doPrint(TrieNode current, int level, char[] branch) {
		if(null == current) {
			return;
		}

		for(Character key : current.childMap.keySet()) {
			branch[level] = key;
			TrieNode nextLink = current.childMap.get(key);
			doPrint(nextLink, level + 1, branch);
		}

		for(int i = 0; i < level && current.isWord; i++) {
			System.out.print(branch[i]);
		}
		System.out.println();
	}

	public static void delete(String[] input, TrieNode root) {
		for(String eachWord : input) {
			System.out.println("Trying to delete " + eachWord);
			if(doSearch(eachWord, root)) {
				doDelete(root, eachWord, 0);	
			} else {
				System.out.println("Word does not exist: " + eachWord);				
			}
			print(root);
		}
	}

	public static void doDelete(TrieNode current, String input, int level) {
		if(null == current) {
			return;
		}

		if(level == input.length()) {
			current.isWord = false;
			if(current.numOfChilds == 0) {
				current.childMap.put(input.charAt(level - 1), null);
			}
			return;
		}

		TrieNode nextNode = current.childMap.get(input.charAt(level));
		doDelete(nextNode, input, level + 1);

		if(current.numOfChilds == 1 && nextNode.numOfChilds == 0) {
			current.childMap.put(input.charAt(level), null);
			current.numOfChilds = 0;
		}
	}

}