/**
	Source: https://www.youtube.com/watch?v=UTXkbcJUY74&index=2&list=PLTS60CibV9pCl3pnwrMiyDz1ftZZshHn8

	Question: FIFO - Page Replacement Algorithm

	Logic: 
		- Watch the video. The logic is written based on the video.
		- Take a map of frame capcaity and when a page occurs,
			- If page is already present, then just igonore the page.
			- If page is not present, then check whether the map capacity is full or not,
				- If full, then delete the first element that is present in the map. How do you know the first element?
				 ==> Keep a pointer called START at the start of the array. Now, 
*/

import java.util.*;

class FIFO {
	public static void main(String[] args) {
		int[] pages = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3};
		// int[] pages = {3, 2, 2, 4, 5, 4};
		int frames = 4;

		FIFO fifoObj = new FIFO();
		fifoObj.printPageFaults(pages, frames);
	}

	void printPageFaults(int[] pages, 
								int frames) {
		int page_faults = getPageFaults(pages, frames);
		System.out.println("FIFO: Page Faults = " + page_faults);
		System.out.println("FIFO: Page Hits = " + (pages.length - page_faults));
	}

	int getPageFaults(int[] pages, 
							int CAPACITY) {
		Map<Integer, Integer> map_frames = new HashMap<Integer, Integer>();
		int page_faults = 0;

		for(int i = 0, start = 0; i < pages.length; i++) {
			int page = pages[i];

			// If page is null then we don't have the page in the frames.
			// Two cases: 
			// If map count is greater than CAPACITY then delete the page at start.
			// If not greater than CAPACITY then just put the page in the frame.
			if(null == map_frames.get(page)) {
				page_faults++;

				if(map_frames.size() == CAPACITY) {
					int delete_page = pages[start];
					map_frames.remove(delete_page);
					start++;

					// after deletion a place will be free so put the current page.
					map_frames.put(page, page);
				} else {
					map_frames.put(page, page);
				}
			}

			printFramePages(map_frames, page);
		}

		return page_faults;
	}

	void printFramePages(Map<Integer, Integer> map, int insertPage) {
		System.out.print("Insert Key " + insertPage + ":  ");
		for(Integer key : map.keySet()) {
			System.out.print(map.get(key) + " ");
		}
		System.out.println();
	}
}