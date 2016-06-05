/**
	Question: Explain HashCode and Equals method.

	Explanation: 
		When we have created two objects like,
			Student stu1 = new Student("Amarnath", 29);
			Student stu2 = new Student("Susham", 25);
		Both the hashcodes of stu1 and stu2 are different. 

		What if I say, 
			Student stu1 = new Student("Amarnath", 29);
			Student stu2 = new Student("Amarnath", 29);
		Still both the hashcodes are different. Yes as expected since they both are having different memory locations. 
		But what if I say if stu1 is equal to stu2 then it is yes.
		==> You need to override equals and hashcode method.
*/

import java.util.HashSet;
import java.util.Set;

public class HashCodeAndEquals {
	public static void main(String[] args) {
		Student stu1 = new Student("Amarnath", 29);
		Student stu2 = new Student("Susham", 25);
		Student stu3 = stu1;
		
		// Using the default implementation of Hashcode and Equals.
		// Checking reference equals
		if(stu1 == stu2) {
			System.out.println("Is stu1 == stu2 => " + "Yes"); 
		} else {
			System.out.println("Is stu1 == stu2 => " + "NO"); // output
		}
		
		// Checking reference equals
		if(stu1 == stu3) {
			System.out.println("Is stu1 == stu3 => " + "Yes"); // output
		} else {
			System.out.println("Is stu1 == stu3 => " + "NO");
		}
		
		// Checking contents equals
		if(stu1.equals(stu2)) {
			System.out.println("Is stu1.equals(stu2) => " + "Yes"); 
		} else {
			System.out.println("Is stu1.equals(stu2) => " + "NO"); // output
		}

		// Checking contents equals		
		if(stu1.equals(stu3)) {
			System.out.println("Is stu1.equals(stu3) => " + "Yes"); // output
		} else {
			System.out.println("Is stu1.equals(stu3) => " + "NO");
		}
		
		// Checking contents equals		
		if(stu1.equals(new Student("Amarnath", 29))) {
			System.out.println("Is stu1.equals(new Student(\"Amarnath\", 29)) => " + "Yes"); // output
		} else {
			System.out.println("Is stu1.equals(new Student(\"Amarnath\", 29)) => " + "No");
		}
		
		// Consider a hash set and see what happens
		Set<Student> set = new HashSet<Student>();
		set.add(stu1);
		set.add(stu2);
		
		// As it checks only the contents.
		if(set.contains(stu1)) {
			System.out.println("Is set.contains(stu1) => " + "Yes"); // output
		} else {
			System.out.println("Is set.contains(stu1) => " + "NO");
		}
		
		// As the contents are same but the hash code is different.
		if(set.contains(new Student("Amarnath", 29))) {
			System.out.println("Is set.contains(new Student(\"Amarnath\", 29)) => " + "Yes"); // output. Only after orverridign the hashcode.
		} else {
			System.out.println("Is set.contains(new Student(\"Amarnath\", 29)) => " + "NO");
		}
		
		/* We will replace both the hashcode and the equals method. */
		// And check all the previous results and see the output.
 	}
}


class Student {
	public String name;
	public int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			// below equals will not call the Student's equals method. 
			// Since it is comparing strings it will call String class equal method.
			return (((Student) obj).name.equals(this.name))
							&& 
					(((Student) obj).age == this.age); 
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return 11 * this.name.hashCode() * this.age;
	}
}