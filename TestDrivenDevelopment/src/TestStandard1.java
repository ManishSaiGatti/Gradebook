import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
public class TestStandard1 {
	
	@Test
	public void get1Question() {
		Standard1 firstStandard = new Standard1(0, 0);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		firstStandard.addQuestions(questions);
		assertEquals("One question in standard incorrectly saved", 
				questions, firstStandard.getQuestions());
	}
	
	@Test
	public void get2Question() {
		Standard1 firstStandard = new Standard1(0, 0);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		assertEquals("One question in standard incorrectly saved", 
				questions, firstStandard.getQuestions());
	}
	
	@Test
	public void get1Score() {
		Standard1 firstStandard = new Standard1(1, 2);
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
		Standard1 firstStandard = new Standard1(0, 0);
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
	
	@Test
	public void get2Score() {
		Standard1 firstStandard = new Standard1(1, 7);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		questions.add("Did the student give meaningful names to all their methods and"
				+ " variables?");
		questions.add("Did the student follow Java's naming standards?");
		questions.add("Did the student leave a blank line followed between all methods?");
		questions.add("Did the student include meaningful comments at the start of each method "
				+ "other than main?");
		questions.add("Did the student include short, meaningful comments where appropriate?");
		questions.add("Did the student complete the header at the top of their submitted .java "
				+ "files?");
		questions.add("Did the student use opening and closing curly braces correctly?");
		
		firstStandard.addQuestions(questions);
		ArrayList<Boolean> answers = new ArrayList<Boolean>();
		for(int i = 0; i < questions.size(); i++) {
			answers.add(true);
		}
		firstStandard.setAnswers("John", answers);
		assertEquals("Gave incorrect score for 1 student with 100%",
				firstStandard.getScore("John"), 100);
		answers.set(0, false);
		answers.set(1, false);
		firstStandard.setAnswers("Sally", answers);
		assertEquals("Gave incorrect score for 1 student with 95%",
				firstStandard.getScore("Sally"), 95);
		answers.set(2, false);
		firstStandard.setAnswers("Tom", answers);
		assertEquals("Gave incorrect score for 1 student with 85%",
				firstStandard.getScore("Tom"), 85);
		for(int i = 3; i < answers.size(); i++) {
			answers.set(i, false);
		}
		firstStandard.setAnswers("Fred", answers);
		assertEquals("Gave incorrect score for 1 student with 75%",
				firstStandard.getScore("Fred"), 75);
	}
}