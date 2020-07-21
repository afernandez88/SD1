import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * Server side for application that determines whether or not a number is prime.
 * @author Andre Fernandez
 * July 20, 2020
 */

public class Server extends Application {

	/**
	 * Generates the stage of the server-side.
	 * @param primaryStage
	 */
	public void start(Stage primaryStage) {
		// Creating the scene, and setting the stage
		TextArea text = new TextArea();
		Scene scene = new Scene(new ScrollPane(text), 450, 200); // Window
		primaryStage.setTitle("Server");
		primaryStage.setScene(scene);
		primaryStage.show();

		new Thread(() -> {
			try {
				ServerSocket serverSocket = new ServerSocket(8000);
				Platform.runLater(() -> {
					text.appendText("Server started @" + new Date() + ".\n");
				}); // end runLater
				
				//Listening for a connection request form a client
				Socket clientSocket = serverSocket.accept();
				
				//Creating the IO data streams
				DataInputStream clientInput = new DataInputStream(clientSocket.getInputStream());
				DataOutputStream clientOutput = new DataOutputStream(clientSocket.getOutputStream());
				
				while(true) {
					// Receiving the number from the client
					int num = clientInput.readInt();
					// Checking is prime or not
					boolean result = isPrime(num);
					// Sending result back
					clientOutput.writeBoolean(result);
					Platform.runLater(() -> {
						text.appendText(num + " isPrime = " + result + "\n");
					});
				} //end while

			} catch (IOException e) {
				System.out.println("Problem with Server Socket");
				e.printStackTrace();
			} //end catch

		}).start(); // end thread
	} // end start()


	/**
	 * Determines whether or not a number is prime.
	 * @param num
	 * @return
	 */
	public boolean isPrime(int num) {
		boolean result = true;

		if(num <= 1)
			result = false;

		int cnt = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				cnt += 1;
			}
		} // end for

		if (cnt > 2)
			result = false;

		return result;
	} // end isPrime


	/**
	 * Starts the server-side application.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}//end main

}// end Server
