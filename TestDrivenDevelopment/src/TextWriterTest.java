import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

/*
 * Connor O'Rourke
 * 11/15/21
 * Test Driven Development Project
 * 
 * This class has all the test cases for the TextWriter class.
 */

public class TextWriterTest {

	@Test
	public void testSaveRoster1() {
		//Tests a simple word in standard1 to save
		TextWriter test = new TextWriter();
		Standard1 roster = new Standard1(2, 5, 0.0);
		roster.setIndividualAnswer("test1", false);
		test.saveRoster1(1100, roster);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		Iterator<String> itr = roster.getRoster().iterator();
		ArrayList<String> correct = new ArrayList<String>();
		while (itr.hasNext()) {
			correct.add(itr.next());
		}
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStudentAnswers1() {
		//Tests a simple word and answer to save for standard 1
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5, 0.0);
		correct.setIndividualAnswer("test1", false);
		test.saveRoster1(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
	
	@Test
	public void testSaveRoster2() {
		//Tests a different word to save for standard 1
		TextWriter test = new TextWriter();
		Standard1 roster = new Standard1(2, 5, 0.0);
		roster.setIndividualAnswer("new test", false);
		test.saveRoster1(1100, roster);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		Iterator<String> itr = roster.getRoster().iterator();
		ArrayList<String> correct = new ArrayList<String>();
		while (itr.hasNext()) {
			correct.add(itr.next());
		}
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStudentAnswers2() {
		//Tests a different word-answer combo to save for standard 1
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5, 0.0);
		correct.setIndividualAnswer("new test", false);
		test.saveRoster1(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
	
	@Test
	public void testSaveRoster3() {
		//Tests saving multiple words for standard 1
		TextWriter test = new TextWriter();
		Standard1 roster = new Standard1(2, 5, 0.0);
		roster.setIndividualAnswer("para1", false);
		roster.setIndividualAnswer("para2", false);
		test.saveRoster1(1100, roster);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		Iterator<String> itr = roster.getRoster().iterator();
		ArrayList<String> correct = new ArrayList<String>();
		while (itr.hasNext()) {
			correct.add(itr.next());
		}
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStudentAnswers3() {
		//Tests saving multiple word-answer pairs in standard 1
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5, 0.0);
		correct.setIndividualAnswer("para1", false);
		correct.setIndividualAnswer("para2", false);
		test.saveRoster1(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
	
	@Test
	public void testSaveRoster4() {
		//Tests saving multiple names with the proper formatting
		TextWriter test = new TextWriter();
		Standard1 roster = new Standard1(2, 5, 0.0);
		roster.setIndividualAnswer("DANNY DEVITO", false);
		roster.setIndividualAnswer("GENO SMITH", false);
		test.saveRoster1(1100, roster);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		Iterator<String> itr = roster.getRoster().iterator();
		ArrayList<String> correct = new ArrayList<String>();
		while (itr.hasNext()) {
			correct.add(itr.next());
		}
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStudentAnswers4() {
		//tests saving student-answer pairs with the proper name formatting
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5, 0.0);
		correct.setIndividualAnswer("DANNY DEVITO", false);
		correct.setIndividualAnswer("GENO SMITH", false);
		test.saveRoster1(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
	
	@Test
	public void testSaveStandard1() {
		//Tests saving a question in standard 1
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5, 0.0);
		correct.addIndividualQuestion("test1");
		test.saveStandard1("tester", correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStandard1("tester", null);
		assertEquals("The initial roster test failed", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStandard2() {
		//Tests saving a different question in standard 1
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5, 0.0);
		correct.addIndividualQuestion("ME!!!");
		test.saveStandard1("tester", correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStandard1("tester", null);
		assertEquals("The initial roster test failed", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStandard3() {
		//Tests saving multiple questions in standard 1
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5, 0.0);
		correct.addIndividualQuestion("paragraph");
		correct.addIndividualQuestion("another paragraph");
		test.saveStandard1("tester", correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStandard1("tester", null);
		assertEquals("The initial roster test failed", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStudentAnswersProper1() {
		//Tests saving multiple students and answers in standard 1
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5, 0.0);
		correct.setIndividualAnswer("DANNY DEVITO", true);
		correct.setIndividualAnswer("DANNY DEVITO", false);
		correct.setIndividualAnswer("GENO SMITH", false);
		correct.setIndividualAnswer("GENO SMITH", false);
		test.saveRoster1(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
	@Test
	public void testSaveRosterNothing() {
		//Tests saving no student names in standard 1
		TextWriter test = new TextWriter();
		Standard1 roster = new Standard1(2, 5, 0.0);
		test.saveRoster1(1100, roster);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		Iterator<String> itr = roster.getRoster().iterator();
		ArrayList<String> correct = new ArrayList<String>();
		while (itr.hasNext()) {
			correct.add(itr.next());
		}
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStandardNothing() {
		//Tests saving no questions in standard 1
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5, 0.0);
		test.saveStandard1("tester", correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStandard1("tester", null);
		assertEquals("The initial roster test failed", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStudentAnswersNothing() {
		//Tests saving no students nor answers in standard 1
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5, 0.0);
		test.saveRoster1(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
	
	@Test
	public void testSaveStandards1() {
		//Tests saving a standard name + type
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("test");
		test.saveStandards("testStu", correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadStandards("testStu");
		assertEquals("The standards list test failed", correct, answer);
	}
	
	@Test
	public void testSaveStandards2() {
		//tests saving a different standard name + type
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("another");
		test.saveStandards("testStu", correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadStandards("testStu");
		assertEquals("The standards list test failed", correct, answer);
	}
	
	@Test
	public void testSaveStandards3() {
		//tests saving multiple standard names + types
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("para1");
		correct.add("para2");
		test.saveStandards("testStu", correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadStandards("testStu");
		assertEquals("The standards list test failed", correct, answer);
	}
	
	@Test
	public void testSaveStandardsNothing() {
		//Tests saving no standard name nor type
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		test.saveStandards("testStu", correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadStandards("testStu");
		assertEquals("The standards list test failed", correct, answer);
	}
	
	@Test
	public void testSaveStan31() {
		//Tests saving a question in standard 3
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("test1", 2.0);
		test.saveStandard3("testStan3", correct);
		TextReader reader = new TextReader();
		Standard3 answer = reader.loadStandard3("testStan3", null);
		if (answer.getQuestion().equals(correct.getQuestion()) && answer.getWeight() == correct.getWeight()) {
			assertTrue("Failed standard3 test", true);
		}
		else {
			assertTrue("Failed standard3 test", false);
		}
	}
	
	@Test
	public void testSaveStan32() {
		//tests saving a different question in standard 3
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("me", 0.0);
		test.saveStandard3("testStan3", correct);
		TextReader reader = new TextReader();
		Standard3 answer = reader.loadStandard3("testStan3", null);
		if (answer.getQuestion().equals(correct.getQuestion()) && answer.getWeight() == correct.getWeight()) {
			assertTrue("Failed standard3 test", true);
		}
		else {
			assertTrue("Failed standard3 test", false);
		}
	}
	
	@Test
	public void testSaveStan3Blank() {
		//tests saving no questions for standard 3
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("", 0.0);
		test.saveStandard3("testStan3", correct);
		TextReader reader = new TextReader();
		Standard3 answer = reader.loadStandard3("testStan3", null);
		if (answer.getQuestion().equals(correct.getQuestion()) && answer.getWeight() == correct.getWeight()) {
			assertTrue("Failed standard3 test", true);
		}
		else {
			assertTrue("Failed standard3 test", false);
		}
	}
	
	@Test
	public void testSaveStan3Roster1() {
		//tests saving a name from standard 3
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("me", 0.0);
		correct.addStudent("jim");
		test.saveRoster3(1333, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1333);
		ArrayList<String> list = (ArrayList<String>)correct.getRoster();
		assertEquals("Failed the standard3 roster test", list, answer);
	}
	
	@Test
	public void testSaveStan3Roster2() {
		//tests saving a different name from standard 3
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("me", 0.0);
		correct.addStudent("joe");
		test.saveRoster3(1333, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1333);
		ArrayList<String> list = (ArrayList<String>)correct.getRoster();
		assertEquals("Failed the standard3 roster test", list, answer);
	}
	
	@Test
	public void testSaveStan3RosterMultiple() {
		//tests saving multiple names from standard 3
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("me", 0.0);
		correct.addStudent("jim");
		correct.addStudent("joe");
		test.saveRoster3(1333, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1333);
		ArrayList<String> list = (ArrayList<String>)correct.getRoster();
		assertEquals("Failed the standard3 roster test", list, answer);
	}
	
	@Test
	public void testSaveStan3RosterProper() {
		//tests saving multiple names from standard 3 with proper formatting
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("me", 0.0);
		correct.addStudent("JOE BIDEN");
		correct.addStudent("BARACK OBAMA");
		test.saveRoster3(1333, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1333);
		ArrayList<String> list = (ArrayList<String>)correct.getRoster();
		assertEquals("Failed the standard3 roster test", list, answer);
	}
	
	@Test
	public void testSaveStan3RosterBlank() {
		//tests saving no names from standard 3
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("me", 0.0);
		test.saveRoster3(1333, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1333);
		ArrayList<String> list = (ArrayList<String>)correct.getRoster();
		assertEquals("Failed the standard3 roster test", list, answer);
	}
	
	@Test
	public void testSaveStan3StudentAnswers1() {
		//tests saving a student - answer pair from standard 3
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("test", 0.0);
		correct.setStudentScore("me", 3);
		test.saveStudentAnswers3("testStan3", 1333, correct);
		test.saveRoster3(1333, correct);
		TextReader reader = new TextReader();
		Standard3 answer = reader.loadStudentAnswers3("testStan3", 1333, new Standard3("test", 0.0));
		if (answer.getRoster().equals(correct.getRoster()) && answer.getStudentScores().equals(correct.getStudentScores())) {
			assertTrue("Failed standard3 test", true);
		}
		else {
			assertTrue("Failed standard3 test", false);
		}
	}
	
	@Test
	public void testSaveStan3StudentAnswers2() {
		//tests saving a different student - answer pair from standard 3
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("test", 0.0);
		correct.setStudentScore("test", 4);
		test.saveStudentAnswers3("testStan3", 1333, correct);
		test.saveRoster3(1333, correct);
		TextReader reader = new TextReader();
		Standard3 answer = reader.loadStudentAnswers3("testStan3", 1333, new Standard3("test", 0.0));
		if (answer.getRoster().equals(correct.getRoster()) && answer.getStudentScores().equals(correct.getStudentScores())) {
			assertTrue("Failed standard3 test", true);
		}
		else {
			assertTrue("Failed standard3 test", false);
		}
	}
	
	@Test
	public void testSaveStan3StudentAnswersMultiple() {
		//tests saving multiple student - answer pairs from Standard 3
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("test", 0.0);
		correct.setStudentScore("me", 3);
		correct.setStudentScore("you", 1);
		test.saveStudentAnswers3("testStan3", 1333, correct);
		test.saveRoster3(1333, correct);
		TextReader reader = new TextReader();
		Standard3 answer = reader.loadStudentAnswers3("testStan3", 1333, new Standard3("test", 0.0));
		if (answer.getRoster().equals(correct.getRoster()) && answer.getStudentScores().equals(correct.getStudentScores())) {
			assertTrue("Failed standard3 test", true);
		}
		else {
			assertTrue("Failed standard3 test", false);
		}
	}
	
	@Test
	public void testSaveStan3StudentAnswersProper() {
		//tests saving multiple student - answer pairs from Standard 3 with proper names
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("test", 0.0);
		correct.setStudentScore("SENOR SENOR", 3);
		correct.setStudentScore("WILL SMITH", 1);
		test.saveStudentAnswers3("testStan3", 1333, correct);
		test.saveRoster3(1333, correct);
		TextReader reader = new TextReader();
		Standard3 answer = reader.loadStudentAnswers3("testStan3", 1333, new Standard3("test", 0.0));
		if (answer.getRoster().equals(correct.getRoster()) && answer.getStudentScores().equals(correct.getStudentScores())) {
			assertTrue("Failed standard3 test", true);
		}
		else {
			assertTrue("Failed standard3 test", false);
		}
	}
	
	@Test
	public void testSaveStan3StudentAnswersBlank() {
		//tests saving no student - answer pairs
		TextWriter test = new TextWriter();
		Standard3 correct = new Standard3("test", 0.0);
		test.saveStudentAnswers3("testStan3", 1333, correct);
		test.saveRoster3(1333, correct);
		TextReader reader = new TextReader();
		Standard3 answer = reader.loadStudentAnswers3("testStan3", 1333, new Standard3("test", 0.0));
		if (answer.getRoster().equals(correct.getRoster()) && answer.getStudentScores().equals(correct.getStudentScores())) {
			assertTrue("Failed standard3 test", true);
		}
		else {
			assertTrue("Failed standard3 test", false);
		}
	}
	
	@Test
	public void testSaveStan21() {
		//tests saving a question for standard 2
		TextWriter test = new TextWriter();
		StandardTwo correct = new StandardTwo(0.0);
		correct.addIndividualQ("test");
		test.saveStandard2("testStan2write", correct);
		TextReader reader = new TextReader();
		StandardTwo answer = reader.loadStandard2("testStan2write", null);
		assertEquals("failed test for save standard 2", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStan22() {
		//tests saving a different question for standard 2
		TextWriter test = new TextWriter();
		StandardTwo correct = new StandardTwo(0.0);
		correct.addIndividualQ("me");
		test.saveStandard2("testStan2write", correct);
		TextReader reader = new TextReader();
		StandardTwo answer = reader.loadStandard2("testStan2write", null);
		assertEquals("failed test for save standard 2", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStan2Multiple() {
		//tests saving multiple questions from standard 2
		TextWriter test = new TextWriter();
		StandardTwo correct = new StandardTwo(0.0);
		correct.addIndividualQ("you");
		correct.addIndividualQ("me");
		test.saveStandard2("testStan2write", correct);
		TextReader reader = new TextReader();
		StandardTwo answer = reader.loadStandard2("testStan2write", null);
		assertEquals("failed test for save standard 2", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStan2Blank() {
		//tests savign no questions from standard 2
		TextWriter test = new TextWriter();
		StandardTwo correct = new StandardTwo(0.0);
		test.saveStandard2("testStan2write", correct);
		TextReader reader = new TextReader();
		StandardTwo answer = reader.loadStandard2("testStan2write", null);
		assertEquals("failed test for save standard 2", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStan2StudentAnswers1() {
		//tests saving a student - answer pair from standard 2
		TextWriter test = new TextWriter();
		StandardTwo correct = new StandardTwo(0.0);
		correct.addIndividualA("me", true);
		test.saveRoster2(1222, correct);
		test.saveStudentAnswers2("testStan2", 1222, correct);
		TextReader reader = new TextReader();
		StandardTwo answer = reader.loadStudentAnswers2("testStan2", 1222, null);
		assertEquals("failed test for save student answers 2", correct.getAllStudentAnswers(), answer.getAllStudentAnswers());
	}
	
	@Test
	public void testSaveStan2StudentAnswers2() {
		//tests saving a different student - answer pair from standard 2
		TextWriter test = new TextWriter();
		StandardTwo correct = new StandardTwo(0.0);
		correct.addIndividualA("tom", true);
		test.saveRoster2(1222, correct);
		test.saveStudentAnswers2("testStan2", 1222, correct);
		TextReader reader = new TextReader();
		StandardTwo answer = reader.loadStudentAnswers2("testStan2", 1222, null);
		assertEquals("failed test for save student answers 2", correct.getAllStudentAnswers(), answer.getAllStudentAnswers());
	}
	
	@Test
	public void testSaveStan2StudentAnswersMultiple() {
		//tests saving multiple student - answer pairs from standard 2
		TextWriter test = new TextWriter();
		StandardTwo correct = new StandardTwo(0.0);
		correct.addIndividualA("mario", true);
		correct.addIndividualA("luigi", false);
		test.saveRoster2(1222, correct);
		test.saveStudentAnswers2("testStan2", 1222, correct);
		TextReader reader = new TextReader();
		StandardTwo answer = reader.loadStudentAnswers2("testStan2", 1222, null);
		assertEquals("failed test for save student answers 2", correct.getAllStudentAnswers(), answer.getAllStudentAnswers());
	}
	
	@Test
	public void testSaveStan2StudentAnswersProper() {
		//tests saving multiple student - answer pairs from standard 2 with proper names
		TextWriter test = new TextWriter();
		StandardTwo correct = new StandardTwo(0.0);
		correct.addIndividualA("MARIO MARIO", true);
		correct.addIndividualA("LUIGI MARIO", false);
		test.saveRoster2(1222, correct);
		test.saveStudentAnswers2("testStan2", 1222, correct);
		TextReader reader = new TextReader();
		StandardTwo answer = reader.loadStudentAnswers2("testStan2", 1222, null);
		assertEquals("failed test for save student answers 2", correct.getAllStudentAnswers(), answer.getAllStudentAnswers());
	}
	
	@Test
	public void testSaveStan2StudentAnswersBlank() {
		//tests saving no student names no answers for standard 2
		TextWriter test = new TextWriter();
		StandardTwo correct = new StandardTwo(0.0);
		test.saveRoster2(1222, correct);
		test.saveStudentAnswers2("testStan2", 1222, correct);
		TextReader reader = new TextReader();
		StandardTwo answer = reader.loadStudentAnswers2("testStan2", 1222, null);
		assertEquals("failed test for save student answers 2", correct.getAllStudentAnswers(), answer.getAllStudentAnswers());
	}
	
	@Test
	public void testSaveRoster21() {
		//tests saving a student name from standard 2
		TextWriter test = new TextWriter();
		StandardTwo roster = new StandardTwo(0.0);
		roster.addIndividualA("me", true);
		test.saveRoster2(1222, roster);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1222);
		Iterator<String> itr = roster.getRoster().iterator();
		ArrayList<String> correct = new ArrayList<String>();
		while (itr.hasNext()) {
			correct.add(itr.next());
		}
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveRoster22() {
		//tests saving a different student name from standard 2
		TextWriter test = new TextWriter();
		StandardTwo roster = new StandardTwo(0.0);
		roster.addIndividualA("tom", true);
		test.saveRoster2(1222, roster);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1222);
		Iterator<String> itr = roster.getRoster().iterator();
		ArrayList<String> correct = new ArrayList<String>();
		while (itr.hasNext()) {
			correct.add(itr.next());
		}
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveRoster2Multiple() {
		//tests saving multiple student names from standard 2
		TextWriter test = new TextWriter();
		StandardTwo roster = new StandardTwo(0.0);
		roster.addIndividualA("mario", true);
		roster.addIndividualA("luigi", false);
		test.saveRoster2(1222, roster);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1222);
		Iterator<String> itr = roster.getRoster().iterator();
		ArrayList<String> correct = new ArrayList<String>();
		while (itr.hasNext()) {
			correct.add(itr.next());
		}
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveRoster2Proper() {
		//tests saving multiple student names from standard 2 with proper names
		TextWriter test = new TextWriter();
		StandardTwo roster = new StandardTwo(0.0);
		roster.addIndividualA("MARIO MARIO", true);
		roster.addIndividualA("LUIGI MARIO", false);
		test.saveRoster2(1222, roster);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1222);
		Iterator<String> itr = roster.getRoster().iterator();
		ArrayList<String> correct = new ArrayList<String>();
		while (itr.hasNext()) {
			correct.add(itr.next());
		}
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveRoster2Nothing() {
		//tests saving no student name from standard 2
		TextWriter test = new TextWriter();
		StandardTwo roster = new StandardTwo(0.0);
		test.saveRoster2(1222, roster);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1222);
		Iterator<String> itr = roster.getRoster().iterator();
		ArrayList<String> correct = new ArrayList<String>();
		while (itr.hasNext()) {
			correct.add(itr.next());
		}
		assertEquals("The initial roster test failed", correct, answer);
	}
}
