package start;

/**
 * Object class used to store retrieved file data from the database.
 * @author Andre Fernandez
 */
public class TextFile {
    private String name;
    private String content;

    /**
     * Constructor for a TextFile object.
     * @param name
     * @param content
     */
    public TextFile(String name, String content) {
        this.name = name;
        this.content = content;
    }

    /**
     * Returns the name of a TextFile object.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the content of a TextFile object.
     * @return String
     */
    public String getContent() {
        return content;
    }

    /**
     * Generates a String to show the data contained in a TextFile object.
     * @return String
     */
    public String toString() {
        return "TextFile{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

} // endTextFile
