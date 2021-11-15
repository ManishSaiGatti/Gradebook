// Catherine Yu

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class Standard3Test {	
	// tests all values are correctly initialized if no students were added
	@Test
	public void initializeStandard() {
		String q = "How much effort did the student put in (1-5)?";
		Standard3 s = new Standard3(q, 100.0);
		assertEquals("Question was not stored correctly.", q, s.getQuestion());
		assertEquals("Weight was not stored correctly.", 100, s.getWeight(), 0.01);
		
		List<String> roster = new ArrayList<String>();
		assertEquals("Roster was not initialized correctly. It should be empty at first!",
				roster,  s.getRoster());
	}
	
	// makes sure student can be added correctly
	// cannot call getScore if the student doesn't have a grade assigned yet
	@Test
	public void addStudentNoScore() {
		String q = "How much effort did the student put in (1-5)?";
		Standard3 s = new Standard3(q, 100);
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
	
	// tests for correct matching of student raw score --> actual score
	// and roster was correctly updated
	@Test
	public void getStudentScoresValid() {
		String q = "How much effort did the student put in (1-5)?";
		Standard3 s = new Standard3(q, 100);
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
				
		// test that getStudentScores lines up with roster and scores were calculated correctly
		HashMap<Integer, Integer> rawScoreConversions = new HashMap<Integer, Integer>() {{
			// key: rawScore, value: converted score
			put(5, 100);
			put(4, 95);
			put(3, 85);
			put(2, 75);
			put(1, 0);
		}};
		
		for (String student: s.getRoster()) {
			assertEquals("Score for " + student + " was not calculated correctly/",
					(int) rawScoreConversions.get(s.getRawScore(student)), s.getScore(student));
		}
	}
		
	@Test
	public void editQuestion() {
		String q = "How much effort did the student put in (1-5)?";
		Standard3 s = new Standard3(q, 100);
		
		// edit question
		String newQ = "How well doe the student do overall (1-5)?";
		s.editQuestion(newQ);
		assertEquals("Question was not edited correctly.", newQ, s.getQuestion());
	}
	
	// cannot call getScore if a student does not exist
	@Test
	public void getScoreStudentDoesntExist() {
		String q = "How much effort did the student put in (1-5)?";
		Standard3 s = new Standard3(q, 100);

		// test if calling getScore on a student that doesn't exist results in an error
		try {
			s.getScore("Student");
			
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Student does not exist yet.", e.getMessage());
		}

	}	
}
