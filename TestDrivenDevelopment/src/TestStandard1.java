import static org.junit.Assert.*;
import java.util.*;
import java.util.ArrayList;

import org.junit.Test;
public class TestStandard1 {
	
	//get1Question(): Calls setQuestion with an ArrayList of 1 question. 
	//Tests if getQuestions returns the same ArrayList
	@Test
	public void get1Question() {
		Standard1 firstStandard = new Standard1(0, 0);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		firstStandard.addQuestions(questions);
		assertEquals("One question in standard incorrectly saved", 
				questions, firstStandard.getQuestions());
	}
	
	//get2Question(): Calls setQuestion with an ArrayList of 2 questions. 
	//Tests of getQuestions returns the same ArrayList
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
	
	//get1Score(): Calls setQuestion with questions and giveScores with John and 2 trues. 
	//Tests if getScore for John returns 100%
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
		assertEquals("Gave incorrect score for 1 student with 100%", 100,
				firstStandard.getScore("John"));
	}
	
	//testRoster(): Checks if roster returned by getRoster is the same as the roster added
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
	
	//getManyScore(): Tests if multiple students with a particular number of questions right and 
	//wrong return corresponding number values
	@Test
	public void getManyScore() {
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
		assertEquals("Gave incorrect score for 1 student with 100%", 100,
				firstStandard.getScore("John"));
		answers.set(0, false);
		answers.set(1, false);
		firstStandard.setAnswers("Sally", answers);
		assertEquals("Gave incorrect score for 1 student with 95%", 95,
				firstStandard.getScore("Sally"));
		answers.set(2, false);
		firstStandard.setAnswers("Tom", answers);
		assertEquals("Gave incorrect score for 1 student with 85%", 85,
				firstStandard.getScore("Tom"));
		for(int i = 3; i < answers.size(); i++) {
			answers.set(i, false);
		}
		firstStandard.setAnswers("Fred", answers);
		assertEquals("Gave incorrect score for 1 student with 75%", 75,
				firstStandard.getScore("Fred"));
	}
	
	//testEditQuestion(): Checks if question saved to Standard1 can be edited properly
	@Test
	public void testEditQuestion() {
		Standard1 firstStandard = new Standard1(0, 0);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		firstStandard.addQuestions(questions);
		questions.clear();
		questions.add("Did the student use opening and closing curly braces correctly?");
		firstStandard.editQuestion("Did the student use conventional indentation and whitespace?"
				, "Did the student use opening and closing curly braces correctly?");
		assertEquals("One question in standard incorrectly saved and edited", 
				questions, firstStandard.getQuestions());
	}
	
	//testAddIndividualQuestion(): Tests if a new, individual question can be properly
	//added to an old set of questions
	@Test
	public void testAddIndividualQuestion() {
		Standard1 firstStandard = new Standard1(0, 0);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		firstStandard.addIndividualQuestion("Did the student follow Java's naming standards?");
		questions.add("Did the student follow Java's naming standards?");
		assertEquals("One individual question in standard incorrectly saved", 
				questions, firstStandard.getQuestions());
	}
	
	//testAddIndividualRepeatQuestion(): Tests if addIndividualQuestion() properly deals with
	//repeat questions passed into its parameters
	@Test
	public void testAddIndividualRepeatQuestion() {
		Standard1 firstStandard = new Standard1(0, 0);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		firstStandard.addIndividualQuestion("Did the student follow Java's naming standards?");
		firstStandard.addIndividualQuestion("Did the student use conventional indentation and"
				+ " whitespace?");
		questions.add("Did the student follow Java's naming standards?");
		assertEquals("Failed to test for repeated question", 
				questions, firstStandard.getQuestions());
	}
	
	//testNotExistingEditQuestion(): Checks if editQuestion properly handles an old question
	//parameter that doesn’t already exist
	@Test
	public void testNotExistingEditQuestion() {
		Standard1 firstStandard = new Standard1(0, 0);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		firstStandard.addQuestions(questions);
		firstStandard.editQuestion("Did the student complete the header at the top of their"
				+ " submitted .java files?"
				, "Did the student use opening and closing curly braces correctly?");
		assertEquals("Question that does not exist in editQuestion not properly handled", 
				questions, firstStandard.getQuestions());
	}
	
	//testEditStudentAnswers(): Checks if editAnswers properly changes an answer by checking
	//score
	@Test
	public void testEditStudentAnswer() {
		Standard1 firstStandard = new Standard1(1, 2);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student follow Java's naming standards?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		ArrayList<Boolean> answers = new ArrayList<Boolean>();
		answers.add(true);
		answers.add(true);
		answers.add(true);
		firstStandard.setAnswers("John", answers);
		firstStandard.editAnswer("John", questions.get(0), false);
		assertEquals("Failed to edit student answer", 95,
				firstStandard.getScore("John"));
	}
	
	//testEditAnswerNotExist(): Checks if editAnswers edits an answer for a question
	//that does not exist
	@Test
	public void testEditAnswerNotExist() {
		Standard1 firstStandard = new Standard1(1, 2);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student follow Java's naming standards?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		ArrayList<Boolean> answers = new ArrayList<Boolean>();
		answers.add(true);
		answers.add(true);
		answers.add(true);
		firstStandard.setAnswers("John", answers);
		firstStandard.editAnswer("John", "Did the student use opening and"
				+ " closing curly braces correctly?", false);
		assertEquals("Edited answer that doesn't exist", 100,
				firstStandard.getScore("John"));
	}
	
	//testEditStudentNotExist(): Checks if editAnswers edits a student’s answer if the
	//student parameter does not exist
	@Test
	public void testEditStudentNotExist() {
		Standard1 firstStandard = new Standard1(1, 2);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		ArrayList<Boolean> answers = new ArrayList<Boolean>();
		answers.add(true);
		answers.add(true);
		firstStandard.setAnswers("John", answers);
		firstStandard.editAnswer("Sally", "Did the student use conventional "
				+ "indentation and whitespace?", false);
		assertEquals("Gave incorrect score for 1 student with 100%", 100,
				firstStandard.getScore("John"));
	}
	
	//testAddMultipleQuestionSets(): Checks if addQuestions works when Standard1
	//already has some questions
	@Test
	public void testAddMultipleQuestionSets() {
		Standard1 firstStandard = new Standard1(0, 0);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		ArrayList<String> newQuestions = new ArrayList<String>();
		newQuestions.add("Did the student follow Java's naming standards?");
		firstStandard.addQuestions(newQuestions);
		questions.add("Did the student follow Java's naming standards?");
		assertEquals("Could not add more questions to those already existing", 
			questions, firstStandard.getQuestions());
	}
	
	//addDuplicateQuestionSets(): Checks if addQuestions adds the same question twice
	//to a set of existing questions
	@Test
	public void addDuplicateQuestionSets() {
		Standard1 firstStandard = new Standard1(0, 0);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		firstStandard.addQuestions(questions);
		firstStandard.addQuestions(questions);
		assertEquals("Added questions twice", 
				questions, firstStandard.getQuestions());
	}
	
	//addMoreAnswers(): Tests if add answers can account for old answers assigned for a student
	@Test
	public void addMoreAnswers() {
		Standard1 firstStandard = new Standard1(1, 2);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student follow Java's naming standards?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		ArrayList<Boolean> answers = new ArrayList<Boolean>();
		answers.add(true);
		answers.add(true);
		firstStandard.setAnswers("John", answers);
		ArrayList<Boolean> newAnswers = new ArrayList<Boolean>();
		newAnswers.add(false);
		firstStandard.setAnswers("John", newAnswers);
		assertEquals("Failed to add more answers to student", 95,
		firstStandard.getScore("John"));
	}
	
	//addIndividualAnswer(): runs setIndividualAnswer after adding other answers
	@Test
	public void addIndividualAnswer() {
		Standard1 firstStandard = new Standard1(1, 2);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student follow Java's naming standards?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		ArrayList<Boolean> answers = new ArrayList<Boolean>();
		answers.add(true);
		answers.add(true);
		firstStandard.setAnswers("John", answers);
		firstStandard.setIndividualAnswer("John", false);
		assertEquals("Failed to add more answers to student", 95,
		firstStandard.getScore("John"));
	}
	
	//setOneIndividualAnswer(): runs setIndividualAnswer initially to set the first answer value,
	//then again
	@Test
	public void setOneIndividualAnswer() {
		Standard1 firstStandard = new Standard1(1, 2);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		firstStandard.setIndividualAnswer("John", true);
		firstStandard.setIndividualAnswer("John", true);
		assertEquals("Gave incorrect score for 1 student with 100%", 100,
				firstStandard.getScore("John"));
	}
	
	//testGetNumForScore(): Tests that getNumCorrect85 and 95 returns the correct value based on
	//the one stored in the standard.
	@Test
	public void testGetNumForScore() {
		Standard1 firstStandard = new Standard1(1, 3);
		assertEquals("numCorrect85 incorrectly saved", 1, firstStandard.getNumCorrect85());
		assertEquals("numCorrect95 incorrectly saved", 3, firstStandard.getNumCorrect95());
	}
	
	//testGetAllAnswers(): Checks to make sure getAllAnswers returns the correct HashMap
	//of students and answers
	@Test
	public void testGetAllAnswers() {
		Standard1 firstStandard = new Standard1(1, 2);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		ArrayList<Boolean> answers = new ArrayList<Boolean>();
		answers.add(true);
		answers.add(true);
		firstStandard.setAnswers("John", answers);
		HashMap<String, ArrayList<Boolean>> studentScores = new HashMap<String, 
				ArrayList<Boolean>>();
		studentScores.put("John", answers);
		assertEquals("Return incorrect hashMap on getAllAnswers", studentScores, 
				firstStandard.getAllAnswers());
	}
	
	//testGetStudentAnswers(): Tests to see that getStudentAnswers returns an ArrayList
	//of all answers for a student
	@Test
	public void testGetStudentAnswers() {
		Standard1 firstStandard = new Standard1(1, 2);
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		ArrayList<Boolean> answers = new ArrayList<Boolean>();
		answers.add(true);
		answers.add(true);
		firstStandard.setAnswers("John", answers);
		assertEquals("Gave incorrect ArrayList of one student's answers", answers, 
				firstStandard.getStudentAnswers("John"));
		answers.set(0, false);
		firstStandard.setAnswers("Sally", answers);
		assertEquals("Gave incorrect ArrayList of another student's answers", answers, 
				firstStandard.getStudentAnswers("Sally"));
		
	}
}
