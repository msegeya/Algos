/**
	Question: Abstract vs Interface

	Explanation:
	1) Interfaces are rules (Rules because you must give an implementation to them and that you can't ignore or avoid, so that are imposed like rules) which works as a common understanding document among the various teams in software development.

	2) Interfaces give the idea what is to be done but not how it will be done. So implementation completely depends on class by following the given rules(Means given signature of methods).

	3) Abstract classes may contain abstract declarations, concrete implementations, or both. 
	3a) If all the sub-classes need not implement the methods then they can use the abstract's concrete methods or else can override them.

	4) Abstract declarations are like rules to be followed and concrete implementations are like guidelines(You can use that as it is or you can ignore it by overriding and giving your own choice implementation to it).

	5) Moreover methods with same signature may change the behaviour in different context are provided as interface declarations as rules to implement accordingly in different contexts.

	Can we instantiate an Interface? 
	No. You cannot instantiate an interface. But you can instantiate an class which implements the interface.

	Can we instantiate an abstract class? 
	No. You cannot instantiate an abstract class. But you can instantiate a class which extends abstract class.

	Can an abstract class implement an interface? 
	Yes, it can implement the interface. But it is not mandatory to implement the methods of the interface.
	If we want we can implement the methods in abstract class such that the class extending the abstract class no need to implement them again. (If it is okay with the implementation of the concrete method in the abstract class.)
	But if the abstract class deos not implement any of the methods of the interface then the class which is extending the abstract class must implement all the abstract methods of both the abstract class as well as Interface methods.

	Can an abstract class have a constructor? (See below abstract class product.)
	Refer: http://stackoverflow.com/questions/260666/can-an-abstract-class-have-a-constructor
	Yes. But we cannot call it directly as we know we cannot create an instance of the abstract class. But this constructor can be used by the sub class to call the constructor of the super class(that is abstract class).
	A constructor in Java doesn't actually "build" the object, it is used to initialize fields.

	Can an abstract class be final?
	NO. Abstract class means that there are some declared but unimplemented methods, which extending classes must implement. Whereas when we say a class as final then we cannot extend that class.

	Can an abstract class have final methods? (http://stackoverflow.com/a/1299434/967638)
	Yes. Any concrete method in an abstract class can be final. (Ex: Template Design pattern)

	Can an interface extend another interface?
	YES.

	Can an interface extend a class?
	NO.
*/

public class AbstractInterface extends CourseBase {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCourse() {
		// TODO Auto-generated method stub
		return null;
	}

	/* NOTE: Now this method is not mandatory since abstract class has implemented this method. */
	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return 0;
	}

}

interface StudentInterface {
	public String getName();
	public int getAge();
}

abstract class CourseBase implements StudentInterface {
	public abstract String getCourse();
	
	public String getSchoolName() {
		return "Harper's High School.";
	}
	
	public int getAge() {
		return 10; 
	}
}

/* Example show how abstract constructor can be used. */
abstract class Product { 
    int multiplyBy;
    public Product( int multiplyBy ) {
        this.multiplyBy = multiplyBy;
    }

    public int mutiply(int val) {
       return multiplyBy * val;
    }
}

class TimesTwo extends Product {
    public TimesTwo() {
        super(2);
    }
}

class TimesWhat extends Product {
    public TimesWhat(int what) {
        super(what);
    }
}