package school;

import java.io.Serializable;

public class Address  implements Serializable {
	/////////////////////////////////////////////////////////// Fields
	private int streetNum;
	private String streetName;
	private String streetType;
	private String city;
	private State state;
	private int zip;

	/////////////////////////////////////////////////////////// Constructors
	public Address(int streetNum, String streetName, String streetType, String city, State state, int zip) {
		this.streetNum = streetNum;
		this.streetName = streetName;
		this.streetType = streetType;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Address() {
		// createAddress();
	}
	
	/////////////////////////////////////////////////////////// Getters and Setters
	public int getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(int streetNum) {
		this.streetNum = streetNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
	/////////////////////////////////////////////////////////// toString and Equals
	public String toString() {
		String result = "";
		result += this.streetNum + " " + this.streetName + " " + this.streetType + ", ";
		result += this.city + ", " + this.state + " " + this.zip;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		if (streetNum != other.streetNum)
			return false;
		if (streetType == null) {
			if (other.streetType != null)
				return false;
		} else if (!streetType.equals(other.streetType))
			return false;
		return true;
	}

	/////////////////////////////////////////////////////////// Methods

}// end Address Class
