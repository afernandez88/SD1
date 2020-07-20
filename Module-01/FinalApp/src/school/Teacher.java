package school;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class Teacher extends Person implements Serializable {
	/////////////////////////////////////////////////////////// Fields
	private int teacherId;
	private String subjectTaught;
	private int totalClasses;
	private int[] officeNum;

	/////////////////////////////////////////////////////////// Constructors
	public Teacher(Name name, String dob, Address address, char gender, boolean smoker, int teacherId,
			String subjectTaught, int totalClasses, int[] officeNum) {
		super(name, dob, address, gender, smoker);
		this.teacherId = teacherId;
		this.subjectTaught = subjectTaught;
		this.totalClasses = totalClasses;
		this.officeNum = officeNum;
	}

	public Teacher() {
 
	}

	/////////////////////////////////////////////////////////// Getters and Setters
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getSubjectTaught() {
		return subjectTaught;
	}

	public void setSubjectTaught(String subjectTaught) {
		this.subjectTaught = subjectTaught;
	}

	public int getTotalClasses() {
		return totalClasses;
	}

	public void setTotalClasses(int totalClasses) {
		this.totalClasses = totalClasses;
	}

	public String getOfficeNum() {
		return officeNum[0] + "-" + officeNum[1];
	}

	public void setOfficeNum(int[] officeNum) {
		this.officeNum = officeNum;
	}

	/////////////////////////////////////////////////////////// toString and Equals
	public String toString() {
		String result = super.toString();
		result += this.teacherId + "\t" + this.subjectTaught + "\t" + this.totalClasses + "\t" + this.officeNum[0] + "-" + this.officeNum[1];
		return result;
	}
	

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (!Arrays.equals(officeNum, other.officeNum))
			return false;
		if (subjectTaught == null) {
			if (other.subjectTaught != null)
				return false;
		} else if (!subjectTaught.equals(other.subjectTaught))
			return false;
		if (teacherId != other.teacherId)
			return false;
		if (totalClasses != other.totalClasses)
			return false;
		return true;
	}

	/////////////////////////////////////////////////////////// Methods

}// end Teacher class
