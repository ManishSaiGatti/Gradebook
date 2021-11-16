import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

public class GUI implements ActionListener {
	private static Dimension maxSize;
	private static JFrame canvas;
	private static String currentScreen;
	private static JTextField assignmentName;
	private static JTextField newStandard;
	private static JTextField studentName;
	private static JTextField textPercentFor85;
	private static JTextField textPercentFor95;
	private static JTextField questionInput;
	private static JTextField stand3Val;
	private static JTextField rosterPeriod;
	private static JTextField studentScore;
	private static JTextField textEditAssignment;
	private static JTextField textPeriod;
	private static String assignment;
	private static List<String> standards;
	private static List<String> incompleteStandards;
	private static String currentStandard;
	private static List<String> questions = new ArrayList<String>();
	private static String currentStandardType;
	private static Iterator<String> it;
	private static Iterator<String> it2;
	private String q;
	
	private static Standard1 standard1;
	private static StandardTwo standard2;
	private static Standard3 standard3;
	private static int stand3Multiplier;
	private static List<String> students;
	private static String currentStudent;
	private static List<Assignment> assignments;
	private static Assignment currentAssignment;
	private static ArrayList<Standard1> standard1s;
	private static ArrayList<StandardTwo> standard2s;
	private static ArrayList<Standard3> standard3s;
	private static int period;
	private static List<String> standard1Names;
	private static List<String> standard2Names;
	private static List<String> standard3Names;
	private static List<String> savedStandards;
	private static Assignment savedStandardsAssignment;
	private static List<Standard1> savedStandard1s;
	private static List<StandardTwo> savedStandard2s;
	private static List<Standard3> savedStandard3s;
	private static String studScore;
	private static List<Integer> totalStudentsScore;
	private static int averageScore;
	private static double weight;
	private static boolean editAssignmentInputRight = true;
	private static boolean DisplayScoresInputRight = true;
	
	public GUI() {
		canvas = new JFrame();
		canvas.setTitle("App");
		
		homeScreen();
		
		maxSize = Toolkit.getDefaultToolkit().getScreenSize();
		maxSize.height -= 50;
	    canvas.setSize(maxSize.width, maxSize.height);
		
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.setLayout(null);
		canvas.setVisible(true);
		
		assignments = new ArrayList<Assignment>();
		standards = new ArrayList<String>();
		incompleteStandards = new ArrayList<String>();
		standard1s = new ArrayList<Standard1>();
		standard2s = new ArrayList<StandardTwo>();
		standard3s = new ArrayList<Standard3>();
		standard1Names = new ArrayList<String>();
		standard2Names = new ArrayList<String>();
		standard3Names = new ArrayList<String>();
		savedStandard1s = new ArrayList<Standard1>();
		savedStandard2s = new ArrayList<StandardTwo>();
		savedStandard3s = new ArrayList<Standard3>();
		
		TextReader reader = new TextReader();
		try {
			savedStandards = reader.loadStandards("savedstandards");
			for(int i = 0; i < savedStandards.size(); i ++) {
				String name = savedStandards.get(i);
				if(name.charAt(name.length() - 1) == '1') {
					savedStandard1s.add(reader.loadStandard1("saved" + name.substring(0, name.length() - 2) + "1", null));
				} else if(name.charAt(name.length() - 1) == '2') {
					savedStandard2s.add(reader.loadStandard2("saved" + name.substring(0, name.length() - 2) + "2", null));
				} else if(name.charAt(name.length() - 1) == '3') {
					savedStandard3s.add(reader.loadStandard3("saved" + name.substring(0, name.length() - 2) + "3", null));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			savedStandards = new ArrayList<String>();
			savedStandard1s = new ArrayList<Standard1>();
			savedStandard2s = new ArrayList<StandardTwo>();
			savedStandard3s = new ArrayList<Standard3>();
		}
	}
	
	private void homeScreen() {
		JButton newAssignment = addButton(5, 10, 150, 40, "New Assignment");
		newAssignment.addActionListener(this);
		
		JButton editAssignment = addButton(168, 10, 150, 40, "Edit Assignment");
		editAssignment.addActionListener(this);
		
		JButton displayScores = addButton(331, 10, 150, 40, "Display Scores");
		displayScores.addActionListener(this);
		
		canvas.add(newAssignment);
		canvas.add(editAssignment);
		canvas.add(displayScores);
		
		currentScreen = "home";
	}
	
	private void newAssignmentScreen() {
		JLabel title = new JLabel();
		title.setBounds(175, 10, 300, 40);
		title.setText("New Assignment");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		canvas.add(title);
		
		JLabel assignmentNameLabel = new JLabel();
		assignmentNameLabel.setBounds(2, 210, 250, 40);
		assignmentNameLabel.setText("Enter Assignment Name: ");
		assignmentNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(assignmentNameLabel);
		
		assignmentName = new JTextField();
		assignmentName.setBounds(220, 210, 190, 40);
		assignmentName.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(assignmentName);
		
		JButton enterKey = new JButton("Enter");
		enterKey.setBounds(415, 210, 65, 40);
		canvas.add(enterKey);
		enterKey.addActionListener(this);
		
		currentScreen = "newAssignment";
	}
	
	private void editAssignment() {
		JLabel title = new JLabel();
		title.setText("What assignment do you want to edit?");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setBounds(0, maxSize.height / 8, 354, 40);
		canvas.add(title);
		
		textEditAssignment = new JTextField();
		textEditAssignment.setBounds(360, maxSize.height / 8, 300, 40);
		textEditAssignment.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(textEditAssignment);
		
		JLabel title2 = new JLabel();
		title2.setText("What period is this assignment for?");
		title2.setFont(new Font("Arial", Font.PLAIN, 20));
		title2.setBounds(0, maxSize.height / 5, 354, 40);
		canvas.add(title2);
		
		textPeriod = new JTextField();
		textPeriod.setBounds(360, maxSize.height / 5, 300, 40);
		textPeriod.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(textPeriod);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(460, maxSize.height / 4 + 20, 100, 40);
		enter.addActionListener(this);
		canvas.add(enter);
		
		if(!editAssignmentInputRight) {
			JLabel wrongInput = new JLabel();
			wrongInput.setFont(new Font("Arial", Font.PLAIN, 20));
			wrongInput.setText("The inputted assignment or period could not be found");
			wrongInput.setBounds(maxSize.width / 2 - 233, maxSize.height / 10 - 20, 466, 40);
			canvas.add(wrongInput);
			editAssignmentInputRight = true;
		}
		
		currentScreen = "editAssignment";
	}
	
	private void displayScores() {
		JLabel title = new JLabel();
		title.setText("What assignment do you want to get data for?");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setBounds(0, maxSize.height / 8, 408, 40);
		canvas.add(title);
		
		textEditAssignment = new JTextField();
		textEditAssignment.setBounds(413, maxSize.height / 8, 300, 40);
		textEditAssignment.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(textEditAssignment);
		
		JLabel title2 = new JLabel();
		title2.setText("What period is this assignment for?");
		title2.setFont(new Font("Arial", Font.PLAIN, 20));
		title2.setBounds(0, maxSize.height / 5, 408, 40);
		canvas.add(title2);
		
		textPeriod = new JTextField();
		textPeriod.setBounds(413, maxSize.height / 5, 300, 40);
		textPeriod.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(textPeriod);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(508, maxSize.height / 4 + 20, 100, 40);
		enter.addActionListener(this);
		canvas.add(enter);
		
		if(!DisplayScoresInputRight) {
			JLabel wrongInput = new JLabel();
			wrongInput.setFont(new Font("Arial", Font.PLAIN, 20));
			wrongInput.setText("The inputted assignment or period could not be found");
			wrongInput.setBounds(maxSize.width / 2 - 233, maxSize.height / 10 - 20, 466, 40);
			canvas.add(wrongInput);
			DisplayScoresInputRight = true;
		}
		
		currentScreen = "displayScores";
	}
	
	private void enterStandardScreen() {
		JLabel title = new JLabel();
		title.setBounds(175, 10, 300, 40);
		title.setText("Assignment: " + assignment);
		title.setFont(new Font("Arial", Font.BOLD, 30));
		canvas.add(title);
		
		JLabel assignmentNameLabel = new JLabel();
		assignmentNameLabel.setBounds(2, 210, 250, 40);
		assignmentNameLabel.setText("Enter Standard Name: ");
		assignmentNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(assignmentNameLabel);
		
		newStandard = new JTextField();
		newStandard.setBounds(220, 210, 190, 40);
		newStandard.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(newStandard);
		
		JButton enterKey = new JButton("Enter");
		enterKey.setBounds(415, 210, 65, 40);
		canvas.add(enterKey);
		enterKey.addActionListener(this);
		
		JButton enterScores = new JButton("Add Scores");
		enterScores.setBounds(210, 310, 250, 40);
		canvas.add(enterScores);
		enterScores.addActionListener(this);
		
		JButton chooseSavedStandard = new JButton("Choose from saved standard");
		chooseSavedStandard.setBounds(210, 360, 250, 40);
		canvas.add(chooseSavedStandard);
		chooseSavedStandard.addActionListener(this);
		
		currentScreen = "newStandard";
	}
	
	private void chooseStandard() {
		int numStandards = incompleteStandards.size();
		List<JButton> standardButtons = new ArrayList<JButton>();
		int counter = 0;
		
		for(int i = 0; i < 2; i ++) {
			int x = 200 * i + 10;
			for(int j = 0; (j < (numStandards / 2 + numStandards % 2)) && (counter < incompleteStandards.size());  j++) {
				int y = j * 40 + 5;
				String name = "Standard: " + incompleteStandards.get(counter);
				counter ++;
				JButton button = addButton(x, y, 200, 40, name);
				button.addActionListener(this);
				standardButtons.add(button);
				canvas.add(button);
			}
		}
		
		JButton home = new JButton("Return Home");
		home.setBounds(500, 5, 110, 40);
		canvas.add(home);
		home.addActionListener(this);
	}
	
	private void addScores() {
		JLabel title = new JLabel();
		title.setBounds(0, 10, 400, 40);
		title.setText("Please Choose the Type of Standard");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(title);
		
		JButton numTrueFalse = new JButton("True False based on percentage");
		numTrueFalse.setBounds(2, 70, 250, 40);
		numTrueFalse.addActionListener(this);
		canvas.add(numTrueFalse);
		
		JButton oneTrueFalse = new JButton("One True False determines score");
		oneTrueFalse.setBounds(2, 170, 250, 40);
		oneTrueFalse.addActionListener(this);
		canvas.add(oneTrueFalse);
		
		JButton intScores = new JButton("Integer values represent score");
		intScores.setBounds(2, 270, 250, 40);
		intScores.addActionListener(this);
		canvas.add(intScores);
		
		JButton save = new JButton("Save");
		save.setBounds(maxSize.width - 117, maxSize.height - 80, 100, 40);
		save.setFont(new Font("Arial", Font.PLAIN, 20));
		save.addActionListener(this);
		canvas.add(save);
	}
	
	private void chooseStudent() {
		JLabel title = new JLabel();
		title.setBounds(119, maxSize.height / 8, 142, 40);
		title.setText("Choose Student");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(title);
		
		JLabel assignmentNameLabel = new JLabel();
		assignmentNameLabel.setBounds(0, maxSize.height / 5, 190, 40);
		assignmentNameLabel.setText("Enter Student Name: ");
		assignmentNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(assignmentNameLabel);
		
		studentName = new JTextField();
		studentName.setBounds(195, maxSize.height / 5, 190, 40);
		studentName.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(studentName);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(110, maxSize.height / 4 + 20, 150, 40);
		canvas.add(enter);
		enter.addActionListener(this);
		
		currentScreen = "chooseStudent";
	}
	
	private void getStudents() {
		JLabel title = new JLabel();
		title.setText("Please enter the period number for the roster:");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setBounds(0, maxSize.height / 8, 405, 40);
		canvas.add(title);
		
		rosterPeriod = new JTextField();
		rosterPeriod.setBounds(410, maxSize.height / 8, 100, 40);
		rosterPeriod.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(rosterPeriod);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(515, maxSize.height / 8, 100, 40);
		enter.addActionListener(this);
		canvas.add(enter);
		
		JButton save = new JButton("Save");
		save.setBounds(maxSize.width - 117, maxSize.height - 80, 100, 40);
		save.setFont(new Font("Arial", Font.PLAIN, 20));
		save.addActionListener(this);
		canvas.add(save);
		
		currentScreen = "loadRoster";
	}
	
	private void percentTrueFalse() {
		JLabel percentFor85 = new JLabel();
		percentFor85.setBounds(2, 110, 280, 40);
		percentFor85.setText("How many correct for an 85: ");
		percentFor85.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(percentFor85);
		
		textPercentFor85 = new JTextField();
		textPercentFor85.setBounds(260, 110, 190, 40);
		textPercentFor85.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(textPercentFor85);
		
		
		JLabel percentFor95 = new JLabel();
		percentFor95.setBounds(2, 210, 280, 40);
		percentFor95.setText("How many correct for a 95: ");
		percentFor95.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(percentFor95);
		
		textPercentFor95 = new JTextField();
		textPercentFor95.setBounds(260, 210, 190, 40);
		textPercentFor95.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(textPercentFor95);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(2, 410, 250, 40);
		enter.addActionListener(this);
		canvas.add(enter);
		
		JButton save = new JButton("Save");
		save.setBounds(maxSize.width - 117, maxSize.height - 80, 100, 40);
		save.setFont(new Font("Arial", Font.PLAIN, 20));
		save.addActionListener(this);
		canvas.add(save);
		
		currentScreen = "Percent True False";
	}
	
	private void oneTrueFalse(String q) {
		this.q = q;
		
		JLabel question = new JLabel();
		question.setFont(new Font("Arial", Font.PLAIN, 20));
		question.setBounds(0, 100, maxSize.width, 40);
		question.setText(q);
		canvas.add(question);
		
		JButton score75 = new JButton("75");
		score75.setBounds(2, 200, 250, 40);
		score75.addActionListener(this);
		canvas.add(score75);
		
		JButton score85 = new JButton("85");
		score85.setBounds(300, 200, 250, 40);
		score85.addActionListener(this);
		canvas.add(score85);
		
		JButton score95 = new JButton("95");
		score95.setBounds(600, 200, 250, 40);
		score95.addActionListener(this);
		canvas.add(score95);
		
		JButton save = new JButton("Save");
		save.setBounds(maxSize.width - 117, maxSize.height - 80, 100, 40);
		save.setFont(new Font("Arial", Font.PLAIN, 20));
		save.addActionListener(this);
		canvas.add(save);
		
		currentScreen = "oneTrueFalse";
	}
	
	private void intValue() {
		JLabel title = new JLabel();
		title.setText("How many points is the standard out of?");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setBounds(0, maxSize.height / 8, 354, 40);
		canvas.add(title);
		
		stand3Val = new JTextField();
		stand3Val.setBounds(360, maxSize.height / 8, 100, 40);
		stand3Val.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(stand3Val);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(465, maxSize.height / 8, 100, 40);
		enter.addActionListener(this);
		canvas.add(enter);
		
		JButton save = new JButton("Save");
		save.setBounds(maxSize.width - 117, maxSize.height - 80, 100, 40);
		save.setFont(new Font("Arial", Font.PLAIN, 20));
		save.addActionListener(this);
		canvas.add(save);
		
		currentScreen = "intValue";
	}
	
	private void enterStudentScore1And2(String student, String q) {
		JLabel title = new JLabel();
		title.setText("Please answer the following question for " + student + ":");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setBounds(0, maxSize.height / 8, 700, 40);
		canvas.add(title);
		
		JLabel question = new JLabel();
		question.setFont(new Font("Arial", Font.PLAIN, 20));
		question.setBounds(0, maxSize.height / 6, maxSize.width, 40);
		question.setText(q);
		canvas.add(question);
		
		JButton trueButton = new JButton();
		trueButton.setBounds(0, maxSize.height / 4, 100, 40);
		trueButton.setText("true");
		trueButton.setFont(new Font("Arial", Font.PLAIN, 20));
		trueButton.addActionListener(this);
		canvas.add(trueButton);
		
		JButton falseButton = new JButton();
		falseButton.setBounds(200, maxSize.height / 4, 100, 40);
		falseButton.setText("false");
		falseButton.setFont(new Font("Arial", Font.PLAIN, 20));
		falseButton.addActionListener(this);
		canvas.add(falseButton);
		
		JButton save = new JButton("Save");
		save.setBounds(maxSize.width - 117, maxSize.height - 80, 100, 40);
		save.setFont(new Font("Arial", Font.PLAIN, 20));
		save.addActionListener(this);
		canvas.add(save);
	}
	
	private void enterStudentScore3(String student) {
		JLabel title = new JLabel();
		title.setText("Please answer the following question for " + student + ":");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setBounds(0, maxSize.height / 8, 700, 40);
		canvas.add(title);
		
		JLabel question = new JLabel();
		question.setFont(new Font("Arial", Font.PLAIN, 20));
		question.setBounds(0, 125, 600, 40);
		question.setText("How many points did this student get? (Please Enter a Number)");
		canvas.add(question);
		
		studentScore = new JTextField();
		studentScore.setBounds(5, maxSize.height / 4, 100, 40);
		studentScore.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(studentScore);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(110, maxSize.height / 4, 100, 40);
		enter.addActionListener(this);
		canvas.add(enter);
		
		JButton save = new JButton("Save");
		save.setBounds(maxSize.width - 117, maxSize.height - 80, 100, 40);
		save.setFont(new Font("Arial", Font.PLAIN, 20));
		save.addActionListener(this);
		canvas.add(save);
		
		currentScreen = "enterStudentScore3";
	}
	
	private void enterQuestions() {
		JLabel questions = new JLabel();
		questions.setFont(new Font("Arial", Font.PLAIN, 20));
		questions.setBounds(2, 210, 326, 40);
		questions.setText("Enter a question that will be graded: ");
		canvas.add(questions);
		
		questionInput = new JTextField();
		questionInput = new JTextField();
		questionInput.setBounds(331, 210, 250, 40);
		questionInput.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(questionInput);
		
		JButton enterKey = new JButton("Enter");
		enterKey.setBounds(586, 210, 66, 40);
		canvas.add(enterKey);
		enterKey.addActionListener(this);
		
		JButton questionsDone = new JButton("I am done entering Questions");
		questionsDone.setBounds(389, 260, 200, 40);
		canvas.add(questionsDone);
		questionsDone.addActionListener(this);
		
		JButton save = new JButton("Save");
		save.setBounds(maxSize.width - 117, maxSize.height - 80, 100, 40);
		save.setFont(new Font("Arial", Font.PLAIN, 20));
		save.addActionListener(this);
		canvas.add(save);
		
		currentScreen = "enterQuestions";
	}
	
	private void setUpIts() {
		if(currentStandardType.equals("intValues")) {
			it = students.iterator();
			currentStudent = it.next();
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			enterStudentScore3(currentStudent);
		} else {
			if(currentStandardType.equals("trueFalsePerc")) {
				it2 = standard1.getQuestions().iterator();
			} else if(currentStandardType.equals("oneTrueFalse")) {
				it2 = standard2.getQuestions().iterator();
			}
			it = students.iterator();
			if(it.hasNext() && it2.hasNext()) {
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				currentStudent = it.next();
				enterStudentScore1And2(currentStudent, it2.next());
			}
		}
	}
	
	private void save() {
		TextWriter writer = new TextWriter();
		writer.saveStandards(assignment, standards);
		try {
			Iterator<Standard1> it1 = standard1s.iterator();
			Iterator<StandardTwo> it2 = standard2s.iterator();
			Iterator<Standard3> it3 = standard3s.iterator();
			for(int i = 0; i < standards.size(); i ++) {
				String name = standards.get(i);
				if(name.charAt(name.length() - 1) == '1') {
					writer.saveAll1(name.substring(0, name.length() - 1), period, it1.next());
				} else if(name.charAt(name.length() - 1) == '2') {
					writer.saveAll2(name.substring(0, name.length() - 1), period, it2.next());
				} else if(name.charAt(name.length() - 1) == '3') {
					writer.saveAll3(name.substring(0, name.length() - 1), period, it3.next());
				}
			}
		} catch(Exception a) {
			
		}
		
		
		ArrayList<Standard1> stand1s = new ArrayList<Standard1>();
		ArrayList<StandardTwo> stand2s = new ArrayList<StandardTwo>();
		ArrayList<Standard3> stand3s = new ArrayList<Standard3>();
		for(int i = 0; i < savedStandard1s.size(); i ++) {
			stand1s.add(savedStandard1s.get(i));
		}
		for(int i = 0; i < savedStandard2s.size(); i ++) {
			stand2s.add(savedStandard2s.get(i));
		}
		for(int i = 0; i < savedStandard3s.size(); i ++) {
			stand3s.add(savedStandard3s.get(i));
		}
		savedStandardsAssignment = new Assignment("SavedStandards", stand1s, stand2s, stand3s);
		
		writer.saveStandards(savedStandardsAssignment.getAssignmentName(), savedStandards);
		
		Iterator<Standard1> savedIt1 = stand1s.iterator();
		Iterator<StandardTwo> savedIt2 = stand2s.iterator();
		Iterator<Standard3> savedIt3 = stand3s.iterator();
		for(int i = 0; i < savedStandards.size(); i ++) {
			String name = savedStandards.get(i);
			if(name.charAt(name.length() - 1) == '1') {
				writer.saveAll1("saved" + name.substring(0, name.length() - 2) + "1", period, savedIt1.next());
			} else if(name.charAt(name.length() - 1) == '2') {
				writer.saveAll2("saved" + name.substring(0, name.length() - 2) + "2", period, savedIt2.next());
			} else if(name.charAt(name.length() - 1) == '3') {
				writer.saveAll3("saved" + name.substring(0, name.length() - 2) + "3", period, savedIt3.next());
			}
		}
	}
	
	private void saveStandard() {
		JLabel title = new JLabel();
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setText("Do you want to save this standard to use in other assignments?");
		title.setBounds(0, maxSize.height / 8, 700, 40);
		canvas.add(title);
		
		JButton yesButton = new JButton();
		yesButton.setBounds(0, maxSize.height / 6 + 30, 100, 40);
		yesButton.setText("Yes");
		yesButton.setFont(new Font("Arial", Font.PLAIN, 20));
		yesButton.addActionListener(this);
		canvas.add(yesButton);
		
		JButton noButton = new JButton();
		noButton.setBounds(200, maxSize.height / 6 + 30, 100, 40);
		noButton.setText("No");
		noButton.setFont(new Font("Arial", Font.PLAIN, 20));
		noButton.addActionListener(this);
		canvas.add(noButton);
	}
	
	private void chooseSavedStandard() {
		int numStandards = savedStandards.size();
		List<JButton> standardButtons = new ArrayList<JButton>();
		int counter = 0;
		
		for(int i = 0; i < 2; i ++) {
			int x = 200 * i + 10;
			for(int j = 0; (j < (numStandards / 2 + numStandards % 2)) && (counter < savedStandards.size());  j++) {
				int y = j * 40 + 5;
				String standName = savedStandards.get(counter);
				String name = "Standard: " + standName.substring(0, standName.length() - 2);
				counter ++;
				JButton button = addButton(x, y, 200, 40, name);
				button.addActionListener(this);
				standardButtons.add(button);
				canvas.add(button);
			}
		}
	}
	
	private void chooseData() {
		JLabel title = new JLabel();
		title.setBounds(400, maxSize.height / 8 - 10, 354, 40);
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setText("What do you want to display?");
		canvas.add(title);
		
		JButton getScore = new JButton("Get Score for a Student");
		getScore.setBounds(0, maxSize.height / 6, 250, 40);
		canvas.add(getScore);
		getScore.addActionListener(this);
		
		JButton getAllScores = new JButton("Get Scores for all Students");
		getAllScores.setBounds(255, maxSize.height / 6, 250, 40);
		canvas.add(getAllScores);
		getAllScores.addActionListener(this);
		
		JButton getAvgScores = new JButton("Get Average Score for all Students");
		getAvgScores.setBounds(510, maxSize.height / 6, 250, 40);
		canvas.add(getAvgScores);
		getAvgScores.addActionListener(this);
		
		JButton getRoster = new JButton("Get all Student Names");
		getRoster.setBounds(765, maxSize.height / 6, 250, 40);
		canvas.add(getRoster);
		getRoster.addActionListener(this);
	}
	
	private void getStudentScore() {
		JLabel score = new JLabel();
		score.setBounds(0, maxSize.height / 4, 700, 40);
		score.setFont(new Font("Arial", Font.PLAIN, 30));
		score.setText(studScore);
		canvas.add(score);
		
		JButton home = new JButton("Return Home");
		home.setBounds(0, maxSize.height / 3 + 20, 110, 40);
		canvas.add(home);
		home.addActionListener(this);
	}
	
	private void displayTotalStudentsScores() {
		int counter = 0;
		Iterator<String> it = new TextReader().loadRoster(period).iterator();
		for(int i = 0; i < 2; i ++) {
			int x = 200 * i + 10;
			for(int j = 0; j < totalStudentsScore.size() / 2; j ++) {
				int y = j * 40 + 5;
				JLabel label = new JLabel();
				label.setBounds(x, y, 300, 40);
				label.setFont(new Font("Arial", Font.PLAIN, 20));
				label.setText(it.next() + ": " + totalStudentsScore.get(counter));
				canvas.add(label);
				counter ++;
			}
		}
	}
	
	private void getAverageScore() {
		JLabel avg = new JLabel();
		avg.setBounds(0, maxSize.height / 8, 700, 40);
		avg.setFont(new Font("Arial", Font.PLAIN, 20));
		avg.setText("The Average Score for the " + currentAssignment.getAssignmentName() + " assignment was: " + averageScore);
		canvas.add(avg);
	}
	
	private void getWeight() {
		JLabel title = new JLabel();
		title.setText("What is the weight of this Standard?");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setBounds(0, maxSize.height / 8, 354, 40);
		canvas.add(title);
		
		textEditAssignment = new JTextField();
		textEditAssignment.setBounds(320, maxSize.height / 8, 100, 40);
		textEditAssignment.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(textEditAssignment);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(425, maxSize.height / 8, 100, 40);
		enter.addActionListener(this);
		canvas.add(enter);
		
		currentScreen = "getWeight";
	}
	
	private void getStudentNames() {
		int counter = 0;
		for(int i = 0; i < 2; i ++) {
			int x = 200 * i + 10;
			for(int j = 0; j < students.size() / 2; j ++) {
				int y = j * 40 + 5;
				JLabel label = new JLabel();
				label.setBounds(x, y, 300, 40);
				label.setFont(new Font("Arial", Font.PLAIN, 20));
				label.setText(students.get(counter));
				canvas.add(label);
				counter ++;
			}
		}
	}
	
	private static JButton addButton(int x, int y, int width, int height, String name) {
		JButton b = new JButton(name);
		b.setBounds(x, y, width, height);
		return b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("New Assignment")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			newAssignmentScreen();
		} else if(e.getActionCommand().equals("Edit Assignment")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			editAssignment();
		} else if(e.getActionCommand().equals("Display Scores")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			displayScores();
		} else if(e.getActionCommand().equals("Enter")) {
			if(currentScreen.equals("newAssignment")) {
				assignment = assignmentName.getText();
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				
				enterStandardScreen();
			} else if(currentScreen.equals("newStandard")) {
				standards.add(newStandard.getText() + "n");
				incompleteStandards.add(newStandard.getText());
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				enterStandardScreen();
			} else if(currentScreen.equals("Percent True False")) {
				String num85 = textPercentFor85.getText();
				String num95 = textPercentFor95.getText();
				
				standard1 = new Standard1(Integer.parseInt(num85), Integer.parseInt(num95), weight);
				
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				enterQuestions();
			} else if(currentScreen.equals("enterQuestions")) {
				String question = questionInput.getText();
				if(currentStandardType.equals("trueFalsePerc")) {
					standard1.addIndividualQuestion(question);
				} else if(currentStandardType.equals("oneTrueFalse")) {
				} else if(currentStandardType.equals("intValues")) {
				}
				questions.add(question);
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				enterQuestions();
			} else if(currentScreen.equals("oneTrueFalse")) {
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				if(it.hasNext()) {
					oneTrueFalse(it.next());
				} else {
					oneTrueFalse("No more questions");
				}
			} else if(currentScreen.equals("intValue")) {
				stand3Multiplier = Integer.parseInt(stand3Val.getText()) / 5;
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				try {
					setUpIts();
				} catch(Exception a) {
					getStudents();
				}
			} else if(currentScreen.equals("loadRoster")) {
				period = Integer.parseInt(rosterPeriod.getText());
				TextReader reader = new TextReader();
				students = reader.loadRoster(period);
				
				if(currentStandardType.equals("intValues")) {
					it = students.iterator();
					currentStudent = it.next();
					canvas.getContentPane().removeAll();
					canvas.getContentPane().repaint();
					enterStudentScore3(currentStudent);
				} else {
					if(currentStandardType.equals("trueFalsePerc")) {
						it2 = standard1.getQuestions().iterator();
					} else if(currentStandardType.equals("oneTrueFalse")) {
						it2 = standard2.getQuestions().iterator();
					}
					it = students.iterator();
					if(it.hasNext() && it2.hasNext()) {
						canvas.getContentPane().removeAll();
						canvas.getContentPane().repaint();
						currentStudent = it.next();
						enterStudentScore1And2(currentStudent, it2.next());
					}
				}
			} else if(currentScreen.equals("enterStudentScore3")) {
				int rawScore = Integer.parseInt(studentScore.getText()) / stand3Multiplier;
				if(rawScore < 1) {
					rawScore = 1;
				} else if(rawScore > 5) {
					rawScore = 5;
				}
				standard3.setStudentScore(currentStudent, rawScore);
				if(it.hasNext()) {
					currentStudent = it.next();
					canvas.getContentPane().removeAll();
					canvas.getContentPane().repaint();
					enterStudentScore3(currentStudent);
				} else {
					standard3s.add(standard3);
					incompleteStandards.remove(currentStandard);
					Iterator<String> it = standard3.getRoster().iterator();
					while(it.hasNext()) {
					}
					canvas.getContentPane().removeAll();
					canvas.getContentPane().repaint();
					saveStandard();
				}
			} else if(currentScreen.equals("editAssignment")) {
				TextReader reader = new TextReader();
				try {
					period = Integer.parseInt(textPeriod.getText());
					standards = reader.loadStandards(textEditAssignment.getText());
					incompleteStandards = reader.loadStandards(textEditAssignment.getText());
					for(int i = 0; i < standards.size(); i ++) {
						String name = standards.get(i);
						incompleteStandards.remove(i);
						incompleteStandards.add(i, name.substring(0, name.length() - 1));
						if(name.charAt(name.length() - 1) == '1') {
							standard1s.add(reader.loadAllStandard1(name.substring(0, name.length() - 1), period, standard1));
							incompleteStandards.remove(standards.get(i));
						} else if(name.charAt(name.length() - 1) == '2') {
							standard2s.add(reader.loadAllStandard2(name.substring(0, name.length() - 1), period, standard2));
							incompleteStandards.remove(standards.get(i));
						} else if(name.charAt(name.length() - 1) == '3') {
							standard3s.add(reader.loadAllStandard3(name.substring(0, name.length() - 1), period, standard3));
							incompleteStandards.remove(standards.get(i));
						}
					}
					standard1s.removeAll(Collections.singleton(null));
					standard2s.removeAll(Collections.singleton(null));
					standard3s.removeAll(Collections.singleton(null));
					canvas.getContentPane().removeAll();
					canvas.getContentPane().repaint();
					if(!incompleteStandards.isEmpty()) {
						chooseStandard();
					} else {
						enterStandardScreen();
					}
				} catch(Exception a) {
					editAssignmentInputRight = false;
					canvas.getContentPane().removeAll();
					canvas.getContentPane().repaint();
					editAssignment();
				}
			} else if(currentScreen.equals("displayScores")) {
				TextReader reader = new TextReader();
				try {
					period = Integer.parseInt(textPeriod.getText());
					standards = reader.loadStandards(textEditAssignment.getText());
					for(int i = 0; i < standards.size(); i ++) {
						String name = standards.get(i);
						if(name.charAt(name.length() - 1) == '1') {
							standard1s.add(reader.loadAllStandard1(name.substring(0, name.length() - 1), period, standard1));
						} else if(name.charAt(name.length() - 1) == '2') {
							standard2s.add(reader.loadAllStandard2(name.substring(0, name.length() - 1), period, standard2));
						} else if(name.charAt(name.length() - 1) == '3') {
							standard3s.add(reader.loadAllStandard3(name.substring(0, name.length() - 1), period, standard3));
						}
					}
					standard1s.removeAll(Collections.singleton(null));
					standard2s.removeAll(Collections.singleton(null));
					standard3s.removeAll(Collections.singleton(null));
					currentAssignment = new Assignment(textEditAssignment.getText(), standard1s, standard2s, standard3s);
					canvas.getContentPane().removeAll();
					canvas.getContentPane().repaint();
					chooseData();
				} catch(Exception a) {
					canvas.getContentPane().removeAll();
					canvas.getContentPane().repaint();
					DisplayScoresInputRight = false;
					displayScores();
				}
			} else if(currentScreen.equals("chooseStudent")) {
				students = new TextReader().loadRoster(period);
				for(String student : students) {
					currentAssignment.calculateStudentScore(student);
				}
				try {
					studScore = studentName.getText() + "'s score: " + currentAssignment.getScore(studentName.getText());
					canvas.getContentPane().removeAll();
					canvas.getContentPane().repaint();
					getStudentScore();
				} catch(Exception a) {
					canvas.getContentPane().removeAll();
					canvas.getContentPane().repaint();
					a.printStackTrace();
					chooseStudent();
				}
			} else if(currentScreen.equals("getWeight")) {
				weight = Double.parseDouble(textEditAssignment.getText());
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				addScores();
			}
		} else if(e.getActionCommand().equals("Add Scores")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			chooseStandard();
		} else if(e.getActionCommand().contains("Standard: ")) {
			currentStandard = e.getActionCommand().substring(10);
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			getWeight();
		}else if(e.getActionCommand().equals("True False based on percentage")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			percentTrueFalse();
			currentStandardType = "trueFalsePerc";
			int index = standards.indexOf(currentStandard + "n");
			String s = standards.get(index);
			String newName = s.substring(0, s.length() - 1) + "1";
			standards.remove(index);
			standards.add(index, newName);
			standard1Names.add(currentStandard);
		} else if(e.getActionCommand().equals("One True False determines score")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			standard2 = new StandardTwo(weight);
			int index = standards.indexOf(currentStandard + "n");
			String s = standards.get(index);
			String newName = s.substring(0, s.length() - 1) + "2";
			standards.remove(index);
			standards.add(index, newName);
			currentStandardType = "oneTrueFalse";
			standard2Names.add(currentStandard);
			enterQuestions();
		} else if(e.getActionCommand().equals("Integer values represent score")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			int index = standards.indexOf(currentStandard + "n");
			String s = standards.get(index);
			String newName = s.substring(0, s.length() - 1) + "3";
			standards.remove(index);
			standards.add(index, newName);
			currentStandardType = "intValues";
			standard3Names.add(currentStandard);
			standard3 = new Standard3("How many points did this student get?", weight);
			questions.add("How many points did this student get?");
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			intValue();
		} else if(e.getActionCommand().equals("I am done entering Questions")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			if(currentStandardType.equals("oneTrueFalse")) {
				it = questions.iterator();
				oneTrueFalse(it.next());
			} else {
				try {
					setUpIts();
				} catch(Exception a) {
					getStudents();
				}
			}
		} else if(e.getActionCommand().equals("75")) {
			standard2.addIndividualQ(q + " 75");
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			if(it.hasNext()) {
				oneTrueFalse(it.next());
			} else {
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				try {
					setUpIts();
				} catch(Exception a) {
					getStudents();
				}
			}
		} else if(e.getActionCommand().equals("85")) {
			standard2.addIndividualQ(q + " 85");
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			if(it.hasNext()) {
				oneTrueFalse(it.next());
			} else {
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				try {
					setUpIts();
				} catch(Exception a) {
					getStudents();
				}
			}
		} else if(e.getActionCommand().equals("95")) {
			standard2.addIndividualQ(q + " 95");
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			if(it.hasNext()) {
				oneTrueFalse(it.next());
			} else {
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				try {
					setUpIts();
				} catch(Exception a) {
					getStudents();
				}
			}
		} else if(e.getActionCommand().equals("true") || e.getActionCommand().equals("false")) {
			if(currentStandardType.equals("trueFalsePerc")) {
				standard1.setIndividualAnswer(currentStudent, Boolean.parseBoolean(e.getActionCommand()));
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				if(it2.hasNext()) {
					enterStudentScore1And2(currentStudent, it2.next());
				} else {
					if(it.hasNext()) {
						currentStudent = it.next();
						it2 = standard1.getQuestions().iterator();
						enterStudentScore1And2(currentStudent, it2.next());
					} else {
						standard1s.add(standard1);
						incompleteStandards.remove(currentStandard);
						canvas.getContentPane().removeAll();
						canvas.getContentPane().repaint();
						saveStandard();
					}
				}
			} else if(currentStandardType.equals("oneTrueFalse")) {
				standard2.addIndividualA(currentStudent, Boolean.parseBoolean(e.getActionCommand()));
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				if(it2.hasNext()) {
					enterStudentScore1And2(currentStudent, it2.next());
				} else {
					if(it.hasNext()) {
						currentStudent = it.next();
						it2 = standard2.getQuestions().iterator();
						enterStudentScore1And2(currentStudent, it2.next());
					} else {
						standard2s.add(standard2);
						incompleteStandards.remove(currentStandard);
						canvas.getContentPane().removeAll();
						canvas.getContentPane().repaint();
						saveStandard();
					}
				}
			}
		} else if(e.getActionCommand().equals("Save")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			save();
			homeScreen();
		} else if(e.getActionCommand().equals("Yes")) {
			if(currentStandardType.equals("trueFalsePerc")) {
				savedStandards.add(currentStandard + " 1");
				savedStandard1s.add(standard1);
			} else if(currentStandardType.equals("oneTrueFalse")) {
				savedStandards.add(currentStandard + " 2");
				savedStandard2s.add(standard2);
			} else if(currentStandardType.equals("intValues")) {
				savedStandards.add(currentStandard + " 3");
				savedStandard3s.add(standard3);
			}
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			if(!incompleteStandards.isEmpty()) {
				questions = new ArrayList<String>();
				chooseStandard();
			} else {
				assignments.add(currentAssignment);
				save();
				homeScreen();
			}
		} else if(e.getActionCommand().equals("No")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			if(!incompleteStandards.isEmpty()) {
				questions = new ArrayList<String>();
				chooseStandard();
			} else {
				assignments.add(currentAssignment);
				save();
				homeScreen();
			}
		} else if(e.getActionCommand().equals("Choose from saved standard")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			chooseSavedStandard();
		} else if(e.getActionCommand().equals("Return Home")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			homeScreen();
		} else if(e.getActionCommand().equals("Get Score for a Student")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			chooseStudent();
		} else if(e.getActionCommand().equals("Get Scores for all Students")) {
			students = new TextReader().loadRoster(period);
			for(String student : students) {
				currentAssignment.calculateStudentScore(student);
			}
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			totalStudentsScore = currentAssignment.getStudentScores();
			displayTotalStudentsScores();
		} else if(e.getActionCommand().equals("Get Average Score for all Students")) {
			students = new TextReader().loadRoster(period);
			for(String student : students) {
				currentAssignment.calculateStudentScore(student);
			}
			averageScore = currentAssignment.getAvgScore();
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			getAverageScore();
		} else if(e.getActionCommand().equals("Get all Student Names")) {
			students = new TextReader().loadRoster(period);
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			getStudentNames();
		}
	}
}