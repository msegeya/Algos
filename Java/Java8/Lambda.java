/**
	What is Lambda Expressions?

	Definition:
	It is an anonymous function that allows you to pass methods as arguments or simply, a mechanism that helps you remove a lot of boilerplate code.They have no access modifier(private, public or protected), no return type declaration and no name.

	Reference: https://blog.idrsolutions.com/2014/10/5-minutes-explanation-java-lambda-expression/
*/

interface Names {
	public void sayName(String name);
}

class NameExample {
	public static void main(String[] args) {
		Names newInstance = new Names() {
			@Override 
			public void sayName(String name) {
				System.out.println("My Name is: " + name);
			}
		};

		sayMyName(newInstance, "Amarnath");
	}

	public static void sayMyName(Names nameInstance, String name) {
		nameInstance.sayName(name); // Nothing but just calling the interface method sayName which we implemented in NameExample class.
	}
}

/***********************************************************************************************/
// If we use lambda expression then we can remove all the useless code and make it look clean
class NameExample {
	public static void main(String[] args) {
		sayMyName(n -> System.out.println("My name is " + n), "Amarnath"); // NOTE: I still have no idea how is this converting to a Names instance reference.
	}
}

public static void sayMyName(Names nameInstance, String name) {
	nameInstance.sayName(name); // Nothing but just calling the interface method sayName which we implemented in NameExample class.
}