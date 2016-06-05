/**
	Description: Serilize and DeSerialize an object when the class is not serialized.

	NOTE: We need to use "transient" keyword to make sure that the class is not Serialized and we will serialize it manually.

*/

import java.io.*;

class SerializeAndDeserialize {
	public static void main(String[] args) {
		try {
			// Serialization
			Course crs = new Course(1);
			Student stu = new Student("Amarnath", crs);
			FileOutputStream fos = new FileOutputStream("student.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(stu);
			oos.close();
			fos.close();
			System.out.println("Objects successfully serialized");

			// Deserialization
			FileInputStream fis = new FileInputStream("student.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student outputStu = (Student) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("Objects successfully deserialized");
			System.out.println("Student Name: " + outputStu.getName());
			System.out.println("Student Course: " + outputStu.getCourse().getCid());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}


class Student implements Serializable {
	private String name;

	// If Course is not serialized then ?
	// Java serialization provides a mechnism such that if you have private methods with particular signature then they will
	// get called during serialization and deserialization. So we will override writeObject and readObject method of Student 
	// class and they will be called during serialization and deserialization of Student object. 
	private transient Course course;

	Student(String name) {
		this.name = name;
	}

	Student(String name, 
					Course course) {
		this.name = name;
		this.course = course;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCourse() {
		return this.course;
	}

	private void writeObject(ObjectOutputStream oos) 
							throws IOException, ClassNotFoundException {
		try {
			oos.defaultWriteObject();
			oos.writeInt(course.getCid());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void readObject(ObjectInputStream ois) 
						throws IOException, ClassNotFoundException {
		try {
			ois.defaultReadObject();
			int cid = ois.readInt();
			course = new Course(cid);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Course {
	private int cid;

	Course(int cid) {
		this.cid = cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCid() {
		return this.cid;
	}
}