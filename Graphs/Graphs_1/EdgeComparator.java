import java.util.*;

class EdgeComparator implements Comparator<Edge> {

	@Override
	public int compare(Edge e1, Edge e2) {
		if(e1.wgt <= e2.wgt) {
			return -1;
		} else {
			return 1;
		}
	}
}