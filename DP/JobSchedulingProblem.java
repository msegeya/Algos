/**
	Question: Job Sequencing Problem. Given various bus schedule arrival and departure (Ai,Di). Find the minimum number of platforms needed at any point of time.

	Reference:  http://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/
				http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

	Logic: 
		- Input will be two arrays, arrival time and depature time. 
		- Sort all the arrival and depature times.
		- Start by taking the first arrival. So platforms needed will be 1.
		- Now for each of the arrival and depature check whether the arrival is first or depature is first,
			1) If arrival is before depature then we need one more platform.
			2) If arrival is after depature then we decrement the platform count.
		- Do this until we reach the end of either arrival or depature.	
*/

import java.util.Arrays;

class JobSchedulingProblem {
	public static void main(String[] args) {
		// below each input is a time that is 9:00. Inorder to make it simple we presented as 900.
		int[] arrival = {900, 940, 950, 1100, 1500, 1800};
		int[] depature = {910, 1200, 1120, 1130, 1900, 2000};

		System.out.println(getMinPlatforms(arrival, depature));
	}

	public static int getMinPlatforms(int[] arrival, int[] depature) {
		// Step-1: Sort the arrays.
		Arrays.sort(arrival);
		Arrays.sort(depature);

		// We will start by taking the first arrival which means already one platform is needed.
		int platforms_needed = 1;
		int output = 1;

		// We will start i = 1 since we have already choosed platforms_needed = 1 which means there is already a platform that is been used.
		int i = 1, j = 0;
		while(i < arrival.length && j < depature.length) {
			// If train arrived before the depature then increment the platforms_needed.
			// Else decrement the platforms_needed count.
			if(arrival[i] < depature[j]) {
				platforms_needed++;
				i++;

				if(platforms_needed > output) {
					output = platforms_needed;
				}
			} else {
				platforms_needed--;
				j++;
			}
		}

		return output;
	}
}