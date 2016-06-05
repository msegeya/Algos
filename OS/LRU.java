/**
	Source: https://www.youtube.com/watch?v=4wVp97-uqr0
			http://www.careercup.com/question?id=17230678
			http://www.geeksforgeeks.org/implement-lru-cache/
			http://stackoverflow.com/questions/23772102/lru-cache-in-java-with-generics-and-o1-operations

	Question: LRU (Least Recently Used) algorithm

	Info:
		PAGE: A page is a block of data.
		FRAME: A frame is the physical address for storing the page.
		PAGE HIT: If the page is already available in the frames.
		PAGE FAULT: If the page is not available in the frames.

	Example: 
		- Take pages P[] = {7, 0, 1, 2, 0, 4}; Frames F[] = { , , } (Initially empty and are of size 3.)
			For 7: Check if p[0] = 7 is present in frame? Nope. ==> f[0] = 7; ==> f[] = {7, , }
			For 0: Not present => f[1] = 0; ==> f[] = {7, 0, };
			For 1: Not present => f[2] = 1; ==> f[] = {7, 0, 1};
			For 2: Not present => Now all 3 frames are full so we need to check which of them is the most recently used one.
				   - From input '2' go backwards => we have 1, 0, 7 => 1 is most recently used, 0 is next most, 7 is least recently.
				   - So we need to replace 7. => f[0] = 2; ==> f[] = {2, 0, 1};
			For 0: Present. So make it as most recent by using linked list. (We will expliain it later.) ==> f[] = {2, 0, 1};
			For 4: Not present => Least used is  1 so ==> f[] = {2, 0, 4};

	Logic: 
		- Watch the above video for more details and the example.
		- You will be given a set of pages say P and frames say F. You need to put these pages into frames and calcualtes the number of page faults.
		- We will use a Map and a Queue to keep SINK of the elements in the frame.
		- We use Map because to check whether the element is present in the Queue or not in O(1).
		- When an NEW_PAGE is inserted, check if the NEW_PAGE is peresent in the map or not,
			If not-present, then remove the NEW_PAGE from the queue (if present in queue)
			It present, then remove the NEW_PAGE from the map and Queue.
		- Finally put the NEW_PAGE in the queue and the map.
*/


import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class LRU {

	public static void main(String[] args) {
		int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2};
		int frames = 3;

		LRU lruObj = new LRU();
		lruObj.printPageFaults(pages, frames);
	}

	void printPageFaults(int[] pages, 
								int frames) {
		int pageFaults = getPageFaults(pages, frames);
		System.out.println("Page Faults: " + pageFaults);
	}	

	int getPageFaults(int[] pages, int CAPACITY) {

		// Map acts like FRAMES.
		Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();

		// Queue acts as the visited pages. Such that we can use queue to know which of the latest one to be replaced.
		Queue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

		// count the total page faults.
		// If the page is not present in the map, then it's a page fault.
		int page_faults = 0;

		for(int page : pages) {
			// If the page is present in the map then delete the page from the queue.
			// such that we can push the map to FRONT as most recent.
			if(null == map.get(page)) {
				queue.remove(page);

				// increment the page_faults count if the page is not present in the frames.
				page_faults++;
			} else {
				queue.remove(page);
				map.remove(page);				
			}

			// remove the pages that are already present in the map. 
			// Since we need remove the pages that are not present within the frame size.
			while(queue.size() >= CAPACITY) {
				int old_page = queue.poll();
				if(old_page >= 0) {
					map.remove(old_page);
				}
			}

			queue.add(page);
			map.put(page, page);

			printQueue(queue, page);
		}
		return page_faults;
	}


	void printQueue(Queue<Integer> queue, int insertEle) {
		System.out.print("Inserted " + insertEle + ": ");
		for(int element : queue) {
			System.out.print(element + "  ");
		}
		System.out.println();
	}
}