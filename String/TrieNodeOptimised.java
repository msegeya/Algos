import java.util.*;

public class TrieNodeOptimised {
	public char letter;
	public boolean wordEnded;
	public Map<Character, TrieNodeOptimised> charMap;
	
	public TrieNodeOptimised(char letter) {
		this.letter = letter;
		this.charMap = new HashMap<Character, TrieNodeOptimised>();
		wordEnded = false;
	}
}