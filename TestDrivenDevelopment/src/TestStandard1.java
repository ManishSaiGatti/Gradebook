import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.*;

import org.junit.Test;
public class TestStandard1 {
	
	@Test
	public void get1Question() {
		Standard1 firstStandard = new Standard1();
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		firstStandard.addQuestions(questions);
		assertEquals("One question in standard incorrectly saved", 
				questions, firstStandard.getQuestions());
	}
	
	@Test
	public void get2Question() {
		Standard1 firstStandard = new Standard1();
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		assertEquals("One question in standard incorrectly saved", 
				questions, firstStandard.getQuestions());
	}
	
	@Test
	public void get1Score() {
		Standard1 firstStandard = new Standard1();
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		ArrayList<Boolean> answers = new ArrayList<Boolean>();
		answers.add(true);
		answers.add(true);
		firstStandard.setAnswers("John", answers);
		assertEquals("Gave incorrect score for 1 student with 100%",
				firstStandard.getScore("John"), 100);
	}
	
	@Test
	public void testRoster() {
		Standard1 firstStandard = new Standard1();
		ArrayList<String> students = new ArrayList<String>();
		students.add("John");
		students.add("Sally");
		students.add("Tom");
		for(String s: students) {
			firstStandard.setAnswers(s, null);
		}
		//Checks the roster in firstStandard and student values have the same values, regardless
		//of order.
		boolean hasSameValues = true;
 		for(String s: firstStandard.getRoster()) {
 			if(!students.contains(s)) {
 				hasSameValues = false;
 			}
 		}
		assertTrue("Gave incorrect roster of 3 students", hasSameValues);
	}
	
}
