/**
	Question: Given a "2 x n" board and tiles of size "2 x 1", count the number of ways to tile the given board using the 2 x 1 tiles. A tile can either be placed horizontally i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile.

	See below for explanation.

	Source: http://www.geeksforgeeks.org/tiling-problem/
			http://stackoverflow.com/questions/21205186/solving-tiling-problems

	Question Explanation:
		Let's take n = 1 => 2 x 1 => It means, 1 tile and with 2 cross (cross mean virtually we divide the tile into two half). 
		NOTE: THE FLOOR SHAPE REMAINS CONSTANT BUT ONLY THE TILE SHAPE CAN BE CHANGED.
		In the below one, the floor is vertical so we kept the tile vertically. 
		If the floor is horizontal then we will keep the tile horizontally.
		
		The floor can be divide (VIRTUALLY). See 2x2 tile example for its usage.
						 ------ 
						|      |
						| -A-  |
						|      |	
						 ------    

		Take 2 x 2, ==> 2 ways are possible
	        Place 2x1 and 2x1 vertically. 
			 ------------
			|     |	     |
            | T1 ---  T2 |
			|     |      |
             ------------

            Place the 2x1 and 2x1 horizontally one above the other.
			 ------------
			|     T1     |
            |------------|
			|     T2     |
             ------------

        Take 2 x 3,   == > 3 ways are possible.  
  			 -------------------
			|       	   		|
            |	T1  | T2  |	 T3	|
			|     	     		|
             -------------------
 
			 -------------------			
			|     T1     		|
            |-----------|	T3	|
			|     T2     		|
             -------------------

			 -------------------			
			|     	    T2		|
            |  T1  |------------|
			|     	    T3 		|
             -------------------

		Take 2 x 4, ==> 5 ways (You can try to draw and conclude number of ways.)

	Logic: 
		- By looking at the example we can say 
				for 2x1, 1 tile is possible.
				For 2x2, 2 ways are possible.
		 		For 2x3, 3 ways are possible.
		 		For 2x4, 5 ways are possible.
		  ==> By this we can see a pattern that is "FIBONACCI SERIES".
		
*/

class TilingProblem {
	public static void main(String[] args) {
		// int tiles = 1;
		// int tiles = 5;
		// int tiles = 4;
		int tiles = 3;

		TilingProblem tpObj = new TilingProblem();
		tpObj.printPossibleTilingWays(tiles);
	}

	void printPossibleTilingWays(int tiles) {
		int totalWays = getTilingWays(tiles);
		System.out.println("Total Tiling Ways: " + totalWays);
	}

	int getTilingWays(int tiles) {
		int tileWays = getTileWaysUsingFibo(tiles);
		return tileWays;
	}

	int getTileWaysUsingFibo(int num) {
		if(num == 1) {
			return num;
		} 

		if(num == 2) {
			return num;
		}

		return getTileWaysUsingFibo(num - 1) + getTileWaysUsingFibo(num - 2);

	}
}