package day26.school;

public class Student {
	private String name;
	private String ID;

	private Subject[] subjects = new Subject[3];
	// 0 - Math
	// 1 - Korean
	// 2 - English

	public Student(String name, String iD) {
		super();
		this.name = name;
		ID = iD;
	}

	public Subject getSubject(SubjectType type) {
		switch (type) {
		case MATH:
			return subjects[0];
		case KOREAN:
			return subjects[1];
		case ENGLISH:
			return subjects[2];
		default:
			return null;
		}
	}

	public void setSubject(Subject subject) {
		switch (subject.getType()) {
		case MATH:
			subjects[0] = subject;
			break;
		case KOREAN:
			subjects[1] = subject;
			break;
		case ENGLISH:
			subjects[2] = subject;
			break;
		default:
			Manager.log("Error in Student.java: Subject specified is not one of 3 defined subjects");
		}
	}

	public String getName() {
		return name;
	}

	public String getID() {
		return ID;
	}

	public void setName(String name) {
		this.name = name;
	}
}
