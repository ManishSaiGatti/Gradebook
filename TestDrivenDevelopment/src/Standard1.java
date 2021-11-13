/*
 * Name: Alec Rothkowitz
 * Date: 10/28/21
 * Project 1 - Standards Grade Creator
 * Summary: This is one of three types of standards implemented by the Standards Grade Creator.
 * This will assign a student grade according to the number of questions they met. These values
 * are set in the constructor to determine how many questions they need to correctly complete
 * to get a certain score. A set of questions for every student to answer is given, and 
 * these answers are also set and associated with a given student.
 */
import java.util.*;
public class Standard1 {
	//Stores the number of questions a student must have met to get an 85
	private final int numCorrect85;
	//Stores the number of questions a student must have met to get a 95
	private final int numCorrect95;
	//List of all questions for the standard
	private ArrayList<String> questions;
	//HashMap of key: student name and value: list of whether they they met a question or not
	private HashMap<String, ArrayList<Boolean>> studentScores;
	
	//Summary - Declares variables
	//Input - Number of questions that need to be correct to get an 85 and 95
	//Output - None
	public Standard1(int numCorrect85, int numCorrect95) {
		questions = new ArrayList<String>();
		studentScores = new HashMap<String, ArrayList<Boolean>>();
		this.numCorrect85 = numCorrect85;
		this.numCorrect95 = numCorrect95;
	}
	
	//Summary - Adds a question to the questions ArrayList, if a question is already in the 
	//array, it is not added
	//Input - ArrayList of questions to be added
	//Output - None
	public void addQuestions(ArrayList<String> questions) {
		if (!this.questions.isEmpty()) {
			for (String s: questions) {
				if (!this.questions.contains(s)) {
					this.questions.add(s);
				}
			}
		} else {
			this.questions = questions;
		}
	}
	
	//Summary -This method allows an individual question to be added to the questions ArrayList,
	//instead of requiring an ArrayList of questions
	//Input - Question string to add
	//Output - None
	public void addIndividualQuestion(String question) {
		if (!questions.contains(question)) {
			questions.add(question);
		}
	}
	
	//Summary - Returns an ArrayList of all the questions in the questions array
	//Input - None
	//Output - ArrayList of all current questions
	public ArrayList<String> getQuestions() {
		return questions;
	}
	
	//Summary - Returns a Set of all students in the roster
	//Input - None
	//Output - Set of Strings representing students in roster
	public Set<String> getRoster() {
		return studentScores.keySet();
	}
	
	//Summary - Sets answers for a particular student. This should be added in the same
	//order as the questions are added. This method creates a student in the HashMap
	//if they do not yet exist.
	//Input - String name of student and ArrayList of true false answers for which questions
	//They met and did not.
	//Output - None
	public void setAnswers(String student, ArrayList<Boolean> answers) {
		if (studentScores.containsKey(student)) {
			ArrayList<Boolean> currentAnswers = studentScores.get(student);
			answers.addAll(currentAnswers);
		}
		studentScores.put(student, answers);
	}
	
	//Summary - Sets a single answer for a particular student. Instead of adding answers 
	//with an ArrayList, this allows a single boolean answer to be given
	//Input - String name of student and boolean answer to a single question
	//Output - None
	public void setIndividualAnswer(String student, boolean answer) {
		ArrayList<Boolean> currentAnswers = studentScores.get(student);
		if (currentAnswers == null) {
			currentAnswers = new ArrayList<Boolean>();
		}
		currentAnswers.add(answer);
		studentScores.put(student, currentAnswers);
	}
	
	//Summary - Gives the score of a student based off the numCorrect85 and numCorrect95 methods.
	//Input - String student name
	//Output - The score of a given student
	public int getScore(String student) {
		int numCorrect = 0;
		for (Boolean b: studentScores.get(student)) {
			if (b) {
				numCorrect++;
			}
		}
		if (numCorrect < numCorrect85) {
			return 75;
		} else if (numCorrect < numCorrect95) {
			return 85;
		//Any number correct that is greater than or equal to numCorrect95 but still below the
		//total number of questions is a 95
		} else if (numCorrect < questions.size()) {
			return 95;
		}
		//For a student to get 100, the numCorrect must equal the number of questions, could
		//include an else statement but unnecessary
		return 100;
	}
	
	//Summary - Replaces an old question with a new question in the questions ArrayList
	//Input - String question to be replaced and String replacement
	//Output - None
	public void editQuestion(String oldQuestion, String newQuestion) {
		//Only changes question if its already in the questions array.
		if (questions.contains(oldQuestion)) {
			questions.set(questions.indexOf(oldQuestion), newQuestion);
		}

	}
	
	//Summary - Edits the answer of a student to a given question
	//Input - String student name, String question that the answer to needs to be edited,
	//and new answer to be set
	//Output - None
	public void editAnswer(String student, String question, boolean answer) {
		ArrayList<Boolean> studentAnswers = studentScores.get(student);
		int indexOfAnswer = questions.indexOf(question);
		if (indexOfAnswer >= 0 && studentAnswers != null) {
			studentAnswers.set(indexOfAnswer, answer);
		}
		studentScores.put(student, studentAnswers);
	}
	
	//Summary - Returns the number of questions a student must get correct to get an 85
	//Input - None
	//Output - Number of questions correct for an 85
	public int getNumCorrect85() {
		return numCorrect85;
	}
	
	//Summary - Returns the number of questions a student must get correct to get an 95
	//Input - None
	//Output - Number of questions correct for an 95
	public int getNumCorrect95() {
		return numCorrect95;
	}
	
	//Summary - Returns a HashMap of all students and answers for testing purposes
	//Input - None
	//Output - HashMap of students and answers
	public HashMap<String, ArrayList<Boolean>> getAllAnswers() {
		return studentScores;
	}
	
	//Summary - Returns an ArrayList of all answers stored for a particular student
	//Input - The student who's answers are being checked
	//Output - ArrayList of all answers for that student
	public ArrayList<Boolean> getStudentAnswers(String student) {
		return studentScores.get(student);
	}
}
