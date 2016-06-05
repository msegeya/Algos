/**
	Question: Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
	In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property means the same).

	In simple, Given weights and each weight has some value. Given target weight. Find the weights whose sum will give us target with maximum value.

	Source: http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
			https://www.youtube.com/watch?v=8LusJS5-AGo&index=6&list=PLTS60CibV9pAotipCiJwCdtC6Sntzgbww

	Logic: See video, code comments and below example.

	Example: Given weights = {1, 3, 4, 5}; corresponding values = {1, 4, 5, 7}; Target_Weight = 7;
				Constraints for filling the table,
					0) Initially put all the benefits as 1 for the weight 1. Since we can take only one item and we put benefit as 1.
					1) If weight_sum value is < weight then the weight cannot out out cast the weight_sum. So get the value from the above cell.
					2) If the weight_sum >= weight then we have two cases,
						case-1: Include the current weight and calcualte as,
								For (weight_sum - weight) = remainder (say) => benefit for including weight is say V1.
								For remainder, get the value at cell [above_row][remainder_column]. (Above row's column, whose col = remainder.) => R1
								==> V1 + R1
						case-2: Excluding the current weight, that we will get from above row value (of same column) => say V2
								Finally we have to update with, Max(V1+R1, V2)

					weight_sum -->   		0	 1	 	2	 	3 	  	 4 	 	  5 	 	 6 	 		7
					  weights 	   (1)  1	0	 1	 	1	 	1	  	 1	 	  1	 		 1		 	1
		    values in brackets	   (4) 	3	0	 1	 	1       4(4+0)	 5(4+1)	  5(4+1)     5(4+1)		5(4+1)
								   (5)	4	0	 1   	1 		4		 5(5+0)	  6(5+1)	 6(5+1)		9(5+4)
								   (7)	5	0	 1   	1		4		 5		  7(7+0)	 8(7+1)		9(Max from above)

*/

class KnapsackProblem {
	public static void main(String[] args) {
		// int[] weights = {1, 3, 4, 5}; int[] values = {1, 4, 5, 7}; int targetWeight = 7; // Result: Max_Benefit is 9
		int[] weights = {10, 20, 30}; int[] values = {60, 100, 120}; int targetWeight = 50; // Result: Max_Benefit is 220 

		KnapsackProblem ksObj = new KnapsackProblem();
		ksObj.printMaxBenefit(weights, values, targetWeight);
	}

	void printMaxBenefit(int[] weights,
							int[] values,
								int targetWeight) {
		int max_benefit = getMaxBenefit(weights, values, targetWeight);
		System.out.println("DP - Maximum Benefit is: " + max_benefit);
	}

	int getMaxBenefit(int[] weights,
							int[] values,
								int targetWeight) {
		int[][] benefit_matrix = prepareBenefitMatrix(weights, values, targetWeight);
		
		System.out.println("Benefit Matrix:");
		for(int row = 0; row < weights.length; row++) {
			for (int col = 0; col <= targetWeight; col++) {
				System.out.print(benefit_matrix[row][col] + "\t");
			}
			System.out.println();
		}
		
		return benefit_matrix[weights.length - 1][targetWeight];
	}

	int[][] prepareBenefitMatrix(int[] weights,
										int[] values,
											int targetWeight) {
		int rowCount = weights.length;
		int colCount = targetWeight + 1;
		int[][] benefit_matrix = new int[rowCount][colCount];

		// For zero weight we don't get any benefits using the weight values.
		for(int row = 0; row < rowCount; row++) {
			benefit_matrix[row][0] = 0; 
		}

		// row is nothing but weights from [0 .. targetWeight] => [0 .. 7]
		// col are nothing but given weights.
		for(int row = 0; row < rowCount; row++) {
			for(int col = 1; col < colCount; col++) {

				int value_to_update = 0;

				if(row == 0) {
					value_to_update = 1;
				} else {
					// if current_target_weight >= weights then we can use it to get benefit else ignore it.
					if(col >= weights[row]) {
						// Get current weight benefit.
						int curr_wgt_benefit = values[row];
						// Get remaining weight benefit
						int remaining_wgt = col - weights[row];
						int rem_wgt_benefit = benefit_matrix[row -1][remaining_wgt];
						
						// Get weight from above
						int wgt_without_curr = benefit_matrix[row-1][col];

						// Finally get max of both benefit calculations.
						int incl_wgt_curr = Math.max(curr_wgt_benefit + rem_wgt_benefit, wgt_without_curr);

						value_to_update = incl_wgt_curr;
					} else {
						// Exclude the current weight and get the previous calculated ones.
						int excl_curr_wgt = benefit_matrix[row - 1][col];
						value_to_update = excl_curr_wgt;
					}	
				}

				benefit_matrix[row][col] = value_to_update;
			}
		}

		return benefit_matrix;	
	}
}
