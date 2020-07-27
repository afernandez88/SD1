package start;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.omg.Messaging.SyncScopeHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Controller Class for the Main FX View
 *
 * @author Andre Fernandez
 */

public class MainController {

    public static String text;

    private static ObservableList<Word> observableList = FXCollections.observableArrayList();
    private static ObservableList<TextFile> filesInDatabase = FXCollections.observableArrayList();

    private static int selection;
    private static File sampleFile = new File("Poem.txt");
    private static File newFile;
    private static boolean usingSample = false;

    ////////////////////////////////////////// FX id's
    // Menu bar
    @FXML
    private ComboBox choose;
    @FXML
    private Button openNew;
    @FXML
    private Button clear;

    // Vbox

    @FXML
    private Button count;
    @FXML
    private Text stats;

    // Top 20 tab
    @FXML
    private TableView<Word> occurrenceViewTop20;
    @FXML
    private TableColumn<Word, String> textColumnTop20;
    @FXML
    private TableColumn<Word, Integer> countColumnTop20;

    // All words tab
    @FXML
    private TableView<Word> occurrenceViewAll;
    @FXML
    private TableColumn<Word, String> textColumnAll;
    @FXML
    private TableColumn<Word, Integer> countColumnAll;

    ////////////////////////////////////////// Controller Method's

    /**
     * Initializes the MainController.
     */
    @FXML
    private void initialize() {
        //Pulls all text files from the database
        choose.getItems().clear();
        filesInDatabase = Database.readFiles(Main.conn);
        for(int i = 0; i < filesInDatabase.size(); i++){
            choose.getItems().add(filesInDatabase.get(i).getName());
        }
    } // end initialize()


    /**
     * Takes the ArrayList of Word objects, and puts it into an ObservableList
     * that will populate the GUI.
     */
    private void fillList() {
        observableList.clear();
        observableList.addAll(Database.readWords(Main.conn));
    } // end fillList()


    /**
     * Action for the "Count" button.
     *
     * Takes the data from the ObservableList, and populates the TableViews with the data.
     */
    public void countButtonAction() throws Exception {

        try {
            Database.clearTable(Main.conn);
        } catch (Exception e) {
            System.out.println(e);
        }

        selection = choose.getSelectionModel().getSelectedIndex();
        System.out.println("[MainController.countButtonAction()] Selection = " +
                filesInDatabase.get(selection).getName());
        String selectionText = filesInDatabase.get(selection).getContent();
        Methods.getTopWordList(selectionText);
        fillList();
        textColumnAll.setCellValueFactory(new PropertyValueFactory<Word, String>("text"));
        countColumnAll.setCellValueFactory(new PropertyValueFactory<Word, Integer>("count"));
        occurrenceViewAll.setItems(observableList);

        ObservableList<Word> observableListTop20 = FXCollections.observableArrayList();
        for(int i = 0; i < 20; i++)
            observableListTop20.add(observableList.get(i));

        textColumnTop20.setCellValueFactory(new PropertyValueFactory<Word, String>("text"));
        countColumnTop20.setCellValueFactory(new PropertyValueFactory<Word, Integer>("count"));
        occurrenceViewTop20.setItems(observableListTop20);

        String results = getStats(observableList);

        stats.setText(results);
    } // countButtonAction()


    /**
     * Action for the "Clear" button.
     *
     * Clears the loaded .txt, clears the TableViews, and disables the Count button
     */
    public void clearButtonAction() {
        observableList.clear();
        stats.setText("");
        occurrenceViewAll.getItems().clear();
        occurrenceViewTop20.getItems().clear();
        usingSample = false;
        try {
            Database.clearTable(Main.conn);
        } catch (Exception e) {
            System.out.println("[Main.main()] Could not flush word table.");
        }
    } // end clearButtonAction()


    /**
     * Action for the "Open a new .txt" button
     *
     * Prompts the user to choose a .txt file
     * @param event
     */
    public void newFileAction(ActionEvent event){

        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if(selectedFile != null){
            System.out.println("[Methods.newFileAction] Valid File selected");
        } else System.out.println("[Methods.newFileAction] Invalid File selected");

        try {
            Database.postFile(Main.conn, selectedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        initialize();
    } // end newFileAction()


    /**
     * Gets the file name, word count, and number of unique words
     * @param list
     * @return String containing the stats.
     */
    public static String getStats( ObservableList<Word> list){
        String result = "";

        result += "Results for " + filesInDatabase.get(selection).getName() + "\n\n";


        int wordCount = 0;
        int unique = list.size();

        for(Word w : list)
            wordCount += w.count;

        result += "Word Count: " + wordCount + "\n\n";
        result += "Unique Words: " + unique + "\n\n";

        System.out.println("[Methods.getStats()] Stats gathered successfully.");
        return result;
    } // end getStats

} // end MainController()
