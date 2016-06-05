class Job {

	public int job_num;
	public int arrival_time;
	public int burst_time;
	public int completion_time;

	// "Turn Around Time" is (CT - AT)
	public int turn_around_time;

	Job(int job_num, 
			int arrival_time, 
				int burst_time) {
		this.job_num = job_num;
		this.arrival_time = arrival_time;
		this.burst_time = burst_time;
	}
}