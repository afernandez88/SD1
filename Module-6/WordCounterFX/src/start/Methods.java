package start;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Methods {

	public static String getTextFromFile(File file) throws FileNotFoundException {
	// Reads in a .txt file, and puts it into a string
		String result = "";

		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			result += scan.next();
			result += " ";
		} // end while
		
		// System.out.println(result);
		scan.close();
		return result;
	} // end getTextFromFile()
	

	public static ArrayList<Word> getTopWordList(String p) {
	// Takes the txt string and returns a sorted ArrayList of all words with their counts
	// all stored in Word(text,count) objects

		String[] temp = p.split("\\s+");

		// Parsing the sentence
		for (int i = 0; i < temp.length; i++)
			temp[i] = temp[i].replaceAll("[^\\w]", "").toLowerCase();

		//System.out.println("Total words found: " + temp.length + "\n");

		ArrayList<String> finalWords = new ArrayList<String>();
		ArrayList<Integer> finalCounts = new ArrayList<Integer>();
		// Checking for duplicate words
		for (String s : temp) {
			if (!finalWords.contains(s)) {
				finalWords.add(s);
				finalCounts.add(1);
			} else {
				int index = finalWords.indexOf(s);
				finalCounts.set(index, finalCounts.get(index) + 1);
			}
		} // end for

		// Combining both lists into individual Word objects

		ArrayList<Word> words = new ArrayList<Word>();

		int j = 0;
		for (String s : finalWords) {
			Word w = new Word(s, finalCounts.get(j));
			words.add(w);
			j++;
		}

		Collections.sort(words, Collections.reverseOrder());

		return words;
	} // end getWordList()

	
	public static void printList(ArrayList<Word> list) {
	// Printing out the top 20 list, followed by the entire list

		System.out.println("\nTop 20...");
		for (int i = 0; i < 20; i++) {
			int temp = i + 1;
			if (temp < 10)
				System.out.println(" " + temp + ". " + list.get(i));
			else
				System.out.println(temp + ". " + list.get(i));
		}
		System.out.println("\nEntire List...");
		for (Word w : list)
			System.out.println(w);
	} // end printList()

} // end Methods
