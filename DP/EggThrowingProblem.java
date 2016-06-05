/**
	Question: Given two eggs and 6 floors. Find out from which floor the egg breaks.

	NOTE: If you have one cat then there is no other solution except to try for each floor linearly.

	Source: http://stackoverflow.com/a/3974179/967638   (Nikitha Ryback ans)
			https://www.youtube.com/watch?v=3hcaVyX00_4  (from Tushar Roy)
			https://www.youtube.com/watch?v=FQa8qbO5CNQ  (How to do it without using dynamic programming.)
			http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/

	Logic: 
		- Read stackoverflow link and watch video before going furthur.
		- Suppose say we have F floors and E eggs.
		- Say at floor k we dropped egg and we have two cases,
			- If egg breaks, then we have (k - 1) floors to check and (e - 1) eggs left. -- > BREAK
			- If egg does not break, then we have (F - k) floors (all floors above k) left and (e) eggs avilable. --> NO_BREAK
			==> MAX(BREAK, NO_BREAK) will be the number of ways.
			Why MAX?
				Since we will get more two values here where we need to select maximum of these ways so MAX.				
		- We need to add ONE to the above result since whether the above is passed or failed we have attempted. So plus ONE.
			==> 1 + Max(matrix[k - 1][e - 1], matrix[f - k][e])
		- We try this for all the floors and we need the best result => Min(function(k)) where k = 1, 2, 3 ..
			where Min(function(k)) =  Min(Max(a[k - 1][e - 1], a[f - k][e]) + 1) for all k = 1, 2, 3 ..


	Logic - 2: (Not logic but how to solve the problem by formula)
		- See video mentioned above --> https://www.youtube.com/watch?v=FQa8qbO5CNQ
		#) If you have 	
			- If you have one egg and we have 100 floors then we need 100 attemps at Max to know where it breaks. Since we have only one egg we need to go linearly from 1st floor to 100th floor and throw the egg at each floor and check the egg condition.
		#) What of you have two eggs and 100 floors?
			- We will use binary appraoch. Take mid point of [1 .. 100] that is 50. Throw an egg at floor 50,
				We have two cases here,
					Egg Survives: Then we take mid point of [51 .. 100] that is 75. And do the process again.
					Egg Breaks: Then we need to linearly search from [1 .. 49]. Total (worst case) = 49 + 1 = 50 
			- What if we change our approach and make in 10 intervals?
				[10 20 30 40 50 60 70 80 90 100]
			  Say, we have dropped egg-1 at 10 => Egg survived
			  	   dropped at 20  => Egg survived
			  	   ..
			  	   dropped at 90  => Egg survived.
			  	   dropped at 100 => Egg breaks.
			  So until 90 we tried and the egg did not break so 9 steps and at 100 egg breaked so 1 more step ==> 10 steps.
			  Now from 91 to 99 we try linearly with egg-2. => 9 more attemps 
			  Total ATTEMPTS = 10 + 9 = 19
		#) Let us get down the numbers for making the logic easy.
			Eggs = 2 and floors = 10 and assume the egg breaks at floor 9.
			Say we start floor 4 => "Egg survived" 
			then goto floor 7 => "Egg survived"
			then got floor 9 => "Egg breaks"
			So use another egg and goto floor 8 => "Egg survived"/"Egg breaks". 
			Total ATTEMPTS = 1 (at floor 4) + 1 (at floor 7) + 1 (at floor 9) + 1 (at floor 8)
						   = 4

			We can see a pattern in above selected floor numbers => 4 3 2 1
			that is, N + (N-1) + (N - 2) .. 1 >= 10 (total floors)
					=> N(N + 1)/2 >= 10 --> Make a suitable N such that the equation satisfies.

			Similarly for 100 floors, 
					=> N(N + 1)/2 >= 100 --> N = 14 will satisfy this condition. Hence total attempts required are 14.		
		
			For 6 floors,
					=> N(N + 1)/2 >= 6   --> N = 3 is the solution. So attempts is 3

*/

class EggThrowingProblem {
	public static void main(String[] args) {
		EggThrowingProblem eggObj = new EggThrowingProblem();

		int floors = 100; int eggs = 2;

		eggObj.printMinWays(floors, eggs);
	}

	void printMinWays(int floors,
							int eggs) {
		int ways = getMinWays(floors, eggs);
		System.out.println("Total Floors = " + floors + " and EGGS = " + eggs);
		System.out.println("Min number of ways with Max floors that egg should not break is: " + ways);
	}

	int getMinWays(int floors,
							int eggs) {
		int[][] numOfWaysMatrix = prepareNumOfWays(floors, eggs);
		return numOfWaysMatrix[floors][eggs];
	}

	int[][] prepareNumOfWays(int floors,
									int eggs) {

		
		// We need one extra row floor i,e. NO FLOOR.
		// We need one extra egg column i,e. NO EGGS.
		int[][] attempts_matrix = new int[floors + 1][eggs + 1];

		// f floors, e eggs, k kth floor which is less than f.
		// Initialize all the floors with no eggs as 0.
		for(int f = 0; f <= floors; f++) {
			attempts_matrix[f][0] = 0;
		}

		// Initialize all the eggs with no floor as 0.
		for(int e = 0; e <= eggs; e++) {
			attempts_matrix[0][e] = 0;
		}

		// If there is only 1 egg and we need to check for all f floors then we can only do it linearly.
		int one_egg = 1;
		for(int f = 1; f <= floors; f++) {
			attempts_matrix[f][one_egg] = f;
		}

		// We need to check for all floors with all eggs.
		// But with one egg we already know the result as it will increase linearly with floors.
		// So we filled the case floor 1 above and starting with egg = 2.
		for(int f = 1; f <= floors; f++) {
			for(int e = 2; e <= eggs; e++) {
				// initialize with max.
				attempts_matrix[f][e] = Integer.MAX_VALUE;

				// Take upto k floors where k = [0 .. f]
				for(int k = 1; k <= f; k++) {
					// If egg breaks at kth floor then we need value from previous attemps i,e. [k-1] with eggs [e - 1]
					int egg_breaks = attempts_matrix[k - 1][e - 1];

					// If the egg survives at kth floor then we are left with [f - k] floors with same number of eggs e
					int egg_survives = attempts_matrix[f - k][e];

					// One more attempt is for current attempt. 
					// Since whether the current is success or not we have attempted so plus ONE.
					// Why max? Worst case attempts will be the total attempts made. So MAX is used to get the max attempts.
					int result = 1 + Math.max(egg_breaks, egg_survives);

					// As we try for all floors so we need MINIMUM ways of all.
					attempts_matrix[f][e] = Math.min(attempts_matrix[f][e], result);
				} 
			}
		} // floor for loop.
		DPUtil.print2DMatrix(attempts_matrix);

		return attempts_matrix;
	}
}