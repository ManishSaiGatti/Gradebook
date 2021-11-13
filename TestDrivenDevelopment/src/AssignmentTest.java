import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class AssignmentTest {	
	@Test
	public void emptyAssignment() {
		Standard3 s = new Standard3("How many out of 5?", 100);
		s.setStudentScore("Student 1", 4);
		
		ArrayList<Standard1> s1 = new ArrayList<Standard1>();
		ArrayList<StandardTwo> s2 = new ArrayList<StandardTwo>();
		ArrayList<Standard3> s3 = new ArrayList<Standard3>();
		
		s3.add(s);
		
		Assignment a = new Assignment("BCC Project", s1, s2, s3);
		a.calculateStudentScore("Student 1");
		
		assertEquals("Student score not calculated correctly!", 95, a.getScore("Student 1"));		
		assertEquals("Class average for class size 1 calculated incorrectly.", 95, a.getAvgScore());
		
		List<String> roster = new ArrayList<String>();
		roster.add("Student 1");
		assertEquals("Student was not added to roster.", roster, a.getRoster());
	}
	
	@Test
	public void weightedStandards() {
		Standard3 stan1 = new Standard3("How many out of 5?", 75);
		stan1.setStudentScore("Student 1", 5);
		Standard3 stan2 = new Standard3("Effort put in out of 5?", 25);
		stan2.setStudentScore("Student 1", 1);
		
		ArrayList<Standard1> s1 = new ArrayList<Standard1>();
		ArrayList<StandardTwo> s2 = new ArrayList<StandardTwo>();
		ArrayList<Standard3> s3 = new ArrayList<Standard3>();
		
		s3.add(stan1);
		s3.add(stan2);
		
		Assignment a = new Assignment("BCC Project", s1, s2, s3);
		a.calculateStudentScore("Student 1");
		
		assertEquals("Student score not calculated correctly!", 75, a.getScore("Student 1"));		
	}
	
	// multiple students, for class avg
	@Test
	public void classAverage() {
		Standard3 s = new Standard3("How many out of 5?", 100);
		s.setStudentScore("Student 1", 5);
		s.setStudentScore("Student 2", 1);
		
		ArrayList<Standard1> s1 = new ArrayList<Standard1>();
		ArrayList<StandardTwo> s2 = new ArrayList<StandardTwo>();
		ArrayList<Standard3> s3 = new ArrayList<Standard3>();
		
		s3.add(s);
		
		Assignment a = new Assignment("BCC Project", s1, s2, s3);
		a.calculateStudentScore("Student 1");
		a.calculateStudentScore("Student 2");
		
		assertEquals("Class average calculated incorrectly.", 50, a.getAvgScore());
	}
}
