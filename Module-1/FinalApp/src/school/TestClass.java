package school;

import java.util.Date;

public class TestClass {

	public static void main(String[] args) {
	
		//Test Person
		State myState = new State("FL");
		Address addy = new Address(4754, "Willamette", "Circle", "Orlando", myState, 32826);
		Name name1 = new Name("Andre", 'J', "Fernandez");
	//	Date dob1 = new Date(8,5,1998);
		Person test1 = new Person(name1, null, addy, 'M', false);
		
		//Test Teacher
		int[] officeNum = new int[2];
		officeNum[0] = 1;
		officeNum[1] = 234;
		Teacher test2 = new Teacher(name1, null, addy, 'M', false, 1001, "Programming", 3, officeNum);
		
		//Test Student
		Student test3 = new Student(name1, null, addy, 'M', false, 3001, "Software Development", 4.0, 60);
		
		//Test Janitor
		Janitor test4 = new Janitor(name1, null, addy, 'M', false, 2001, 21, true, 20.01);
		
		//Output
		System.out.println(test4);
	}

}
