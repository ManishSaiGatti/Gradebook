import java.util.*;
public class Standard {
	private HashMap<String, ArrayList<String>> studentScore;
	private Set<String> roster;
	List<String> rosterArr;
    
	
	public Standard() {
		studentScore = new HashMap<String, ArrayList<String>>();
		roster = new HashSet<String>();
		rosterArr = new ArrayList<>();
		
	}
	
	// put student name, and question+answer into hashmap
	public void setIntScore(String student, String question, boolean correct) {
		ArrayList<String> questionAndAnswer = new ArrayList<String>();
		questionAndAnswer.add(question + " " + correct);
		studentScore.put(student, questionAndAnswer);
	}
	
	// get 
	public int getScore(String student) {
		ArrayList<String> questionsAndAnswers = studentScore.get(student);
		System.out.println(questionsAndAnswers);
		for(String s: questionsAndAnswers) {
			int i = Integer.parseInt(s.substring(s.length() - 3).trim());
			System.out.println(i);
			return i;
		}
		return 100;
	}
	
	public List<String> getRoster() {
		roster = studentScore.keySet();
		for (String i : roster) {
            rosterArr.add(i);
		}
		return rosterArr;
	}
}