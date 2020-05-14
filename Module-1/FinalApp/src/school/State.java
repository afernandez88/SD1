package school;

import java.io.Serializable;

public class State  implements Serializable {
	/////////////////////////////////////////////////////////// Fields
	private String abbrev;

	/////////////////////////////////////////////////////////// Constructors
	public State(String stateName) {
		this.abbrev = stateName;
	}

	public State() {
		// createState();
	}

	/////////////////////////////////////////////////////////// Getters and Setters

	public String getStateName() {
		return abbrev;
	}

	public void setStateName(String stateName) {
		this.abbrev = stateName;
	}

	/////////////////////////////////////////////////////////// toString and Equals
	public String toString() {
		return abbrev;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (abbrev == null) {
			if (other.abbrev != null)
				return false;
		} else if (!abbrev.equals(other.abbrev))
			return false;
		return true;
	}

	/////////////////////////////////////////////////////////// Methods

}// end State Class
