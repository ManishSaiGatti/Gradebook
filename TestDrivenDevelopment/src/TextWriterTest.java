import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TextWriterTest {

	@Test
	public void testSaveRoster1() {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("test1");
		test.saveRoster(1100, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStudentAnswers1() {
		TextWriter test = new TextWriter();
		ArrayList<String> roster = new ArrayList<String>();
		roster.add("test1");
		test.saveRoster(1100, roster);
		HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
		correct.put("test1", new ArrayList<String>());
		test.saveStudentAnswers("testStu", 1100, correct);
		TextReader reader = new TextReader();
		HashMap<String, ArrayList<String>> answer = reader.loadStudentAnswers("testStu", 1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveRoster2() {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("new test");
		test.saveRoster(1100, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStudentAnswers2() {
		TextWriter test = new TextWriter();
		ArrayList<String> roster = new ArrayList<String>();
		roster.add("new test");
		test.saveRoster(1100, roster);
		HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
		correct.put("new test", new ArrayList<String>());
		test.saveStudentAnswers("testStu", 1100, correct);
		TextReader reader = new TextReader();
		HashMap<String, ArrayList<String>> answer = reader.loadStudentAnswers("testStu", 1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveRoster3() {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("para1");
		correct.add("para2");
		test.saveRoster(1100, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStudentAnswers3() {
		TextWriter test = new TextWriter();
		ArrayList<String> roster = new ArrayList<String>();
		roster.add("para1");
		roster.add("para2");
		test.saveRoster(1100, roster);
		HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
		correct.put("para1", new ArrayList<String>());
		correct.put("para2", new ArrayList<String>());
		test.saveStudentAnswers("testStu", 1100, correct);
		TextReader reader = new TextReader();
		HashMap<String, ArrayList<String>> answer = reader.loadStudentAnswers("testStu", 1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveRoster4() {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("DANNY DEVITO");
		correct.add("GENO SMITH");
		test.saveRoster(1100, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStudentAnswers4() {
		TextWriter test = new TextWriter();
		ArrayList<String> roster = new ArrayList<String>();
		roster.add("DANNY DEVITO");
		roster.add("GENO SMITH");
		test.saveRoster(1100, roster);
		HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
		correct.put("DANNY DEVITO", new ArrayList<String>());
		correct.put("GENO SMITH", new ArrayList<String>());
		test.saveStudentAnswers("testStu", 1100, correct);
		TextReader reader = new TextReader();
		HashMap<String, ArrayList<String>> answer = reader.loadStudentAnswers("testStu", 1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStandard1() {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("test1");
		test.saveStandard("tester", correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadStandard("tester");
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStandard2() {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("ME!!!");
		test.saveStandard("tester", correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadStandard("tester");
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStandard3() {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("paragraph");
		correct.add("another paragraph");
		test.saveStandard("tester", correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadStandard("tester");
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStudentAnswersProper1() {
		TextWriter test = new TextWriter();
		ArrayList<String> roster = new ArrayList<String>();
		roster.add("DANNY DEVITO");
		roster.add("GENO SMITH");
		test.saveRoster(1100, roster);
		HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
		correct.put("DANNY DEVITO", new ArrayList<String>());
		correct.get("DANNY DEVITO").add("true");
		correct.get("DANNY DEVITO").add("false");
		correct.put("GENO SMITH", new ArrayList<String>());
		correct.get("GENO SMITH").add("false");
		correct.get("GENO SMITH").add("false");
		test.saveStudentAnswers("testStu", 1100, correct);
		TextReader reader = new TextReader();
		HashMap<String, ArrayList<String>> answer = reader.loadStudentAnswers("testStu", 1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	@Test
	public void testSaveRosterNothing() {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		test.saveRoster(1100, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStandardNothing() {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		test.saveStandard("tester", correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadStandard("tester");
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStudentAnswersNothing() {
		TextWriter test = new TextWriter();
		ArrayList<String> roster = new ArrayList<String>();
		test.saveRoster(1100, roster);
		HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
		test.saveStudentAnswers("testStu", 1100, correct);
		TextReader reader = new TextReader();
		HashMap<String, ArrayList<String>> answer = reader.loadStudentAnswers("testStu", 1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
}
