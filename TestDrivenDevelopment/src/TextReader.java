
import java.util.*;
import java.io.*;

public class TextReader {
	private String fileLocation;
    
    public TextReader() {
        fileLocation = "./";
    }
    
    public Standard loadStudentAnswers(String standardName, Standard standard) throws IOException {
        /*String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt";
        BufferedReader input = new BufferedReader(new FileReader("studentAnswers/" + newName));
        String output = input.readLine();
        return output;*/
    	return null;
    }
    
    public Standard loadStandard(String standardName) throws IOException {
    	/*String[] splitName = standardName.split(" ");
        String newName = "";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt";
        BufferedReader input = new BufferedReader(new FileReader("standards/" + newName));
        String output = input.readLine();
        return output;*/
    	return null;
    }
}
