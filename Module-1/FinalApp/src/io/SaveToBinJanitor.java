package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import school.Janitor;
import school.Student;

public class SaveToBinJanitor implements Runnable {

	private ArrayList<Janitor> people = new ArrayList<Janitor>();

	public SaveToBinJanitor(ArrayList<Janitor> people) {
		this.people = people;
	}

	@Override
	public void run() {
		Janitor[] elements = new Janitor[people.size()];
		int i = 0;
		for (Janitor t : people) {
			elements[i] = t;
			i++;
		}
		System.out.println("[SaveToBin] Added " + i + " element(s) to the array.");

		// Saving to Binary
		
		try {
			FileOutputStream fos = new FileOutputStream("janitors.dat");
			System.out.println("[SaveToBin] Created FileOutputStream.");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			System.out.println("[SaveToBin] Created ObjectOutputStream.");
			oos.writeObject(elements);
			System.out.println("[SaveToBin] Objects successfully written.");
			oos.close();
			System.out.println("[SaveToBin] Information has been saved.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[SaveToBin] File cound not be saved.");
		}

		// Saving to txt
		String fileName = "janitors.txt";
		try {
			PrintWriter outputStream = new PrintWriter(fileName);
			int l = 0;
			for (Janitor j : people) {
				outputStream.print(people.get(l) + "\n");
				l++;
			}
			outputStream.flush();
			outputStream.close();
			System.out.println("[SaveToBin] All elements printed to txt file.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[SaveToBin] Txt file not found.");
		}
	}

}
