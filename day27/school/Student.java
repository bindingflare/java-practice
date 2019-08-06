package day26.school;

public class Student {
	private String name;
	private String ID;

	private EnrolledSubject[] subjects = new EnrolledSubject[3];
	// 0 - Math
	// 1 - Korean
	// 2 - English

	public Student(String name, String ID) {
		super();
		this.name = name;
		this.ID = ID;
	}
	
	public void info() {
		Manager.output("====");
		Manager.output("Student name: " + getName());
		Manager.output("Student ID: " + getID());
		Manager.output("");
		
		Manager.output("Subjects:");
		Manager.output("");
		
		for(Subject subject : subjects) {
			subject.info();
		}
	}

	public EnrolledSubject getSubject(SubjectType type) {
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

	public void setSubject(EnrolledSubject subject) {
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

	public void setID(String iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score, Subject subject) {
		setSubject(new EnrolledSubject(subject, score));
	}
	
	public Subject[] getSubjects() {
		Subject[] subjectsD = new Subject[subjects.length];
		
		for(int i = 0; i < subjects.length; i++) {
			subjectsD[i] = subjects[i];
		}
		
		return subjectsD;
	}
}
