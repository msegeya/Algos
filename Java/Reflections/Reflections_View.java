/**
	Question: We will display all the methods, fields(intance variables) of a class.

*/

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflections_View {
	public static void main(String[] args) {
		Class<?> c = Employee_Reflect.class;
		
		System.out.println("***** All Methods *****");
		Method[] methods = c.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
		}
		
		System.out.println("\n****** All Fields *******");
		Field[] fields = c.getDeclaredFields();
		for(Field f : fields) {
			System.out.println(f.getName());
		}
	}
}


class Employee_Reflect {
	private int id;
	private String name;
	private int age;

	public Employee_Reflect(String name, int id, int age) {
		this.name = name;
		this.age = age;
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setId(int id) {
		this.id = id;
	}
}
