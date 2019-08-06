package day26.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
	private List<Student> stdArr = new ArrayList<>();

	// Preload subjects
	public static final Subject math = new Subject("Maths 1", "MAT-001", SubjectType.MATH);
	public static final Subject english = new Subject("English Advanced Lvl", "ENG-003", SubjectType.ENGLISH);
	public static final Subject korean = new Subject("Korean Advanced Lvl", "KOR-003", SubjectType.KOREAN);
	
	public static void main(String[] args) {
		Manager manager = new Manager();
		Scanner sc = new Scanner(System.in);

		for (;;) {
			// Initial msg
			Manager.output("Welcome to student management portal");
			
			Manager.output("Load data from save file? Type 'y' to load and anything else to continue");
			String input = sc.nextLine();
			
			if(input.equals("y")) {
				StudentIO io = new StudentIO(manager);
				manager.stdArr = io.load();
				
				Manager.output("Loaded save file");
			}
			
			Manager.output("Select operation");
			commands();

			input = sc.nextLine();

			if (input.equals("1")) {
				// 1 - Insert data
				String stdName, stdID;
				int mat, kor, eng;

				Manager.output("Input student name");
				stdName = sc.nextLine();

				Manager.output("Input student ID");
				stdID = sc.nextLine();

//				Manager.output("Input math subject ID");
				Manager.output("Input student math score");
				mat = sc.nextInt();

//				Manager.output("Input korean subject ID");
				Manager.output("Input student korean score");
				kor = sc.nextInt();

//				Manager.output("Input english subject ID");
				Manager.output("Input student english score");
				eng = sc.nextInt();

				Student student = new Student(stdName, stdID);

				student.setSubject(new EnrolledSubject(korean, kor));
				student.setSubject(new EnrolledSubject(english, eng));
				student.setSubject(new EnrolledSubject(math, mat));

				manager.stdArr.add(student);

				Manager.output("Student has been added");

				Manager.output("Press enter to continue");
				sc.nextLine();
				sc.nextLine(); // Catch trailing enter
				System.out.flush();

			} else if (input.equals("2")) {
				// 2 - Print all data

				for (Student student : manager.stdArr) {
					student.info();
					Manager.output("");
				}

				Manager.output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			} else if (input.equals("3")) {
				// 3 - Find data
				Manager.output("Enter search type");

				Manager.output("1 - search students");
				Manager.output("2 - search subjects");

				String input2 = sc.nextLine();

				if (input2.equals("1")) {
					Manager.output("Enter student name or ID");

					String query = sc.nextLine();

					manager.findStd(query);
				} else if (input2.equals("2")) {
					Manager.output("Enter subject name or ID");

					String query = sc.nextLine();

					manager.findSub(query);
				}

				Manager.output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			} else if (input.equals("4")) {
				// 4 - Edit data
				for (;;) {
					Manager.output("Enter student name or ID");
					String query = sc.nextLine();

					boolean goOut = false;
					
					Student result = null;
					int i;
					
					for (i = 0; i < manager.stdArr.size(); i++) {
						Student std = manager.stdArr.get(i);
						
						if (std.getName().equals(query) || std.getID().equals(query)) {
							result = std;
						}
					}
					
					if (result == null) {
						log("Student was not found. Please try again");
					} else {
						result.info();
						for (;;) {
							Manager.output("Select data to edit");
							
							Manager.output("1 - Name");
							Manager.output("2 - ID");
							Manager.output("3 - English score");
							Manager.output("4 - Korean score");
							Manager.output("5 - Math score");
							
							String input2 = sc.nextLine();
							
							int inputNum = Integer.parseInt(input2);
							
							if(inputNum > 0 && inputNum < 6) {
								if(inputNum == 1) {
									Manager.output("Enter new name");
									result.setName(sc.nextLine());
								} else if (inputNum == 2) {
									Manager.output("Enter new ID");
									result.setID(sc.nextLine());
								} else if (inputNum == 3) {
									Manager.output("Enter new score");
									result.setScore(sc.nextInt(), english);
								} else if (inputNum == 4) {
									Manager.output("Enter new score");
									result.setScore(sc.nextInt(), korean);
								} else if (inputNum == 5) {
									Manager.output("Enter new score");
									result.setScore(sc.nextInt(), math);
								}
								
								goOut = true;
								break;
							}
						}
						
						if(goOut) {
							break;
						}
						
						//manager.stdArr[i] = result;
					}
				}

				Manager.output("Edit complete");
				Manager.output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			} else if (input.equals("5")) {
				// 5 - Delete data
				
				Manager.output("Enter student name or ID");
				String query = sc.nextLine();

				Student result = null;
				int i;
				
				for (i = 0; i < manager.stdArr.size(); i++) {
					Student std = manager.stdArr.get(i);
					
					if (std.getName().equals(query) || std.getID().equals(query)) {
						result = std;
						break;
					}
				}
				
				if (result == null) {
					log("Student was not found. Please try again");
				} else {
					manager.stdArr.remove(i);
				}
				
				Manager.output("Delete successful");

				Manager.output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			} else if (input.equals("9")) {
				break;

			} else {
				Manager.output("Please try again");

				Manager.output("Press enter to continue");
				sc.nextLine();
				System.out.flush();

			}
		}

		Manager.output("Program will exit");
		sc.close();
	}

	public void findStd(String query) {
		for (Student std : stdArr) {
			if (std.getName().equals(query) || std.getID().equals(query)) {
				std.info();
				Manager.output("");
			}
		}
	}

	public void findSub(String query) {
		for (Student std : stdArr) {
			for (Subject subject : std.getSubjects()) {
				if (subject.getName().equals(query) || subject.getID().equals(query)) {
					std.info();
					Manager.output("");
				}
			}
		}
	}

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
