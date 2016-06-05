/**
	Source: http://stackoverflow.com/questions/185697/the-most-efficient-way-to-find-top-k-frequent-words-in-a-big-word-sequence

	Question: The Most Efficient Way To Find Top K Frequent Words In A Big Word Sequence

	Logic: 
		- Same as word count logic. Split the words and insert them into Map.
		- After Map construction, Insert each (key, value) pait (say a class Word) from Map into a Heap of Size k. 
		- After the last insertion get the objects from heap and print them.
*/

import java.util.*;

class WordCountTopK {
	public static void main(String[] args) {
		String input = "Welcome to the world of Geeks This portal has been created to provide well written well thought and well explained solutions for selected questions If you like Geeks for Geeks and would like to contribute here is your chance You can write article and mail your article to contribute at geeksforgeeks org See your article appearing on the Geeks for Geeks main page and help thousands of other Geeks";
		int k = 5;

		WordCountTopK wck = new WordCountTopK();
		wck.printKTopWords(input, k);
	}

	void printKTopWords(String input, int k) {
		PriorityQueue<WordAndCount> pq = getTopKWords(input, k);

		while(!pq.isEmpty()) {
			WordAndCount wc = pq.remove();
			System.out.println("Word = " + wc.word + " \t\tCount = " + wc.count);
		}
	}

	/**
	 	For each insert into the priority queue,
	 		- If the priority queue is of size k then get the minimum count word (say MIN_WORD_PQ) in the pq and see whether the current word count from map is greater than that of the MIN_WORD_PQ. If so then remove it and insert current word into the pq, else ignore this word.
			- If the pq size is less than k then insert the map word into the queue.
	*/
	PriorityQueue<WordAndCount> getTopKWords(String input, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		int max_word_count = 0;
		String max_word = null;

		// You can split them using split function like
		String[] words = input.split("\\s+");
		for(String word : words) {
			if(map.get(word) != null) {
				int count = map.get(word);
				map.put(word, ++count);
			} else {
				map.put(word, 1);
			}
		}

		// PQ will be in increasing order.
		WordAndCountSort wcsort = new WordAndCountSort();
		PriorityQueue<WordAndCount> pqwc = new PriorityQueue<WordAndCount>(k, wcsort);
		for(String key : map.keySet()) {

			// Since we are looking for top k words so there is no point in storing all the words in the queue.
			// If the size of PQ = k, get the peek element and check whether the count of it is less than the current word from map
			// If so then remove the word from current and insert map's word into the PQ.
			if(pqwc.size() == k) {
				WordAndCount wac = pqwc.peek();
				if(wac.count < map.get(key)) {
					pqwc.remove();
					pqwc.add(new WordAndCount(key, map.get(key)));		
				}
			} else {
				pqwc.add(new WordAndCount(key, map.get(key)));
			}
		}

		return pqwc;
	}
}