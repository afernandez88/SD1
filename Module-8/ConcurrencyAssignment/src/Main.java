import java.util.concurrent.ExecutionException;
/*
 * Author: Andre Fernandez
 * Date: July 1, 2020
 * Class: Software Development 1
 *
 * Assignment:
 * Make an array of 200 million random numbers between 1 and 10.
 * Compute the sum in parallel using multiple threads.
 * Then compute the sum with only one thread, and display the sum and times for both cases.
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Creating the random number array
        int[] nums;

        // Number of times the test will run
        int runs = 4;

        for(int i = 1; i <= runs; i++) {
            System.out.println("Run " + i + " -------------------------------------------" +
                    "---------------------------------------------------------");
            // Populating the random number array
            nums = Methods.populateArray();
            // Computing the sum of the array using multiple threads
            Methods.multiThreadSum(nums);
            // Computing the sum of the array using a single thread
            Methods.singleTreadSum(nums);
            System.out.println("\n");
        }

    } // end main()

} // end Main
