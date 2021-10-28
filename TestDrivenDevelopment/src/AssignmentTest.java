import static org.junit.Assert.*;
import org.junit.Test;

public class AssignmentTest {

	@Test
	public void oneStandardTest1() {
		/*
		 * 	(helper constructor for Standard) Standard(String student, double weight, int score)
			then i can create a standard with its grade for a student, call getOneStudentScore &
			calculate expected score
		 */
		Standard s1 = new Standard();
		s1.setIntScore("Catherine", "question1", 100, 1.0);
	}
}
