/**
	Question: Find minimum number of coins that make a given value.

	Reference: http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

	Logic: 
		- In previous CoinChange.java we got all the ways to find the sum.
		- We use the same logic as CoinChange.java but here we use one-dimentional matrix to solve the same.
		- The logic is,
		  #) Take matrix[total + 1] where indexes are from sum = 0 to sum = total.
		  #) Initialize matrix[0] = 0 and remaining indices with Integer.MAX_VALUE
		  #) If a coin can make change for the given sum then do the following,
		  	sub_result = matrix[sub_sum - coins[coin]] + 1 only if matrix[sub_sum - coins[coin]] is != Integer.MAX_VALUE.
		  	=> If coin is 5 and the sub_sum is 5. Then sub_result should be looking for column to the left of 5 steps.

*/

public class CoinChange_MinCoins {
	
	private int[] matrix;
	private int total;
	private int[] coins;
	
	public static void main(String[] args) {
		CoinChange_MinCoins mcObj = new CoinChange_MinCoins();
		mcObj.initialize();
		mcObj.printMinCoins();
	}
	
	public void initialize() {
		total = 30;
		
		coins = new int[3];
		coins[0] = 5; coins[1] = 10; coins[2] = 25;
		
		// we need one more row extra for 0 sum.
		// total sum is from 0 .. 10
		matrix = new int[total + 1];
	}
	
	public void printMinCoins() {
		int min_coins = getMinCoins(total, coins, matrix);
		System.out.println("Min. coins required for sum " + total + " is " + min_coins);
	}
	
	public int getMinCoins(int total, int[] coins, int[] matrix) {
		
		matrix[0] = 0;
		for(int r = 1; r < matrix.length; r++) {
			matrix[r] = Integer.MAX_VALUE;
		}

		for(int sub_sum = 1; sub_sum < total + 1; sub_sum ++) {
			for(int coin = 0; coin < coins.length; coin++) {
				if(coins[coin] <= sub_sum) {
					int sub_result = matrix[sub_sum - coins[coin]];
					if(sub_result != Integer.MAX_VALUE && (sub_result + 1) < matrix[sub_sum]) {
						matrix[sub_sum] = sub_result + 1;
					}
				}
			}
		}
		 
		return matrix[total];
	}
	
}
