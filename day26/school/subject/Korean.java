package day26.school.subject;

import day26.school.Subject;
import day26.school.SubjectType;

public class Korean extends Subject {
	private final SubjectType type = SubjectType.KOREAN;

	public Korean(int score) {
		super(score);
	}

	@Override
	public String getName() {
		return "Korean";
	}

	@Override
	public String getID() {
		return "S-KOR";
	}

	public SubjectType getType() {
		return type;
	}
}
