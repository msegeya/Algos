/**
	Question: What is Serialization?

	Serialization:
	Object Serialization in Java is a process used to convert Object into a binary format which can be persisted into disk or sent over network to any other running Java virtual machine; the reverse process of creating object from binary stream is called deserialization in Java.

	Serializable has no methods. If no method then what is the purpose of Serializable interface?
	Serializable interface exists in java.io package and forms core of java serialization mechanism. It doesn't have any method and also called Marker Interface in Java. When your class implements java.io.Serializable interface it becomes Serializable in Java and gives compiler an indication that use Java Serialization mechanism to serialize this object.

	What is serialVersionUID? What would happen if you don't define this?
	SerialVersionUID is an ID which is stamped on object when it get serialized usually hashcode of object. 

	While serializing you want some of the members not to serialize? How do you achieve it?
	If you don't want any field to be part of object's state then declare it either "static" or "transient" based on your need and it will not be included during Java serialization process.

	What will happen if one of the members in the class doesn't implement Serializable interface?
	If you try to serialize an object of a class which implements Serializable, but the object includes a reference to an non- Serializable class then a 'NotSerializableException' will be thrown at runtime.

	Are the static variables saved as the part of serialization?
	No. The static variables belong to the class are not the part of the state of the object so they are not saved as the part of serialized object.

	What will be the value of transient variable after de-serialization?
	It's default value.
	Ex: If the transient variable in question is an int, it’s value after deserialization will be zero. For object it will be null.

	If a class is serializable but its superclass in not, what will be the state of the instance variables inherited from super class after deserialization?
	The values of the instance variables inherited from superclass will be reset to the values they were given during the original construction of the object as the non-serializable super-class constructor will run.

	Serializable Vs Externalizable:
	Externalizable interface, which extends Serializable. By implementing Externalizable, a developer is responsible for implementing the writeExternal() and readExternal() methods. As a result, a developer has sole control over reading and writing the serialized objects.

*/

class Serialization {
	// NOTE: Read all the above points and make sure you read all the below files.
	// Refer Serialization/SerializationDemo.java
	// Refer Serialization/DeSerializationDemo.java
	// Refer Serialization/SerializeAndDeserialize.java
}