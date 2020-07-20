package school;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Name  implements Serializable {
	/////////////////////////////////////////////////////////// Fields
	private String fName;
	private char mInitial;
	private String lName;

	/////////////////////////////////////////////////////////// Constructors
	public Name(String fName, char mInitial, String lName) {
		this.fName = fName;
		this.mInitial = mInitial;
		this.lName = lName;
	}

	public Name() {
		createName();
	}

	/////////////////////////////////////////////////////////// Getters and Setters
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		String temp = fName.toLowerCase();
		char fLetter = Character.toUpperCase(temp.charAt(0));
		temp = fLetter + temp.substring(1);
		this.fName = temp;
	}

	public char getmInitial() {
		return mInitial;
	}

	public void setmInitial(char mInitial) {
		this.mInitial = Character.toUpperCase(mInitial);
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		String temp = lName.toLowerCase();
		char fLetter = Character.toUpperCase(temp.charAt(0));
		temp = fLetter + temp.substring(1);
		this.lName = temp;
	}


	/////////////////////////////////////////////////////////// toString and Equals
	public String toString() {
		return fName + " " + mInitial + " " + lName;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (mInitial != other.mInitial)
			return false;
		return true;
	}	

	/////////////////////////////////////////////////////////// Methods
	public void createName(){
		String first = JOptionPane.showInputDialog("Whats the person's first name?");
		setfName(first);
		String middle = JOptionPane.showInputDialog("Whats the person's middle initial?");
		setmInitial(middle.charAt(0));
		String last = JOptionPane.showInputDialog("Whats the person's last name?");
		setlName(last);
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}// end Name class
