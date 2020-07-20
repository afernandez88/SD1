package school.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import school.Address;
import school.Janitor;
import school.Main;
import school.Name;
import school.State;
import school.Student;
import school.Teacher;

public class AddNewJanitorRecordController {

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

	// Janitor Info
	@FXML
	private TextField employeeIdField;
	@FXML
	private TextField yearsWorkedField;
	@FXML
	private RadioButton noCleanButton;
	@FXML
	private RadioButton yesCleanButton;
	@FXML
	private TextField salaryField;

	////// Methods

	@FXML
	private void initialize() {
		stateTypeBox.setItems(stateList);
		genderBox.setValue("Unknown");
		genderBox.setItems(genderList);
	}

	@FXML
	private void createJanitor() {
		try {
			// Creating Person
			// Getting Janitor address
			State janitorState = new State(stateTypeBox.getValue().toString());
			Address janitorAddy = new Address(Integer.parseInt(streetNumField.getText()), streetNameField.getText(),
					streetTypeField.getText(), cityField.getText(), janitorState, Integer.parseInt(zipCodeField.getText()));
			// Getting janitor name
			Name janitorName = new Name(fNameField.getText(), mNameField.getText().charAt(0), lNameField.getText());
			String janitorDob = dob.getValue().toString();
			// Getting gender
			char janitorGender = genderBox.getValue().toString().charAt(0);

			// Getting smoker
			boolean janitorSmoker = false;
			if (yesSmokeButton.isSelected()) {
				janitorSmoker = true;
			}

			// Creating Janitor
			int janitorId = Integer.parseInt(employeeIdField.getText());
			int janitorEmployed = Integer.parseInt(yearsWorkedField.getText());
			boolean janitorCleaned = false;
			if (yesCleanButton.isSelected()) {
				janitorCleaned = true;
			}
			double janitorPay = Double.parseDouble(salaryField.getText());
			
				if((janitorPay < 10.0)||(janitorPay > 25.0))
				{
					throw new Exception();
				}

			Janitor janitor = new Janitor(janitorName, janitorDob, janitorAddy, janitorGender, janitorSmoker, janitorId,
					janitorEmployed, janitorCleaned, janitorPay);
			Main.addJanitor(janitor);
			}
			catch(NumberFormatException nfe)
			{
				System.err.println("Please enter values in the correct format.");
			}
			catch(Exception pay)
			{
				System.err.println("Please enter the janitor pay within range.");
			}
	}
}
