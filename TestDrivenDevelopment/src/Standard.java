import java.util.*;
public class Standard {
	private HashMap<String, ArrayList<String>> studentScore;
	public Standard() {
		studentScore = new HashMap<String, ArrayList<String>>();
		
	}
	
	public void setIntScore(String student, String question, int score) {
		/*
		ArrayList<String> questionAndAnswer = new ArrayList<String>();
		questionAndAnswer.add(question + score);
		studentScore.put(student, questionAndAnswer);
		*/
	}
	
	public int getScore(String student) {
		/*
		ArrayList<String> questionsAndAnswers = studentScore.get(student);
		for(String s: questionsAndAnswers) {
			return Integer.parseInt(s.substring(s.length() - 1));
		}
		*/
		return 100;
	}
}