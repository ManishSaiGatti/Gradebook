import java.util.*;
public class StandardTwo {
	// eg: "How are you? | 75"
	List<String> questions;
	List<Boolean> trueOrFalse;
	// hashmap for student, question and boolean or wtv
	private HashMap<String, ArrayList<String>> studentScore;
	// roster
	private Iterator<String> roster;
	//private Set<String> roster;
	//List<String> rosterArr;
	
	
	public StandardTwo() {
		questions = new ArrayList<>();
		trueOrFalse = new ArrayList<>();
		studentScore = new HashMap<String, ArrayList<String>>();
	}
	
	// put question and answers based on student name in hashmap
	public void setAnswers(String question, boolean correct) {
		questions.add(question);
		trueOrFalse.add(correct);
	}
	
	public Iterator<String> getRoster() {
		roster = studentScore.keySet().iterator();
		return roster;
	}
	
	public int getScore() {
		int i = 0;
		int score = 0;
		for(String q : questions) {
			//q is Did you code? | 75
			if(trueOrFalse.get(i) == true) {
				// parse question after | and make score = #
				String split[] = q.split("@");
				for(int j = 0; j < split.length; j++) {
					System.out.println("split is " + split[j]);
				}
		        for (String s: split) {
		            System.out.println(s);
		        	//score = s;
				}
			}
			i++;
		}
		return score;
	}
	
}
