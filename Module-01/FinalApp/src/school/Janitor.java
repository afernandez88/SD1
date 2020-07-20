package school;
import java.io.Serializable;
import java.util.Date;

public class Janitor extends Person  implements Serializable {
	/////////////////////////////////////////////////////////// Fields
	private int employeeId; 
	private int yearsWorked;
	private boolean bldgClean;
	private double payRate;

	/////////////////////////////////////////////////////////// Constructors
	public Janitor(Name name, String dob, Address address, char gender, boolean smoker, int employeeId, int yearsWorked,
			boolean bldgClean, double payRate) {
		super(name, dob, address, gender, smoker);
		this.employeeId = employeeId;
		this.yearsWorked = yearsWorked;
		this.bldgClean = bldgClean;
		this.payRate = payRate;
	}

	public Janitor() {
		// createJanitor();
	}

	/////////////////////////////////////////////////////////// Getters and Setters
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getYearsWorked() {
		return yearsWorked;
	}

	public void setYearsWorked(int yearsWorked) {
		this.yearsWorked = yearsWorked;
	}

	public boolean isBldgClean() {
		return bldgClean;
	}

	public void setBldgClean(boolean bldgClean) {
		this.bldgClean = bldgClean;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	/////////////////////////////////////////////////////////// toString and Equals
	public String toString() {
		String result = super.toString();
		result += this.employeeId + "\t" + this.yearsWorked + "\t" + this.bldgClean + "\t" + this.payRate;
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Janitor other = (Janitor) obj;
		if (bldgClean != other.bldgClean)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (Double.doubleToLongBits(payRate) != Double.doubleToLongBits(other.payRate))
			return false;
		if (yearsWorked != other.yearsWorked)
			return false;
		return true;
	}
	
	/////////////////////////////////////////////////////////// Methods

}// end Janitor class
