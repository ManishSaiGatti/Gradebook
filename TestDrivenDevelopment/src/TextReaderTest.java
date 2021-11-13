import java.util.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TextReaderTest {
	@Test
    public void testStudentAnswers1() {
        TextReader test = new TextReader();
        Standard1 answer = test.loadStudentAnswers1("test", 1000, null);
        Standard1 correct = new Standard1(2, 5, 0.0);
        correct.setIndividualAnswer("test", false);
        assertEquals("Text exported is incorrect", correct.getAllAnswers(), answer.getAllAnswers());
    }
	
	@Test
    public void testStandards1() {
        TextReader test = new TextReader();
        Standard1 answer = test.loadStandard1("test", null);
        Standard1 correct = new Standard1(2, 5, 0.0);
        correct.addIndividualQuestion("test");
        assertEquals("Text exported is incorrect", correct.getQuestions(), answer.getQuestions());
    }
	
	@Test
    public void testStudentAnswers2() {
        TextReader test = new TextReader();
        Standard1 answer = test.loadStudentAnswers1("test2", 2000, null);
        Standard1 correct = new Standard1(2, 5, 0.0);
        correct.setIndividualAnswer("Name", false);
        assertEquals("Text exported is incorrect", correct.getAllAnswers(), answer.getAllAnswers());
    }
	
	@Test
    public void testStandards2() {
		TextReader test = new TextReader();
        Standard1 answer = test.loadStandard1("test2", null);
        Standard1 correct = new Standard1(2, 5, 0.0);
        correct.addIndividualQuestion("if this works");
        assertEquals("Text exported is incorrect", correct.getQuestions(), answer.getQuestions());
    }
	
	@Test
    public void testStudentAnswers3() {
        TextReader test = new TextReader();
        Standard1 answer = test.loadStudentAnswers1("test3", 3000, null);
        Standard1 correct = new Standard1(2, 5, 0.0);
        correct.setIndividualAnswer("para1", false);
        correct.setIndividualAnswer("para2", false);
        assertEquals("Text exported is incorrect", correct.getAllAnswers(), answer.getAllAnswers());
    }
	
	@Test
    public void testStandards3() {
		TextReader test = new TextReader();
        Standard1 answer = test.loadStandard1("test3", null);
        Standard1 correct = new Standard1(2, 5, 0.0);
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
        Standard1 correct = new Standard1(2, 5, 0.0);
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
        Standard1 correct = new Standard1(2, 5, 0.0);
        assertEquals("Text exported is incorrect", correct.getAllAnswers(), answer.getAllAnswers());
    }
	
	@Test
    public void testStandardsNothing() {
		TextReader test = new TextReader();
        Standard1 answer = test.loadStandard1("blank", null);
        Standard1 correct = new Standard1(2, 5, 0.0);
        assertEquals("Text exported is incorrect", correct.getQuestions(), answer.getQuestions());
    }
	
	@Test
    public void testRosterNothing() {
        TextReader test = new TextReader();
        ArrayList<String> answer = (ArrayList<String>)test.loadRoster(9999);
        ArrayList<String> correct = new ArrayList<String>();
        assertEquals("Text exported is incorrect", correct, answer);
    }
	
	@Test
	public void testLoadStan31() {
		TextReader test = new TextReader();
		Standard3 answer = test.loadStandard3("testStan3", null);
		Standard3 correct = new Standard3("me", 0);
		if (answer.getQuestion().equals(correct.getQuestion()) && answer.getWeight() == correct.getWeight()) {
			assertTrue("Failed standard3 test", true);
		}
		else {
			assertTrue("Failed standard3 test", false);
		}
	}
	
	@Test
	public void testLoadStan32() {
		TextReader test = new TextReader();
		Standard3 answer = test.loadStandard3("testStan32", null);
		Standard3 correct = new Standard3("test2", 0);
		if (answer.getQuestion().equals(correct.getQuestion()) && answer.getWeight() == correct.getWeight()) {
			assertTrue("Failed standard3 test", true);
		}
		else {
			assertTrue("Failed standard3 test", false);
		}
	}
	
	@Test
	public void testLoadStan3Blank() {
		TextReader test = new TextReader();
		Standard3 answer = test.loadStandard3("testStan3Blank", null);
		Standard3 correct = new Standard3("", 0);
		if (answer.getQuestion().equals(correct.getQuestion()) && answer.getWeight() == correct.getWeight()) {
			assertTrue("Failed standard3 test", true);
		}
		else {
			assertTrue("Failed standard3 test", false);
		}
	}
	
	@Test
	public void testLoadStan3StudentAnswers1() {
		TextReader test = new TextReader();
		Standard3 correct = new Standard3("test", 0);
		Standard3 answer = test.loadStudentAnswers3("testStan3", 1300, correct);
		correct.setStudentScore("hi", 1);
		assertEquals("Failed the standard3 student answers test", correct.getStudentScores(), answer.getStudentScores());
	}
	
	@Test
	public void testLoadStan3StudentAnswers2() {
		TextReader test = new TextReader();
		Standard3 correct = new Standard3("test", 0);
		Standard3 answer = test.loadStudentAnswers3("testStan3", 2300, correct);
		correct.setStudentScore("me", 2);
		assertEquals("Failed the standard3 student answers test", correct.getStudentScores(), answer.getStudentScores());
	}
	
	@Test
	public void testLoadStan3StudentAnswersFull() {
		TextReader test = new TextReader();
		Standard3 correct = new Standard3("test", 0);
		Standard3 answer = test.loadStudentAnswers3("testStan3", 3300, correct);
		correct.setStudentScore("me", 2);
		correct.setStudentScore("you", 3);
		assertEquals("Failed the standard3 student answers test", correct.getStudentScores(), answer.getStudentScores());
	}
	
	@Test
	public void testLoadStan3StudentAnswersBlank() {
		TextReader test = new TextReader();
		Standard3 correct = new Standard3("test", 0);
		Standard3 answer = test.loadStudentAnswers3("testStan3", 4300, correct);
		assertEquals("Failed the standard3 student answers test", correct.getStudentScores(), answer.getStudentScores());
	}
	
	@Test
	public void testLoadStandards1() {
		TextReader test = new TextReader();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("test");
		ArrayList<String> answer = (ArrayList<String>)test.loadStandards("test1");
		assertEquals("Failed the loadStandards test", correct, answer);
	}
	
	@Test
	public void testLoadStandards2() {
		TextReader test = new TextReader();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("me");
		ArrayList<String> answer = (ArrayList<String>)test.loadStandards("test2");
		assertEquals("Failed the loadStandards test", correct, answer);
	}
	
	@Test
	public void testLoadStandardsMultiple() {
		TextReader test = new TextReader();
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("me");
		correct.add("you");
		ArrayList<String> answer = (ArrayList<String>)test.loadStandards("test3");
		assertEquals("Failed the loadStandards test", correct, answer);
	}
	
	@Test
	public void testLoadStandardsBlank() {
		TextReader test = new TextReader();
		ArrayList<String> correct = new ArrayList<String>();
		ArrayList<String> answer = (ArrayList<String>)test.loadStandards("blank");
		assertEquals("Failed the loadStandards test", correct, answer);
	}
}
