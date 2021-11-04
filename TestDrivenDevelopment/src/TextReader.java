
import java.util.*;
import java.io.*;

public class TextReader {
    
    public TextReader() {
    	
    }
    
    public /*Standard*/ HashMap<String, ArrayList<String>> loadStudentAnswers(String standardName, int period/*, Standard standard*/) {
        String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) {
        	newName += s;
        }
        newName += "period" + period + ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader("studentAnswers/" + newName));
            HashMap<String, ArrayList<String>> output = new HashMap<String, ArrayList<String>>();
            ArrayList<String> studentNames = (ArrayList<String>)loadRoster(period);
            String name = "";
            while (input.ready()) {
            	String next = input.readLine();
            	String[] split = next.split(",");
            	if (split.length > 1) {
            		next = split[1] + " " + split[0];
            	}
            	if (studentNames.contains(next)) {
            		output.put(next, new ArrayList<String>());
            		name = next;
            	}
            	else {
            		output.get(name).add(next);
            	}
            }
            return output;
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    public /*Standard*/ List<String> loadStandard(String standardName) {
    	String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt";
        try {
        	BufferedReader input = new BufferedReader(new FileReader("standards/" + newName));
            ArrayList<String> output = new ArrayList<String>();
            while (input.ready()) {
            	output.add(input.readLine());
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
