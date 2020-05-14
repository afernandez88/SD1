package school.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import school.Address;
import school.Main;
import school.Name;
import school.State;
import school.Student;

public class AddNewStudentRecordController {

	ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female", "Other", "Unknown");
	ObservableList<String> stateList = FXCollections.observableArrayList("AK", "AL", "AR", "AS", "AZ", "CA", "CO", "CT",
			"DC", "DE", "FL", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN",
			"MO", "MP", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR", "RI",
			"SC", "SD", "TN", "TX", "UM", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY");

	// Name Info
	@FXML
	private TextField fNameField;
	@FXML
	private TextField mNameField;
	@FXML
	private TextField lNameField;

	// Address Info
	@FXML
	private TextField streetNumField;
	@FXML
	private TextField streetNameField;
	@FXML
	private TextField streetTypeField;
	@FXML
	private TextField cityField;
	@FXML
	private ChoiceBox stateTypeBox;
	@FXML
	private TextField zipCodeField;

	// Smoker Info
	@FXML
	private RadioButton yesSmokeButton;
	@FXML
	private RadioButton noSmokeButton;
	@FXML
	private ChoiceBox genderBox;
	@FXML
	private DatePicker dob;

	// Student Info
	@FXML
	private TextField studentIdField;
	@FXML
	private TextField majorField;
	@FXML
	private TextField gpaField;
	@FXML
	private TextField totalCreditsField;

	////// Methods

	@FXML
	private void initialize() {
		stateTypeBox.setItems(stateList);
		genderBox.setValue("Unknown");
		genderBox.setItems(genderList);
	}

	@FXML
	private void createStudent() {
		try {
			// Creating Person
			// Getting student address
			State studentState = new State(stateTypeBox.getValue().toString());

			Address studentAddy = new Address(Integer.parseInt(streetNumField.getText()), streetNameField.getText(),
					streetTypeField.getText(), cityField.getText(), studentState, Integer.parseInt(zipCodeField.getText()));
			
			// Getting student name
			Name studentName = new Name(fNameField.getText(), mNameField.getText().charAt(0), lNameField.getText());
			String studentDob = dob.getValue().toString();
			// Getting gender
			char studentGender = genderBox.getValue().toString().charAt(0);

			// Getting smoker
			boolean studentSmoker = false;
			if (yesSmokeButton.isSelected()) {
				studentSmoker = true;
			}

			// Creating Student
			int studentId = Integer.parseInt(studentIdField.getText());
			String studentMajor = majorField.getText();
			double studentGpa = Double.parseDouble(gpaField.getText());
			int studentCredits = Integer.parseInt(totalCreditsField.getText());
			
			if((studentGpa < 1.0)||(studentGpa > 5.0))
			{
				throw new Exception();
			}
			
			if((studentCredits < 0)||(studentCredits > 100))
			{
				throw new Exception();
			}

			Student student = new Student(studentName, studentDob, studentAddy, studentGender, studentSmoker, studentId,
					studentMajor, studentGpa, studentCredits);
			Main.addStudent(student);
			
			}
			catch(NumberFormatException nfe)
			{
				System.err.println("Please enter values in the correct format");
			}
			catch(Exception gpa)
			{
				System.err.println("Please make sure GPA and credits amount are in range.");
			}
	}

}
