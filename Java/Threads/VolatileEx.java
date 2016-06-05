/**
	Question: Explain Volatile keyword and its uses.

	Definition: volatile variable in Java is a special variable which is used to signal threads, a compiler that this particular variables value are going to be updated by multiple threads inside Java application. By making a variable volatile using the volatile keyword in Java, application programmer ensures that its value should always be read from main memory and thread should not use cached value of that variable from their own stack. 
	
	Applicable on?
	#) The volatile keyword can only be applied to a variable, it can not be applied to class or method.
	
	When to use Volatile?
	#) Any variable which is shared between multiple threads should be made variable, in order to ensure that all thread must see the latest value of the volatile variable.
	#) A signal to compiler and JIT to ensure that compiler does not change ordering or volatile variable and moves them out of synchronized context.
	#) You want to save the cost of synchronization as volatile variables are less expensive than synchronization.


	From StackOverflow,
		Volatile means that the variable changes at runtime and that the compiler should not cache its value for any reason.
		This is only really a problem when sharing the variable amongst threads, you don't want a thread working with stale data, so the compiler should never cache the value of a volatile variable reference.
*/

public class VolatileEx {

	public static void main(String[] args) {
		new VolatileEx().initialize();
	}

	public void initialize() {
		VolatileData data = new VolatileData();

		// We will need two threads.
		Thread[] threads = new Thread[2];
		for(int i = 0; i < 2; i++) {
			Runnable r = new VolatileThread(data);
			threads[i] = new Thread(r);
		}

		// start all threads.
		for(int i = 0; i < 2; i++) {
			Thread t = threads[i];
			t.start();
		}
	}

}

class VolatileData {
	private volatile int counter;

	public int getCounter() {
		return counter;
	}

	public void incrCounter() {
		++counter;
	}
}

class VolatileThread implements Runnable {

	private final VolatileData data;

	public VolatileThread(VolatileData data) {
		this.data = data;
	}

	public void run() {
		int oldCounter = data.getCounter();
		System.out.println("Thread =" + Thread.currentThread().getId() + " and Counter = " + oldCounter);

		data.incrCounter();

		int newCounter = data.getCounter();
		System.out.println("Thread =" + Thread.currentThread().getId() + " and Counter = " + newCounter);				
	}
}