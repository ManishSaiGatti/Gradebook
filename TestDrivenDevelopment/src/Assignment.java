public class Assignment {
	private double score;
	private static double totalScores;
	private static int numStudents;
	
	public Assignment(String student) {
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