package day26.school;

import java.util.ArrayList;
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

					output("Enter subject ID (Available subjects IDs : " + SubjectList.getIDs() + ")");
					ID = sc.nextLine();

					output("Enter score of subject");
					score = Integer.parseInt(sc.nextLine());

					std.addSubject(ID, score);

					output("");
				}

				list.add(std);

				output("Student has been added");

				output("Press enter to continue");
				sc.nextLine();
				sc.nextLine(); // Catch trailing enter
				System.out.flush();

			} else if (input.equals("2")) {
				// 2 - Print all data

				for (int i = 1; i <= list.size(); i++) {
					output("Student No. " + i + "_");
					list.get(i - 1).info();
					output("");
				}

				output("Print all student data complete");

				output("");
				output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			} else if (input.equals("3")) {
				// 3 - Find data
				output("Enter search type");

				output("1 - search students");
				output("2 - search subjects");

				input = sc.nextLine();

				if (input.equals("1")) {
					output("Enter student name or ID");

					String query = sc.nextLine();

					List<Student> results = list.searchByStudent(query);

					output("");
					output("Found " + results.size() + " hits");
					output("");

					for (Student student : results) {
						student.info();
						output("");
					}

				} else if (input.equals("2")) {
					output("Enter subject name or ID");

					String query = sc.nextLine();

					List<Student> results = list.searchBySubject(query);

					output("");
					output("Found " + results.size() + " hits");
					output("");

					for (Student student : results) {
						student.info();
						output("");
					}
				}

				output("Search complete");

				output("");
				output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			} else if (input.equals("4")) {
				// 4 - Edit data
				output("Enter student name or ID");
				input = sc.nextLine();

				List<Student> results = list.searchByStudent(input);

				output("");
				output("Found " + results.size() + " hits");
				output("");

				for (Student student : results) {
					student.info();
					output("");
				}

				output("Input exact ID of student from list above");
				String ID = sc.nextLine();

				output("Enter field to edit");

				output("1 - edit name");
				output("2 - edit ID");
				output("3 - add subject");
				output("4 - remove subject");
				output("5 - edit subject");

				int selection = Integer.parseInt(sc.nextLine());

				// TODO Finish edit code
				
//				for (;;) {
//					output("Enter student name or ID");
//					String query = sc.nextLine();
//
//					boolean goOut = false;
//					
//					Student result = null;
//					int i;
//					
//					for (i = 0; i < manager.stdArr.size(); i++) {
//						Student std = manager.stdArr.get(i);
//						
//						if (std.getName().equals(query) || std.getID().equals(query)) {
//							result = std;
//						}
//					}
//					
//					if (result == null) {
//						log("Student was not found. Please try again");
//					} else {
//						result.info();
//						for (;;) {
//							output("Select data to edit");
//							
//							output("1 - Name");
//							output("2 - ID");
//							output("3 - English score");
//							output("4 - Korean score");
//							output("5 - Math score");
//							
//							String input2 = sc.nextLine();
//							
//							int inputNum = Integer.parseInt(input2);
//							
//							if(inputNum > 0 && inputNum < 6) {
//								if(inputNum == 1) {
//									output("Enter new name");
//									result.setName(sc.nextLine());
//								} else if (inputNum == 2) {
//									output("Enter new ID");
//									result.setID(sc.nextLine());
//								} else if (inputNum == 3) {
//									output("Enter new score");
//									result.setScore(sc.nextInt(), english);
//								} else if (inputNum == 4) {
//									output("Enter new score");
//									result.setScore(sc.nextInt(), korean);
//								} else if (inputNum == 5) {
//									output("Enter new score");
//									result.setScore(sc.nextInt(), math);
//								}
//								
//								goOut = true;
//								break;
//							}
//						}
//						
//						if(goOut) {
//							break;
//						}
//						
//						//manager.stdArr[i] = result;
//					}
//				}
//
//				output("Edit complete");
//				output("Press enter to continue");
//				sc.nextLine();
//				System.out.flush();

			} else if (input.equals("5")) {
				// 5 - Delete data

				output("Enter student name or ID");
				input = sc.nextLine();

				List<Student> results = list.searchByStudent(input);

				String ID = results.get(0).getID();
				
				if (results.size() > 1) {
					output("");
					output("Found " + results.size() + " hits");
					output("");

					for (Student student : results) {
						student.info();
						output("");
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

//	public void findStd(String query) {
//		for (Student std : stdArr) {
//			if (std.getName().equals(query) || std.getID().equals(query)) {
//				std.info();
//				output("");
//			}
//		}
//	}

//	public void findSub(String query) {
//		for (Student std : stdArr) {
//			for (Subject subject : std.getSubjects()) {
//				if (subject.getName().equals(query) || subject.getID().equals(query)) {
//					std.info();
//					output("");
//				}
//			}
//		}
//	}

	public static void log(String msg) {
		System.out.println("[StudMan] INFO: " + msg);
	}

	public static void output(String msg) {
		System.out.println(msg);
	}

	public static void commands() {
		System.out.println("1 - Insert student data");
		System.out.println("2 - Print all student data");
		System.out.println("3 - Find student data");
		System.out.println("4 - Edit student data");
		System.out.println("5 - Delete student data");
		System.out.println("9 - Exit program");
	}
}
