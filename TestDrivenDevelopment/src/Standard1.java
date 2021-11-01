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
	
	public void giveScores(String student, ArrayList<Boolean> scores) {
		studentScores.put(student, scores);
	}
	
	public int getScores(String student) {
		return 100;
	}
}
