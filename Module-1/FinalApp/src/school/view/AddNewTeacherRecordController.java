package school.view;

import java.io.IOException;
import java.util.Calendar;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import school.Address;
import school.Main;
import school.Name;
import school.State;
import school.Student;
import school.Teacher;

public class AddNewTeacherRecordController {

	private Main main;

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

	// Teacher Info
	@FXML
	private TextField teacherIdField;
	@FXML
	private TextField subjectField;
	@FXML
	private TextField classesField;
	@FXML
	private TextField bldgNumField;
	@FXML
	private TextField roomNumField;
	
	@FXML
	private Button createButton;
	
	////// Methods

	@FXML
	private void initialize() {
		stateTypeBox.setItems(stateList);
		genderBox.setValue("Unknown");
		genderBox.setItems(genderList);
	}

	@FXML
	private void createTeacher() {
		try {
			// Creating Person
			// Getting teacher address
			State teacherState = new State(stateTypeBox.getValue().toString());
			Address teacherAddy = new Address(Integer.parseInt(streetNumField.getText()), streetNameField.getText(),
					streetTypeField.getText(), cityField.getText(), teacherState, Integer.parseInt(zipCodeField.getText()));
			// Getting teacher name
			Name teacherName = new Name(fNameField.getText(), mNameField.getText().charAt(0), lNameField.getText());
			String teacherDob = dob.getValue().toString();
			// Getting gender
			char teacherGender = genderBox.getValue().toString().charAt(0);

			// Getting smoker
			boolean teacherSmoker = false;
			if (yesSmokeButton.isSelected()) {
				teacherSmoker = true;
			}

			// Creating Teacher
			int teacherId = Integer.parseInt(teacherIdField.getText());
			String teacherSubject = subjectField.getText();
			int teacherClasses = Integer.parseInt(classesField.getText());
			// Get officeNum
			int[] teacherOffice = new int[2];
			teacherOffice[0] = Integer.parseInt(bldgNumField.getText());
			teacherOffice[1] = Integer.parseInt(roomNumField.getText());

			Teacher teacher = new Teacher(teacherName, teacherDob, teacherAddy, teacherGender, teacherSmoker, teacherId,
					teacherSubject, teacherClasses, teacherOffice);
			Main.addTeacher(teacher);
			}
			catch(NumberFormatException nfe)
			{
				System.err.println("Please enter values in the correct format");
			}
			
			//Maybe clear everything after
			
		
	}

}
