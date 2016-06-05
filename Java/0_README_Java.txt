Questions:
-------------------------------------------------------------------------------------------
- OOPS Principles ----> (Simple/OOPS.java)
Abstraction - Hiding internal details and showing functionality is known as abstraction. (Ex: Abstract class)
Encapsulation - Binding (or wrapping) code and data together into a single unit is known as encapsulation. Force the public accessor methods to call the setter/getter methods instead of accessing the instance variable directly.
Inheritance (Is-a relation) - When one object acquires all the properties and behaviours of parent object i.e. known as Inheritance. 
Ploymorphism - Polymorphism means one name, many forms. In Java, we use method overloading (compile time polymorphism) and method overriding (runtime polymorphism) to achieve polymorphism. Runtime polymorphism is also called "Dynamic Method Dispatch (DMD)"
Composition (has a relation) - By composition we mean using instance of other class as a field in our class. Example consider a class Student which has class Course instance under it. So the relation between them is composition (has-a).
-------------------------------------------------------------------------------------------
- Inheritance Vs Composition
  You do composition by having an instance of another class C as a field in your class, instead of extending C.
  Composition means HAS A.
  Inheritance means IS A.
  Example: Car has a Engine and Car is a Automobile
-------------------------------------------------------------------------------------------
- SOLID Principles
S – Single-responsiblity principle
O – Open-closed principle
L – Liskov substitution principle
I – Interface segregation principle
D – Dependency Inversion Principle
-------------------------------------------------------------------------------------------
- Access modifiers rules:
Default Access - An instance variable or method declared without any access control modifier is available to any other class in the same package.
Public Access - A class, method, constructor, interface etc declared public can be accessed from any other class.
Private Access - Methods, Variables and Constructors that are declared private can only be accessed within the declared class itself.
Protected Access - Variables, methods and constructors which are declared protected in a superclass can be accessed only by the subclasses in other package or any class within the package of the protected members' class.
-------------------------------------------------------------------------------------------
Explain "public static void main"
	public - Since this method has to be visible to outside the class such that JVM can call it.
	static - JVM should call it directly without creating an instance.
	void - no return type is needed.
	main - indicates that this is the method that has to be called.
	String[] args - For command line arguments.
-------------------------------------------------------------------------------------------
Explain "System.out.println"
	System - It is a class in java.lang package
	out - static instance inside System class and it is of type java.io.PrintStream. An static object called "out" is created inside System class which points to an instance of PrintStream class.
	println - It is a NON-STATIC method. So it is called using out instance variable.
-------------------------------------------------------------------------------------------
- HashCode Vs Equals
Hashing/HashCodeAndEquals.java
-------------------------------------------------------------------------------------------
- Immutable classes
	String/EmployeeImmutable.java

What is the need of Immutable object?
	1) String Pool - Is to reduce the number of string objects that are created. Goal is to reduce the number of string objects such that two or more String references can share the same String objects => So String object should be constant => Immutable.
	2) Security - It the connection string to database is mutable then hacker can change the string and cause secutry threat.
	3) Multi-Threading benefits - If many threads are trying to access the same data then it is required that the data is not changed.
-------------------------------------------------------------------------------------------
- Threads (wait, Notify, NotifyAll, sleep, join)
wait(): Tells the calling thread to give up the call and go to sleep until other threads enters the same monitor and calls notify.
		Ex: 	synchronized( lockObject )
				{ 
				    while( ! condition )
				    { 
				        lockObject.wait();
				    }
				     
				    //take the action here;
				}

notify(): It wakes up one single thread that called wait() on the same object. It will not tell the waiting thread that it can access this block. But it is upto the thread to enter the block.
		Ex: 	synchronized(lockObject) 
				{
				    //establish_the_condition;
				 
				    lockObject.notify();
				     
				    //any additional code if needed
				}

notifyAll(): It wakes up all the threads that called wait() on the same object. The highest priority thread will run first in most of the situation, though not guaranteed.
		Ex: 	synchronized(lockObject) 
				{
				   // establish_the_condition;
				 
				    lockObject.notifyAll();
				}

yield(): What yield() is supposed to do is make the currently running thread head back to runnable to allow other threads of the same priority to get their turn.

sleep(): Guaranteed to cause the current thread to stop executing for at least the specified sleep duration. It causes InterruptedException.
		 Always should be arounfd try/catch blocks.
		 	Ex: try {
					Thread.sleep(200);	
				} catch(InterruptedException e) {
					e.printStackTrace();
				}

join(): Guaranteed to cause the current thread to stop executing until the thread it joins with (in other words, the thread it calls join())
			Ex: t1.start();
				try {
					// Thread t2 waits only for 0.01s after thread t1 starts.
					t1.join(100);	
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				t2.start();
-------------------------------------------------------------------------------------------
- Executor Thread pool
Threads/ExecutorFramework.java
-------------------------------------------------------------------------------------------
- Overloading and Overriding
Simple/OverloadingOverriding.java
-------------------------------------------------------------------------------------------
- Abstract Vs Interface
Simple/AbstractInterface.java
-------------------------------------------------------------------------------------------
- HashMap implementation.
There can be one null key in HashMap and can have any number of null values.
Hashing/HashMap_Working_Internally.pdf
-------------------------------------------------------------------------------------------
- HashMap Vs TreeMap
TreeMap is an example of a SortedMap, which means that the order of the keys will be sorted in a natural order, and when iterating over the keys, you can expect that they will be in natural order.
HashMap on the other hand, makes no such guarantee. Therefore, when iterating over the keys of a HashMap, you can't be sure what order they will be in.
HashMap will be more efficient in general, so use it whenever you don't care about the order of the keys.
-------------------------------------------------------------------------------------------
- HashMap Vs ConcurrentHashMap Vs HasbTable

HashMap is not Synchronised, Allows only one null key and many null values, fast, fail-fast.
ConcurrentHashMap - Synchronised, Does not allow null key or null values
HashTable is Synchronised, Does not allow null key or values, slow, not failfast.

Hashing/HashMapVsConcurrentHashMap.pdf
-------------------------------------------------------------------------------------------
- String Vs StringBuffer Vs String Builder
Mutability Difference:
String is immutable, if you try to alter their values, another object gets created, whereas StringBuffer and StringBuilder are mutable so they can change their values.

Thread-Safety Difference:
The difference between StringBuffer and StringBuilder is that StringBuffer is thread-safe. So when the application needs to be run only in a single thread then it is better to use StringBuilder. StringBuilder is more efficient than StringBuffer.

Situations:
If your string is not going to change, use a String class because a String object is immutable.
If your string can change (example: lots of logic and operations in the construction of the string) and will only be accessed from a single thread, using a StringBuilder is good enough.
If your string can change, and will be accessed from multiple threads, use a StringBuffer because StringBuffer is synchronous so you have thread-safety.
-------------------------------------------------------------------------------------------
- Callable Vs Runnable
Callable has a method called call(..) which has a return type.
Runnable has a method called run() which DOES NOT have a return type.

When we submit a given task to a callable method using executor service framework and the result which we get "Future" interface value. 
Look at example MyCallable.java
-------------------------------------------------------------------------------------------
Write code for deadlock?
Threads/Deadlock.java
-------------------------------------------------------------------------------------------
What is Busy Spinning? Why you will use Busy Spinning as wait strategy? $$$$$$$$$$$$$$$$$$$$$$$
-------------------------------------------------------------------------------------------
What is ReadWriteLock in Java? $$$$$$$$$$$$$$$$$$$$$$$
-------------------------------------------------------------------------------------------
What is ReentrantLock in Java? $$$$$$$$$$$$$$$$$$$$$$$
-------------------------------------------------------------------------------------------
- Can two threads call two different synchronized instance methods of an Object?
Threads/Access2SyncMethods.java
-------------------------------------------------------------------------------------------
What happens when I make a static method as synchronized?
Yes we can lock a static method. But static belongs to class so whole class will be locked.
So until a thread releases lock on the static method (that is class) no other thread will be able to access the method (that is class)
	Ex:  synchronised static void foo() {
			// do something.
		 }

		 IS SAME AS,

		 static void foo() {
			synchronized(SomeClass.class) {
				// do something.
			}
		 }

Reference: http://stackoverflow.com/a/582500

Similarly for non static methods,
synchronized void foo() {
    ...
}

is same as

void foo() {
    synchronized(this) {
        ...
    }
}
-------------------------------------------------------------------------------------------
Why must wait() always be in synchronized block?
A wait() only makes sense when there is also a notify(), so it's always about communication between threads, and that needs synchronization to work correctly.
We no need to do any more of these just use java.util.concurrent package which deos the necessary things done for you.
-------------------------------------------------------------------------------------------
- Wait Vs Sleep
http://javarevisited.blogspot.in/2011/12/difference-between-wait-sleep-yield.html

wait is called on object whereas sleep is called on thread.
wait should be called in synchronised block where sleep can be called any where bust inside try/catch.
sleep() is a method which is used to hold the process for few seconds or the time you wanted.
wait() is a method where thread goes in waiting state and it won’t come back automatically until we call the notify() or notifyAll(). 
It bases on some condition to go wait state.

wait = A wait can be "woken up" by another thread calling notify on the monitor whereas a sleep cannot.
wait = A wait must happen in a block synchronized on the monitor object whereas sleep does not.
-------------------------------------------------------------------------------------------
- Exceptions. Runtime(unchecked) Vs Checked Exception Vs Error
Checked: are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using throws keyword.
	Ex: If we use IO operations or Thread.sleep() or  the we should write the code inside try/catch.

UnChecked: are the exceptions that are not checked at compiled time. NullPointerException, java.lang.ArithmeticException, java.lang.ArrayIndexOutOfBoundException etc.
Below example will throw java.lang.ArithmeticException.
	Example: public void divide() {
		      int x = 0;
		      int y = 10;
		      int z = y/x;
		  	}

Error: Errors are also unchecked exception & the programmer is not required to do anything with these. In fact it is a bad idea to use a try-catch for Errors. Most often, recovery from an Error is not possible & the program should be allowed to terminate. 
Examples: OutOfMemoryError, StackOverflowError, etc.

Refer: java/Exceptions/Exceptions_Hierarchy.png
-------------------------------------------------------------------------------------------
- final vs finally vs finalize
final: final can be used to mark a variable "unchangeable", can also make a method not "overriden", can also make a class not "inheritable". i.e. the class can not be sub-classed.

finally: finally is used in a try/catch statement to execute code "always".

finalize: Called by the garbage collector on an object when garbage collection determines that there are no more references to the object. 
A subclass overrides the finalize method to dispose of system resources or to perform other cleanup.

Simple/FinallyEx.java
-------------------------------------------------------------------------------------------
- Serialization
Simple/Serialization.java
-------------------------------------------------------------------------------------------
- Interfaces with no methods
Cloneable, Serializable, Type etc.

Why is are these interfaces with no methods necessary?
This are called Tagged or Marker interface. These are not used for any use or operation. These methods are used to tag or marking a class. So that you can determine whether someclass is a child of those classes.

Marker interface is used as a tag to inform a message to the java compiler so that it can add special behavior to the class implementing it. Java marker interface has no members in it.
The purpose of Marker interfaces is to force some kind of functionality in the classes by providing some functionality to a class if it implements the marker interface.
-------------------------------------------------------------------------------------------
- Extends Vs Implements
Extends: When a subclass extends a class, it allows the subclass to inherit (reuse) and override code defined in the supertype.
Implements: When a class implements an interface, it allows an object created from the class to be used in any context that expects a value of the interface.

Since extends is more powerful, why use implements? 
Java requires that a class may extend at most one other class. Extending multiple classes introduces a diamond problem.
-------------------------------------------------------------------------------------------
- Java Heap memory Vs Stack Memory.
Main difference between heap and stack is that stack memory is used to store local variables and function call, while heap memory is used to store objects in Java. No matter, where object is created in code e.g. as member variable, local variable or class variable,  they are always created inside heap space in Java.
-------------------------------------------------------------------------------------------
- Cloning, Deep Copy and Shallow Copy.
Simple/CloneEx.java
-------------------------------------------------------------------------------------------
- Some Major Design Patterns
Singleton Pattern
Factory Pattern
-------------------------------------------------------------------------------------------
Packages:
http://javarevisited.blogspot.in/2015/04/error-could-not-find-or-load-main-class-helloworld-java.html

* Suppose we have a java file in parent directory and a class in sub-directory.
  If y needs x to compile and run then how do we perform the compile and run?
	folder-X
		|
		|
		|_______ x.java
		|
		|_______ folder Y
					|
					|
					|_______ y.java	

  Since these files are not in the package structure. So we need to set the classpath manually. How?
  	> javac -cp ../ y.java    ---> (This will compile both the classes. Here ../ states to look into parent directory for dependencies.)
  	> java -cp ../;. y 		  ---> (This will run y class. Here ../;. says to check the class files in parent direcotry and to use them in current directory.)
-------------------------------------------------------------------------------------------
Inner classes:
	Why to use inner class?
		If you have a class whose functionalities are required only by enclosing class then it does not make sense to create separate class for that. Instead of this you create an "inner class".

	Two types of inner classes
	1) static member class
	2) Inner class - (Member class, Anonymous class, Local class)

	Refer: Java/InnerClass/*
-------------------------------------------------------------------------------------------
Serialization:
Refer: Algos/Java/Serialization/0_README_Serialization.txt
-------------------------------------------------------------------------------------------
Threads:
Refer: Algos/Java/Threads/*
-------------------------------------------------------------------------------------------
Static classes:
Can there be a static classes as main class ?
No.

Can there be a static class ?
Yes.
Only nested classes can be static.
-------------------------------------------------------------------------------------------
Can we give private access modifier to a static variable?
Yes. 
But we cannot access this from outside the class. Any variable inside the class can call it using the class name.
-------------------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------