public class Assignment {
	private double score;
	private static double totalScores;
	private static int numStudents;
	
	public Assignment(String student) {
		/*
		 * check to make sure weights for all standards add up to 1
		 * for each standard a student's assignment has:
		 * 		score += weight * student's score for that standard
		 */
		score = Standard.getOneStudentScore(student);
		
		totalScores += score;
		numStudents++;
	}
	
	public double getScore() {
		return score;
	}
	
	public static double getAvgScore() {
		return totalScores/numStudents;
	}
}