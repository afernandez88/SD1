import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		//Input - Converting poem to a string
		String poem = Methods.getTextFromFile();
		
		//Process - Parsing the poem, and counting the words
		ArrayList<Word> sortedList = Methods.getTopWordList(poem);

		//Output - Printing the top 20 words, and their count
		Methods.printList(sortedList);

	} // end main()

} // end Main
