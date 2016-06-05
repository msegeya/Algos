/**
	Question: Deadlock creation in Java.

	Logic: 
		- Create two threads and create two instance variables str1 and str2.
		- Take two threads.
		- Synchronize the two instance variables.
		- Thread 1 should access str1 and str2 in the same order.
		- Thread 2 should access str2 and str1 in the same order.
		- Since both of these instance variables are synchronized so each thread waits for the other.

	Now, How do you make sure deadlock is never occured?
		=> Instead of threads accessing resources in different order make them to access the resources in the same order.
		   Thread-1 = s1 then s2
		   Thread-2 = s1 then s2
*/

class Deadlock {

	public String str1 = "Angularjs";
	public String str2 = "Backbone";

	public static void main(String[] args) {
		Deadlock dlRef = new Deadlock();
		dlRef.startThreads();
	}

	public void startThreads() {
		Runnable r1 = new MyThread_One();
		Runnable r2 = new MyThread_Two();

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();
	}

	class MyThread_One implements Runnable {
		public void run() {
			while(true) {
				synchronized(str1) {
					synchronized(str2) {
						System.out.println("MyThread_One " + str1 + " " + str2);		
					}
				}
			}
		}
	}

	class MyThread_Two implements Runnable {
		public void run() {
			while(true) {
				synchronized(str2) {
					synchronized(str1) {
						System.out.println("MyThread_Two " + str1 + " " + str2);		
					}
				}
			}
		}	
	}

}