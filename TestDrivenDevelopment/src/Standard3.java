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
	// adds a new student with the score inputted if student does not yet exist, replaces the student's score
	// with the new given score if student already exists
	public void changeStudentScore(String student, int rawScore) {
		studentRawScores.put(student, rawScore);
	}

	public void editQuestion(String newQuestion) {
		question = newQuestion;
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
	
	// converts raw score to /100 score. ASSUMES SCORE IS ALREADY IN THE RANGE OF 1-5
	private int convertRawScore(int rawScore) {
		// 5-100 4-95 3-85 2-75 1-0
		if (rawScore == 5) {
			return 100;
		} else if (rawScore == 4) {
			return 95;
		} else if (rawScore == 3) {
			return 85;
		} else if (rawScore == 2) {
			return 75;
		} else if (rawScore == 1) {
			return 0;
		} else { // rawScore will have to be -1 given that GUI makes sure score given when setting is 1-5
			throw new IllegalArgumentException("You have not given a student "
					+ "a score yet!"); // IDK IF THIS IS THE RIGHT TYPE OF EXCEPTION TO THROW
		}
	}
	
	// get roster method (List<String>) use keyset,iterator
	public List<String> getRoster() {
		return new ArrayList<>(studentRawScores.keySet());
	}
}
