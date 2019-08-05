package day26.school.subject;

import day26.school.Subject;
import day26.school.SubjectType;

public abstract class Math extends Subject {
	private final SubjectType type = SubjectType.MATH;

	public Math(int score) {
		super(score);
	}

	@Override
	public String getName() {
		return "Mathematics";
	}

	@Override
	public String getID() {
		return "S-MAT";
	}

	public SubjectType getType() {
		return type;
	}
}
