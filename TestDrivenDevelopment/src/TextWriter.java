import java.util.*;
import java.io.*;

public class TextWriter {
	
	public TextWriter() {
		
	}
	
	public void saveAll1(String standardName, int period, Standard1 standard) {
		saveStandard1(standardName, standard);
		saveStudentAnswers1(standardName, period, standard);
	}
	
	/*public void saveAll2(String standardName, int period, Standard2 standard) {
		saveStandard2(standardName, standard);
		saveStudentAnswers2(standardName, period, standard);
	}
	
	public void saveAll3(String standardName, int period, Standard3 standard) {
		saveStandard3(standardName, standard);
		saveStudentAnswers3(standardName, period, standard);
	}*/
	
	public void saveStandard1(String standardName, Standard1 standard) {
		if (standard == null) {
			return;
		}
		String[] splitName = standardName.split(" ");
        String newName = "standards/";
        for (String s : splitName) {
        	newName += s;
        }
        newName += ".txt";
        ArrayList<String> questions = standard.getQuestions();
        String output = "";
        output += standard.getNumCorrect85() + "\n" + standard.getNumCorrect95() + "\n";
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
	
	/*public void saveStandard2(String standardName, Standard2 standard) {
		
	}
	
	public void saveStandard3(String standardName, Standard3 standard) {
		
	}*/
	
	public void saveStudentAnswers1(String standardName, int period, Standard1 standard) {
		if (standard == null) {
			return;
		}
		String[] splitName = standardName.split(" ");
        String newName = "studentAnswers/";
        for (String s : splitName) {
        	newName += s;
        }
        newName += "period" + period + ".txt";
        String output = "";
        output += standard.getNumCorrect85() + "\n" + standard.getNumCorrect95() + "\n";
        Iterator<String> names = standard.getRoster().iterator();
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
        	ArrayList<Boolean> answers = standard.getStudentAnswers(nameFirst);
        	if (answers == null) {
        		continue;
        	}
        	for (int c = 0; c < answers.size(); c++) {
        		output += answers.get(c) + "\n";
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
	
	/*public void saveStudentAnswers2(String standardName, int period, Standard2 standard) {
		
	}
	
	public void saveStudentAnswers3(String standardName, int period, Standard3 standard) {
		
	}*/
	
	public void saveRoster(int period, Standard1 standard) {
		if (standard == null) {
			return;
		}
		String fileName = "roster/period" + period + ".txt"; 
		String output = "";
		Iterator<String> names = standard.getRoster().iterator();
		while (names.hasNext()) {
			String[] splitName = names.next().split(" ");
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
