package school.view;

import java.io.IOException;

import javafx.fxml.FXML;
import school.Main;

public class MainViewController {
	private Main main;
	
	@FXML
	private void goHome() throws IOException {
		main.showMainItems();
	}

	@FXML
	private void addTeacherButton() throws IOException {
		main.showAddTeacherStage();
	}
	
	@FXML
	private void addStudentButton() throws IOException {
		main.showAddStudentStage();
	}
	
	@FXML
	private void addJanitorButton() throws IOException {
		main.showAddJanitorStage();
	}
	
	@FXML
	private void saveButton() {
		main.saveEverything();
	}
	
	@FXML
	private void openButton() {
		main.openEverything();
	}
}
