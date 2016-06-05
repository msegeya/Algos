/**
	Questions: What is Reflection in Java?
	
	Reflection is a language's ability to inspect and dynamically call classes, methods, attributes, etc. at runtime.
	Using reflections we can get the metadata of the class and we can also change the runtime behaviour of the class.
	The java.lang and java.lang.reflect provides package for Java reflections.
	
	Reflection is important since it lets you write programs that do not have to "know" everything at compile time, making them more dynamic, since they can be tied together at runtime.

	NOTE: 
	The ability to inspect the code in the system and see object types is not reflection, but rather Type Introspection. Reflection is then the ability to make modifications at runtime by making use of introspection. The distinction is necessary here as some languages support introspection, but do not support reflection. One such example is C++.
*/


// Example to access private constructor using reflections.
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflections {
	public static void main(String[] args) {
		try {
			Constructor<Student_Reflect> c = Student_Reflect.class.getDeclaredConstructor();
			// very important. By using this we can surpress java language access checking.
			c.setAccessible(true);
			Student_Reflect instance = c.newInstance();
			instance.setName("Amarnath");
			System.out.println("Calling getName method: " + instance.getName());
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

class Student_Reflect {

	private String name;

	// Private constructor.
	private Student_Reflect() { System.out.println("Accessed Private Constructor. "); }

	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
}
