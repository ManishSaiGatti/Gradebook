import java.util.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TextWriterTest {

	@Test
	public void testSaveRoster1() throws IOException {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("test1");
		test.saveRoster(1100, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveRoster2() throws IOException {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("new test");
		test.saveRoster(1100, correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadRoster(1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveRoster3() throws IOException {
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
	public void testSaveRoster4() throws IOException {
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
	public void testSaveStandard1() throws IOException {
		TextWriter test = new TextWriter();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("test1");
		test.saveStandard("tester", correct);
		TextReader reader = new TextReader();
		ArrayList<String> answer = (ArrayList<String>)reader.loadStandard("tester");
		assertEquals("The initial roster test failed", correct, answer);
	}
	
	@Test
	public void testSaveStudentAnswers1() throws IOException {
		TextWriter test = new TextWriter();
		HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
		correct.put("test1", new ArrayList<String>());
		test.saveStudentAnswers("testStu", 1100, correct);
		TextReader reader = new TextReader();
		HashMap<String, ArrayList<String>> answer = reader.loadStudentAnswers("testStu", 1100);
		assertEquals("The initial roster test failed", correct, answer);
	}
}
