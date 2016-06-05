import java.util.*;

class GraphUtil {
	public static void print(int[][] matrix) {
		int ROWS = matrix.length;
		int COLS = matrix[1].length;

		System.out.println("Graph matrix is: \n");
		for(int row = 1; row < ROWS; row++) {
			for(int col = 1; col < COLS; col++) {
				try{
					System.out.print(matrix[row][col] + "\t");	
				} catch(Exception e) {

				}
			}
			System.out.println();
		}
	}

	public static void print(int[][] matrix, int source) {
		int ROWS = matrix.length;
		int COLS = matrix[1].length;

		System.out.println("Start point of Graph is: " + source);
		System.out.println("Graph matrix is:");
		for(int row = 1; row < ROWS; row++) {
			for(int col = 1; col < COLS; col++) {
				System.out.print(matrix[row][col] + "\t");
			}
			System.out.println();
		}
	}

	public static void printEdges(List<Edge> edges, String msg) {

		if(null == msg) {
			msg = "Printing all Edges";
		}

		if(null == edges || edges.size() == 0) {
			System.out.println(msg + " " + " No Edges.");
			return;
		}

		System.out.println(msg);
		for(int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			System.out.println("(" + edge.src + ", " + edge.des + ") = " + edge.wgt);
		}
	}

	public static List<Edge> removeLoops(List<Edge> edges) {
		if(null == edges || edges.size() == 0) {
			return null;
		}

		for(int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			if(edge.src == edge.des) {
				edges.remove(i);
			}
		}

		return edges;
	}

	public static List<Edge> removeParEdges(List<Edge> edges) {
		if(null == edges || edges.size() == 0) {
			return null;
		}

		for(int i = 0; i < edges.size(); i++) {
			Edge main_edge = edges.get(i);
			for(int j = 0; j < edges.size(); j++) {
				Edge sub_edge = edges.get(j);

				if(main_edge.src == sub_edge.src && main_edge.des == sub_edge.des) {
					if(main_edge.wgt != sub_edge.wgt && sub_edge.wgt != -1) {
						if(main_edge.wgt > sub_edge.wgt) {
							edges.remove(i);
							break;
						}
					}
				}
			}
		}

		return edges;
	}

	public static int[][] preMatrixFromEdges(List<Edge> edges, int V) {
		int[][] matrix = new int[V + 1][V + 1];

		for(int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			int row = edge.src;
			int col = edge.des;

			matrix[row][col] = edge.wgt;
		}

		return matrix;
	}

	public static int getWgt(List<Edge> edges) {
		int cost = 0;
		if(null == edges || edges.size() == 0) {
			return cost;
		}

		for(Edge edge : edges) {
			cost = cost + edge.wgt;
		}

		return cost;
	}

}