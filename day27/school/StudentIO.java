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

public class StudentIO {
	File saveFile;

	public StudentIO(Manager manager) {
		saveFile = new File("src/day26/school/studentData.txt");
	}

	public List<Student> load() {
		List<Student> list = new ArrayList<>();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(saveFile));
		} catch (FileNotFoundException e) {
			Manager.log("Error loading save file (File Not Found Exception)");
		}

		int count = 0;

		String name = null;
		String ID = null;
		int matS = 0;
		int korS = 0;
		int engS = 0;

		for (;;) {
			String line = null;

			try {
				line = reader.readLine();
			} catch (IOException e) {
				// Do nothing
			}

			if (line == null) {
				break;
			}

			switch (count) {
			case 0:
				name = line;
				break;
			case 1:
				ID = line;
				break;
			case 2:
				matS = Integer.parseInt(line);
				break;
			case 3:
				korS = Integer.parseInt(line);
				break;
			case 4:
				engS = Integer.parseInt(line);
				break;
			default:
				break;
			}

			count++;

			if (count == 5) {
				count = 0;

				Student std = new Student(name, ID);
				std.setSubject(new EnrolledSubject(Manager.math, matS));
				std.setSubject(new EnrolledSubject(Manager.korean, korS));
				std.setSubject(new EnrolledSubject(Manager.english, engS));

				list.add(std);
			}
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

				writer.write(std.getSubject(SubjectType.MATH).getScore());
				writer.newLine();
				
				writer.write(std.getSubject(SubjectType.KOREAN).getScore());
				writer.newLine();
				
				writer.write(std.getSubject(SubjectType.ENGLISH).getScore());
				writer.newLine();
			} catch (IOException e) {
				Manager.log("Error saving studentData.txt");
			}
		}
		
		try {
			writer.close();
		} catch (IOException e) {
			Manager.log("Error closing writer");
		}
	}

}
