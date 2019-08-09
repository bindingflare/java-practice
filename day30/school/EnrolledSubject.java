package day26.school;

public class EnrolledSubject extends Subject {
	private int score;

	public EnrolledSubject(String name, String ID, SubjectType type, int score) {
		super(name, ID, type);
		this.score = score;
	}

	public EnrolledSubject(Subject subject, int score) {
		this(subject.getName(), subject.getID(), subject.getType(), score);
	}

	public void info() {
		StdManager.output("Name:\t" + getName());
		StdManager.output("ID:\t" + getID() + "\tScore: " + getScore());
	}

	public int getScore() {
		return score;
	}
}
