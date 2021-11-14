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
	
	// ADD ANSWERS, STUDENT, ALL QUESTIONS, INDIV QUESTIONS
	// put question and answers based on student name in hashmap
	// only string arraylist
	public ArrayList<String> addAllQuestions(ArrayList<String> ar) {
		questions = ar;
		return questions;
	}
	
	public void addIndividualQ(String q) {
		questions.add(q);
	}
	
	public void addAllAnswers(String student, ArrayList<Boolean> answers) {
		// if student doesnt have a arlist of bools for answers make one
		if(studentAnswers.containsKey(student)) {
			studentAnswers.replace(student, answers);
		}
		// if student doesnt exist, add new student with answers
		studentAnswers.put(student, answers);	
	}
	
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
	
	public void addStudent(String student) {
		ArrayList<Boolean> temp = new ArrayList<>();
		studentAnswers.put(student, temp);
	}
	
	// GET ROSTER, 1 STUDENT SCORE, ALL ANSWERS, ALL STUDENT SCORES, ALL QUESTIONS, QUEST WORTH, WEIGHT
	public Set<String> getRoster() {
		// make list of roster names
		return studentAnswers.keySet();
	}
	
	public ArrayList<Boolean> getOneStuAnswers(String student) {
		return studentAnswers.get(student);
	}
	
	public int calculateOneStudentTotal(String student) {
		int totalScore = 0;
		for(int i = 0; i < studentAnswers.get(student).size(); i++) {
			int worth = getQuestionWorth(i);
			// if student's answer for the specific question is true
			if(studentAnswers.get(student).get(i) == true && worth >= totalScore) {
				//then the total score is the worth
				totalScore = worth;
			}
		}
		return totalScore;
	}
	
	public HashMap<String, ArrayList<Boolean>> getAllStudentAnswers() {
		return studentAnswers;
	}
	
	public List<String> getQuestions() {
		return questions;
	}
	
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
	
	public double getWeight() {
		return weight;
	}
	
	
	// EDIT QUESTIONS, ANSWERS, 
	// string string, old and new question
	public void editQuestions(int index, String newQ) {
		questions.set(index, newQ);
	}
	
	// string string bool
	public void editAnswers(String student, int index, boolean newA) {
		ArrayList<Boolean> stuAns = studentAnswers.get(student);
		if(stuAns == null) {
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
