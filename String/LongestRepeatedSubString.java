import java.util.*;

class LongestRepeatedSubString {

	private static String max_str = "";

	public static void main(String[] args) {
		String input = "wgyckaycka";
		createTrie(input);
	}

	public static void createTrie(String input) {
		TrieNode_LRS root = new TrieNode_LRS(' ');
		for(int i = 0; i < input.length(); i++) {
			String data = input.substring(i, input.length());
			root = insert(root, data);
		}

		System.out.println(max_str.length());
	}

	public static TrieNode_LRS insert(TrieNode_LRS root, String data) {
		StringBuilder builder = new StringBuilder();

		TrieNode_LRS current = root;
		for(int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			if(null == current.link.get(ch)) {
				TrieNode_LRS newNode = new TrieNode_LRS(ch);
				current.link.put(ch, newNode);
				current = newNode;
			} else {
				builder.insert(builder.length(), ch);
				current = current.link.get(ch);
			}
		}

		if(max_str.length() <= builder.length()) {
			max_str = builder.toString();
		}

		return root;
	} // insert

}


class TrieNode_LRS {
	public char data;
	public Map<Character, TrieNode_LRS> link;

	TrieNode_LRS(char ch) {
		this.data = ch;
		this.link = new HashMap<Character, TrieNode_LRS>();
	}
}