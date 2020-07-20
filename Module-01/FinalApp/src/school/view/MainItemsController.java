package school.view;

import java.io.IOException;

import javafx.fxml.FXML;
import school.Main;

//This class allows you to write methods for the main page buttons
//Every fxml file must have a controller class
//This controller must be in the same package as the fxml file

public class MainItemsController {
	private Main main;
	@FXML
	private void goTeachers() throws IOException {
		main.showTeacherScene();
	}
	@FXML
	private void goStudents() throws IOException {
		main.showStudentScene();
	}
	@FXML
	private void goJanitors() throws IOException {
		main.showJanitorScene();
	}
	
	@FXML
	private void goView() {
		main.animation();
	}
	
	@FXML
	private void goDatabase() throws IOException {
		main.showDatabaseScene();
	}
	

}
