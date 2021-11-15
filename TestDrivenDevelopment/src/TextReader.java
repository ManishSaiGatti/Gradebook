
import java.util.*;
import java.io.*;

/*
 * Connor O'Rourke
 * 11/15/21
 * Test Driven Development Project
 * 
 * This class reads the text from the files and puts them into a standard.
 */
public class TextReader {
    
    public TextReader() {
    	
    }
    
    public List<String> loadStandards(String fileName) {
    	String[] splitName = fileName.split(" ");
        String newName = "standardNames/" + splitName[0].toLowerCase();
        for (int i = 1; i < splitName.length; i++) { //remove any spaces to fit the file name
        	newName += splitName[i].substring(0, 1).toUpperCase() + splitName[i].substring(1).toLowerCase();
        	// ^ camel casing
        }
        newName += ".txt";
    	try {
    		BufferedReader input = new BufferedReader(new FileReader(newName));
    		ArrayList<String> output = new ArrayList<String>(); //list of standard names
    		while (input.ready()) {
    			output.add(input.readLine()); //for each new line add the text to the list
    		}
    		return output;
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public Standard1 loadAllStandard1 (String standardName, int period, Standard1 standard) {
    	Standard1 output = loadStandard1(standardName, standard); //loads the questions
    	output = loadStudentAnswers1(standardName, period, output); //loads the students and their answers
    	return output;
    }
    
    public StandardTwo loadAllStandard2 (String standardName, int period, StandardTwo standard) {
    	StandardTwo output = loadStandard2(standardName, standard); //load the questions
    	output = loadStudentAnswers2(standardName, period, output); //load the students and answers
    	return output;
    }
    
    public Standard3 loadAllStandard3 (String standardName, int period, Standard3 standard) {
    	Standard3 output = loadStandard3(standardName, standard); //load the questions
    	output = loadStudentAnswers3(standardName, period, output); //load the students and answers
    	return output;
    }
    
    public Standard1 loadStudentAnswers1(String standardName, int period, Standard1 standard) {
        String[] splitName = standardName.split(" ");
        String newName = "studentAnswers/" + splitName[0].toLowerCase();
        for (int i = 1; i < splitName.length; i++) { //remove any spaces to fit the file name
        	newName += splitName[i].substring(0, 1).toUpperCase() + splitName[i].substring(1).toLowerCase();
        	// ^ camel casing
        }
        newName += "period" + period + ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader(newName));
        	double weight = Double.parseDouble(input.readLine());
        	int ninetyFive = Integer.parseInt(input.readLine()); //first 2 numbers in the file are score cutoffs
        	int eightyFive = Integer.parseInt(input.readLine());
        	Standard1 output;
        	if (standard == null) { //create the standard if needed
        		output = new Standard1(eightyFive, ninetyFive, weight);
        	}
        	else {
        		output = standard;
        	}
            String name = "";
            while (input.ready()) {
            	String next = input.readLine();
            	String[] split = next.split(",");
            	if (split.length > 1) {
        			next = split[1] + " " + split[0]; //reformat the name
        		}
            	ArrayList<String> roster = (ArrayList<String>) loadRoster(period);
            	if (roster.contains(next)) {
            		name = next; //current name is changeds
            	}
            	else {
            		boolean answer;
            		if (next.substring(0,1).toLowerCase().equals("t")) {
            			//get the boolean based off the first letter in the line
            			answer = true;
            		}
            		else {
            			answer = false;
            		}
            		output.setIndividualAnswer(name, answer);
            	}
            }
            return output;
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    public StandardTwo loadStudentAnswers2 (String standardName, int period, StandardTwo standard) {
    	String[] splitName = standardName.split(" ");
    	String newName = "studentAnswers/" + splitName[0].toLowerCase();
        for (int i = 1; i < splitName.length; i++) { //remove any spaces to fit the file name
        	newName += splitName[i].substring(0, 1).toUpperCase() + splitName[i].substring(1).toLowerCase();
        	// ^ camel casing
        }
        newName += "period" + period + ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader(newName));
        	double weight = Double.parseDouble(input.readLine());
        	StandardTwo output;
        	if (standard == null) { //create the standard if needed
        		output = new StandardTwo(weight);
        	}
        	else {
        		output = standard;
        	}
        	String name = "";
        	while (input.ready()) {
        		String next = input.readLine();
            	String[] split = next.split(",");
            	if (split.length > 1) {
        			next = split[1] + " " + split[0]; //reformat the name
        		}
            	ArrayList<String> roster = (ArrayList<String>) loadRoster(period);
            	if (roster.contains(next)) {
            		name = next; //current name is changed
            	}
            	else {
            		boolean answer;
            		if (next.substring(0,1).toLowerCase().equals("t")) {
            			//get the boolean based off the first letter in the line
            			answer = true;
            		}
            		else {
            			answer = false;
            		}
            		output.addIndividualA(name, answer);
            	}
        	}
        	return output;
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
    	return null;
    }
    
    public Standard3 loadStudentAnswers3 (String standardName, int period, Standard3 standard) {
    	String[] splitName = standardName.split(" ");
    	String newName = "studentAnswers/" + splitName[0].toLowerCase();
        for (int i = 1; i < splitName.length; i++) { //remove any spaces to fit the file name
        	newName += splitName[i].substring(0, 1).toUpperCase() + splitName[i].substring(1).toLowerCase();
        	// ^ camel casing
        }
        newName += "period" + period + ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader(newName));
        	Standard3 output = standard;
        	String name = "";
        	while (input.ready()) {
        		String next = input.readLine();
            	String[] split = next.split(",");
            	if (split.length > 1) {
        			next = split[1] + " " + split[0]; //reformat the name
        		}
            	ArrayList<String> roster = (ArrayList<String>) loadRoster(period);
            	if (roster.contains(next)) {
            		name = next; //current name is changed
            		output.addStudent(next);
            	}
            	else {
            		int value = Integer.parseInt(next);
            		output.setStudentScore(name, value); //get the answer from the student and add it
            	}
            }
            return output;
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
    	return null;
    }
    
    public Standard1 loadStandard1(String standardName, Standard1 standard) {
    	String[] splitName = standardName.split(" ");
    	String newName = "standards/" + splitName[0].toLowerCase();
        for (int i = 1; i < splitName.length; i++) { //remove any spaces to fit the file name
        	newName += splitName[i].substring(0, 1).toUpperCase() + splitName[i].substring(1).toLowerCase();
        	// ^ camel casing
        }
        newName += ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader(newName));
        	double weight = Double.parseDouble(input.readLine()); //first line is weight
        	int ninetyFive = Integer.parseInt(input.readLine()); //second 2 lines of file are the cutoffs
        	int eightyFive = Integer.parseInt(input.readLine());
        	Standard1 output;
        	if (standard == null) { //create a new standard if needed
        		output = new Standard1(eightyFive, ninetyFive, weight);
        	}
        	else {
        		output = standard;
        	}
            while (input.ready()) { //get a list of all the questions
            	output.addIndividualQuestion(input.readLine());
            }
            return output;
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    public StandardTwo loadStandard2 (String standardName, StandardTwo standard) {
    	String[] splitName = standardName.split(" ");
    	String newName = "standards/" + splitName[0].toLowerCase();
        for (int i = 1; i < splitName.length; i++) { //remove any spaces to fit the file name
        	newName += splitName[i].substring(0, 1).toUpperCase() + splitName[i].substring(1).toLowerCase();
        	// ^ camel casing
        }
        newName += ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader(newName));
        	double weight = Double.parseDouble(input.readLine()); //first line is the weight
        	StandardTwo output;
        	if (standard == null) { //create a new standard if needed
        		output = new StandardTwo(weight);
        	}
        	else {
        		output = standard;
        	}
        	while (input.ready()) {
        		output.addIndividualQ(input.readLine()); //add each question from the file into the standard
        	}
        	return output;
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
    	return null;
    }
    
    public Standard3 loadStandard3 (String standardName, Standard3 standard) {
    	String[] splitName = standardName.split(" ");
    	String newName = "standards/" + splitName[0].toLowerCase();
        for (int i = 1; i < splitName.length; i++) { //remove any spaces to fit the file name
        	newName += splitName[i].substring(0, 1).toUpperCase() + splitName[i].substring(1).toLowerCase();
        	// ^ camel casing
        }
        newName += ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader(newName));
        	int weight = Integer.parseInt(input.readLine()); //first line is the weight
        	if (!input.ready()) { //if there's no question in file
        		if (standard == null) { //create a new standard if needed
        			Standard3 output = new Standard3("", weight);
        			return output;
        		}
        		return standard;
        	}
        	String question = input.readLine();
        	Standard3 output;
        	if (standard == null) { //create a new standard if needed
        		output = new Standard3(question, weight);
        	}
        	else {
        		output = standard;
        		output.editQuestion(question);
        	}
        	return output;
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
    	return null;
    }
    
    public List<String> loadRoster(int period) {
    	try {
    		BufferedReader input = new BufferedReader(new FileReader("roster/period" + period + ".txt"));
            ArrayList<String> output = new ArrayList<String>(); //list of names
            while (input.ready()) { //add each name in file to list
            	String[] names = input.readLine().split(",");
            	String newName;
            	if (names.length > 1) {
            		newName = names[1] + " " + names[0]; //change name formatting to work
            	}
            	else {
            		newName = names[0];
            	}
            	output.add(newName);
            }
            return output;
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
}
