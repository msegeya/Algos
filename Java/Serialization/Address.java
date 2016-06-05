/**
	Source: http://www.javacodegeeks.com/2013/03/serialization-in-java.html
*/

import java.io.Serializable;

class Address 
		implements Serializable 
{
	private String city;

	Address(String city) {
		this.city = city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}
}