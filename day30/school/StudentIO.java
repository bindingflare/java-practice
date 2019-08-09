package day26.school;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*	Data save file format (.txt)
 *  
 *  Each student:
 *  	Student name (String)
 *  	Student ID (String)
 *  	
 *  	Each subject:
 *  		Subject ID
 *  		Score
 *  END_OF_STUDENT_DATA_SYMBOL (*)
 */

public class StudentIO {
	private File saveFile;

	private final char STD_DATA_END_SET_SYMBOL = '*';

	public StudentIO(StdManager manager) {
		saveFile = new File("src/day26/school/studentData.txt");
	}

	public List<Student> load() {
		List<Student> list = new ArrayList<>();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(saveFile));
		} catch (FileNotFoundException e) {
			StdManager.outputLog("Error loading save file (File Not Found Exception)");
		}

		int count = 0;

		Student std = null;

		String stdName = null;
		String stdID = null;

		String subjID = null;
		int subjScore;

		for (;;) {
			String line = null;

			try {
				line = reader.readLine();
			} catch (IOException e) {
				StdManager.outputLog("Error reading file");
			}

			if (line == null) {
				break;
			}

			if (line.equals(STD_DATA_END_SET_SYMBOL + "")) {
				// Add student to student list before reset
				list.add(std);

				count = 0;
				continue;
			}

			if (count == 0) {
				stdName = line;
			} else if (count == 1) {
				stdID = line;
				// Construct basic student object BEFORE adding subjects
				std = new Student(stdName, stdID);
			} else if (count > 1) {
				if (count % 2 == 0) {
					subjID = line;
				} else {
					subjScore = Integer.parseInt(line);

					std.addSubject(subjID, subjScore);
				}
			}

			count++;
		}

		return list;
	}

	public void save(List<Student> list) {
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(saveFile, false));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Student std : list) {
			try {
				writer.write(std.getName());
				writer.newLine();

				writer.write(std.getID());
				writer.newLine();

				for (Subject subject : std.getSubjects()) {
					writer.write(subject.getID());
					writer.newLine();

					writer.write(String.valueOf(std.getScore(subject)));
					writer.newLine();
				}
				
				writer.write("*");
				writer.newLine();
			} catch (IOException e) {
				StdManager.outputLog("Error saving studentData.txt");
			}
		}

		try {
			writer.close();
		} catch (IOException e) {
			StdManager.outputLog("Error closing writer");
		}
	}

}
