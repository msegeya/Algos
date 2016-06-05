/**
	Question: Sort the array elements by their frequency. if two numbers have the same freuqency then the number which first came in the array should be given the higher priority.

	NOTE: This question is different from SortByFrequency.java. Here we need to print elements in the order of their frequency.
*/

import java.util.*;

class SortbyFreq {
	public static void main(String[] args) {
		int[] array = {2, 5, 2, 8, 5, 6, 8, 8}; // {8, 2, 5, 1}
		Map<Integer, FreqEle> map = new TreeMap<Integer, FreqEle>();
		List<FreqEle> list = new ArrayList<FreqEle>();
		
		for(int i = 0; i < array.length; i++) {
			if(null == map.get(array[i])) {
				map.put(array[i], new FreqEle(array[i], 1, i));
			} else {
				FreqEle temp = map.get(array[i]);
				temp.count++;
				if(temp.index > i) {
					temp.index = i;
				}
			}
		}
		
		Set<Integer> keys = map.keySet();
		for(Integer key : keys) {
			list.add(map.get(key));
		}
		
		map.clear();
		keys.clear();
		
		Collections.sort(list, new Comparator<FreqEle>() {
									public int compare(FreqEle o1, FreqEle o2) {
										// If freuqency is more then return it.
										// If freuqency is same then return the element 
										// that occured first in the array.
										if(o1.count != o2.count) {
											return o2.count - o1.count;
										} else {
											return o1.index - o2.index;
										}
									};
								});
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).element + " ");
		}
	}
	
}

class FreqEle {
	int element;
	int count;
	int index;
	
	public FreqEle(int element, int count, int index) {
		this.element = element;
		this.count = count;
		this.index = index;
	}
}