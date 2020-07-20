import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class Methods {

    // Creates and returns an int array[200000000] populated with random numbers between 1 and 10
    public static int[] populateArray(){
        int[] result = new int[200000000];
        System.out.println("[Methods.populateArray()] Populating the array (n=200,000,000) with random numbers " +
                "between 1 and 10...");
        for (int i = 0; i < result.length; i++) {
            Random rand = new Random();
            result[i] = rand.nextInt(10 - 1 + 1) + 1;
        }
        return result;
    } // end populateArray()


    // Separates the random number array into four sub-arrays to be used for the multi-threaded count,
    // and returns all four inside of an ArrayList
    public static ArrayList<int[]> separateArray(int[] array){
        ArrayList<int[]> results = new ArrayList<int[]>();

        int array1[] = new int[50000000];
        int size1 = 0;
        int array2[] = new int[50000000];
        int size2 = 0;
        int array3[] = new int[50000000];
        int size3 = 0;
        int array4[] = new int[50000000];
        int size4 = 0;

        for(int i = 0; i < 200000000; i++){
            if(i < 50000000) {
                array1[size1] = array[i];
                size1++;
            }
            else if(i >= 50000000 && i < 100000000) {
                array2[size2] = array[i];
                size2++;
            }
            else if(i >= 100000000 && i < 150000000) {
                array3[size3] = array[i];
                size3++;
            }
            else if(i >= 150000000 && i < 200000000) {
                array4[size4] = array[i];
                size4++;
            }
        } // end for

        results.add(array1);
        results.add(array2);
        results.add(array3);
        results.add(array4);

        return results;
    } // end separateArray()


    // Takes the array of random numbers, and uses a multiple threads to calculate the sum
    public static void multiThreadSum(int[] nums) throws ExecutionException, InterruptedException {
        System.out.println("\n[Methods.multiTreadSum()] Separating the single array four ways...");
        ArrayList<int[]> arrays = separateArray(nums);

        System.out.println("[Methods.multiTreadSum()] Starting multi thread sum...");

        long start, end, total;

        start = System.nanoTime();
        System.out.println("[Methods.multiTreadSum()] Started @ " + start + "ns");
        ExecutorService service = Executors.newFixedThreadPool(1);
        Callable callable2 = new MultiArraySum(arrays);
        Future<Integer> future = service.submit(callable2);
        end = System.nanoTime();
        System.out.println("[Methods.multiTreadSum()] Ended @ " + end + "ns");
        total = end - start;

        int sum = future.get();

        System.out.println("[Methods.multiTreadSum()] The sum of the array is " + sum);
        System.out.println("[Methods.multiTreadSum()] Process took about " + total + "ns, or "
                + total/1000000 + "ms");
    } // end multiThreadSum()


    // Takes the array of random numbers, and uses a single thread to calculate the sum
    public static void singleTreadSum(int[] nums) throws ExecutionException, InterruptedException {
        System.out.println("\n[Methods.singleTreadSum()] Starting single thread sum...");
        long start, end, total;

        start = System.nanoTime();
        System.out.println("[Methods.singleTreadSum()] Started @ " + start + "ns");
        ExecutorService service = Executors.newFixedThreadPool(1);
        Callable callable1 = new ArraySum(nums);
        Future<Integer> future = service.submit(callable1);
        end = System.nanoTime();
        System.out.println("[Methods.singleTreadSum()] Ended @ " + end + "ns");
        total = end - start;

        int sum = future.get();

        System.out.println("[Methods.singleTreadSum()] The sum of the array is " + sum);
        System.out.println("[Methods.singleTreadSum()] Process took about " + total + "ns, or "
                + total/1000000 + "ms");
    } // end singleTreadSum()

} // end Methods
