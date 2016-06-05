/**
	Source: http://www.javacodegeeks.com/2013/03/serialization-in-java.html

	Question: Serialization Example

	Description: Serialize an object by writing it to a file.

*/
import java.io.*;

class SerializationDemo {
	public static void main(String[] args) {
		try {
			Employee emp = new Employee(1, "Amarnath", "CS");
			FileOutputStream fos = new FileOutputStream("employee.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(emp);
			oos.close();
			fos.close();
			System.out.println("Employee Object Serialized successfully.");
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}