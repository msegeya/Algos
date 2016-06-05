/**
	Source: http://www.javacodegeeks.com/2013/03/serialization-in-java.html

	Description: Deserialising an object by reading it from the file.
*/
import java.io.*;

class DeSerializationDemo {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("employee.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Employee emp = (Employee) ois.readObject();
			ois.close();
			fis.close();

			System.out.println("After DeSerialization of Employee Object: ");
			System.out.println("Employee Id: " + emp.getId());	
			System.out.println("Employee Name: " + emp.getName());
			System.out.println("Employee Dept.: " + emp.getDept());
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}