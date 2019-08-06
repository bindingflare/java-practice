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
		Manager.output("Name: " + getName());
		Manager.output("ID: " + getID() + "\tScore: " + getScore());
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
