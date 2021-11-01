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
}
