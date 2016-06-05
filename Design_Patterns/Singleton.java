/**
	- Singleton Design Pattern:
	The instance of the class is created only once. The constructor will be private.
	class Singleton {
		private Singleton instance;
		private Singleton() {}
		public Singleton getInstance() { 
			if(null == instance) {
				instance = new Singleton();
			} 

			return instance;
		}
	}

	But if two threads race for the Thread creation since the method is not Synchronised there can be more than one instance that can be created.
	So how to make Singleton class as Thread safe?
	==> By using double checking. 

	class Singleton {
		private Singleton instance;
		private Singleton() {}
		public Singleton getInstance() { 
			if(null == instance) {
				synchronized(Singleton.class) {
					if(null == instance) {
						instance = new Singleton();
					}
				}
			}
			return instance;
		}
	}

	Still we can break the threaded also? By using Reflections.
	By reflections we will be accessing the private constructor object.
	Ex: 
	Constructor<Student_Reflect> c = Student_Reflect.class.getDeclaredConstructor();
	c.setAccessible(true); // IMPORTANT step.
	Student_Reflect instance = c.newInstance();

	Applications: (Real time. If it is from your project then it is too good.)
		- Logging.
		- Property file. Reading application config settings during startup.
		- Database connections.
		- Controls shared resource access.
*/

public class Singleton {
	
	private static Singleton instance;
	
	private Singleton(String name) {
		System.out.println("Inside Singleton Constructor " + name);
	}

	public static Singleton getInstance(String name) {
		// first check
		if(null == instance) {
			synchronized(Singleton.class) {
				// second check
				if(null == instance) {
					instance = new Singleton(name);
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		Runnable r1 = new Thread_One_Singleton();
		Runnable r2 = new Thread_Two_Singleton();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}

class Thread_One_Singleton implements Runnable {
	@Override
	public void run() {
		Singleton.getInstance("One");
	}
}

class Thread_Two_Singleton implements Runnable {
	@Override
	public void run() {
		Singleton.getInstance("Two");
	}
}