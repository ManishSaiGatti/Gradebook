// Catherine Yu

import java.util.*;

// standard 3 is a standard where the student earns a score out of 5 points.
public class Standard3 {
	// key: String studentName, val: int studentRawScore
	private HashMap<String, Integer> studentRawScores;
	private String question; // eg "how many points out of 5 for ___?"
	private double weight;
	
	public Standard3(String question, double weight) {
		this.question = question;
		studentRawScores = new HashMap<String, Integer>();
		this.weight = weight;
	}
	
	// adds a new student to hashmap, no score assigned yet (raw score = -1)
	public void addStudent(String student) {
		studentRawScores.put(student, -1);
	}
	
	// sets the student's answer based on name and their raw score
	// adds a new student with the score inputted if student does not yet exist
	// replaces the student's score if student already exists
	public void setStudentScore(String student, int rawScore) {
		studentRawScores.put(student, rawScore);
	}

	public void editQuestion(String newQuestion) {
		question = newQuestion;
	}

	public String getQuestion() {
		return question;
	}
	
	public double getWeight() {
		return weight;
	}
	
	// should only be used internally for testing
	public int getRawScore(String student) {
		if (studentRawScores.containsKey(student)) {
			return studentRawScores.get(student);
		} else {
			throw new IllegalArgumentException("Student does not exist yet.");
		}
	}
	
	public int getScore(String student) {
		if (studentRawScores.containsKey(student)) {
			return convertRawScore((int) studentRawScores.get(student));
		} else {
			throw new IllegalArgumentException("Student does not exist yet.");
		}
	}
	
	// get a list of all the student scores. order matches up with the order that roster returns
	public List<Integer> getStudentScores() {
		List<Integer> scores = new ArrayList<Integer>();
		for (String s: getRoster()) {
			scores.add(getScore(s));
		}
		
		return scores;
	}
	
	// assumes scores is already in the range of 1-5
	// converts raw score to /100 score.
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
		} else {
			// rawScore is -1, given that GUI makes sure score given when setting is 1-5
			throw new IllegalArgumentException("You have not given a student "
					+ "a score yet!");
		}
	}
	
	public List<String> getRoster() {
		return new ArrayList<>(studentRawScores.keySet());
	}
}
