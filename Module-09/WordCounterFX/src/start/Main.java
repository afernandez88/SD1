package start;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main class of the WordCounterFX application
 *
 * This application will return the count for each word found in
 * an inputted .txt file.
 *
 * @author Andre Fernandez
 * @version 2.0 - July 8, 2020
 */

public class Main extends Application {
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
    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("Word Occurrence Counter");
        mainView();
    } // end start()

    /**
     * Launches the application.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException { launch(args); }

} //end Main
