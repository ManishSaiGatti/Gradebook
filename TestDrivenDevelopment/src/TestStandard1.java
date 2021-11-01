import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
public class TestStandard1 {
	
	@Test
	public void get1Question() {
		Standard1 firstStandard = new Standard1();
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		firstStandard.addQuestions(questions);
		assertEquals("One question in standard incorrectly saved", 
				questions, firstStandard.getQuestions());
	}
	
	@Test
	public void get2Question() {
		Standard1 firstStandard = new Standard1();
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Did the student use conventional indentation and whitespace?");
		questions.add("Did the student keep their lines of code under 100 characters in length?");
		firstStandard.addQuestions(questions);
		assertEquals("One question in standard incorrectly saved", 
				questions, firstStandard.getQuestions());
	}
}
