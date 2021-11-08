import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TextWriterTest {

	@Test
	public void testSaveRoster1() {
		TextWriter test = new TextWriter();
		Standard1 roster = new Standard1(2, 5);
		roster.setIndividualAnswer("test1", false);
		test.saveRoster(1100, roster);
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
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5);
		correct.setIndividualAnswer("test1", false);
		test.saveRoster(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
	
	@Test
	public void testSaveRoster2() {
		TextWriter test = new TextWriter();
		Standard1 roster = new Standard1(2, 5);
		roster.setIndividualAnswer("new test", false);
		test.saveRoster(1100, roster);
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
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5);
		correct.setIndividualAnswer("new test", false);
		test.saveRoster(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
	
	@Test
	public void testSaveRoster3() {
		TextWriter test = new TextWriter();
		Standard1 roster = new Standard1(2, 5);
		roster.setIndividualAnswer("para1", false);
		roster.setIndividualAnswer("para2", false);
		test.saveRoster(1100, roster);
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
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5);
		correct.setIndividualAnswer("para1", false);
		correct.setIndividualAnswer("para2", false);
		test.saveRoster(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
	
	@Test
	public void testSaveRoster4() {
		TextWriter test = new TextWriter();
		Standard1 roster = new Standard1(2, 5);
		roster.setIndividualAnswer("DANNY DEVITO", false);
		roster.setIndividualAnswer("GENO SMITH", false);
		test.saveRoster(1100, roster);
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
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5);
		correct.setIndividualAnswer("DANNY DEVITO", false);
		correct.setIndividualAnswer("GENO SMITH", false);
		test.saveRoster(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
	
	@Test
	public void testSaveStandard1() {
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5);
		correct.addIndividualQuestion("test1");
		test.saveStandard1("tester", correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStandard1("tester", null);
		assertEquals("The initial roster test failed", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStandard2() {
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5);
		correct.addIndividualQuestion("ME!!!");
		test.saveStandard1("tester", correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStandard1("tester", null);
		assertEquals("The initial roster test failed", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStandard3() {
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5);
		correct.addIndividualQuestion("paragraph");
		correct.addIndividualQuestion("another paragraph");
		test.saveStandard1("tester", correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStandard1("tester", null);
		assertEquals("The initial roster test failed", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStudentAnswersProper1() {
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5);
		correct.setIndividualAnswer("DANNY DEVITO", true);
		correct.setIndividualAnswer("DANNY DEVITO", false);
		correct.setIndividualAnswer("GENO SMITH", false);
		correct.setIndividualAnswer("GENO SMITH", false);
		test.saveRoster(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
	@Test
	public void testSaveRosterNothing() {
		TextWriter test = new TextWriter();
		Standard1 roster = new Standard1(2, 5);
		test.saveRoster(1100, roster);
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
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5);
		test.saveStandard1("tester", correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStandard1("tester", null);
		assertEquals("The initial roster test failed", correct.getQuestions(), answer.getQuestions());
	}
	
	@Test
	public void testSaveStudentAnswersNothing() {
		TextWriter test = new TextWriter();
		Standard1 correct = new Standard1(2, 5);
		test.saveRoster(1100, correct);
		test.saveStudentAnswers1("testStu", 1100, correct);
		TextReader reader = new TextReader();
		Standard1 answer = reader.loadStudentAnswers1("testStu", 1100, null);
		assertEquals("The initial roster test failed", correct.getAllAnswers(), answer.getAllAnswers());
	}
}