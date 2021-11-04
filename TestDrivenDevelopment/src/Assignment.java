public class Assignment {
	private double score;
	private static double totalScores;
	private static int numStudents;
	// CHANGE THIS TO BE STORED IN HASHMAPS ALSO
	
	public Assignment(String name) {
		/*
		 * check to make sure weights for all standards add up to 1
		 * for each standard a student's assignment has:
		 * 		score += weight * student's score for that standard
		 */
		score = Standard.getOneStudentScore(student);
		
		totalScores += score;
		numStudents++;
	}
	
	private double getScore(int standardType) {
		// if 0/1/2, return the score for that type of standard
		return -1;
	}
	
	public double getScore() {
		return score;
	}
	
	public static double getAvgScore() {
		return totalScores/numStudents;
	}
}