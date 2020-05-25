import java.io.File;
import java.util.*;

public class ReadFile {
	public static Scanner x;

	public static String openFile() {
		try {
			Scanner x = new Scanner(new File("../Poem.txt"));
		} catch (Exception e) {
			System.out.println("FILE NOT FOUND!");
		}
		String result = " ";
		int i = 0;
		while(x.hasNext()) {
			result += x.next() + " ";
		}
		
		return result;

	} // end openFile()
	


}// end ReadFile
