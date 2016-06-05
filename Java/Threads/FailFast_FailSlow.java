/**
	Question: Before going furthur lets look at some of the terminologies.
	
	Reference: http://javahungry.blogspot.com/2014/04/fail-fast-iterator-vs-fail-safe-iterator-difference-with-example-in-java.html

	Concurrent Modification: 
	When one or more thread is iterating over the collection, in between, one thread changes the structure of the collection (either adding the element to the collection or by deleting the element in the collection or by updating the value at particular position in the collection) is known as Concurrent Modification

	#) Fail Fast Iterator:
	While iterating through the collection instantly throws "Concurrent Modification Exception" if there is a structural modification of the collection. Thus in the face of the concurrent modification the iterator fails quickly and cleanly rather than risking for any non-deterministic behaviour.

	Example: Following are the cases where we get "ConcurrentModificationException".
		Single Threaded Environment: After the creation of the iterator , structure is modified at any time by any method other than iterator's own remove method. 
		Multi-Threaded Environment: If one thread is modifying the structure of the collection while other thread is iterating over it.
	
	Question arises, how do the Fail-Fast iterator knows that there is a structural modification?
	Short Answer, using a flag called "mods".
	Long Answer, Iterator read internal data structure (object array) directly. The internal data structure(i.e object array) should not be modified while iterating through the collection. To ensure this it maintains an internal  flag "mods". Iterator checks the "mods" flag whenever it gets the next value (using hasNext() method and next() method). Value of mods flag changes whenever there is an structural modification. Thus indicating iterator to throw ConcurrentModificationException.

	#) Fail Safe Iterator:
	Fail Safe Iterator makes copy of the internal data structure (object array) and iterates over the copied data structure.Any structural modification done to the iterator affects the copied data structure. So, original data structure remains structurally unchanged. Hence, no "ConcurrentModificationException" throws by the fail safe iterator.

	Issues in Fail-Safe Iterator: (Two issues)
	- Overhead of maintaining the copied data structure i.e memory.
	- Fail safe iterator does not guarantee that the data being read is the data currently in the original data structure.

	This array never changes during the lifetime of the iterator, so interference is impossible and the iterator is guaranteed not to throw ConcurrentModificationException.The iterator will not reflect additions, removals, or changes to the list since the iterator was created. Element-changing operations on iterators themselves (remove(), set(), and add()) are not supported. These methods throw UnsupportedOperationException.

	We will write two methods to show FailFast and FailSafe.
*/

import java.util.*;
import java.util.concurrent.*;

class FailFast_FailSlow {
	public static void main(String[] args) {
		try {
			failFast();
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			failSlow();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void failFast() throws ConcurrentModificationException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Name", "Amarnath");
		map.put("Gender", "Male");
		map.put("Age", "28");

		Iterator iter = map.keySet().iterator();

		while(iter.hasNext()) {
			System.out.println(map.get(iter.next()));

			// let modify this while iterating. Because of this modification it throws Exception.
			map.put("City", "Bangalore");
		}
	}

	public static void failSlow() {
		ConcurrentHashMap<String, String> con_map = new ConcurrentHashMap<String, String>();
		con_map.put("Name", "Amarnath");
		con_map.put("Gender", "Male");
		con_map.put("Age", "28");

		Iterator iter = con_map.keySet().iterator();

		while(iter.hasNext()) {
			System.out.println(con_map.get(iter.next()));

			// Add this to the map. But it won't reflect the change here. So there will be no Exception here.
			con_map.put("City", "Bangalore");
		}
	}
}