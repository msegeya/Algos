/**
	Question Threads Vs Process:
	
	1) Process: A program in execution is refered to as Process.
	   Thread: A Thread is a subset of a process.
	2) Process: A process contains multiple threads.   
	   Thread: A thread is the smallest part of the process which can execute concurrently with other threads.
	3) Process: A process is refered as Task.
	   Thread: A thread is refered to as light weight process.
	4) Process: A process has its own address space.
	   Thread: A thread uses process address space.
	5) Process: A process can communicate with other process using inter-process-communication.
	   Thread: A thread communicates with other threads using wait(), notify(), notifyAll
	6) Process: A process cannot have control on other process. It has control only on child's process.
	   Thread: A thread can control other threads using wait(), nofity(), notifyAll().         


	Inter Process Communication: 
	It mainly refers to refers specifically to the mechanisms an operating system provides to allow processes it manages to share data.
	Various Approaches:
		1) File: A record stored on disk, or a record synthesized on demand by a file server, which can be accessed by multiple processes.
		2) Socket: A data stream sent over a network interface, either to a different process on the same computer or to another computer on the network. Typically byte-oriented, sockets rarely preserve message boundaries.
		3) Message Queue: A data stream similar to a socket, but which usually preserves message boundaries. Typically implemented by the operating system, they allow multiple processes to read and write to the message queue without being directly connected to each other.
		4) Pipe: A two-way data stream between two processes interfaced through standard input and output and read in one character at a time.
		5) Semaphore: A simple structure that synchronizes multiple processes acting on shared resources.
		6) Shared Memory: Multiple processes are given access to the same block of memory which creates a shared buffer for the processes to communicate with each other.
		7) Message Passing: Allows multiple programs to communicate using message queues and/or non-OS managed channels, commonly used in concurrency models.

*/

class ThreadsVsProcess {

}