/**
	Description: Sort Jobs using their arrival time.
*/

import java.util.*;
class SortJobs_AT 
				implements Comparator<Job> {

	public int compare(Job j1, Job j2) {
		return j1.arrival_time - j2.arrival_time;
	}				
}