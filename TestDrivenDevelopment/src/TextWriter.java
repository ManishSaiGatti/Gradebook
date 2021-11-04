import java.util.*;
import java.io.*;

public class TextWriter {
	
	public TextWriter() {
		
	}
	
	public void saveStandard(String standardName, List<String> questions) {
		String[] splitName = standardName.split(" ");
        String newName = "standards/";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt";
        String output = "";
        for (int i = 0; i < questions.size(); i++) {
        	output += questions.get(i) + "\n";
        }
        try {
        	FileWriter writer = new FileWriter(newName);
            writer.write(output);
            writer.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void saveStudentAnswers(String standardName, int period, Map<String, ArrayList<String>> answers) {
		String[] splitName = standardName.split(" ");
        String newName = "studentAnswers/";
        for (String s : splitName) {
        	newName += s;
        }
        newName += "period" + period + ".txt";
        String output = "";
        Iterator<String> names = answers.keySet().iterator();
        while (names.hasNext()) {
        	String nameFirst = names.next();
        	String[] split = nameFirst.split(" ");
        	String name;
        	if (split.length > 1) {
        		name = split[1] + "," + split[0];
        	}
        	else {
        		name = nameFirst;
        	}
        	output += name + "\n";
        	for (int c = 0; c < answers.get(nameFirst).size(); c++) {
        		output += answers.get(nameFirst).get(c) + "\n";
        	}
        }
        try {
        	FileWriter writer = new FileWriter(newName);
            writer.write(output);
            writer.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void saveRoster(int period, List<String> names) {
		String fileName = "roster/period" + period + ".txt"; 
		String output = "";
		for (int i = 0; i < names.size(); i++) {
			String[] splitName = names.get(i).split(" ");
			String newName;
			if (splitName.length > 1) {
				newName = splitName[1] + "," + splitName[0];
			}
			else {
				newName = splitName[0];
			}
			output += newName + "\n";
		}
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write(output);
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
