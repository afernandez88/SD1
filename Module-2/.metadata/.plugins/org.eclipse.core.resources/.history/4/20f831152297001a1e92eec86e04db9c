import java.util.ArrayList;
import java.util.Collections;

public class Methods {
	
	public static ArrayList<Word> getTopWordList(String p) {
	
			
			String[] temp = p.split("\\s+");
			
			
			//Parsing the sentence
			for (int i = 0; i < temp.length; i++)
				temp[i] = temp[i].replaceAll("[^\\w]", "").toLowerCase();
			
			System.out.println("Total words found:" + temp.length + "\n");
				
			ArrayList<String> finalWords = new ArrayList<String>();
			ArrayList<Integer> finalCounts = new ArrayList<Integer>();
			//Checking for duplicate words
			for(String s : temp) {
				if(!finalWords.contains(s)) {
					finalWords.add(s);
					finalCounts.add(1);
				}
				else{
					int index = finalWords.indexOf(s);
					finalCounts.set(index, finalCounts.get(index) + 1);
				}
			}//end for
			
			//Combining both lists into individual Word objects
			
			ArrayList<Word> words = new ArrayList<Word>();
			
			int j = 0;
			for(String s: finalWords) {
				Word w = new Word(s, finalCounts.get(j));
				words.add(w);
				j++;
			}

			Collections.sort(words, Collections.reverseOrder());

			return words;
		} //end getWordList() 
	


} //end Methods
