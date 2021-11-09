import java.util.*;

// standard 3 is a standard where the student earns a score out of 5 points.
public class Standard3 {
	private HashMap<String, Integer> studentRawScores; // key: String studentName, val: int studentRawScore
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
	public void setStudentScore(String student, int rawScore) {
		studentRawScores.put(student, rawScore);
	}

	public void editQuestion(String newQuestion) {
		question = newQuestion;
	}
		
	public String getQuestion() {
		return question;
	}
	
	public int getScore(String student) {
		if (studentRawScores.containsKey(student)) {
			return convertRawScore((int) studentRawScores.get(student));
		} else {
			throw new IllegalArgumentException("Student does not exist yet.");
		}
	}
	
	public List<Integer> getStudentScores() {
		/*
		List<Integer> scores = (List<Integer>) studentRawScores.values();
		
		for (int i = 0; i < scores.size(); i++) {
			scores.set(i, convertRawScore((int) scores.get(i)));
		}
		*/
		
		List<Integer> scores = new ArrayList<Integer>();
		for (String s: getRoster()) {
			scores.add(getScore(s));
		}
		
		return scores;
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
					+ "a score yet!");
		}
	}
	
	// get roster method (List<String>) use keyset,iterator
	public List<String> getRoster() {
		return new ArrayList<>(studentRawScores.keySet());
	}
}
