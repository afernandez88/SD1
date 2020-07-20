package start;

/**
 * Object class for a "Word".
 *
 * These objects are used to contain the text of a parsed word,
 * along with the number of times that word was found.
 *
 * @author Andre Fernandez
 */
public class Word implements Comparable<Word> {

	String text;
	int count;

	/**
	 * Constructor for a "Word".
	 * @param text
	 * @param count
	 */
	public Word(String text, int count) {
		setText(text);
		this.count = count;
	}

	/**
	 * Gets the text of a Word object.
	 * @return String
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text of a Word object.
	 * This will also set the first letter of the text to upper-case.
	 * @param text
	 */
	public void setText(String text) {
	//
		char fletter = Character.toUpperCase(text.charAt(0));
		String result = fletter + text.substring(1);
		this.text = result;
	}

	/**
	 * Gets the count of a Word object.
	 * @return int
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Sets the count of a Word object.
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Generates a String to show the data contained in a Word object.
	 * @return String
	 */
	public String toString() {
		String result = text;

		int diff = 12 - text.length();

		for (int i = 0; i < diff; i++)
			result += " ";

		result += "|   Count: " + count;

		return result;
	}// end toString()

	/**
	 * Used to compare the count field of two words
	 * @param w
	 * @return int
	 */
	public int compareTo(Word w) {
		return Integer.compare(this.getCount(), w.getCount());
	} // end compareTo()

}// end Word
