package school.teachers;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import school.Address;
import school.Main;
import school.Teacher;

public class TeacherRecordsController {

	int effSize = 0;
	ArrayList<Teacher> teachers = Main.getTeachers();
	ObservableList<Teacher> teacherList = FXCollections.observableArrayList();

	private void fillList() {
		teacherList.clear();
		teacherList.addAll(teachers);
		System.out.println("ObservableList filled with " + teacherList.size() + " value.");
		System.out.println(teacherList);
	}

	@FXML
	private TableView<Teacher> personalView;
	@FXML
	private TableColumn<Teacher, String> nameColumn;
	@FXML
	private TableColumn<Teacher, String> dobColumn;
	@FXML
	private TableColumn<Teacher, Address> addressColumn;
	@FXML
	private TableColumn<Teacher, Character> genderColumn;
	@FXML
	private TableColumn<Teacher, Boolean> smokerColumn;

	// private TableView<Teacher> teacherView;
	@FXML
	private TableView<Teacher> teacherView;
	@FXML
	private TableColumn<Teacher, String> nameColumn1;
	@FXML
	private TableColumn<Teacher, Integer> idColumn;
	@FXML
	private TableColumn<Teacher, String> subjectColumn;
	@FXML
	private TableColumn<Teacher, Integer> classesColumn;
	@FXML
	private TableColumn<Teacher, String> officeColumn;

	public void initialize() {
		fillList();
		// Setting up personal info
		nameColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
		dobColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("dob"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<Teacher, Address>("address"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<Teacher, Character>("gender"));
		smokerColumn.setCellValueFactory(new PropertyValueFactory<Teacher, Boolean>("smoker"));

		// Setting up teacher info
		nameColumn1.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("teacherId"));
		subjectColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("subjectTaught"));
		classesColumn.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("totalClasses"));
		officeColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("officeNum"));

		personalView.setItems(teacherList);
		teacherView.setItems(teacherList);

	}

}
