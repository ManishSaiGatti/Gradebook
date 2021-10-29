
import java.util.*;
import java.io.*;

public class TextReader {
	private String fileLocation;
    
    public TextReader() {
        fileLocation = "./";
    }
    
    public /*Standard*/ String loadStudentAnswers(String standardName/*, Standard standard*/) throws IOException {
        String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt";
        BufferedReader input = new BufferedReader(new FileReader("studentAnswers/" + newName));
        String output = input.readLine();
        while (input.ready()) {
        	output += "-" + input.readLine();
        }
        return output;
    }
    
    public /*Standard*/ String loadStandard(String standardName) throws IOException {
    	String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt";
        BufferedReader input = new BufferedReader(new FileReader("standards/" + newName));
        String output = input.readLine();
        while (input.ready()) {
        	output += "-" + input.readLine();
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
