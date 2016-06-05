/**
	Question: Explain Default methods in Java 8.
	Please refer Default_Method_Java8.pdf

	Definition: Default methods enable us to add new functionalities to interfaces without breaking the classes that implements that interface. Lets take a look at the example below.
*/

interface Interface_A {
	public void saySomething();
}

class MyClass implements Interface_A {
	// Now we need to implement the interface methods.
	public void saySomething() {

	}
}

/*********************************************************************/
// Suppose after a long time and the project really becomes big and if we want to introduce one more method in the interface as,
interface Interface_A {
	public void saySomething();

	public void newMethod();
}

// Now all the classes that implemented this interface will throw error. So in Java 8 we have something called as "Default Methods"
// In "the strictest sense", Default methods are a step backwards because they allow you to "pollute" your interfaces with code. But they provide the most elegant and practical way to allow backwards compatibility. It made it much easier for Oracle to update all the Collections classes and for you to retrofit your existing code for Lambda.
// NOTE: A default methods should be concrete and the methods name should have default keyword.

// Now the above interface becomes as follows,
interface Interface_A {
	public void saySomething();

	default public void newMethod() {
		System.out.println("Hi! New method.");
	}
}

// Now the class becomes.
class MyClass implements Interface_A {
	public void saySomething() {
		// some code.
	}

	// If we don't override the default methods then the interface method will be used.
	// If we override then the current class method will be used.
	@Overide 
	default public void newMethod() {
		System.out.println("Hi! Inside concrete class.");
	}
}

// But what if there are more than one interface than is having the same default method name.
interface Interface_A {
	default public void newMethod() { System.out.println("Hi! In interface A"); }
}

interface Interface_B {
	default public void newMethod() { System.out.println("Hi! In interface B"); }
}

class MyClass implements Interface_A, Interface_B {
	// If we override then the newMethod will not have any confict. 
	// But what if we want to use the interface's one which one will be inherited?
	// In these cases we need to actually explicitly define what is needed.
	@override 
	public void newMethod() {
		Interface_A.super.newMethod();
		// Interface_B.super.newMethod(); // for interface B's method.
	}
}

