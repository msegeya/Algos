/**
	Question: Input is infinaite number of S = {s1, s2, .. } valued coins and given a input value "N". How many ways can we make the change for N? Order of coins in the result set does not matter.

	Source: https://www.youtube.com/watch?v=_fgjrs570YE&list=PLTS60CibV9pAotipCiJwCdtC6Sntzgbww&index=6
			http://www.algorithmist.com/index.php/Coin_Change (See Dynamic Programming code)
			http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
			  
	NOTE: Sort the denomination before constructing the matrix.

	Logic: 
		- Look at the video in the above mentioned link.

	Example: 
		Input: S = {1, 2, 3} and N = 5
		Output: 5 ways. 
		Way-1: {1, 1, 1, 1, 1}
		Way-2: {1, 1, 1, 2}
		Way-3: {1, 2, 2}
		Way-4: {2, 3}
		Way-5: {1, 1, 3}

	Queries?
		- What if there is no denomination with 1? If the denomination starts with 2, 3, 4.
		  ==> Refer CoinChange_MinCoins.java
*/

class CoinChange {
	private int[] coins;
	private int N;

	public static void main(String[] args) {
		CoinChange ccObj = new CoinChange();
		ccObj.prepareInput();
		ccObj.printTotalChangeWays();
	}

	void prepareInput() {
		coins = new int[3]; 
		coins[0] = 1; coins[1] = 2; coins[2] = 3;

		N = 5;
	}

	void printTotalChangeWays() {
		int numOfCoins = coins.length;
		int totalWays = getChangeWays(coins, N, numOfCoins);

		System.out.println("Total number of ways: " + totalWays);
	}

	int getChangeWays(int[] coins,
							int N,
								int numOfCoins) {
		int[][] coinMatrix = getCoinMatrix(coins, N, numOfCoins);
		return coinMatrix[numOfCoins-1][N];
	}

	int[][] getCoinMatrix(int[] coins, 
								int N,
									int numOfCoins) {
		int rowCount = numOfCoins;
		int colCount = N + 1;
		int[][] coinMatrix = new int[rowCount][colCount];

		// Initialize all the rows of 0th column as 0.
		for(int row = 0; row < rowCount; row++) {
			coinMatrix[row][0] = 1;
		}

		// NOTE: Required sum is in COLUMNS and denominations are in ROWS.
		for(int row = 0; row < rowCount; row++) {
			for(int col = 1; col < colCount; col++) {

				// Count number of ways using current coin.
				// For each sum (column value) check whether you can make change or not. 
				// Change is possible only if the (sum - denomination_in_that_row) >= 0 else return 0
				// If change is possible then how to calculate?
				// We get the value of the cell which is to the left (same row) of current cell by step size of the denomination.
				// How does this logic works? Why should we move towards left? 
				// Every value we get in DP is by quering for the previous result + current result. 
				// Take an example, with denomination 2 (row 1) and sum as 2 (col 1)
				// So we need all the ways for sum 2 using denomination 1 and denomination 2.
				// incl_curr calculates using denomination 2 and excl_curr calcualtes previous denominations.
				// incl_curr: 
				// 		If the sum is not possible using the denomination that is (sum < denomination) then return 0
				// 	 else, we will move towards left and check how many 2's alone are required to get the sum 2 ==> 1 way.
				//      Why left? Because when we substract coin value from sum we get remainder. Now for the remainder go to the sum(column) which has this 
				//      remainder and get the number of ways. The result for this gives us the number of ways using the current coin.
				// 		Similarly,
				// 				 if we need sum 3 with denomination 2 ==> 3 - 2 = 1. Goto column(sum) 1 an get the number of ways.
				// 				 if we need sum 4 with denomination 2 ==> 4 - 2 = 2. Goto column(sum) 2 an get the number of ways.
				//				 if we need sum 5 with denomination 2 ==> 5 - 2 = 3. Goto column(sum) 3 an get the number of ways.
				int incl_curr = (col - coins[row] >= 0 ? coinMatrix[row][col - coins[row]] : 0);

				// Now count the number of ways from previous coins excluding the current one.
				// We will get the result of this using by quering the previous coin(s) result for the same sum.
				int excl_curr = (row > 0 ? coinMatrix[row - 1][col] : 0);

				coinMatrix[row][col] = incl_curr + excl_curr;
				System.out.print(coinMatrix[row][col] + "\t");
			}
			System.out.println();
		}
		return coinMatrix;
	}

	/*    coins {1, 2, 3} and N = 5
		   sum ->0	1	2	3	4	5
		   (1)0  1	1	1	1	1	1
	coins  (2)1	 1	1   2   2   3   3 
		   (3)2	 1  1   2	3	4	5
	*/

}