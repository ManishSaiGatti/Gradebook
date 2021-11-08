import java.util.*;

public class Assignment {
	private HashMap<String, Integer> studentScores; // key: String studentName, val: int studentScore
	private String assignmentName;
	
	public Assignment(String assignmentName) {		
		this.assignmentName = assignmentName;
		studentScores = new HashMap<String, Integer>();
	}
	
	// adds a new student with their calculated  score.
	// if student's score already exists, recalculates and updates their score.
	public void setStudentScore(String student) {
		studentScores.put(student, calculateScore(student));
	}
		
	private int calculateScore(String student) {
		/*
		check to make sure weights for all standards add up to 1
		for each standard a student's assignment has:
				score += weight * student's score for that standard
		score = Standard.getOneStudentScore(student);
		
		totalScores += score;
		numStudents++;
		*/

		return -1;
	}
	
	public void editAssignmentName(String newName) {
		assignmentName = newName;
	}
	
	public String getAssignmentName() {
		return assignmentName;
	}

	public int getScore(String student) {
		if (studentScores.containsKey(student)) {
			return (int) studentScores.get(student);
		} else {
			throw new IllegalArgumentException("Student does not exist yet!");
		}
	}
	
	// get all students' scores
	public List<Integer> getStudentScores() {
		return (List<Integer>) studentScores.values();
	}

	public double getAvgScore() {
		int total = 0;
		// add all student scores together
		for (Integer score: studentScores.values()) {
			total += (int) score;
		}
		
		// divide by # things in hashmap
		return ((double) total / studentScores.size()); // CUT THE DOUBLE TO 2 DIGITS HERE
	}
	
	public List<String> getRoster() {
		return new ArrayList<>(studentScores.keySet());
	}
}