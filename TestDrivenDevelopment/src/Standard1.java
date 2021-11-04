import java.util.*;
public class Standard1 {
	private final int numCorrect85;
	private final int numCorrect95;
	private ArrayList<String> questions;
	private HashMap<String, ArrayList<Boolean>> studentScores;
	
	public Standard1(int numCorrect85, int numCorrect95) {
		questions = new ArrayList<String>();
		studentScores = new HashMap<String, ArrayList<Boolean>>();
		this.numCorrect85 = numCorrect85;
		this.numCorrect95 = numCorrect95;
	}
	
	public void addQuestions(ArrayList<String> questions) {
		if(!this.questions.isEmpty()) {
			for(String s: questions) {
				if(!this.questions.contains(s)) {
					this.questions.add(s);
				}
			}
		} else {
			this.questions = questions;
		}
	}
	
	public void addIndividualQuestion(String question) {
		if(!questions.contains(question)) {
			questions.add(question);
		}
	}
	
	public ArrayList<String> getQuestions() {
		return questions;
	}
	
	public Set<String> getRoster() {
		return studentScores.keySet();
	}
	
	public void setAnswers(String student, ArrayList<Boolean> answers) {
		if(studentScores.containsKey(student)) {
			ArrayList<Boolean> currentAnswers = studentScores.get(student);
			answers.addAll(currentAnswers);
		}
		studentScores.put(student, answers);
	}
	
	public void setIndividualAnswer(String student, boolean answer) {
		ArrayList<Boolean> currentAnswers = studentScores.get(student);
		if(currentAnswers == null) {
			currentAnswers = new ArrayList<Boolean>();
		}
		currentAnswers.add(answer);
		studentScores.put(student, currentAnswers);
	}
	
	public int getScore(String student) {
		int numCorrect = 0;
		for(Boolean b: studentScores.get(student)) {
			if(b) {
				numCorrect++;
			}
		}
		if(numCorrect < numCorrect85) {
			return 75;
		} else if (numCorrect < numCorrect95) {
			return 85;
		} else if (numCorrect != questions.size()) {
			return 95;
		}
		return 100;
	}
	
	public void editQuestion(String oldQuestion, String newQuestion) {
		if(questions.contains(oldQuestion)) {
			questions.set(questions.indexOf(oldQuestion), newQuestion);
		}

	}
	
	public void editAnswer(String student, String question, boolean answer) {
		ArrayList<Boolean> studentAnswers = studentScores.get(student);
		int indexOfAnswer = questions.indexOf(question);
		if(indexOfAnswer >= 0 && studentAnswers != null) {
			studentAnswers.set(indexOfAnswer, answer);
		}
		studentScores.put(student, studentAnswers);
	}
}
