package day26.school;

public abstract class Subject {
	private int score;

	public Subject(int score) {
		super();
		this.score = score;
	}

	public abstract String getName();

	public abstract String getID();

	public abstract SubjectType getType();

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
