import java.util.*;
public class StandardTwo {
	// eg: "How are you? 75"
	List<String> questions;
	ArrayList<Boolean> trueOrFalse;
	// hashmap for student, arraylist<bboolean> that line up with questions' indices
	private HashMap<String, ArrayList<Boolean>> studentScore;
	private List<String> roster;
	
	
	public StandardTwo() {
		questions = new ArrayList<>();
		trueOrFalse = new ArrayList<>();
		studentScore = new HashMap<String, ArrayList<Boolean>>();
		roster = new ArrayList<>();
	}
	
	// put question and answers based on student name in hashmap
	public void setAnswers(String student, String question, boolean correct) {
		questions.add(question);
		trueOrFalse.add(correct);
		studentScore.put(student, trueOrFalse);
	}
	
	public void addStudent(String student) {
		ArrayList<Boolean> temp = new ArrayList<>();
		studentScore.put(student, temp);
	}
	
	public List<String> getRoster() {
		// need to return the set itself instead of a list
		Set<String> rosSet = new HashSet<String>();
		rosSet = studentScore.keySet();
		for(String x: rosSet) {
			roster.add(x);
		}
		return roster;
	}
	
	public List<Integer> getAllStudentScores() {
		ArrayList<Integer> allScores = new ArrayList<>();
		// for every student, calculate score
		for(int i = 0; i < roster.size(); i++) {
			allScores.add(calculateOneStudentTotal(roster.get(i)));
		}
		return allScores;
	}
	
	public int calculateOneStudentTotal(String student) {
		int totalScore = 0;
		for(int i = 0; i < trueOrFalse.size(); i++) {
			int worth = getQuestionWorth(i);
			// if student's answer for the specific question is null
			if(studentScore.get(student).get(i) == null) {
				//then break
				break;
			}
			// if student's answer for the specific question is true
			else if(studentScore.get(student).get(i) == true) {
				//then the total score is the worth
				totalScore = worth;
			}
		}
		return totalScore;
	}
	
	public List<String> getQuestions() {
		return questions;
	}
	
	public int getQuestionWorth(int index) {
		String strScore = "";
		int worth = 0;
		
		String q = questions.get(index);
		strScore = q.substring(q.length() - 3); 
		System.out.println("the score is " + strScore);
		worth = Integer.parseInt(strScore);
		System.out.println("score is " + worth);
		return worth;
	}
	
	public void editQuestions(int index, String newQ) {
		questions.set(index, newQ);
	}
	
	public void editAnswers(int index, boolean newA) {
		trueOrFalse.set(index, newA);
	}
	
}
