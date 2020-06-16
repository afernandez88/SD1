package application;

import java.util.*;

public class Methods {

	public static long recursion(long i) {
		// Generating the next number for the recursion list
		if (i == 0)
			return 0;
		if (i <= 2)
			return 1;
		long fibterm = recursion(i - 1) + recursion(i - 2);
		return fibterm;
	} // end recursion

	public static ArrayList<Fib> buildRecursiveList(int n) {
		// Creating ArrayList of Fibs(long num, long time)
		ArrayList<Fib> fibs = new ArrayList<>();

		// Grabbing the start time to later find the difference
		long startTime = System.nanoTime();
		System.out.println("Recursion start time: " + startTime + "ns");

		// Populating the list
		int index = 0;
		for (int i = 0; i < n; i++) {
			Fib current = new Fib(recursion(index), System.nanoTime() - startTime);
			fibs.add(current);
			index++;
		}

		// Finding total time to complete
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Recursion end time: " + endTime + "ns");
		System.out.println("Recursion took about " + totalTime + "ns");

		return fibs;
	} // end buildRecursiveList()

	public static ArrayList<Fib> buildIterativeList(int n) {
		// Creating ArrayList of Fibs(long num, long time)
		ArrayList<Fib> fibs = new ArrayList<>();

		// Grabbing the start time to later find the difference
		long startTime = System.nanoTime();
		System.out.println("\nIteration start time: " + startTime + "ns");

		// Populating the first 2 entries of 0 and 1 into the list
		Fib a = new Fib(0, System.nanoTime() - startTime);
		Fib b = new Fib(1, System.nanoTime() - startTime);
		fibs.add(a);
		fibs.add(b);

		// Populating the rest of the list
		int i = 2;
		while (i < n) {
			Fib current = new Fib(fibs.get(i - 1).getNum() + fibs.get(i - 2).getNum(), System.nanoTime() - startTime);
			fibs.add(current);
			i++;
		}

		// Finding total time to complete
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Iteration end time: " + endTime + "ns");
		System.out.println("Iteration took about " + totalTime + "ns\n");
		return fibs;
	} // end buildIterativeList()

	public static void printLists(ArrayList<Fib> iter, ArrayList<Fib> recur, int n) {
		// Printing out both sequences to compare times
		System.out.println("Number of entries in each sequence = " + n + "\n");

		System.out.println("RECURSIVE:\n");
		for (Fib f : recur)
			System.out.println(f);
		System.out.println("\n\nITERATIVE:\n");
		for (Fib f : iter)
			System.out.println(f);
	} // end printLists

} // end Methods
