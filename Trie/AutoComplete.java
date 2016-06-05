/**
	Question: Auto complete feature using Trie.

	NOTE: Ternary Search Tree are good for auto complete than Trie. Since Trie has a disadvantage with space complexity. But we will implement only using Trie. I thik that should be good.

	Reference: Own implementation

	Logic:
		- We already know how to construct a Trie.
		- Let us construct a Trie with the words starting with same characters upto a certain length.
			Example: 
				Construct words like "cona", "coni", "cony", "conia". When you give input as "con" then we should get output as "cona", "coni", "cony". That is we are printing words that are one level close to given word. That is words that are completed in the level equal to length of the word and the next level. "conia" also ends but it is at the next level. So ignore it.
								
								   A	
								  /
								 I	
								/
				ROOT - C - O - N - A 
								\
								 Y

		- So when we enter "CON" all the words that end in next level including the given string if it is already ended.
*/

import java.util.*;

class AutoComplete {
		
	private TrieNode root;
	private String[] input = {"cona", "coni", "cony", "conia"}; // some random letters
	private String[] testStr = {"con", "dog"};

	public static void main(String[] args) {
		AutoComplete acObj = new AutoComplete();
		acObj.initialize();
		acObj.checkAutoCom();
	}

	public void initialize() {
		root = Trie.insert(input, root);
	}

	public void checkAutoCom() {
		printAutoComStr(testStr);
	}

	public void printAutoComStr(String[] testInput) {
		for(String eachWord : testInput) {
			int length = eachWord.length();
			TrieNode current = root;
			// assume at most we will have 10 strings in auto complete.
			String[] output = new String[10];
			StringBuilder builder = new StringBuilder();
			int k = 0;
			for(int i = 0; i < eachWord.length(); i++) {
				builder.append(eachWord.charAt(i));
				TrieNode nextNode = current.childMap.get(eachWord.charAt(i));
				if(nextNode != null) {
					length--;

					if(length == 0) {
						if(nextNode.isWord) {
							output[k] = new String(builder);
							k++;
						}

						// I have used current here and it will fail if you use current. Since current is still not at the last character.
						// So use nextNode.
						Map<Character, TrieNode> map = nextNode.childMap;
						for(Character key : map.keySet()) {
							TrieNode nextLink = map.get(key);
							if(null != nextLink && nextLink.isWord) {
								builder.append(nextLink.data);
								output[k] = new String(builder);
								k++;
								builder.setLength(builder.length() - 1);
							}
						}
						break;
					} else {
						current = nextNode;
					}
				} else {
					break;
				}
			}

			if(0 != length) {
				System.out.println(eachWord + " " + "has no Words available to auto-complete.");
			} else {
				if(length == 0 && k != 0) {
					System.out.println(eachWord + " " + "has auto compelte strings as, ");
					for(int index = 0; index < k; index++) {
						System.out.println(output[index]);
					}	
				}
			}
		}
	}

}