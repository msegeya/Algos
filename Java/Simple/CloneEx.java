/**
	Question: Explain Cloning.
	
	Refer Shallow_Copy.gif and Deep_Copy.gif
	Reference:  https://www.cs.utexas.edu/~scottm/cs307/handouts/deepCopying.htm
				http://stackoverflow.com/a/1175667/967638

	What is clone?
	Clone is nothing but the process of copying one object to produce the exact object, which is not guaranteed.
	We all know as Java object is referred by reference we can not copy one object directly to another object.
	By default Java class does not support cloning. But using an interface called Cloneable, which is a marker interface and by implementing this interface we can duplicate an object by calling clone.
	Clone can throw an exception called "CloneNotSupportedException" when try to call clone.
	
	By default any clone() method gives shallow copy of the object i.e. if we invoke super.clone() then it’s a shallow copy but if we want to deep copy we have to override the clone() method and make it public and give own definition of making copy of object.

	Shallow Copy Vs Deep Copy:
	Context is, when we have two objects A and B. If B is the clone(deep or shallow) of A then.
	In short, it depends on what points to what. In a shallow copy, object B points to object A's location in memory. In deep copy, all things in object A's memory location get copied to object B's memory location.
*/

class CloneEx {
	public static void main(String[] args) {
		try {
			Foo myFoo = new Foo();
			Foo shallow_foo = myFoo.shallowCopy();
			Foo deep_foo = myFoo.deepCopy();

			System.out.println("\nShallow Copying");
			System.out.println(shallow_foo.myBar == myFoo.myBar);
			System.out.println(shallow_foo.myBar.equals(myFoo.myBar));

			System.out.println("\nDeep Copying");
			System.out.println(deep_foo.myBar == myFoo.myBar);
			System.out.println(deep_foo.myBar.equals(myFoo.myBar));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Foo {
	public Bar myBar = new Bar();

	public Foo shallowCopy() throws CloneNotSupportedException {
		Foo foo_new = new Foo();
		foo_new.myBar = myBar;
		return foo_new;
	}

	public Foo deepCopy() throws CloneNotSupportedException {
		Foo foo_new = new Foo();
		foo_new.myBar = (Bar) myBar.clone();
		return foo_new;
	}
}

class Bar implements Cloneable {
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}