import java.util.*;

class SortBoxUsingBase 
		implements Comparator<Box> {

	@Override
	public int compare(Box b1, Box b2) {
		int base1 = b1.width * b1.depth;
		int base2 = b2.width * b2.depth;

		// we have to print in decreasing order.
		return base2 - base1;
	}
}