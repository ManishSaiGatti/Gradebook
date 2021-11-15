import java.util.*;
import java.io.*;

/*
 * Connor O'Rourke
 * 11/15/21
 * 
 * Test Driven Development Project
 * 
 * This class helps save the standard into a file for later use.
 */

public class TextWriter {
	
	public TextWriter() {
		
	}
	
	public void saveStandards(String fileName, List<String> standards) {
		if (standards == null) { //if no standards return
			return;
		}
		String[] splitName = fileName.split(" ");
        String newName = "standardNames/" + splitName[0].toLowerCase();
        for (int i = 1; i < splitName.length; i++) { //remove any spaces to fit the file name
        	newName += splitName[i].substring(0, 1).toUpperCase() + splitName[i].substring(1).toLowerCase();
        }
        newName += ".txt";
        String output = "";
        for (int i = 0; i < standards.size(); i++) {
        	output += standards.get(i) + "\n"; //add each standard name/type to output
        }
        try {
        	FileWriter writer = new FileWriter(newName);
            writer.write(output); //write into the file
            writer.close();
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void saveAll1(String standardName, int period, Standard1 standard) {
		saveStandard1(standardName, standard); //saves the question
		saveRoster1(period, standard); //saves the student roster
		saveStudentAnswers1(standardName, period, standard); //save the students and answers
	}
	
	public void saveAll2(String standardName, int period, StandardTwo standard) {
		saveStandard2(standardName, standard); //saves the question
		saveRoster2(period, standard); //saves the student roster
		saveStudentAnswers2(standardName, period, standard); //save the students and answers
	}
	
	public void saveAll3(String standardName, int period, Standard3 standard) {
		saveStandard3(standardName, standard); //saves the question
		saveRoster3(period, standard); //saves the student roster
		saveStudentAnswers3(standardName, period, standard); //save the students and answers
	}
	
	public void saveStandard1(String standardName, Standard1 standard) {
		if (standard == null) { //return with a empty input standard
			return;
		}
		String[] splitName = standardName.split(" ");
        String newName = "standards/";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt"; //format the inputted file name correctly
        ArrayList<String> questions = standard.getQuestions(); //get all the questions to save
        String output = "";
        output += standard.getWeight() + "\n" + standard.getNumCorrect85() + "\n" + standard.getNumCorrect95() + "\n";
        //^ the first two lines of the file are for the number of trues/falses to get a score
        for (int i = 0; i < questions.size(); i++) {
        	output += questions.get(i) + "\n"; //add each question to the output
        }
        try {
        	FileWriter writer = new FileWriter(newName);
            writer.write(output); //write into the file
            writer.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void saveStandard2(String standardName, StandardTwo standard) {
		if (standard == null) { //return with a empty input standard
			return;
		}
		String[] splitName = standardName.split(" ");
        String newName = "standards/";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt"; //format the inputted file name correctly
        ArrayList<String> questions = (ArrayList<String>)standard.getQuestions(); //get all the questions to save
        String output = standard.getWeight() + "\n";
        //^ the first two lines of the file are for the number of trues/falses to get a score
        for (int i = 0; i < questions.size(); i++) {
        	output += questions.get(i) + "\n"; //add each question to the output
        }
        try {
        	FileWriter writer = new FileWriter(newName);
            writer.write(output); //write into the file
            writer.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void saveStandard3(String standardName, Standard3 standard) {
		if (standard == null) { //return with a empty input standard
			return;
		}
		String[] splitName = standardName.split(" ");
        String newName = "standards/";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt"; //format the inputted file name correctly
        String output = standard.getWeight() + "\n" + standard.getQuestion(); //add the weight and question to output
        try {
        	FileWriter writer = new FileWriter(newName);
            writer.write(output); //write into the file
            writer.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void saveStudentAnswers1(String standardName, int period, Standard1 standard) {
		if (standard == null) { //return for a blank standard
			return;
		}
		String[] splitName = standardName.split(" ");
        String newName = "studentAnswers/";
        for (String s : splitName) {
        	newName += s;
        }
        newName += "period" + period + ".txt"; //properly format the file name/location
        String output = "";
        output += standard.getWeight() + "\n" + standard.getNumCorrect85() + "\n" + standard.getNumCorrect95() + "\n";
        //^ first two lines are cutoffs for a score
        Iterator<String> names = standard.getRoster().iterator(); //get all the student names
        while (names.hasNext()) {
        	String nameFirst = names.next();
        	String[] split = nameFirst.split(" ");
        	String name;
        	if (split.length > 1) {
        		name = split[1] + "," + split[0]; //change student name format from first last to last,first
        	}
        	else {
        		name = nameFirst;
        	}
        	output += name + "\n"; //add the student name to the output
        	ArrayList<Boolean> answers = standard.getStudentAnswers(nameFirst); //get all the answers for the student
        	if (answers == null) { //if the student has no answers skip to the next line
        		continue;
        	}
        	for (int c = 0; c < answers.size(); c++) {
        		output += answers.get(c) + "\n"; //add each answer to the output
        	}
        }
        try {
        	FileWriter writer = new FileWriter(newName);
            writer.write(output); //write the output in the file
            writer.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void saveStudentAnswers2(String standardName, int period, StandardTwo standard) {
		if (standard == null) { //return for a blank standard
			return;
		}
		String[] splitName = standardName.split(" ");
        String newName = "studentAnswers/";
        for (String s : splitName) {
        	newName += s;
        }
        newName += "period" + period + ".txt"; //properly format the file name/location
        String output = standard.getWeight() + "\n";
        Iterator<String> names = standard.getRoster().iterator(); //get all the student names
        while (names.hasNext()) {
        	String nameFirst = names.next();
        	String[] split = nameFirst.split(" ");
        	String name;
        	if (split.length > 1) {
        		name = split[1] + "," + split[0]; //change student name format from first last to last,first
        	}
        	else {
        		name = nameFirst;
        	}
        	output += name + "\n"; //add the student name to the output
        	ArrayList<Boolean> answers = standard.getOneStuAnswers(nameFirst); //get all the answers for the student
        	if (answers == null) { //if the student has no answers skip to the next line
        		continue;
        	}
        	for (int c = 0; c < answers.size(); c++) {
        		output += answers.get(c) + "\n"; //add each answer to the output
        	}
        }
        try {
        	FileWriter writer = new FileWriter(newName);
            writer.write(output); //write the output in the file
            writer.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void saveStudentAnswers3(String standardName, int period, Standard3 standard) {
		if (standard == null) { //return for a blank standard
			return;
		}
		String[] splitName = standardName.split(" ");
        String newName = "studentAnswers/";
        for (String s : splitName) {
        	newName += s;
        }
        newName += "period" + period + ".txt"; //properly format the file name/location
        String output = "";
        //^ first two lines are cutoffs for a score
        ArrayList<String> names = (ArrayList<String>)standard.getRoster(); //get all the student names
        for (int i = 0; i < names.size(); i++) {
        	String nameFirst = names.get(i);
        	String[] split = nameFirst.split(" ");
        	String name;
        	if (split.length > 1) {
        		name = split[1] + "," + split[0]; //change student name format from first last to last,first
        	}
        	else {
        		name = nameFirst;
        	}
        	output += name + "\n" + standard.getRawScore(nameFirst) + "\n"; //add the student's name and their answer to the output
        }
        try {
        	FileWriter writer = new FileWriter(newName);
            writer.write(output); //write the output in the file
            writer.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void saveRoster1(int period, Standard1 standard) {
		if (standard == null) { //return for a blank standard
			return;
		}
		String fileName = "roster/period" + period + ".txt"; //properly format the file name/location
		String output = "";
		Iterator<String> names = standard.getRoster().iterator(); //get all the student names
		while (names.hasNext()) {
			String[] splitName = names.next().split(" ");
			String newName;
			if (splitName.length > 1) {
				newName = splitName[1] + "," + splitName[0]; //change first last to last,first to save.
			}
			else {
				newName = splitName[0];
			}
			output += newName + "\n"; //add the name to the output
		}
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write(output); //write the output into the file
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveRoster2(int period, StandardTwo standard) {
		if (standard == null) { //return for a blank standard
			return;
		}
		String fileName = "roster/period" + period + ".txt"; //properly format the file name/location
		String output = "";
		Iterator<String> names = standard.getRoster().iterator(); //get all the student names
		while (names.hasNext()) {
			String[] splitName = names.next().split(" ");
			String newName;
			if (splitName.length > 1) {
				newName = splitName[1] + "," + splitName[0]; //change first last to last,first to save.
			}
			else {
				newName = splitName[0];
			}
			output += newName + "\n"; //add the name to the output
		}
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write(output); //write the output into the file
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveRoster3(int period, Standard3 standard) {
		if (standard == null) { //return for a blank standard
			return;
		}
		String fileName = "roster/period" + period + ".txt"; //properly format the file name/location
		String output = "";
		Iterator<String> names = standard.getRoster().iterator(); //get all the student names
		while (names.hasNext()) {
			String[] splitName = names.next().split(" ");
			String newName;
			if (splitName.length > 1) {
				newName = splitName[1] + "," + splitName[0]; //change first last to last,first to save.
			}
			else {
				newName = splitName[0];
			}
			output += newName + "\n"; //add the name to the output
		}
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write(output); //write the output into the file
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
