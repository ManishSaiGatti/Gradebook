import java.util.*;

public class Standard3 {
	// hashmap - key is string, ints for val
	private HashMap<String, Integer> studentScores;
	private final int TOTAL_POINTS = 5;
	private String question;
	
	public Standard3(String question) {
		this.question = question;
		studentScores = new HashMap<String, Integer>();
	}
	
	// setAnswers based on student name (void)
	public void setAsnwers(String student, int rawScore) {
		studentScores.put(student, rawScore);
	}
	
	public void editAnswer(String student, int newRawScore) {
		studentScores.replace(student, newRawScore);
	}
	
	public int getScore(String student) {
		// 5-100 4-95 3-85 2-75 1-0
		
		if (studentScores.get(student) == null) {
			throw new IllegalArgumentException(student + " does not exist. "
						+ "Please add their grade to this standard or try another student.");
		}
		
		int rawScore = (int) studentScores.get(student);
		
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
			throw new IllegalArgumentException("Raw score for " + student +
					" was not in the range from 1-5. Please edit their score.");
		}
	}
	
	// get roster method (List<String>) use keyset,iterator
	public List<String> getRoster() {
		return (List<String>) studentScores.keySet().iterator();
	}
}
