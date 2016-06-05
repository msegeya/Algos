/**
	Question: Differnece between Overloading and Overriding.

	Difference:
	1) Overloading: Method overloading is used to increase the readability of the program.
	   Overriding:	Method overriding is used to provide the specific implementation of the method that is already provided by its super class.
	2) Overloading: In case of method overloading, parameter must be different.
	   Overriding: In case of method overriding, parameter must be same.
	3) Overloading: Method overloading is the example of compile time polymorphism.
	   Overriding:  Method overriding is the example of runtime time polymorphism.
	4) Overloading: Method overloading can't be performed by changing return type of the method only. Return type can be same or different in method overloading. But you must have to change the parameter.
	   Overriding: Return type must be same or covariant in method overriding.
	5) Overriding: The overriding method MUST NOT HAVE MORE RESTRICTIVE access modifier.
				   If the overridden method is has default access, then the overriding one must be default, protected or public.
				   If the overridden method is protected, then the overriding one must be protected or public.
				   If the overridden method is public, then the overriding one must be only public.	
*/

class OverloadingOverriding {
	public static void main(String[] args) {
		Overloading ol = new Overloading();
		System.out.println(ol.add(10, 20));
		System.out.println(ol.add(10, false));

		Overriding or = new Overriding();
		or.sendMsg();
	}
}

class Overloading {
	public int add(int a, int b) {
		return a + b;
	}

	public int add(int a, boolean b) {
		return a;
	}
}

interface Message {
	public void sendMsg();
}

class Overriding implements Message {
	public void sendMsg() {
		System.out.println("Message method overriden.");
	}
}