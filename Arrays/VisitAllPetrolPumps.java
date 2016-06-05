/**
	Question: Find the first circular tour that visits all petrol pumps. Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data {X, Y}
		where X = The amount of petrol that every petrol pump has.
			  Y = Distance from that petrol pump to the next petrol pump.

	In this question, you need to find from which petrol pump you should start your journey so that you can reach all other pump and finally to the starting point forming a circular track without having negative amount of petrol in your truck.		  
	
	Example: Let there be 4 petrol pumps with (X, Y). ==> {4, 6}, {6, 5}, {7, 3} and {4, 5} ==> Start Pos = 1

	Reference:  http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
				http://ideone.com/qEmWmT
				http://stackoverflow.com/questions/13258144/find-the-index-in-the-circle-such-that-a-traveler-can-completes-one-round

	Logic: 
		- Start at the first petrol pump. 
		- Get the petrol left as, (petrol_at_this_pump - distance_to_next_pump)
		- If the distance < petrol then we will be left with some petrol else petrol will be negative.
			==> Inroder to keep track of the petrol we will use "petrol_upToNow".
		- How to update it petrol_upToNow?
			If the petrol_upToNow >= 0 then just add the cur_petrol to it.
			Else change the start position and make the petrol_upToNow as cur_petrol.
		- Check total petrol that is used so far. If total is < = then path is not possible else return the start position.
*/

class VisitAllPetrolPumps {
	public static void main(String[] args) {
		int[] petrol = {9, 5, 3, 6};
		int[] dist = {2, 6, 10, 5};
		printStartPos(petrol, dist);

		int[] petrol2 = {4, 6, 7, 4};
		int[] dist2 = {6, 5, 3, 5};
		printStartPos(petrol2, dist2);
	}	

	public static void printStartPos(int[] petrol, int[] dist) {
		// total travelled. It total is < 0  then return -1 else return start.
		int total = 0;

		// Calculate cost upto now.
		int petrol_upToNow = 0;

		// We will start initially at 0. 
		// If the solution is not possible at start then we will update start.
		int start = 0;

		for(int i = 0; i < petrol.length; i++) {
			int cur_petrol = petrol[i] - dist[i];

			// If petrol_upToNow is postive then add the cur_petrolent to it.
			// Else if petrol_upToNow is negative then update the start postion and make petrol_upToNow as cur_petrol.
			if(petrol_upToNow >= 0) {
				petrol_upToNow += cur_petrol;
			} else {
				petrol_upToNow = cur_petrol;
				start = i;
			}

			total += cur_petrol;

			System.out.println("petrol_upToNow = " + petrol_upToNow + " start = " + start + " total = " + total);
		}

		int startPos = total >= 0 ? start : -1;
		System.out.println("Start at Petrol Pump " + startPos);
		System.out.println();
	}
}