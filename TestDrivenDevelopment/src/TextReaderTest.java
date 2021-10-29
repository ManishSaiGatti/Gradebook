import java.util.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TextReaderTest {
	@Test
    public void testStudentAnswers1() throws IOException {
        TextReader test = new TextReader();
        String answer = test.loadStudentAnswers("test");
        assertEquals("Text exported is incorrect", "test", answer);
    }
	
	@Test
    public void testStandards1() throws IOException {
        TextReader test = new TextReader();
        String answer = test.loadStandard("test");
        assertEquals("Text exported is incorrect", "test", answer);
    }
	
	@Test
    public void testStudentAnswers2() throws IOException {
        TextReader test = new TextReader();
        String answer = test.loadStudentAnswers("test2");
        assertEquals("Text exported is incorrect", "hopefully this works :)", answer);
    }
	
	@Test
    public void testStandards2() throws IOException {
        TextReader test = new TextReader();
        String answer = test.loadStandard("test2");
        assertEquals("Text exported is incorrect", "if this works", answer);
    }
	
	@Test
    public void testStudentAnswers3() throws IOException {
        TextReader test = new TextReader();
        String answer = test.loadStudentAnswers("test3");
        assertEquals("Text exported is incorrect", "para1-para2", answer);
    }
	
	@Test
    public void testStandards3() throws IOException {
        TextReader test = new TextReader();
        String answer = test.loadStandard("test3");
        assertEquals("Text exported is incorrect", "para3-para4", answer);
    }
	
	@Test
    public void testRoster1() throws IOException {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadRoster(1000);
        ArrayList<String> correct = new ArrayList<String>();
        correct.add("test");
        assertEquals("Text exported is incorrect", correct, answer);
    }
	
	@Test
    public void testRoster2() throws IOException {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadRoster(2000);
        ArrayList<String> correct = new ArrayList<String>();
        correct.add("Name");
        assertEquals("Text exported is incorrect", correct, answer);
    }
    
    @Test
    public void testRoster3() throws IOException {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadRoster(3000);
        ArrayList<String> correct = new ArrayList<String>();
        correct.add("para5");
        correct.add("para6");
        assertEquals("Text exported is incorrect", correct, answer);
    }
    
    @Test
    public void testRoster4() throws IOException {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadRoster(4000);
        ArrayList<String> correct = new ArrayList<String>();
        correct.add("BRAD PITT");
        correct.add("MIKE TROUT");
        assertEquals("Text exported is incorrect", correct, answer);
    }
}
