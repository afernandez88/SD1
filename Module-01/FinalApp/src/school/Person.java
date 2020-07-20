package school;

import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public class Person  implements Serializable {
	/////////////////////////////////////////////////////////// Fields
	private Name name;
	private String dob;
	private Address address;
	private char gender;
	private boolean smoker;

	/////////////////////////////////////////////////////////// Constructors
	public Person(Name name, String dob, Address address, char gender, boolean smoker) {
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.gender = gender;
		this.smoker = smoker;
	}

	public Person() {
		createPerson();
	}

	/////////////////////////////////////////////////////////// Getters and Setters
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

	/////////////////////////////////////////////////////////// toString and Equals
	public String toString() {
		String result = this.name + "\t" + this.dob + "\t" + this.address + "\t" + this.gender + "\t" + this.smoker + "\t";
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (smoker != other.smoker)
			return false;
		return true;
	}

	/////////////////////////////////////////////////////////// Methods
	public void createPerson() {
		
	}

}// end Person class
