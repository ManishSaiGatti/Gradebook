import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.awt.Color;

import javax.swing.*;

public class GUI implements ActionListener {
	private static int width;
	private static int height;
	private static Dimension maxSize;
//	private static String currentScreen;
//	private static String assignmentName = "";
	private static JFrame canvas;
	private static String currentScreen;
	private static JTextField assignmentName;
	private static JTextField newStandard;
	private static JTextField newStudent;
	private static JTextField textPercentFor85;
	private static JTextField textPercentFor95;
	private static JTextField textPercentFor100;
	private static JTextField questionInput;
	private static String assignment;
	private static HashMap<String, String> standard = new HashMap<String, String>();
	private static String currentStandard;
	private static List<String> students = new ArrayList<String>();
	private static List<String> questions = new ArrayList<String>();
	private static String currentStandardType;
	private static Iterator<String> it;
	
	public GUI() {
		width = 100;
		height = 100;
		canvas = new JFrame();
		canvas.setTitle("App");
		
		homeScreen();
		
		maxSize = Toolkit.getDefaultToolkit().getScreenSize();
	    canvas.setSize(maxSize.width, maxSize.height);
		
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.setLayout(null);
		canvas.setVisible(true);
	}
	
	public GUI(int width, int height) {
		this.width = width;
		this.height = height;
		canvas = new JFrame();
		canvas.setTitle("App");
		
		homeScreen();
		
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.setSize(width, height);
		canvas.setLayout(null);
		canvas.setVisible(true);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
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
		title.setBounds(175, 10, 175, 40);
		title.setText("New Assignment");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
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
		
//		System.out.println(canvas.getHeight());
//		System.out.println(canvas.getWidth());
//		System.out.println(canvas.getComponentCount());
	}
	
	private void enterStandardScreen() {
		JLabel title = new JLabel();
		title.setBounds(175, 10, 175, 40);
		title.setText(assignment);
		title.setFont(new Font("Arial", Font.PLAIN, 20));
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
		
		currentScreen = "newStandard";
	}
	
	private void chooseStandard() {
		int numStandards = standard.size();
		System.out.println(numStandards);
		List<JButton> standardButtons = new ArrayList<JButton>();
		List<String> standardNames = new ArrayList<String>(standard.keySet());
		int counter = 0;
		//Iterator<String> it = standardNames.iterator();
		
		for(int i = 0; i < 2; i ++) {
			int x = 200 * i + 10;
			for(int j = 0; (j < (numStandards / 2 + numStandards % 2)) && (counter < standardNames.size());  j++) {
				int y = j * 40 + 5;
				String name = "Standard: " + standardNames.get(counter);
				counter ++;
				JButton button = addButton(x, y, 200, 40, name);
				//System.out.println(x + ", " + y);
				button.addActionListener(this);
				standardButtons.add(button);
				canvas.add(button);
			}
		}
	}
	
	private void addScores() {
		JLabel title = new JLabel();
		title.setBounds(175, 10, 175, 40);
		title.setText("Please Choose the Type of Standard");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(title);
		
		JButton numTrueFalse = new JButton("True False based on percentage");
		numTrueFalse.setBounds(2, 210, 250, 40);
		numTrueFalse.addActionListener(this);
		canvas.add(numTrueFalse);
		
		JButton oneTrueFalse = new JButton("One True False determines score");
		oneTrueFalse.setBounds(2, 310, 250, 40);
		oneTrueFalse.addActionListener(this);
		canvas.add(oneTrueFalse);
		
		JButton intScores = new JButton("int values represent score");
		intScores.setBounds(2, 410, 250, 40);
		intScores.addActionListener(this);
		canvas.add(intScores);
	}
	
	private void chooseStudent() {
		JLabel title = new JLabel();
		title.setBounds(175, 10, 175, 40);
		title.setText("Choose Student");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(title);
		
		JLabel assignmentNameLabel = new JLabel();
		assignmentNameLabel.setBounds(2, 210, 250, 40);
		assignmentNameLabel.setText("Enter Student Name: ");
		assignmentNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(assignmentNameLabel);
		
		newStudent = new JTextField();
		newStudent.setBounds(220, 210, 190, 40);
		newStudent.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(newStudent);
		
		JButton addNew = new JButton("Add New Student");
		addNew.setBounds(110, 310, 150, 40);
		canvas.add(addNew);
		addNew.addActionListener(this);
		
		JButton useOld = new JButton("Find Existing Student");
		useOld.setBounds(310, 310, 160, 40);
		canvas.add(useOld);
		useOld.addActionListener(this);
		
		currentScreen = "chooseStudent";
	}
	
	public void percentTrueFalse() {
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
		
		currentScreen = "Percent True False";
	}
	
	public void oneTrueFalse(String q) {
		JLabel question = new JLabel();
		question.setFont(new Font("Arial", Font.PLAIN, 20));
		question.setBounds(0, 100, maxSize.width, 40);
		//question.setHorizontalAlignment(JLabel.CENTER);
		//question.setVerticalTextPosition(100);
		question.setText(q);
		//canvas.setLayout(new GridBagLayout());
		//canvas.setLocationRelativeTo(null);
		canvas.add(question);
		
		JButton score75 = new JButton("75");
		score75.setBounds(2, 410, 250, 40);
		score75.addActionListener(this);
		canvas.add(score75);
		
		JButton score85 = new JButton("85");
		score85.setBounds(300, 410, 250, 40);
		score85.addActionListener(this);
		canvas.add(score85);
		
		JButton score95 = new JButton("95");
		score95.setBounds(600, 410, 250, 40);
		score95.addActionListener(this);
		canvas.add(score95);
		
		currentScreen = "oneTrueFalse";
	}
	
	public void enterQuestions() {
		JLabel questions = new JLabel();
		questions.setBounds(2, 210, 250, 40);
		questions.setText("Enter a question that will be graded: ");
		canvas.add(questions);
		System.out.println(questions.getPreferredSize());
		
		questionInput = new JTextField();
		questionInput = new JTextField();
		questionInput.setBounds(220, 210, 190, 40);
		questionInput.setFont(new Font("Arial", Font.PLAIN, 20));
		canvas.add(questionInput);
		
		JButton enterKey = new JButton("Enter");
		enterKey.setBounds(415, 210, 65, 40);
		canvas.add(enterKey);
		enterKey.addActionListener(this);
		
		JButton questionsDone = new JButton("I am done entering Questions");
		questionsDone.setBounds(285, 410, 200, 40);
		canvas.add(questionsDone);
		questionsDone.addActionListener(this);
		
		currentScreen = "enterQuestions";
	}
	
	public static JButton addButton(int x, int y, int width, int height, String name) {
		JButton b = new JButton(name);
		b.setBounds(x, y, width, height);
		return b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getActionCommand());
		if(e.getActionCommand().equals("New Assignment")) {
			System.out.println("New Assignment");
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			newAssignmentScreen();
		} else if(e.getActionCommand().equals("Edit Assignment")) {
			System.out.println("Edit Assignment");
		} else if(e.getActionCommand().equals("Display Scores")) {
			System.out.println("Display Scores");
		} else if(e.getActionCommand().equals("Enter")) {
			if(currentScreen.equals("newAssignment")) {
				assignment = assignmentName.getText();
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				enterStandardScreen();
			} else if(currentScreen.equals("newStandard")) {
//				standard.add(assignmentName.getText());
				standard.put(newStandard.getText(), "");
				System.out.println(standard);
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
				enterStandardScreen();
			} else if(currentScreen.equals("chooseStudent")) {
				canvas.getContentPane().removeAll();
				canvas.getContentPane().repaint();
			} else if(currentScreen.equals("Percent True False")) {
				String num85 = textPercentFor85.getText();
				String num95 = textPercentFor95.getText();
				//String num100 = textPercentFor100.getText();
				
				String ans = "85:" + num85 + "/95:" + num95;
				
				standard.put(currentStandard, ans);
				
				System.out.println(standard);
				
//				System.out.println("85: " + num85);
//				System.out.println("95: " + num95);
//				System.out.println("100: " + num100);
			} else if(currentScreen.equals("enterQuestions")) {
				String question = questionInput.getText();
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
			}
		} else if(e.getActionCommand().equals("Add Scores")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			chooseStandard();
		} else if(e.getActionCommand().contains("Standard: ")) {
			currentStandard = e.getActionCommand().substring(10);
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			//chooseStudent();
			addScores();
			//enterQuestions();
		} else if(e.getActionCommand().equals("Add New Student")) {
			students.add(newStudent.getText());
			System.out.println("Added Student " + newStudent.getText());
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
		} else if(e.getActionCommand().equals("Find Existing Student")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			if(students.contains(newStudent.getText())) {
				System.out.println("Student exists " + newStudent.getText());
			} else {
				System.out.println("Student doesn't exist");
			}
		} else if(e.getActionCommand().equals("True False based on percentage")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			//percentTrueFalse();
			enterQuestions();
			currentStandardType = "trueFalsePerc";
			System.out.println("True False based on percentage");
		} else if(e.getActionCommand().equals("One True False determines score")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			System.out.println("One True False determines score");
			enterQuestions();
			currentStandardType = "oneTrueFalse";
		} else if(e.getActionCommand().equals("int values represent score")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			System.out.println("int values represent score");
			enterQuestions();
			currentStandardType = "intValues";
		} else if(e.getActionCommand().equals("I am done entering Questions")) {
			canvas.getContentPane().removeAll();
			canvas.getContentPane().repaint();
			//addScores();
			if(currentStandardType.equals("trueFalsePerc")) {
				percentTrueFalse();
			} else if(currentStandardType.equals("oneTrueFalse")) {
				it = questions.iterator();
				oneTrueFalse(it.next());
				System.out.println("One True False determines score");
			} else if(currentStandardType.equals("intValues")) {
				System.out.println("int values represent score");
			}
		} else if(e.getActionCommand().equals("75")) {
			
		}
	}
}