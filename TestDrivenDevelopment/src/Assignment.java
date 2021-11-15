import java.util.*;

public class Assignment {
	private HashMap<String, Integer> studentScores; // key: String studentName, val: int studentScore
	private String assignmentName;
	// store all the standards for that assignment, sorted by type
	private ArrayList<Standard1> standards1;
	private ArrayList<StandardTwo> standards2;
	private ArrayList<Standard3> standards3;
	
	public Assignment(String assignmentName, ArrayList<Standard1> standards1,
			ArrayList<StandardTwo> standards2, ArrayList<Standard3> standards3) {
		this.assignmentName = assignmentName;
		studentScores = new HashMap<String, Integer>();
		this.standards1 = standards1;
		this.standards2 = standards2;
		this.standards3 = standards3;
	}
	
	// adds a new student with their calculated  score.
	// if student's score already exists, recalculates and updates their score.
	public void calculateStudentScore(String student) {
		studentScores.put(student, calculateScore(student));
	}
		
	// assumes that the weight of the standards adds up to 100
	private int calculateScore(String student) {
		double score = 0;
		for (Standard1 s1: standards1) {
			score += (s1.getScore(student) * s1.getWeight() / 100.0);
		}
		for (StandardTwo s2: standards2) {
			score += (s2.calculateOneStudentTotal(student) * s2.getWeight() / 100.0);
		}
		for (Standard3 s3: standards3) {
			score += (s3.getScore(student) * s3.getWeight() / 100.0);
		}
		return (int) Math.round(score);
	}
	
	public void editAssignmentName(String newName) {
		assignmentName = newName;
	}
	
	public void editStandards1(ArrayList<Standard1> newStandards1) {
		standards1 = newStandards1;
	}

	public void editStandards2(ArrayList<StandardTwo> newStandards2) {
		standards2 = newStandards2;
	}
	
	public void editStandards3(ArrayList<Standard3> newStandards3) {
		standards3 = newStandards3;
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

	public int getAvgScore() {
		double total = 0;
		// add all student scores together
		for (Integer score: studentScores.values()) {
			total += (int) score;
		}
		
		// divide by # things in hashmap
		return (int) Math.round(total / studentScores.size());
	}
	
	public List<String> getRoster() {
		return new ArrayList<>(studentScores.keySet());
	}
}