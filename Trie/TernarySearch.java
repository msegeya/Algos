/**
	Question: Ternary search tree. An space efficient appraoch of Trie.

	Reference:  http://www.sanfoundry.com/java-program-ternary-search-tree/
				http://www.geeksforgeeks.org/ternary-search-tree/
				https://www.youtube.com/watch?v=XuFBUinUzcA

	Logic: 
		- Usually in Trie we have [a .. z] pointers. Only if we have all the words starting with [a .. z].
		- But we can still work out using just three pointer instead of 26 pointers. => Solution is Ternary Search Tree.
		- Each node will have 3 pointers, leftPtr, middlePtr, rightPtr. 
		- Create a node as root with the first character of the first input word. And it will be straight and simple. No need of any comparisons for 1st word.
			Example: "CAT"	=> C - A - T
		- Next word is "APPLE", letter "A" is less than root letter C so A should go to the leftPtr. As there are no letters after "A" to the left of "C" then just make it straight.
		- Logic is, 
					if the character is less than the input char then move it to left, 
					if same then ignore this and move to next input char, 
					if greater than move to right of the root.
		- So we space complexity is reduced.

	INSERT: Look at code comments.
	SEARCH: Look at code comments.
	PRINT: Look at code comments.
		
*/

import java.util.*;

class TernarySearch {

	public TernaryNode root;
	public String[] input = {"cat", "apple", "carrot", "cow"};
	public String[] search = {"apple", "cow", "meat"};

	public static void main(String[] args) {
		TernarySearch tsObj = new TernarySearch();
		tsObj.insert();
		tsObj.search();
		tsObj.print();
	}

	public void insert() {
		for(String eachWord : input) {
			root = doInsert(root, eachWord, 0);
		}
	}


	/*
		If current is null then create a node with the given char. After creating don't increment the index.
		Since the current node data is same as index data both less than or greater conditions will fail. (THESE TWO CASES WILL FAIL IF A NEW NODE IS CREATED.)
		So now we will go to equals condition.
		Check if index value is less than the word length. If so it means that there are more chars still pending else mark it as word ended.

	*/
	public TernaryNode doInsert(TernaryNode current, 
							String word, 
								int index) {
		if(null == current) {
			current = new TernaryNode(word.charAt(index));
		}

		if(word.charAt(index) < current.data) {
			current.left = doInsert(current.left, word, index);
		} else if(word.charAt(index) > current.data) {
			current.right = doInsert(current.right, word, index);
		} else {
			if(index + 1 < word.length()) {
				current.middle = doInsert(current.middle, word, index + 1);
			} else {
				current.isWordEnd = true;
			}
		}

		return current;
	}

	public void search() {
		for(String eachWord : search) {
			if(doSearch(root, eachWord, 0)) {
				System.out.println(eachWord + " " + "FOUND");
			} else {
				System.out.println(eachWord + " " + "NOT FOUND");
			}
		}
	}

	/*
		If input is less than the root data then move to left,.
		If greater than root data then move to right. 
		If equal then check if it is the end of word if so return true.
		If not then see whether index == word length, if this is true then the word is not there.
		Else, it means the current char is same as root char and so move on towards the middle pointer.
	*/
	public boolean doSearch(TernaryNode current, 
								String word, 
									int index) {

		if(null == current) {
			return false;
		}

		if(word.charAt(index) < current.data) {
			return doSearch(current.left, word, index);
		} else if(word.charAt(index) > current.data) {
			return doSearch(current.right, word, index);
		} else {
			if(current.isWordEnd && index == word.length() - 1) {
				return true;
			} else if(index == word.length() - 1) {
				return false;
			} else {
				return doSearch(current.middle, word, index + 1);
			}
		}

	}

	List<String> outputWords = new ArrayList<String>();
	public void print() {
		System.out.println("**************** Printing all words ****************");
		doPrint(root, "");
		for(int i = 0; i < outputWords.size(); i++) {
			System.out.println(outputWords.get(i));
		}
	}

	/*
		Start from the root go left until there is no left.
		Then add the node data to output
		If node's isWordEnd is true then add it to output list.
		Then goto middle, now start the same process again just like the way we started from root.
		Since the root of the middle is already traversed so we will substring from 0 to (length-1)
		Then move to right node and do the same again.
	*/
	public void doPrint(TernaryNode current, String output) {
		if(null != current) {
			doPrint(current.left, output);

			output = output + current.data;
			if(current.isWordEnd) {
				outputWords.add(output);
			}

			doPrint(current.middle, output);
			output = output.substring(0, output.length() - 1);

			doPrint(current.right, output);
		}
	}
}