/**
	Source: http://www.javacodegeeks.com/2013/03/serialization-in-java.html
*/

import java.io.Serializable;

class Employee 
		implements Serializable {
	public int id;
	public String name;
	public String dept;

	// Another Example: We add Object Address.
	// NOTE: Address should also be Serialized.
	// What if we don't have access to the address class to make it serializable?
	// ==> Just make the variable as transient. => private transient Address address; 
	// ==> This will make sure we don't serialize Address. So deserialization of address gives NULL ==> fails.
	private Address address;

	Employee(int id,
				String name,
					String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	Employee(int id,
				String name,
					String dept,
						Address address) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.address = address;
	}	

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDept() {
		return this.dept;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return this.address;
	}
}