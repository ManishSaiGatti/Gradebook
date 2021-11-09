import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

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
	public void initializeStandard() {
		String q = "How much effort did the student put in (1-5)?";
		Standard3 s = new Standard3(q);
		assertEquals("Question was not stored correctly.", q, s.getQuestion());
		
		List<String> roster = new ArrayList<String>();
		assertEquals("Roster was not initialized correctly. It should be empty at first!", roster,  s.getRoster());
	}
	
	@Test
	public void addStudentNoScore() {
		String q = "How much effort did the student put in (1-5)?";
		Standard3 s = new Standard3(q);
		s.addStudent("Student 1");
		
		// test student was added to roster
		List<String> roster = new ArrayList<String>();
		roster.add("Student 1");
		assertEquals("Student was not added to roster.", roster, s.getRoster());
		
		// test student's initial raw score of -1 throws an error
		try {
			s.getScore("Student 1");
			
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("You have not given a student a score yet!", e.getMessage());
		}
	}
	
	@Test
	public void getStudentScoresValid() {
		String q = "How much effort did the student put in (1-5)?";
		Standard3 s = new Standard3(q);
		s.setStudentScore("s1", 5);
		s.setStudentScore("s2", 4);
		s.setStudentScore("s3", 3);
		s.setStudentScore("s4", 2);
		s.setStudentScore("s5", 1);
		
		// test that all students were added to roster correctly
		boolean containsStudent = true;
		List<String> roster = new ArrayList<String>(Arrays.asList("s1", "s2", "s3", "s4", "s5"));

		for (String currStudent: roster) {
			if (!s.getRoster().contains(currStudent)) {
				containsStudent = false;
			}
		}
		assertEquals("At least one student is missing from roster.", true, containsStudent);
		assertEquals("Incorrect number of students were added.", 5, s.getRoster().size());
		
		// test that each student's score was calculated correctly
		
		List<Integer> expectedScores = new ArrayList<Integer>(Arrays.asList(100, 95, 85, 75, 0));
		int i = 1;
		for (String student: roster) {
			assertEquals("Score for student was calculated incorrectly.",
					(int) expectedScores.get(i), s.getScore(student));
			i++;
		}
		// ^^ HERE - BC THE GETROSTER RETURNS RANDOM VARIABLE
	}
	
	// done/working on above, havent looked at below yet
		
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
	public void addStudentNoScorePart2QuestionMark() {
		Standard3 s = new Standard3("Question");
		String stu1 = "Student 1";
		s.addStudent(stu1);
		assertEquals("Student (no score given) not added correctly.", s.getRoster().get(0), stu1);
		assertEquals("Student's score (no score given) not set correctly.", (int) s.getStudentScores().get(0), -1);
	}
	
	
}
