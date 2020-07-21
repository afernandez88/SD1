import java.io.*;
import java.net.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * Client side for application that determines whether or not a number is prime.
 * @author Andre Fernandez
 * July 20, 2020
 */

public class Client extends Application {

    // Create io stream reference variables
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    /**
     * Generates the stage of the client-side.
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        // Creating the view
        BorderPane textPane = new BorderPane();
        textPane.setPadding(new Insets(5, 5, 5, 5));
        textPane.setLeft(new Label("Enter a number "));
        TextField text = new TextField();
        text.setAlignment(Pos.BOTTOM_RIGHT);
        textPane.setCenter(text);
        BorderPane mainPane = new BorderPane();
        TextArea area = new TextArea();
        mainPane.setCenter(new ScrollPane(area));
        mainPane.setTop(textPane);

        // Creating the scene, and setting the stage
        Scene scene = new Scene(mainPane, 450, 250);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        text.setOnAction(e -> {

            // Sending the number to the server
            try {
                int num = Integer.parseInt(text.getText().trim());
                toServer.writeInt(num);
                toServer.flush(); // Flushing the data stream

                // Get result from the server
                boolean result = fromServer.readBoolean();

                // Displaying the result
                if(result){
                    area.appendText(num + " is prime!\n");
                } else {
                    area.appendText(num + " is NOT prime!\n");
                }

            } catch (IOException e1) {
                System.out.println("Error writing to the server");
                System.err.println(e1);
            } // end catch
        }); // end setOnAction

        try {

            // Creating socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Creating IO stream to get data from server
            fromServer = new DataInputStream(socket.getInputStream());

            // Creating IO stream to get data from server
            toServer = new DataOutputStream(socket.getOutputStream());

        } catch (IOException ioe) {
            area.appendText(ioe.toString() + "\n");
            System.out.println("Issue to and from the server");
        } // end catch

    }// end start()


    /**
     * Starts the client-side application.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }//end main()

}//end Client
