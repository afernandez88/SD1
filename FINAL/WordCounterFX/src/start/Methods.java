package start;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class containing general methods used for the application.
 *
 * @author Andre Fernandez
 */

public class Methods {

	/**
	 * Reads in a .txt file, and coverts it into a string.
	 *
	 * @param file
	 * @return String
	 * @throws FileNotFoundException
	 */
	public static String getTextFromFile(File file) throws FileNotFoundException {
	//
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


	/**
	 * Takes the string generated from the .txt file and returns a sorted
	 * ArrayList of all words with their counts.
	 * This data os stored in Word(text,count) objects.
	 *
	 * @param p
	 * @return ArrayList<Word>
	 */
	public static void getTopWordList(String p) throws Exception {

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

		for(Word w: words)
			Database.postWord(Main.conn, w);

		System.out.println("[Methods.getTopWordList()] List of Words successfully " +
				"transferred to Database.");

	} // end getWordList()


	/**
	 * This method is used to get rid of all special characters in a string
	 * so that it can be sent over to the database without messing up
	 * the query.
	 * @param p
	 * @return
	 */
	public static String prettyString(String p){
		String result = "";

		String[] temp = p.split("\\s+");

		// Parsing the sentence
		for (int i = 0; i < temp.length; i++)
			temp[i] = temp[i].replaceAll("[^\\w]", "");

		for (String s : temp)
			result += s + " ";

		System.out.println("[Methods.prettyString] Cleaned up your string!");
		return result;
	} //end prettyString()

} // end Methods
