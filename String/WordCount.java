/**
	Source: http://stackoverflow.com/questions/7540351/find-word-with-maximum-number-of-occurrences
			http://www.geeksforgeeks.org/find-the-k-most-frequent-words-from-a-file/

	Question: Find word with maximum number of occurrences
	
	Logic: 
		- Split words of the file using String's split funtionality.
		- For each word,
				If exists in map then increment count by 1
				If does not exist then put in map with value as 1
		- While traversing also keep track of max_count and max_count_word.
*/

import java.util.*;

class WordCount {
	public static void main(String[] args) {
		String input = "Welcome to the world of Geeks This portal has been created to provide well written well thought and well explained solutions for selected questions If you like Geeks for Geeks and would like to contribute here is your chance You can write article and mail your article to contribute at geeksforgeeks org See your article appearing on the Geeks for Geeks main page and help thousands of other Geeks";

		WordCount wcObj = new WordCount();
		wcObj.printMaxCountWord(input);
	}

	void printMaxCountWord(String input) {
		Map<String, Integer> map = getMaxCountWord(input);

		for(String key : map.keySet()) {
			System.out.println("Word = " + key + "\tCount = " + map.get(key));	
		}
	}

	Map<String, Integer> getMaxCountWord(String input) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		int max_word_count = 0;
		String max_word = null;

		// You can split them using split function like
		String[] words = input.split("\\s+");
		for(String word : words) {
			if(map.get(word) != null) {
				int count = map.get(word);
				map.put(word, ++count);

				if(count > max_word_count) {
					max_word_count = count;
					max_word = word;
				}
			} else {
				map.put(word, 1);
			}
		}

		map.clear();
		map.put(max_word, max_word_count);

		return map;
	}
}