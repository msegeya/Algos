/**
	Source: http://www.java2novice.com/java-interview-programs/thread-deadlock/

	Question: Write a program for a Deadlock.

	Description: Deadlock describes a situation where two or more threads are blocked forever, waiting for each other. Deadlocks can occur in Java when the synchronized keyword causes the executing thread to block while waiting to get the lock, associated with the specified object. Since the thread might already hold locks associated with other objects, two threads could each be waiting for the other to release a lock. In such case, they will end up waiting forever. - See more at: http://www.java2novice.com/java-interview-programs/thread-deadlock/#sthash.T8TrSzrI.dpuf

	Logic: 
		- Take two strings str1, str2.
		- Take two threads, and each of them will concat str1, str2.
		- Thread-1 locks str1 and waiting for str2 whereas Thread-2 is locks str2 and waits for str1.
			==> Deadlock.
*/

class DeadLock {
	public static void main(String[] args) {
		DeadLock dlObj = new DeadLock();
		dlObj.performDeadLock();
	}

	String str1 = "amarnath";
	String str2 = "chandana";
	static int count = 0;

	void performDeadLock() {
		thr1.start();
		thr2.start();
	}

	Thread thr1 = new Thread("Thread-1") {
		public void run() {
			while(true) {
				synchronized(str1) {
					synchronized(str2) {
						System.out.println((count++) + " " + (str1 + str2));
					}
				}
			}
		}
	};

	Thread thr2 = new Thread("Thread-2") {
		public void run() {
			while(true) {
				synchronized(str2) {
					synchronized(str1) {
						System.out.println((count++) + " " + (str1 + str2));
					}
				}
			}
		}
	};

}