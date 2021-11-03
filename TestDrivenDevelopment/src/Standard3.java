import java.util.*;

public class Standard3 {
	private HashMap<String, Integer> studentRawScores; // key: String studentName, val: int studentRawScore
	// private final int TOTAL_POINTS = 5;
	private String question; // eg "how many points out of 5 for ___?"
	
	public Standard3(String question) {
		this.question = question;
		studentRawScores = new HashMap<String, Integer>();
	}
	
	// adds a new student to hashmap, no score assigned yet (raw score = -1)
	public void addStudent(String student) {
		studentRawScores.put(student, -1);
	}
	
	// setAnswers based on student name (void)
	public void addStudentScore(String student, int rawScore) {
		studentRawScores.put(student, rawScore);
	}

	public void editQuestion(String newQuestion) {
		question = newQuestion;
	}
	
	public void editAnswer(String student, int newRawScore) {
		studentRawScores.replace(student, newRawScore);
	}
	
	public String getQuestion() {
		return question;
	}
	
	public List<Integer> getStudentScores() {
		List<Integer> scores = (List<Integer>) studentRawScores.values();
		
		for (int i = 0; i < scores.size(); i++) {
			scores.set(i, convertRawScore((int) scores.get(i)));
		}		
		return scores;
		
		/*
		if (studentRawScores.get(student) == null) {
			throw new IllegalArgumentException(student + " does not exist. "
					+ "Please add their grade to this standard or try another student.");
		}
		 */
	}
	
	// converts raw score to /100 score
	private int convertRawScore(int rawScore) {
		// 5-100 4-95 3-85 2-75 1-0
		if (rawScore == -1) {
			throw new IllegalArgumentException("You have not given a student "
					+ "a score yet!"); // IDK IF THIS IS THE RIGHT TYPE OF EXCEPTION TO THROW
		} else if (rawScore == 5) {
			return 100;
		} else if (rawScore == 4) {
			return 95;
		} else if (rawScore == 3) {
			return 85;
		} else if (rawScore == 2) {
			return 75;
		} else if (rawScore == 1) {
			return 0;
		} else {
			throw new IllegalArgumentException("Raw score for a student" +
					" was not in the range from 1-5. Please edit their score.");
		}
	}
	
	// get roster method (List<String>) use keyset,iterator
	public List<String> getRoster() {
		return (List<String>) studentRawScores.keySet().iterator();
	}
}
