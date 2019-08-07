package day26.school;

import java.util.ArrayList;
import java.util.List;

public class Student implements Cloneable{
	private String name;
	private String ID;

	private EnrolledSubject[] subjects = new EnrolledSubject[StdManager.MAX_SUBJECTS];

	private int currentSubjectSlot = 0;
	// 0 - Math
	// 1 - Korean
	// 2 - English

	public Student(String name, String ID, EnrolledSubject[] subjects) {
		super();
		this.name = name;
		this.ID = ID;

		if (subjects != null) {
			for (EnrolledSubject subject : subjects) {
				this.subjects[currentSubjectSlot] = subject;
				currentSubjectSlot++;
			}
		}

	}

	public Student(String name, String ID) {
		this(name, ID, null);
	}

	public void info() {
		StdManager.output("Student name:\t" + getName());
		StdManager.output("Student ID:\t" + getID());

		StdManager.output("");
		StdManager.output("Subjects_");

		for (Subject subject : subjects) {
			if (subject != null) {
				subject.info();
			}
		}
	}

	public List<EnrolledSubject> getSubjectOfType(SubjectType type) {
		List<EnrolledSubject> subjects = new ArrayList<>();

		for (EnrolledSubject subject : subjects) {
			if (subject.getType() == type) {
				subjects.add(subject);
			}
		}

		return subjects;
	}

	public boolean addSubject(String ID, int score) {
		// Check if ID exists in Subject list
		if (!SubjectList.has(ID)) {
			StdManager.log("Error! For student name " + getName() + " and ID " + getID() + ": Subject with ID " + ID + " and score " + score + " was not added due to invalid ID");
			return false;
		}

		// Check for duplicate ID's first
		int hits = 0;

		for (Subject existingSubject : subjects) {
			if (existingSubject == null) {
				continue;
			}

			if (existingSubject.getID().equals(ID)) {
				hits++;
			}
		}

		if (hits != 0) {
			StdManager.log("Error! Found " + hits + " instances of enrolled subject which have the same ID");
			return false;
		}

		if (currentSubjectSlot == StdManager.MAX_SUBJECTS - 1) {
			StdManager.log("Error! Max subject slots reached for this student");
			return false;
		}

		subjects[currentSubjectSlot] = new EnrolledSubject(SubjectList.getSubject(ID), score);
		currentSubjectSlot++;

		return true;
	}

	public void removeSubject(String ID) {
		for (int i = 0; i < subjects.length; i++) {
			if (subjects[i].getID().equals(ID)) {
				subjects[i] = null;

				// Shift array after index i down by 1
				for (int j = i; j < subjects.length - 1; j++) {
					subjects[j] = subjects[j + 1];
				}

				currentSubjectSlot--;
			}
		}
	}

//	@Deprecated
//	public void setSubject(EnrolledSubject subject) {
//		switch (subject.getType()) {
//		case MATH:
//			subjects[0] = subject;
//			break;
//		case KOREAN:
//			subjects[1] = subject;
//			break;
//		case ENGLISH:
//			subjects[2] = subject;
//			break;
//		default:
//			StdManager.log("Error in Student.java: Subject specified is not one of 3 defined subjects");
//		}
//	}

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
	
	public int getScore(Subject subject) {
		for(EnrolledSubject subject2 : subjects) {
			if(subject.getID().equals(subject2)) {
				return subject2.getScore();
			}
		}
		
		return -1;
	}

//	@Deprecated
//	public void setScore(int score, Subject subject) {
//		setSubject(new EnrolledSubject(subject, score));
//	}

	public Subject[] getSubjects() {
		Subject[] subjectsD = new Subject[subjects.length];

		for (int i = 0; i < subjects.length; i++) {
			subjectsD[i] = subjects[i];
		}

		return subjectsD;
	}

	@Override
	protected Student clone() {
		try {
			return (Student) super.clone();
		} catch (CloneNotSupportedException e) {
			StdManager.log("Error! Student with ID + " + getID() + " and name " + getName() + " could not be cloned");
		}
		
		return null;
	}
}
