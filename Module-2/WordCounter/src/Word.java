
public class Word implements Comparable<Word> {

	// Fields 
	String text;
	int count;

	// Constructors 
	public Word(String text, int count) {
		setText(text);
		this.count = count;
	}

	// Getters and Setters //////////////////////////////////////////
	public String getText() {
		return text;
	}

	//Sets the first letter of the word to upper-case
	public void setText(String text) {
		char fletter = Character.toUpperCase(text.charAt(0));
		String result = fletter + text.substring(1);
		this.text = result;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// Methods //////////////////////////////////////////////////////

	public String toString() {
		String result = text;

		int diff = 12 - text.length();

		for (int i = 0; i < diff; i++)
			result += " ";

		result += "|   Count: " + count;

		return result;
	}// end toString()


	public int compareTo(Word w) {
	//Used to compare the count field of two words
		return Integer.compare(this.getCount(), w.getCount());
	} // end compareTo()

}// end Word
