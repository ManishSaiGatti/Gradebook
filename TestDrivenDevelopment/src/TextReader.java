
import java.util.*;
import java.io.*;

public class TextReader {
	private String fileLocation;
    
    public TextReader() {
        fileLocation = "./";
    }
    
    public /*Standard*/ HashMap<String, ArrayList<String>> loadStudentAnswers(String standardName, int period/*, Standard standard*/) throws IOException {
        String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) {
        	newName += s;
        }
        newName += "period" + period + ".txt";
        BufferedReader input = new BufferedReader(new FileReader("studentAnswers/" + newName));
        HashMap<String, ArrayList<String>> output = new HashMap<String, ArrayList<String>>();
        ArrayList<String> studentNames = (ArrayList<String>)loadRoster(period);
        while (input.ready()) {
        	String next = input.readLine();
        	if (studentNames.contains(next)) {
        		output.put(next, new ArrayList<String>());
        	}
        	else {
        		output.get(studentNames.get(output.size()-1)).add(next);
        	}
        }
        return output;
    }
    
    public /*Standard*/ List<String> loadStandard(String standardName) throws IOException {
    	String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt";
        BufferedReader input = new BufferedReader(new FileReader("standards/" + newName));
        ArrayList<String> output = new ArrayList<String>();
        while (input.ready()) {
        	output.add(input.readLine());
        }
        return output;
    }
    
    public List<String> loadRoster(int period) throws IOException {
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
}
