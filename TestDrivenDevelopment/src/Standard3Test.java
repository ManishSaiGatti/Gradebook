import static org.junit.Assert.*;
import org.junit.Test;

public class Standard3Test {
	
	/*
	@Test
	public void getTotalPoints1() {
		int totalPoints = 5;
		Standard3 s = new Standard3(totalPoints);
		assertEquals("Total points for standard 3 incorrect", totalPoints, s.getTotalPoints());
	}
	*/
	
	@Test
	public void getQuestion1() {
		String q = "How much effort did the student put in (1-5)?";
		Standard3 s = new Standard3(q);
		assertEquals("Question was not stored correctly.", s.getQuestion(), q);
	}
		
	@Test
	public void editQuestion2() {
		String q = "How much effort did the student put in (1-5)?";
		Standard3 s = new Standard3(q);
		assertEquals("Question was not stored correctly.", s.getQuestion(), q);
		
		// edit question
		String newQ = "How well doe the student do overall (1-5)?";
		s.editQuestion(newQ);
		assertEquals("Question was not edited correctly.", s.getQuestion(), newQ);
	}
	
	@Test
	public void addStudentNoScore() {
		Standard3 s = new Standard3("Question");
		String stu1 = "Student 1";
		s.addStudent(stu1);
		assertEquals("Student (no score given) not added correctly.", s.getRoster().get(0), stu1);
		assertEquals("Student's score (no score given) not set correctly.", (int) s.getStudentScores().get(0), -1);
	}
	
	
}
