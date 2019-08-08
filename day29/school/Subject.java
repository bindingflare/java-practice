package day26.school;

public class Subject {
	private String name;
	private String ID;
	
	private SubjectType type;

	public Subject(String name, String ID, SubjectType type) {
		super();
		this.name = name;
		this.ID = ID;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getID() {
		return ID;
	}

	public void info() {
		StdManager.output("Name:\t" + getName());
		StdManager.output("ID:\t" + getID());
	}
	
	public SubjectType getType() {
		return type;
	}
}
