/**
	Question: Sort the array by the order of their frequency. The element that occured more times gets higher priority.	

	NOTE: This question is different from SortbyFreq.java

	Reference: http://www.geeksforgeeks.org/sort-elements-by-frequency/

	Logic - 1: (Using Maps and Sorting)
		- Create a Map and store element as key and value as count of the element.
		- Sort the map based on value.
*/

import java.util.*;

class SortByFrequency {
	public static void main(String[] args) {
		int[] array = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};  // o/p: {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < array.length; i++) {
			if(null == map.get(array[i])) {
				map.put(array[i], 1);
			} else {
				int count = map.get(array[i]);
				map.put(array[i], ++count);
			}
		}

		// NOTE: It's map.entrySet() not map.keySet()
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(set);

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
					public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
						return (m2.getValue()).compareTo(m1.getValue());
					}
		});


		for(int i = 0; i < list.size(); i++) {
			int count = list.get(i).getValue();
			while(count > 0) {
				System.out.print(list.get(i).getKey() + "\t");
				count--;
			}
		}
	}
}