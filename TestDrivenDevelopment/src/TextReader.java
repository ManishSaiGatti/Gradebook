
import java.util.*;
import java.io.*;

public class TextReader {
    
    public TextReader() {
    	
    }
    
    public Standard1 loadAllStandard1 (String standardName, int period, Standard1 standard) {
    	Standard1 output = loadStandard1(standardName, standard);
    	output = loadStudentAnswers1(standardName, period, output);
    	return output;
    }
    
    public Standard1 loadStudentAnswers1(String standardName, int period, Standard1 standard) {
        String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) {
        	newName += s;
        }
        newName += "period" + period + ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader("studentAnswers/" + newName));
        	int ninetyFive = Integer.parseInt(input.readLine());
        	int eightyFive = Integer.parseInt(input.readLine());
        	Standard1 output;
        	if (standard == null) {
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
            		next = split[1] + " " + split[0];
            	}
            	if (split.length > 1) {
            		name = next;
            	}
            	else {
            		boolean answer;
            		if (next.substring(0,1).toLowerCase().equals("t")) {
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
    
    public Standard1 loadStandard1(String standardName, Standard1 standard) {
    	String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader("standards/" + newName));
        	int ninetyFive = Integer.parseInt(input.readLine());
        	int eightyFive = Integer.parseInt(input.readLine());
        	Standard1 output;
        	if (standard == null) {
        		output = new Standard1(eightyFive, ninetyFive);
        	}
        	else {
        		output = standard;
        	}
            ArrayList<String> questions = new ArrayList<String>();
            while (input.ready()) {
            	questions.add(input.readLine());
            }
            output.addQuestions(questions);
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
            ArrayList<String> output = new ArrayList<String>();
            while (input.ready()) {
            	String[] names = input.readLine().split(",");
            	String newName;
            	if (names.length > 1) {
            		newName = names[1] + " " + names[0];
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
