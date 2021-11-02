import java.util.*;
public class Standard1 {
	private final int numCorrect85;
	private final int numCorrect95;
	private ArrayList<String> questions;
	private HashMap<String, ArrayList<Boolean>> studentScores;
	
	public Standard1(int numCorrect85, int numCorrect95) {
		questions = new ArrayList<String>();
		studentScores = new HashMap<String, ArrayList<Boolean>>();
		this.numCorrect85 = numCorrect85;
		this.numCorrect95 = numCorrect95;
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
		int numCorrect = 0;
		for(Boolean b: studentScores.get(student)) {
			if(b) {
				numCorrect++;
			}
		}
		if(numCorrect < numCorrect85) {
			return 75;
		} else if (numCorrect < numCorrect95) {
			return 85;
		} else if (numCorrect != questions.size()) {
			return 95;
		}
		return 100;
	}
	
	public void editQuestion(String student, String question) {
		return;
	}
	
	public void editAnswer(String student, String question, boolean answer) {
		return;
	}
}
