OS_questions

- LRU
- FIFO
- Resources and Process problem
- Deadlock situation

- SCHEDULING Algorithms:
	- First Come First Serve (FCFS) 
	- Shortest-Job-First (SJF) Scheduling
	- Priority Scheduling
	- Round Robin(RR) Scheduling
	- Multilevel Queue Scheduling

- Banker's Problem

THEORY: (Link - http://geeksquiz.com/commonly-asked-operating-systems-interview-questions-set-1/)

- What is deadlock? 
	Deadlock is a situation when two or more processes wait for each other to finish and none of them ever finish.  Consider an example when two trains are coming toward each other on same track and there is only one track, none of the trains can move once they are in front of each other.  Similar situation occurs in operating systems when there are two or more processes hold some resources and wait for resources held by other(s).

- What are the necessary conditions for deadlock?
	Mutual Exclusion: There is s resource that cannot be shared.
	Hold and Wait: A process is holding at least one resource and waiting for another resource which is with some other process.
	No Preemption: The operating system is not allowed to take a resource back from a process until process gives it back.
	Circular Wait:  A set of processes are waiting for each other in circular form.

- What is Virtual Memory? How is it implemented?
	Virtual memory creates an illusion that each user has one or more contiguous address spaces, each beginning at address zero. The sizes of such virtual address spaces is generally very high.
	The idea of virtual memory is to use disk space to extend the RAM. Running processes don’t need to care whether the memory is from RAM or disk. The illusion of such a large amount of memory is created by subdividing the virtual memory into smaller pieces, which can be loaded into physical memory whenever they are needed by a process.

- What is Thrashing?
	Thrashing is a situation when the performance of a computer degrades or collapses. Thrashing occurs when a system spends more time processing page faults than executing transactions. While processing page faults is necessary to in order to appreciate the benefits of virtual memory, thrashing has a negative affect on the system. As the page fault rate increases, more transactions need processing from the paging device. The queue at the paging device increases, resulting in increased service time for a page fault (Source: http://cs.gmu.edu/cne/modules/vm/blue/thrash.html)

- What is Belady's Anomaly?
	Belady's anomaly is an anomaly with some page replacement policies where increasing the number of page frames results in an increase in the number of page faults. It occurs with First in First Out page replacement is used. See the wiki page for an example and more details.

- Differences between mutex and semphore?
	See http://www.geeksforgeeks.org/mutex-vs-semaphore/

- Difference between a crash and exception. 

- Difference between macros and inline functions. 

- Mfc: message maps and virtual functions.
