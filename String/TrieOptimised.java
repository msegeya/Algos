/**
	Source: http://codereview.stackexchange.com/questions/32010/trie-code-review-request-for-improvement

	Question: Trie DS

	Time Complexity: (M words, N is the longest word.)
		O(M * logN)

	Space Complexity: May be all the letter in all the words. (WORST CASE)
	
	Search Complexity: O(M), where M is the length of the given word.

	Logic: 
		- Each node has a Map.
		- Words: "ant", "be", "hello"
		- The first node is empty. When the first word is given as input. Then take the first char in the word, see if the first char is present or not.
			- If char present, then ignore this char and go for the next char in the input word.
			- If the char is not present then, create a node with that char.

*/

import java.util.*;

public class TrieOptimised {
	
	private TrieNodeOptimised root;
	
	public static void main(String[] args) {
		String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
		
		TrieOptimised toObj = new TrieOptimised();
		toObj.prepareTrie(words);
		
		toObj.print();
		
		// "alk", "zip" does not exist.
		String[] searchWords = {"allot", "all", "be", "alk", "zip"};
		toObj.search(searchWords);
	}
	
	void prepareTrie(String[] words) {
		
		root = new TrieNodeOptimised(' ');
		
		for(String word: words) {
			root = insert(root, word);
		}
	}
	
	TrieNodeOptimised insert(TrieNodeOptimised root, 
							String word) {
		TrieNodeOptimised currentNode = root;
		Map<Character, TrieNodeOptimised> map = null;
		
		for(int i = 0; i < word.length(); i++) {
			char cur_char = word.charAt(i);
			map = currentNode.charMap;
			
			// If the char is not available in the map then we need to create a node and place it in the map.
			TrieNodeOptimised link = map.get(cur_char);
			if(null == link) {
				TrieNodeOptimised newNode = new TrieNodeOptimised(cur_char);
				map.put(cur_char, newNode);
				currentNode = newNode;
			} else {
				currentNode = link; 
			}
		}
		currentNode.wordEnded = true;
		
		return root;
	}
	
	
	void search(String[] searchWords) {
		System.out.println("\nSearch Results: ");
		for(String search : searchWords) {
			boolean searchStatus = search(root, search);
			if(searchStatus) {
				System.out.println("Word found: " + search);
			} else {
				System.out.println("Word NOT found: " + search);
			}
		}
	}
	
	boolean search(TrieNodeOptimised root, 
								String search) {
		TrieNodeOptimised current = root;
		int i = 0;
		for(i = 0; i < search.length(); i++) {
			TrieNodeOptimised nextNode = current.charMap.get(search.charAt(i));
			if(null == nextNode){
				break;
			}
			current = nextNode;
		}
		
		if(current.wordEnded && i == search.length()) {
			return true;
		}
		
		return false;
	}
	
	void print() {
		System.out.println("Words present are: ");
		print(root, 0, new char[50]);
	}
	
	void print(TrieNodeOptimised root, 
								int level, 
									char[] branch) {
		if(null == root) {
			return;
		}
		
		// for each char
		for(Character key : root.charMap.keySet()) {
			branch[level] = key;
			TrieNodeOptimised nextLink = root.charMap.get(key); 
			print(nextLink, level + 1, branch);
		}
		
		if(root.wordEnded) {
			for(int i = 0; i < level; i++) {
				System.out.print(branch[i]);
			}
			System.out.println();
		}
	}
}