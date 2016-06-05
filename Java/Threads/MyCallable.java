import java.util.*;
import java.util.concurrent.*;

class MyCallable {
	public static void main(String[] args) {
		// Two threads are created.
		ExecutorService executor = Executors.newFixedThreadPool(2);
		// Only one object reference is created and passed to the executor service.
		FactorialCalculator fcRef = new FactorialCalculator(4);
		// Future reference will hold the output.
		Future<Integer> future = executor.submit(fcRef);
		try
        {
            System.out.println("Future result is - " + future.get() + "; And Task done is " + future.isDone());
        } 
        catch (InterruptedException | ExecutionException e) 
        {
            e.printStackTrace();
        }

        // We need to shutdown the executor.
        executor.shutdown();
	}
}

class FactorialCalculator implements Callable<Integer> {

	public int num;

	public FactorialCalculator(int num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		int result = 1;
		if(num == 0 || num == 1) {
			return 1;
		} else {
			for(int i = 2; i <= num; i++) {
				result = result * i;
			}
		}
		System.out.println("Result of the number " + num + " is " + result);
		return result;
	}
}