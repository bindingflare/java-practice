package day26.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StdManager {

	public static final int MAX_SUBJECTS = 5;

	// Preload subjects

	public static void main(String[] args) {
		StdManager manager = new StdManager();
//		SubjectList list = new SubjectList();
		StudentList list;
		StudentIO io = new StudentIO(manager);

		Scanner sc = new Scanner(System.in);

		output("Welcome to student management portal");

		output("Load data from save file? Type 'y' to load and anything else to continue");
		String input = sc.nextLine();

		List<Student> loadedList = new ArrayList<>();

		if (input.equals("y")) {
			loadedList = io.load();

			output("Loaded save file");
		}

		list = new StudentList(loadedList);

		for (;;) {
			// Initial msg
			output("Please select an operation");
			commands();

			input = sc.nextLine();

			if (input.equals("1")) {
				// 1 - Insert data
				String stdName, stdID;

				int numSubjects;

				String ID;
				int score;

				output("Input student name");
				stdName = sc.nextLine();

				output("Input student ID");
				stdID = sc.nextLine();

				Student std = new Student(stdName, stdID);

				output("Input number of enrolled subjects");
				numSubjects = Integer.parseInt(sc.nextLine());

				for (int i = 1; i <= numSubjects; i++) {
					output("Subject entry (no " + i + ")");

					output("Enter subject ID (Available subjects IDs : " + Arrays.toString(SubjectList.getIDs()) + ")");
					ID = sc.nextLine();

					output("Enter score of subject");
					score = Integer.parseInt(sc.nextLine());

					std.addSubject(ID, score);

					outputEmpty();
				}

				list.add(std);

				output("Student has been added");

				output("Press enter to continue");
				sc.nextLine(); // Catch trailing enter
				System.out.flush();

			} else if (input.equals("2")) {
				// 2 - Print all data

				for (int i = 1; i <= list.size(); i++) {
					output("Student No. " + i + "_");
					list.get(i - 1).info();
					outputEmpty();
				}

				output("Print all student data complete");

				outputEmpty();
				output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			} else if (input.equals("3")) {
				// 3 - Find data
				output("Enter search type");

				output("1 - search students");
				output("2 - search subjects");
				output("3 - search subject fields");

				input = sc.nextLine();

				if (input.equals("1")) {
					output("Enter student name or ID");

					String query = sc.nextLine();

					List<Student> results = list.searchByStudent(query);

					outputEmpty();
					output("Found " + results.size() + " hits");
					outputEmpty();

					for (Student student : results) {
						student.info();
						outputEmpty();
					}

				} else if (input.equals("2")) {
					output("Enter subject name or ID");

					String query = sc.nextLine();

					List<Student> results = list.searchBySubject(query);

					outputEmpty();
					output("Found " + results.size() + " hits");
					outputEmpty();

					for (Student student : results) {
						student.info();
						outputEmpty();
					}
				} else if (input.equals("3")) {
					output("Enter subject field. Availabled fields: " + Arrays.toString(SubjectType.values()));

					input = sc.nextLine();

					List<Student> results = list.searchByField(input);

					if (results.isEmpty()) {
						output("Error! Subject field entered does not exist");
					} else {
						outputEmpty();
						output("Found " + results.size() + " hits");
						outputEmpty();

						for (Student student : results) {
							student.info();
							outputEmpty();
						}
					}
				}

				output("Search complete");

				outputEmpty();
				output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			} else if (input.equals("4")) {
				// 4 - Edit data
				output("Enter student name or ID");
				input = sc.nextLine();

				List<Student> results = list.searchByStudent(input);

				Student std = null;
				
				if (results.size() > 1) {
					outputEmpty();
					output("Found " + results.size() + " hits");
					outputEmpty();

					for (Student student : results) {
						student.info();
						outputEmpty();
					}

					output("Input exact ID of student from list above");
					String ID = sc.nextLine();
					
					std = list.get(ID);
				} else if(results.size() == 1) {
					std = results.get(0);
				} else {
					output("No students found");
					
					output("Edit complete");
					output("Press enter to continue");
					sc.nextLine();
					System.out.flush();
					
					continue;
				}
				
				output("Student information_");
				std.info();
				outputEmpty();

				output("Enter field to edit");

				output("1 - edit name");
				output("2 - edit ID");
				output("3 - add subject");
				output("4 - remove subject");
				output("5 - edit subject");

				int selection = Integer.parseInt(sc.nextLine());

				if (selection == 1) {
					// Edit name
					output("The old name is " + std.getName());
					output("Input the new name");

					input = sc.nextLine();

					std.setName(input);

					list.edit(std);

				} else if (selection == 2) {
					// Edit ID
					output("Editting ID requires removing and readding the student");

				} else if (selection == 3) {
					// Add subject
					output("Input the subject ID to add. Available subjects: " + Arrays.toString(SubjectList.getIDs()));

					input = sc.nextLine();

					output("Input the score of the subject");

					int score = Integer.parseInt(sc.nextLine());

					std.addSubject(input, score);

					list.edit(std);

				} else if (selection == 4) {
					output("Input the subject ID to remove. Available subjects: "
							+ Arrays.toString(SubjectList.getIDs()));

					input = sc.nextLine();

					std.removeSubject(input);

					list.edit(std);

				} else if (selection == 5) {
					output("Input the subject ID to edit. Available subjects: "
							+ Arrays.toString(std.getSubjectIDs().toArray()));

					input = sc.nextLine();

					output("Input the new score of the subject");

					int score = Integer.parseInt(sc.nextLine());

					std.removeSubject(input);
					std.addSubject(input, score);

					list.edit(std);
				}

				output("Edit complete");
				output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			} else if (input.equals("5")) {
				// 5 - Delete data

				output("Enter student name or ID");
				input = sc.nextLine();

				List<Student> results = list.searchByStudent(input);

				String ID = results.get(0).getID();

				if (results.size() > 1) {
					outputEmpty();
					output("Found " + results.size() + " hits");
					outputEmpty();

					for (Student student : results) {
						student.info();
						outputEmpty();
					}

					output("Input exact ID of student from list above");
					ID = sc.nextLine();

				} else if (results.size() == 0) {
					output("No student found with that name or ID. Please try again");
					continue;
				}

				list.remove(ID);

				output("Delete successful");

				output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			} else if (input.equals("8")) {
				// Save student data
				io.save(list.getFullList());
				output("Student data saved");

				output("Press enter to continue");
				sc.nextLine();
				System.out.flush();
			} else if (input.equals("9")) {
				break;

			} else {
				output("Please try again");

				output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			}
		}

		output("Save progress? Type 'y' to load and anything else to continue");
		input = sc.nextLine();

		if (input.equals("y")) {
			io.save(list.getFullList());
			output("Progress saved");
		}

		output("Program will exit");
		sc.close();
	}

	public static void log(String msg) {
		System.out.println("[StudMan] INFO: " + msg);
	}

	public static void output(String msg) {
		System.out.println("[StdManager] " + msg);
	}

	public static void outputEmpty() {
		System.out.println();
	}

	public static void commands() {
		System.out.println("1 - Insert student data");
		System.out.println("2 - Print all student data");
		System.out.println("3 - Find student data");
		System.out.println("4 - Edit student data");
		System.out.println("5 - Delete student data");
		System.out.println("8 - Save student data");
		System.out.println("9 - Exit program");
	}
}
