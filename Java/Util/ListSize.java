import java.util.*;

class ListSize {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(null);
		list.add(3);

		System.out.println(list.size());
	}
}