package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import school.Student;
import school.Teacher;

public class SaveToBinStudent implements Runnable {

	private ArrayList<Student> people = new ArrayList<Student>();

	public SaveToBinStudent(ArrayList<Student> people) {
		this.people = people;
	}

	@Override
	public void run() {
		Student[] elements = new Student[people.size()];
		int i = 0;
		for (Student t : people) {
			elements[i] = t;
			i++;
		}
		System.out.println("[SaveToBin] Added " + i + " element(s) to the array.");

		// Saving to Binary

		try {
			FileOutputStream fos = new FileOutputStream("students.dat");
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
		String fileName = "students.txt";
		try {
			PrintWriter outputStream = new PrintWriter(fileName);
			int j = 0;
			for (Student s : people) {
				outputStream.print(people.get(j) + "\n");
				j++;
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
