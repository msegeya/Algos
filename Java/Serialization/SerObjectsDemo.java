/**
	Source: http://www.javacodegeeks.com/2013/03/serialization-in-java.html

	Question: What if the object instance has link to another object like Employee has Address in it.
*/

import java.io.*;
class SerObjectsDemo {
	public static void main(String[] args) {
		try {
			// Serialization
			Address add = new Address("Bangalore");
			Employee emp = new Employee(1, "Amarnath", "CS", add);
			FileOutputStream fos = new FileOutputStream("empadd.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(emp);
			oos.close();
			fos.close();
			System.out.println("Objects successfully serialized");

			// Deserialization
			FileInputStream fis = new FileInputStream("empadd.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Employee outputEmp = (Employee) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("Objects successfully deserialized");
			System.out.println("Emp Id: " + emp.getId());
			System.out.println("Address: " + emp.getAddress().getCity());
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}