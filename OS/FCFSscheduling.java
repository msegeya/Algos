/**
	Source: http://stackoverflow.com/questions/27280729/waiting-time-in-fcfs-scheduling-algorithm
			https://www.youtube.com/watch?v=HIB3hZ-5fHw

	Question: FCFS Scheduling Algorithm

	Logic:
		- Start at service time = 0.
		- Now sort the jobs according to the arrival time.
		- Start from the first job based on the arrival time and wait until completion. Now go to the next job and do the same.

	Definitions:
		- Arrival Time (AT) = Time at which the job is ready.
		- Burst Time (BT) = Time for job to complete.
		- Completion Time (CT) = Time at which the job is completed.
		- Turn Aroung Time (TAT) = (CT - AT)
		- Waiting Time = (TAT - BT)
*/

import java.util.*;

class FCFSscheduling {
		
	private List<Job> jobs;

	public static void main(String[] args) {
		FCFSscheduling fcfsObj = new FCFSscheduling();

		fcfsObj.prepareJobs();
		fcfsObj.printTotalTime();
	}

	void prepareJobs() {
		Job j1 = new Job(1, 0, 4);
		Job j5 = new Job(2, 1, 3);
		Job j2 = new Job(3, 2, 1);
		Job j3 = new Job(4, 3, 2);
		Job j4 = new Job(5, 4, 5);

		jobs = new ArrayList<Job>();
		jobs.add(j1);
		jobs.add(j2);
		jobs.add(j3);
		jobs.add(j4);
		jobs.add(j5);
	}

	void printTotalTime() {
		int total_time = getTotalTime(jobs);
		System.out.println("\nTotal Turn Around Time = " + total_time);
	}

	int getTotalTime(List<Job> jobs) {
		System.out.println("\nInput Jobs: ");
		printJobs(jobs);

		// Sort the jobs based on arrival time.
		SortJobs_AT sort = new SortJobs_AT();
		Collections.sort(jobs, sort);

		System.out.println("\nSort Jobs using Arrival Time: ");
		printJobs(jobs);

		int serviceTime = 0;
		for(Job job : jobs) {
			serviceTime += job.burst_time;

			job.completion_time = serviceTime;
		}

		System.out.println("\nAfter Job Completion: ");
		printJobs(jobs);

		return serviceTime;
	}


	void printJobs(List<Job> jobs) {
		// print the jobs
		System.out.println("Name\t" + "AT\t" + "BT\t" + "CT\t" + "TAT");
		for(Job job : jobs) {
			System.out.println(job.job_num + "\t" + job.arrival_time + "\t" 
									+ job.burst_time + "\t" + job.completion_time + "\t" 
										+ (job.completion_time - job.arrival_time));
		}
	}
}