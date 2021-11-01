import java.util.*;
import java.io.*;

public class TextWriter {
	
	public TextWriter() {
		
	}
	
	public void SaveStandard(String standardName, List<String> questions) {
		
	}
	
	public void saveStudentAnswers(String standardName, int period, Map<String, List<String>> answers) {
		
	}
	
	public void saveRoster(int period, List<String> names) throws IOException {
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
		FileWriter writer = new FileWriter(fileName);
		writer.write(output);
		writer.close();
	}
}
