/**
	Question: Thread Join
	
	Explanation: If we say thread t2 should run only after thread t1 then we need use "join". 
	1) If t2 depends on what t1 does then do the following,
			t1.start()
			t1.join();
			t2.start();
	2) If t2 should only wait for some seconds just like the below program,
			t1.start();
			t1.join(100); // t1 will block 0.01 seconds
			t2.start();
	3) If we say t1 should run first then t2 then t3,
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
*/

class Join {
	public static void main(String[] args) {
		Runnable r1 = new ThreadOdd();
		Runnable r2 = new ThreadEven();

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		try{
			// Thread t2 waits only for 0.01s after thread t1 starts.
			t1.join(100);	
		} catch(Exception e) {
			e.printStackTrace();
		}
		t2.start();
	}
}

class ThreadOdd implements Runnable {
	@Override
	public void run() {
		for(int i = 1; i <= 10; i = i + 2) {
			System.out.println(i);
			try{
				// It prints the value and goes to sleep. 
				// Such that the next thread which is in waiting state will start working.
				Thread.sleep(200);	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadEven implements Runnable {
	@Override
	public void run() {
		for(int i = 2; i <= 10; i = i + 2) {
			System.out.println(i);
			try{
				// It prints the value and goes to sleep. 
				// Such that the next thread which is in waiting state will start working.
				Thread.sleep(200);	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}	
}