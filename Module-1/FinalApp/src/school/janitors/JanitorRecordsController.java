package school.janitors;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import school.Address;
import school.Main;
import school.Janitor;

public class JanitorRecordsController {

	int effSize = 0;
	ArrayList<Janitor> janitors = Main.getJanitors();
	ObservableList<Janitor> janitorList = FXCollections.observableArrayList();

	private void fillList() {
		janitorList.clear();
		janitorList.addAll(janitors);
		System.out.println("ObservableList filled with " + janitorList.size() + " value.");
		System.out.println(janitorList);
	}

	@FXML
	private TableView<Janitor> personalView;
	@FXML
	private TableColumn<Janitor, String> nameColumn;
	@FXML
	private TableColumn<Janitor, String> dobColumn;
	@FXML
	private TableColumn<Janitor, Address> addressColumn;
	@FXML
	private TableColumn<Janitor, Character> genderColumn;
	@FXML
	private TableColumn<Janitor, Boolean> smokerColumn;

	// private TableView<Janitor> JanitorView;
	@FXML
	private TableView<Janitor> janitorView;
	@FXML
	private TableColumn<Janitor, String> nameColumn1;
	@FXML
	private TableColumn<Janitor, Integer> idColumn;
	@FXML
	private TableColumn<Janitor, Integer> yearsWorkedColumn;
	@FXML
	private TableColumn<Janitor, Boolean> bldgCleanColumn;
	@FXML
	private TableColumn<Janitor, Double> payRateColumn;

	public void initialize() {
		fillList();
		// Setting up personal info
		nameColumn.setCellValueFactory(new PropertyValueFactory<Janitor, String>("name"));
		dobColumn.setCellValueFactory(new PropertyValueFactory<Janitor, String>("dob"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<Janitor, Address>("address"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<Janitor, Character>("gender"));
		smokerColumn.setCellValueFactory(new PropertyValueFactory<Janitor, Boolean>("smoker"));

		// Setting up Janitor info
		nameColumn1.setCellValueFactory(new PropertyValueFactory<Janitor, String>("name"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Janitor, Integer>("employeeId"));
		yearsWorkedColumn.setCellValueFactory(new PropertyValueFactory<Janitor, Integer>("yearsWorked"));
		bldgCleanColumn.setCellValueFactory(new PropertyValueFactory<Janitor, Boolean>("bldgClean"));
		payRateColumn  .setCellValueFactory(new PropertyValueFactory<Janitor, Double>("payRate"));

		personalView.setItems(janitorList);
		janitorView.setItems(janitorList);

	}

}
