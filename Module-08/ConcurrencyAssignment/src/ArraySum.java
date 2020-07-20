import java.util.concurrent.Callable;

/*
 * - Task class that takes an array of integers, and returns the sum.
 */
public class ArraySum implements Callable<Integer> {
    private int array[];

    public ArraySum(int[] array) {
        this.array = array;
    } // end ArraySum()

    public Integer call() throws Exception {
        int sum = 0;
        for(int i : array)
            sum+=i;
        return sum;
    } // end call()
} // end ArraySum