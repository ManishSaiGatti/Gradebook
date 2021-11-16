import java.util.*;
public class StandardTwo {
	// eg: "How are you? 75"
	ArrayList<String> questions;
	// hashmap for student, arraylist<boolean> that line up with questions' indices
	private HashMap<String, ArrayList<Boolean>> studentAnswers;
	private double weight;
	
	public StandardTwo(double weight) {
		questions = new ArrayList<>();
		studentAnswers = new HashMap<String, ArrayList<Boolean>>();
		this.weight = weight;
	}
	
	// ADD METHODS
	// add all questions as string arraylist
	public void addAllQuestions(ArrayList<String> ar) {
		questions = ar;
	}
	
	// add individual question to end of questions arraylist
	public void addIndividualQ(String q) {
		questions.add(q);
	}
	
	// add all answers for 1 student
	public void addAllAnswers(String student, ArrayList<Boolean> answers) {
		// if student doesnt have a arlist of bools for answers make one
		if(studentAnswers.containsKey(student)) {
			studentAnswers.replace(student, answers);
		}
		// if student doesnt exist, add new student with answers
		studentAnswers.put(student, answers);	
	}
	
	// add individual answer for 1 student at the end of their arraylist
	public ArrayList<Boolean> addIndividualA(String student, Boolean a) {
		// if student doesnt have answers arlist yet, make one
		if(studentAnswers.get(student) == null) {
			ArrayList<Boolean> stuAns = new ArrayList<Boolean>();
			stuAns.add(a);
			studentAnswers.put(student, stuAns);
		}
		else {
			studentAnswers.get(student).add(a);
		}
		return studentAnswers.get(student);
	}
	
	// add a student with an empty list for their answers
	public void addStudent(String student) {
		ArrayList<Boolean> temp = new ArrayList<>();
		studentAnswers.put(student, temp);
	}
	
	// GET METHODS
	// get all names from studentAnswers hashmap and return as a set
	public Set<String> getRoster() {
		return studentAnswers.keySet();
	}
	
	// get all answers of 1 student
	public ArrayList<Boolean> getOneStuAnswers(String student) {
		return studentAnswers.get(student);
	}
	
	// calculate 1 student's total score after checking all of their answers
	// for all questions in 1 standard
	public int calculateOneStudentTotal(String student) {
		int totalScore = 0;
		boolean flagHund = true;
		for(int i = 0; i < studentAnswers.get(student).size(); i++) {
			int worth = getQuestionWorth(i);
			// if student's answer for the specific question is true
			if(studentAnswers.get(student).get(i) == true && worth >= totalScore) {
				//then the total score is the worth
				totalScore = worth;
			}
			// if a student ever misses a grade, they wont get 100
			if(studentAnswers.get(student).get(i) == false) {
				flagHund = false;
			}
		}
		// student got all questions correct, they get a 100
		if(flagHund) {
			totalScore = 100;
		}
		return totalScore;
	}
	
	// get answers of every student as 1 hashmap
	public HashMap<String, ArrayList<Boolean>> getAllStudentAnswers() {
		return studentAnswers;
	}
	
	// get all questions as 1 list
	public List<String> getQuestions() {
		return questions;
	}
	
	// get worth of 1 question
	public int getQuestionWorth(int index) {
		String strScore = "";
		int worth = 0;
		
		String q = questions.get(index);
		// get the last 3 characters (the score) & make it a number
		strScore = q.substring(q.length() - 2);
		if(strScore.equals("00")) {
			strScore = "100";
		}
		worth = Integer.parseInt(strScore);
		return worth;
	}
	
	// get weight
	public double getWeight() {
		return weight;
	}
	
	
	// EDIT METHODS
	// edit 1 question by first specifying which question to edit
	public void editQuestions(String oldQ, String newQ) {
		if (questions.contains(oldQ)) {
			questions.set(questions.indexOf(oldQ), newQ);
		}
	}
	
	// edit answer of 1 student by first specifying the student and question to edit
	public void editAnswers(String student, String q, boolean newA) {
		ArrayList<Boolean> stuAns = studentAnswers.get(student);
		int index = questions.indexOf(q);
		// if student answer is null
		if(stuAns == null) {
			// make new empty arraylist and add answer to it for that student
			stuAns = new ArrayList<Boolean>();
			stuAns.add(newA);
		}
		// if there is already an answer at that index, replace it
		else {
			stuAns.set(index, newA);
		}
		
		studentAnswers.put(student, stuAns);
	}
	
}
