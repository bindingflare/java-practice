package day26.school;

import java.util.ArrayList;
import java.util.List;

public class Student implements Cloneable {
	private String name;
	private String ID;

	private List<EnrolledSubject> subjects = new ArrayList<>();

	// 0 - Math
	// 1 - Korean
	// 2 - English

	public Student(String name, String ID) {
		this.name = name;
		this.ID = ID;
	}

	public void info() {
		StdManager.output("Student name:\t" + getName());
		StdManager.output("Student ID:\t" + getID());

		StdManager.outputEmpty();
		StdManager.output("Subjects_");

		for (Subject subject : subjects) {
			subject.info();
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
			StdManager.outputLog("Error! For student name " + getName() + " and ID " + getID() + ": Subject with ID "
					+ ID + " and score " + score + " was not added due to invalid ID");
			return false;
		}

		// Check for duplicate ID's first
		int hits = 0;

		for (Subject existingSubject : subjects) {
			if (existingSubject.getID().equals(ID)) {
				hits++;
			}
		}

		if (hits != 0) {
			StdManager.outputLog("Error! Found " + hits + " instances of enrolled subject which have the same ID");
			return false;
		}

		subjects.add(new EnrolledSubject(SubjectList.getSubject(ID), score));

		return true;
	}

	public void removeSubject(String ID) {
		for (int i = 0; i < subjects.size(); i++) {
			if (subjects.get(i).getID().equals(ID)) {
				subjects.remove(i);
			}
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

	public int getScore(Subject subject) {
		for (EnrolledSubject subject2 : subjects) {
			if (subject.getID().equals(subject2.getID())) {
				return subject2.getScore();
			}
		}

		return -1;
	}

	public EnrolledSubject[] getSubjects() {
		EnrolledSubject[] list = new EnrolledSubject[subjects.size()];

		for (int i = 0; i < subjects.size(); i++) {
			list[i] = subjects.get(i);
		}

		return list;
	}

	public List<String> getSubjectIDs() {
		List<String> subjectsD = new ArrayList<>();

		for (int i = 0; i < subjects.size(); i++) {
			subjectsD.add(subjects.get(i).getID());
		}

		return subjectsD;
	}

	@Override
	protected Student clone() {
		try {
			return (Student) super.clone();
		} catch (CloneNotSupportedException e) {
			StdManager.outputLog(
					"Error! Student with ID + " + getID() + " and name " + getName() + " could not be cloned");
		}

		return null;
	}
}
