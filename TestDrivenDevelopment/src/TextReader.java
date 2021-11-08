
import java.util.*;
import java.io.*;

public class TextReader {
    
    public TextReader() {
    	
    }
    
    public Standard1 loadAllStandard1 (String standardName, int period, Standard1 standard) {
    	Standard1 output = loadStandard1(standardName, standard); //loads the questions
    	output = loadStudentAnswers1(standardName, period, output); //loads the students and their answers
    	return output;
    }
    
    /*public Standard2 loadAllStandard2 (String standardName, int period, Standard2 standard) {
    	Standard2 output = loadStandard2(standardName, standard);
    	output = loadStudentAnswers2(standardName, period, output);
    	return output;
    }
    
    public Standard3 loadAllStandard3 (String standardName, int period, Standard3 standard) {
    	Standard3 output = loadStandard3(standardName, standard);
    	output = loadStudentAnswers3(standardName, period, output);
    	return output;
    }*/
    
    public Standard1 loadStudentAnswers1(String standardName, int period, Standard1 standard) {
        String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) { //recombine name since file names won't have spaces
        	newName += s;
        }
        newName += "period" + period + ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader("studentAnswers/" + newName));
        	int ninetyFive = Integer.parseInt(input.readLine()); //first 2 numbers in the file are score cutoffs
        	int eightyFive = Integer.parseInt(input.readLine());
        	Standard1 output;
        	if (standard == null) { //create the standard if needed
        		output = new Standard1(eightyFive, ninetyFive);
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
    
    /*public Standard2 loadStudentAnswers2 (String standardName, int period, Standard2 standard) {
    	return null;
    }
    
    public Standard3 loadStudentAnswers3 (String standardName, int period Standard3 standard) {
    	return null;
    }*/
    
    public Standard1 loadStandard1(String standardName, Standard1 standard) {
    	String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) { //remove any spaces to fit the file name
        	newName += s;
        }
        newName += ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader("standards/" + newName));
        	int ninetyFive = Integer.parseInt(input.readLine()); //first 2 lines of file are the cutoffs
        	int eightyFive = Integer.parseInt(input.readLine());
        	Standard1 output;
        	if (standard == null) { //create a new standard if needed
        		output = new Standard1(eightyFive, ninetyFive);
        	}
        	else {
        		output = standard;
        	}
            ArrayList<String> questions = new ArrayList<String>();
            while (input.ready()) { //get a list of all the questions
            	questions.add(input.readLine());
            }
            output.addQuestions(questions); //add all the questions together
            return output;
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /*public Standard2 loadStandard2 (String standardName, Standard2 standard) {
    	return null;
    }
    
    public Standard3 loadStandard3 (String standardName, Standard3 standard) {
    	return null;
    }*/
    
    public List<String> loadRoster(int period) {
    	try {
    		BufferedReader input = new BufferedReader(new FileReader("roster/period" + period + ".txt"));
            ArrayList<String> output = new ArrayList<String>();
            while (input.ready()) {
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
