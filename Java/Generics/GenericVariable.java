/**
	Source: https://www.youtube.com/watch?v=9tHLV0u87G4

	Question: Use two types of generic arguments.

	Description:
		In the below Student class we have name and age as attributes. Name is of type String and Age is of type Integer.
		So we need to use two generic variables, T as String for Name and E as Integer for Age.

*/

import java.util.*;

class GenericVariable {
	public static void main(String[] args) {
			
		Student<String, Integer> stu1 = new Student("Amarnath", 1);
		Student<String, Integer> stu2 = new Student("Chandana", 2);
		
		List<Student<String, Integer>> studentsList = new ArrayList<>();
		studentsList.add(stu1);
		studentsList.add(stu2);

		// Print students
		System.out.println("Student-1: " + " Name = " + studentsList.get(0).name + "; Age = " + studentsList.get(0).age);
		System.out.println("Student-2: " + " Name = " + studentsList.get(1).name + "; Age = " + studentsList.get(1).age);
	}
}

class Student<T, E> {
	public T name;
	public E age;

	Student(T name,
				E age) {
		this.name = name;
		this.age = age;
	}
}