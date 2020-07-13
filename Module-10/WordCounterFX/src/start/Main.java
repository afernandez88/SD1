package start;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

/**
 * Main class of the WordCounterFX application
 *
 * This application will return the count for each word found in
 * an inputted .txt file.
 *
 * This application is sending all information to a local mySQL database
 * called "word_occurrences".
 *
 * @author Andre Fernandez
 * @version 3.0 - July 13, 2020
 */

public class Main extends Application {

    public static Connection conn;
    private static Stage primaryStage;
    private static BorderPane mainLayout;

    /**
     * Builds the main view of the border pane.
     * @throws IOException
     */
    private void mainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Main.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    } // end mainView()


    /**
     * Starts the Main View.
     * @param primaryStage
     * @throws IOException
     */
    public void start(Stage primaryStage) throws Exception {
        conn = Database.getConnection();
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("Word Occurrence Counter");
        mainView();
    } // end start()


    /**
     * Launches the application.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
        try {
            Database.clearTable(Main.conn);
        } catch (Exception e) {
            System.out.println("[Main.main()] Could not flush word table.");
        }
    } // end main()

} //end Main
