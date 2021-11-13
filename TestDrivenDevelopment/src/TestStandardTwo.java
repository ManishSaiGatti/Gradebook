import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;

public class TestStandardTwo {
	
	@Test
	public void testAddAllQuestions() {
		StandardTwo St2 = new StandardTwo(75);
		ArrayList<String> ques = new ArrayList<String>();
		ques.add("Hello? 75");
		ques.add("who is this? 85");
		ques.add("where are you? 95");
		St2.addAllQuestions(ques);
		assertEquals("The score is not 0", ques, St2.getQuestions());
	}
	
	@Test
	public void testAddIndividQ() {
		StandardTwo St2 = new StandardTwo(75);
		ArrayList<String> qs = new ArrayList<String>();
		qs.add("How is life? 85");
		St2.addIndividualQ("How is life? 85");
		assertEquals("It does not return an array of 1 question", qs, St2.getQuestions());
	}
	
	@Test
	public void testAddAllAnswers() {
		StandardTwo St2 = new StandardTwo(75);
		ArrayList<Boolean> ans = new ArrayList<Boolean>();
		ans.add(true);
		ans.add(false);
		ans.add(true);
		St2.addAllAnswers("Bob", ans);
		assertEquals("The score is not 0", ans, St2.getOneStuAnswers("Bob"));
	}
	
	@Test
	public void testAddIndividA() {
		StandardTwo St2 = new StandardTwo(75);
		St2.addIndividualA("Bob", true);
		assertEquals("The score is not 0", true, St2.getOneStuAnswers("Bob"));
	}
	
	@Test
	public void testGetQuestionWorth() {
		StandardTwo St2 = new StandardTwo(75);
		St2.addIndividualQ("Is it pink? 75");
		assertEquals("The score is not 75", 75, St2.getQuestionWorth(0));
	}
	
	@Test
	public void testGetRoster() {
		StandardTwo St2 = new StandardTwo(75);
		ArrayList<Boolean> ans = new ArrayList<Boolean>();
		ans.add(true);
		ans.add(false);
		ans.add(true);
		St2.addAllAnswers("Bob", ans);
		ArrayList<Boolean> ans2 = new ArrayList<Boolean>();
		ans.add(false);
		ans.add(true);
		ans.add(false);
		St2.addAllAnswers("Eric", ans2);
		List<String> ros = new ArrayList<String>();
		ros.add("Bob");
		ros.add("Eric");
		//assertEquals("The score is not 75", St2.getRoster(), ros);
		assertTrue(St2.getRoster().contains("Eric"));
	}
	
	@Test
	public void testEditQ() {
		StandardTwo St2 = new StandardTwo(75);
		St2.addIndividualQ("hello?");
		St2.editQuestions(0, "goodbye?");
		assertEquals("The question didn't edit correctly", "goodbye?", St2.getQuestions());
	}
	
	@Test
	public void testEditA() {
		StandardTwo St2 = new StandardTwo(75);
		HashMap<String, ArrayList<Boolean>> studentAnswer = new HashMap<String, ArrayList<Boolean>>();
		ArrayList<Boolean> ans = new ArrayList<Boolean>();
		ans.add(true);
		studentAnswer.put("Bob", ans);
		ArrayList<Boolean> ans2 = new ArrayList<Boolean>();
		ans2.add(false);
		studentAnswer.put("Mary", ans2);
		St2.editAnswers("Mary", 0, true);
		assertEquals("hashmap of all student answers is wrong", studentAnswer, St2.getAllStudentAnswers());
	}
	
	@Test
	public void testGetQs() {
		StandardTwo St2 = new StandardTwo(75);
		ArrayList<String> ques = new ArrayList<String>();
		ques.add("Hello? 75");
		ques.add("who is this? 85");
		ques.add("where are you? 95");
		St2.addAllQuestions(ques);
		assertEquals("the questions came out wrong", ques, St2.getQuestions());
	}
	
	@Test
	public void testGetAllA() {
		StandardTwo St2 = new StandardTwo(75);
		HashMap<String, ArrayList<Boolean>> studentAnswer = new HashMap<String, ArrayList<Boolean>>();
		ArrayList<Boolean> ans = new ArrayList<Boolean>();
		ans.add(true);
		studentAnswer.put("Bob", ans);
		ArrayList<Boolean> ans2 = new ArrayList<Boolean>();
		ans2.add(false);
		studentAnswer.put("Mary", ans2);
		assertEquals("hashmap of all student answers is wrong", studentAnswer, St2.getAllStudentAnswers());
	}
	
	@Test
	public void testGetOneA() {
		StandardTwo St2 = new StandardTwo(75);
		HashMap<String, ArrayList<Boolean>> studentAnswer = new HashMap<String, ArrayList<Boolean>>();
		ArrayList<Boolean> ans = new ArrayList<Boolean>();
		ans.add(true);
		studentAnswer.put("Bob", ans);
		System.out.println("ans is " + St2.getOneStuAnswers("Bob").get(0));
		assertEquals("hashmap with only one student answers is wrong", ans, St2.getOneStuAnswers("Bob"));
	}
	
	
}
