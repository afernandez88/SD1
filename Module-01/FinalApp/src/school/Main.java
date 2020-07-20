 package school;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import io.ReadFromBinJanitor;
import io.ReadFromBinStudent;
import io.ReadFromBinTeacher;
import io.SaveToBinJanitor;
import io.SaveToBinStudent;
import io.SaveToBinTeacher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;

public class Main extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;

	private static ArrayList<Student> students = new ArrayList<Student>();
	private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private static ArrayList<Janitor> janitors = new ArrayList<Janitor>();

	private static HashMap<Integer, Teacher> teacherMap = new HashMap<Integer, Teacher>(); // Random order
	private static LinkedHashMap<Integer, Student> studentLinkedMap = new LinkedHashMap<Integer, Student>(); // entry
																												// order
	private static TreeMap<Integer, Janitor> janitorTreeMap = new TreeMap<Integer, Janitor>(); // Sorted by key

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Advanced Java Final");
		showMainView();
		showMainItems();
	}

	// Shows the main view of the border pane
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// Shows the application home page
	public static void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainItems.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
		primaryStage.setTitle("Advanced Java Final");
	}

	// Pulls up the teacher records
	public static void showTeacherScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("teachers/TeacherRecords.fxml"));
		BorderPane teacherRecords = loader.load();
		mainLayout.setCenter(teacherRecords);
		primaryStage.setTitle("Teacher Records");
	}

	// Pulls up the student records
	public static void showStudentScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("students/StudentRecords.fxml"));
		BorderPane studentRecords = loader.load();
		mainLayout.setCenter(studentRecords);
		primaryStage.setTitle("Student Records");
	}

	// Pulls up the janitor records
	public static void showJanitorScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("janitors/JanitorRecords.fxml"));
		BorderPane janitorRecords = loader.load();
		mainLayout.setCenter(janitorRecords);
		primaryStage.setTitle("Janitor Records");
	}

	// Database Scene
	public static void showDatabaseScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/DatabaseView.fxml"));
		BorderPane database = loader.load();
		mainLayout.setCenter(database);
		primaryStage.setTitle("Database");
	}

	// Shows the add new teacher record pop-up
	public static void showAddTeacherStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AddNewTeacherRecord.fxml"));
		BorderPane addNewTeacherRecord = loader.load();
		Stage addDialogueStage = new Stage();
		addDialogueStage.setTitle("Add New Teacher Record");
		addDialogueStage.initModality(Modality.WINDOW_MODAL); // <-When add page is open nothing else can be clicked
		addDialogueStage.initOwner(primaryStage);
		Scene scene = new Scene(addNewTeacherRecord);
		addDialogueStage.setScene(scene);
		addDialogueStage.showAndWait();

	}

	// Shows the add new student record pop-up
	public static void showAddStudentStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AddNewStudentRecord.fxml"));
		BorderPane addNewStudentRecord = loader.load();
		Stage addDialogueStage = new Stage();
		addDialogueStage.setTitle("Add New Student Record");
		addDialogueStage.initModality(Modality.WINDOW_MODAL); // <-When add page is open nothing else can be clicked
		addDialogueStage.initOwner(primaryStage);
		Scene scene = new Scene(addNewStudentRecord);
		addDialogueStage.setScene(scene);
		addDialogueStage.show();

	}

	// Shows the add new janitor record pop-up
	public static void showAddJanitorStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AddNewJanitorRecord.fxml"));
		BorderPane addNewJanitorRecord = loader.load();
		Stage addDialogueStage = new Stage();
		addDialogueStage.setTitle("Add New Janitor Record");
		addDialogueStage.initModality(Modality.WINDOW_MODAL); // <-When add page is open nothing else can be clicked
		addDialogueStage.initOwner(primaryStage);
		Scene scene = new Scene(addNewJanitorRecord);
		addDialogueStage.setScene(scene);
		addDialogueStage.showAndWait();

	}

	public static void addTeacher(Teacher teacher) {
		teachers.add(teacher);
		System.out.println(teacher);
	}

	public static ArrayList getTeachers() {
		return teachers;
	}

	private static void teachersToMap() {
		int sizeBefore = teacherMap.size();
		int cnt = 0;
		for (Teacher t : teachers) {
			teacherMap.put(t.getTeacherId(), t);
		}
		int sizeAfter = teacherMap.size();
		int diff = sizeAfter - sizeBefore;
		System.out.println("[Main] Successfully added " + diff + " element(s) to 'teacherMap'.");
		// System.out.println(teacherMap);
	}

	public static void addStudent(Student student) {
		students.add(student);
		System.out.println(student);
	}

	private static void studentsToMap() {
		int sizeBefore = studentLinkedMap.size();
		int cnt = 0;
		for (Student s : students) {
			studentLinkedMap.put(s.getStudentId(), s);
		}
		int sizeAfter = studentLinkedMap.size();
		int diff = sizeAfter - sizeBefore;
		System.out.println("[Main] Successfully added " + diff + " element(s) to 'studentLinkedMap'.");
		// System.out.println(studentLinkedMap);
	}

	public static ArrayList getStudents() {
		return students;
	}

	public static void addJanitor(Janitor janitor) {
		janitors.add(janitor);
		System.out.println(janitor);
	}

	public static ArrayList getJanitors() {
		return janitors;
	}

	private static void janitorsToMap() {
		int sizeBefore = janitorTreeMap.size();
		int cnt = 0;
		for (Janitor j : janitors) {
			janitorTreeMap.put(j.getEmployeeId(), j);
		}
		int sizeAfter = janitorTreeMap.size();
		int diff = sizeAfter - sizeBefore;
		System.out.println("[Main] Successfully added " + diff + " element(s) to 'janitorTreeMap'.");
		System.out.println(janitorTreeMap);
	}

	private static void loadExamples() {
		State myState = new State("FL");
		Address addy = new Address(4754, "Willamette", "Circle", "Orlando", myState, 32826);
		Name name1 = new Name("Andre", 'J', "Fernandez");
		Name name2 = new Name("Dennis", 'P', "Hunchuck");

		// Date dob1 = new Date(8,5,1998);
		Person test1 = new Person(name1, null, addy, 'M', false);

		// Test Teacher
		int[] officeNum = new int[2];
		officeNum[0] = 1;
		officeNum[1] = 234;
		Teacher test2 = new Teacher(name1, "1998-08-05", addy, 'M', false, 1001, "Programming", 3, officeNum);
		Teacher test5 = new Teacher(name2, "1322-02-03", addy, 'M', false, 1002, "CS", 3, officeNum);

		// Test Student
		Student test3 = new Student(name1, null, addy, 'M', false, 3001, "Software Development", 4.0, 60);

		// Test Janitor
		Janitor test4 = new Janitor(name1, null, addy, 'M', false, 2001, 21, true, 20.01);

		teachers.add(test2);
		students.add(test3);
		janitors.add(test4);
		teachers.add(test5);

		System.out.println("[Main] Created and added test examples.");
	}

	public static void saveEverything() {
		Runnable saveTeachers = new SaveToBinTeacher(teachers);
		Thread thread1 = new Thread(saveTeachers);
		Runnable saveStudents = new SaveToBinStudent(students);
		Thread thread2 = new Thread(saveStudents);
		Runnable saveJanitors = new SaveToBinJanitor(janitors);
		Thread thread3 = new Thread(saveJanitors);
		thread1.start();
		thread2.start();
		thread3.start();
	}

	public static void openEverything() {
		Runnable readTeachers = new ReadFromBinTeacher(teachers);
		Thread thread1 = new Thread(readTeachers);
		Runnable readStudents = new ReadFromBinStudent(students);
		Thread thread2 = new Thread(readStudents);
		Runnable readJanitors = new ReadFromBinJanitor(janitors);
		Thread thread3 = new Thread(readJanitors);
		thread1.start();
		thread2.start();
		thread3.start();
	}

	public static void animation() {

		primaryStage.setTitle("ImageView Experiment 1");

		Image student = new Image("pencil.png");
		Image teacher = new Image("apple.png");
		Image janitor = new Image("mop.png");
		ImageView imageView = new ImageView(student);
		imageView.setFitHeight(100);
		imageView.setFitWidth(100);

		HBox hbox = new HBox(imageView);

		ToggleGroup tg = new ToggleGroup();

		RadioButton r1 = new RadioButton("Student");
		RadioButton r2 = new RadioButton("Teacher");
		RadioButton r3 = new RadioButton("Janitor");

		VBox Vbox = new VBox(imageView, r1, r2, r3);

		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		r3.setToggleGroup(tg);

		r1.setOnAction(e -> {
			imageView.setImage(student);
		});

		r2.setOnAction(e -> {
			imageView.setImage(teacher);
		});

		r3.setOnAction(e -> {
			imageView.setImage(janitor);
		});

		ScaleTransition scaleGrow = new ScaleTransition();

		scaleGrow.setDuration(Duration.millis(50));

		scaleGrow.setNode(imageView);

		scaleGrow.setByY(1.5);
		scaleGrow.setByX(1.5);

		ScaleTransition scaleShrink = new ScaleTransition();

		scaleShrink.setDuration(Duration.millis(50));

		scaleShrink.setNode(imageView);

		scaleShrink.setByY(-1.5);
		scaleShrink.setByX(-1.5);

		RotateTransition rotate = new RotateTransition();

		rotate.setDuration(Duration.millis(1000));

		rotate.setNode(imageView);

		rotate.setByAngle(360);

		EventHandler<MouseEvent> imageFlip = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				rotate.play();
			}
		};

		EventHandler<MouseEvent> imageGrow = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				scaleGrow.play();
			}
		};

		EventHandler<MouseEvent> imageShrink = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				scaleShrink.play();
			}
		};

		imageView.addEventFilter(MouseEvent.MOUSE_ENTERED, imageGrow);
		imageView.addEventFilter(MouseEvent.MOUSE_EXITED, imageShrink);
		imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, imageFlip);

		BorderPane scene = new BorderPane();
		scene.setCenter(Vbox);
		mainLayout.setCenter(scene);
		primaryStage.show();

	}
	
	/*public void serverConnect(ArrayList<Student> students, ArrayList<Teacher> teachers, ArrayList<Janitor> janitors) {
		Connection connection;
		ResultSet rs;
		java.sql.Statement stmt;
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Server Connected");
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafinal","root","student");
           
          
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("for name Didnt Connect");
            e.printStackTrace();
        }

	}*/

	public static void main(String[] args) {
		//loadExamples();
		teachersToMap();
		studentsToMap();
		janitorsToMap();

		launch(args);
	}
}
