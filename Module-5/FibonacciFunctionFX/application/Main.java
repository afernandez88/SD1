// Author: Andre Fernandez
// Class: Software Development 1
// Assignment: Create a line chart that shows the differences in efficiency for the 
//             Fibonacci Function by recusion and iteration.

package application;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Main extends Application {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void start(Stage stage) {
		/*
		 * A "Fib" is a simple object used to hold the data of each entry in the
		 * Fibonacci sequence.
		 * 
		 * Each object will hold the next number in the series, along with the time that
		 * it took to reach that number from the previous in nano seconds (ns).
		 */

		// Number of entries in the sequence
		int n = 40;

		// Gathering data using recursion
		ArrayList<Fib> recursiveFibs = Methods.buildRecursiveList(n);

		// Gathering data using iteration
		ArrayList<Fib> iterativeFibs = Methods.buildIterativeList(n);

		Methods.printLists(iterativeFibs, recursiveFibs, n);

		// Creating the Line Chart
		System.out.println("\nPlotting Data...");

		stage.setTitle("Assignment 5");

		// Defining the axes...
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Integers");
		yAxis.setLabel("Time (ns)");

		// Initializing...
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
		lineChart.setTitle("Fibonacci Function - Recursive vs. Iterative");

		// Defining the series'...
		XYChart.Series recursive = new XYChart.Series();
		XYChart.Series iterative = new XYChart.Series();

		recursive.setName("Recursive");
		iterative.setName("Iterative");

		// Populating the series' with data...
		for (Fib f : recursiveFibs)
			recursive.getData().add(new XYChart.Data(f.getNum(), f.getTime()));

		for (Fib f : iterativeFibs)
			iterative.getData().add(new XYChart.Data(f.getNum(), f.getTime()));

		Scene scene = new Scene(lineChart, 800, 600);
		lineChart.getData().add(recursive);
		lineChart.getData().add(iterative);

		// Presenting to user
		stage.setScene(scene);
		stage.show();
	} // end start

	public static void main(String[] args) {
		launch(args);
	} // end main()
	
} // end Main
