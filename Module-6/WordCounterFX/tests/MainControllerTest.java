import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Test;
import start.MainController;
import start.Methods;
import start.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainControllerTest {

    File poem = new File("Poem.txt");
    File lyrics = new File("lyrics.txt");

    // Creates an observable list used to test getStats
    public ObservableList<Word> getObservableList(File file) throws FileNotFoundException {
        String text = Methods.getTextFromFile(file);
        ArrayList<Word> sortedList = Methods.getTopWordList(text);
        ObservableList<Word> observableList = FXCollections.observableArrayList();
        observableList.addAll(sortedList);
        return observableList;
    } // end getObservableList()

    @Test // Testing Methods.getStats() to check for word count, and unique words
    public void getStats() throws FileNotFoundException {
        ObservableList<Word> poemList = getObservableList(poem);
        ObservableList<Word> lyricList = getObservableList(lyrics);

        Assert.assertEquals("Word Count: 1092\n" + "\n" + "Unique Words: 440\n\n",
                MainController.getStats(poemList));
        Assert.assertEquals("Word Count: 175\n" + "\n" + "Unique Words: 70\n\n",
                MainController.getStats(lyricList));
    } // end getStats() Test


} // end MainControllerTest