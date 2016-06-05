/**
	Question: Can two threads call two different synchronized instance methods of an Object?
    NO. Since lock is on Object. So if one thread holds the lock on the object then other thread need to wait.

	Reference: http://stackoverflow.com/a/3160045/967638

	Explanation: 
	The synchronized keyword applies on object level, and only one thread can hold the lock of the object. So as long as you're talking about the same object, then no, t2 will wait for t1 to release the lock acquired when it entered m1.
	The thread can however release the lock without returning from the method, by calling Object.wait().

	What would be the state of other thread t2 ?
	It would sit tight and wait for t1 to release the lock (return from the method or invoke Object.wait()). 
	Specifically, it will be in a BLOCKED state.

    In simple, Both methods lock the same monitor. Therefore, you can't simultaneously execute them on the same object from different threads (one of the two methods will block until the other is finished).
*/

public class Access2SyncMethods {

    public synchronized void m1() {
        try { Thread.sleep(2000); }
        catch (InterruptedException ie) {}
    }

    public synchronized void m2() {
        try { Thread.sleep(2000); }
        catch (InterruptedException ie) {}
    }

    // Here both the threads are using the same instance.
    // Even though they both are accessing different methods but the object instance is same.
    // So if one thread is using then the other thread is blocked.
    public static void main(String[] args) throws InterruptedException {
        final Access2SyncMethods t = new Access2SyncMethods();
        Thread t1 = new Thread() 
        { 
            public void run() { 
                t.m1(); 
            } 
        };

        Thread t2 = new Thread() { 
            public void run() { 
                t.m2(); 
            } 
        };

        t1.start();
        Thread.sleep(500);

        t2.start();
        Thread.sleep(500);

        System.out.println("Thread t2 state is: " + t2.getState());
    }
}