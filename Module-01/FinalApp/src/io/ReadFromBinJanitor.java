package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import school.Main;
import school.Janitor;

public class ReadFromBinJanitor implements Runnable{
	private ArrayList<Janitor> people = new ArrayList<Janitor>();

	public ReadFromBinJanitor(ArrayList<Janitor> people) {
		this.people = people;
	}

	@Override
	public void run() {
       
	   Janitor[] list;
       System.out.println("[ReadFromBin] Loading file.");

        try (FileInputStream FIS = new FileInputStream("janitors.dat")) {
            try (ObjectInputStream OIS = new ObjectInputStream(FIS)) {
                list = (Janitor[]) OIS.readObject();
                System.out.println("[ReadFromBin] Array read in has " + list.length + " element(s).");
                System.out.println("[ReadFromBin] Information has been loaded.");
                people.addAll(Arrays.asList(list));
                System.out.println("[ReadFromBin] List has copied " + list.length + "element(s) from the array.");
            }
            catch (ClassNotFoundException x) {
                System.out.println("[ReadFromBin] File could not be loaded.");
            }
        }
        catch (IOException e) {
            System.out.println("[ReadFromBin] File not found.");
        }
        
        
        System.out.println("[ReadFromBin] " + people.size() + " element(s) sent to main.");
	}

	public ArrayList<Janitor> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Janitor> people) {
		this.people = people;
	}
	
	
	
	
}
