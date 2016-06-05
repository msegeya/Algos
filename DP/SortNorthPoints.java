import java.util.*;

class SortNorthPoints
			implements Comparator<Point> {
	@Override
	public int compare(Point p1, Point p2) {
		return p1.north - p2.north;
	}
}