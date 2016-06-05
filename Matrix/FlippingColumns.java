/**
	Question: Flipping Columns. Suppose that we are given an m x n grid of zeros and ones and want to transform the grid so that the maximum number of rows are composed solely of ones. The only operation we are allowed to perform on the grid is picking some column and flipping all of the zeros and ones in that column. 

	Reference:  http://stackoverflow.com/a/26695157/967638
				http://stackoverflow.com/a/7118342/967638

	Logic:
		- Find all unique rows in a given matrix. Say them as S1, S2, ... Sn
		- Declare an array count[] of size of unique rows. And count[i] will be the number of rows same as 'Si'. Use Trie to find the duplicat rows and increment the count of that index.
		- 	maxCount = 0
		    For each si,
				For each sj
					if(sj == si) 
						continue
					else
						if(count(si) + count(sj) > maxCount)
							maxCount = count(si) + count(sj)
		    return maxCount.				
*/


class FlippingColumns {
	public static void main(String[] args) {
		int[][] matrix = {
							{0, 1, 0, 0},
							{0, 1, 1, 1},
							{0, 1, 0, 0},
							{1, 1, 1, 0}
						 };

		

	}
}