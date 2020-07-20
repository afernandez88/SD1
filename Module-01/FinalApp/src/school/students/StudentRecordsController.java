package school.students;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import school.Address;
import school.Main;
import school.Student;

public class StudentRecordsController {

	int effSize = 0;
	ArrayList<Student> students = Main.getStudents();
	ObservableList<Student> studentList = FXCollections.observableArrayList();

	private void fillList() {
		studentList.clear();
		studentList.addAll(students);
		System.out.println("ObservableList filled with " + studentList.size() + " value.");
		System.out.println(studentList);
	}

	@FXML
	private TableView<Student> personalView;
	@FXML
	private TableColumn<Student, String> nameColumn;
	@FXML
	private TableColumn<Student, String> dobColumn;
	@FXML
	private TableColumn<Student, Address> addressColumn;
	@FXML
	private TableColumn<Student, Character> genderColumn;
	@FXML
	private TableColumn<Student, Boolean> smokerColumn;

	// private TableView<Student> StudentView;
	@FXML
	private TableView<Student> studentView;
	@FXML
	private TableColumn<Student, String> nameColumn1;
	@FXML
	private TableColumn<Student, Integer> idColumn;
	@FXML
	private TableColumn<Student, String> majorColumn;
	@FXML
	private TableColumn<Student, Double> gpaColumn;
	@FXML
	private TableColumn<Student, Integer> creditsColumn;

	public void initialize() {
		fillList();
		// Setting up personal info
		nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		dobColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("dob"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<Student, Address>("address"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<Student, Character>("gender"));
		smokerColumn.setCellValueFactory(new PropertyValueFactory<Student, Boolean>("smoker"));

		// Setting up Student info
		nameColumn1.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("studentId"));
		majorColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("major"));
		gpaColumn.setCellValueFactory(new PropertyValueFactory<Student, Double>("gpa"));
		creditsColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("creditsCompleted"));

		personalView.setItems(studentList);
		studentView.setItems(studentList);

	}

}
