import java.util.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TextReaderTest {
	@Test
    public void testStudentAnswers1() {
        TextReader test = new TextReader();
        Standard1 answer = test.loadStudentAnswers1("test", 1000, null);
        Standard1 correct = new Standard1(2, 5);
        correct.setIndividualAnswer("test", false);
        assertEquals("Text exported is incorrect", correct.getAllAnswers(), answer.getAllAnswers());
    }
	
	@Test
    public void testStandards1() {
        TextReader test = new TextReader();
        Standard1 answer = test.loadStandard1("test", null);
        Standard1 correct = new Standard1(2, 5);
        correct.addIndividualQuestion("test");
        assertEquals("Text exported is incorrect", correct.getQuestions(), answer.getQuestions());
    }
	
	@Test
    public void testStudentAnswers2() {
        TextReader test = new TextReader();
        Standard1 answer = test.loadStudentAnswers1("test2", 2000, null);
        Standard1 correct = new Standard1(2, 5);
        correct.setIndividualAnswer("Name", false);
        assertEquals("Text exported is incorrect", correct.getAllAnswers(), answer.getAllAnswers());
    }
	
	@Test
    public void testStandards2() {
		TextReader test = new TextReader();
        Standard1 answer = test.loadStandard1("test2", null);
        Standard1 correct = new Standard1(2, 5);
        correct.addIndividualQuestion("if this works");
        assertEquals("Text exported is incorrect", correct.getQuestions(), answer.getQuestions());
    }
	
	@Test
    public void testStudentAnswers3() {
        TextReader test = new TextReader();
        Standard1 answer = test.loadStudentAnswers1("test3", 3000, null);
        Standard1 correct = new Standard1(2, 5);
        correct.setIndividualAnswer("para1", false);
        correct.setIndividualAnswer("para2", false);
        assertEquals("Text exported is incorrect", correct.getAllAnswers(), answer.getAllAnswers());
    }
	
	@Test
    public void testStandards3() {
		TextReader test = new TextReader();
        Standard1 answer = test.loadStandard1("test3", null);
        Standard1 correct = new Standard1(2, 5);
        correct.addIndividualQuestion("para3");
        correct.addIndividualQuestion("para4");
        assertEquals("Text exported is incorrect", correct.getQuestions(), answer.getQuestions());
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
        Standard1 answer = test.loadStudentAnswers1("test4", 4000, null);
        Standard1 correct = new Standard1(2, 5);
        correct.setIndividualAnswer("BRAD PITT", true);
        correct.setIndividualAnswer("BRAD PITT", false);
        correct.setIndividualAnswer("MIKE TROUT", false);
        correct.setIndividualAnswer("BRAD PITT", false);
        assertEquals("Text exported is incorrect", correct.getAllAnswers(), answer.getAllAnswers());
    }
    
    @Test
    public void testStudentAnswersNothing() {
        TextReader test = new TextReader();
        Standard1 answer = test.loadStudentAnswers1("blank", 9999, null);
        Standard1 correct = new Standard1(2, 5);
        assertEquals("Text exported is incorrect", correct.getAllAnswers(), answer.getAllAnswers());
    }
	
	@Test
    public void testStandardsNothing() {
		TextReader test = new TextReader();
        Standard1 answer = test.loadStandard1("blank", null);
        Standard1 correct = new Standard1(2, 5);
        assertEquals("Text exported is incorrect", correct.getQuestions(), answer.getQuestions());
    }
	
	@Test
    public void testRosterNothing() {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadRoster(9999);
        ArrayList<String> correct = new ArrayList<String>();
        assertEquals("Text exported is incorrect", correct, answer);
    }
}
