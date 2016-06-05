/**
	Following are the disadvantages of the usual Threading.
	1) Time consuming - When ever a new task comes we need to create a new Thread and start assigning it to do the task.
	2) Poor Resource Managent - If we create too many threads but there is actually not that many tasks available.
	3) Not Robust: Since we don't have number of thread creation limit. If any hacker or if we get too many tasks then we will create too many threads which will cause Memory Exeception

	How do we solve all this? Using Executor Thread Pool.
	Executor Thread Pool was introduced in Java5.
	We have an interface called "Executor" which is implemented in "Executors" class.
	We can define what is the maximum number of threads that can be created. Using which we can solve the resource management issue.
	Even there are more tasks the actual number of threads, Executor thread pool framework will manage the tasks in a queue and assign a thread to a task only if there are any threads in the thread pool

	NOTE: All the below methods of Executors are static classes so no need to create objects to access them.
	// create one thread. So all tasks will be serviced by this thread alone.
	ExecutorService oneThreadSrv = Excutors.newSingleThreadExecutor(); 

	// Creates n number of threads. All these threads will perform the given task.
	ExecutorService fixedThreadSrv = Executors.newFixedThreadPool(int nThreads);

	// Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.
	ExecutorService schThreadPool = Executors.newScheduledThreadPool(int corePoolSize)
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorFramework {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5); // 5 threads will be created.

		// we will create 10 tasks.
		int taskCount = 10;
		for(int count = 1; count <= 10; count++) {
			// create each task.
			Runnable worker = new WorkerThread(count);

			// push it to the executor.
			executor.execute(worker);
		}

		// once all the tasks are completed then we can shutdown the executor.
		executor.shutdown();
	}
}

class WorkerThread implements Runnable {

	public int command;

	public WorkerThread(int command) {
		this.command = command;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " start with command = " + command);
		makeItSleep();
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	public void makeItSleep() {
		try {
			Thread.sleep(3000);
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}