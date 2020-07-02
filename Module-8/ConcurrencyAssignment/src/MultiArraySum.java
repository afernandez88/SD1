import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * - Task class that takes the for sub arrays, and creates 4 threads in parallel using the ArraySum task class.
 * - Adds the returned values from each thread into the total sum, which then gets returned.
 */
public class MultiArraySum implements Callable<Integer> {
    private ArrayList<int[]> arrays;

    public MultiArraySum(ArrayList<int[]> arrays) {
        this.arrays = arrays;
    } // end MultiArraySum()

    public Integer call() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(4);

        Callable callable1 = new ArraySum(arrays.get(0));
        Future<Integer> future1 = service.submit(callable1);
        int sum1 = future1.get();

        Callable callable2 = new ArraySum(arrays.get(1));
        Future<Integer> future2 = service.submit(callable2);
        int sum2 = future2.get();

        Callable callable3 = new ArraySum(arrays.get(2));
        Future<Integer> future3 = service.submit(callable3);
        int sum3 = future3.get();

        Callable callable4 = new ArraySum(arrays.get(3));
        Future<Integer> future4 = service.submit(callable4);
        int sum4 = future4.get();

        int result = sum1 + sum2 + sum3 + sum4;

        return result;
    } // end call()
} // end MultiArraySum
