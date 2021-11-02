import java.util.*;
public class Standard1 {
	
	private ArrayList<String> questions;
	private HashMap<String, ArrayList<Boolean>> studentScores;
	
	public Standard1() {
		questions = new ArrayList<String>();
		studentScores = new HashMap<String, ArrayList<Boolean>>();
	}
	public void addQuestions(ArrayList<String> questions) {
		this.questions = questions;
	}
	
	public ArrayList<String> getQuestions() {
		return questions;
	}
	
	public Set<String> getRoster() {
		return studentScores.keySet();
	}
	
	public void setAnswers(String student, ArrayList<Boolean> answers) {
		studentScores.put(student, answers);
	}
	
	public int getScore(String student) {
		return 100;
	}
	
	public void editQuestion(String student, String question) {
		return;
	}
	
	public void editAnswer(String student, String question, boolean answer) {
		return;
	}
}
