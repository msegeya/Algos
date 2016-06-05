/**
	Question: Composite Design Pattern

	Reference: http://www.tutorialspoint.com/design_pattern/composite_pattern.htm

	Application: 
		- This pattern creates a class that contains a group of its own Objects.

	Explanation: 
		- You will have the same object present under each object. 
		- When we need to print the object we need to print all the objects under it.
*/

import java.util.*;

public class CompositePattern {
	public static void main(String[] args) {
		Employee CEO = new Employee("Modi", "CEO", 10000);
		
		// main Employee
		Employee manager = new Employee("Amarnath", "Program Manager", 1000);
		// Sub employees under manager
		Employee lead = new Employee("Abhinandhan", "Program Lead", 8000);
		
		manager.addEmployee(lead);
		
		Employee marketing = new Employee("Sushma", "Marketing Manager", 1001);
		// Sub employees under marketing manager
		Employee market_lead = new Employee("Jyothi", "Market Lead", 8000);
		marketing.addEmployee(market_lead);
		
		// finally add both the managers under the ceo.
		CEO.addEmployee(manager);
		CEO.addEmployee(marketing);
		
		System.out.println(CEO);
		
		for(Employee e : CEO.getSubOrdinates()) {
			System.out.println(e);
			
			for(Employee subEmployees : e.getSubOrdinates()) {
				System.out.println(subEmployees);
			}
		}
	}
}

class Employee {
	String name;
	String dept;
	int salary;
	List<Employee> subOrdinates;
	
	public Employee(String name, String dept, int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.subOrdinates = new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee e) {
		subOrdinates.add(e);
	}
	
	public void removeEmployee(Employee e) {
		subOrdinates.remove(e);
	}
	
	public List<Employee> getSubOrdinates() {
		return subOrdinates;
	}
	
	@Override
	public String toString() {
		return ("Name = " + this.name + " Salary = " + this.salary + " Role = " + this.dept);
	}
}