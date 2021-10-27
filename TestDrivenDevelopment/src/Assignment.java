public class Assignment {
	private double score;
	
	public Assignment(String student) {
		score = Standard.getOneStudentScore(student);
	}
	
	public double getScore() {
		return score;
	}
}