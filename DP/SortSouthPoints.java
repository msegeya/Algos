import java.util.*;

class SortSouthPoints
			implements Comparator<Point> {
	@Override
	public int compare(Point p1, Point p2) {
		return p1.south - p2.south;
	}
}