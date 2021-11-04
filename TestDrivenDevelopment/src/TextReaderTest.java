import java.util.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TextReaderTest {
	@Test
    public void testStudentAnswers1() {
        TextReader test = new TextReader();
        HashMap<String, ArrayList<String>> answer = test.loadStudentAnswers("test", 1000);
        HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
        correct.put("test", new ArrayList<String>());
        assertEquals("Text exported is incorrect", correct, answer);
    }
	
	@Test
    public void testStandards1() {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadStandard("test");
        ArrayList<String> correct = new ArrayList<String>();
        correct.add("test");
        assertEquals("Text exported is incorrect", correct, answer);
    }
	
	@Test
    public void testStudentAnswers2() {
        TextReader test = new TextReader();
        HashMap<String, ArrayList<String>> answer = test.loadStudentAnswers("test2", 2000);
        HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
        correct.put("Name", new ArrayList<String>());
        correct.get("Name").add("hopefully this works :)");
        assertEquals("Text exported is incorrect", correct, answer);
    }
	
	@Test
    public void testStandards2() {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadStandard("test2");
        ArrayList<String> correct = new ArrayList<String>();
        correct.add("if this works");
        assertEquals("Text exported is incorrect", correct, answer);
    }
	
	@Test
    public void testStudentAnswers3() {
        TextReader test = new TextReader();
        HashMap<String, ArrayList<String>> answer = test.loadStudentAnswers("test3", 3000);
        HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
        correct.put("para1", new ArrayList<String>());
        correct.put("para2", new ArrayList<String>());
        assertEquals("Text exported is incorrect", correct, answer);
    }
	
	@Test
    public void testStandards3() {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadStandard("test3");
        ArrayList<String> correct = new ArrayList<String>();
        correct.add("para3");
        correct.add("para4");
        assertEquals("Text exported is incorrect", correct, answer);
    }
	
	@Test
    public void testRoster1() {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadRoster(1000);
        ArrayList<String> correct = new ArrayList<String>();
        correct.add("test");
        assertEquals("Text exported is incorrect", correct, answer);
    }
	
	@Test
    public void testRoster2() {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadRoster(2000);
        ArrayList<String> correct = new ArrayList<String>();
        correct.add("Name");
        assertEquals("Text exported is incorrect", correct, answer);
    }
    
    @Test
    public void testRoster3() {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadRoster(3000);
        ArrayList<String> correct = new ArrayList<String>();
        correct.add("para1");
        correct.add("para2");
        assertEquals("Text exported is incorrect", correct, answer);
    }
    
    @Test
    public void testRoster4() {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadRoster(4000);
        ArrayList<String> correct = new ArrayList<String>();
        correct.add("BRAD PITT");
        correct.add("MIKE TROUT");
        assertEquals("Text exported is incorrect", correct, answer);
    }
    
    @Test
    public void testStudentAnswers4() {
        TextReader test = new TextReader();
        HashMap<String, ArrayList<String>> answer = test.loadStudentAnswers("test4", 4000);
        HashMap<String, ArrayList<String>> correct = new HashMap<String, ArrayList<String>>();
        correct.put("BRAD PITT", new ArrayList<String>());
        correct.put("MIKE TROUT", new ArrayList<String>());
        correct.get("BRAD PITT").add("true");
        correct.get("BRAD PITT").add("false");
        correct.get("MIKE TROUT").add("false");
        correct.get("BRAD PITT").add("false");
        assertEquals("Text exported is incorrect", correct, answer);
    }
}
