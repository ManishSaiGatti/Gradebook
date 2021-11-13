import java.util.*;
public class StandardTwo {
	// eg: "How are you? 75"
	ArrayList<String> questions;
	// hashmap for student, arraylist<boolean> that line up with questions' indices
	private HashMap<String, ArrayList<Boolean>> studentAnswers;
	private double weight;
	
	public static void main(String args[]) {
		StandardTwo St2 = new StandardTwo(75);
		/*St2.addIndividualQ("hello?");
		St2.editQuestions(0, "goodbye?");
		St2.getQuestions();*/
	}
	
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
		studentAnswers.put(student, answers);
	}
	
	public boolean addIndividualA(String student, Boolean a) {
		studentAnswers.get(student).add(a);
		System.out.println("answer is " + studentAnswers.get(student).get(-1));
		return studentAnswers.get(student).get(-1);
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
		//System.out.println("ans is " + studentAnswers.get(student).get(0));
		
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
		for(int i = 0; i < questions.size(); i++) {
			System.out.println("question is " + questions.get(i));
		}
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
		System.out.println("the int score is " + worth);
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
		studentAnswers.get(student).set(index, newA);
	}
	
}
