package school;

import java.io.Serializable;
import java.util.Date;

public class Student extends Person  implements Serializable {
	/////////////////////////////////////////////////////////// Fields
	private int studentId;
	private String major;
	private double gpa;
	private int creditsCompleted;

	/////////////////////////////////////////////////////////// Constructors
	public Student(Name name, String dob, Address address, char gender, boolean smoker, int studentId, String major,
			double gpa, int creditsCompleted) {
		super(name, dob, address, gender, smoker);
		this.studentId = studentId;
		this.major = major;
		this.gpa = gpa;
		this.creditsCompleted = creditsCompleted;
	}

	public Student() {
		// createStudent();
	}

	/////////////////////////////////////////////////////////// Getters and Setters
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getCreditsCompleted() {
		return creditsCompleted;
	}

	public void setCreditsCompleted(int creditsCompleted) {
		this.creditsCompleted = creditsCompleted;
	}

	public String toString() {
		String result = super.toString();
		result += this.studentId + "\t" + this.major + "\t" + this.gpa + "\t" + this.creditsCompleted;

		return result;
	}

	/////////////////////////////////////////////////////////// toString and Equals
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (creditsCompleted != other.creditsCompleted)
			return false;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}
	/////////////////////////////////////////////////////////// Methods

}// end Student class
