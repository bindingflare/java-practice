package day26.school.subject;

import day26.school.Subject;
import day26.school.SubjectType;

public class English extends Subject {
	private final SubjectType type = SubjectType.ENGLISH;

	public English(int score) {
		super(score);
	}

	@Override
	public String getName() {
		return "English";
	}

	@Override
	public String getID() {
		return "S-ENG";
	}

	public SubjectType getType() {
		return type;
	}
}
